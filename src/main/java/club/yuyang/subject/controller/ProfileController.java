package club.yuyang.subject.controller;


import club.yuyang.subject.dao.PersonCourseDTODao;
import club.yuyang.subject.dto.PersonCourseDTO;
import club.yuyang.subject.dto.ClassmateCourseDTO;
import club.yuyang.subject.dto.UserDTO;
import club.yuyang.subject.entity.ClassmateCourse;
import club.yuyang.subject.entity.SelectCourse;
import club.yuyang.subject.entity.User;
import club.yuyang.subject.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            classmateCourseDTOS.add(classmateCourseDTO);
        }
        request.setAttribute("classmateCourseDTOS",classmateCourseDTOS);
        return "profile";
    }

    //跳转个人课表
    @RequestMapping("/personCourse")
    public String toPersonCourse(HttpServletRequest request){
//        //跳转到对应用户界面时传入相应信息
       UserDTO responseUser = (UserDTO) request.getSession().getAttribute("user");


        List<PersonCourseDTO> personCourseDTOS = new ArrayList<>();//定义个人课程集合（班级课表+选修课表）
        User user = new User();
        user.setClassmateId(responseUser.getClassmateId());
        user.setAccount(responseUser.getAccount());
        List<PersonCourseDTO> personCourseDTOS1 = personCourseDTODao.getPersonCourse(user);
        for (PersonCourseDTO course : personCourseDTOS1){
            course.setCourseName(courseService.getCourseById(course.getCourseId()).getCourseName());
            personCourseDTOS.add(course);
        }
//        //班级课表
//        List<ClassmateCourse> classmateCourse = classmateCourseService.getClassmateCourse(responseUser.getClassmateId());
//        for (ClassmateCourse course : classmateCourse){
//            PersonCourseDTO personCourseDTO = new PersonCourseDTO();
//            BeanUtils.copyProperties(course,personCourseDTO);
//            personCourseDTO.setCourseName(courseService.getCourseById(course.getCourseId()).getCourseName());
//            personCourseDTOS.add(personCourseDTO);
//        }
//        //个人课表
//        List<SelectCourse> personCourses = selectCourseService.getPersonCourse(responseUser.getAccount());
//        for (SelectCourse personCourse : personCourses){
//            PersonCourseDTO personCourseDTO2 = new PersonCourseDTO();
//            BeanUtils.copyProperties(personCourse, personCourseDTO2);
//            personCourseDTO2.setCourseName(courseService.getCourseById(personCourse.getCourseId()).getCourseName());
//            personCourseDTOS.add(personCourseDTO2);
//        }

        request.setAttribute("personCourseDTOS", personCourseDTOS);
        return "profile";
    }
}