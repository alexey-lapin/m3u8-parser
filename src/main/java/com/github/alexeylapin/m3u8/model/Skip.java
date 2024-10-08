package com.github.alexeylapin.m3u8.model;

import org.immutables.value.Value;

import java.util.List;

@Value.Immutable
public interface Skip {

    long skippedSegments();

    List<String> recentlyRemovedDateRanges();

    static Builder builder() {
        return new Builder();
    }

    class Builder extends SkipBuilder {

    }

    static Skip of(long skippedSegments) {
        return builder().skippedSegments(skippedSegments).build();
    }
}