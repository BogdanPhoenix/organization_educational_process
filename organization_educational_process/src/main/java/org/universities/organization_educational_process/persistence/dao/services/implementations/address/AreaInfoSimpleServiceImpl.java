package org.universities.organization_educational_process.persistence.dao.services.implementations.address;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.address.AreaInfoRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.AreaInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.address.AreaInfo;
import org.universities.organization_educational_process.persistence.requests.address.AreaInfoRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AreaInfoSimpleServiceImpl implements AreaInfoSimpleService {
    private final AreaInfoRepository repository;

    @Override
    public List<AreaInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull AreaInfoRequest request) {
        var area = AreaInfo.builder()
                .uaName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .enName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .currentData(true)
                .build();

        if(isExist(area)){
            throw new IllegalStateException("This area is already in place.");
        }

        repository.save(area);
    }

    @Override
    public boolean isExist(@NonNull AreaInfo value) {
        return repository
                .findByEnName(value.getEnName())
                .isPresent();
    }
}
