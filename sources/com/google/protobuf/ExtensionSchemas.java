package com.google.protobuf;

/* loaded from: grasscutter.jar:com/google/protobuf/ExtensionSchemas.class */
final class ExtensionSchemas {
    private static final ExtensionSchema<?> LITE_SCHEMA = new ExtensionSchemaLite();
    private static final ExtensionSchema<?> FULL_SCHEMA = loadSchemaForFullRuntime();

    ExtensionSchemas() {
    }

    private static ExtensionSchema<?> loadSchemaForFullRuntime() {
        try {
            return (ExtensionSchema) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static ExtensionSchema<?> lite() {
        return LITE_SCHEMA;
    }

    /* access modifiers changed from: package-private */
    public static ExtensionSchema<?> full() {
        if (FULL_SCHEMA != null) {
            return FULL_SCHEMA;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
