package com.shyftlabs.srms.controller;

import com.shyftlabs.srms.model.ResultRequest;
import com.shyftlabs.srms.model.ResultResponse;
import com.shyftlabs.srms.service.ResultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<ResultResponse> getResults() {
        return resultService.getAllResults();
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void createResult(@RequestBody @Valid final ResultRequest resultRequest) {
        resultService.createResult(resultRequest);
    }
}