package org.universities.organization_educational_process.controllers.address;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.RegionInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.address.RegionInfo;
import org.universities.organization_educational_process.persistence.requests.address.RegionInfoRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.address}/region")
@RequiredArgsConstructor
public class RegionInfoController {
    private final RegionInfoSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody RegionInfoRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<RegionInfo> listAll() { return service.findAll();}
}
