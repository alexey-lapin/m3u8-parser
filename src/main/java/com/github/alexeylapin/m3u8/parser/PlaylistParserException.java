package com.github.alexeylapin.m3u8.parser;

import java.io.IOException;

public class PlaylistParserException extends IOException {
    public PlaylistParserException(String message) {
        super(message);
    }
}
