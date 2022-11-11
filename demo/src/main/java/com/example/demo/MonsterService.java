package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class MonsterService {

    public Monster getMonster() {
        System.out.println("in the service layer");
        Monster m = new Monster();
        return m;
    }

}
