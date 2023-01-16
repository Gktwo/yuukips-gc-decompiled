package dev.morphia.utils;

import dev.morphia.query.QueryException;

/* loaded from: grasscutter.jar:dev/morphia/utils/Assert.class */
public final class Assert {
    private Assert() {
    }

    public static void raiseError(String error) {
        throw new QueryException(error);
    }

    public static void parametersNotNull(String names, Object... objects) {
        String msgPrefix = "At least one of the parameters";
        if (objects != null) {
            if (objects.length == 1) {
                msgPrefix = "Parameter";
            }
            for (Object object : objects) {
                if (object == null) {
                    raiseError(String.format("%s '%s' is null.", msgPrefix, names));
                }
            }
        }
    }

    public static void parameterNotEmpty(String name, Iterable obj) {
        if (!obj.iterator().hasNext()) {
            raiseError(String.format("Parameter '%s' from type '%s' is expected to NOT be empty", name, obj.getClass().getName()));
        }
    }

    public static void parameterNotEmpty(String name, String value) {
        if (value != null && value.isEmpty()) {
            raiseError(String.format("Parameter '%s' is expected to NOT be empty.", name));
        }
    }
}
