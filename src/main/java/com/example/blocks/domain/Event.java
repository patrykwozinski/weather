package com.example.blocks.domain;

import java.time.Instant;
import java.util.UUID;

public interface Event {

    UUID getId();

    Instant occurredAt();

}
