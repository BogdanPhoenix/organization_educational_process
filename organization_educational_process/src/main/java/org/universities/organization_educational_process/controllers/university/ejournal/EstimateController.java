package org.universities.organization_educational_process.controllers.university.ejournal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.EstimateSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Estimate;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.EstimateRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/${application.uri.ejournal}/estimate")
@RequiredArgsConstructor
public class EstimateController {
    private final EstimateSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody EstimateRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Estimate> listAll() { return service.findAll(); }
}
