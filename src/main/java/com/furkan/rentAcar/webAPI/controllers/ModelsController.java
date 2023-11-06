package com.furkan.rentAcar.webAPI.controllers;

import com.furkan.rentAcar.business.abstracts.ModelService;
import com.furkan.rentAcar.business.requests.CreateBrandRequest;
import com.furkan.rentAcar.business.requests.CreateModelRequest;
import com.furkan.rentAcar.business.responses.GetAllModelsResponse;
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

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }

}

