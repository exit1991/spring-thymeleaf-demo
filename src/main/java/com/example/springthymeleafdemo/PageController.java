package com.example.springthymeleafdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class PageController {
    
    @GetMapping("/")
    public ModelAndView getTopPage(ModelAndView mav) {
        mav.setViewName("index");
        return mav;
    }
    
    @GetMapping("/entry/input")
    public ModelAndView getEntryPage(ModelAndView mav) {
        mav.setViewName("entry/input");
        return mav;
    }
    
    @PostMapping("/entry/complete")
    public ModelAndView postCompletePage(ModelAndView mav, @ModelAttribute UserEntry userEntry) {
        mav.setViewName("entry/complete");
        mav.addObject("userEntry", userEntry);
        return mav;
    }
    
}
