package com.codeex.taskcode.domain.dao;

import com.codeex.taskcode.domain.model.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserRoleRepository {
    @Select("select * from user_role")
    List<UserRole> findAll();

    @Select("select * from user_role where \"userId\" = #{id}")
    List<UserRole> findByUserId(Integer id);

    @Delete("delete from user_role where \"userId\" = #{userId} and \"roleId\" = #{roleId}")
    void remove(UserRole userRole);

    @Insert("insert into user_role( " +
            "\"userId\", \"roleId\") " +
            "values (#{userId}, #{roleId})")
    void add(UserRole var);
}
