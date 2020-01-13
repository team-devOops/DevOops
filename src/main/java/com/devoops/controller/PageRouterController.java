package com.devoops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class PageRouterController {

    @RequestMapping("html/{packageName}/{routePage}")
    public String mainRouter(@PathVariable Map<String, String> pathMap) {
        pathMap.forEach((key,value)-> {System.out.printf("key:: %s value:: %s\n", key,value);});

        return pathMap.get("packageName") +"/"+pathMap.get("routePage");
    }

}