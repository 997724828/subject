package club.yuyang.subject.service;


import club.yuyang.subject.dto.UserDTO;

/**
 * @author yuyang
 * @date 2019/9/10 8:42
 */
public interface UserService {

    //   1.1 登录模块
    UserDTO login(String account, String password);

}
