package com.zm.controller;


import com.zm.mapper.AdministratorMapper;
import com.zm.mapper.ConsultationMapper;
import com.zm.mapper.DelegatorMapper;
import com.zm.pojo.Administrator;
import com.zm.pojo.Consultation;
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

    @Autowired
    private ConsultationMapper consultationMapper;

    //登录认证
    @RequestMapping("/golog")
    public String login(String name,String password,String userType , Model model){
        if(userType.equals("1")){
            Delegator d = delegatorMapper.login(name, password);
            model.addAttribute("delegator",d);
            if( d != null){
                return "cate";

            }else {
                System.out.println("失败");
            }
        }

        if(userType.equals("4")) {
            Administrator a = administratorMapper.login(name,password);
            System.out.println(a.getAdministratorId());
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

    //跳转到咨询室
    @RequestMapping("toAdvice")
    public String toAdvice(Consultation consultation,Model model){
        consultationMapper.addCs(consultation);
        Consultation c = consultationMapper.selectCs(28);
        System.out.println(c);
        model.addAttribute("consulation",c);
        return "advice";
    }
}
