package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.AddressesRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.AddressesSimpleService;

@Service
public class AddressesSimpleServiceImpl implements AddressesSimpleService {
    private AddressesRepository repository;

    @Autowired
    public void setRepository(AddressesRepository repository) { this.repository = repository; }
}
