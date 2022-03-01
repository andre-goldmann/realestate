/*
 * Created: 26.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.domain;

import java.util.Objects;

/**
 * @author Andre Goldmann
 */
public final class TypeParameter<T> {

    private final Class<T> type;
    private String url;

    public TypeParameter(final Class<T> type, final String url) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(url);
        this.type = type;
        this.url = url;
    }

    public Class<T> getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TypeParameter<?> that = (TypeParameter<?>) o;
        return type.equals(that.type) && url.equals(that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, url);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TypeParameter{");
        sb.append("type=").append(type);
        sb.append(", url='").append(url).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
