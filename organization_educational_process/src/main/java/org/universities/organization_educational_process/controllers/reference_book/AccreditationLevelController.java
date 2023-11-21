package org.universities.organization_educational_process.controllers.reference_book;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.reference_book.AccreditationLevelSimpleService;
import org.universities.organization_educational_process.persistence.model.reference_book.AccreditationLevel;
import org.universities.organization_educational_process.persistence.requests.reference_book.AccreditationLevelRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.reference_book}/accreditation-level")
@RequiredArgsConstructor
public class AccreditationLevelController {
    private final AccreditationLevelSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody AccreditationLevelRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<AccreditationLevel> listAll() {
        return service.findAll();
    }
}
