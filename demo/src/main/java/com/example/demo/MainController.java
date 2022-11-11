package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    private MonsterService monsterService;

    @GetMapping("/")
    @ResponseBody
    public String greet() {
        System.out.println("Logging");
        return "Greetings from the server!";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/hello/again")
    @ResponseBody
    public String sayHelloAgain() {
        return "One more Hello!!!";
    }

    // RETURN OBJECT
    @GetMapping("/monster")
    @ResponseBody
    public Monster getMonster() {
        // Monster m = new Monster("yeti", 2000, false);
        Monster m = monsterService.getMonster();
        return m;

    }

    // POSTING
    @PostMapping("/monster")
    @ResponseBody
    public Monster createMonster(@RequestBody Monster m) {
        System.out.println(m.getName() + " " + m.getAge() + " " + m.isScary());
        return m;
    }

}
