package club.yuyang.subject.dto;

/**用于传输课表的用户信息
 * @author yuyang
 * @date 2019/10/14 20:35
 */
public class IdentityDTO {
    private Integer instituteId;
    private Integer classmateId;



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

}
