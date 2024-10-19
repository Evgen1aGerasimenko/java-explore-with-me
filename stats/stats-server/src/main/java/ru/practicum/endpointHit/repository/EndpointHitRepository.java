package ru.practicum.endpointHit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.endpointHit.EndpointHit;

import java.time.LocalDateTime;
import java.util.List;

public interface EndpointHitRepository extends JpaRepository<EndpointHit, Long> {

    @Query(value = "select new ru.practicum.dto.ViewStatsDto(eh.app, eh.uri, count(eh.ip)) " +
            "from EndpointHit eh " +
            "where eh.timestamp >= :start and eh.timestamp <= :end and eh.uri in :uris " +
            "group by eh.uri, eh.app " +
            "order by count(eh.ip) desc")
    List<ViewStatsDto> getAllStats(@Param("uris") List<String> uris,
                                   @Param("start") LocalDateTime start,
                                   @Param("end") LocalDateTime end);

    @Query(value = "select new ru.practicum.dto.ViewStatsDto(eh.app, eh.uri, count(eh.ip)) " +
            "from EndpointHit eh " +
            "where eh.timestamp >= :start and eh.timestamp <= :end " +
            "group by eh.uri, eh.app " +
            "order by count(eh.ip) desc")
    List<ViewStatsDto> getAllStats(@Param("start") LocalDateTime start,
                                   @Param("end") LocalDateTime end);

    @Query(value = "select new ru.practicum.dto.ViewStatsDto(eh.app, eh.uri, count(distinct eh.ip)) " +
            "from EndpointHit eh " +
            "where eh.timestamp >= :start and eh.timestamp <= :end " +
            "group by eh.uri, eh.app " +
            "order by count(distinct eh.ip) desc")
    List<ViewStatsDto> getAllStatsWithUniqueIp(@Param("start") LocalDateTime start,
                                               @Param("end") LocalDateTime end);

    @Query(value = "select new ru.practicum.dto.ViewStatsDto(eh.app, eh.uri, count(distinct eh.ip)) " +
            "from EndpointHit eh " +
            "where eh.timestamp >= :start and eh.timestamp <= :end and eh.uri in :uris " +
            "group by eh.uri, eh.app " +
            "order by count(distinct eh.ip) desc")
    List<ViewStatsDto> getAllStatsWithUniqueIp(@Param("uris") List<String> uris,
                                               @Param("start") LocalDateTime start,
                                               @Param("end") LocalDateTime end);
}
