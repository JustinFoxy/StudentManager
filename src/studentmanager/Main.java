package studentmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("\n欢迎使用学生管理系统");
            System.out.println("1.添加学生");
            System.out.println("2.显示所有学生");
            System.out.println("3.退出系统");
            System.out.print("请输入你的选择：");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1) {
                System.out.println("请输入学生的姓名：");
                String name = scanner.nextLine();
                System.out.println("请输入学生的年龄：");
                int age = scanner.nextInt();
                manager.addStudent(name, age);
            }else if(choice == 2) {
                manager.showAllStudents();
            }else if(choice == 3) {
                System.out.println("退出成功");
                break;
            }else{
                System.out.println("无效的选项，请重新输入！");
            }
        }
        scanner.close();
    }
}
