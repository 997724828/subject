package club.yuyang.subject.controller;


import club.yuyang.subject.dto.UserDTO;
import club.yuyang.subject.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author yuyang
 * @date 2019/9/8 9:00
 */
@Controller
public class IndexController {
    @Resource
    UserService userService;

//  跳转后台界面
    @RequestMapping("/admin")
    public String toAdmin(){
        return "admin";
    }

//  跳转首页
    @RequestMapping("/")
    public String login(HttpServletRequest request){
       request.setAttribute("message","欢迎使用NJIT课程管理系统");
        return "login";
    }

//    验证登录
    @PostMapping("/index")
    public String checkLogin(@RequestParam("account")String account,
                             @RequestParam("password")String password,
                             HttpServletRequest request){

       UserDTO responseUser = userService.login(account,password);

        if (responseUser == null){
            //登录失败
            request.setAttribute("message","sorry登录失败，账号密码错误！");
            return "/login";
        }else {
            //登陆成功
            request.getSession().setAttribute("user",responseUser);
            request.getSession().setAttribute("currentDate",new Date());
            return "redirect:/classmateCourse";
        }
    }


    //  退出系统
    @RequestMapping("/out")
    public String toOut(HttpSession httpSession){
        httpSession.removeAttribute("user");
        return "redirect:/";
    }
}
