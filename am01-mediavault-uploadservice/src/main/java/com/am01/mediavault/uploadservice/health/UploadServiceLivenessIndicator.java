package com.am01.mediavault.uploadservice.health;

import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.AvailabilityState;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class UploadServiceLivenessIndicator extends LivenessStateHealthIndicator {

    private final AtomicBoolean ready = new AtomicBoolean();

    public UploadServiceLivenessIndicator(ApplicationAvailability availability) {
        super(availability);
    }

    @Override
    protected AvailabilityState getState(ApplicationAvailability applicationAvailability) {
        return ready.get()
                ? LivenessState.CORRECT
                : LivenessState.BROKEN;
    }

    public void markAsReady() {
        if (ready.get()) {
            throw new IllegalStateException("Already initialized");
        }
        ready.set(true);
    }
}
