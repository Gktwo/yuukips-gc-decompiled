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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DKOBFHFONLMOuterClass.class */
public final class DKOBFHFONLMOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011DKOBFHFONLM.proto\"E\n\u000bDKOBFHFONLM\u0012\u000f\n\u0007levelId\u0018\u0002 \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\u0007 \u0001(\b\u0012\u0015\n\rminFinishTime\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DKOBFHFONLM_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DKOBFHFONLM_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DKOBFHFONLM_descriptor, new String[]{"LevelId", "IsOpen", "MinFinishTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DKOBFHFONLMOuterClass$DKOBFHFONLMOrBuilder.class */
    public interface DKOBFHFONLMOrBuilder extends MessageOrBuilder {
        int getLevelId();

        boolean getIsOpen();

        int getMinFinishTime();
    }

    private DKOBFHFONLMOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DKOBFHFONLMOuterClass$DKOBFHFONLM.class */
    public static final class DKOBFHFONLM extends GeneratedMessageV3 implements DKOBFHFONLMOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELID_FIELD_NUMBER = 2;
        private int levelId_;
        public static final int ISOPEN_FIELD_NUMBER = 7;
        private boolean isOpen_;
        public static final int MINFINISHTIME_FIELD_NUMBER = 12;
        private int minFinishTime_;
        private byte memoizedIsInitialized;
        private static final DKOBFHFONLM DEFAULT_INSTANCE = new DKOBFHFONLM();
        private static final Parser<DKOBFHFONLM> PARSER = new AbstractParser<DKOBFHFONLM>() { // from class: emu.grasscutter.net.proto.DKOBFHFONLMOuterClass.DKOBFHFONLM.1
            @Override // com.google.protobuf.Parser
            public DKOBFHFONLM parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DKOBFHFONLM(input, extensionRegistry);
            }
        };

        private DKOBFHFONLM(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DKOBFHFONLM() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DKOBFHFONLM();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DKOBFHFONLM(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.levelId_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 96:
                                    this.minFinishTime_ = input.readUInt32();
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
            return DKOBFHFONLMOuterClass.internal_static_DKOBFHFONLM_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DKOBFHFONLMOuterClass.internal_static_DKOBFHFONLM_fieldAccessorTable.ensureFieldAccessorsInitialized(DKOBFHFONLM.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DKOBFHFONLMOuterClass.DKOBFHFONLMOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.DKOBFHFONLMOuterClass.DKOBFHFONLMOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.DKOBFHFONLMOuterClass.DKOBFHFONLMOrBuilder
        public int getMinFinishTime() {
            return this.minFinishTime_;
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
            if (this.levelId_ != 0) {
                output.writeUInt32(2, this.levelId_);
            }
            if (this.isOpen_) {
                output.writeBool(7, this.isOpen_);
            }
            if (this.minFinishTime_ != 0) {
                output.writeUInt32(12, this.minFinishTime_);
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
            if (this.levelId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.levelId_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isOpen_);
            }
            if (this.minFinishTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.minFinishTime_);
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
            if (!(obj instanceof DKOBFHFONLM)) {
                return equals(obj);
            }
            DKOBFHFONLM other = (DKOBFHFONLM) obj;
            return getLevelId() == other.getLevelId() && getIsOpen() == other.getIsOpen() && getMinFinishTime() == other.getMinFinishTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getLevelId())) + 7)) + Internal.hashBoolean(getIsOpen()))) + 12)) + getMinFinishTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DKOBFHFONLM parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DKOBFHFONLM parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DKOBFHFONLM parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DKOBFHFONLM parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DKOBFHFONLM parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DKOBFHFONLM parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DKOBFHFONLM parseFrom(InputStream input) throws IOException {
            return (DKOBFHFONLM) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DKOBFHFONLM parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DKOBFHFONLM) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DKOBFHFONLM parseDelimitedFrom(InputStream input) throws IOException {
            return (DKOBFHFONLM) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DKOBFHFONLM parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DKOBFHFONLM) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DKOBFHFONLM parseFrom(CodedInputStream input) throws IOException {
            return (DKOBFHFONLM) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DKOBFHFONLM parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DKOBFHFONLM) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DKOBFHFONLM prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DKOBFHFONLMOuterClass$DKOBFHFONLM$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DKOBFHFONLMOrBuilder {
            private int levelId_;
            private boolean isOpen_;
            private int minFinishTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DKOBFHFONLMOuterClass.internal_static_DKOBFHFONLM_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DKOBFHFONLMOuterClass.internal_static_DKOBFHFONLM_fieldAccessorTable.ensureFieldAccessorsInitialized(DKOBFHFONLM.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DKOBFHFONLM.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelId_ = 0;
                this.isOpen_ = false;
                this.minFinishTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DKOBFHFONLMOuterClass.internal_static_DKOBFHFONLM_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DKOBFHFONLM getDefaultInstanceForType() {
                return DKOBFHFONLM.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DKOBFHFONLM build() {
                DKOBFHFONLM result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DKOBFHFONLM buildPartial() {
                DKOBFHFONLM result = new DKOBFHFONLM(this);
                result.levelId_ = this.levelId_;
                result.isOpen_ = this.isOpen_;
                result.minFinishTime_ = this.minFinishTime_;
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
                if (other instanceof DKOBFHFONLM) {
                    return mergeFrom((DKOBFHFONLM) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DKOBFHFONLM other) {
                if (other == DKOBFHFONLM.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getMinFinishTime() != 0) {
                    setMinFinishTime(other.getMinFinishTime());
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
                DKOBFHFONLM parsedMessage = null;
                try {
                    try {
                        parsedMessage = DKOBFHFONLM.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DKOBFHFONLM) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DKOBFHFONLMOuterClass.DKOBFHFONLMOrBuilder
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

            @Override // emu.grasscutter.net.proto.DKOBFHFONLMOuterClass.DKOBFHFONLMOrBuilder
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

            @Override // emu.grasscutter.net.proto.DKOBFHFONLMOuterClass.DKOBFHFONLMOrBuilder
            public int getMinFinishTime() {
                return this.minFinishTime_;
            }

            public Builder setMinFinishTime(int value) {
                this.minFinishTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearMinFinishTime() {
                this.minFinishTime_ = 0;
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

        public static DKOBFHFONLM getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DKOBFHFONLM> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DKOBFHFONLM> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DKOBFHFONLM getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
