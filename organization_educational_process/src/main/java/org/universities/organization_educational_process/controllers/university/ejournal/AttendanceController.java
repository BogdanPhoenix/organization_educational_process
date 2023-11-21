package org.universities.organization_educational_process.controllers.university.ejournal;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.AttendanceSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Attendance;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.AttendanceRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/${application.uri.ejournal}/attendance")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody AttendanceRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Attendance> listAll() { return service.findAll();}
}
