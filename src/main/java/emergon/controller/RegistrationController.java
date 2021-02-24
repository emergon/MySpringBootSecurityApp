package emergon.controller;

import emergon.entity.MyUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {
    
    @GetMapping("/register")
    public String showRegisterForm(@ModelAttribute("myuser") MyUser xrhsths){
        return "register-form";
    }
}
