package org.universities.organization_educational_process.controllers.university;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.TeacherSimpleService;
import org.universities.organization_educational_process.persistence.requests.university.TeacherRequest;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.university}/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody TeacherRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }
}
