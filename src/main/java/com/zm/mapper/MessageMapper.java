package com.zm.mapper;

import com.zm.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {



    //添加信息
    @Insert("insert into ssm.message(content,title,type) values (#{content},#{title},#{type});")
    int addMessage(Message message);

    //根据用户id查询信息
    @Select("select * from ssm.message where sender_id = #{delegatorId}")
    List<Message> queryAllMessage(@Param("delegatorId") int delegatorId);

    //根据律师id查询信息
    @Select("select * from ssm.message where recipient_id = #{lawyerId}")
    List<Message> queryAllMessageByLawyer(@Param("lawyerId") int lawyerId);
}
