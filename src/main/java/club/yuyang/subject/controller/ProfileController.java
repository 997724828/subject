package club.yuyang.subject.controller;


import club.yuyang.subject.dao.PersonCourseDTODao;
import club.yuyang.subject.dto.PersonCourseDTO;
import club.yuyang.subject.dto.ClassmateCourseDTO;
import club.yuyang.subject.dto.UserDTO;
import club.yuyang.subject.entity.*;
import club.yuyang.subject.enums.EnumWeek;
import club.yuyang.subject.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * @author yuyang
 * @date 2019/9/26 16:45
 */
@Controller
public class ProfileController {
    @Resource
    ClassmateCourseService classmateCourseService;
    @Resource
    SelectCourseService selectCourseService;
    @Resource
    CourseService courseService;
    @Resource
    PersonCourseDTODao personCourseDTODao;
    @Resource
    InstituteService instituteService;
    @Resource
    ClassmateService classmateService;


    //跳转班级课表
    @GetMapping("/classmateCourse")
    public String toClassmateCourse(HttpServletRequest request){
        //跳转到对应用户界面时传入相应信息
        UserDTO responseUser = (UserDTO) request.getSession().getAttribute("user");
        List<ClassmateCourse> classmateCourse = classmateCourseService.getClassmateCourse(responseUser.getClassmateId());
        List<ClassmateCourseDTO> classmateCourseDTOS = new ArrayList<>();
        for (ClassmateCourse course : classmateCourse){
            ClassmateCourseDTO classmateCourseDTO = new ClassmateCourseDTO();
            BeanUtils.copyProperties(course,classmateCourseDTO);
            classmateCourseDTO.setClassmateName(responseUser.getClassmateName());
            classmateCourseDTO.setCourseName(courseService.getCourseById(course.getCourseId()).getCourseName());
            classmateCourseDTO.setWeekName(EnumWeek.getWeekName(course.getTimes()));
            classmateCourseDTOS.add(classmateCourseDTO);
        }
        request.setAttribute("classmateCourseDTOS",classmateCourseDTOS);
        return "profile";
    }

    //跳转个人课表
    @RequestMapping("/personCourse")
    public String toPersonCourse(HttpServletRequest request){
        //跳转到对应用户界面时传入相应信息
        UserDTO responseUser = (UserDTO) request.getSession().getAttribute("user");
        List<PersonCourseDTO> personCourseDTOS = new ArrayList<>();//定义个人课程集合（班级课表+选修课表）
        User user = new User();
        user.setClassmateId(responseUser.getClassmateId());
        user.setAccount(responseUser.getAccount());
        List<PersonCourseDTO> personCourseDTOS1 = personCourseDTODao.getPersonCourse(user);
        for (PersonCourseDTO course : personCourseDTOS1){
            course.setCourseName(courseService.getCourseById(course.getCourseId()).getCourseName());
            course.setWeekName(EnumWeek.getWeekName(course.getTimes()));
            personCourseDTOS.add(course);
        }
        request.setAttribute("personCourseDTOS", personCourseDTOS);
        return "profile";
    }

    //跳转我要蹭课列表
    @GetMapping("/rubCourse")
    public String toRubCourse(Model model){

        //获得该学校所有的学院信息-》选择进入的学院
        model.addAttribute("allInstitutes",instituteService.getAllInstitutes());
        //发送状态，为了前台知道知道已经跳转蹭课界面
        model.addAttribute("rubCourse","rubCourse");
        return "profile";
    }

    //实现前端ajax通过选择学院拉取对应所有课程列表
    @ResponseBody
    @GetMapping("/getCourseByInstituteId")
    public List<Course> getAllCourses(Integer instituteId){
        List<Course> courses = courseService.getAllCourse(instituteId);
        return courses;
    }

    //实现前端ajax通过选择课程拉取对应所有课程信息
    @ResponseBody
    @GetMapping("/getRubCourses")
    public List<ClassmateCourseDTO> getRubCourses(Integer courseId){
        List<ClassmateCourseDTO> rubCourseList = new ArrayList<>();
        List<ClassmateCourse> rubCourses = classmateCourseService.getRubCourse(courseId);
        for (ClassmateCourse list : rubCourses){
            ClassmateCourseDTO e = new ClassmateCourseDTO();
            BeanUtils.copyProperties(list,e);
            e.setCourseName(courseService.getCourseById(list.getCourseId()).getCourseName());//通过课程id查到课程再set进去课程的课程名
            e.setClassmateName(classmateService.getClassmateName(list.getClassmateId()));
            e.setWeekName(EnumWeek.getWeekName(list.getTimes()));
            rubCourseList.add(e);
        }
        return rubCourseList;
    }

    //添加想要蹭的课程进去个人选课表
    @GetMapping("/addRubCourseIntoPerson/{id}")
    public String toAddRubCourse(@PathVariable("id")Integer id,
                                 HttpServletRequest request){
        UserDTO responseUser = (UserDTO) request.getSession().getAttribute("user");
        //得到想要蹭的课程
        ClassmateCourse course = classmateCourseService.getClassmateCourseById(id);

        ClassmateCourse classmateCourse = new ClassmateCourse();
        classmateCourse.setClassmateId(responseUser.getClassmateId());
        classmateCourse.setTimes(course.getTimes());
        classmateCourse.setSections(course.getSections());
        ClassmateCourse course1 = classmateCourseService.isExitCourse(classmateCourse);
        if (course1!=null){
            //说明课程会和必修课冲突
            request.setAttribute("message", "课程和您的必修课冲突");
            return "error";
        }else {
            //检测是否和选修冲突
            SelectCourse selectCourse = new SelectCourse();
            selectCourse.setAccount(responseUser.getAccount());
            selectCourse.setTimes(course.getTimes());
            selectCourse.setSections(course.getSections());
            SelectCourse selectCourse1 = selectCourseService.isExitCourse(selectCourse);
            if(selectCourse1!=null){
                //说明课程会和选修课冲突
                request.setAttribute("message", "课程和您的选修课冲突");
                return "error";
            }else {
                SelectCourse course2 = new SelectCourse();
                course2.setInstituteId(responseUser.getInstituteId());
                course2.setCourseId(course.getCourseId());
                course2.setAccount(responseUser.getAccount());
                course2.setTeacher(course.getTeacher());
                course2.setTimes(course.getTimes());
                course2.setSections(course.getSections());
                course2.setAddress(course.getAddress());
                course2.setTypes("蹭");
                selectCourseService.insertSelectCourse(course2);
                return "redirect:/personCourse";
            }
        }
    }
}