package org.universities.organization_educational_process.controllers.university.ejournal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.JournalEntrySimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.JournalEntry;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.JournalEntryRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/${application.uri.ejournal}/journal-entry")
@RequiredArgsConstructor
public class JournalEntryController {
    private final JournalEntrySimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody JournalEntryRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<JournalEntry> listAll() { return service.findAll(); }
}
