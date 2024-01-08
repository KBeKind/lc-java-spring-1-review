package org.launchcode.hellospring.controllers;

import jakarta.websocket.server.PathParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello Spring";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye Spring";
    }

    // HANDLES REQUESTS OF THE FORM hello?name=aName
    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        return language + " " + name;
    }

    // HANDLES REQUESTS OF THE FORM hello/aName
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("form")
    public String helloForm(){
    return "<html>"
        + "<body>"
        + "<form action='../hello' method='post'>"
        + "<input type=text name='name' >"
        + "<label for='lang-select'>Select Language:</label>"
        + "<select name='language' id='lang-select'>"
        + "  <option value='>--Please choose an option--</option>'"
        + "  <option value='Hello'>English</option>"
        + "  <option value='What up'>Cool</option>"
        + "  <option value='Hola'>Spanish</option>"
        + "</select>"
        + "<input type=submit value='Greet Me' >"
        + "</form>"
        + "</body>"
        + "</html>";
    }




}
