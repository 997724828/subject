package club.yuyang.subject.serviceImpl;

import club.yuyang.subject.dao.SelectCourseDao;
import club.yuyang.subject.entity.SelectCourse;
import club.yuyang.subject.service.SelectCourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 1:12
 */
@Service
public class SelectCourseServiceImpl implements SelectCourseService {
    @Resource
    SelectCourseDao personCourseDao;

    @Override
    public List<SelectCourse> getPersonCourse(String account) {
        return personCourseDao.getPersonCourse(account);
    }
}
