package dev.morphia.query;

import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/Meta.class */
public class Meta {
    private static final String META = "$meta";
    private final String metaDataKeyword;
    private final String field;

    @Deprecated(forRemoval = true)
    /* loaded from: grasscutter.jar:dev/morphia/query/Meta$MetaDataKeyword.class */
    public enum MetaDataKeyword {
        textScore
    }

    public Meta(String metaDataKeyword, String fieldName) {
        this.metaDataKeyword = metaDataKeyword;
        this.field = fieldName;
    }

    @Deprecated(forRemoval = true)
    public Meta(MetaDataKeyword metaDataKeyword) {
        this(metaDataKeyword.name(), metaDataKeyword.name());
    }

    @Deprecated(forRemoval = true)
    public Meta(MetaDataKeyword metaDataKeyword, String field) {
        this(metaDataKeyword.name(), field);
    }

    public static Meta indexKey(String field) {
        return new Meta("indexKey", field);
    }

    public static Meta searchHighlights(String field) {
        return new Meta("searchHighlights", field);
    }

    public static Meta searchScore(String field) {
        return new Meta("searchScore", field);
    }

    public static Meta textScore(String field) {
        return new Meta("textScore", field);
    }

    @Deprecated(forRemoval = true)
    public static Meta textScore() {
        return new Meta(MetaDataKeyword.textScore);
    }

    public String getField() {
        return this.field;
    }

    /* access modifiers changed from: package-private */
    public Document toDatabase() {
        return new Document(this.field, new Document(META, this.metaDataKeyword));
    }
}
