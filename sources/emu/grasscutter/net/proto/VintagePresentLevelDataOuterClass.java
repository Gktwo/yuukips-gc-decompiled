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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentLevelDataOuterClass.class */
public final class VintagePresentLevelDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dVintagePresentLevelData.proto\"_\n\u0017VintagePresentLevelData\u0012\u000e\n\u0006isOpen\u0018\u0002 \u0001(\b\u0012\u000f\n\u0007stageId\u0018\u0007 \u0001(\r\u0012\u0011\n\tpresentId\u0018\u0005 \u0001(\r\u0012\u0010\n\bisFinish\u0018\u0003 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_VintagePresentLevelData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintagePresentLevelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintagePresentLevelData_descriptor, new String[]{"IsOpen", "StageId", "PresentId", "IsFinish"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentLevelDataOuterClass$VintagePresentLevelDataOrBuilder.class */
    public interface VintagePresentLevelDataOrBuilder extends MessageOrBuilder {
        boolean getIsOpen();

        int getStageId();

        int getPresentId();

        boolean getIsFinish();
    }

    private VintagePresentLevelDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentLevelDataOuterClass$VintagePresentLevelData.class */
    public static final class VintagePresentLevelData extends GeneratedMessageV3 implements VintagePresentLevelDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISOPEN_FIELD_NUMBER = 2;
        private boolean isOpen_;
        public static final int STAGEID_FIELD_NUMBER = 7;
        private int stageId_;
        public static final int PRESENTID_FIELD_NUMBER = 5;
        private int presentId_;
        public static final int ISFINISH_FIELD_NUMBER = 3;
        private boolean isFinish_;
        private byte memoizedIsInitialized;
        private static final VintagePresentLevelData DEFAULT_INSTANCE = new VintagePresentLevelData();
        private static final Parser<VintagePresentLevelData> PARSER = new AbstractParser<VintagePresentLevelData>() { // from class: emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelData.1
            @Override // com.google.protobuf.Parser
            public VintagePresentLevelData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintagePresentLevelData(input, extensionRegistry);
            }
        };

        private VintagePresentLevelData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintagePresentLevelData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintagePresentLevelData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintagePresentLevelData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 24:
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 40:
                                    this.presentId_ = input.readUInt32();
                                    break;
                                case 56:
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
            return VintagePresentLevelDataOuterClass.internal_static_VintagePresentLevelData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintagePresentLevelDataOuterClass.internal_static_VintagePresentLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintagePresentLevelData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
        public int getPresentId() {
            return this.presentId_;
        }

        @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
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
            if (this.isOpen_) {
                output.writeBool(2, this.isOpen_);
            }
            if (this.isFinish_) {
                output.writeBool(3, this.isFinish_);
            }
            if (this.presentId_ != 0) {
                output.writeUInt32(5, this.presentId_);
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(7, this.stageId_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isOpen_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isFinish_);
            }
            if (this.presentId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.presentId_);
            }
            if (this.stageId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.stageId_);
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
            if (!(obj instanceof VintagePresentLevelData)) {
                return equals(obj);
            }
            VintagePresentLevelData other = (VintagePresentLevelData) obj;
            return getIsOpen() == other.getIsOpen() && getStageId() == other.getStageId() && getPresentId() == other.getPresentId() && getIsFinish() == other.getIsFinish() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashBoolean(getIsOpen()))) + 7)) + getStageId())) + 5)) + getPresentId())) + 3)) + Internal.hashBoolean(getIsFinish()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static VintagePresentLevelData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintagePresentLevelData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintagePresentLevelData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintagePresentLevelData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintagePresentLevelData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintagePresentLevelData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintagePresentLevelData parseFrom(InputStream input) throws IOException {
            return (VintagePresentLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintagePresentLevelData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintagePresentLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintagePresentLevelData parseDelimitedFrom(InputStream input) throws IOException {
            return (VintagePresentLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintagePresentLevelData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintagePresentLevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintagePresentLevelData parseFrom(CodedInputStream input) throws IOException {
            return (VintagePresentLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintagePresentLevelData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintagePresentLevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintagePresentLevelData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintagePresentLevelDataOuterClass$VintagePresentLevelData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintagePresentLevelDataOrBuilder {
            private boolean isOpen_;
            private int stageId_;
            private int presentId_;
            private boolean isFinish_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VintagePresentLevelDataOuterClass.internal_static_VintagePresentLevelData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintagePresentLevelDataOuterClass.internal_static_VintagePresentLevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(VintagePresentLevelData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintagePresentLevelData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isOpen_ = false;
                this.stageId_ = 0;
                this.presentId_ = 0;
                this.isFinish_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintagePresentLevelDataOuterClass.internal_static_VintagePresentLevelData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintagePresentLevelData getDefaultInstanceForType() {
                return VintagePresentLevelData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintagePresentLevelData build() {
                VintagePresentLevelData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintagePresentLevelData buildPartial() {
                VintagePresentLevelData result = new VintagePresentLevelData(this);
                result.isOpen_ = this.isOpen_;
                result.stageId_ = this.stageId_;
                result.presentId_ = this.presentId_;
                result.isFinish_ = this.isFinish_;
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
                if (other instanceof VintagePresentLevelData) {
                    return mergeFrom((VintagePresentLevelData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintagePresentLevelData other) {
                if (other == VintagePresentLevelData.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getPresentId() != 0) {
                    setPresentId(other.getPresentId());
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
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
                VintagePresentLevelData parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintagePresentLevelData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintagePresentLevelData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
            public int getPresentId() {
                return this.presentId_;
            }

            public Builder setPresentId(int value) {
                this.presentId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPresentId() {
                this.presentId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.VintagePresentLevelDataOuterClass.VintagePresentLevelDataOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
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

        public static VintagePresentLevelData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintagePresentLevelData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintagePresentLevelData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintagePresentLevelData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
