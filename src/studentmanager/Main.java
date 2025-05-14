package studentmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        //在程序的最前面调用：读取txt中的学生数据
        manager.loadFromFile("students_info.txt");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("欢迎使用学生管理系统");
            System.out.println("    0.退出系统");
            System.out.println("    1.添加学生");
            System.out.println("    2.显示所有学生");
            System.out.println("    3.删除学生");
            System.out.println("    4.修改学生");
            System.out.print("请输入你的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("系统退出成功，感谢你的使用");
                    running=false;
                    break;
                case 1:
                    System.out.print("请输入学生的姓名：");
                    String name = scanner.nextLine();
                    System.out.print("请输入学生的年龄：");
                    int age = scanner.nextInt();
                    manager.addStudent(name, age);
                    manager.saveToFile("students_info.txt");
                    break;
                case 2:
                    manager.showAllStudents();
                    break;
                case 3:
                    System.out.print("请输入要删除的学生姓名：");
                    String nameToDelete = scanner.nextLine();
                    manager.deleteStudentByName(nameToDelete);
                    manager.saveToFile("students_info.txt");
                    break;
                case 4:
                    System.out.print("请输入要修改的学生姓名：");
                    String nameToUpdate = scanner.nextLine();
                    manager.updateStudentByName(nameToUpdate, scanner);
                    manager.saveToFile("students_info.txt");  // 记得保存修改
                    break;
                default:
                    System.out.print("无效的选项，请重新输入！");
            }
        }
        scanner.close();
    }
}
