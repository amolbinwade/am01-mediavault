package com.am01.mediavault.userservice;

import com.am01.mediavault.mongo.shared.repository.UserRepository;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import com.am01.mediavault.mongo.shared.model.UserEntity;
import jakarta.ws.rs.core.Response;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserRepository userRepository;

    @GET
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @PUT
    @Path("/{email}")
    public Uni<Response> upsertUser(@PathParam("email") String email, UserEntity user) {
        System.out.println("called user resource");
        user.email = email;

        return userRepository.findByEmail(email)
                .onItem().ifNotNull().transformToUni(existing -> {
                //update existing user fields
                existing.firstName = user.firstName;
                existing.lastName = user.lastName;
                return userRepository.insertOrUpdate(existing, "SYSTEM")
                        .replaceWith(Response.ok(existing).build());
                })
                .onItem().ifNull().switchTo(() -> {
                    user.status = UserEntity.Status.ACTIVE;
                    return userRepository.insertOrUpdate(user, "SYSTEM")
                                .replaceWith(Response.status(Response.Status.CREATED)
                                        .entity(user).build());
                }
                );
    }
}
