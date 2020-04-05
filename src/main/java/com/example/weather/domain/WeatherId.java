package com.example.weather.domain;

import java.util.Objects;
import java.util.UUID;

public final class WeatherId {
    private final UUID id;

    public WeatherId(UUID id) {
        this.id = id;
    }

    public static WeatherId create() {
        return new WeatherId(UUID.randomUUID());
    }

    public UUID id() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeatherId that = (WeatherId) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public String toString() {
        return "WeatherId{" +
                "id=" + id +
                '}';
    }
}
