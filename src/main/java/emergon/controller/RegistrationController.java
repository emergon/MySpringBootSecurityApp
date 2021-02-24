package emergon.controller;

import emergon.entity.MyUser;
import emergon.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegistrationController {
    
    @Autowired
    UserService userService;
    
    @GetMapping("/register")
    public String showRegisterForm(@ModelAttribute("myuser") MyUser xrhsths){
        return "register-form";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("myuser") MyUser xrhsths, BindingResult result
            , RedirectAttributes attributes
    ){
        if(result.hasErrors()){
            return "register-form";
        }
        //save user to DB
        //System.out.println(">>>>> xrhsths:"+xrhsths);
        userService.saveUser(xrhsths);
        attributes.addFlashAttribute("registered", "Successfully registered");
        return "redirect:/loginPage";
    }
}
