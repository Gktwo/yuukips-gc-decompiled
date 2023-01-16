package dev.morphia;

import dev.morphia.mapping.Mapper;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/EntityInterceptor.class */
public interface EntityInterceptor {
    default void postLoad(Object ent, Document document, Mapper mapper) {
    }

    default void postPersist(Object ent, Document document, Mapper mapper) {
    }

    default void preLoad(Object ent, Document document, Mapper mapper) {
    }

    default void prePersist(Object ent, Document document, Mapper mapper) {
    }
}
