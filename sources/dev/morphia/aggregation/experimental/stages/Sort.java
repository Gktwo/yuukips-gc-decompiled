package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import java.util.ArrayList;
import java.util.List;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Sort.class */
public class Sort extends Stage {
    private final List<SortType> sorts = new ArrayList();

    /* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Sort$Direction.class */
    public enum Direction {
        ASCENDING {
            @Override // dev.morphia.aggregation.experimental.stages.Sort.Direction
            public void encode(BsonWriter writer) {
                writer.writeInt32(1);
            }
        },
        DESCENDING {
            @Override // dev.morphia.aggregation.experimental.stages.Sort.Direction
            public void encode(BsonWriter writer) {
                writer.writeInt32(-1);
            }
        },
        META {
            @Override // dev.morphia.aggregation.experimental.stages.Sort.Direction
            public void encode(BsonWriter writer) {
                ExpressionHelper.document(writer, () -> {
                    writer.writeString("$meta", "textScore");
                });
            }
        };

        public abstract void encode(BsonWriter bsonWriter);
    }

    protected Sort() {
        super("$sort");
    }

    @Deprecated(forRemoval = true)
    /* renamed from: on */
    public static Sort m1229on() {
        return new Sort();
    }

    public static Sort sort() {
        return new Sort();
    }

    public Sort ascending(String field, String... additional) {
        this.sorts.add(new SortType(field, Direction.ASCENDING));
        for (String another : additional) {
            this.sorts.add(new SortType(another, Direction.ASCENDING));
        }
        return this;
    }

    public Sort descending(String field, String... additional) {
        this.sorts.add(new SortType(field, Direction.DESCENDING));
        for (String another : additional) {
            this.sorts.add(new SortType(another, Direction.DESCENDING));
        }
        return this;
    }

    public List<SortType> getSorts() {
        return this.sorts;
    }

    public Sort meta(String field) {
        this.sorts.add(new SortType(field, Direction.META));
        return this;
    }

    /* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Sort$SortType.class */
    public class SortType {
        private final String field;
        private final Direction direction;

        protected SortType(String field, Direction direction) {
            this.field = field;
            this.direction = direction;
        }

        public Direction getDirection() {
            return this.direction;
        }

        public String getField() {
            return this.field;
        }
    }
}
