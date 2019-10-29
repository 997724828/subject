package club.yuyang.subject.dto;

/**
 * @author yuyang
 * @date 2019/10/24 22:55
 */
public class ClassmateCourseDTO {
    private Integer id;
    private Integer courseId;
    private String courseName;
    private Integer classmateId;
    private String classmateName;
    private String teacher;
    private String address;
    private int times;
    private String weekName;//显示星期几，原来的times字段只是个数字
    private String sections;
    private String types;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getClassmateId() {
        return classmateId;
    }

    public void setClassmateId(Integer classmateId) {
        this.classmateId = classmateId;
    }

    public String getClassmateName() {
        return classmateName;
    }

    public void setClassmateName(String classmateName) {
        this.classmateName = classmateName;
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

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
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
