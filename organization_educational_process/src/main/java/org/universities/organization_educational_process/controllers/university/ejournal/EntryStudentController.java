package org.universities.organization_educational_process.controllers.university.ejournal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.EntryStudentSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EntryStudent;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.EntryStudentRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/${application.uri.ejournal}/entry-student")
@RequiredArgsConstructor
public class EntryStudentController {
    private final EntryStudentSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody EntryStudentRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<EntryStudent> listAll() { return service.findAll();}
}
