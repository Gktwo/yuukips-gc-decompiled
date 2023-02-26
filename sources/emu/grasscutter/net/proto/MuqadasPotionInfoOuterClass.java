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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionInfoOuterClass.class */
public final class MuqadasPotionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017MuqadasPotionInfo.proto\"\u0001\n\u0011MuqadasPotionInfo\u0012\"\n\u001amuqadasPotionLevelDataList\u0018\r \u0001(\r\u0012\r\n\u0005score\u0018\u000e \u0001(\r\u0012\u001b\n\u0013Unk3300_LKEICOLMPII\u0018\u0003 \u0001(\r\u0012\u001c\n\u0014captureWeaknessCount\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MuqadasPotionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MuqadasPotionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MuqadasPotionInfo_descriptor, new String[]{"MuqadasPotionLevelDataList", "Score", "Unk3300LKEICOLMPII", "CaptureWeaknessCount"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionInfoOuterClass$MuqadasPotionInfoOrBuilder.class */
    public interface MuqadasPotionInfoOrBuilder extends MessageOrBuilder {
        int getMuqadasPotionLevelDataList();

        int getScore();

        int getUnk3300LKEICOLMPII();

        int getCaptureWeaknessCount();
    }

    private MuqadasPotionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionInfoOuterClass$MuqadasPotionInfo.class */
    public static final class MuqadasPotionInfo extends GeneratedMessageV3 implements MuqadasPotionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MUQADASPOTIONLEVELDATALIST_FIELD_NUMBER = 13;
        private int muqadasPotionLevelDataList_;
        public static final int SCORE_FIELD_NUMBER = 14;
        private int score_;
        public static final int UNK3300_LKEICOLMPII_FIELD_NUMBER = 3;
        private int unk3300LKEICOLMPII_;
        public static final int CAPTUREWEAKNESSCOUNT_FIELD_NUMBER = 5;
        private int captureWeaknessCount_;
        private byte memoizedIsInitialized;
        private static final MuqadasPotionInfo DEFAULT_INSTANCE = new MuqadasPotionInfo();
        private static final Parser<MuqadasPotionInfo> PARSER = new AbstractParser<MuqadasPotionInfo>() { // from class: emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfo.1
            @Override // com.google.protobuf.Parser
            public MuqadasPotionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MuqadasPotionInfo(input, extensionRegistry);
            }
        };

        private MuqadasPotionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MuqadasPotionInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MuqadasPotionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MuqadasPotionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.unk3300LKEICOLMPII_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.captureWeaknessCount_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.muqadasPotionLevelDataList_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.score_ = input.readUInt32();
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
            return MuqadasPotionInfoOuterClass.internal_static_MuqadasPotionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MuqadasPotionInfoOuterClass.internal_static_MuqadasPotionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MuqadasPotionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
        public int getMuqadasPotionLevelDataList() {
            return this.muqadasPotionLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
        public int getUnk3300LKEICOLMPII() {
            return this.unk3300LKEICOLMPII_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
        public int getCaptureWeaknessCount() {
            return this.captureWeaknessCount_;
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
            if (this.unk3300LKEICOLMPII_ != 0) {
                output.writeUInt32(3, this.unk3300LKEICOLMPII_);
            }
            if (this.captureWeaknessCount_ != 0) {
                output.writeUInt32(5, this.captureWeaknessCount_);
            }
            if (this.muqadasPotionLevelDataList_ != 0) {
                output.writeUInt32(13, this.muqadasPotionLevelDataList_);
            }
            if (this.score_ != 0) {
                output.writeUInt32(14, this.score_);
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
            if (this.unk3300LKEICOLMPII_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.unk3300LKEICOLMPII_);
            }
            if (this.captureWeaknessCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.captureWeaknessCount_);
            }
            if (this.muqadasPotionLevelDataList_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.muqadasPotionLevelDataList_);
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.score_);
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
            if (!(obj instanceof MuqadasPotionInfo)) {
                return equals(obj);
            }
            MuqadasPotionInfo other = (MuqadasPotionInfo) obj;
            return getMuqadasPotionLevelDataList() == other.getMuqadasPotionLevelDataList() && getScore() == other.getScore() && getUnk3300LKEICOLMPII() == other.getUnk3300LKEICOLMPII() && getCaptureWeaknessCount() == other.getCaptureWeaknessCount() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getMuqadasPotionLevelDataList())) + 14)) + getScore())) + 3)) + getUnk3300LKEICOLMPII())) + 5)) + getCaptureWeaknessCount())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MuqadasPotionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionInfo parseFrom(InputStream input) throws IOException {
            return (MuqadasPotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MuqadasPotionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MuqadasPotionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MuqadasPotionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MuqadasPotionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MuqadasPotionInfo parseFrom(CodedInputStream input) throws IOException {
            return (MuqadasPotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MuqadasPotionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MuqadasPotionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionInfoOuterClass$MuqadasPotionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MuqadasPotionInfoOrBuilder {
            private int muqadasPotionLevelDataList_;
            private int score_;
            private int unk3300LKEICOLMPII_;
            private int captureWeaknessCount_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MuqadasPotionInfoOuterClass.internal_static_MuqadasPotionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MuqadasPotionInfoOuterClass.internal_static_MuqadasPotionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MuqadasPotionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MuqadasPotionInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.muqadasPotionLevelDataList_ = 0;
                this.score_ = 0;
                this.unk3300LKEICOLMPII_ = 0;
                this.captureWeaknessCount_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MuqadasPotionInfoOuterClass.internal_static_MuqadasPotionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MuqadasPotionInfo getDefaultInstanceForType() {
                return MuqadasPotionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MuqadasPotionInfo build() {
                MuqadasPotionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MuqadasPotionInfo buildPartial() {
                MuqadasPotionInfo result = new MuqadasPotionInfo(this);
                result.muqadasPotionLevelDataList_ = this.muqadasPotionLevelDataList_;
                result.score_ = this.score_;
                result.unk3300LKEICOLMPII_ = this.unk3300LKEICOLMPII_;
                result.captureWeaknessCount_ = this.captureWeaknessCount_;
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
                if (other instanceof MuqadasPotionInfo) {
                    return mergeFrom((MuqadasPotionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MuqadasPotionInfo other) {
                if (other == MuqadasPotionInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getMuqadasPotionLevelDataList() != 0) {
                    setMuqadasPotionLevelDataList(other.getMuqadasPotionLevelDataList());
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
                }
                if (other.getUnk3300LKEICOLMPII() != 0) {
                    setUnk3300LKEICOLMPII(other.getUnk3300LKEICOLMPII());
                }
                if (other.getCaptureWeaknessCount() != 0) {
                    setCaptureWeaknessCount(other.getCaptureWeaknessCount());
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
                MuqadasPotionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MuqadasPotionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MuqadasPotionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
            public int getMuqadasPotionLevelDataList() {
                return this.muqadasPotionLevelDataList_;
            }

            public Builder setMuqadasPotionLevelDataList(int value) {
                this.muqadasPotionLevelDataList_ = value;
                onChanged();
                return this;
            }

            public Builder clearMuqadasPotionLevelDataList() {
                this.muqadasPotionLevelDataList_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
            public int getUnk3300LKEICOLMPII() {
                return this.unk3300LKEICOLMPII_;
            }

            public Builder setUnk3300LKEICOLMPII(int value) {
                this.unk3300LKEICOLMPII_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LKEICOLMPII() {
                this.unk3300LKEICOLMPII_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder
            public int getCaptureWeaknessCount() {
                return this.captureWeaknessCount_;
            }

            public Builder setCaptureWeaknessCount(int value) {
                this.captureWeaknessCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCaptureWeaknessCount() {
                this.captureWeaknessCount_ = 0;
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

        public static MuqadasPotionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MuqadasPotionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MuqadasPotionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MuqadasPotionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
