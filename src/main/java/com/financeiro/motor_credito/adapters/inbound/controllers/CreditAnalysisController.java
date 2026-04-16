package com.financeiro.motor_credito.adapters.inbound.controllers;

import com.financeiro.motor_credito.application.dto.AnalysisRequestDto;
import com.financeiro.motor_credito.application.dto.AnalysisResponseDto;
import com.financeiro.motor_credito.application.usecase.CreditAnalysisUseCases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Credit Analysis Controller
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
@RestController
@RequestMapping("/api/analyze")
public class CreditAnalysisController {

    private final CreditAnalysisUseCases creditAnalysisUseCases;

    public CreditAnalysisController(CreditAnalysisUseCases creditAnalysisUseCases) {
        this.creditAnalysisUseCases = creditAnalysisUseCases;
    }

    @PostMapping
    public ResponseEntity<AnalysisResponseDto> doSearch(@RequestBody AnalysisRequestDto requestDto) {
        System.out.println("analysis request: " + requestDto);
        AnalysisResponseDto response = creditAnalysisUseCases.analyze(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AnalysisResponseDto>> getSearches(@PathVariable("id") Long clientId) {
        List<AnalysisResponseDto> responseDtoList = creditAnalysisUseCases.getAnalysis(clientId);
        return ResponseEntity.ok(responseDtoList);
    }

}
