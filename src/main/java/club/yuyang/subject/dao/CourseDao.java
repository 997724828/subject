package club.yuyang.subject.dao;

import club.yuyang.subject.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 0:45
 */
@Mapper
public interface CourseDao {
    Course getCourseById(Integer courseId);

    List<Course> getAllCourse(@Param("instituteId") Integer instituteId);
}
