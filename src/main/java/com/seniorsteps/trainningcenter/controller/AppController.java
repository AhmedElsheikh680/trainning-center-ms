/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.seniorsteps.trainningcenter.controller;

import com.seniorsteps.trainningcenter.model.User;
//import com.seniorsteps.trainningcenter.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

//    @Autowired
//    private UserService userService;

    @RequestMapping(
            {
                "/", "", "/index"
            })

    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }

   

    @GetMapping("/login")
    public String getLoginPage() {
//        User user = getUserPrincipal();
//        if (user == null) {

            return "login";
//        } else {
//            return "redirect:/";
//        }
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

//    private User getUserPrincipal() {
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//        }
//        if (userName != null) {
//            return userService.getByUsername(userName);
//        }
//        return null;
//    }

//    @GetMapping("/Access_Denied")
//    public String access_Denied(){
//        List<Role> roles = roleService.getList();
//        System.out.println("Roles "+ roles.size());
//        return "accessDe";
//    }
}
