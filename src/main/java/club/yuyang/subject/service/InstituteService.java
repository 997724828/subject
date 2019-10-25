package club.yuyang.subject.service;


import club.yuyang.subject.entity.Institute;


import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/19 12:53
 */
public interface InstituteService {

    //    3.1 根据学院Id锁定学院名称
    String getInstituteName(Integer instituteId);

    //    3.2 获得所有学院信息
    List<Institute> getAllInstitutes();

    //    3.3 删除一个学院信息
    int deleteOne(Integer instituteId);
}
