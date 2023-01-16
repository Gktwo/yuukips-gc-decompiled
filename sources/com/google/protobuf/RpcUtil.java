package com.google.protobuf;

/* loaded from: grasscutter.jar:com/google/protobuf/RpcUtil.class */
public final class RpcUtil {
    private RpcUtil() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.protobuf.RpcCallback<com.google.protobuf.Message> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <Type extends Message> RpcCallback<Type> specializeCallback(RpcCallback<Message> originalCallback) {
        return originalCallback;
    }

    public static <Type extends Message> RpcCallback<Message> generalizeCallback(final RpcCallback<Type> originalCallback, final Class<Type> originalClass, final Type defaultInstance) {
        return new RpcCallback<Message>() { // from class: com.google.protobuf.RpcUtil.1
            public void run(Message parameter) {
                Message message;
                try {
                    message = (Message) originalClass.cast(parameter);
                } catch (ClassCastException e) {
                    message = RpcUtil.copyAsType(defaultInstance, parameter);
                }
                originalCallback.run(message);
            }
        };
    }

    /* access modifiers changed from: private */
    public static <Type extends Message> Type copyAsType(Type typeDefaultInstance, Message source) {
        return (Type) typeDefaultInstance.newBuilderForType().mergeFrom(source).build();
    }

    public static <ParameterType> RpcCallback<ParameterType> newOneTimeCallback(final RpcCallback<ParameterType> originalCallback) {
        return new RpcCallback<ParameterType>() { // from class: com.google.protobuf.RpcUtil.2
            private boolean alreadyCalled = false;

            @Override // com.google.protobuf.RpcCallback
            public void run(ParameterType parameter) {
                synchronized (this) {
                    if (this.alreadyCalled) {
                        throw new AlreadyCalledException();
                    }
                    this.alreadyCalled = true;
                }
                originalCallback.run(parameter);
            }
        };
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/RpcUtil$AlreadyCalledException.class */
    public static final class AlreadyCalledException extends RuntimeException {
        private static final long serialVersionUID = 5469741279507848266L;

        public AlreadyCalledException() {
            super("This RpcCallback was already called and cannot be called multiple times.");
        }
    }
}
