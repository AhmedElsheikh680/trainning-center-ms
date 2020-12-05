package com.seniorsteps.trainningcenter.controller;

import com.seniorsteps.trainningcenter.model.Role;
import com.seniorsteps.trainningcenter.model.User;
import com.seniorsteps.trainningcenter.service.RoleService;
import com.seniorsteps.trainningcenter.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dataentry/user")
public class UserController {

    private static final String pakageName = "dataentry";
    private static final String requestMapping = "/dataentry/user";

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleService roleService;

    @GetMapping("/new")
    public String getNewUserPage(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        List<Role> roles = roleService.getList();
        model.addAttribute("roles", roles);
        model.addAttribute("edit", false);
        return pakageName + "/user";
    }

    @PostMapping("/new")
    public String AddUser(@Valid User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return pakageName + "/user";
        }
        if (user.getId() == null) {
            user = userService.save(user);
            if (user != null) {
                model.addAttribute("added", "Added Successfully....");
            } else {
                model.addAttribute("added", "Error In Adding");
            }
        } else {
            userService.update(user);
        }
        return "redirect:" + requestMapping + "/list";
    }

    @GetMapping("/list")
    public String getAllUser(ModelMap model) {
        List<User> users = userService.getList();
        model.addAttribute("users", users);
        return pakageName + "/users";
    }
    
    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Integer id,ModelMap model){
        User user = userService.getById(id);
        if(user !=null){
            user.setPassword(null);
            model.addAttribute("user", user);
            model.addAttribute("edit", true);
            return pakageName+"/user";
        }
        return "rediret:"+requestMapping+"/list";
    }
    
    @PostMapping("/edit/{id}")
    public String updatedUser(@Valid User user, BindingResult result, ModelMap model){
        
        if(result.hasErrors()){
            return pakageName+"/user";
        }
        user = userService.update(user);
        if(user !=null){
            model.addAttribute("updated", "Updated Successfully....");
        }else {
            model.addAttribute("updated", "Error In Updating");
        }
        return "redirect:"+requestMapping+"/list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id, ModelMap model){
        User user = userService.getById(id);
        if(user != null){
            boolean deleted = userService.delete(user);
            if(deleted){
                model.addAttribute("deleted", "Deleted Successfully....");
            } else {
                model.addAttribute("deleted", "Can't Be Deleted");
            }
        }
        return "redirect:"+requestMapping+"/list";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
