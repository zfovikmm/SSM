package com.zm.controller;


import com.zm.mapper.*;
import com.zm.pojo.*;
import com.zm.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private DelegatorServiceImpl delegatorService;

    @Autowired
    private LawyerServiceImpl lawyerService;

    @Autowired
    private ConsulationServiceImpl consulationService;

    @Autowired
    private AdministratorServiceImpl administratorService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CasetypeMapper casetypeMapper;

    //登录认证
    @RequestMapping("/golog")
    public String login(String name,String password,String userType , Model model){
        if(userType.equals("1")){
            Delegator d = delegatorService.login(name, password);
            List<Lawyer> lawyers = lawyerService.queryAllLawyer();
            model.addAttribute("lawyers",lawyers);
            if( d != null){
                return "cate";
            }else {
                return "redirect:/index.jsp";
            }
        }

        if(userType.equals("2")){
            Lawyer login = lawyerService.login(name, password);
            if( login != null ){
                List<Message> messages = messageService.queryAllMessageByLawyer(login.getLawyerId());
                System.out.println(login.getLawyerId());
                System.out.println(messages);
                model.addAttribute("messages",messages);
                return "lawyer_show";
            }else {
                return "redirect:/index.jsp";
            }
        }

        if(userType.equals("3")) {
            Administrator a = administratorService.login(name,password);
            model.addAttribute("admin", a);
            if (a != null) {
                return "main";
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
        int d = delegatorService.addDelegator(delegator);
        if (d != 0) {
            return "redirect:/index.jsp";
        }else {
            return "redirect:/index.jsp";
        }
    }

//======================================委托人后台管理系统===================================================================

    //退出
    @RequestMapping("exit")
    public String exit(){
        return "redirect:/index.jsp";
    }

    //首页
    @RequestMapping("main")
    public String m(){
        return "main";
    }

    //删除委托人
    @RequestMapping("delGator")
    public String delGator(int delegatorId){
        int i = delegatorService.delGator(delegatorId);
        if(i != 0){
            request.setAttribute("newsc","删除成功");
            return "redirect:/list";
        }else {
            request.setAttribute("newsc","删除失败");
            return "redirect:/list";
        }
    }

    //编辑委托人
    @RequestMapping("upDele")
    public String upDele(Delegator delegator){
        int i = delegatorService.upDele(delegator);
        if(i != 0){
            request.setAttribute("newsc","更新成功");
            return "redirect:/list";
        }else {
            request.setAttribute("newsc","更新失败");
            return "redirect:/list";
        }
    }
    //模糊查询委托人
    @RequestMapping("selectDele")
    public String selectDele(String dename,Model model){
        List<Delegator> delegators = delegatorService.selectDele(dename);
        System.out.println(dename);
        System.out.println(delegators);
        model.addAttribute("delegators",delegators);

        return "dele_show";
    }

    //分页查询
    @RequestMapping("list")
    public String list(Model model, @RequestParam(value = "nodePage",defaultValue = "1") int nodePage){
        //获取数据总记录数
        int DataItemSize = delegatorService.getAllSize();
        System.out.println(DataItemSize);
        int allPage = 0; //总页数
        int pageSize = 2;//每页要显示的记录数
        //判断数据总记录和每页要显示的记录数求余，余数是否为0
        if (DataItemSize%pageSize==0){
            allPage=DataItemSize/pageSize;// 10/5=2 总页数=2
        }else{
            allPage=(DataItemSize/pageSize)+1;//如果是13条：13/5=2.5 int类型取2整数，然后在加1就成了3页 总页数=3
        }
        int startIndex = 0;//默认值设置起点为0；
        //select * from user limit 起点，条数
        startIndex = (nodePage-1)*pageSize; //起点=当前页数-1*每页要显示的记录数
        Map<String,Integer> map = new HashMap<String, Integer>(); //把起点和要显示的记录数存入map集合中
        map.put("start",startIndex);
        map.put("pageSize",pageSize);

        model.addAttribute("allpage",allPage);//把总页数传到页面
        model.addAttribute("nodePage",nodePage);//把当前页数传到页面

        List<Delegator> list = delegatorService.getAll(map);
        System.out.println(list);
        model.addAttribute("delegators",list);
        return "dele_show";
    }

    //======================================案件后台管理系统===================================================================
    //查询所有案件类型
    @RequestMapping("allCase")
    public String queryAllCase(Model model){
        List<Casetype> cases = casetypeMapper.queryAllCase();
        model.addAttribute("cases",cases);
        return "caseType";
    }

    //更新案件类型
    @RequestMapping("uptype")
    public String uptype(Casetype cas){
        int i = casetypeMapper.upCase(cas);
        if(i!=0){
            request.setAttribute("newsc","更新成功");
            return "redirect:/allCase";
        }else {
            request.setAttribute("newsc","更新失败");
            return "redirect:/allCase";
        }
    }

    //删除
    @RequestMapping("deltype")
    public String deltype(int caseId){
        int i = casetypeMapper.delCase(caseId);
        if(i!=0){
            request.setAttribute("newsc","更新成功");
            return "redirect:/allCase";
        }else {
            request.setAttribute("newsc","更新失败");
            return "redirect:/allCase";
        }
    }

    //添加案件
    @RequestMapping("addtype")
    public String addtype(Casetype casetype){
        int i =  casetypeMapper.addCase(casetype);
        if(i!=0){
            request.setAttribute("newsc","添加成功");
            return "redirect:/allCase";
        }else {
            request.setAttribute("newsc","添加失败");
            return "redirect:/allCase";
        }
    }

    //======================================律师后台管理系统===================================================================
    //分页查询
    @RequestMapping("listLawyer")
    public String listLawyer(Model model, @RequestParam(value = "nodePage",defaultValue = "1") int nodePage){
        //获取数据总记录数
        int DataItemSize = lawyerService.getAllSize();
        System.out.println(DataItemSize);
        int allPage = 0; //总页数
        int pageSize = 2;//每页要显示的记录数
        //判断数据总记录和每页要显示的记录数求余，余数是否为0
        if (DataItemSize%pageSize==0){
            allPage=DataItemSize/pageSize;// 10/5=2 总页数=2
        }else{
            allPage=(DataItemSize/pageSize)+1;//如果是13条：13/5=2.5 int类型取2整数，然后在加1就成了3页 总页数=3
        }
        int startIndex = 0;//默认值设置起点为0；
        //select * from user limit 起点，条数
        startIndex = (nodePage-1)*pageSize; //起点=当前页数-1*每页要显示的记录数
        Map<String,Integer> map = new HashMap<String, Integer>(); //把起点和要显示的记录数存入map集合中
        map.put("start",startIndex);
        map.put("pageSize",pageSize);

        model.addAttribute("allpage",allPage);//把总页数传到页面
        model.addAttribute("nodePage",nodePage);//把当前页数传到页面

        List<Lawyer> list = lawyerService.getAll(map);
        System.out.println(list);
        model.addAttribute("lawyers",list);
        return "lawyerlist";
    }

    //删除
    @RequestMapping("delLaw")
    public String delLaw(int lawyerId,Model model){
        int i = lawyerService.delLaw(lawyerId);
        if(i != 0){
            request.setAttribute("newsc","删除成功");
            return "redirect:/listLawyer";
        }else {
            request.setAttribute("newsc","删除失败");
            return "redirect:/listLawyer";
        }
    }

    //更新
    @RequestMapping("upLaw")
    public String upLaw(Lawyer lawyer,Model model){
        int i = lawyerService.upLaw(lawyer);
        if(i != 0){
            request.setAttribute("newsc","更新成功");
            return "redirect:/listLawyer";
        }else {
            request.setAttribute("newsc","更新失败");
            return "redirect:/listLawyer";
        }
    }

    //模糊查询
    @RequestMapping("selectLawyer")
    public String selectLawyer(String name,Model model){
        List<Lawyer> lawyers = lawyerService.selectLawyer(name);
        model.addAttribute("lawyers",lawyers);
        return "lawyerlist";
    }
    //添加
    @RequestMapping("addLawyer")
    public String addLawyer(){
        return "addLawyer";
    }

}
