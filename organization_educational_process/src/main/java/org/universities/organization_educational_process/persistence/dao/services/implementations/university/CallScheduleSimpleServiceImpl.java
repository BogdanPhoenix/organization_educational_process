package org.universities.organization_educational_process.persistence.dao.services.implementations.university;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.university.CallScheduleRepository;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.university.CallScheduleSimpleService;
import org.universities.organization_educational_process.persistence.model.university.CallSchedule;
import org.universities.organization_educational_process.persistence.requests.university.CallScheduleRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CallScheduleSimpleServiceImpl implements CallScheduleSimpleService {
    private final CallScheduleRepository repository;

    @Override
    public List<CallSchedule> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull CallScheduleRequest request) {
        var call = CallSchedule.builder()
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .currentData(true)
                .build();

        if(isExist(call)){
            throw new IllegalStateException("This call schedule is already in place.");
        }

        repository.save(call);
    }

    @Override
    public boolean isExist(@NonNull CallSchedule value){
        return repository
                .findByStartTimeAndEndTime(value.getStartTime(), value.getEndTime())
                .isPresent();
    }
}
