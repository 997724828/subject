package club.yuyang.subject.serviceImpl;

import club.yuyang.subject.dao.SelectCourseDao;
import club.yuyang.subject.entity.SelectCourse;
import club.yuyang.subject.service.SelectCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 1:12
 */
@Service
@Transactional
public class SelectCourseServiceImpl implements SelectCourseService {
    @Resource
    SelectCourseDao selectCourseDao;

    @Override
    public List<SelectCourse> getPersonCourse(String account) {
        return selectCourseDao.getPersonCourse(account);
    }

    @Override
    public SelectCourse isExitCourse(SelectCourse selectCourse) {
        return selectCourseDao.isExitCourse(selectCourse);
    }

    @Override
    public void insertSelectCourse(SelectCourse selectCourse) {
         selectCourseDao.insertSelectCourse(selectCourse);
    }

    @Override
    public boolean delSelectCourseById(Integer id) {
        int num = selectCourseDao.delSelectCourseById(id);
        return num>0 ? true : false;
    }
}
