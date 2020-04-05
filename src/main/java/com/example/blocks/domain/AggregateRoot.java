package com.example.blocks.domain;

import java.util.ArrayList;
import java.util.List;

abstract public class AggregateRoot {
    private List<Event> events;

    protected AggregateRoot() {
        this.events = new ArrayList<>();
    }

    public final List<Event> pullEvents() {
        ArrayList<Event> recorded = new ArrayList<>(this.events);

        events.clear();

        return recorded;
    }

    protected final void recordThat(final Event e) {
        events.add(e);
    }
}
