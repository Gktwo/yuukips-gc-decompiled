package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: grasscutter.jar:com/google/gson/internal/bind/TreeTypeAdapter.class */
public final class TreeTypeAdapter<T> extends TypeAdapter<T> {
    private final JsonSerializer<T> serializer;
    private final JsonDeserializer<T> deserializer;
    final Gson gson;
    private final TypeToken<T> typeToken;
    private final TypeAdapterFactory skipPast;
    private final TreeTypeAdapter<T>.GsonContextImpl context = new GsonContextImpl();
    private volatile TypeAdapter<T> delegate;

    public TreeTypeAdapter(JsonSerializer<T> serializer, JsonDeserializer<T> deserializer, Gson gson, TypeToken<T> typeToken, TypeAdapterFactory skipPast) {
        this.serializer = serializer;
        this.deserializer = deserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = skipPast;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader in) throws IOException {
        if (this.deserializer == null) {
            return delegate().read(in);
        }
        JsonElement value = Streams.parse(in);
        if (value.isJsonNull()) {
            return null;
        }
        return this.deserializer.deserialize(value, this.typeToken.getType(), this.context);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter out, T value) throws IOException {
        if (this.serializer == null) {
            delegate().write(out, value);
        } else if (value == null) {
            out.nullValue();
        } else {
            Streams.write(this.serializer.serialize(value, this.typeToken.getType(), this.context), out);
        }
    }

    private TypeAdapter<T> delegate() {
        TypeAdapter<T> d = this.delegate;
        if (d != null) {
            return d;
        }
        TypeAdapter<T> delegateAdapter = this.gson.getDelegateAdapter(this.skipPast, this.typeToken);
        this.delegate = delegateAdapter;
        return delegateAdapter;
    }

    public static TypeAdapterFactory newFactory(TypeToken<?> exactType, Object typeAdapter) {
        return new SingleTypeFactory(typeAdapter, exactType, false, null);
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> exactType, Object typeAdapter) {
        return new SingleTypeFactory(typeAdapter, exactType, exactType.getType() == exactType.getRawType(), null);
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> hierarchyType, Object typeAdapter) {
        return new SingleTypeFactory(typeAdapter, null, false, hierarchyType);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/gson/internal/bind/TreeTypeAdapter$SingleTypeFactory.class */
    public static final class SingleTypeFactory implements TypeAdapterFactory {
        private final TypeToken<?> exactType;
        private final boolean matchRawType;
        private final Class<?> hierarchyType;
        private final JsonSerializer<?> serializer;
        private final JsonDeserializer<?> deserializer;

        SingleTypeFactory(Object typeAdapter, TypeToken<?> exactType, boolean matchRawType, Class<?> hierarchyType) {
            JsonSerializer<?> jsonSerializer;
            JsonDeserializer<?> jsonDeserializer;
            if (typeAdapter instanceof JsonSerializer) {
                jsonSerializer = (JsonSerializer) typeAdapter;
            } else {
                jsonSerializer = null;
            }
            this.serializer = jsonSerializer;
            if (typeAdapter instanceof JsonDeserializer) {
                jsonDeserializer = (JsonDeserializer) typeAdapter;
            } else {
                jsonDeserializer = null;
            }
            this.deserializer = jsonDeserializer;
            C$Gson$Preconditions.checkArgument((this.serializer == null && this.deserializer == null) ? false : true);
            this.exactType = exactType;
            this.matchRawType = matchRawType;
            this.hierarchyType = hierarchyType;
        }

        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            boolean matches;
            if (this.exactType != null) {
                matches = this.exactType.equals(type) || (this.matchRawType && this.exactType.getType() == type.getRawType());
            } else {
                matches = this.hierarchyType.isAssignableFrom(type.getRawType());
            }
            if (matches) {
                return new TreeTypeAdapter(this.serializer, this.deserializer, gson, type, this);
            }
            return null;
        }
    }

    /* loaded from: grasscutter.jar:com/google/gson/internal/bind/TreeTypeAdapter$GsonContextImpl.class */
    private final class GsonContextImpl implements JsonSerializationContext, JsonDeserializationContext {
        private GsonContextImpl() {
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object src) {
            return TreeTypeAdapter.this.gson.toJsonTree(src);
        }

        @Override // com.google.gson.JsonSerializationContext
        public JsonElement serialize(Object src, Type typeOfSrc) {
            return TreeTypeAdapter.this.gson.toJsonTree(src, typeOfSrc);
        }

        @Override // com.google.gson.JsonDeserializationContext
        public <R> R deserialize(JsonElement json, Type typeOfT) throws JsonParseException {
            return (R) TreeTypeAdapter.this.gson.fromJson(json, typeOfT);
        }
    }
}
