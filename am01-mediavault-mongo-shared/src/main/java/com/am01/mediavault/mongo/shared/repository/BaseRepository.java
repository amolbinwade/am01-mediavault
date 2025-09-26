package com.am01.mediavault.mongo.shared.repository;

import com.am01.mediavault.mongo.shared.model.BaseEntity;
import com.mongodb.client.model.ReplaceOptions;
import io.quarkus.mongodb.reactive.ReactiveMongoClient;
import io.quarkus.mongodb.reactive.ReactiveMongoCollection;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.lang.reflect.ParameterizedType;
import java.time.Instant;
import java.util.Optional;

/**
 * Reactive base repository providing common CRUD and UPSERT helpers.
 * Extend this for all entity repositories (e.g., UserRepository).
 *
 * @param <T> Entity type
 */
public abstract class BaseRepository<T extends BaseEntity>
        implements ReactivePanacheMongoRepositoryBase<T, ObjectId> {

    @Inject
    ReactiveMongoClient reactiveMongoClient;

    @Inject
    @ConfigProperty(name = "quarkus.mongodb.database", defaultValue = "mediavault")
    String databaseName;

    /**
     * Resolve the entity class at runtime.
     */
    @SuppressWarnings("unchecked")
    private Class<T> entityClass() {
        return (Class<T>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Resolve collection name.
     * Default = classname.toLowerCase() + "s"
     */
    protected String collectionName() {
        return entityClass().getSimpleName().replace("Entity", "").toLowerCase() + "s";
    }

    /**
     * Get the typed reactive MongoCollection for this entity.
     */
    protected ReactiveMongoCollection<T> collection() {
        return reactiveMongoClient
                .getDatabase(databaseName)
                .getCollection(collectionName(), entityClass());
    }

    /**
     * Find entity by ID wrapped in Uni<Optional<T>>.
     */
    public Uni<Optional<T>> findByIdOptional(ObjectId id) {
        return findById(id).onItem().ifNotNull().transform(Optional::ofNullable);
    }

    /**
     * Insert or update entity (UPSERT).
     * - If entity has no id, treat as new insert.
     * - If id exists, replaces the document with upsert=true.
     */
    public Uni<T> insertOrUpdate(T entity, String actor) {
        Instant now = Instant.now();

        if (entity.id == null) {
            // new document
            entity.createdAt = now;
            entity.createdBy = actor;
            entity.version = 1;
            return persist(entity);
        } else {
            // update existing document
            entity.updatedAt = now;
            entity.updatedBy = actor;
            entity.version = (entity.version == null ? 1 : entity.version + 1);

            return collection().replaceOne(
                    new Document("_id", entity.id),
                    entity,
                    new ReplaceOptions().upsert(true)
            ).map(r -> entity);
        }
    }

    /**
     * Delete entity by ID safely.
     */
    public Uni<Boolean> deleteByIdSafe(ObjectId id) {
        return deleteById(id);
    }
}
