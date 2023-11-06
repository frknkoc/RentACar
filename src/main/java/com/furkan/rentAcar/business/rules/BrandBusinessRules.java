package com.furkan.rentAcar.business.rules;

import com.furkan.rentAcar.core.utilities.exceptions.BusinessException;
import com.furkan.rentAcar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existByName(name)){
            throw new BusinessException("Brand name already exists");
        }
    }
}
