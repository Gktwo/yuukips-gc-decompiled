package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityGadgetInfoOuterClass.class */
public final class AbilityGadgetInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017AbilityGadgetInfo.proto\"X\n\u0011AbilityGadgetInfo\u0012\u000f\n\u0007camp_id\u0018\u0001 \u0001(\r\u0012\u0018\n\u0010camp_target_type\u0018\u0002 \u0001(\r\u0012\u0018\n\u0010target_entity_id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AbilityGadgetInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityGadgetInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityGadgetInfo_descriptor, new String[]{"CampId", "CampTargetType", "TargetEntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityGadgetInfoOuterClass$AbilityGadgetInfoOrBuilder.class */
    public interface AbilityGadgetInfoOrBuilder extends MessageOrBuilder {
        int getCampId();

        int getCampTargetType();

        int getTargetEntityId();
    }

    private AbilityGadgetInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityGadgetInfoOuterClass$AbilityGadgetInfo.class */
    public static final class AbilityGadgetInfo extends GeneratedMessageV3 implements AbilityGadgetInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CAMP_ID_FIELD_NUMBER = 1;
        private int campId_;
        public static final int CAMP_TARGET_TYPE_FIELD_NUMBER = 2;
        private int campTargetType_;
        public static final int TARGET_ENTITY_ID_FIELD_NUMBER = 3;
        private int targetEntityId_;
        private byte memoizedIsInitialized;
        private static final AbilityGadgetInfo DEFAULT_INSTANCE = new AbilityGadgetInfo();
        private static final Parser<AbilityGadgetInfo> PARSER = new AbstractParser<AbilityGadgetInfo>() { // from class: emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass.AbilityGadgetInfo.1
            @Override // com.google.protobuf.Parser
            public AbilityGadgetInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityGadgetInfo(input, extensionRegistry);
            }
        };

        private AbilityGadgetInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityGadgetInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityGadgetInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityGadgetInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 8:
                                    this.campId_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.campTargetType_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.targetEntityId_ = input.readUInt32();
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
                        }
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
            return AbilityGadgetInfoOuterClass.internal_static_AbilityGadgetInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityGadgetInfoOuterClass.internal_static_AbilityGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityGadgetInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder
        public int getCampId() {
            return this.campId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder
        public int getCampTargetType() {
            return this.campTargetType_;
        }

        @Override // emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder
        public int getTargetEntityId() {
            return this.targetEntityId_;
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
            if (this.campId_ != 0) {
                output.writeUInt32(1, this.campId_);
            }
            if (this.campTargetType_ != 0) {
                output.writeUInt32(2, this.campTargetType_);
            }
            if (this.targetEntityId_ != 0) {
                output.writeUInt32(3, this.targetEntityId_);
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
            if (this.campId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.campId_);
            }
            if (this.campTargetType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.campTargetType_);
            }
            if (this.targetEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.targetEntityId_);
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
            if (!(obj instanceof AbilityGadgetInfo)) {
                return equals(obj);
            }
            AbilityGadgetInfo other = (AbilityGadgetInfo) obj;
            return getCampId() == other.getCampId() && getCampTargetType() == other.getCampTargetType() && getTargetEntityId() == other.getTargetEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getCampId())) + 2)) + getCampTargetType())) + 3)) + getTargetEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AbilityGadgetInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityGadgetInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityGadgetInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityGadgetInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityGadgetInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityGadgetInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityGadgetInfo parseFrom(InputStream input) throws IOException {
            return (AbilityGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityGadgetInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityGadgetInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityGadgetInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityGadgetInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityGadgetInfo parseFrom(CodedInputStream input) throws IOException {
            return (AbilityGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityGadgetInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityGadgetInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityGadgetInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityGadgetInfoOuterClass$AbilityGadgetInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityGadgetInfoOrBuilder {
            private int campId_;
            private int campTargetType_;
            private int targetEntityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityGadgetInfoOuterClass.internal_static_AbilityGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityGadgetInfoOuterClass.internal_static_AbilityGadgetInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityGadgetInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityGadgetInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.campId_ = 0;
                this.campTargetType_ = 0;
                this.targetEntityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityGadgetInfoOuterClass.internal_static_AbilityGadgetInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityGadgetInfo getDefaultInstanceForType() {
                return AbilityGadgetInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityGadgetInfo build() {
                AbilityGadgetInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityGadgetInfo buildPartial() {
                AbilityGadgetInfo result = new AbilityGadgetInfo(this);
                result.campId_ = this.campId_;
                result.campTargetType_ = this.campTargetType_;
                result.targetEntityId_ = this.targetEntityId_;
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
                if (other instanceof AbilityGadgetInfo) {
                    return mergeFrom((AbilityGadgetInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityGadgetInfo other) {
                if (other == AbilityGadgetInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getCampId() != 0) {
                    setCampId(other.getCampId());
                }
                if (other.getCampTargetType() != 0) {
                    setCampTargetType(other.getCampTargetType());
                }
                if (other.getTargetEntityId() != 0) {
                    setTargetEntityId(other.getTargetEntityId());
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
                AbilityGadgetInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityGadgetInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityGadgetInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder
            public int getCampId() {
                return this.campId_;
            }

            public Builder setCampId(int value) {
                this.campId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCampId() {
                this.campId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder
            public int getCampTargetType() {
                return this.campTargetType_;
            }

            public Builder setCampTargetType(int value) {
                this.campTargetType_ = value;
                onChanged();
                return this;
            }

            public Builder clearCampTargetType() {
                this.campTargetType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass.AbilityGadgetInfoOrBuilder
            public int getTargetEntityId() {
                return this.targetEntityId_;
            }

            public Builder setTargetEntityId(int value) {
                this.targetEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetEntityId() {
                this.targetEntityId_ = 0;
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

        public static AbilityGadgetInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityGadgetInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityGadgetInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityGadgetInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
