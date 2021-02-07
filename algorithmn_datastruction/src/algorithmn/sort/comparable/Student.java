package algorithmn.sort.comparable;

/**
 * 定义一个Student类，有年龄和姓名两个属性，并通过Comparable接口提供比较规则
 */
public class Student implements Comparable<Student>{

    private String username;
    private int age;

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
