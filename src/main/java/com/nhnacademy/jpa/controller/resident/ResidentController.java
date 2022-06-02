package com.nhnacademy.jpa.controller.resident;

import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.service.resident.ResidentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/resident")
@RequiredArgsConstructor
public class ResidentController {

    private final ResidentService residentService;

    @GetMapping("/index")
    ModelAndView ViewResident(Pageable pageable){
        Page<Resident> pagedResident = residentService.PagedResident(pageable);
        List<Resident> resident = pagedResident.getContent();
        ModelAndView mav = new ModelAndView("resident/index");

        mav.addObject("totalPage", pagedResident.getTotalPages());
        mav.addObject("residents", resident);
        mav.addObject("page", pageable);


        return mav;
    }

}
