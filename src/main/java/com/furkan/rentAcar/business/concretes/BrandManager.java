package com.furkan.rentAcar.business.concretes;

import com.furkan.rentAcar.business.abstracts.BrandService;
import com.furkan.rentAcar.business.requests.CreateBrandRequest;
import com.furkan.rentAcar.business.requests.UpdateBrandRequest;
import com.furkan.rentAcar.business.responses.GetAllBrandsResponse;
import com.furkan.rentAcar.business.responses.GetByIdBrandResponse;
import com.furkan.rentAcar.core.utilities.mapper.ModelMapperService;
import com.furkan.rentAcar.dataAccess.abstracts.BrandRepository;
import com.furkan.rentAcar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
   private BrandRepository brandRepository;
   private ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        /*
        for (Brand brand: brands) {
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setId(brand.getId());
            responseItem.setName(brand.getName());
            brandsResponses.add(responseItem);
        }
        */

        List<GetAllBrandsResponse> brandsResponses = brands.
                stream().map(brand -> this.modelMapperService
                        .forResponse().map(brand, GetAllBrandsResponse.class))
                .collect(Collectors.toList());
        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
       Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
       // Brand brand = new Brand();
       // brand.setName(createBrandRequest.getName());
       this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
