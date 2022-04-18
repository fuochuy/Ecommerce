package cybersoft.javabackend.ecommerce.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cybersoft.javabackend.ecommerce.global.GlobalData;
import cybersoft.javabackend.ecommerce.role.model.Role;
import cybersoft.javabackend.ecommerce.role.repository.RoleRepository;
import cybersoft.javabackend.ecommerce.user.dto.UserDTO;
import cybersoft.javabackend.ecommerce.user.model.User;
import cybersoft.javabackend.ecommerce.user.repository.UserRepository;



@Controller
public class LoginController{
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }//page login

    @GetMapping("/forgotpassword")
    public String forgotPass(Model model){
        model.addAttribute("userDTO", new UserDTO());
        return "forgotpassword";
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        return "register";
    } //page register

   
}
