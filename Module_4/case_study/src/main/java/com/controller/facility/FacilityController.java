package com.controller.facility;


import com.dto.FacilityDto;
import com.model.facility.Facility;
import com.service.facility.IFacilityService;
import com.service.facility.IFacilityTypeService;
import com.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/facilities")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;
    @Autowired
    private IFacilityTypeService facilityTypeService;
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("/list")
    public String showFacilityList(@PageableDefault(size = 5) Pageable pageable, Model model, @RequestParam(defaultValue = "") String searchParam){
        model.addAttribute("facilityList", facilityService.findAll(pageable, searchParam));
        model.addAttribute("searchParam", searchParam);
        return "/facility/facilityList";
    }

    @GetMapping("/create")
    public String showCreateForm( Model model) {
        model.addAttribute("facilityDto", new FacilityDto() );
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "/facility/facilityAdd";
    }
    @PostMapping("/save")
    public String saveFacility(@ModelAttribute(value = "facilityDto")@Valid FacilityDto facilityDto,
                               BindingResult bindingResult, Model model){
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("facilityTypeList",facilityTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "/facility/facilityAdd";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return "redirect:/facilities/list";
    }
    @PostMapping("/delete")
    public String deleteFacility(@RequestParam int IdFacility){
        facilityService.deleteById(IdFacility);
        return "redirect:/facilities/list";
    }
    @GetMapping("/showEdit")
    public String showEditForm(@RequestParam int id,  Model model){
        Facility facility = facilityService.findById(id).orElse(null);
        FacilityDto facilityDto = new FacilityDto();
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facilityDto",facilityDto);
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "/facility/facilityEdit";
    }
    @PostMapping("/saveEdit")
    public String saveEditFacility(@ModelAttribute(value = "facilityDto") @Valid FacilityDto facilityDto,
                                   BindingResult bindingResult, Model model){
        new FacilityDto().validate(facilityDto, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("facilityTypeList",facilityTypeService.findAll());
            model.addAttribute("rentTypeList", rentTypeService.findAll());
            return "/facility/facilityEdit";
        }
        Facility facility = new Facility();
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.save(facility);
        return "redirect:/facilities/list";
    }
}
