package com.code.bms.controller;

import com.code.bms.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;


    @RequestMapping(value = "/register.action")
    public String toLogin() {
        return "register";
    }

    @RequestMapping("/reader_register_do.action")
    public String registerDo(Integer readerId, String name, String passwd, String sex, Date birth, String address,
                             String telcode, RedirectAttributes redirectAttributes) {
        boolean succ = this.registerService.addReaderCard(readerId, name, passwd, sex, birth, address, telcode);
        if (succ) {
            return "register_succ";
        } else {
            redirectAttributes.addFlashAttribute("error", "该读者已注册");
            return "redirect:/register.action";
        }


    }

}
