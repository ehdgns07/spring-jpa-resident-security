package com.nhnacademy.jpa.controller.resident;


import com.nhnacademy.jpa.domain.FamilyRelationShipDto;
import com.nhnacademy.jpa.domain.ResidentRegisterDto;
import com.nhnacademy.jpa.entity.family.relationship.FamilyRelationship;
import com.nhnacademy.jpa.entity.resident.Resident;
import com.nhnacademy.jpa.service.familyrelation.FamilyRelationShipService;
import com.nhnacademy.jpa.service.resident.ResidentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/residents")
public class ResidentController {

private final ResidentService residentService;
private final FamilyRelationShipService familyRelationshipService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Resident registerResident(@RequestBody Resident resident){ return residentService.createResident(resident); }


    @PutMapping("/{serialNumber}")
    public Integer modifyResident(@RequestBody ResidentRegisterDto residentRegisterDto, @PathVariable Integer serialNumber)
    { return residentService.editResident(residentRegisterDto, serialNumber); }

    @PostMapping("/{serialNumber}/relationship")
    public FamilyRelationship registerFamilyRelationship(@RequestBody FamilyRelationship familyRelationship,
                                                         @PathVariable Integer serialNumber){

        return familyRelationshipService.registerRelationShip(familyRelationship, serialNumber);
    }

    @PutMapping("/{serialNumber}/relationship/{familySerialNumber}")
    public Integer modifyFamilyRelationship(@RequestBody FamilyRelationShipDto familyRelationShipDto,
                                            @PathVariable Integer serialNumber,
                                            @PathVariable Integer familySerialNumber){
        return familyRelationshipService.editFamilyRelationship(familyRelationShipDto,
                                                                serialNumber, familySerialNumber);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @DeleteMapping("/{serialNumber}/relationship/{familySerialNumber}")
    public void eraseFamilyRelationship(@PathVariable Integer serialNumber, @PathVariable Integer familySerialNumber){
        System.out.println();
        familyRelationshipService.removeFamilyRelationship(serialNumber,familySerialNumber);
    }
}
