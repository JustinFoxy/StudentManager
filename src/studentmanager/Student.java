package studentmanager;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //因为使用的是私有的类，所以说你要获取他只能用get方法
    public String getName() {
        return name;
    }
    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "学生姓名:"+ name+",年龄:"+age;
    }
}
