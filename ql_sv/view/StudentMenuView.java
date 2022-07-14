package ql_sv.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMenuView {
    static Scanner input = new Scanner(System.in);
    static  StudentView studentView = new StudentView();


    public static void showMenu() {
        System.out.println("----------------- MENU STUDENT ------------------");
        System.out.println("|   1. Xem danh sách sinh viên                  |");
        System.out.println("|   2. Thêm sinh viên                           |");
        System.out.println("|   3. Cập nhật sinh viên                       |");
        System.out.println("|   4. Xóa sinh viên                            |");
        System.out.println("|   5. Sort By Score ASC                        |");
        System.out.println("|   6. Sort By Score DESC                       |");
        System.out.println("|   7. Exit                                     |");
        System.out.println("------------------------------------------------");

    }

    public static void run() {
        int choice;
        do {
            showMenu();
            try {
                System.out.println("Nhập chức năng:  ");
                System.out.println(" ⭆");
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        studentView.showStudentsList();
                        break;
                    case 2 :
                        studentView.addStudent();
                        break;
                    case 3 :
                        studentView.update();
                        break;
                    case 4 :
                        studentView.remove();
                        break;
                    case 5:
                        studentView.sortByScoreASC();
                        break;
                    case 6:
                        studentView.sortByScoreDES();
                        break;
                    case 7:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Sai chức năng. Nhập lại!");
                }

            } catch (InputMismatchException io) {
                System.out.println("Nhập sai! Nhập lại.");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
