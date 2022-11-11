package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// import com.fasterxml.jackson.core.sym.Name;

@Controller
public class DefaultController {

    @GetMapping("*")
    public String redirect() {
        return "redirect:/";
    }

    // REQUEST PARAMETERS
    // localhost:8080/helloname?name=Oscar
    // shows how you can just put in the values for stuff in the url
    @GetMapping("/helloname")
    @ResponseBody
    public String sayHelloWithName(@RequestParam String name) {
        System.out.println(name);
        return ("Hello " + name + "!");
    }

    // http://localhost:8080/wordvalueboolean?word=scar&value=33&b=true
    @GetMapping("/wordvalueboolean")
    @ResponseBody
    public String wordValueBoolean(@RequestParam String word, @RequestParam Double value, @RequestParam boolean b) {
        return word + " " + value + " " + b;
    }

    // PATH VARIABLES
    // http://localhost:8080/hello/Oscar
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHellowith(@PathVariable String name) {
        return ("hello " + name);
    }

    // RETURN LIST
    @GetMapping("/list")
    @ResponseBody
    public ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("scer");
        list.add("nerd");
        list.add("perkele");
        return list;
    }

    // RETURN MAP
    @GetMapping("/map")
    @ResponseBody
    public HashMap<String, String> getMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Finland", "Helsinki");
        map.put("Oscar", "Hero");
        return map;
    }
}
