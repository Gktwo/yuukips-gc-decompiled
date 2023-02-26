package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAnimatorParameterInfoOuterClass.class */
public final class EvtAnimatorParameterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eEvtAnimatorParameterInfo.proto\u001a AnimatorParameterValueInfo.proto\"\n\u0018EvtAnimatorParameterInfo\u0012\u0010\n\bentityId\u0018\u000e \u0001(\r\u0012\u000e\n\u0006nameId\u0018\u0002 \u0001(\u0005\u0012*\n\u0005value\u0018\f \u0001(\u000b2\u001b.AnimatorParameterValueInfo\u0012\u0015\n\risServerCache\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AnimatorParameterValueInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EvtAnimatorParameterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EvtAnimatorParameterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EvtAnimatorParameterInfo_descriptor, new String[]{"EntityId", "NameId", "Value", "IsServerCache"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAnimatorParameterInfoOuterClass$EvtAnimatorParameterInfoOrBuilder.class */
    public interface EvtAnimatorParameterInfoOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getNameId();

        boolean hasValue();

        AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo getValue();

        AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder getValueOrBuilder();

        boolean getIsServerCache();
    }

    private EvtAnimatorParameterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAnimatorParameterInfoOuterClass$EvtAnimatorParameterInfo.class */
    public static final class EvtAnimatorParameterInfo extends GeneratedMessageV3 implements EvtAnimatorParameterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 14;
        private int entityId_;
        public static final int NAMEID_FIELD_NUMBER = 2;
        private int nameId_;
        public static final int VALUE_FIELD_NUMBER = 12;
        private AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo value_;
        public static final int ISSERVERCACHE_FIELD_NUMBER = 9;
        private boolean isServerCache_;
        private byte memoizedIsInitialized;
        private static final EvtAnimatorParameterInfo DEFAULT_INSTANCE = new EvtAnimatorParameterInfo();
        private static final Parser<EvtAnimatorParameterInfo> PARSER = new AbstractParser<EvtAnimatorParameterInfo>() { // from class: emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfo.1
            @Override // com.google.protobuf.Parser
            public EvtAnimatorParameterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EvtAnimatorParameterInfo(input, extensionRegistry);
            }
        };

        private EvtAnimatorParameterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EvtAnimatorParameterInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EvtAnimatorParameterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EvtAnimatorParameterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 16:
                                this.nameId_ = input.readInt32();
                                break;
                            case 72:
                                this.isServerCache_ = input.readBool();
                                break;
                            case 98:
                                AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder subBuilder = this.value_ != null ? this.value_.toBuilder() : null;
                                this.value_ = (AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo) input.readMessage(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.value_);
                                    this.value_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 112:
                                this.entityId_ = input.readUInt32();
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EvtAnimatorParameterInfoOuterClass.internal_static_EvtAnimatorParameterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EvtAnimatorParameterInfoOuterClass.internal_static_EvtAnimatorParameterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAnimatorParameterInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
        public int getNameId() {
            return this.nameId_;
        }

        @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
        public boolean hasValue() {
            return this.value_ != null;
        }

        @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
        public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo getValue() {
            return this.value_ == null ? AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.getDefaultInstance() : this.value_;
        }

        @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
        public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder getValueOrBuilder() {
            return getValue();
        }

        @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
        public boolean getIsServerCache() {
            return this.isServerCache_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.nameId_ != 0) {
                output.writeInt32(2, this.nameId_);
            }
            if (this.isServerCache_) {
                output.writeBool(9, this.isServerCache_);
            }
            if (this.value_ != null) {
                output.writeMessage(12, getValue());
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(14, this.entityId_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.nameId_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(2, this.nameId_);
            }
            if (this.isServerCache_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isServerCache_);
            }
            if (this.value_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getValue());
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.entityId_);
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EvtAnimatorParameterInfo)) {
                return equals(obj);
            }
            EvtAnimatorParameterInfo other = (EvtAnimatorParameterInfo) obj;
            if (getEntityId() == other.getEntityId() && getNameId() == other.getNameId() && hasValue() == other.hasValue()) {
                return (!hasValue() || getValue().equals(other.getValue())) && getIsServerCache() == other.getIsServerCache() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getEntityId())) + 2)) + getNameId();
            if (hasValue()) {
                hash = (53 * ((37 * hash) + 12)) + getValue().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getIsServerCache()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EvtAnimatorParameterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAnimatorParameterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAnimatorParameterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAnimatorParameterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAnimatorParameterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EvtAnimatorParameterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EvtAnimatorParameterInfo parseFrom(InputStream input) throws IOException {
            return (EvtAnimatorParameterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAnimatorParameterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAnimatorParameterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAnimatorParameterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EvtAnimatorParameterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EvtAnimatorParameterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAnimatorParameterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EvtAnimatorParameterInfo parseFrom(CodedInputStream input) throws IOException {
            return (EvtAnimatorParameterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EvtAnimatorParameterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EvtAnimatorParameterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EvtAnimatorParameterInfo prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EvtAnimatorParameterInfoOuterClass$EvtAnimatorParameterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EvtAnimatorParameterInfoOrBuilder {
            private int entityId_;
            private int nameId_;
            private AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo value_;
            private SingleFieldBuilderV3<AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder> valueBuilder_;
            private boolean isServerCache_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EvtAnimatorParameterInfoOuterClass.internal_static_EvtAnimatorParameterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EvtAnimatorParameterInfoOuterClass.internal_static_EvtAnimatorParameterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EvtAnimatorParameterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EvtAnimatorParameterInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.nameId_ = 0;
                if (this.valueBuilder_ == null) {
                    this.value_ = null;
                } else {
                    this.value_ = null;
                    this.valueBuilder_ = null;
                }
                this.isServerCache_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EvtAnimatorParameterInfoOuterClass.internal_static_EvtAnimatorParameterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EvtAnimatorParameterInfo getDefaultInstanceForType() {
                return EvtAnimatorParameterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAnimatorParameterInfo build() {
                EvtAnimatorParameterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EvtAnimatorParameterInfo buildPartial() {
                EvtAnimatorParameterInfo result = new EvtAnimatorParameterInfo(this);
                result.entityId_ = this.entityId_;
                result.nameId_ = this.nameId_;
                if (this.valueBuilder_ == null) {
                    result.value_ = this.value_;
                } else {
                    result.value_ = this.valueBuilder_.build();
                }
                result.isServerCache_ = this.isServerCache_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof EvtAnimatorParameterInfo) {
                    return mergeFrom((EvtAnimatorParameterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EvtAnimatorParameterInfo other) {
                if (other == EvtAnimatorParameterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getNameId() != 0) {
                    setNameId(other.getNameId());
                }
                if (other.hasValue()) {
                    mergeValue(other.getValue());
                }
                if (other.getIsServerCache()) {
                    setIsServerCache(other.getIsServerCache());
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                EvtAnimatorParameterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EvtAnimatorParameterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EvtAnimatorParameterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
            public int getNameId() {
                return this.nameId_;
            }

            public Builder setNameId(int value) {
                this.nameId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNameId() {
                this.nameId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
            public boolean hasValue() {
                return (this.valueBuilder_ == null && this.value_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
            public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo getValue() {
                if (this.valueBuilder_ == null) {
                    return this.value_ == null ? AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.getDefaultInstance() : this.value_;
                }
                return this.valueBuilder_.getMessage();
            }

            public Builder setValue(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo value) {
                if (this.valueBuilder_ != null) {
                    this.valueBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.value_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setValue(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder builderForValue) {
                if (this.valueBuilder_ == null) {
                    this.value_ = builderForValue.build();
                    onChanged();
                } else {
                    this.valueBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeValue(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo value) {
                if (this.valueBuilder_ == null) {
                    if (this.value_ != null) {
                        this.value_ = AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.newBuilder(this.value_).mergeFrom(value).buildPartial();
                    } else {
                        this.value_ = value;
                    }
                    onChanged();
                } else {
                    this.valueBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearValue() {
                if (this.valueBuilder_ == null) {
                    this.value_ = null;
                    onChanged();
                } else {
                    this.value_ = null;
                    this.valueBuilder_ = null;
                }
                return this;
            }

            public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder getValueBuilder() {
                onChanged();
                return getValueFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
            public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder getValueOrBuilder() {
                if (this.valueBuilder_ != null) {
                    return this.valueBuilder_.getMessageOrBuilder();
                }
                return this.value_ == null ? AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.getDefaultInstance() : this.value_;
            }

            private SingleFieldBuilderV3<AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder> getValueFieldBuilder() {
                if (this.valueBuilder_ == null) {
                    this.valueBuilder_ = new SingleFieldBuilderV3<>(getValue(), getParentForChildren(), isClean());
                    this.value_ = null;
                }
                return this.valueBuilder_;
            }

            @Override // emu.grasscutter.net.proto.EvtAnimatorParameterInfoOuterClass.EvtAnimatorParameterInfoOrBuilder
            public boolean getIsServerCache() {
                return this.isServerCache_;
            }

            public Builder setIsServerCache(boolean value) {
                this.isServerCache_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsServerCache() {
                this.isServerCache_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static EvtAnimatorParameterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EvtAnimatorParameterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EvtAnimatorParameterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EvtAnimatorParameterInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AnimatorParameterValueInfoOuterClass.getDescriptor();
    }
}
