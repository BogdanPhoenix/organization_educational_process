package org.universities.organization_educational_process.persistence.dao.services.implementations;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.BookingAuditoriumRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.BookingAuditoriumSimpleService;
import org.universities.organization_educational_process.persistence.model.BookingAuditorium;
import org.universities.organization_educational_process.persistence.requests.BookingAuditoriumRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingAuditoriumSimpleServiceImpl implements BookingAuditoriumSimpleService {
    private final BookingAuditoriumRepository repository;

    @Override
    public void add(@NonNull BookingAuditoriumRequest request) {
        var bookingAuditorium = BookingAuditorium.builder()
                .audience(request.getAudience())
                .user(request.getUser())
                .startDateTime(request.getStartDateTime())
                .duration(request.getDuration())
                .currentData(true)
                .build();

        if(isExist(bookingAuditorium)){
            throw new IllegalStateException("This booking auditorium is already in place.");
        }

        repository.save(bookingAuditorium);
    }

    @Override
    public boolean isExist(@NonNull BookingAuditorium entity) {
        return repository
                .findByAudienceAndUserAndStartDateTime(
                        entity.getAudience(),
                        entity.getUser(),
                        entity.getStartDateTime()
                ).isPresent();
    }

    @Override
    public List<BookingAuditorium> findAll() {
        return repository.findAll();
    }
}
