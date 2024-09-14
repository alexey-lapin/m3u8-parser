package com.github.alexeylapin.m3u8.model;

import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
public interface ContentSteering {
    String serverUri();

    Optional<String> pathwayId();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends ContentSteeringBuilder {
    }

    static ContentSteering of(String serverUri, String pathwayId) {
        return builder()
                .serverUri(serverUri)
                .pathwayId(pathwayId)
                .build();
    }
}