package com.codeex.taskcode.domain.dao;

import com.codeex.taskcode.domain.model.Task;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TaskRepository {
    @Select("select * from task where \"userId\" = #{userId}")
    List<Task> findAll(@Param("userId") Integer userId);

    @Select("select * from task where id = #{id} and \"userId\" = #{userId}")
    Task findById(@Param("id") Integer id, @Param("userId") Integer userId);

    @Delete("delete from task where id = #{id} and \"userId\" = #{userId}")
    void remove(@Param("id") Integer id, @Param("userId") Integer userId);

    @Insert("insert into task(subject, \"dueDate\", \"userId\") " +
            "values(#{subject}, #{dueDate}, #{userId})")
    void add(Task task);

    @Update("update task " +
            "set subject = #{subject}, " +
            "\"dueDate\" = #{dueDate} " +
            "where id = #{id} and " +
            "\"dueDate\" = #{userId}")
    void update(Task task);

    @Select("select * from task where \"userId\" = #{userId} order by id desc limit 1")
    Task findLastTask(@Param("userId") Integer userId);
}
