package studentmanager;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList = new ArrayList<Student>();

    public void addStudent(String name, int age) {
        Student student = new Student(name, age);
        studentList.add(student);
        System.out.println("学生添加成功！");
    }

    public void showAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("当前没有学生的信息");
        } else {
            System.out.println("学生列表：");
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }
}
