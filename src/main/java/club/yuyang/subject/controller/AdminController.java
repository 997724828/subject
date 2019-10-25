package club.yuyang.subject.controller;

import club.yuyang.subject.entity.Institute;
import club.yuyang.subject.service.InstituteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 20:46
 */
@Controller
public class AdminController {
    @Resource
    InstituteService instituteService;

    //查询所有学院信息
    @GetMapping("/allInstitutes")
    public String getInstitutes(Model model){
        List<Institute> instituteList = instituteService.getAllInstitutes();
        model.addAttribute("instituteList",instituteList);
        return "admin";
    }

    //删除一个学院
    @GetMapping("/delInstitute/{id}")
   public String delInstitute(@PathVariable("id")Integer id,
                              Model model){
        if (instituteService.deleteOne(id)>0){
            return "redirect:/allInstitutes";
        }else{
            model.addAttribute("message","删除失败");
            return "error";
        }
    }
}
