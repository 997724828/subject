package club.yuyang.subject.serviceImpl;

import club.yuyang.subject.dao.CourseDao;
import club.yuyang.subject.entity.Course;
import club.yuyang.subject.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/10/25 0:45
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    CourseDao courseDao;

    @Override
    public Course getCourseById(Integer courseId) {

        return courseDao.getCourseById(courseId);
    }
}
