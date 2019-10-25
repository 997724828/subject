package club.yuyang.subject.interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录检查
 * @author yuyang
 * @date 2019/9/26 11:23
 */
@Service
public class LoginHandlerInterceptor implements HandlerInterceptor {


    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute("user");
        if (user == null){
            //未登录，返回登录页面
            request.setAttribute("warn","sorry,没有权限请先登录!");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }else{
            //已登录，放行请求
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
