package club.yuyang.subject.serviceImpl;

import club.yuyang.subject.dao.ClassmateCourseDao;
import club.yuyang.subject.entity.ClassmateCourse;
import club.yuyang.subject.service.ClassmateCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 0:34
 */
@Service
public class ClassmateCourseServiceImpl implements ClassmateCourseService {
    @Resource
    ClassmateCourseDao classmateCourseDao;

    @Override
    public List<ClassmateCourse> getClassmateCourse(Integer classmateId) {
        return classmateCourseDao.getClassmateCourse(classmateId);
    }
}
