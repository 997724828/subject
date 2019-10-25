package club.yuyang.subject.serviceImpl;


import club.yuyang.subject.dao.ClassmateDao;
import club.yuyang.subject.service.ClassmateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/9/19 16:38
 */
@Service
public class ClassmateServiceImpl implements ClassmateService {
    @Resource
    ClassmateDao classmateDao;

    @Override
    public String getClassmateName(Integer classmateId) {
        String classmateName = classmateDao.findNameByClassmateId(classmateId);
        return classmateName;
    }

    
}
