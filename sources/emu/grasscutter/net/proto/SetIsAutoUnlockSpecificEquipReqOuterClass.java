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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetIsAutoUnlockSpecificEquipReqOuterClass.class */
public final class SetIsAutoUnlockSpecificEquipReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%SetIsAutoUnlockSpecificEquipReq.proto\"H\n\u001fSetIsAutoUnlockSpecificEquipReq\u0012%\n\u001dis_auto_unlock_specific_equip\u0018\b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SetIsAutoUnlockSpecificEquipReq_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_SetIsAutoUnlockSpecificEquipReq_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f872x184c11dc = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetIsAutoUnlockSpecificEquipReq_descriptor, new String[]{"IsAutoUnlockSpecificEquip"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetIsAutoUnlockSpecificEquipReqOuterClass$SetIsAutoUnlockSpecificEquipReqOrBuilder.class */
    public interface SetIsAutoUnlockSpecificEquipReqOrBuilder extends MessageOrBuilder {
        boolean getIsAutoUnlockSpecificEquip();
    }

    private SetIsAutoUnlockSpecificEquipReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetIsAutoUnlockSpecificEquipReqOuterClass$SetIsAutoUnlockSpecificEquipReq.class */
    public static final class SetIsAutoUnlockSpecificEquipReq extends GeneratedMessageV3 implements SetIsAutoUnlockSpecificEquipReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_AUTO_UNLOCK_SPECIFIC_EQUIP_FIELD_NUMBER = 8;
        private boolean isAutoUnlockSpecificEquip_;
        private byte memoizedIsInitialized;
        private static final SetIsAutoUnlockSpecificEquipReq DEFAULT_INSTANCE = new SetIsAutoUnlockSpecificEquipReq();
        private static final Parser<SetIsAutoUnlockSpecificEquipReq> PARSER = new AbstractParser<SetIsAutoUnlockSpecificEquipReq>() { // from class: emu.grasscutter.net.proto.SetIsAutoUnlockSpecificEquipReqOuterClass.SetIsAutoUnlockSpecificEquipReq.1
            @Override // com.google.protobuf.Parser
            public SetIsAutoUnlockSpecificEquipReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetIsAutoUnlockSpecificEquipReq(input, extensionRegistry);
            }
        };

        private SetIsAutoUnlockSpecificEquipReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetIsAutoUnlockSpecificEquipReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetIsAutoUnlockSpecificEquipReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetIsAutoUnlockSpecificEquipReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.isAutoUnlockSpecificEquip_ = input.readBool();
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
            return SetIsAutoUnlockSpecificEquipReqOuterClass.internal_static_SetIsAutoUnlockSpecificEquipReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetIsAutoUnlockSpecificEquipReqOuterClass.f872x184c11dc.ensureFieldAccessorsInitialized(SetIsAutoUnlockSpecificEquipReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetIsAutoUnlockSpecificEquipReqOuterClass.SetIsAutoUnlockSpecificEquipReqOrBuilder
        public boolean getIsAutoUnlockSpecificEquip() {
            return this.isAutoUnlockSpecificEquip_;
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
            if (this.isAutoUnlockSpecificEquip_) {
                output.writeBool(8, this.isAutoUnlockSpecificEquip_);
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
            if (this.isAutoUnlockSpecificEquip_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(8, this.isAutoUnlockSpecificEquip_);
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
            if (!(obj instanceof SetIsAutoUnlockSpecificEquipReq)) {
                return equals(obj);
            }
            SetIsAutoUnlockSpecificEquipReq other = (SetIsAutoUnlockSpecificEquipReq) obj;
            return getIsAutoUnlockSpecificEquip() == other.getIsAutoUnlockSpecificEquip() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsAutoUnlockSpecificEquip()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(InputStream input) throws IOException {
            return (SetIsAutoUnlockSpecificEquipReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetIsAutoUnlockSpecificEquipReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseDelimitedFrom(InputStream input) throws IOException {
            return (SetIsAutoUnlockSpecificEquipReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetIsAutoUnlockSpecificEquipReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(CodedInputStream input) throws IOException {
            return (SetIsAutoUnlockSpecificEquipReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetIsAutoUnlockSpecificEquipReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetIsAutoUnlockSpecificEquipReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetIsAutoUnlockSpecificEquipReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetIsAutoUnlockSpecificEquipReqOuterClass$SetIsAutoUnlockSpecificEquipReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetIsAutoUnlockSpecificEquipReqOrBuilder {
            private boolean isAutoUnlockSpecificEquip_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetIsAutoUnlockSpecificEquipReqOuterClass.internal_static_SetIsAutoUnlockSpecificEquipReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetIsAutoUnlockSpecificEquipReqOuterClass.f872x184c11dc.ensureFieldAccessorsInitialized(SetIsAutoUnlockSpecificEquipReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetIsAutoUnlockSpecificEquipReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isAutoUnlockSpecificEquip_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetIsAutoUnlockSpecificEquipReqOuterClass.internal_static_SetIsAutoUnlockSpecificEquipReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetIsAutoUnlockSpecificEquipReq getDefaultInstanceForType() {
                return SetIsAutoUnlockSpecificEquipReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetIsAutoUnlockSpecificEquipReq build() {
                SetIsAutoUnlockSpecificEquipReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetIsAutoUnlockSpecificEquipReq buildPartial() {
                SetIsAutoUnlockSpecificEquipReq result = new SetIsAutoUnlockSpecificEquipReq(this);
                result.isAutoUnlockSpecificEquip_ = this.isAutoUnlockSpecificEquip_;
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
                if (other instanceof SetIsAutoUnlockSpecificEquipReq) {
                    return mergeFrom((SetIsAutoUnlockSpecificEquipReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetIsAutoUnlockSpecificEquipReq other) {
                if (other == SetIsAutoUnlockSpecificEquipReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsAutoUnlockSpecificEquip()) {
                    setIsAutoUnlockSpecificEquip(other.getIsAutoUnlockSpecificEquip());
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
                SetIsAutoUnlockSpecificEquipReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetIsAutoUnlockSpecificEquipReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetIsAutoUnlockSpecificEquipReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetIsAutoUnlockSpecificEquipReqOuterClass.SetIsAutoUnlockSpecificEquipReqOrBuilder
            public boolean getIsAutoUnlockSpecificEquip() {
                return this.isAutoUnlockSpecificEquip_;
            }

            public Builder setIsAutoUnlockSpecificEquip(boolean value) {
                this.isAutoUnlockSpecificEquip_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsAutoUnlockSpecificEquip() {
                this.isAutoUnlockSpecificEquip_ = false;
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

        public static SetIsAutoUnlockSpecificEquipReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetIsAutoUnlockSpecificEquipReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetIsAutoUnlockSpecificEquipReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetIsAutoUnlockSpecificEquipReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
