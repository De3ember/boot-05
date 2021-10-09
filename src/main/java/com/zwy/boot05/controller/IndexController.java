package com.zwy.boot05.controller;

import com.zwy.boot05.Service.Impl.AccountServiceImpl;
import com.zwy.boot05.bean.Account;
import com.zwy.boot05.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if(!StringUtils.isEmpty(user.getUsername())&&"123456".equals(user.getPassword())){
            session.setAttribute("loginuser",user);
            return "redirect:main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            return "login";
        }
    }
    @GetMapping("main.html")
    public String mainPage( HttpSession session, Model model){
            return "index";
    }
    @Autowired
    AccountServiceImpl accountService;
    @ResponseBody
    @GetMapping("/account")
    public Account getById(@RequestParam("id") Integer id){
        return accountService.getById(id);
    }
}
