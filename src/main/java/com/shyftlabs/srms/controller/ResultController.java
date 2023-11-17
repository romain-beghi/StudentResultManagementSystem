package com.shyftlabs.srms.controller;

import com.shyftlabs.srms.model.ResultResponse;
import com.shyftlabs.srms.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
}