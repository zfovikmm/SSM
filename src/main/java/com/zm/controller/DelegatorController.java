package com.zm.controller;

import com.zm.mapper.CasetypeMapper;
import com.zm.pojo.Casetype;
import com.zm.pojo.Lawyer;
import com.zm.pojo.Message;
import com.zm.service.LawyerServiceImpl;
import com.zm.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DelegatorController {

    @Autowired
    private LawyerServiceImpl lawyerService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private CasetypeMapper casetypeMapper;

    //跳转到咨询页面
    @RequestMapping("tonew")
    public String t(Model model){
        List<Casetype> casetypes = casetypeMapper.queryAllCase();
        model.addAttribute("casetypes",casetypes);
        return "new";
    }

    //咨询成功后跳转到首页
    @RequestMapping("tocate")
    public String tocate(Message message, Model model){
        messageService.addMessage(message);
        List<Lawyer> lawyers = lawyerService.queryAllLawyer();
        model.addAttribute("lawyers",lawyers);
        return "cate";
    }

    //跳转到消息列表
    @RequestMapping("tomessage")
    public String tomessage(int delegatorID,Model model){
        List<Message> messages = messageService.queryAllMessage(delegatorID);
        System.out.println(delegatorID);
        model.addAttribute("messages",messages);
        return "message";
    }

}
