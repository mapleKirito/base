package com.linktones.user.mapper;


import com.linktones.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user where token=#{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from user where account=#{account} and password=#{password}")
    User getUser(User userValue);

    @Update("update user set token=#{token},gmt_last_login=#{gmt_last_login} where id=#{id}")
    void updateToken(User user);
}
