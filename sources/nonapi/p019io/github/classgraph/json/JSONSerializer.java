package nonapi.p019io.github.classgraph.json;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;
import p013io.github.classgraph.ClassGraphException;

/* renamed from: nonapi.io.github.classgraph.json.JSONSerializer */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/JSONSerializer.class */
public final class JSONSerializer {
    private static final Comparator<Object> SET_COMPARATOR = new Comparator<Object>() { // from class: nonapi.io.github.classgraph.json.JSONSerializer.1
        @Override // java.util.Comparator
        public int compare(Object o1, Object o2) {
            if (o1 == null || o2 == null) {
                return (o1 == null ? 0 : 1) - (o2 == null ? 0 : 1);
            } else if (!Comparable.class.isAssignableFrom(o1.getClass()) || !Comparable.class.isAssignableFrom(o2.getClass())) {
                return o1.toString().compareTo(o2.toString());
            } else {
                return ((Comparable) o1).compareTo(o2);
            }
        }
    };

    private JSONSerializer() {
    }

    private static void assignObjectIds(Object jsonVal, Map<ReferenceEqualityKey<Object>, JSONObject> objToJSONVal, ClassFieldCache classFieldCache, Map<ReferenceEqualityKey<JSONReference>, CharSequence> jsonReferenceToId, AtomicInteger objId, boolean onlySerializePublicFields) {
        if (jsonVal instanceof JSONObject) {
            for (Map.Entry<String, Object> item : ((JSONObject) jsonVal).items) {
                assignObjectIds(item.getValue(), objToJSONVal, classFieldCache, jsonReferenceToId, objId, onlySerializePublicFields);
            }
        } else if (jsonVal instanceof JSONArray) {
            for (Object item2 : ((JSONArray) jsonVal).items) {
                assignObjectIds(item2, objToJSONVal, classFieldCache, jsonReferenceToId, objId, onlySerializePublicFields);
            }
        } else if (jsonVal instanceof JSONReference) {
            Object refdObj = ((JSONReference) jsonVal).idObject;
            if (refdObj == null) {
                throw ClassGraphException.newClassGraphException("Internal inconsistency");
            }
            JSONObject refdJsonVal = objToJSONVal.get(new ReferenceEqualityKey<>(refdObj));
            if (refdJsonVal == null) {
                throw ClassGraphException.newClassGraphException("Internal inconsistency");
            }
            Field annotatedField = classFieldCache.get(refdObj.getClass()).idField;
            CharSequence idStr = null;
            if (annotatedField != null) {
                try {
                    Object idObject = annotatedField.get(refdObj);
                    if (idObject != null) {
                        idStr = idObject.toString();
                        refdJsonVal.objectId = idStr;
                    }
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    throw new IllegalArgumentException("Could not access @Id-annotated field " + annotatedField, e);
                }
            }
            if (idStr == null) {
                if (refdJsonVal.objectId == null) {
                    idStr = "[#" + objId.getAndIncrement() + "]";
                    refdJsonVal.objectId = idStr;
                } else {
                    idStr = refdJsonVal.objectId;
                }
            }
            jsonReferenceToId.put(new ReferenceEqualityKey<>((JSONReference) jsonVal), idStr);
        }
    }

    private static void convertVals(Object[] convertedVals, Set<ReferenceEqualityKey<Object>> visitedOnPath, Set<ReferenceEqualityKey<Object>> standardObjectVisited, ClassFieldCache classFieldCache, Map<ReferenceEqualityKey<Object>, JSONObject> objToJSONVal, boolean onlySerializePublicFields) {
        ReferenceEqualityKey<Object>[] valKeys = new ReferenceEqualityKey[convertedVals.length];
        boolean[] needToConvert = new boolean[convertedVals.length];
        for (int i = 0; i < convertedVals.length; i++) {
            Object val = convertedVals[i];
            needToConvert[i] = !JSONUtils.isBasicValueType(val);
            if (needToConvert[i] && !JSONUtils.isCollectionOrArray(val)) {
                ReferenceEqualityKey<Object> valKey = new ReferenceEqualityKey<>(val);
                valKeys[i] = valKey;
                if (!standardObjectVisited.add(valKey)) {
                    convertedVals[i] = new JSONReference(val);
                    needToConvert[i] = false;
                }
            }
            if (val instanceof Class) {
                convertedVals[i] = ((Class) val).getName();
            }
        }
        for (int i2 = 0; i2 < convertedVals.length; i2++) {
            if (needToConvert[i2]) {
                Object val2 = convertedVals[i2];
                convertedVals[i2] = toJSONGraph(val2, visitedOnPath, standardObjectVisited, classFieldCache, objToJSONVal, onlySerializePublicFields);
                if (!JSONUtils.isCollectionOrArray(val2)) {
                    objToJSONVal.put(valKeys[i2], (JSONObject) convertedVals[i2]);
                }
            }
        }
    }

    private static Object toJSONGraph(Object obj, Set<ReferenceEqualityKey<Object>> visitedOnPath, Set<ReferenceEqualityKey<Object>> standardObjectVisited, ClassFieldCache classFieldCache, Map<ReferenceEqualityKey<Object>, JSONObject> objToJSONVal, boolean onlySerializePublicFields) {
        Object jsonVal;
        if (obj instanceof Class) {
            return ((Class) obj).getName();
        }
        if (JSONUtils.isBasicValueType(obj)) {
            return obj;
        }
        ReferenceEqualityKey<Object> objKey = new ReferenceEqualityKey<>(obj);
        if (visitedOnPath.add(objKey)) {
            Class<?> cls = obj.getClass();
            boolean isArray = cls.isArray();
            if (Map.class.isAssignableFrom(cls)) {
                Map<Object, Object> map = (Map) obj;
                ArrayList<?> keys = new ArrayList<>(map.keySet());
                int n = keys.size();
                boolean keysComparable = false;
                Object firstNonNullKey = null;
                for (int i = 0; i < n && firstNonNullKey == null; i++) {
                    firstNonNullKey = keys.get(i);
                }
                if (firstNonNullKey != null && Comparable.class.isAssignableFrom(firstNonNullKey.getClass())) {
                    CollectionUtils.sortIfNotEmpty(keys);
                    keysComparable = true;
                }
                String[] convertedKeys = new String[n];
                for (int i2 = 0; i2 < n; i2++) {
                    Object key = keys.get(i2);
                    if (key == null || JSONUtils.isBasicValueType(key)) {
                        convertedKeys[i2] = JSONUtils.escapeJSONString(key == null ? "null" : key.toString());
                    } else {
                        throw new IllegalArgumentException("Map key of type " + key.getClass().getName() + " is not a basic type (String, Integer, etc.), so can't be easily serialized as a JSON associative array key");
                    }
                }
                if (!keysComparable) {
                    Arrays.sort(convertedKeys);
                }
                Object[] convertedVals = new Object[n];
                for (int i3 = 0; i3 < n; i3++) {
                    convertedVals[i3] = map.get(keys.get(i3));
                }
                convertVals(convertedVals, visitedOnPath, standardObjectVisited, classFieldCache, objToJSONVal, onlySerializePublicFields);
                List<Map.Entry<String, Object>> convertedKeyValPairs = new ArrayList<>(n);
                for (int i4 = 0; i4 < n; i4++) {
                    convertedKeyValPairs.add(new AbstractMap.SimpleEntry<>(convertedKeys[i4], convertedVals[i4]));
                }
                jsonVal = new JSONObject(convertedKeyValPairs);
            } else if (isArray || List.class.isAssignableFrom(cls)) {
                List<?> list = List.class.isAssignableFrom(cls) ? (List) obj : null;
                int n2 = list != null ? list.size() : isArray ? Array.getLength(obj) : 0;
                Object[] convertedVals2 = new Object[n2];
                for (int i5 = 0; i5 < n2; i5++) {
                    convertedVals2[i5] = list != null ? list.get(i5) : isArray ? Array.get(obj, i5) : 0;
                }
                convertVals(convertedVals2, visitedOnPath, standardObjectVisited, classFieldCache, objToJSONVal, onlySerializePublicFields);
                jsonVal = new JSONArray(Arrays.asList(convertedVals2));
            } else if (Collection.class.isAssignableFrom(cls)) {
                List<Object> convertedValsList = new ArrayList<>((Collection<? extends Object>) ((Collection) obj));
                if (Set.class.isAssignableFrom(cls)) {
                    CollectionUtils.sortIfNotEmpty(convertedValsList, SET_COMPARATOR);
                }
                Object[] convertedVals3 = convertedValsList.toArray();
                convertVals(convertedVals3, visitedOnPath, standardObjectVisited, classFieldCache, objToJSONVal, onlySerializePublicFields);
                jsonVal = new JSONArray(Arrays.asList(convertedVals3));
            } else {
                try {
                    List<FieldTypeInfo> fieldOrder = classFieldCache.get(cls).fieldOrder;
                    int n3 = fieldOrder.size();
                    String[] fieldNames = new String[n3];
                    Object[] convertedVals4 = new Object[n3];
                    for (int i6 = 0; i6 < n3; i6++) {
                        Field field = fieldOrder.get(i6).field;
                        fieldNames[i6] = field.getName();
                        convertedVals4[i6] = JSONUtils.getFieldValue(obj, field);
                    }
                    convertVals(convertedVals4, visitedOnPath, standardObjectVisited, classFieldCache, objToJSONVal, onlySerializePublicFields);
                    List<Map.Entry<String, Object>> convertedKeyValPairs2 = new ArrayList<>(n3);
                    for (int i7 = 0; i7 < n3; i7++) {
                        convertedKeyValPairs2.add(new AbstractMap.SimpleEntry<>(fieldNames[i7], convertedVals4[i7]));
                    }
                    jsonVal = new JSONObject(convertedKeyValPairs2);
                } catch (IllegalAccessException | IllegalArgumentException e) {
                    throw ClassGraphException.newClassGraphException("Could not get value of field in object: " + obj, e);
                }
            }
            visitedOnPath.remove(objKey);
            return jsonVal;
        } else if (!JSONUtils.isCollectionOrArray(obj)) {
            return new JSONReference(obj);
        } else {
            throw new IllegalArgumentException("Cycles involving collections cannot be serialized, since collections are not assigned object ids. Reached cycle at: " + obj);
        }
    }

    /* access modifiers changed from: package-private */
    public static void jsonValToJSONString(Object jsonVal, Map<ReferenceEqualityKey<JSONReference>, CharSequence> jsonReferenceToId, boolean includeNullValuedFields, int depth, int indentWidth, StringBuilder buf) {
        if (jsonVal == null) {
            buf.append("null");
        } else if (jsonVal instanceof JSONObject) {
            ((JSONObject) jsonVal).toJSONString(jsonReferenceToId, includeNullValuedFields, depth, indentWidth, buf);
        } else if (jsonVal instanceof JSONArray) {
            ((JSONArray) jsonVal).toJSONString(jsonReferenceToId, includeNullValuedFields, depth, indentWidth, buf);
        } else if (jsonVal instanceof JSONReference) {
            jsonValToJSONString(jsonReferenceToId.get(new ReferenceEqualityKey((JSONReference) jsonVal)), jsonReferenceToId, includeNullValuedFields, depth, indentWidth, buf);
        } else if ((jsonVal instanceof CharSequence) || (jsonVal instanceof Character) || jsonVal.getClass().isEnum()) {
            buf.append('\"');
            JSONUtils.escapeJSONString(jsonVal.toString(), buf);
            buf.append('\"');
        } else {
            buf.append(jsonVal.toString());
        }
    }

    public static String serializeObject(Object obj, int indentWidth, boolean onlySerializePublicFields, ClassFieldCache classFieldCache) {
        HashMap<ReferenceEqualityKey<Object>, JSONObject> objToJSONVal = new HashMap<>();
        Object rootJsonVal = toJSONGraph(obj, new HashSet(), new HashSet(), classFieldCache, objToJSONVal, onlySerializePublicFields);
        Map<ReferenceEqualityKey<JSONReference>, CharSequence> jsonReferenceToId = new HashMap<>();
        assignObjectIds(rootJsonVal, objToJSONVal, classFieldCache, jsonReferenceToId, new AtomicInteger(0), onlySerializePublicFields);
        StringBuilder buf = new StringBuilder(32768);
        jsonValToJSONString(rootJsonVal, jsonReferenceToId, false, 0, indentWidth, buf);
        return buf.toString();
    }

    public static String serializeObject(Object obj, int indentWidth, boolean onlySerializePublicFields) {
        return serializeObject(obj, indentWidth, onlySerializePublicFields, new ClassFieldCache(false, false));
    }

    public static String serializeObject(Object obj) {
        return serializeObject(obj, 0, false);
    }

    public static String serializeFromField(Object containingObject, String fieldName, int indentWidth, boolean onlySerializePublicFields, ClassFieldCache classFieldCache) {
        FieldTypeInfo fieldResolvedTypeInfo = classFieldCache.get(containingObject.getClass()).fieldNameToFieldTypeInfo.get(fieldName);
        if (fieldResolvedTypeInfo == null) {
            throw new IllegalArgumentException("Class " + containingObject.getClass().getName() + " does not have a field named \"" + fieldName + "\"");
        }
        Field field = fieldResolvedTypeInfo.field;
        if (!JSONUtils.fieldIsSerializable(field, false)) {
            throw new IllegalArgumentException("Field " + containingObject.getClass().getName() + Mapper.IGNORED_FIELDNAME + fieldName + " needs to be accessible, non-transient, and non-final");
        }
        try {
            return serializeObject(JSONUtils.getFieldValue(containingObject, field), indentWidth, onlySerializePublicFields, classFieldCache);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could get value of field " + fieldName, e);
        }
    }

    public static String serializeFromField(Object containingObject, String fieldName, int indentWidth, boolean onlySerializePublicFields) {
        return serializeFromField(containingObject, fieldName, indentWidth, onlySerializePublicFields, new ClassFieldCache(false, onlySerializePublicFields));
    }
}
