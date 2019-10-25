package club.yuyang.subject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuyang
 * @date 2019/9/19 12:49
 */
@Mapper
public interface InstituteDao {

    String findNameByInstituteId(@Param("instituteId") Integer instituteId);
}
