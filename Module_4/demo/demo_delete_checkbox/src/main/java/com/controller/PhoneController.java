package com.controller;

import com.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @GetMapping("/list")
    public  String showList(@PageableDefault(size = 4)Pageable pageable, Model model){

        model.addAttribute("phoneList", this.phoneService.findAll(pageable));
        return "List";
    }

    @PostMapping("/delete")
    public String deletePhone(@RequestParam String IdsPhone){
        System.out.println(IdsPhone);
        String[] idStringArr = IdsPhone.split("");
        Integer[] idArr = new Integer[idStringArr.length];
        for (int i = 0; i <idStringArr.length ; i++) {
            idArr[i] = Integer.parseInt(idStringArr[i]);
        }
        System.out.println(idArr);
        for (int i = 0; i < idArr.length; i++) {
            this.phoneService.deleteById(idArr[i]);
        }
        return "redirect:/phones/list";
    }
}
