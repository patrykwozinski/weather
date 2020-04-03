package com.example.blocks.domain;

import java.util.ArrayList;

abstract public class AggregateRoot {
    private ArrayList<Event> events;

    final protected void recordThat(Event e) {
        events.add(e);
    }

    final protected ArrayList<Event> pullEvents() {
        ArrayList<Event> recorded = events;

        events.clear();

        return recorded;
    }
}
