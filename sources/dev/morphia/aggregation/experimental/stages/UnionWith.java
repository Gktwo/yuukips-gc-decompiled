package dev.morphia.aggregation.experimental.stages;

import com.mongodb.lang.Nullable;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/UnionWith.class */
public class UnionWith extends Stage {
    private final List<Stage> stages;
    private Class<?> collectionType;
    private String collectionName;

    public UnionWith(String collection, List<Stage> stages) {
        super("$unionWith");
        this.collectionName = collection;
        this.stages = stages;
    }

    public UnionWith(Class<?> type, List<Stage> stages) {
        super("$unionWith");
        this.collectionType = type;
        this.stages = stages;
    }

    @Nullable
    public String getCollectionName() {
        return this.collectionName;
    }

    public Class<?> getCollectionType() {
        return this.collectionType;
    }

    public List<Stage> getStages() {
        return this.stages;
    }
}
