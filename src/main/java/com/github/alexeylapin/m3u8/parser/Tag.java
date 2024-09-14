package com.github.alexeylapin.m3u8.parser;

interface Tag<T, B> {
    void read(B builder, String attributes, ParsingMode parsingMode) throws PlaylistParserException;
    void write(T playlist, TextBuilder textBuilder);
    String name();

    default String tag() {
        String name = name();
        return name.contains("_") ? name.replace("_", "-") : name;
    }
}
