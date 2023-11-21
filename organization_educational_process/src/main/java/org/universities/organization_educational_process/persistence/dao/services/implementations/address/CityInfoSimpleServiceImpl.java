package org.universities.organization_educational_process.persistence.dao.services.implementations.address;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.universities.organization_educational_process.persistence.dao.repositories.address.CityInfoRepository;
import org.universities.organization_educational_process.tools.SupportingTools;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.address.CityInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.address.CityInfo;
import org.universities.organization_educational_process.persistence.requests.address.CityInfoRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityInfoSimpleServiceImpl implements CityInfoSimpleService {
    private final CityInfoRepository repository;

    @Override
    public List<CityInfo> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(@NonNull CityInfoRequest request) {
        var city = CityInfo.builder()
                .enName(SupportingTools
                        .formationCorrectValue(request.getEnName()))
                .uaName(SupportingTools
                        .formationCorrectValue(request.getUaName()))
                .currentData(true)
                .build();

        if(isExist(city)){
            throw new IllegalStateException("This city is already in place.");
        }

        repository.save(city);
    }

    @Override
    public boolean isExist(@NonNull CityInfo city){
        return repository.findByEnNameAndUaName(city.getEnName(), city.getUaName()).isPresent();
    }
}
