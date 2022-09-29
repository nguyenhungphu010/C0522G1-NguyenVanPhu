package com.controller;

import com.model.Smartphone;
import com.service.ISmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    private ISmartphoneService smartphoneService;

    @GetMapping
    public ResponseEntity<Iterable<Smartphone>> allPhones(){
        return new ResponseEntity<>(smartphoneService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Smartphone> createSmartPhone(@RequestBody Smartphone smartphone){
        return new ResponseEntity<>(smartphoneService.save(smartphone), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ModelAndView getAllSmartphonePage() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("smartphones", smartphoneService.findAll());
        return modelAndView;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Smartphone> deleteSmartPhone(@PathVariable Long id){
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if (!smartphone.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        smartphoneService.remove(id);
        return new ResponseEntity<>(smartphone.get(), HttpStatus.NO_CONTENT);
    }
//    @GetMapping("/showUpdate")
//    public String showUpdate(@RequestParam Long id, Model model){
//        Optional<Smartphone> smartphone = smartphoneService.findById(id);
//        model.addAttribute("smartphone", smartphone);
//        return "list";
//    }

    @GetMapping("/showUpdate")
    public ResponseEntity<Optional<Smartphone> > showUpdate(@RequestParam Long id){
        Optional<Smartphone> smartphone = smartphoneService.findById(id);
        if (smartphone == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(smartphone, HttpStatus.OK);
    }
//    @PostMapping("/save")
//    public String savePhone(@ModelAttribute Smartphone smartphone, Model model){
//        smartphoneService.save(smartphone);
//        return "redirect:/smartphones/list";
//    }

    @PostMapping("/save")
    public ResponseEntity<Smartphone> savePhone(@RequestBody Smartphone smartphone){
        try{
            this.smartphoneService.save(smartphone);
        }catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
