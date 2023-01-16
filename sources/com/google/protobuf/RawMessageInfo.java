package com.google.protobuf;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/RawMessageInfo.class */
public final class RawMessageInfo implements MessageInfo {
    private final MessageLite defaultInstance;
    private final String info;
    private final Object[] objects;
    private final int flags;

    /* access modifiers changed from: package-private */
    public RawMessageInfo(MessageLite defaultInstance, String info, Object[] objects) {
        this.defaultInstance = defaultInstance;
        this.info = info;
        this.objects = objects;
        int position = 0 + 1;
        int value = info.charAt(0);
        if (value < 55296) {
            this.flags = value;
            return;
        }
        int result = value & 8191;
        int shift = 13;
        while (true) {
            position++;
            int value2 = info.charAt(position);
            if (value2 >= 55296) {
                result |= (value2 & 8191) << shift;
                shift += 13;
            } else {
                this.flags = result | (value2 << shift);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String getStringInfo() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public Object[] getObjects() {
        return this.objects;
    }

    @Override // com.google.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    @Override // com.google.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return (this.flags & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    @Override // com.google.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return (this.flags & 2) == 2;
    }
}
