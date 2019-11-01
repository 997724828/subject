package club.yuyang.subject.service;

import club.yuyang.subject.entity.ClassmateCourse;
import club.yuyang.subject.entity.SelectCourse;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 1:08
 */
public interface SelectCourseService {
    List<SelectCourse> getPersonCourse(String account);

    SelectCourse isExitCourse(SelectCourse selectCourse);

    //添加蹭的课程
    void insertSelectCourse(SelectCourse selectCourse);

    //删除课程
    boolean delSelectCourseById(Integer id);
}
