package improve.reflection;

/**
 * @Desc
 * @Author lizeng
 * @CreateTime 2019/12/4 18:07
 **/
public class Father {
    private String fatherName;
    private int fatherAge;
    public long money;

    public Father() {
    }

    public Father(String fatherName, int fatherAge) {
        this.fatherName = fatherName;
        this.fatherAge = fatherAge;
    }

    private String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(int fatherAge) {
        this.fatherAge = fatherAge;
    }
}
