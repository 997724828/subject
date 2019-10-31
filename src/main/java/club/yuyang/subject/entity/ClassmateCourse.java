package club.yuyang.subject.entity;

/**
 * @author yuyang
 * @date 2019/10/24 22:34
 */
public class ClassmateCourse {
    private Integer id;
    private Integer courseId;
    private Integer instituteId;
    private Integer classmateId;
    private String teacher;
    private String address;
    private int times;
    private String sections;
    private String types;



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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getClassmateId() {
        return classmateId;
    }

    public void setClassmateId(Integer classmateId) {
        this.classmateId = classmateId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public String getSections() {
        return sections;
    }

    public void setSections(String sections) {
        this.sections = sections;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }
}
