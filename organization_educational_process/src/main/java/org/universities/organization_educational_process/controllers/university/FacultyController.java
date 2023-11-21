package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.implementations.university.FacultySimpleServiceImpl;
import org.universities.organization_educational_process.persistence.model.university.Faculty;
import org.universities.organization_educational_process.persistence.requests.university.FacultyRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/faculty")
@RequiredArgsConstructor
public class FacultyController {
    private final FacultySimpleServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody FacultyRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Faculty> listAll() { return service.findAll();}
}
