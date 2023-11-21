package org.universities.organization_educational_process.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.BookingAuditoriumSimpleService;
import org.universities.organization_educational_process.persistence.model.BookingAuditorium;
import org.universities.organization_educational_process.persistence.requests.BookingAuditoriumRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/booking-auditorium")
@RequiredArgsConstructor
public class BookingAuditoriumController {
    private final BookingAuditoriumSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody BookingAuditoriumRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<BookingAuditorium> listAll() { return service.findAll();}
}
