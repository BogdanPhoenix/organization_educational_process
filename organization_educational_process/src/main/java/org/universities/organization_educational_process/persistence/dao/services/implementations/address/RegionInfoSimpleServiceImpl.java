package org.universities.organization_educational_process.persistence.dao.services.implementations.address;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.address.RegionInfoRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.RegionInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.address.RegionInfo;
import org.universities.organization_educational_process.persistence.requests.address.RegionInfoRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionInfoSimpleServiceImpl implements RegionInfoSimpleService {
    private final RegionInfoRepository repository;

    @Override
    public void add(@NonNull RegionInfoRequest request) {
        var region = RegionInfo.builder()
                .uaName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .enName(SupportingTools
                        .formationCorrectValue(request.getEnName()))
                .currentData(true)
                .build();

        if(isExist(region)){
            throw new IllegalStateException("This region is already in place.");
        }

        repository.save(region);
    }

    @Override
    public boolean isExist(@NonNull RegionInfo entity) {
        return repository
                .findByEnName(entity.getEnName())
                .isPresent();
    }

    @Override
    public List<RegionInfo> findAll() {
        return repository.findAll();
    }
}
