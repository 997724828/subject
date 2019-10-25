package club.yuyang.subject.service;

import club.yuyang.subject.entity.SelectCourse;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 1:08
 */
public interface SelectCourseService {
    List<SelectCourse> getPersonCourse(String account);
}
