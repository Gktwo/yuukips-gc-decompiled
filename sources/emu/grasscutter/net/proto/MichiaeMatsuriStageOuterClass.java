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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriStageOuterClass.class */
public final class MichiaeMatsuriStageOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019MichiaeMatsuriStage.proto\"K\n\u0013MichiaeMatsuriStage\u0012\u0010\n\bstage_id\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007is_open\u0018\u0002 \u0001(\b\u0012\u0011\n\topen_time\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MichiaeMatsuriStage_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MichiaeMatsuriStage_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MichiaeMatsuriStage_descriptor, new String[]{"StageId", "IsOpen", "OpenTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriStageOuterClass$MichiaeMatsuriStageOrBuilder.class */
    public interface MichiaeMatsuriStageOrBuilder extends MessageOrBuilder {
        int getStageId();

        boolean getIsOpen();

        int getOpenTime();
    }

    private MichiaeMatsuriStageOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriStageOuterClass$MichiaeMatsuriStage.class */
    public static final class MichiaeMatsuriStage extends GeneratedMessageV3 implements MichiaeMatsuriStageOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_ID_FIELD_NUMBER = 4;
        private int stageId_;
        public static final int IS_OPEN_FIELD_NUMBER = 2;
        private boolean isOpen_;
        public static final int OPEN_TIME_FIELD_NUMBER = 1;
        private int openTime_;
        private byte memoizedIsInitialized;
        private static final MichiaeMatsuriStage DEFAULT_INSTANCE = new MichiaeMatsuriStage();
        private static final Parser<MichiaeMatsuriStage> PARSER = new AbstractParser<MichiaeMatsuriStage>() { // from class: emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass.MichiaeMatsuriStage.1
            @Override // com.google.protobuf.Parser
            public MichiaeMatsuriStage parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MichiaeMatsuriStage(input, extensionRegistry);
            }
        };

        private MichiaeMatsuriStage(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MichiaeMatsuriStage() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MichiaeMatsuriStage();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MichiaeMatsuriStage(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.openTime_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 32:
                                    this.stageId_ = input.readUInt32();
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
            return MichiaeMatsuriStageOuterClass.internal_static_MichiaeMatsuriStage_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MichiaeMatsuriStageOuterClass.internal_static_MichiaeMatsuriStage_fieldAccessorTable.ensureFieldAccessorsInitialized(MichiaeMatsuriStage.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder
        public int getOpenTime() {
            return this.openTime_;
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
            if (this.openTime_ != 0) {
                output.writeUInt32(1, this.openTime_);
            }
            if (this.isOpen_) {
                output.writeBool(2, this.isOpen_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(4, this.stageId_);
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
            if (this.openTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.openTime_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isOpen_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.stageId_);
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
            if (!(obj instanceof MichiaeMatsuriStage)) {
                return equals(obj);
            }
            MichiaeMatsuriStage other = (MichiaeMatsuriStage) obj;
            return getStageId() == other.getStageId() && getIsOpen() == other.getIsOpen() && getOpenTime() == other.getOpenTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getStageId())) + 2)) + Internal.hashBoolean(getIsOpen()))) + 1)) + getOpenTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MichiaeMatsuriStage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriStage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriStage parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriStage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriStage parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriStage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriStage parseFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriStage) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriStage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriStage) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriStage parseDelimitedFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriStage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriStage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriStage) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriStage parseFrom(CodedInputStream input) throws IOException {
            return (MichiaeMatsuriStage) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriStage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriStage) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MichiaeMatsuriStage prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriStageOuterClass$MichiaeMatsuriStage$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MichiaeMatsuriStageOrBuilder {
            private int stageId_;
            private boolean isOpen_;
            private int openTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MichiaeMatsuriStageOuterClass.internal_static_MichiaeMatsuriStage_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MichiaeMatsuriStageOuterClass.internal_static_MichiaeMatsuriStage_fieldAccessorTable.ensureFieldAccessorsInitialized(MichiaeMatsuriStage.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MichiaeMatsuriStage.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.stageId_ = 0;
                this.isOpen_ = false;
                this.openTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MichiaeMatsuriStageOuterClass.internal_static_MichiaeMatsuriStage_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MichiaeMatsuriStage getDefaultInstanceForType() {
                return MichiaeMatsuriStage.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriStage build() {
                MichiaeMatsuriStage result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriStage buildPartial() {
                MichiaeMatsuriStage result = new MichiaeMatsuriStage(this);
                result.stageId_ = this.stageId_;
                result.isOpen_ = this.isOpen_;
                result.openTime_ = this.openTime_;
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
                if (other instanceof MichiaeMatsuriStage) {
                    return mergeFrom((MichiaeMatsuriStage) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MichiaeMatsuriStage other) {
                if (other == MichiaeMatsuriStage.getDefaultInstance()) {
                    return this;
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
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
                MichiaeMatsuriStage parsedMessage = null;
                try {
                    try {
                        parsedMessage = MichiaeMatsuriStage.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MichiaeMatsuriStage) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriStageOuterClass.MichiaeMatsuriStageOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
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

        public static MichiaeMatsuriStage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MichiaeMatsuriStage> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MichiaeMatsuriStage> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MichiaeMatsuriStage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
