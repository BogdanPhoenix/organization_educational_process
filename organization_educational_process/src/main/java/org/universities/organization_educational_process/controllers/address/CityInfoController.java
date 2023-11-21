package org.universities.organization_educational_process.controllers.address;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.CityInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.address.CityInfo;
import org.universities.organization_educational_process.persistence.requests.address.CityInfoRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.address}/city")
@RequiredArgsConstructor
public class CityInfoController {
    private final CityInfoSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody CityInfoRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<CityInfo> listAll() { return service.findAll();}
}
