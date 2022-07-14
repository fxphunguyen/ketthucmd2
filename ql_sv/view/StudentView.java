package ql_sv.view;

import ql_sv.model.Student;
import ql_sv.sevice.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentView {
    private final StudentService studentService;
    private final Scanner input = new Scanner(System.in);

    public StudentView() {
        studentService = StudentService.getInstance();
    }

    public void showStudentsList() {
        System.out.println("---------------------------------- STUDENT LIST---------------------------------------- \n");
        System.out.printf("%-15s %-20s %-12s %-12s %-12s %-15s \n", "ID", "Full Name", "Age", "Gender", "Address", "Average Score");
        System.out.println("---------------------------------------------------------------------------------------");
        for (Student student : studentService.findAll()) {
            System.out.printf("%-15s %-20s %-12s %-12s %-12s %-15s \n", student.getId(), student.getFullName(), student.getAge(), student.getGender(), student.getAddress(), student.getAverageScore());
        }
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println();

    }

    public void showSortStudent(List<Student> students) {
        System.out.println("---------------------------------- STUDENT SORT LIST------------------------------------- \n");
        System.out.printf("%-15s %-20s %-12s %-12s %-12s %-15s \n", "ID", "Full Name", "Age", "Gender", "Address", "Average Score");
        System.out.println("-----------------------------------------------------------------------------------------");
        for (Student student : students) {
            System.out.printf("%-15s %-20s %-12s %-12s %-12s %-15s \n", student.getId(), student.getFullName(), student.getAge(), student.getGender(), student.getAddress(), student.getAverageScore());
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println();
    }

    public void sortByScoreASC() {
        showSortStudent(studentService.sortByScoreASC());
    }

    public void sortByScoreDES() {
        showSortStudent(studentService.sortByScoreDES());
    }

    public void addStudent() {
        studentService.findAll();
        try {

            System.out.println("Nhập tên sinh viên: ");
            String fullName = input.nextLine();
            while (fullName.trim().equals("")) {
                fullName = input.nextLine();
            }

            System.out.println("Nhập tuổi sinh viên ");
            int age = Integer.parseInt(input.nextLine());
            while (age <= 0) {
                System.out.println("Tuổi phải lớn hơn 0!. ");
                age = input.nextInt();
            }

            System.out.println("Giới tính");
            String gender = input.nextLine();

            System.out.println("Địa chỉ: ");
            String address = input.nextLine();

            System.out.println("Nhập điểm trung bình: ");
            double averageScore = Double.parseDouble(input.nextLine());
            while (averageScore <= 0.0) {
                System.out.println("Điểm trung bình phải lớn hơn 0. ");
                averageScore = input.nextDouble();
            }

            studentService.add(new Student(fullName, age, gender, address, averageScore));
            System.out.println("Thêm sinh viên thành công.");

        } catch (Exception e) {
            System.out.println("Nhập sai! Nhập lại.");
            e.printStackTrace();
        }
    }

    public void update() {

        studentService.findAll();
        System.out.println("Search by ID: ");
        int id = Integer.parseInt(input.nextLine());
        Student student = studentService.findById(id);
        if (studentService.checkDuplicateId(id)) {

            System.out.println("------  EDIT INFO  ------");
            System.out.println("|   1. Sửa tên            |");
            System.out.println("|   2. Sửa tuổi           |");
            System.out.println("|   3. Sửa giới tính      |");
            System.out.println("|   4. Sửa địa chỉ        |");
            System.out.println("|   5. Sửa điểm TB        |");
            System.out.println("---------------------------");
            System.out.println("Nhập chức năng cần sửa: ");
            int choice = input.nextInt();
            input.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Cập nhật tên sinh viên: ");
                        String fullName = input.nextLine();
                        student.setFullName(fullName);
                        studentService.update(student);
                        System.out.println("Cập nhật tên thành công");
                        break;

                    case 2:
                        System.out.println("Cập nhật tuổi sinh viên: ");
                        int age = input.nextInt();
                        student.setAge(age);
                        studentService.update(student);
                        System.out.println("Cập nhật tuổi thành công");
                        break;

                    case 3:
                        System.out.println("Cập nhật giới tính: ");
                        String gender = input.nextLine();
                        student.setGender(gender);
                        studentService.update(student);
                        System.out.println("Cập nhật thành công");
                        break;

                    case 4:
                        System.out.println("Cập nhật địa chi");
                        String address = input.nextLine();
                        student.setAddress(address);
                        studentService.update(student);
                        System.out.println("Cập nhật thành công");
                        break;

                    case 5:
                        System.out.println("Cập nhật điểm trung bình");
                        double avrscore = input.nextDouble();
                        student.setAverageScore(avrscore);
                        studentService.update(student);
                        System.out.println("Cập nhật thành công");
                        break;
                    default:
                        System.out.println("Sai chức năng! Nhập lại .");
                        update();
                }
            } catch (Exception e) {
                System.out.println("Sai chức năng! Nhập lại.");
                e.printStackTrace();
            }
        }
    }


    public void remove() {
        studentService.findAll();
        System.out.println("Nhập id sinh viên cần xóa.");
        int id = input.nextInt();
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Id không tồn tại!");
        } else {
            boolean check = true;
            System.out.println("------------REMOVE CONFIRM-----------");
            System.out.println("        1. Chọn 1 để xóa ");
            System.out.println("        2. Quay lại menu");
            System.out.println("--------------------------------------");
            int choice1 = input.nextInt();
            input.nextLine();
            try {
                switch (choice1) {
                    case 1:
                        studentService.removeById(id);
                        System.out.println("Xóa thành công");
                        do {
                            System.out.println("Input 'y' to comeback menu Product | 'n' to exit ");
                            String choice2 = input.nextLine();
                            switch (choice2) {
                                case "y":
                                    StudentMenuView.run();
                                    break;
                                case "n":
                                    System.exit(0);
                                    break;
                                default:
                                    System.out.println("Nhập sai! Nhập lại.");
                                    check = false;
                            }
                        } while (!check);
                        break;
                    case 2:
                        StudentMenuView.run();
                        break;
                    default:
                        System.out.println("Nhập sai! Nhập lại.");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
