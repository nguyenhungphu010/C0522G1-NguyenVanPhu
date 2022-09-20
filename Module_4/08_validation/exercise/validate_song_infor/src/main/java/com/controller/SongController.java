package com.controller;

import com.dto.SongInforDto;
import com.model.SongInfor;
import com.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("listSong", iSongService.listAll());
        return "list";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("song", new SongInforDto());
        return "create";
    }

    @PostMapping("createSong")
    public String save(@Validated @ModelAttribute(name = "song") SongInforDto songInforDto,
                       BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "create";
        }
        SongInfor songInfor = new SongInfor();
        BeanUtils.copyProperties(songInforDto, songInfor);
        iSongService.create(songInfor);
        return "redirect:/";
    }

    @GetMapping("update")
    public String showUpdateForm(@RequestParam int id, Model model) {
        model.addAttribute("songUpdate", iSongService.findById(id));
        return "update";
    }

    @PostMapping("updateSong")
    public String updateSong(@Validated @ModelAttribute("songUpdate") SongInforDto songInforDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "update";
        }
        SongInfor songInfor = new SongInfor();
        BeanUtils.copyProperties(songInforDto, songInfor);
        iSongService.update(songInfor);
        return "redirect:/";
    }
}
