package com.am01.mediavault.mongo.shared.model;

import io.quarkus.mongodb.panache.PanacheMongoEntityBase;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.time.Instant;

@MongoEntity
public class BaseEntity  extends PanacheMongoEntityBase {

    /**
     * Primary key (_id in MongoDB).
     * ObjectId is Mongo’s standard identifier type.
     */
    public ObjectId id;

    /**
     * Audit fields.
     */
    public Instant createdAt;
    public String createdBy;
    public Instant updatedAt;
    public String updatedBy;

    /**
     * Optimistic concurrency control field.
     */
    public Integer version;

}
