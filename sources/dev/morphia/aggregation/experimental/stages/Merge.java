package dev.morphia.aggregation.experimental.stages;

import com.mongodb.client.model.MergeOptions;
import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Merge.class */
public class Merge<M> extends Stage {
    private Class<M> type;
    private String database;
    private String collection;

    /* renamed from: on */
    private List<String> f472on;
    private Map<String, Expression> variables;
    private MergeOptions.WhenMatched whenMatched;
    private List<Stage> whenMatchedPipeline;
    private MergeOptions.WhenNotMatched whenNotMatched;

    protected Merge(Class<M> type) {
        this();
        this.type = type;
    }

    protected Merge() {
        super("$merge");
    }

    protected Merge(String collection) {
        this();
        this.collection = collection;
    }

    protected Merge(String database, String collection) {
        this();
        this.database = database;
        this.collection = collection;
    }

    public static <M> Merge<M> into(Class<M> type) {
        return new Merge<>(type);
    }

    public static Merge<?> into(String collection) {
        return new Merge<>(collection);
    }

    public static Merge<?> into(String database, String collection) {
        return new Merge<>(database, collection);
    }

    public String getCollection() {
        return this.collection;
    }

    @Nullable
    public String getDatabase() {
        return this.database;
    }

    public List<String> getOn() {
        return this.f472on;
    }

    @Nullable
    public Class<M> getType() {
        return this.type;
    }

    public Map<String, Expression> getVariables() {
        return this.variables;
    }

    public MergeOptions.WhenMatched getWhenMatched() {
        return this.whenMatched;
    }

    public List<Stage> getWhenMatchedPipeline() {
        return this.whenMatchedPipeline;
    }

    public MergeOptions.WhenNotMatched getWhenNotMatched() {
        return this.whenNotMatched;
    }

    public Merge<M> let(String variable, Expression value) {
        if (this.variables == null) {
            this.variables = new LinkedHashMap();
        }
        this.variables.put(variable, value);
        return this;
    }

    /* renamed from: on */
    public Merge<M> m1237on(String field, String... fields) {
        List<String> list = new ArrayList<>();
        list.add(field);
        list.addAll(Arrays.asList(fields));
        this.f472on = list;
        return this;
    }

    public Merge<M> whenMatched(MergeOptions.WhenMatched whenMatched) {
        this.whenMatched = whenMatched;
        return this;
    }

    public Merge<M> whenMatched(List<Stage> pipeline) {
        this.whenMatchedPipeline = pipeline;
        return this;
    }

    public Merge<M> whenNotMatched(MergeOptions.WhenNotMatched whenNotMatched) {
        this.whenNotMatched = whenNotMatched;
        return this;
    }
}
