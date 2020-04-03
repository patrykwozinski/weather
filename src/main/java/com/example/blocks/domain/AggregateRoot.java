package com.example.blocks.domain;

import java.util.ArrayList;

abstract public class AggregateRoot {
    private ArrayList<Event> events;

    protected AggregateRoot() {
        this.events = new ArrayList<>();
    }

    final protected void recordThat(final Event e) {
        events.add(e);
    }

    final protected ArrayList<Event> pullEvents() {
        ArrayList<Event> recorded = events;

        events.clear();

        return recorded;
    }
}
