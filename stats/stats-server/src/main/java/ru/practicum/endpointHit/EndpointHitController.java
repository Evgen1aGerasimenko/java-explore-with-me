package ru.practicum.endpointHit;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.dto.ViewStatsRequestDto;
import ru.practicum.endpointHit.service.EndpointHitService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class EndpointHitController {

    private final EndpointHitService endpointHitService;

    @PostMapping("/hit")
    public EndpointHit hit(@RequestBody EndpointHitDto endpointHit) {
        return endpointHitService.save(endpointHit);
    }

    @GetMapping("/stats")
    public List<ViewStatsDto> getStatsWithParams(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime start,
                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime end,
                                                 @RequestParam(required = false) List<String> uris,
                                                 @RequestParam(defaultValue = "false") boolean unique) {

        ViewStatsRequestDto viewStatsRequestDto = new ViewStatsRequestDto(start, end, uris, unique);
        return endpointHitService.getStatsWithParams(viewStatsRequestDto);
    }
}
