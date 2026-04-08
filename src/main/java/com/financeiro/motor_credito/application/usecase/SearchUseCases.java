package com.financeiro.motor_credito.application.usecase;

import com.financeiro.motor_credito.application.dto.SearchRequestDto;
import com.financeiro.motor_credito.application.dto.SearchResponseDto;

import java.util.List;

/**
 * Search Use Cases
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
public interface SearchUseCases {
    public SearchResponseDto search(SearchRequestDto data);

    public List<SearchResponseDto> getSearches(Long clientId);
}
