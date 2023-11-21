package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.UniversitySimpleService;
import org.universities.organization_educational_process.persistence.model.university.University;
import org.universities.organization_educational_process.persistence.requests.university.UniversityRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversitySimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody UniversityRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<University> listAll() { return service.findAll();}
}
