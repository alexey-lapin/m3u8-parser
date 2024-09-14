package com.github.alexeylapin.m3u8.parser;

import com.github.alexeylapin.m3u8.model.MediaPlaylist;
import com.github.alexeylapin.m3u8.model.MediaSegment;
import com.github.alexeylapin.m3u8.model.TVGAttribute;
import com.github.alexeylapin.m3u8.model.TVGAttributeKeys;
import com.github.alexeylapin.m3u8.parser.MediaPlaylistParser;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class TVGAttributesTest {

    private final Path resources = Paths.get("src/test/resources/");

    private final MediaPlaylistParser mediaPlaylistParser = new MediaPlaylistParser();

    @Test
    public void parseTvgAttributes() throws Exception {
        MediaPlaylist playlist = mediaPlaylistParser.readPlaylist(resources.resolve("media/tvg-2.m3u8"));

        MediaSegment mediaSegment1 = playlist.mediaSegments().get(0);
        assertEquals("channel-1", mediaSegment1.title().get());
        assertEquals(TVGAttributeKeys.TVG_ID.getName(), mediaSegment1.tvgAttributes().get(0).key().getName());
        assertEquals("id-1", mediaSegment1.tvgAttributes().get(0).value());
        assertEquals(TVGAttributeKeys.TVG_LOGO.getName(), mediaSegment1.tvgAttributes().get(1).key().getName());
        assertEquals("logo-1", mediaSegment1.tvgAttributes().get(1).value());

        MediaSegment mediaSegment2 = playlist.mediaSegments().get(1);
        assertEquals("channel-2", mediaSegment2.title().get());
        assertEquals(TVGAttributeKeys.TVG_ID.getName(), mediaSegment2.tvgAttributes().get(0).key().getName());
        assertEquals("id-2", mediaSegment2.tvgAttributes().get(0).value());
        assertEquals(TVGAttributeKeys.TVG_LOGO.getName(), mediaSegment2.tvgAttributes().get(1).key().getName());
        assertEquals("logo-2", mediaSegment2.tvgAttributes().get(1).value());

        MediaSegment mediaSegment3 = playlist.mediaSegments().get(2);
        assertEquals("channel-3", mediaSegment3.title().get());
        assertEquals(TVGAttributeKeys.TVG_ID.getName(), mediaSegment3.tvgAttributes().get(0).key().getName());
        assertEquals("id-3", mediaSegment3.tvgAttributes().get(0).value());
        assertEquals(TVGAttributeKeys.TVG_LOGO.getName(), mediaSegment3.tvgAttributes().get(1).key().getName());
        assertEquals("logo-3", mediaSegment3.tvgAttributes().get(1).value());

        MediaSegment mediaSegment4 = playlist.mediaSegments().get(3);
        assertEquals("channel-4", mediaSegment4.title().get());
        assertEquals(TVGAttributeKeys.TVG_ID.getName(), mediaSegment4.tvgAttributes().get(0).key().getName());
        assertEquals("id-4", mediaSegment4.tvgAttributes().get(0).value());
        assertEquals(TVGAttributeKeys.TVG_LOGO.getName(), mediaSegment4.tvgAttributes().get(1).key().getName());
        assertEquals("logo-4", mediaSegment4.tvgAttributes().get(1).value());

        MediaSegment mediaSegment5 = playlist.mediaSegments().get(4);
        assertEquals("channel-5", mediaSegment5.title().get());
        assertEquals(TVGAttributeKeys.TVG_ID.getName(), mediaSegment5.tvgAttributes().get(0).key().getName());
        assertEquals("id-5", mediaSegment5.tvgAttributes().get(0).value());
        assertEquals(TVGAttributeKeys.TVG_LOGO.getName(), mediaSegment5.tvgAttributes().get(1).key().getName());
        assertEquals("logo-5", mediaSegment5.tvgAttributes().get(1).value());
    }

    @Test
    public void writeTvgAttributes() throws Exception {
        MediaPlaylist playlist = MediaPlaylist.builder()
                .targetDuration(2)
                .addMediaSegments(MediaSegment.builder()
                        .title("Channel 1")
                        .duration(1)
                        .addTvgAttributes(TVGAttribute.of(TVGAttributeKeys.TVG_ID, "id-1"))
                        .addTvgAttributes(TVGAttribute.of(TVGAttributeKeys.TVG_LOGO, "http://example.com/logo1.jpg"))
                        .addTvgAttributes(TVGAttribute.of(TVGAttributeKeys.GROUP_TITLE, "Sports"))
                        .uri("http://example.com/stream1.ts")
                        .build())
                .addMediaSegments(MediaSegment.builder()
                        .title("Channel 2")
                        .duration(1.55)
                        .addTvgAttributes(TVGAttribute.of(TVGAttributeKeys.TVG_ID, "id-2"))
                        .addTvgAttributes(TVGAttribute.of(TVGAttributeKeys.TVG_LOGO, "http://example.com/logo2.jpg"))
                        .addTvgAttributes(TVGAttribute.of(TVGAttributeKeys.GROUP_TITLE, "News"))
                        .uri("http://example.com/stream2.ts")
                        .build())
                .build();

        String expected = "#EXTM3U\n" +
                "#EXT-X-TARGETDURATION:2\n" +
                "#EXT-X-MEDIA-SEQUENCE:0\n" +
                "#EXTINF:1.0 tvg-id=\"id-1\" tvg-logo=\"http://example.com/logo1.jpg\" group-title=\"Sports\",Channel 1\n" +
                "http://example.com/stream1.ts\n" +
                "#EXTINF:1.55 tvg-id=\"id-2\" tvg-logo=\"http://example.com/logo2.jpg\" group-title=\"News\",Channel 2\n" +
                "http://example.com/stream2.ts\n";

        assertEquals(expected, mediaPlaylistParser.writePlaylistAsString(playlist));
    }

}
