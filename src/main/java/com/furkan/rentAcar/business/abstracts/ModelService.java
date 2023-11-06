package com.furkan.rentAcar.business.abstracts;

import com.furkan.rentAcar.business.requests.CreateBrandRequest;
import com.furkan.rentAcar.business.requests.CreateModelRequest;
import com.furkan.rentAcar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}

