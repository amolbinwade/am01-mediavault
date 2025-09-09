package com.am01.mediavault.mongo.shared.repository;

import com.am01.mediavault.mongo.shared.model.UserEntity;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.Multi;
import jakarta.enterprise.context.ApplicationScoped;
import org.bson.types.ObjectId;

/**
 * Reactive repository for UserEntity.
 * Extends BaseRepository to inherit CRUD and UPSERT helpers.
 */
@ApplicationScoped
public class UserRepository extends BaseRepository<UserEntity> {

    /**
     * Find a user by email (returns Uni<UserEntity>).
     */
    public Uni<UserEntity> findByEmail(String email) {
        return find("email", email).firstResult();
    }

    /**
     * Stream all active users.
     */
    public Multi<UserEntity> findAllActive() {
        return find("status", UserEntity.Status.ACTIVE).stream();
    }

    /**
     * find user by ID with status check.
     */
    public Uni<UserEntity> findActiveById(ObjectId id) {
        return find("_id = ?1 and status = ?2", id, UserEntity.Status.ACTIVE)
                .firstResult();
    }
}
