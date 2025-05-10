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

    //添加删除学生
    public void deleteStudentByName(String name) {
        boolean found = false;
        for(int i=0; i<studentList.size(); i++) {
            if(studentList.get(i).getName().equals(name)) {
                studentList.remove(i);
                System.out.println("已成功移除名字为 "+name+" 的学生。");
                found = true;
                break;
            }
        }if(!found) {
            System.out.println("没有找到名字为 "+name+" 的学生。");
        }
    }


}
