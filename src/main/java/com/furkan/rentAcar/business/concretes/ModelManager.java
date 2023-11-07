package com.furkan.rentAcar.business.concretes;

import com.furkan.rentAcar.business.abstracts.ModelService;
import com.furkan.rentAcar.business.requests.CreateModelRequest;
import com.furkan.rentAcar.business.requests.UpdateModelRequest;
import com.furkan.rentAcar.business.responses.GetAllModelsResponse;
import com.furkan.rentAcar.business.responses.GetByIdBrandResponse;
import com.furkan.rentAcar.business.responses.GetByIdModelResponse;
import com.furkan.rentAcar.core.utilities.mapper.ModelMapperService;
import com.furkan.rentAcar.dataAccess.abstracts.ModelRepository;
import com.furkan.rentAcar.entities.concretes.Brand;
import com.furkan.rentAcar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponses = models.
                stream().map(model -> this.modelMapperService.forResponse()
                 .map(model, GetAllModelsResponse.class))
                .collect(Collectors.toList());

        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public GetByIdModelResponse getByIdModel(int id) {
        Model model = this.modelRepository.findById(id).orElseThrow();
        GetByIdModelResponse response = this.modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
        return response;
    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }

}
