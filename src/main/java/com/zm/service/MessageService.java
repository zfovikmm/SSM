package com.zm.service;

import com.zm.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageService {

    //添加信息
    int addMessage(Message message);

    //查询用户咨询的内容
    List<Message> queryAllMessage(int delegatorId);

    List<Message> queryAllMessageByLawyer(int lawyerId);
}
