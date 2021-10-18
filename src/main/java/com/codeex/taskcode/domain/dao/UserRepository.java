package com.codeex.taskcode.domain.dao;

import com.codeex.taskcode.domain.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserRepository {
    @Select("select * from \"user\"")
    List<User> findAll();

    @Select("select * from \"user\" where id = #{id}")
    User findById(Integer id);

    @Delete("delete from \"user\" where id = #{id}")
    void remove(Integer id);

    @Insert("insert into \"user\"( " +
            "\"firstName\", \"lastName\", username, password) " +
            "values (#{firstName}, #{lastName}, #{username}, #{password})")
    void add(User user);

    @Update("update \"user\" " +
            "set \"firstName\"= #{firstName}, " +
            "\"lastName\"= #{lastName}, " +
            "username= #{username} " +
            "where id= #{id}")
    void update(User user);

    @Select("select * from \"user\" where username = #{username}")
    User findByUsername(@Param("username") String username);

}
