package org.universities.organization_educational_process.controllers.address;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.AreaInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.address.AreaInfo;
import org.universities.organization_educational_process.persistence.requests.address.AreaInfoRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.address}/area")
@RequiredArgsConstructor
public class AreaInfoController {
    private final AreaInfoSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody AreaInfoRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<AreaInfo> listAll() { return service.findAll();}
}
