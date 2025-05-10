package studentmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("欢迎使用学生管理系统");
            System.out.println("    0.退出系统");
            System.out.println("    1.添加学生");
            System.out.println("    2.显示所有学生");
            System.out.println("    3.删除学生");
            System.out.print("请输入你的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("系统退出成功，感谢你的使用");
                    running=false;
                    break;
                case 1:
                    System.out.println("请输入学生的姓名：");
                    String name = scanner.nextLine();
                    System.out.println("请输入学生的年龄：");
                    int age = scanner.nextInt();
                    manager.addStudent(name, age);
                    break;
                case 2:
                    manager.showAllStudents();
                    break;
                case 3:
                    System.out.println("请输入要删除的学生姓名：");
                    String nameToDelete = scanner.nextLine();
                    manager.deleteStudentByName(nameToDelete);
                    break;
                default:
                    System.out.println("无效的选项，请重新输入！");
            }
        }
        scanner.close();
    }
}
