package org.jline.console;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jline.reader.Completer;

/* loaded from: grasscutter.jar:org/jline/console/ScriptEngine.class */
public interface ScriptEngine {
    String getEngineName();

    Collection<String> getExtensions();

    Completer getScriptCompleter();

    boolean hasVariable(String str);

    void put(String str, Object obj);

    Object get(String str);

    Map<String, Object> find(String str);

    void del(String... strArr);

    String toJson(Object obj);

    String toString(Object obj);

    Map<String, Object> toMap(Object obj);

    Object deserialize(String str, String str2);

    List<String> getSerializationFormats();

    List<String> getDeserializationFormats();

    void persist(Path path, Object obj);

    void persist(Path path, Object obj, String str);

    Object execute(String str) throws Exception;

    Object execute(File file, Object[] objArr) throws Exception;

    Object execute(Object obj, Object... objArr);

    default Map<String, Object> find() {
        return find(null);
    }

    default Object deserialize(String value) {
        return deserialize(value, null);
    }

    default Object execute(File script) throws Exception {
        return execute(script, (Object[]) null);
    }
}
