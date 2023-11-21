package org.universities.organization_educational_process.controllers.reference_book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.reference_book.AcademicDegreeSimpleService;
import org.universities.organization_educational_process.persistence.model.reference_book.AcademicDegree;
import org.universities.organization_educational_process.persistence.requests.reference_book.AcademicDegreeRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.reference_book}/academic-degree")
@RequiredArgsConstructor
public class AcademicDegreeController {
    private final AcademicDegreeSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody AcademicDegreeRequest request
    ) {
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<AcademicDegree> listAll() {
        return service.findAll();
    }
}
