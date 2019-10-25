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
}
