package org.universities.organization_educational_process.controllers.address;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.AddressSimpleService;
import org.universities.organization_educational_process.persistence.model.address.Address;
import org.universities.organization_educational_process.persistence.requests.address.AddressRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/${application.uri.main}/${application.uri.address}")
@RequiredArgsConstructor
public class AddressController {
    private final AddressSimpleService service;

    @PostMapping("/add")
    public ResponseEntity<?> add(
            @RequestBody AddressRequest request
    ){
        service.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<Address> listAll() { return service.findAll();}
}
