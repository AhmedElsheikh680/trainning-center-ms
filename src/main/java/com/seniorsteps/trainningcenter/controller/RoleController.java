package com.seniorsteps.trainningcenter.controller;

import com.seniorsteps.trainningcenter.model.Role;
import com.seniorsteps.trainningcenter.service.RoleService;
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
@RequestMapping("/dataentry/role")
public class RoleController {

    private static final String packageName = "dataentry";
    private static final String requestMapping = "/dataentry/role";

    @Autowired
    private RoleService roleService;

    @GetMapping("/new")
    public String getNewRolePage(ModelMap model) {
        Role role = new Role();
        model.addAttribute("role", role);
        model.addAttribute("edit", false);
        return packageName + "/role";
    }

    @PostMapping("/new")
    public String newRole(@Valid Role role, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return packageName + "/role";
        }
        if (role.getId() == null) {
            role = roleService.save(role);
            if (role != null) {

                model.addAttribute("message", "Added Successfully");
            }
        } else {
            roleService.update(role);
        }
        return "redirect:" + requestMapping + "/list";
    }

    @GetMapping("/list")
    public String getALl(ModelMap model) {
        List<Role> roles = roleService.getList();
        model.addAttribute("roles", roles);
        return packageName + "/roles";
    }

    @GetMapping("/edit/{id}")
    public String getEditPage(@PathVariable Integer id, ModelMap model) {
        Role role = roleService.getById(id);
        if (role != null) {
            model.addAttribute("role", role);
            model.addAttribute("edit", true);
            return packageName + "/role";
        }
        return "redirect:" + requestMapping + "/list";
    }

    @PostMapping("/edit/{id}")
    public String updatedPage(@Valid Role role, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return packageName + "/role";
        }
        role = roleService.update(role);
        if (role != null) {
            model.addAttribute("updated", "Updated Successfully");
        }
        return "redirect:" + requestMapping + "/list";
    }

    @GetMapping("/delete/{id}")
    public String delteRole(@PathVariable Integer id, ModelMap model) {
        Role role = roleService.getById(id);
        if (role != null) {
            boolean deleted = roleService.delete(role);
            if(deleted){
                model.addAttribute("deleted", "Deleted Successfully");
            } else{
                model.addAttribute("delted", "Can\'t Be Deleted");
            }
        }
        return "redirect:"+requestMapping+"/list";
    }

}
