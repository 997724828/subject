package club.yuyang.subject.dao;

import club.yuyang.subject.entity.ClassmateCourse;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/19 16:33
 */
@Mapper
public interface ClassmateCourseDao {

    List<ClassmateCourse> getClassmateCourse(Integer classmateId);

}
