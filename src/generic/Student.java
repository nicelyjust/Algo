package generic;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/11/13 15:24
 **/
public class Student extends Person {
    public String rank;

    public Student(String name, int age,String rank) {
        super(name, age);
        this.rank = rank;
    }
}
