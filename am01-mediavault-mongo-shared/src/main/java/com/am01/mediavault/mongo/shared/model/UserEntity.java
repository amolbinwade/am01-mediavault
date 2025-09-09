package com.am01.mediavault.mongo.shared.model;

import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "users")
public class UserEntity extends BaseEntity{

    public String firstName;
    public String lastName;
    public String email;

    public Status status;

    public enum Status {
        ACTIVE,
        INACTIVE,
        DELETED
    }
}
