package com.zm.controller;


import com.zm.mapper.AdministratorMapper;
import com.zm.mapper.DelegatorMapper;
import com.zm.pojo.Administrator;
import com.zm.pojo.Delegator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @Autowired
//    @Qualifier("AdministratorServiceImpl")
    private AdministratorMapper administratorMapper;

    @Autowired
    private DelegatorMapper delegatorMapper;

    //登录认证
    @RequestMapping("/golog")
    public String login(String name,String password,String userType , Model model){
        if(userType.equals("4")) {
            Administrator a = administratorMapper.login(name,password);
            model.addAttribute("admin", a);
            if (a != null) {
                return "logok";
            } else {
                return "logno";
            }
        }else {
            return "logno";
        }
    }

    //跳转到注册页面
    @RequestMapping("toSignUp")
    public String toSigUp(){
        return "signUp";
    }


    //注册
    @RequestMapping("/signUp")
    public String signUp(Delegator delegator){
       int d = delegatorMapper.addDelegator(delegator);
       if (d != 0) {
           System.out.println("success");
           return "redirect:/index.jsp";
       }else {
           System.out.println("error");
           return "redirect:/index.jsp";
       }
    }

}
