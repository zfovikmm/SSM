package com.zm.service;

import com.zm.mapper.MessageMapper;
import com.zm.pojo.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Resource
    private MessageMapper messageMapper;

    @Override
    public int addMessage(Message message) {
        return messageMapper.addMessage(message);
    }

    @Override
    public List<Message> queryAllMessage(int delegatorId) {
        return  messageMapper.queryAllMessage(delegatorId);
    }

    @Override
    public List<Message> queryAllMessageByLawyer(int lawyerId) {
        return messageMapper.queryAllMessageByLawyer(lawyerId);
    }

}
