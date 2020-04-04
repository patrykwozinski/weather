package com.example.blocks.domain;

import java.util.ArrayList;

abstract public class AggregateRoot {
    private ArrayList<Event> events;

    protected AggregateRoot() {
        this.events = new ArrayList<>();
    }

    public final ArrayList<Event> pullEvents() {
        ArrayList<Event> recorded = new ArrayList<>(this.events);

        events.clear();

        return recorded;
    }

    protected final void recordThat(final Event e) {
        events.add(e);
    }
}
