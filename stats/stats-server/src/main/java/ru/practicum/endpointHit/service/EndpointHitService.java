package ru.practicum.endpointHit.service;

import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.dto.ViewStatsRequestDto;
import ru.practicum.endpointHit.EndpointHit;

import java.util.List;

public interface EndpointHitService {

    EndpointHit save(EndpointHitDto endpointHit);

    List<ViewStatsDto> getStatsWithParams(ViewStatsRequestDto viewStatsRequestDto);
}
