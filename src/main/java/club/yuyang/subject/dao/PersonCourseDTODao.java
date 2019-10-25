package club.yuyang.subject.dao;

import club.yuyang.subject.dto.PersonCourseDTO;
import club.yuyang.subject.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author yuyang
 * @date 2019/10/25 11:47
 */
@Mapper
public interface PersonCourseDTODao {
    List<PersonCourseDTO> getPersonCourse(User user);
}
