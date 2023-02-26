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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OMNAAMAIBOHOuterClass.class */
public final class OMNAAMAIBOHOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011OMNAAMAIBOH.proto\"S\n\u000bOMNAAMAIBOH\u0012\u0012\n\nisFinished\u0018\u0002 \u0001(\b\u0012\u000e\n\u0006isOpen\u0018\u0004 \u0001(\b\u0012\u000f\n\u0007stageId\u0018\f \u0001(\r\u0012\u000f\n\u0007levelId\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_OMNAAMAIBOH_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_OMNAAMAIBOH_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_OMNAAMAIBOH_descriptor, new String[]{"IsFinished", "IsOpen", "StageId", "LevelId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OMNAAMAIBOHOuterClass$OMNAAMAIBOHOrBuilder.class */
    public interface OMNAAMAIBOHOrBuilder extends MessageOrBuilder {
        boolean getIsFinished();

        boolean getIsOpen();

        int getStageId();

        int getLevelId();
    }

    private OMNAAMAIBOHOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OMNAAMAIBOHOuterClass$OMNAAMAIBOH.class */
    public static final class OMNAAMAIBOH extends GeneratedMessageV3 implements OMNAAMAIBOHOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISFINISHED_FIELD_NUMBER = 2;
        private boolean isFinished_;
        public static final int ISOPEN_FIELD_NUMBER = 4;
        private boolean isOpen_;
        public static final int STAGEID_FIELD_NUMBER = 12;
        private int stageId_;
        public static final int LEVELID_FIELD_NUMBER = 5;
        private int levelId_;
        private byte memoizedIsInitialized;
        private static final OMNAAMAIBOH DEFAULT_INSTANCE = new OMNAAMAIBOH();
        private static final Parser<OMNAAMAIBOH> PARSER = new AbstractParser<OMNAAMAIBOH>() { // from class: emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOH.1
            @Override // com.google.protobuf.Parser
            public OMNAAMAIBOH parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new OMNAAMAIBOH(input, extensionRegistry);
            }
        };

        private OMNAAMAIBOH(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private OMNAAMAIBOH() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new OMNAAMAIBOH();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private OMNAAMAIBOH(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.isFinished_ = input.readBool();
                                    break;
                                case 32:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 40:
                                    this.levelId_ = input.readUInt32();
                                    break;
                                case 96:
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return OMNAAMAIBOHOuterClass.internal_static_OMNAAMAIBOH_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return OMNAAMAIBOHOuterClass.internal_static_OMNAAMAIBOH_fieldAccessorTable.ensureFieldAccessorsInitialized(OMNAAMAIBOH.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
        public int getLevelId() {
            return this.levelId_;
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
            if (this.isFinished_) {
                output.writeBool(2, this.isFinished_);
            }
            if (this.isOpen_) {
                output.writeBool(4, this.isOpen_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(5, this.levelId_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(12, this.stageId_);
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
            if (this.isFinished_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isFinished_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isOpen_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.levelId_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.stageId_);
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
            if (!(obj instanceof OMNAAMAIBOH)) {
                return equals(obj);
            }
            OMNAAMAIBOH other = (OMNAAMAIBOH) obj;
            return getIsFinished() == other.getIsFinished() && getIsOpen() == other.getIsOpen() && getStageId() == other.getStageId() && getLevelId() == other.getLevelId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashBoolean(getIsFinished()))) + 4)) + Internal.hashBoolean(getIsOpen()))) + 12)) + getStageId())) + 5)) + getLevelId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static OMNAAMAIBOH parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OMNAAMAIBOH parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OMNAAMAIBOH parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OMNAAMAIBOH parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OMNAAMAIBOH parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static OMNAAMAIBOH parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static OMNAAMAIBOH parseFrom(InputStream input) throws IOException {
            return (OMNAAMAIBOH) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OMNAAMAIBOH parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OMNAAMAIBOH) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static OMNAAMAIBOH parseDelimitedFrom(InputStream input) throws IOException {
            return (OMNAAMAIBOH) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static OMNAAMAIBOH parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OMNAAMAIBOH) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static OMNAAMAIBOH parseFrom(CodedInputStream input) throws IOException {
            return (OMNAAMAIBOH) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static OMNAAMAIBOH parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (OMNAAMAIBOH) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(OMNAAMAIBOH prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/OMNAAMAIBOHOuterClass$OMNAAMAIBOH$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements OMNAAMAIBOHOrBuilder {
            private boolean isFinished_;
            private boolean isOpen_;
            private int stageId_;
            private int levelId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return OMNAAMAIBOHOuterClass.internal_static_OMNAAMAIBOH_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return OMNAAMAIBOHOuterClass.internal_static_OMNAAMAIBOH_fieldAccessorTable.ensureFieldAccessorsInitialized(OMNAAMAIBOH.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (OMNAAMAIBOH.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinished_ = false;
                this.isOpen_ = false;
                this.stageId_ = 0;
                this.levelId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return OMNAAMAIBOHOuterClass.internal_static_OMNAAMAIBOH_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public OMNAAMAIBOH getDefaultInstanceForType() {
                return OMNAAMAIBOH.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OMNAAMAIBOH build() {
                OMNAAMAIBOH result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public OMNAAMAIBOH buildPartial() {
                OMNAAMAIBOH result = new OMNAAMAIBOH(this);
                result.isFinished_ = this.isFinished_;
                result.isOpen_ = this.isOpen_;
                result.stageId_ = this.stageId_;
                result.levelId_ = this.levelId_;
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
                if (other instanceof OMNAAMAIBOH) {
                    return mergeFrom((OMNAAMAIBOH) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(OMNAAMAIBOH other) {
                if (other == OMNAAMAIBOH.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
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
                OMNAAMAIBOH parsedMessage = null;
                try {
                    try {
                        parsedMessage = OMNAAMAIBOH.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (OMNAAMAIBOH) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
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

            @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
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

            @Override // emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
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

        public static OMNAAMAIBOH getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OMNAAMAIBOH> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<OMNAAMAIBOH> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public OMNAAMAIBOH getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
