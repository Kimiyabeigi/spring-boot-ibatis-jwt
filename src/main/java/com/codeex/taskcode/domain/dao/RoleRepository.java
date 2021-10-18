package com.codeex.taskcode.domain.dao;

import com.codeex.taskcode.domain.model.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoleRepository {
    @Select("select * from role")
    List<Role> findAll();

    @Select("select * from role where id = #{id}")
    Role findById(Integer id);

    @Select("select * from role where name = #{name}")
    Role findByName(String name);

    @Delete("delete from role where id = #{id}")
    void remove(Integer id);

    @Insert("insert into role (name) values (#{name})")
    void add(Role var);

    @Update("update role set name= #{name} where id = #{id}")
    void update(Role var);
}
