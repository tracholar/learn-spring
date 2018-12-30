package com.tracholar.web.demo;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by zuoyuan on 2018/12/27.
 */
@Controller
@RequestMapping("/person")
public class PersonController {
    @GetMapping("/")
    public String form(){
        return "person";
    }
    @PostMapping("/")
    @ResponseBody
    public Object checkPersonInfo(@Valid PersonData person, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors();
        }

        return person;
    }
}
