package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ClassScheduleSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ClassSchedule;
import org.universities.organization_educational_process.persistence.requests.university.ClassScheduleRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/class-schedule")
@RequiredArgsConstructor
public class ClassScheduleController {
    private final ClassScheduleSimpleService service;
    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody ClassScheduleRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<ClassSchedule> listAll() { return service.findAll();}
}
