package club.yuyang.subject.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yuyang
 * @date 2019/9/19 16:33
 */
@Mapper
public interface ClassmateDao {

    String findNameByClassmateId(@Param("classmateId") Integer classmateId);
}
