package studentmanager;

public class Student {
    //名字和年龄
    private String name;
    private int age;

    //构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //因为使用的是私有的类，所以说你要获取他只能用get方法
    //获取名字
    public String getName() {
        return name;
    }
    //获取年龄
    public int getAge(){
        return age;
    }

    //修改名字
    public void setName(String name) {
        this.name = name;
    }
    //修改年龄
    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "学生姓名:"+ name+", 年龄:"+age;
    }
}
