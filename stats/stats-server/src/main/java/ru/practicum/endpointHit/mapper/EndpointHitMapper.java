package ru.practicum.endpointHit.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.endpointHit.EndpointHit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class EndpointHitMapper {
    public static EndpointHit toEntity(EndpointHitDto dto) {
        if (dto == null) {
            return null;
        }
        EndpointHit endpointHit = new EndpointHit();
        endpointHit.setApp(dto.getApp());
        endpointHit.setUri(dto.getUri());
        endpointHit.setIp(dto.getIp());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime timestamp = LocalDateTime.parse(dto.getTimestamp(), dateTimeFormatter);
        endpointHit.setTimestamp(timestamp);
        return endpointHit;
    }
}
