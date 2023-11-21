package org.universities.organization_educational_process.controllers.university.ejournal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.EJournalSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.EJournal;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.EJournalRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/${application.uri.ejournal}")
@RequiredArgsConstructor
public class EJournalController {
    private final EJournalSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody EJournalRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<EJournal> listAll() { return service.findAll();}
}
