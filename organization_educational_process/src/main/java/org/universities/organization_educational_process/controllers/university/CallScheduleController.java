package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.CallScheduleSimpleService;
import org.universities.organization_educational_process.persistence.model.university.CallSchedule;
import org.universities.organization_educational_process.persistence.requests.university.CallScheduleRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/call-schedule")
@RequiredArgsConstructor
public class CallScheduleController {
    private final CallScheduleSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody CallScheduleRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<CallSchedule> listAll() { return service.findAll();}
}
