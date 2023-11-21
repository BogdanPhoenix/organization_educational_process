package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.EnclosureSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Enclosure;
import org.universities.organization_educational_process.persistence.requests.university.EnclosureRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/enclosure")
@RequiredArgsConstructor
public class EnclosureController {
    private final EnclosureSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody EnclosureRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Enclosure> listAll() { return service.findAll();}
}
