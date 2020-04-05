package com.example.blocks.unit.domain

import com.example.blocks.domain.AggregateRoot
import com.example.blocks.domain.Event
import spock.lang.Specification

import static java.util.UUID.randomUUID

final class AggregateRootSpec extends Specification {
    private static final UUID expectedId = randomUUID()

    private ExampleAggregate aggregate = new ExampleAggregate(expectedId)

    def 'event recorded when action invoked'() {
        when:
            aggregate.someAction()
            Event event = aggregate.pullEvents().get(0)
        then:
            event.getId().is(expectedId)
    }

    def 'no events when pulled second time'() {
        given:
            aggregate.someAction()
        when:
            aggregate.pullEvents()
            ArrayList<Event> result = aggregate.pullEvents()
        then:
            result.isEmpty()
    }

    private static class ExampleAggregate extends AggregateRoot {
        UUID expectedId

        ExampleAggregate(UUID id) {
            this.expectedId = id
        }

        void someAction() {
            this.recordThat(new ExampleEvent(expectedId))
        }
    }

    private static class ExampleEvent implements Event {
        private final UUID id

        ExampleEvent(UUID id) {
            this.id = id
        }

        @Override
        UUID getId() {
            return this.id
        }
    }
}
