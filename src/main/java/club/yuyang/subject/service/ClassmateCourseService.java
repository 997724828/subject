package club.yuyang.subject.service;

import club.yuyang.subject.entity.ClassmateCourse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 0:28
 */
public interface ClassmateCourseService{
    List<ClassmateCourse> getClassmateCourse(Integer classmateId);

    List<ClassmateCourse> getRubCourse(Integer courseId);//获得想要蹭课的课程信息

    ClassmateCourse getClassmateCourseById(Integer id);

    //判断是否与现在课程冲突
    ClassmateCourse isExitCourse(ClassmateCourse classmateCourse);
}
