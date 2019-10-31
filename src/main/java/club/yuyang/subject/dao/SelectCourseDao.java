package club.yuyang.subject.dao;

import club.yuyang.subject.entity.SelectCourse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 1:09
 */
@Mapper
public interface SelectCourseDao {
    List<SelectCourse> getPersonCourse(String account);

    SelectCourse isExitCourse(SelectCourse selectCourse);

    //添加蹭的课程
    void insertSelectCourse(SelectCourse selectCourse);
}
