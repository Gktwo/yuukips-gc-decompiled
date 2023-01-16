package com.google.protobuf;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/ManifestSchemaFactory.class */
public final class ManifestSchemaFactory implements SchemaFactory {
    private final MessageInfoFactory messageInfoFactory;
    private static final MessageInfoFactory EMPTY_FACTORY = new MessageInfoFactory() { // from class: com.google.protobuf.ManifestSchemaFactory.1
        @Override // com.google.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> clazz) {
            return false;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> clazz) {
            throw new IllegalStateException("This should never be called.");
        }
    };

    public ManifestSchemaFactory() {
        this(getDefaultMessageInfoFactory());
    }

    private ManifestSchemaFactory(MessageInfoFactory messageInfoFactory) {
        this.messageInfoFactory = (MessageInfoFactory) Internal.checkNotNull(messageInfoFactory, "messageInfoFactory");
    }

    @Override // com.google.protobuf.SchemaFactory
    public <T> Schema<T> createSchema(Class<T> messageType) {
        SchemaUtil.requireGeneratedMessage(messageType);
        MessageInfo messageInfo = this.messageInfoFactory.messageInfoFor(messageType);
        if (!messageInfo.isMessageSetWireFormat()) {
            return newSchema(messageType, messageInfo);
        }
        if (GeneratedMessageLite.class.isAssignableFrom(messageType)) {
            return MessageSetSchema.newSchema(SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.lite(), messageInfo.getDefaultInstance());
        }
        return MessageSetSchema.newSchema(SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.full(), messageInfo.getDefaultInstance());
    }

    private static <T> Schema<T> newSchema(Class<T> messageType, MessageInfo messageInfo) {
        if (GeneratedMessageLite.class.isAssignableFrom(messageType)) {
            if (isProto2(messageInfo)) {
                return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.lite(), ListFieldSchema.lite(), SchemaUtil.unknownFieldSetLiteSchema(), ExtensionSchemas.lite(), MapFieldSchemas.lite());
            }
            return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.lite(), ListFieldSchema.lite(), SchemaUtil.unknownFieldSetLiteSchema(), null, MapFieldSchemas.lite());
        } else if (isProto2(messageInfo)) {
            return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.full(), ListFieldSchema.full(), SchemaUtil.proto2UnknownFieldSetSchema(), ExtensionSchemas.full(), MapFieldSchemas.full());
        } else {
            return MessageSchema.newSchema(messageType, messageInfo, NewInstanceSchemas.full(), ListFieldSchema.full(), SchemaUtil.proto3UnknownFieldSetSchema(), null, MapFieldSchemas.full());
        }
    }

    private static boolean isProto2(MessageInfo messageInfo) {
        return messageInfo.getSyntax() == ProtoSyntax.PROTO2;
    }

    private static MessageInfoFactory getDefaultMessageInfoFactory() {
        return new CompositeMessageInfoFactory(GeneratedMessageInfoFactory.getInstance(), getDescriptorMessageInfoFactory());
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/ManifestSchemaFactory$CompositeMessageInfoFactory.class */
    public static class CompositeMessageInfoFactory implements MessageInfoFactory {
        private MessageInfoFactory[] factories;

        CompositeMessageInfoFactory(MessageInfoFactory... factories) {
            this.factories = factories;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public boolean isSupported(Class<?> clazz) {
            for (MessageInfoFactory factory : this.factories) {
                if (factory.isSupported(clazz)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.protobuf.MessageInfoFactory
        public MessageInfo messageInfoFor(Class<?> clazz) {
            MessageInfoFactory[] messageInfoFactoryArr = this.factories;
            for (MessageInfoFactory factory : messageInfoFactoryArr) {
                if (factory.isSupported(clazz)) {
                    return factory.messageInfoFor(clazz);
                }
            }
            throw new UnsupportedOperationException("No factory is available for message type: " + clazz.getName());
        }
    }

    private static MessageInfoFactory getDescriptorMessageInfoFactory() {
        try {
            return (MessageInfoFactory) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception e) {
            return EMPTY_FACTORY;
        }
    }
}
