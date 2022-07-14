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

            System.out.println("Input name student: ");
            String fullName = input.nextLine();
            while (fullName.trim().equals("")) {
                fullName = input.nextLine();
            }

            System.out.println("Input age student ");
            int age = Integer.parseInt(input.nextLine());
            while (age <= 0) {
                System.out.println("Wrong Input. Age > 0. Try again. ");
                age = input.nextInt();
            }

            System.out.println("Input gender student");
            String gender = input.nextLine();

            System.out.println("Input address: ");
            String address = input.nextLine();

            System.out.println("Input Average Score");
            double averageScore = Double.parseDouble(input.nextLine());
            while (averageScore <= 0.0) {
                System.out.println("AVR Score > 0. Input again. ");
                averageScore = input.nextDouble();
            }

            studentService.add(new Student(fullName, age, gender, address, averageScore));
            System.out.println("ADD STUDENT SUCCESSFULLY.");

        } catch (Exception e) {
            System.out.println("Wrong Input! Try again.");
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
            System.out.println("|   1. Edit name        |");
            System.out.println("|   2. Edit age         |");
            System.out.println("|   3. Edit gender      |");
            System.out.println("|   4. Edit address     |");
            System.out.println("|   5. Edit AVR Score   |");
            System.out.println("------------------------");
            System.out.println("Input number to edit product");
            int choice = input.nextInt();
            input.nextLine();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Edit name student: ");
                        String fullName = input.nextLine();
                        student.setFullName(fullName);
                        studentService.update(student);
                        System.out.println("Successfully updated name");
                        break;

                    case 2:
                        System.out.println("Edit age student: ");
                        int age = input.nextInt();
                        student.setAge(age);
                        studentService.update(student);
                        System.out.println("Successfully updated age");
                        break;

                    case 3:
                        System.out.println("Edit Gender student");
                        String gender = input.nextLine();
                        student.setGender(gender);
                        studentService.update(student);
                        System.out.println("Successfully updated Gender");
                        break;

                    case 4:
                        System.out.println("Edit Address student");
                        String address = input.nextLine();
                        student.setAddress(address);
                        studentService.update(student);
                        System.out.println("Successfully updated Address");
                        break;

                    case 5:
                        System.out.println("Edit AVR Score student");
                        double avrscore = input.nextDouble();
                        student.setAverageScore(avrscore);
                        studentService.update(student);
                        System.out.println("Successfully updated AVRScore");
                        break;
                    default:
                        System.out.println("Wrong choice ! Try again .");
                        update();
                }
            } catch (Exception e) {
                System.out.println("Wrong input! Try again.");
                e.printStackTrace();
            }
        }
    }


    public void remove() {
        studentService.findAll();
        System.out.println("Input Id Product that you want to remove.");
        int id = input.nextInt();
        Student student = studentService.findById(id);
        if (student == null) {
            System.out.println("This ID not exist");
        } else {
            boolean check = true;
            System.out.println("------------REMOVE CONFIRM-----------");
            System.out.println("        1. Input 1 to remove ");
            System.out.println("        2. Back to Menu");
            System.out.println("--------------------------------------");
            int choice1 = input.nextInt();
            input.nextLine();
            try {
                switch (choice1) {
                    case 1:
                        studentService.removeById(id);
                        System.out.println("Item removed successfully");
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
                                    System.out.println("Wrong input. Try again.");
                                    check = false;
                            }
                        } while (!check);
                        break;
                    case 2:
                        StudentMenuView.run();
                        break;
                    default:
                        System.out.println("Wrong input. Try again.");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
