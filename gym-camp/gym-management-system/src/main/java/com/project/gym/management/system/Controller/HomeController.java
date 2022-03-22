package com.project.gym.management.system.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@GetMapping("/")
    public String home(){
    return "index";

}

//@GetMapping("/session")
//    public String session(){
//    return "session";
//
//}

@GetMapping("/aboutUs")
    public String aboutUs(){
    return "aboutUs";

}

    @GetMapping("/contactUs")
    public String contactUs(){
        return "contactUs";

    }

}
