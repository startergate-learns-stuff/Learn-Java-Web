package kr.gsm.model;

public class MemberVO {
    private String id;
    private String pwd;
    private int age;

    public MemberVO() {

    }

    public MemberVO(String id, String pwd, int age) {
        this.id = id;
        this.pwd = pwd;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MemberVO{" +
                "id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }
}

