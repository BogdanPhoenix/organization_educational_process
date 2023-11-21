package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.GroupSimpleService;
import org.universities.organization_educational_process.persistence.model.university.Group;
import org.universities.organization_educational_process.persistence.requests.university.GroupRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/group")
@RequiredArgsConstructor
public class GroupController {
    private final GroupSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody GroupRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Group> listAll() { return service.findAll();}
}
