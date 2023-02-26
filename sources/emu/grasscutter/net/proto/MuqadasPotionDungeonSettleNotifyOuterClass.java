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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionDungeonSettleNotifyOuterClass.class */
public final class MuqadasPotionDungeonSettleNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&MuqadasPotionDungeonSettleNotify.proto\"\u0001\n MuqadasPotionDungeonSettleNotify\u0012\u000f\n\u0007levelId\u0018\u000b \u0001(\r\u0012\u001c\n\u0014captureWeaknessCount\u0018\u0007 \u0001(\r\u0012\u0012\n\nfinalScore\u0018\u000e \u0001(\r\u0012\u0011\n\tisSuccess\u0018\u0003 \u0001(\b\u0012\u0013\n\u000bisNewRecord\u0018\u0002 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MuqadasPotionDungeonSettleNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_MuqadasPotionDungeonSettleNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f784x29e6bf40 = new GeneratedMessageV3.FieldAccessorTable(internal_static_MuqadasPotionDungeonSettleNotify_descriptor, new String[]{"LevelId", "CaptureWeaknessCount", "FinalScore", "IsSuccess", "IsNewRecord"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionDungeonSettleNotifyOuterClass$MuqadasPotionDungeonSettleNotifyOrBuilder.class */
    public interface MuqadasPotionDungeonSettleNotifyOrBuilder extends MessageOrBuilder {
        int getLevelId();

        int getCaptureWeaknessCount();

        int getFinalScore();

        boolean getIsSuccess();

        boolean getIsNewRecord();
    }

    private MuqadasPotionDungeonSettleNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionDungeonSettleNotifyOuterClass$MuqadasPotionDungeonSettleNotify.class */
    public static final class MuqadasPotionDungeonSettleNotify extends GeneratedMessageV3 implements MuqadasPotionDungeonSettleNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELID_FIELD_NUMBER = 11;
        private int levelId_;
        public static final int CAPTUREWEAKNESSCOUNT_FIELD_NUMBER = 7;
        private int captureWeaknessCount_;
        public static final int FINALSCORE_FIELD_NUMBER = 14;
        private int finalScore_;
        public static final int ISSUCCESS_FIELD_NUMBER = 3;
        private boolean isSuccess_;
        public static final int ISNEWRECORD_FIELD_NUMBER = 2;
        private boolean isNewRecord_;
        private byte memoizedIsInitialized;
        private static final MuqadasPotionDungeonSettleNotify DEFAULT_INSTANCE = new MuqadasPotionDungeonSettleNotify();
        private static final Parser<MuqadasPotionDungeonSettleNotify> PARSER = new AbstractParser<MuqadasPotionDungeonSettleNotify>() { // from class: emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotify.1
            @Override // com.google.protobuf.Parser
            public MuqadasPotionDungeonSettleNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MuqadasPotionDungeonSettleNotify(input, extensionRegistry);
            }
        };

        private MuqadasPotionDungeonSettleNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MuqadasPotionDungeonSettleNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MuqadasPotionDungeonSettleNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MuqadasPotionDungeonSettleNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isNewRecord_ = input.readBool();
                                break;
                            case 24:
                                this.isSuccess_ = input.readBool();
                                break;
                            case 56:
                                this.captureWeaknessCount_ = input.readUInt32();
                                break;
                            case 88:
                                this.levelId_ = input.readUInt32();
                                break;
                            case 112:
                                this.finalScore_ = input.readUInt32();
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
            return MuqadasPotionDungeonSettleNotifyOuterClass.internal_static_MuqadasPotionDungeonSettleNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MuqadasPotionDungeonSettleNotifyOuterClass.f784x29e6bf40.ensureFieldAccessorsInitialized(MuqadasPotionDungeonSettleNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
        public int getCaptureWeaknessCount() {
            return this.captureWeaknessCount_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
        public int getFinalScore() {
            return this.finalScore_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
        public boolean getIsSuccess() {
            return this.isSuccess_;
        }

        @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
        public boolean getIsNewRecord() {
            return this.isNewRecord_;
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
            if (this.isNewRecord_) {
                output.writeBool(2, this.isNewRecord_);
            }
            if (this.isSuccess_) {
                output.writeBool(3, this.isSuccess_);
            }
            if (this.captureWeaknessCount_ != 0) {
                output.writeUInt32(7, this.captureWeaknessCount_);
            }
            if (this.levelId_ != 0) {
                output.writeUInt32(11, this.levelId_);
            }
            if (this.finalScore_ != 0) {
                output.writeUInt32(14, this.finalScore_);
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
            if (this.isNewRecord_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isNewRecord_);
            }
            if (this.isSuccess_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isSuccess_);
            }
            if (this.captureWeaknessCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.captureWeaknessCount_);
            }
            if (this.levelId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.levelId_);
            }
            if (this.finalScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.finalScore_);
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
            if (!(obj instanceof MuqadasPotionDungeonSettleNotify)) {
                return equals(obj);
            }
            MuqadasPotionDungeonSettleNotify other = (MuqadasPotionDungeonSettleNotify) obj;
            return getLevelId() == other.getLevelId() && getCaptureWeaknessCount() == other.getCaptureWeaknessCount() && getFinalScore() == other.getFinalScore() && getIsSuccess() == other.getIsSuccess() && getIsNewRecord() == other.getIsNewRecord() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getLevelId())) + 7)) + getCaptureWeaknessCount())) + 14)) + getFinalScore())) + 3)) + Internal.hashBoolean(getIsSuccess()))) + 2)) + Internal.hashBoolean(getIsNewRecord()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(InputStream input) throws IOException {
            return (MuqadasPotionDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MuqadasPotionDungeonSettleNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MuqadasPotionDungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MuqadasPotionDungeonSettleNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionDungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(CodedInputStream input) throws IOException {
            return (MuqadasPotionDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MuqadasPotionDungeonSettleNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MuqadasPotionDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MuqadasPotionDungeonSettleNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MuqadasPotionDungeonSettleNotifyOuterClass$MuqadasPotionDungeonSettleNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MuqadasPotionDungeonSettleNotifyOrBuilder {
            private int levelId_;
            private int captureWeaknessCount_;
            private int finalScore_;
            private boolean isSuccess_;
            private boolean isNewRecord_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MuqadasPotionDungeonSettleNotifyOuterClass.internal_static_MuqadasPotionDungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MuqadasPotionDungeonSettleNotifyOuterClass.f784x29e6bf40.ensureFieldAccessorsInitialized(MuqadasPotionDungeonSettleNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MuqadasPotionDungeonSettleNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelId_ = 0;
                this.captureWeaknessCount_ = 0;
                this.finalScore_ = 0;
                this.isSuccess_ = false;
                this.isNewRecord_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MuqadasPotionDungeonSettleNotifyOuterClass.internal_static_MuqadasPotionDungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MuqadasPotionDungeonSettleNotify getDefaultInstanceForType() {
                return MuqadasPotionDungeonSettleNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MuqadasPotionDungeonSettleNotify build() {
                MuqadasPotionDungeonSettleNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MuqadasPotionDungeonSettleNotify buildPartial() {
                MuqadasPotionDungeonSettleNotify result = new MuqadasPotionDungeonSettleNotify(this);
                result.levelId_ = this.levelId_;
                result.captureWeaknessCount_ = this.captureWeaknessCount_;
                result.finalScore_ = this.finalScore_;
                result.isSuccess_ = this.isSuccess_;
                result.isNewRecord_ = this.isNewRecord_;
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
                if (other instanceof MuqadasPotionDungeonSettleNotify) {
                    return mergeFrom((MuqadasPotionDungeonSettleNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MuqadasPotionDungeonSettleNotify other) {
                if (other == MuqadasPotionDungeonSettleNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getCaptureWeaknessCount() != 0) {
                    setCaptureWeaknessCount(other.getCaptureWeaknessCount());
                }
                if (other.getFinalScore() != 0) {
                    setFinalScore(other.getFinalScore());
                }
                if (other.getIsSuccess()) {
                    setIsSuccess(other.getIsSuccess());
                }
                if (other.getIsNewRecord()) {
                    setIsNewRecord(other.getIsNewRecord());
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
                MuqadasPotionDungeonSettleNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = MuqadasPotionDungeonSettleNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MuqadasPotionDungeonSettleNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
            public int getFinalScore() {
                return this.finalScore_;
            }

            public Builder setFinalScore(int value) {
                this.finalScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearFinalScore() {
                this.finalScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
            public boolean getIsSuccess() {
                return this.isSuccess_;
            }

            public Builder setIsSuccess(boolean value) {
                this.isSuccess_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSuccess() {
                this.isSuccess_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MuqadasPotionDungeonSettleNotifyOuterClass.MuqadasPotionDungeonSettleNotifyOrBuilder
            public boolean getIsNewRecord() {
                return this.isNewRecord_;
            }

            public Builder setIsNewRecord(boolean value) {
                this.isNewRecord_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsNewRecord() {
                this.isNewRecord_ = false;
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

        public static MuqadasPotionDungeonSettleNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MuqadasPotionDungeonSettleNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MuqadasPotionDungeonSettleNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MuqadasPotionDungeonSettleNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
