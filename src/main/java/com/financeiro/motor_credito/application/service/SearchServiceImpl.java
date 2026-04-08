package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.application.dto.SearchRequestDto;
import com.financeiro.motor_credito.application.dto.SearchResponseDto;
import com.financeiro.motor_credito.application.usecase.SearchUseCases;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Search Service
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
@Service
public class SearchServiceImpl implements SearchUseCases {

    @Override
    public SearchResponseDto search(SearchRequestDto data) {
        return null;
    }

    @Override
    public List<SearchResponseDto> getSearches(Long clientId) {
        return List.of();
    }
}
