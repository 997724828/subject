package club.yuyang.subject.dao;


import club.yuyang.subject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuyang
 * @date 2019/9/10 8:22
 */
@Mapper
public interface UserDao {

    //    登录模块
    User findByIdAndPaw(@Param("account") String account, @Param("password") String password);

    //    修改密码模块
    int updatePaw(@Param("account") String account, @Param("password") String password);

}
