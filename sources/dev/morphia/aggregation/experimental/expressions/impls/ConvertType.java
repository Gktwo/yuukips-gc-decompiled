package dev.morphia.aggregation.experimental.expressions.impls;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/ConvertType.class */
public enum ConvertType {
    DOUBLE("double", 1),
    STRING("string", 2),
    OBJECT_ID("objectId", 7),
    BOOLEAN("bool", 8),
    DATE("date", 9),
    INT("int", 16),
    LONG("long", 18),
    DECIMAL("decimal", 19);
    
    private final String name;
    private final int identifier;

    ConvertType(String name, int identifier) {
        this.name = name;
        this.identifier = identifier;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    public String getName() {
        return this.name;
    }
}
