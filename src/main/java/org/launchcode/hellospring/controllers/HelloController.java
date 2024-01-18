package org.launchcode.hellospring.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye Spring";
    }

    @RequestMapping(value="hello", method={RequestMethod.GET, RequestMethod.POST})
    public String hello(Model model, @RequestParam(defaultValue = "Dudeman") String name){
        String greeting = "What up " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(Model model, @PathVariable String name){
        String greeting = "What up " + name + "! This used a path variable.";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm(){
    return "form";
    }

 @GetMapping("hello-my-list")
    public String helloList(Model model){

        List<String> names = new ArrayList<>();
        names.add("Duder");
        names.add("DudeMan");
        names.add("Duderino");

        model.addAttribute("names", names);

        return "hello-list";
    }


}
