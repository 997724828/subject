package club.yuyang.subject.service;

import club.yuyang.subject.entity.Course;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 0:45
 */
public interface CourseService {
    Course getCourseById(Integer courseId);

    //通过学院ID查找该学院的所有课程信息
    List<Course> getAllCourse(Integer instituteId);
}
