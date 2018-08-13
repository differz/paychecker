package com.differz.paychecker.web.root;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String paychecker() {

        return "redirect:/subscription";
    }
}
