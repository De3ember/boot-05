package com.zwy.boot05.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zwy.boot05.Service.UserService;
import com.zwy.boot05.bean.User;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn,  Model model){

        Page<User> userPage=new Page<>(pn,2);
        Page page = userService.page(userPage,null);


        model.addAttribute("page",page);

        return "table/dynamic_table";
    }
    @GetMapping("user/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, @RequestParam(value="pn",defaultValue = "1") Integer pn, RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";

    }
    @GetMapping("/responsive_table")
    public String responsive_table(){ return "table/responsive_table"; }
    @GetMapping("/editable_table")
    public String editable_table(){ return "table/editable_table"; }
    @GetMapping("/pricing_table")
    public String pricing_table(){ return "table/pricing_table"; }
    @GetMapping("/update")
    public String toupdate(){return "table/update";}
    @GetMapping("/insertuser")
    public String insert(User user){

        userService.save(user);
        return "redirect:/dynamic_table";
    }
    @GetMapping("user/update/{id}/{name}/{age}/{email}")
    public String update(Model model,@PathVariable("id")Integer id,@PathVariable("name") String name,@PathVariable("age")Integer age,@PathVariable("email") String email){

        User user=new User();
        user.setId(id.longValue());
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        model.addAttribute("user",user);
        return "table/updating";
    }
    @GetMapping("/updatingeuser")
    public String updating(User user){
        userService.updateById(user);
        return  "redirect:/dynamic_table";
    }
}
