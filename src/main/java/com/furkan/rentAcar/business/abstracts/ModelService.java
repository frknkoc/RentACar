package com.furkan.rentAcar.business.abstracts;

import com.furkan.rentAcar.business.requests.CreateModelRequest;
import com.furkan.rentAcar.business.requests.UpdateModelRequest;
import com.furkan.rentAcar.business.responses.GetAllModelsResponse;
import com.furkan.rentAcar.business.responses.GetByIdModelResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
    GetByIdModelResponse getByIdModel(int id);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);

}

