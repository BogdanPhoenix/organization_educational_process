package org.universities.organization_educational_process.persistence.dao.services.implementations.university.ejournal;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.ejournal.AttendanceRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.ejournal.AttendanceSimpleService;
import org.universities.organization_educational_process.persistence.model.university.ejournal.Attendance;
import org.universities.organization_educational_process.persistence.requests.university.ejournal.AttendanceRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceSimpleServiceImpl implements AttendanceSimpleService {
    private final AttendanceRepository repository;

    @Override
    public void add(@NonNull AttendanceRequest request) {
        var attendance = Attendance.builder()
                .entryStudent(request.getEntryStudent())
                .presence(request.getPresence())
                .currentData(true)
                .build();

        if(isExist(attendance)){
            throw new IllegalStateException("This call is already in place.");
        }

        repository.save(attendance);
    }

    @Override
    public boolean isExist(Attendance entity) {
        return repository
                .findByEntryStudent(entity.getEntryStudent())
                .isPresent();
    }

    @Override
    public List<Attendance> findAll() {
        return repository.findAll();
    }
}
