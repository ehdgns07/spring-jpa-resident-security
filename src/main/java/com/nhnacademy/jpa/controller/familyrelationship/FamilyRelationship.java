package com.nhnacademy.jpa.controller.familyrelationship;

import com.nhnacademy.jpa.domain.familyrelationship.FamilyRelationshipCertificationDto;
import com.nhnacademy.jpa.service.familyrelation.FamilyRelationShipService;
import com.nhnacademy.jpa.service.resident.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/relationship")
@RequiredArgsConstructor
public class FamilyRelationship {

    FamilyRelationShipService familyRelationShipService;
    ResidentService residentService;

    @GetMapping("/{baseResidentSerialNo}")
    public ModelAndView certificate(@PathVariable Integer baseResidentSerialNo){
        ModelAndView mav = new ModelAndView("familyRelationship/familycertification");
        mav.addObject("family",familyRelationShipService.doCertificate(baseResidentSerialNo));
        residentService.getResident(baseResidentSerialNo);

        return mav;
    }
}
