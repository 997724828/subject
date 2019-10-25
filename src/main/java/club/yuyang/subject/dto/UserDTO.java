package club.yuyang.subject.dto;


import club.yuyang.subject.entity.User;

/**
 * @author yuyang
 * @date 2019/9/19 15:46
 */
public class UserDTO extends User {

    private String instituteName;
    private String classmateName;


    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getClassmateName() {
        return classmateName;
    }

    public void setClassmateName(String classmateName) {
        this.classmateName = classmateName;
    }
}
