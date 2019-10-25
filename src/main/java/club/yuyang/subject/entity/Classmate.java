package club.yuyang.subject.entity;

/**
 * @author yuyang
 * @date 2019/9/19 16:20
 */
public class Classmate {

    private Integer instituteId;
    private Integer classmateId;
    private Integer classmateName;

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

    public Integer getClassmateName() {
        return classmateName;
    }

    public void setClassmateName(Integer classmateName) {
        this.classmateName = classmateName;
    }
}
