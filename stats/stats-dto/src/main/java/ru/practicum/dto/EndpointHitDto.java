package ru.practicum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EndpointHitDto {
    private String app;
    private String uri;
    private String ip;
    private String timestamp;
}
