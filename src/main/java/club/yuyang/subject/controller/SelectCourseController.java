package club.yuyang.subject.controller;

import club.yuyang.subject.service.SelectCourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;

/**
 * @author yuyang
 * @date 2019/11/1 12:04
 */
@Controller
@RequestMapping("/selectCourse")
public class SelectCourseController {
    @Resource
    SelectCourseService selectCourseService;


    @GetMapping("/del/{id}")
    public String delSelectCourse(@PathVariable("id")Integer id,
                                  Model model){
        boolean isOk = selectCourseService.delSelectCourseById(id);
        if (isOk){
            return "redirect:/personCourse";
        }else {
            model.addAttribute("message","删除课程失败");
            return "error";
        }
    }
}
