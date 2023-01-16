package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessage.Builder;
import com.google.protobuf.MessageOrBuilder;

/* loaded from: grasscutter.jar:com/google/protobuf/SingleFieldBuilderV3.class */
public class SingleFieldBuilderV3<MType extends AbstractMessage, BType extends AbstractMessage.Builder, IType extends MessageOrBuilder> implements AbstractMessage.BuilderParent {
    private AbstractMessage.BuilderParent parent;
    private BType builder;
    private MType message;
    private boolean isClean;

    public SingleFieldBuilderV3(MType message, AbstractMessage.BuilderParent parent, boolean isClean) {
        this.message = (MType) ((AbstractMessage) Internal.checkNotNull(message));
        this.parent = parent;
        this.isClean = isClean;
    }

    public void dispose() {
        this.parent = null;
    }

    public MType getMessage() {
        if (this.message == null) {
            this.message = (MType) ((AbstractMessage) this.builder.buildPartial());
        }
        return this.message;
    }

    public MType build() {
        this.isClean = true;
        return getMessage();
    }

    public BType getBuilder() {
        if (this.builder == null) {
            this.builder = (BType) ((AbstractMessage.Builder) this.message.newBuilderForType(this));
            this.builder.mergeFrom(this.message);
            this.builder.markClean();
        }
        return this.builder;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [MType extends com.google.protobuf.AbstractMessage, IType extends com.google.protobuf.MessageOrBuilder] */
    /* JADX WARN: Type inference failed for: r0v5, types: [BType extends com.google.protobuf.AbstractMessage$Builder, IType extends com.google.protobuf.MessageOrBuilder] */
    public IType getMessageOrBuilder() {
        if (this.builder != null) {
            return this.builder;
        }
        return this.message;
    }

    public SingleFieldBuilderV3<MType, BType, IType> setMessage(MType message) {
        this.message = (MType) ((AbstractMessage) Internal.checkNotNull(message));
        if (this.builder != null) {
            this.builder.dispose();
            this.builder = null;
        }
        onChanged();
        return this;
    }

    public SingleFieldBuilderV3<MType, BType, IType> mergeFrom(MType value) {
        if (this.builder == null && this.message == this.message.getDefaultInstanceForType()) {
            this.message = value;
        } else {
            getBuilder().mergeFrom(value);
        }
        onChanged();
        return this;
    }

    public SingleFieldBuilderV3<MType, BType, IType> clear() {
        MessageLite messageLite;
        if (this.message != null) {
            messageLite = this.message.getDefaultInstanceForType();
        } else {
            messageLite = this.builder.getDefaultInstanceForType();
        }
        this.message = (MType) ((AbstractMessage) messageLite);
        if (this.builder != null) {
            this.builder.dispose();
            this.builder = null;
        }
        onChanged();
        return this;
    }

    private void onChanged() {
        if (this.builder != null) {
            this.message = null;
        }
        if (this.isClean && this.parent != null) {
            this.parent.markDirty();
            this.isClean = false;
        }
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }
}
