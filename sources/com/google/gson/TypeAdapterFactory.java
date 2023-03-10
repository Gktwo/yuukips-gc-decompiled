package com.google.gson;

import com.google.gson.reflect.TypeToken;

/* loaded from: grasscutter.jar:com/google/gson/TypeAdapterFactory.class */
public interface TypeAdapterFactory {
    <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken);
}
