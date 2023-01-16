package dev.morphia.aggregation.experimental.stages;

import com.mongodb.lang.Nullable;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Out.class */
public class Out<O> extends Stage {
    private Class<?> type;
    private String collection;

    protected Out() {
        super("$out");
    }

    /* renamed from: to */
    public static <O> Out<O> m1236to(Class<O> type) {
        return new Out().type(type);
    }

    /* renamed from: to */
    public static Out<Document> m1235to(String collection) {
        return new Out().collection(collection);
    }

    public String getCollection() {
        return this.collection;
    }

    @Nullable
    public Class<?> getType() {
        return this.type;
    }

    private Out<O> collection(String collection) {
        this.collection = collection;
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Class<O> */
    /* JADX WARN: Multi-variable type inference failed */
    private Out<O> type(Class<O> type) {
        this.type = type;
        return this;
    }
}
