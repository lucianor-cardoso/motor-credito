package com.financeiro.motor_credito.adapters.inbound.controllers;

import com.financeiro.motor_credito.application.dto.SearchRequestDto;
import com.financeiro.motor_credito.application.dto.SearchResponseDto;
import com.financeiro.motor_credito.application.usecase.SearchUseCases;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Search Controller
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
@RestController
@RequestMapping("/api/search")
public class SearchController {

    private SearchUseCases searchUseCases;

    public SearchController(SearchUseCases searchUseCases) {
        this.searchUseCases = searchUseCases;
    }

    @PostMapping
    public ResponseEntity<SearchResponseDto> doSearch(@RequestBody SearchRequestDto requestDto) {
        SearchResponseDto response = searchUseCases.search(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<SearchResponseDto>> getSearches(@PathVariable("id") Long clientId) {
        List<SearchResponseDto> responseDtoList = searchUseCases.getSearches(clientId);
        return ResponseEntity.ok(responseDtoList);
    }

}
