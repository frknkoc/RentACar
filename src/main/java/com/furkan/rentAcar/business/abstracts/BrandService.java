package com.furkan.rentAcar.business.abstracts;

import com.furkan.rentAcar.business.requests.CreateBrandRequest;
import com.furkan.rentAcar.business.requests.UpdateBrandRequest;
import com.furkan.rentAcar.business.responses.GetAllBrandsResponse;
import com.furkan.rentAcar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
