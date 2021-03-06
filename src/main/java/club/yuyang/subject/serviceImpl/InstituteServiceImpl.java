package club.yuyang.subject.serviceImpl;


import club.yuyang.subject.dao.InstituteDao;
import club.yuyang.subject.entity.Institute;
import club.yuyang.subject.service.InstituteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/9/19 13:06
 */
@Service
public class InstituteServiceImpl implements InstituteService {

    @Resource
    private InstituteDao instituteDao;

    @Override
    public String getInstituteName(Integer instituteId) {
        String instituteName = instituteDao.findNameByInstituteId(instituteId);
        return instituteName;
    }

    @Override
    public List<Institute> getAllInstitutes() {
        return instituteDao.getAllInstitutes();
    }

    @Override
    public int deleteOne(Integer instituteId) {
       return instituteDao.deleteOne(instituteId);
    }
}
