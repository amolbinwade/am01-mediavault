package com.am01.mediavault.uploadservice.health;


import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class UploadServiceReadinessIndicator extends ReadinessStateHealthIndicator {

    private final AtomicBoolean ready = new AtomicBoolean();

    public UploadServiceReadinessIndicator(ApplicationAvailability availability) {
        super(availability);
    }

    @Override
    protected AvailabilityState getState(ApplicationAvailability applicationAvailability) {
        return ready.get()
                ? ReadinessState.ACCEPTING_TRAFFIC
                : ReadinessState.REFUSING_TRAFFIC;
    }

    public void markAsReady() {
        if (ready.get()) {
            throw new IllegalStateException("Already initialized");
        }
        ready.set(true);
    }
}
