package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.DisciplineSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Discipline;
import org.universities.organization_educational_process.persistence.requests.university.DisciplineRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/discipline")
@RequiredArgsConstructor
public class DisciplineController {
    private final DisciplineSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody DisciplineRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Discipline> listAll() { return service.findAll();}
}
