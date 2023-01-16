package nonapi.p019io.github.classgraph.json;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import nonapi.p019io.github.classgraph.types.ParseException;
import p013io.github.classgraph.ClassGraphException;

/* renamed from: nonapi.io.github.classgraph.json.JSONDeserializer */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/JSONDeserializer.class */
public class JSONDeserializer {
    private JSONDeserializer() {
    }

    private static Object jsonBasicValueToObject(Object jsonVal, Type expectedType, boolean convertStringToNumber) {
        if (jsonVal == null) {
            return null;
        }
        if ((jsonVal instanceof JSONArray) || (jsonVal instanceof JSONObject)) {
            throw ClassGraphException.newClassGraphException("Expected a basic value type");
        } else if (expectedType instanceof ParameterizedType) {
            if (((ParameterizedType) expectedType).getRawType().getClass() == Class.class) {
                String str = jsonVal.toString();
                int idx = str.indexOf(60);
                try {
                    return Class.forName(str.substring(0, idx < 0 ? str.length() : idx));
                } catch (ClassNotFoundException e) {
                    throw new IllegalArgumentException("Could not deserialize class reference " + jsonVal, e);
                }
            } else {
                throw new IllegalArgumentException("Got illegal ParameterizedType: " + expectedType);
            }
        } else if (!(expectedType instanceof Class)) {
            throw new IllegalArgumentException("Got illegal basic value type: " + expectedType);
        } else {
            Class<?> rawType = (Class) expectedType;
            if (rawType == String.class) {
                if (jsonVal instanceof CharSequence) {
                    return jsonVal.toString();
                }
                throw new IllegalArgumentException("Expected string; got " + jsonVal.getClass().getName());
            } else if (rawType == CharSequence.class) {
                if (jsonVal instanceof CharSequence) {
                    return jsonVal;
                }
                throw new IllegalArgumentException("Expected CharSequence; got " + jsonVal.getClass().getName());
            } else if (rawType == Integer.class || rawType == Integer.TYPE) {
                if (convertStringToNumber && (jsonVal instanceof CharSequence)) {
                    return Integer.valueOf(Integer.parseInt(jsonVal.toString()));
                }
                if (jsonVal instanceof Integer) {
                    return jsonVal;
                }
                throw new IllegalArgumentException("Expected integer; got " + jsonVal.getClass().getName());
            } else if (rawType == Long.class || rawType == Long.TYPE) {
                boolean isLong = jsonVal instanceof Long;
                boolean isInteger = jsonVal instanceof Integer;
                if (convertStringToNumber && (jsonVal instanceof CharSequence)) {
                    return Long.valueOf(isLong ? Long.parseLong(jsonVal.toString()) : (long) Integer.parseInt(jsonVal.toString()));
                } else if (!isLong && !isInteger) {
                    throw new IllegalArgumentException("Expected long; got " + jsonVal.getClass().getName());
                } else if (isLong) {
                    return jsonVal;
                } else {
                    return Long.valueOf((long) ((Integer) jsonVal).intValue());
                }
            } else if (rawType == Short.class || rawType == Short.TYPE) {
                if (convertStringToNumber && (jsonVal instanceof CharSequence)) {
                    return Short.valueOf(Short.parseShort(jsonVal.toString()));
                }
                if (!(jsonVal instanceof Integer)) {
                    throw new IllegalArgumentException("Expected short; got " + jsonVal.getClass().getName());
                }
                int intValue = ((Integer) jsonVal).intValue();
                if (intValue >= -32768 && intValue <= 32767) {
                    return Short.valueOf((short) intValue);
                }
                throw new IllegalArgumentException("Expected short; got out-of-range value " + intValue);
            } else if (rawType == Float.class || rawType == Float.TYPE) {
                if (convertStringToNumber && (jsonVal instanceof CharSequence)) {
                    return Float.valueOf(Float.parseFloat(jsonVal.toString()));
                }
                if (!(jsonVal instanceof Double)) {
                    throw new IllegalArgumentException("Expected float; got " + jsonVal.getClass().getName());
                }
                double doubleValue = ((Double) jsonVal).doubleValue();
                if (doubleValue >= 1.401298464324817E-45d && doubleValue <= 3.4028234663852886E38d) {
                    return Float.valueOf((float) doubleValue);
                }
                throw new IllegalArgumentException("Expected float; got out-of-range value " + doubleValue);
            } else if (rawType == Double.class || rawType == Double.TYPE) {
                if (convertStringToNumber && (jsonVal instanceof CharSequence)) {
                    return Double.valueOf(Double.parseDouble(jsonVal.toString()));
                }
                if (jsonVal instanceof Double) {
                    return jsonVal;
                }
                throw new IllegalArgumentException("Expected double; got " + jsonVal.getClass().getName());
            } else if (rawType == Byte.class || rawType == Byte.TYPE) {
                if (convertStringToNumber && (jsonVal instanceof CharSequence)) {
                    return Byte.valueOf(Byte.parseByte(jsonVal.toString()));
                }
                if (!(jsonVal instanceof Integer)) {
                    throw new IllegalArgumentException("Expected byte; got " + jsonVal.getClass().getName());
                }
                int intValue2 = ((Integer) jsonVal).intValue();
                if (intValue2 >= -128 && intValue2 <= 127) {
                    return Byte.valueOf((byte) intValue2);
                }
                throw new IllegalArgumentException("Expected byte; got out-of-range value " + intValue2);
            } else if (rawType == Character.class || rawType == Character.TYPE) {
                if (!(jsonVal instanceof CharSequence)) {
                    throw new IllegalArgumentException("Expected character; got " + jsonVal.getClass().getName());
                }
                CharSequence charSequence = (CharSequence) jsonVal;
                if (charSequence.length() == 1) {
                    return Character.valueOf(charSequence.charAt(0));
                }
                throw new IllegalArgumentException("Expected single character; got string");
            } else if (rawType == Boolean.class || rawType == Boolean.TYPE) {
                if (convertStringToNumber && (jsonVal instanceof CharSequence)) {
                    return Boolean.valueOf(Boolean.parseBoolean(jsonVal.toString()));
                }
                if (jsonVal instanceof Boolean) {
                    return jsonVal;
                }
                throw new IllegalArgumentException("Expected boolean; got " + jsonVal.getClass().getName());
            } else if (Enum.class.isAssignableFrom(rawType)) {
                if (jsonVal instanceof CharSequence) {
                    return Enum.valueOf(rawType, jsonVal.toString());
                }
                throw new IllegalArgumentException("Expected string for enum value; got " + jsonVal.getClass().getName());
            } else if (JSONUtils.getRawType(expectedType).isAssignableFrom(jsonVal.getClass())) {
                return jsonVal;
            } else {
                throw new IllegalArgumentException("Got type " + jsonVal.getClass() + "; expected " + expectedType);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nonapi.io.github.classgraph.json.JSONDeserializer$ObjectInstantiation */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/JSONDeserializer$ObjectInstantiation.class */
    public static class ObjectInstantiation {
        Object jsonVal;
        Object objectInstance;
        Type type;

        public ObjectInstantiation(Object objectInstance, Type type, Object jsonVal) {
            this.jsonVal = jsonVal;
            this.objectInstance = objectInstance;
            this.type = type;
        }
    }

    private static void populateObjectFromJsonObject(Object objectInstance, Type objectResolvedType, Object jsonVal, ClassFieldCache classFieldCache, Map<CharSequence, Object> idToObjectInstance, List<Runnable> collectionElementAdders) {
        boolean is1DArray;
        Class<?> arrayComponentType;
        Type commonResolvedValueType;
        Type mapKeyType;
        TypeResolutions typeResolutions;
        Constructor<?> commonValueDefaultConstructor;
        Constructor<?> commonValueConstructorWithSizeHint;
        int numItems;
        Object itemJsonValue;
        String itemJsonKey;
        FieldTypeInfo fieldTypeInfo;
        Type resolvedItemValueType;
        final Object instantiatedItemObject;
        int numSubItems;
        if (jsonVal != null) {
            boolean isJsonObject = jsonVal instanceof JSONObject;
            boolean isJsonArray = jsonVal instanceof JSONArray;
            if (isJsonArray || isJsonObject) {
                JSONObject jsonObject = isJsonObject ? (JSONObject) jsonVal : null;
                JSONArray jsonArray = isJsonArray ? (JSONArray) jsonVal : null;
                Class<?> rawType = objectInstance.getClass();
                boolean isMap = Map.class.isAssignableFrom(rawType);
                Map<Object, Object> mapInstance = isMap ? (Map) objectInstance : null;
                boolean isCollection = Collection.class.isAssignableFrom(rawType);
                final Collection<Object> collectionInstance = isCollection ? (Collection) objectInstance : null;
                boolean isArray = rawType.isArray();
                boolean isObj = !isMap && !isCollection && !isArray;
                if ((isMap || isObj) == isJsonObject) {
                    if ((isCollection || isArray) == isJsonArray) {
                        Type objectResolvedTypeGeneric = objectResolvedType;
                        if (objectResolvedType instanceof Class) {
                            Class<?> objectResolvedCls = (Class) objectResolvedType;
                            if (Map.class.isAssignableFrom(objectResolvedCls)) {
                                if (!isMap) {
                                    throw new IllegalArgumentException("Got an unexpected map type");
                                }
                                objectResolvedTypeGeneric = objectResolvedCls.getGenericSuperclass();
                            } else if (Collection.class.isAssignableFrom(objectResolvedCls)) {
                                if (!isCollection) {
                                    throw new IllegalArgumentException("Got an unexpected map type");
                                }
                                objectResolvedTypeGeneric = objectResolvedCls.getGenericSuperclass();
                            }
                        }
                        if (objectResolvedTypeGeneric instanceof Class) {
                            typeResolutions = null;
                            mapKeyType = null;
                            Class<?> objectResolvedCls2 = (Class) objectResolvedTypeGeneric;
                            if (isArray) {
                                arrayComponentType = objectResolvedCls2.getComponentType();
                                is1DArray = !arrayComponentType.isArray();
                            } else {
                                arrayComponentType = null;
                                is1DArray = false;
                            }
                            commonResolvedValueType = null;
                        } else if (objectResolvedTypeGeneric instanceof ParameterizedType) {
                            typeResolutions = new TypeResolutions((ParameterizedType) objectResolvedTypeGeneric);
                            int numTypeArgs = typeResolutions.resolvedTypeArguments.length;
                            if (isMap && numTypeArgs != 2) {
                                throw new IllegalArgumentException("Wrong number of type arguments for Map: got " + numTypeArgs + "; expected 2");
                            } else if (!isCollection || numTypeArgs == 1) {
                                mapKeyType = isMap ? typeResolutions.resolvedTypeArguments[0] : null;
                                commonResolvedValueType = isMap ? typeResolutions.resolvedTypeArguments[1] : isCollection ? typeResolutions.resolvedTypeArguments[0] : null;
                                is1DArray = false;
                                arrayComponentType = null;
                            } else {
                                throw new IllegalArgumentException("Wrong number of type arguments for Collection: got " + numTypeArgs + "; expected 1");
                            }
                        } else {
                            throw new IllegalArgumentException("Got illegal type: " + objectResolvedTypeGeneric);
                        }
                        Class<?> commonValueRawType = commonResolvedValueType == null ? null : JSONUtils.getRawType(commonResolvedValueType);
                        if (isMap || isCollection || (is1DArray && !JSONUtils.isBasicValueType(arrayComponentType))) {
                            commonValueConstructorWithSizeHint = classFieldCache.getConstructorWithSizeHintForConcreteTypeOf(is1DArray ? arrayComponentType : commonValueRawType);
                            if (commonValueConstructorWithSizeHint != null) {
                                commonValueDefaultConstructor = null;
                            } else {
                                commonValueDefaultConstructor = classFieldCache.getDefaultConstructorForConcreteTypeOf(is1DArray ? arrayComponentType : commonValueRawType);
                            }
                        } else {
                            commonValueConstructorWithSizeHint = null;
                            commonValueDefaultConstructor = null;
                        }
                        ClassFields classFields = isObj ? classFieldCache.get(rawType) : null;
                        ArrayList<ObjectInstantiation> itemsToRecurseToInPass2 = null;
                        if (jsonObject != null) {
                            numItems = jsonObject.items.size();
                        } else {
                            numItems = jsonArray != null ? jsonArray.items.size() : 0;
                        }
                        for (int i = 0; i < numItems; i++) {
                            if (jsonObject != null) {
                                Map.Entry<String, Object> jsonObjectItem = jsonObject.items.get(i);
                                itemJsonKey = jsonObjectItem.getKey();
                                itemJsonValue = jsonObjectItem.getValue();
                            } else if (jsonArray != null) {
                                itemJsonKey = null;
                                itemJsonValue = jsonArray.items.get(i);
                            } else {
                                throw ClassGraphException.newClassGraphException("This exception should not be thrown");
                            }
                            boolean itemJsonValueIsJsonObject = itemJsonValue instanceof JSONObject;
                            boolean itemJsonValueIsJsonArray = itemJsonValue instanceof JSONArray;
                            JSONObject itemJsonValueJsonObject = itemJsonValueIsJsonObject ? (JSONObject) itemJsonValue : null;
                            JSONArray itemJsonValueJsonArray = itemJsonValueIsJsonArray ? (JSONArray) itemJsonValue : null;
                            if (classFields != null) {
                                fieldTypeInfo = classFields.fieldNameToFieldTypeInfo.get(itemJsonKey);
                                if (fieldTypeInfo == null) {
                                    throw new IllegalArgumentException("Field " + rawType.getName() + Mapper.IGNORED_FIELDNAME + itemJsonKey + " does not exist or is not accessible, non-final, and non-transient");
                                }
                            } else {
                                fieldTypeInfo = null;
                            }
                            if (fieldTypeInfo != null) {
                                resolvedItemValueType = fieldTypeInfo.getFullyResolvedFieldType(typeResolutions);
                            } else {
                                resolvedItemValueType = isArray ? arrayComponentType : commonResolvedValueType;
                            }
                            if (itemJsonValue == null) {
                                instantiatedItemObject = null;
                            } else if (resolvedItemValueType == Object.class) {
                                if (itemJsonValueIsJsonObject) {
                                    instantiatedItemObject = new HashMap();
                                    if (itemsToRecurseToInPass2 == null) {
                                        itemsToRecurseToInPass2 = new ArrayList<>();
                                    }
                                    itemsToRecurseToInPass2.add(new ObjectInstantiation(instantiatedItemObject, ParameterizedTypeImpl.MAP_OF_UNKNOWN_TYPE, itemJsonValue));
                                } else if (itemJsonValueIsJsonArray) {
                                    instantiatedItemObject = new ArrayList();
                                    if (itemsToRecurseToInPass2 == null) {
                                        itemsToRecurseToInPass2 = new ArrayList<>();
                                    }
                                    itemsToRecurseToInPass2.add(new ObjectInstantiation(instantiatedItemObject, ParameterizedTypeImpl.LIST_OF_UNKNOWN_TYPE, itemJsonValue));
                                } else {
                                    instantiatedItemObject = jsonBasicValueToObject(itemJsonValue, resolvedItemValueType, false);
                                }
                            } else if (JSONUtils.isBasicValueType(resolvedItemValueType)) {
                                if (itemJsonValueIsJsonObject || itemJsonValueIsJsonArray) {
                                    throw new IllegalArgumentException("Got JSONObject or JSONArray type when expecting a simple value type");
                                }
                                instantiatedItemObject = jsonBasicValueToObject(itemJsonValue, resolvedItemValueType, false);
                            } else if (CharSequence.class.isAssignableFrom(itemJsonValue.getClass())) {
                                Object linkedObject = idToObjectInstance.get(itemJsonValue);
                                if (linkedObject == null) {
                                    throw new IllegalArgumentException("Object id not found: " + itemJsonValue);
                                }
                                instantiatedItemObject = linkedObject;
                            } else if (itemJsonValueIsJsonObject || itemJsonValueIsJsonArray) {
                                if (itemJsonValueJsonObject != null) {
                                    try {
                                        numSubItems = itemJsonValueJsonObject.items.size();
                                    } catch (ReflectiveOperationException | SecurityException e) {
                                        throw new IllegalArgumentException("Could not instantiate type " + resolvedItemValueType, e);
                                    }
                                } else {
                                    numSubItems = itemJsonValueJsonArray != null ? itemJsonValueJsonArray.items.size() : 0;
                                }
                                if (!(resolvedItemValueType instanceof Class) || !((Class) resolvedItemValueType).isArray()) {
                                    if (isCollection || isMap || is1DArray) {
                                        if (commonValueConstructorWithSizeHint != null) {
                                            instantiatedItemObject = commonValueConstructorWithSizeHint.newInstance(Integer.valueOf(numSubItems));
                                        } else {
                                            instantiatedItemObject = commonValueDefaultConstructor != null ? commonValueDefaultConstructor.newInstance(new Object[0]) : null;
                                        }
                                    } else if (fieldTypeInfo != null) {
                                        Constructor<?> valueConstructorWithSizeHint = fieldTypeInfo.getConstructorForFieldTypeWithSizeHint(resolvedItemValueType, classFieldCache);
                                        if (valueConstructorWithSizeHint != null) {
                                            instantiatedItemObject = valueConstructorWithSizeHint.newInstance(Integer.valueOf(numSubItems));
                                        } else {
                                            instantiatedItemObject = fieldTypeInfo.getDefaultConstructorForFieldType(resolvedItemValueType, classFieldCache).newInstance(new Object[0]);
                                        }
                                    } else if (!isArray || is1DArray) {
                                        throw new IllegalArgumentException("Got illegal type");
                                    } else {
                                        instantiatedItemObject = Array.newInstance(rawType.getComponentType(), numSubItems);
                                    }
                                } else if (!itemJsonValueIsJsonArray) {
                                    throw new IllegalArgumentException("Expected JSONArray, got " + itemJsonValue.getClass().getName());
                                } else {
                                    instantiatedItemObject = Array.newInstance(((Class) resolvedItemValueType).getComponentType(), numSubItems);
                                }
                                if (itemJsonValue instanceof JSONObject) {
                                    JSONObject itemJsonObject = (JSONObject) itemJsonValue;
                                    if (itemJsonObject.objectId != null) {
                                        idToObjectInstance.put(itemJsonObject.objectId, instantiatedItemObject);
                                    }
                                }
                                if (itemsToRecurseToInPass2 == null) {
                                    itemsToRecurseToInPass2 = new ArrayList<>();
                                }
                                itemsToRecurseToInPass2.add(new ObjectInstantiation(instantiatedItemObject, resolvedItemValueType, itemJsonValue));
                            } else {
                                throw new IllegalArgumentException("Got simple value type when expecting a JSON object or JSON array");
                            }
                            if (fieldTypeInfo != null) {
                                fieldTypeInfo.setFieldValue(objectInstance, instantiatedItemObject);
                            } else if (mapInstance != null) {
                                mapInstance.put(jsonBasicValueToObject(itemJsonKey, mapKeyType, true), instantiatedItemObject);
                            } else if (isArray) {
                                Array.set(objectInstance, i, instantiatedItemObject);
                            } else if (collectionInstance != null) {
                                collectionElementAdders.add(new Runnable() { // from class: nonapi.io.github.classgraph.json.JSONDeserializer.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        collectionInstance.add(instantiatedItemObject);
                                    }
                                });
                            }
                        }
                        if (itemsToRecurseToInPass2 != null) {
                            Iterator<ObjectInstantiation> it = itemsToRecurseToInPass2.iterator();
                            while (it.hasNext()) {
                                ObjectInstantiation i2 = it.next();
                                populateObjectFromJsonObject(i2.objectInstance, i2.type, i2.jsonVal, classFieldCache, idToObjectInstance, collectionElementAdders);
                            }
                            return;
                        }
                        return;
                    }
                }
                throw new IllegalArgumentException("Wrong JSON type for class " + objectInstance.getClass().getName());
            }
            throw new IllegalArgumentException("Expected JSONObject or JSONArray, got " + jsonVal.getClass().getSimpleName());
        }
    }

    private static Map<CharSequence, Object> getInitialIdToObjectMap(Object objectInstance, Object parsedJSON) {
        Object firstItemValue;
        Map<CharSequence, Object> idToObjectInstance = new HashMap<>();
        if (parsedJSON instanceof JSONObject) {
            JSONObject itemJsonObject = (JSONObject) parsedJSON;
            if (!itemJsonObject.items.isEmpty()) {
                Map.Entry<String, Object> firstItem = itemJsonObject.items.get(0);
                if (firstItem.getKey().equals("__ID") && ((firstItemValue = firstItem.getValue()) == null || !CharSequence.class.isAssignableFrom(firstItemValue.getClass()))) {
                    idToObjectInstance.put((CharSequence) firstItemValue, objectInstance);
                }
            }
        }
        return idToObjectInstance;
    }

    private static <T> T deserializeObject(Class<T> expectedType, String json, ClassFieldCache classFieldCache) throws IllegalArgumentException {
        try {
            Object parsedJSON = JSONParser.parseJSON(json);
            try {
                T newInstance = (T) classFieldCache.getDefaultConstructorForConcreteTypeOf(expectedType).newInstance(new Object[0]);
                List<Runnable> collectionElementAdders = new ArrayList<>();
                populateObjectFromJsonObject(newInstance, expectedType, parsedJSON, classFieldCache, getInitialIdToObjectMap(newInstance, parsedJSON), collectionElementAdders);
                for (Runnable runnable : collectionElementAdders) {
                    runnable.run();
                }
                return newInstance;
            } catch (ReflectiveOperationException | SecurityException e) {
                throw new IllegalArgumentException("Could not construct object of type " + expectedType.getName(), e);
            }
        } catch (ParseException e2) {
            throw new IllegalArgumentException("Could not parse JSON", e2);
        }
    }

    public static <T> T deserializeObject(Class<T> expectedType, String json) throws IllegalArgumentException {
        return (T) deserializeObject(expectedType, json, new ClassFieldCache(true, false));
    }

    public static void deserializeToField(Object containingObject, String fieldName, String json, ClassFieldCache classFieldCache) throws IllegalArgumentException {
        if (containingObject == null) {
            throw new IllegalArgumentException("Cannot deserialize to a field of a null object");
        }
        try {
            Object parsedJSON = JSONParser.parseJSON(json);
            JSONObject wrapperJsonObj = new JSONObject(1);
            wrapperJsonObj.items.add(new AbstractMap.SimpleEntry(fieldName, parsedJSON));
            List<Runnable> collectionElementAdders = new ArrayList<>();
            populateObjectFromJsonObject(containingObject, containingObject.getClass(), wrapperJsonObj, classFieldCache, new HashMap(), collectionElementAdders);
            for (Runnable runnable : collectionElementAdders) {
                runnable.run();
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Could not parse JSON", e);
        }
    }

    public static void deserializeToField(Object containingObject, String fieldName, String json) throws IllegalArgumentException {
        deserializeToField(containingObject, fieldName, json, new ClassFieldCache(true, false));
    }
}
