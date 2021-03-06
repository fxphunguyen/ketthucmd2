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

            System.out.println("Nh???p t??n sinh vi??n: ");
            String fullName = input.nextLine();
            while (fullName.trim().equals("")) {
                fullName = input.nextLine();
            }

            System.out.println("Nh???p tu???i sinh vi??n ");
            int age = Integer.parseInt(input.nextLine());
            while (age <= 0) {
                System.out.println("Tu???i ph???i l???n h??n 0!. ");
                age = input.nextInt();
            }

            System.out.println("Gi???i t??nh");
            String gender = input.nextLine();

            System.out.println("?????a ch???: ");
            String address = input.nextLine();

            System.out.println("Nh???p ??i???m trung b??nh: ");
            double averageScore = Double.parseDouble(input.nextLine());
            while (averageScore <= 0.0) {
                System.out.println("??i???m trung b??nh ph???i l???n h??n 0. ");
                averageScore = input.nextDouble();
            }

            studentService.add(new Student(fullName, age, gender, address, averageScore));
            System.out.println("Th??m sinh vi??n th??nh c??ng.");

        } catch (Exception e) {
            System.out.println("Nh???p sai! Nh???p l???i.");
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
            System.out.println("|   1. S???a t??n            |");
            System.out.println("|   2. S???a tu???i           |");
            System.out.println("|   3. S???a gi???i t??nh      |");
            System.out.println("|   4. S???a ?????a ch???        |");
            System.out.println("|   5. S???a ??i???m TB        |");
            System.out.println("---------------------------");
            System.out.println("Nh???p ch???c n??ng c???n s???a: ");
            int choice = input.nextInt();
            input.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("C???p nh???t t??n sinh vi??n: ");
                        String fullName = input.nextLine();
                        student.setFullName(fullName);
                        studentService.update(student);
                        System.out.println("C???p nh???t t??n th??nh c??ng");
                        break;

                    case 2:
                        System.out.println("C???p nh???t tu???i sinh vi??n: ");
                        int age = input.nextInt();
                        student.setAge(age);
                        studentService.update(student);
                        System.out.println("C???p nh???t tu???i th??nh c??ng");
                        break;

                    case 3:
                        System.out.println("C???p nh???t gi???i t??nh: ");
                        String gender = input.nextLine();
                        student.setGender(gender);
                        studentService.update(student);
                        System.out.println("C???p nh???t th??nh c??ng");
                        break;

                    case 4:
                        System.out.println("C???p nh???t ?????a chi");
                        String address = input.nextLine();
                        student.setAddress(address);
                        studentService.update(student);
                        System.out.println("C???p nh???t th??nh c??ng");
                        break;

                    case 5:
                        System.out.println("C???p nh???t ??i???m trung b??nh");
                        double avrscore = input.nextDouble();
                        student.setAverageScore(avrscore);
                        studentService.update(student);
                        System.out.println("C???p nh???t th??nh c??ng");
                        break;
                    default:
                        System.out.println("Sai ch???c n??ng! Nh???p l???i .");
                        update();
                }
            } catch (Exception e) {
                System.out.println("Sai ch???c n??ng! Nh???p l???i.");
                e.printStackTrace();
            }
        }
    }


    public void remove() {
        studentService.findAll();
        System.out.println("Nh???p id sinh vi??n c???n x??a.");
        int id = input.nextInt();
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("Id kh??ng t???n t???i!");
        } else {
            boolean check = true;
            System.out.println("------------REMOVE CONFIRM-----------");
            System.out.println("        1. Ch???n 1 ????? x??a ");
            System.out.println("        2. Quay l???i menu");
            System.out.println("--------------------------------------");
            int choice1 = input.nextInt();
            input.nextLine();
            try {
                switch (choice1) {
                    case 1:
                        studentService.removeById(id);
                        System.out.println("X??a th??nh c??ng");
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
                                    System.out.println("Nh???p sai! Nh???p l???i.");
                                    check = false;
                            }
                        } while (!check);
                        break;
                    case 2:
                        StudentMenuView.run();
                        break;
                    default:
                        System.out.println("Nh???p sai! Nh???p l???i.");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
