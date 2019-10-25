package club.yuyang.subject.dao;

import club.yuyang.subject.entity.Institute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/19 12:49
 */
@Mapper
public interface InstituteDao {

    //通过学院Id查找学院名称
    String findNameByInstituteId(@Param("instituteId") Integer instituteId);

    //获得所有学院信息
    List<Institute> getAllInstitutes();

    //删除一个学院信息
    int deleteOne(@Param("instituteId") Integer instituteId);
}
