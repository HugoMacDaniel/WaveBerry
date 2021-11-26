package org.sweppy.waveberry.events.impl;
import org.sweppy.waveberry.events.Event;

public class EventCancelable extends Event {

    private boolean cancelled = false;

    public boolean IsCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
