package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.SpecialtySimpleService;
import org.universities.organization_educational_process.persistence.model.university.Specialty;
import org.universities.organization_educational_process.persistence.requests.university.SpecialtyRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/specialty")
@RequiredArgsConstructor
public class SpecialtyController {
    private final SpecialtySimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody SpecialtyRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Specialty> listAll() { return service.findAll();}
}
