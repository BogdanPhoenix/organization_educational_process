package org.universities.organization_educational_process.persistence.dao.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.BookingAuditoriumsRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.BookingAuditoriumsSimpleService;

@Service
public class BookingAuditoriumsSimpleServiceImpl implements BookingAuditoriumsSimpleService {
    private BookingAuditoriumsRepository repository;

    @Autowired
    public void setRepository(BookingAuditoriumsRepository repository) {
        this.repository = repository;
    }
}
