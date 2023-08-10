package com.example.sessionstore;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {


    @GetMapping("/login")
    public String login(HttpSession session, @RequestParam String name){
        session.setAttribute(session.getId(),name);

        return "saved.";
    }

    @GetMapping("/myName")
    public String myName(HttpSession session){
        String myName = (String)session.getAttribute(session.getId());

        return myName;
    }
}
