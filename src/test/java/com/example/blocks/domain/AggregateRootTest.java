package com.example.blocks.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class AggregateRootTest {
    private UUID expectedId;
    private ExampleAggregate aggregate;

    @BeforeEach
    public void setUp() {
        expectedId = UUID.randomUUID();
        aggregate = new ExampleAggregate(this.expectedId);
    }

    @Test
    public void eventRecordedWhenActionInvoked() {
        // When
        this.aggregate.someAction();

        // Then
        Event recordedEvent = this.aggregate.pullEvents().get(0);

        assertThat(recordedEvent.getId()).isEqualByComparingTo(this.expectedId);
    }

    @Test
    public void pullingEventsFlushingThem() {
        // Given
        this.aggregate.someAction();


        // When
        this.aggregate.pullEvents();
        ArrayList<Event> secondTimePulled = this.aggregate.pullEvents();

        // Then
        assertThat(secondTimePulled).isEmpty();
    }

    private static class ExampleAggregate extends AggregateRoot {
        final private UUID expectedId;

        ExampleAggregate(UUID expectedId) {
            this.expectedId = expectedId;
        }

        public void someAction() {
            this.recordThat(new ExampleEvent(this.expectedId));
        }
    }

    private static class ExampleEvent implements Event {
        final private UUID id;

        ExampleEvent(UUID id) {
            this.id = id;
        }

        @Override
        public UUID getId() {
            return this.id;
        }
    }
}
