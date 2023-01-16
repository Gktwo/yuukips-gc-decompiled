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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2LevelDataOuterClass.class */
public final class EffigyChallengeV2LevelDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n EffigyChallengeV2LevelData.proto\"¹\u0001\n\u001aEffigyChallengeV2LevelData\u0012\u001b\n\u0013Unk3300_PPOEMEILBIA\u0018\r \u0001(\r\u0012\u0015\n\ris_level_open\u0018\u0004 \u0001(\b\u0012\u001b\n\u0013Unk3300_KJEOADDMJMI\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_JMGACODMJLG\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013Unk3300_IJAGOAKOABH\u0018\u0007 \u0001(\r\u0012\u0010\n\blevel_id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EffigyChallengeV2LevelData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EffigyChallengeV2LevelData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EffigyChallengeV2LevelData_descriptor, new String[]{"Unk3300PPOEMEILBIA", "IsLevelOpen", "Unk3300KJEOADDMJMI", "Unk3300JMGACODMJLG", "Unk3300IJAGOAKOABH", "LevelId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2LevelDataOuterClass$EffigyChallengeV2LevelDataOrBuilder.class */
    public interface EffigyChallengeV2LevelDataOrBuilder extends MessageOrBuilder {
        int getUnk3300PPOEMEILBIA();

        boolean getIsLevelOpen();

        int getUnk3300KJEOADDMJMI();

        int getUnk3300JMGACODMJLG();

        int getUnk3300IJAGOAKOABH();

        int getLevelId();
    }

    private EffigyChallengeV2LevelDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2LevelDataOuterClass$EffigyChallengeV2LevelData.class */
    public static final class EffigyChallengeV2LevelData extends GeneratedMessageV3 implements EffigyChallengeV2LevelDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_PPOEMEILBIA_FIELD_NUMBER = 13;
        private int unk3300PPOEMEILBIA_;
        public static final int IS_LEVEL_OPEN_FIELD_NUMBER = 4;
        private boolean isLevelOpen_;
        public static final int UNK3300_KJEOADDMJMI_FIELD_NUMBER = 9;
        private int unk3300KJEOADDMJMI_;
        public static final int UNK3300_JMGACODMJLG_FIELD_NUMBER = 2;
        private int unk3300JMGACODMJLG_;
        public static final int UNK3300_IJAGOAKOABH_FIELD_NUMBER = 7;
        private int unk3300IJAGOAKOABH_;
        public static final int LEVEL_ID_FIELD_NUMBER = 12;
        private int levelId_;
        private byte memoizedIsInitialized;
        private static final EffigyChallengeV2LevelData DEFAULT_INSTANCE = new EffigyChallengeV2LevelData();
        private static final Parser<EffigyChallengeV2LevelData> PARSER = new AbstractParser<EffigyChallengeV2LevelData>() { // from class: emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelData.1
            @Override // com.google.protobuf.Parser
            public EffigyChallengeV2LevelData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EffigyChallengeV2LevelData(input, extensionRegistry);
            }
        };

        private EffigyChallengeV2LevelData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EffigyChallengeV2LevelData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EffigyChallengeV2LevelData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EffigyChallengeV2LevelData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300JMGACODMJLG_ = input.readUInt32();
                                break;
                            case 32:
                                this.isLevelOpen_ = input.readBool();
                                break;
                            case 56:
                                this.unk3300IJAGOAKOABH_ = input.readUInt32();
                                break;
                            case 72:
                                this.unk3300KJEOADDMJMI_ = input.readUInt32();
                                break;
                            case 96:
                                this.levelId_ = input.readUInt32();
                                break;
                            case 104:
                                this.unk3300PPOEMEILBIA_ = input.readUInt32();
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
            return EffigyChallengeV2LevelDataOuterClass.internal_static_EffigyChallengeV2LevelData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EffigyChallengeV2LevelDataOuterClass.internal_static_EffigyChallengeV2LevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeV2LevelData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
        public int getUnk3300PPOEMEILBIA() {
            return this.unk3300PPOEMEILBIA_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
        public boolean getIsLevelOpen() {
            return this.isLevelOpen_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
        public int getUnk3300KJEOADDMJMI() {
            return this.unk3300KJEOADDMJMI_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
        public int getUnk3300JMGACODMJLG() {
            return this.unk3300JMGACODMJLG_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
        public int getUnk3300IJAGOAKOABH() {
            return this.unk3300IJAGOAKOABH_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
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
            if (this.unk3300JMGACODMJLG_ != 0) {
                output.writeUInt32(2, this.unk3300JMGACODMJLG_);
            }
            if (this.isLevelOpen_) {
                output.writeBool(4, this.isLevelOpen_);
            }
            if (this.unk3300IJAGOAKOABH_ != 0) {
                output.writeUInt32(7, this.unk3300IJAGOAKOABH_);
            }
            if (this.unk3300KJEOADDMJMI_ != 0) {
                output.writeUInt32(9, this.unk3300KJEOADDMJMI_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(12, this.levelId_);
            }
            if (this.unk3300PPOEMEILBIA_ != 0) {
                output.writeUInt32(13, this.unk3300PPOEMEILBIA_);
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
            if (this.unk3300JMGACODMJLG_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.unk3300JMGACODMJLG_);
            }
            if (this.isLevelOpen_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isLevelOpen_);
            }
            if (this.unk3300IJAGOAKOABH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300IJAGOAKOABH_);
            }
            if (this.unk3300KJEOADDMJMI_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.unk3300KJEOADDMJMI_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.levelId_);
            }
            if (this.unk3300PPOEMEILBIA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unk3300PPOEMEILBIA_);
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
            if (!(obj instanceof EffigyChallengeV2LevelData)) {
                return equals(obj);
            }
            EffigyChallengeV2LevelData other = (EffigyChallengeV2LevelData) obj;
            return getUnk3300PPOEMEILBIA() == other.getUnk3300PPOEMEILBIA() && getIsLevelOpen() == other.getIsLevelOpen() && getUnk3300KJEOADDMJMI() == other.getUnk3300KJEOADDMJMI() && getUnk3300JMGACODMJLG() == other.getUnk3300JMGACODMJLG() && getUnk3300IJAGOAKOABH() == other.getUnk3300IJAGOAKOABH() && getLevelId() == other.getLevelId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getUnk3300PPOEMEILBIA())) + 4)) + Internal.hashBoolean(getIsLevelOpen()))) + 9)) + getUnk3300KJEOADDMJMI())) + 2)) + getUnk3300JMGACODMJLG())) + 7)) + getUnk3300IJAGOAKOABH())) + 12)) + getLevelId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EffigyChallengeV2LevelData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2LevelData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2LevelData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2LevelData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2LevelData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2LevelData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2LevelData parseFrom(InputStream input) throws IOException {
            return (EffigyChallengeV2LevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2LevelData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2LevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeV2LevelData parseDelimitedFrom(InputStream input) throws IOException {
            return (EffigyChallengeV2LevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2LevelData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2LevelData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeV2LevelData parseFrom(CodedInputStream input) throws IOException {
            return (EffigyChallengeV2LevelData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2LevelData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2LevelData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EffigyChallengeV2LevelData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2LevelDataOuterClass$EffigyChallengeV2LevelData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EffigyChallengeV2LevelDataOrBuilder {
            private int unk3300PPOEMEILBIA_;
            private boolean isLevelOpen_;
            private int unk3300KJEOADDMJMI_;
            private int unk3300JMGACODMJLG_;
            private int unk3300IJAGOAKOABH_;
            private int levelId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EffigyChallengeV2LevelDataOuterClass.internal_static_EffigyChallengeV2LevelData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EffigyChallengeV2LevelDataOuterClass.internal_static_EffigyChallengeV2LevelData_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeV2LevelData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EffigyChallengeV2LevelData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300PPOEMEILBIA_ = 0;
                this.isLevelOpen_ = false;
                this.unk3300KJEOADDMJMI_ = 0;
                this.unk3300JMGACODMJLG_ = 0;
                this.unk3300IJAGOAKOABH_ = 0;
                this.levelId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EffigyChallengeV2LevelDataOuterClass.internal_static_EffigyChallengeV2LevelData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EffigyChallengeV2LevelData getDefaultInstanceForType() {
                return EffigyChallengeV2LevelData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeV2LevelData build() {
                EffigyChallengeV2LevelData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeV2LevelData buildPartial() {
                EffigyChallengeV2LevelData result = new EffigyChallengeV2LevelData(this);
                result.unk3300PPOEMEILBIA_ = this.unk3300PPOEMEILBIA_;
                result.isLevelOpen_ = this.isLevelOpen_;
                result.unk3300KJEOADDMJMI_ = this.unk3300KJEOADDMJMI_;
                result.unk3300JMGACODMJLG_ = this.unk3300JMGACODMJLG_;
                result.unk3300IJAGOAKOABH_ = this.unk3300IJAGOAKOABH_;
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
                if (other instanceof EffigyChallengeV2LevelData) {
                    return mergeFrom((EffigyChallengeV2LevelData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EffigyChallengeV2LevelData other) {
                if (other == EffigyChallengeV2LevelData.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300PPOEMEILBIA() != 0) {
                    setUnk3300PPOEMEILBIA(other.getUnk3300PPOEMEILBIA());
                }
                if (other.getIsLevelOpen()) {
                    setIsLevelOpen(other.getIsLevelOpen());
                }
                if (other.getUnk3300KJEOADDMJMI() != 0) {
                    setUnk3300KJEOADDMJMI(other.getUnk3300KJEOADDMJMI());
                }
                if (other.getUnk3300JMGACODMJLG() != 0) {
                    setUnk3300JMGACODMJLG(other.getUnk3300JMGACODMJLG());
                }
                if (other.getUnk3300IJAGOAKOABH() != 0) {
                    setUnk3300IJAGOAKOABH(other.getUnk3300IJAGOAKOABH());
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
                EffigyChallengeV2LevelData parsedMessage = null;
                try {
                    try {
                        parsedMessage = EffigyChallengeV2LevelData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EffigyChallengeV2LevelData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
            public int getUnk3300PPOEMEILBIA() {
                return this.unk3300PPOEMEILBIA_;
            }

            public Builder setUnk3300PPOEMEILBIA(int value) {
                this.unk3300PPOEMEILBIA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PPOEMEILBIA() {
                this.unk3300PPOEMEILBIA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
            public boolean getIsLevelOpen() {
                return this.isLevelOpen_;
            }

            public Builder setIsLevelOpen(boolean value) {
                this.isLevelOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsLevelOpen() {
                this.isLevelOpen_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
            public int getUnk3300KJEOADDMJMI() {
                return this.unk3300KJEOADDMJMI_;
            }

            public Builder setUnk3300KJEOADDMJMI(int value) {
                this.unk3300KJEOADDMJMI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KJEOADDMJMI() {
                this.unk3300KJEOADDMJMI_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
            public int getUnk3300JMGACODMJLG() {
                return this.unk3300JMGACODMJLG_;
            }

            public Builder setUnk3300JMGACODMJLG(int value) {
                this.unk3300JMGACODMJLG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JMGACODMJLG() {
                this.unk3300JMGACODMJLG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
            public int getUnk3300IJAGOAKOABH() {
                return this.unk3300IJAGOAKOABH_;
            }

            public Builder setUnk3300IJAGOAKOABH(int value) {
                this.unk3300IJAGOAKOABH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300IJAGOAKOABH() {
                this.unk3300IJAGOAKOABH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2LevelDataOuterClass.EffigyChallengeV2LevelDataOrBuilder
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

        public static EffigyChallengeV2LevelData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EffigyChallengeV2LevelData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EffigyChallengeV2LevelData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EffigyChallengeV2LevelData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
