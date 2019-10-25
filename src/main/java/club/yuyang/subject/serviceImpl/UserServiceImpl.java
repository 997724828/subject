package club.yuyang.subject.serviceImpl;



import club.yuyang.subject.dao.UserDao;
import club.yuyang.subject.dto.UserDTO;
import club.yuyang.subject.entity.User;
import club.yuyang.subject.service.ClassmateService;
import club.yuyang.subject.service.InstituteService;
import club.yuyang.subject.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/9/10 8:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao userDao;
    @Resource
    InstituteService instituteService;
    @Resource
    ClassmateService classmateService;

    @Override
    public UserDTO login(String account,String password) {

        User user = userDao.findByIdAndPaw(account,password);

        if (user == null){
            return null;
        }else {
            Integer instituteId = user.getInstituteId();
            Integer classmateId = user.getClassmateId();
            String instituteName = instituteService.getInstituteName(instituteId);
            String classmateName = classmateService.getClassmateName(classmateId);
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(user, userDTO);
            userDTO.setInstituteName(instituteName);
            userDTO.setClassmateName(classmateName);
            return userDTO;
        }
    }


}
