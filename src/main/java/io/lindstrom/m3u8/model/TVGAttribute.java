package io.lindstrom.m3u8.model;

import java.util.Objects;

/**
 * TV Guide attribute interface
 */
public interface TVGAttribute {

    TVGAttributeKey key();

    String value();

    static TVGAttribute of(TVGAttributeKey key, String value) {
        Objects.requireNonNull(key, "key must not be null");
        Objects.requireNonNull(value, "value must not be null");
        return new DefaultTVGAttribute(key, value);
    }

    class DefaultTVGAttribute implements TVGAttribute {

        private final TVGAttributeKey key;
        private final String value;

        public DefaultTVGAttribute(TVGAttributeKey key, String value) {
            this.key = key;
            this.value = value;
        }

        public TVGAttributeKey key() {
            return key;
        }

        public String value() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DefaultTVGAttribute)) return false;
            DefaultTVGAttribute that = (DefaultTVGAttribute) o;
            return Objects.equals(key, that.key) && Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }

    }

}
