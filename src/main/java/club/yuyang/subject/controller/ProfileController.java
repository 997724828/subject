package club.yuyang.subject.controller;


import club.yuyang.subject.dao.PersonCourseDTODao;
import club.yuyang.subject.dto.PersonCourseDTO;
import club.yuyang.subject.dto.ClassmateCourseDTO;
import club.yuyang.subject.dto.UserDTO;
import club.yuyang.subject.entity.ClassmateCourse;
import club.yuyang.subject.entity.Course;
import club.yuyang.subject.entity.User;
import club.yuyang.subject.enums.EnumWeek;
import club.yuyang.subject.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    CourseService courseService;
    @Resource
    PersonCourseDTODao personCourseDTODao;
    @Resource
    InstituteService instituteService;


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
//    @ResponseBody
//    @GetMapping("/getRubCourses")
//    public List<Course> getAllCourses(Integer instituteId){
//        List<Course> courses = courseService.getAllCourse(instituteId);
//        return courses;
//    }

}