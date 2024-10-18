package ru.practicum.endpointHit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.dto.ViewStatsRequestDto;
import ru.practicum.endpointHit.EndpointHit;
import ru.practicum.endpointHit.mapper.EndpointHitMapper;
import ru.practicum.endpointHit.repository.EndpointHitRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EndpointHitServiceImpl implements EndpointHitService {

    private final EndpointHitRepository endpointHitRepository;

    @Override
    public EndpointHit save(EndpointHitDto endpointHitDto) {
        return endpointHitRepository.save(EndpointHitMapper.toEntity(endpointHitDto));
    }

    @Override
    public List<ViewStatsDto> getStatsWithParams(ViewStatsRequestDto viewStatsRequestDto) {
        List<ViewStatsDto> listViewStats;
        boolean paramsIsExists = viewStatsRequestDto.getUris() == null || viewStatsRequestDto.getUris().isEmpty();

        if (!viewStatsRequestDto.getUnique()) {
            if (paramsIsExists) {
                listViewStats = endpointHitRepository.getAllStats(viewStatsRequestDto.getStart(),
                        viewStatsRequestDto.getEnd());
            } else {
                listViewStats = endpointHitRepository.getAllStats(viewStatsRequestDto.getUris(),
                        viewStatsRequestDto.getStart(), viewStatsRequestDto.getEnd());
            }
        } else {
            if (paramsIsExists) {
                listViewStats = endpointHitRepository.getAllStatsWithUniqueIp(viewStatsRequestDto.getStart(),
                        viewStatsRequestDto.getEnd());
            } else {
                listViewStats = endpointHitRepository.getAllStatsWithUniqueIp(viewStatsRequestDto.getUris(),
                        viewStatsRequestDto.getStart(), viewStatsRequestDto.getEnd());
            }
        }

        return listViewStats;
    }
}
