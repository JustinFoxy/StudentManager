package studentmanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
    //
    private List<Student> studentList = new ArrayList<Student>();

    //添加学生方法
    public void addStudent(String name,int age) {
        Student student=new Student(name,age);
        studentList.add(student);
        System.out.println("学生添加成功");
    }


    //展示所有学生
    public void showAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("当前没有学生的信息");
        } else {
            System.out.println("现存在如下学生：");
            //遍历studentList
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    //删除学生
    public void deleteStudentByName(String name) {
        //定义默认找不到学生
        boolean found = false;
        //找到了逻辑
        //根据studentList的长度遍历
        for (int i = 0; i < studentList.size(); i++) {
            //遍历中如果找到和需要删除是名字名字相同
            if (studentList.get(i).getName().equals(name)) {
                //移除这个studentList数组下标中的数据
                studentList.remove(i);
                System.out.println("已成功移除名字为 " + name + " 的学生。");
                //删除完后，把find设置成找到了，这样不会触发后面的if判断
                found = true;
                break;
            }
        }
        //找不到
        if (!found) {
            System.out.println("没有找到名字为 " + name + " 的学生。");
        }
    }

    //保存文件(原理是写入文件)
    // 参数 fileName 是要保存的文件名，例如 "students.txt"
    public void saveToFile(String fileName) {
        //写入异常捕捉
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            //遍历studentList
            for (Student s : studentList) {
                //写入文件
                writer.write(s.getName() + "," + s.getAge());  // 用逗号分隔
                writer.newLine(); // 换行
            }
            System.out.println("✅ 学生列表已保存到文件：" + fileName);
        } catch (IOException e) {
            System.out.println("❌ 写入文件失败：" + e.getMessage());
        }
    }

    //实现“程序启动时读取 students_info.txt”（原理是读取文件）
    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    studentList.add(new Student(name, age));
                }
            }
            System.out.println("✅ 成功读取学生数据，共 " + studentList.size() + " 个学生。");
        } catch (IOException e) {
            System.out.println("⚠️ 未能读取文件，可能是第一次使用或文件不存在。");
        }
    }

    //
    public void updateStudentByName(String name, Scanner scanner) {
        boolean found = false;
        for (Student s : studentList) {
            if (s.getName().equals(name)) {
                System.out.print("请输入新的姓名：");
                String newName = scanner.nextLine();
                System.out.print("请输入新的年龄：");
                int newAge = scanner.nextInt();
                scanner.nextLine(); // 吃掉换行

                // 修改数据
                s.setName(newName);
                s.setAge(newAge);

                System.out.println("✅ 修改成功！");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("⚠️ 没有找到名为 " + name + " 的学生！");
        }
    }

}
