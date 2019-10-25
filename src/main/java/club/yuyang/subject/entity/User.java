package club.yuyang.subject.entity;

/**
 * @author yuyang
 * @date 2019/9/10 8:32
 */
public class User {
    private Integer id;
    private Integer instituteId;//学院
    private Integer classmateId;//班级
    private String account;  //账号
    private String password; //密码
    private String name;     //姓名

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Integer instituteId) {
        this.instituteId = instituteId;
    }

    public Integer getClassmateId() {
        return classmateId;
    }

    public void setClassmateId(Integer classmateId) {
        this.classmateId = classmateId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
