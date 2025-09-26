package com.am01.mediavault.userservice;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/userservice/api/v1")
public class UserServiceApplication extends Application {
    // Empty – just sets the base path for all resources
}
