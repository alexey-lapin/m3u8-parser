package com.github.alexeylapin.m3u8.model;

import java.util.Objects;

/**
 * TV Guide attribute key interface
 */
public interface TVGAttributeKey {

    String getName();

    static TVGAttributeKey of(String name) {
        return new DefaultTVGAttributeKey(name);
    }

    class DefaultTVGAttributeKey implements TVGAttributeKey {

        private final String name;

        public DefaultTVGAttributeKey(String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DefaultTVGAttributeKey)) return false;
            DefaultTVGAttributeKey that = (DefaultTVGAttributeKey) o;
            return Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        @Override
        public String toString() {
            return name;
        }

    }

}
