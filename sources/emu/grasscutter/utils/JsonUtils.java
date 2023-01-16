package emu.grasscutter.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.common.DynamicFloat;
import emu.grasscutter.utils.JsonAdapters;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import p014it.unimi.dsi.fastutil.ints.IntList;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/JsonUtils.class */
public final class JsonUtils {
    static final Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(DynamicFloat.class, new JsonAdapters.DynamicFloatAdapter()).registerTypeAdapter(IntList.class, new JsonAdapters.IntListAdapter()).registerTypeAdapterFactory(new JsonAdapters.EnumTypeAdapterFactory()).create();

    public static String encode(Object object) {
        return gson.toJson(object);
    }

    public static <T> T decode(JsonElement jsonElement, Class<T> classType) throws JsonSyntaxException {
        return (T) gson.fromJson(jsonElement, (Class<Object>) classType);
    }

    public static <T> T loadToClass(Reader fileReader, Class<T> classType) throws IOException {
        return (T) gson.fromJson(fileReader, (Class<Object>) classType);
    }

    public static <T> T loadToClass(Path filename, Class<T> classType) throws IOException {
        BufferedReader fileReader = Files.newBufferedReader(filename, StandardCharsets.UTF_8);
        try {
            T t = (T) loadToClass(fileReader, classType);
            if (fileReader != null) {
                fileReader.close();
            }
            return t;
        } catch (Throwable th) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static <T> List<T> loadToList(Reader fileReader, Class<T> classType) throws IOException {
        return (List) gson.fromJson(fileReader, TypeToken.getParameterized(List.class, classType).getType());
    }

    public static <T> List<T> loadToList(Path filename, Class<T> classType) throws IOException {
        BufferedReader fileReader = Files.newBufferedReader(filename, StandardCharsets.UTF_8);
        try {
            List<T> loadToList = loadToList(fileReader, classType);
            if (fileReader != null) {
                fileReader.close();
            }
            return loadToList;
        } catch (Throwable th) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static <T1, T2> Map<T1, T2> loadToMap(Reader fileReader, Class<T1> keyType, Class<T2> valueType) throws IOException {
        return (Map) gson.fromJson(fileReader, TypeToken.getParameterized(Map.class, keyType, valueType).getType());
    }

    public static <T1, T2> Map<T1, T2> loadToMap(Path filename, Class<T1> keyType, Class<T2> valueType) throws IOException {
        BufferedReader fileReader = Files.newBufferedReader(filename, StandardCharsets.UTF_8);
        try {
            Map<T1, T2> loadToMap = loadToMap(fileReader, keyType, valueType);
            if (fileReader != null) {
                fileReader.close();
            }
            return loadToMap;
        } catch (Throwable th) {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public static <T> T decode(String jsonData, Class<T> classType) {
        try {
            return (T) gson.fromJson(jsonData, (Class<Object>) classType);
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error Decode Json: ", (Throwable) e);
            return null;
        }
    }

    public static <T> List<T> decodeList(String jsonData, Class<T> classType) throws JsonSyntaxException {
        try {
            return (List) gson.fromJson(jsonData, TypeToken.getParameterized(List.class, classType).getType());
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error Decode List Json: ", (Throwable) e);
            return null;
        }
    }
}
