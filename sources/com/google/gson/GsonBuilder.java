package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.sql.SqlTypesSupport;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/google/gson/GsonBuilder.class */
public final class GsonBuilder {
    private Excluder excluder;
    private LongSerializationPolicy longSerializationPolicy;
    private FieldNamingStrategy fieldNamingPolicy;
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<TypeAdapterFactory> factories;
    private final List<TypeAdapterFactory> hierarchyFactories;
    private boolean serializeNulls;
    private String datePattern;
    private int dateStyle;
    private int timeStyle;
    private boolean complexMapKeySerialization;
    private boolean serializeSpecialFloatingPointValues;
    private boolean escapeHtmlChars;
    private boolean prettyPrinting;
    private boolean generateNonExecutableJson;
    private boolean lenient;
    private boolean useJdkUnsafe;
    private ToNumberStrategy objectToNumberStrategy;
    private ToNumberStrategy numberToNumberStrategy;

    public GsonBuilder() {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
    }

    /* access modifiers changed from: package-private */
    public GsonBuilder(Gson gson) {
        this.excluder = Excluder.DEFAULT;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
        this.instanceCreators = new HashMap();
        this.factories = new ArrayList();
        this.hierarchyFactories = new ArrayList();
        this.serializeNulls = false;
        this.datePattern = Gson.DEFAULT_DATE_PATTERN;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.complexMapKeySerialization = false;
        this.serializeSpecialFloatingPointValues = false;
        this.escapeHtmlChars = true;
        this.prettyPrinting = false;
        this.generateNonExecutableJson = false;
        this.lenient = false;
        this.useJdkUnsafe = true;
        this.objectToNumberStrategy = Gson.DEFAULT_OBJECT_TO_NUMBER_STRATEGY;
        this.numberToNumberStrategy = Gson.DEFAULT_NUMBER_TO_NUMBER_STRATEGY;
        this.excluder = gson.excluder;
        this.fieldNamingPolicy = gson.fieldNamingStrategy;
        this.instanceCreators.putAll(gson.instanceCreators);
        this.serializeNulls = gson.serializeNulls;
        this.complexMapKeySerialization = gson.complexMapKeySerialization;
        this.generateNonExecutableJson = gson.generateNonExecutableJson;
        this.escapeHtmlChars = gson.htmlSafe;
        this.prettyPrinting = gson.prettyPrinting;
        this.lenient = gson.lenient;
        this.serializeSpecialFloatingPointValues = gson.serializeSpecialFloatingPointValues;
        this.longSerializationPolicy = gson.longSerializationPolicy;
        this.datePattern = gson.datePattern;
        this.dateStyle = gson.dateStyle;
        this.timeStyle = gson.timeStyle;
        this.factories.addAll(gson.builderFactories);
        this.hierarchyFactories.addAll(gson.builderHierarchyFactories);
        this.useJdkUnsafe = gson.useJdkUnsafe;
        this.objectToNumberStrategy = gson.objectToNumberStrategy;
        this.numberToNumberStrategy = gson.numberToNumberStrategy;
    }

    public GsonBuilder setVersion(double ignoreVersionsAfter) {
        this.excluder = this.excluder.withVersion(ignoreVersionsAfter);
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... modifiers) {
        this.excluder = this.excluder.withModifiers(modifiers);
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
        return this;
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.excluder = this.excluder.disableInnerClassSerialization();
        return this;
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy serializationPolicy) {
        this.longSerializationPolicy = serializationPolicy;
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy namingConvention) {
        this.fieldNamingPolicy = namingConvention;
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        this.fieldNamingPolicy = fieldNamingStrategy;
        return this;
    }

    public GsonBuilder setObjectToNumberStrategy(ToNumberStrategy objectToNumberStrategy) {
        this.objectToNumberStrategy = objectToNumberStrategy;
        return this;
    }

    public GsonBuilder setNumberToNumberStrategy(ToNumberStrategy numberToNumberStrategy) {
        this.numberToNumberStrategy = numberToNumberStrategy;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... strategies) {
        for (ExclusionStrategy strategy : strategies) {
            this.excluder = this.excluder.withExclusionStrategy(strategy, true, true);
        }
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy strategy) {
        this.excluder = this.excluder.withExclusionStrategy(strategy, true, false);
        return this;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy strategy) {
        this.excluder = this.excluder.withExclusionStrategy(strategy, false, true);
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setLenient() {
        this.lenient = true;
        return this;
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder setDateFormat(String pattern) {
        this.datePattern = pattern;
        return this;
    }

    public GsonBuilder setDateFormat(int style) {
        this.dateStyle = style;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int dateStyle, int timeStyle) {
        this.dateStyle = dateStyle;
        this.timeStyle = timeStyle;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object typeAdapter) {
        C$Gson$Preconditions.checkArgument((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof InstanceCreator) || (typeAdapter instanceof TypeAdapter));
        if (typeAdapter instanceof InstanceCreator) {
            this.instanceCreators.put(type, (InstanceCreator) typeAdapter);
        }
        if ((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer)) {
            this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(TypeToken.get(type), typeAdapter));
        }
        if (typeAdapter instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newFactory(TypeToken.get(type), (TypeAdapter) typeAdapter));
        }
        return this;
    }

    public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory factory) {
        this.factories.add(factory);
        return this;
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> baseType, Object typeAdapter) {
        C$Gson$Preconditions.checkArgument((typeAdapter instanceof JsonSerializer) || (typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof TypeAdapter));
        if ((typeAdapter instanceof JsonDeserializer) || (typeAdapter instanceof JsonSerializer)) {
            this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(baseType, typeAdapter));
        }
        if (typeAdapter instanceof TypeAdapter) {
            this.factories.add(TypeAdapters.newTypeHierarchyFactory(baseType, (TypeAdapter) typeAdapter));
        }
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder disableJdkUnsafe() {
        this.useJdkUnsafe = false;
        return this;
    }

    public Gson create() {
        List<TypeAdapterFactory> factories = new ArrayList<>(this.factories.size() + this.hierarchyFactories.size() + 3);
        factories.addAll(this.factories);
        Collections.reverse(factories);
        List<TypeAdapterFactory> hierarchyFactories = new ArrayList<>(this.hierarchyFactories);
        Collections.reverse(hierarchyFactories);
        factories.addAll(hierarchyFactories);
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, factories);
        return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.useJdkUnsafe, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, factories, this.objectToNumberStrategy, this.numberToNumberStrategy);
    }

    private void addTypeAdaptersForDate(String datePattern, int dateStyle, int timeStyle, List<TypeAdapterFactory> factories) {
        TypeAdapterFactory dateAdapterFactory;
        boolean sqlTypesSupported = SqlTypesSupport.SUPPORTS_SQL_TYPES;
        TypeAdapterFactory sqlTimestampAdapterFactory = null;
        TypeAdapterFactory sqlDateAdapterFactory = null;
        if (datePattern != null && !datePattern.trim().isEmpty()) {
            dateAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(datePattern);
            if (sqlTypesSupported) {
                sqlTimestampAdapterFactory = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(datePattern);
                sqlDateAdapterFactory = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(datePattern);
            }
        } else if (dateStyle != 2 && timeStyle != 2) {
            dateAdapterFactory = DefaultDateTypeAdapter.DateType.DATE.createAdapterFactory(dateStyle, timeStyle);
            if (sqlTypesSupported) {
                sqlTimestampAdapterFactory = SqlTypesSupport.TIMESTAMP_DATE_TYPE.createAdapterFactory(dateStyle, timeStyle);
                sqlDateAdapterFactory = SqlTypesSupport.DATE_DATE_TYPE.createAdapterFactory(dateStyle, timeStyle);
            }
        } else {
            return;
        }
        factories.add(dateAdapterFactory);
        if (sqlTypesSupported) {
            factories.add(sqlTimestampAdapterFactory);
            factories.add(sqlDateAdapterFactory);
        }
    }
}
