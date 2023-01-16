package dev.morphia.query;

import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/Criteria.class */
public interface Criteria {
    default void attach(CriteriaContainer container) {
        MorphiaQuery.legacyOperation();
    }

    default String getFieldName() {
        return (String) MorphiaQuery.legacyOperation();
    }

    default Document toDocument() {
        return (Document) MorphiaQuery.legacyOperation();
    }
}
