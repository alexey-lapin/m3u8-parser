package io.lindstrom.m3u8.model;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * TV Guide attribute keys
 */
public class TVGAttributeKeys {

    private static final Map<String, TVGAttributeKey> keys = new ConcurrentHashMap<>();

    public static final TVGAttributeKey CHANNEL_ID = register("channel-id");
    public static final TVGAttributeKey CHANNEL_NUMBER = register("channel-number");
    public static final TVGAttributeKey GROUP_TITLE = register("group-title");

    public static final TVGAttributeKey TVG_ARCHIVE = register("tvg-archive");
    public static final TVGAttributeKey TVG_ASPECT_RATIO = register("tvg-aspect-ratio");
    public static final TVGAttributeKey TVG_AUDIO_TRACK = register("tvg-audio-track");
    public static final TVGAttributeKey TVG_CHNO = register("tvg-chno");
    public static final TVGAttributeKey TVG_CLOSED_CAPTIONS = register("tvg-closed-captions");
    public static final TVGAttributeKey TVG_CLOSED_CAPTIONS_LANGUAGE = register("tvg-closed-captions-language");
    public static final TVGAttributeKey TVG_CLOSED_CAPTIONS_TYPE = register("tvg-closed-captions-type");
    public static final TVGAttributeKey TVG_CONTENT_TYPE = register("tvg-content-type");
    public static final TVGAttributeKey TVG_COPYRIGHT = register("tvg-copyright");
    public static final TVGAttributeKey TVG_COUNTRY = register("tvg-country");
    public static final TVGAttributeKey TVG_DURATION = register("tvg-duration");
    public static final TVGAttributeKey TVG_EPGID = register("tvg-epgid");
    public static final TVGAttributeKey TVG_EPGSHIFT = register("tvg-epgshift");
    public static final TVGAttributeKey TVG_EPGURL = register("tvg-epgurl");
    public static final TVGAttributeKey TVG_EXT_X_DISCONTINUITY = register("tvg-ext-x-discontinuity");
    public static final TVGAttributeKey TVG_EXT_X_ENDLIST = register("tvg-ext-x-endlist");
    public static final TVGAttributeKey TVG_EXT_X_KEY = register("tvg-ext-x-key");
    public static final TVGAttributeKey TVG_EXT_X_MEDIA_SEQUENCE = register("tvg-ext-x-media-sequence");
    public static final TVGAttributeKey TVG_EXT_X_PROGRAM_DATE_TIME = register("tvg-ext-x-program-date-time");
    public static final TVGAttributeKey TVG_EXT_X_VERSION = register("tvg-ext-x-version");
    public static final TVGAttributeKey TVG_FRAMERATE = register("tvg-framerate");
    public static final TVGAttributeKey TVG_GAP = register("tvg-gap");
    public static final TVGAttributeKey TVG_GROUP = register("tvg-group");
    public static final TVGAttributeKey TVG_ID = register("tvg-id");
    public static final TVGAttributeKey TVG_INDEPENDENT_SEGMENTS = register("tvg-independent-segments");
    public static final TVGAttributeKey TVG_LANGUAGE = register("tvg-language");
    public static final TVGAttributeKey TVG_LOGO = register("tvg-logo");
    public static final TVGAttributeKey TVG_MEDIA = register("tvg-media");
    public static final TVGAttributeKey TVG_MEDIA_SEQUENCE = register("tvg-media-sequence");
    public static final TVGAttributeKey TVG_NAME = register("tvg-name");
    public static final TVGAttributeKey TVG_PLAYLIST_TYPE = register("tvg-playlist-type");
    public static final TVGAttributeKey TVG_RADIO = register("tvg-radio");
    public static final TVGAttributeKey TVG_RESOLUTION = register("tvg-resolution");
    public static final TVGAttributeKey TVG_START = register("tvg-start");
    public static final TVGAttributeKey TVG_TARGETDURATION = register("tvg-targetduration");
    public static final TVGAttributeKey TVG_TIMESHIFT = register("tvg-timeshift");
    public static final TVGAttributeKey TVG_TVGPLAYLIST = register("tvg-tvgplaylist");
    public static final TVGAttributeKey TVG_TYPE = register("tvg-type");
    public static final TVGAttributeKey TVG_URL = register("tvg-url");
    public static final TVGAttributeKey TVG_X_BYTERANGE = register("tvg-x-byterange");
    public static final TVGAttributeKey TVG_X_ENDLIST = register("tvg-x-endlist");
    public static final TVGAttributeKey TVG_X_KEY = register("tvg-x-key");
    public static final TVGAttributeKey TVG_X_MEDIA_SEQUENCE = register("tvg-x-media-sequence");
    public static final TVGAttributeKey TVG_X_PROGRAM_DATE_TIME = register("tvg-x-program-date-time");
    public static final TVGAttributeKey TVG_X_VERSION = register("tvg-x-version");

    public static TVGAttributeKey register(String name) {
        Objects.requireNonNull(name, "name is null");
        TVGAttributeKey tvgAttributeKey = TVGAttributeKey.of(name);
        keys.put(name, tvgAttributeKey);
        return tvgAttributeKey;
    }

    public static TVGAttributeKey forName(String name) {
        Objects.requireNonNull(name, "name is null");
        return keys.get(name);
    }

}
