package com.furkan.rentAcar.webAPI.controllers;

import com.furkan.rentAcar.business.abstracts.ModelService;
import com.furkan.rentAcar.business.requests.CreateModelRequest;
import com.furkan.rentAcar.business.requests.UpdateModelRequest;
import com.furkan.rentAcar.business.responses.GetAllModelsResponse;
import com.furkan.rentAcar.business.responses.GetByIdBrandResponse;
import com.furkan.rentAcar.business.responses.GetByIdModelResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;
    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdModelResponse getByIdModel(@PathVariable int id){
        return modelService.getByIdModel(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateModelRequest updateModelRequest){
        this.modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.modelService.delete(id);
    }


}

