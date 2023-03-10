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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyDailyInfoOuterClass.class */
public final class EffigyDailyInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015EffigyDailyInfo.proto\"À\u0001\n\u000fEffigyDailyInfo\u0012\u0013\n\u000bchallengeId\u0018\u000f \u0001(\r\u0012\u001e\n\u0016isFirstPassRewardTaken\u0018\u0002 \u0001(\b\u0012\u001b\n\u0013Unk3300_NEBCDALEFEC\u0018\n \u0001(\r\u0012\u0010\n\bdayIndex\u0018\u000e \u0001(\r\u0012\u0019\n\u0011challengeMaxScore\u0018\u0006 \u0001(\r\u0012\u0011\n\tbeginTime\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_NNHICCGELHP\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EffigyDailyInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EffigyDailyInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EffigyDailyInfo_descriptor, new String[]{"ChallengeId", "IsFirstPassRewardTaken", "Unk3300NEBCDALEFEC", "DayIndex", "ChallengeMaxScore", "BeginTime", "Unk3300NNHICCGELHP"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyDailyInfoOuterClass$EffigyDailyInfoOrBuilder.class */
    public interface EffigyDailyInfoOrBuilder extends MessageOrBuilder {
        int getChallengeId();

        boolean getIsFirstPassRewardTaken();

        int getUnk3300NEBCDALEFEC();

        int getDayIndex();

        int getChallengeMaxScore();

        int getBeginTime();

        int getUnk3300NNHICCGELHP();
    }

    private EffigyDailyInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyDailyInfoOuterClass$EffigyDailyInfo.class */
    public static final class EffigyDailyInfo extends GeneratedMessageV3 implements EffigyDailyInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHALLENGEID_FIELD_NUMBER = 15;
        private int challengeId_;
        public static final int ISFIRSTPASSREWARDTAKEN_FIELD_NUMBER = 2;
        private boolean isFirstPassRewardTaken_;
        public static final int UNK3300_NEBCDALEFEC_FIELD_NUMBER = 10;
        private int unk3300NEBCDALEFEC_;
        public static final int DAYINDEX_FIELD_NUMBER = 14;
        private int dayIndex_;
        public static final int CHALLENGEMAXSCORE_FIELD_NUMBER = 6;
        private int challengeMaxScore_;
        public static final int BEGINTIME_FIELD_NUMBER = 7;
        private int beginTime_;
        public static final int UNK3300_NNHICCGELHP_FIELD_NUMBER = 12;
        private int unk3300NNHICCGELHP_;
        private byte memoizedIsInitialized;
        private static final EffigyDailyInfo DEFAULT_INSTANCE = new EffigyDailyInfo();
        private static final Parser<EffigyDailyInfo> PARSER = new AbstractParser<EffigyDailyInfo>() { // from class: emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfo.1
            @Override // com.google.protobuf.Parser
            public EffigyDailyInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EffigyDailyInfo(input, extensionRegistry);
            }
        };

        private EffigyDailyInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EffigyDailyInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EffigyDailyInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EffigyDailyInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isFirstPassRewardTaken_ = input.readBool();
                                break;
                            case 48:
                                this.challengeMaxScore_ = input.readUInt32();
                                break;
                            case 56:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.unk3300NEBCDALEFEC_ = input.readUInt32();
                                break;
                            case 96:
                                this.unk3300NNHICCGELHP_ = input.readUInt32();
                                break;
                            case 112:
                                this.dayIndex_ = input.readUInt32();
                                break;
                            case 120:
                                this.challengeId_ = input.readUInt32();
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
            return EffigyDailyInfoOuterClass.internal_static_EffigyDailyInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EffigyDailyInfoOuterClass.internal_static_EffigyDailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyDailyInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
        public int getChallengeId() {
            return this.challengeId_;
        }

        @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
        public boolean getIsFirstPassRewardTaken() {
            return this.isFirstPassRewardTaken_;
        }

        @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
        public int getUnk3300NEBCDALEFEC() {
            return this.unk3300NEBCDALEFEC_;
        }

        @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
        public int getChallengeMaxScore() {
            return this.challengeMaxScore_;
        }

        @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
        public int getUnk3300NNHICCGELHP() {
            return this.unk3300NNHICCGELHP_;
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
            if (this.isFirstPassRewardTaken_) {
                output.writeBool(2, this.isFirstPassRewardTaken_);
            }
            if (this.challengeMaxScore_ != 0) {
                output.writeUInt32(6, this.challengeMaxScore_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(7, this.beginTime_);
            }
            if (this.unk3300NEBCDALEFEC_ != 0) {
                output.writeUInt32(10, this.unk3300NEBCDALEFEC_);
            }
            if (this.unk3300NNHICCGELHP_ != 0) {
                output.writeUInt32(12, this.unk3300NNHICCGELHP_);
            }
            if (this.dayIndex_ != 0) {
                output.writeUInt32(14, this.dayIndex_);
            }
            if (this.challengeId_ != 0) {
                output.writeUInt32(15, this.challengeId_);
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
            if (this.isFirstPassRewardTaken_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isFirstPassRewardTaken_);
            }
            if (this.challengeMaxScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.challengeMaxScore_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.beginTime_);
            }
            if (this.unk3300NEBCDALEFEC_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300NEBCDALEFEC_);
            }
            if (this.unk3300NNHICCGELHP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300NNHICCGELHP_);
            }
            if (this.dayIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.dayIndex_);
            }
            if (this.challengeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.challengeId_);
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
            if (!(obj instanceof EffigyDailyInfo)) {
                return equals(obj);
            }
            EffigyDailyInfo other = (EffigyDailyInfo) obj;
            return getChallengeId() == other.getChallengeId() && getIsFirstPassRewardTaken() == other.getIsFirstPassRewardTaken() && getUnk3300NEBCDALEFEC() == other.getUnk3300NEBCDALEFEC() && getDayIndex() == other.getDayIndex() && getChallengeMaxScore() == other.getChallengeMaxScore() && getBeginTime() == other.getBeginTime() && getUnk3300NNHICCGELHP() == other.getUnk3300NNHICCGELHP() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getChallengeId())) + 2)) + Internal.hashBoolean(getIsFirstPassRewardTaken()))) + 10)) + getUnk3300NEBCDALEFEC())) + 14)) + getDayIndex())) + 6)) + getChallengeMaxScore())) + 7)) + getBeginTime())) + 12)) + getUnk3300NNHICCGELHP())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EffigyDailyInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyDailyInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyDailyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyDailyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyDailyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyDailyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyDailyInfo parseFrom(InputStream input) throws IOException {
            return (EffigyDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyDailyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyDailyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EffigyDailyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EffigyDailyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyDailyInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyDailyInfo parseFrom(CodedInputStream input) throws IOException {
            return (EffigyDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyDailyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyDailyInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EffigyDailyInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyDailyInfoOuterClass$EffigyDailyInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EffigyDailyInfoOrBuilder {
            private int challengeId_;
            private boolean isFirstPassRewardTaken_;
            private int unk3300NEBCDALEFEC_;
            private int dayIndex_;
            private int challengeMaxScore_;
            private int beginTime_;
            private int unk3300NNHICCGELHP_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EffigyDailyInfoOuterClass.internal_static_EffigyDailyInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EffigyDailyInfoOuterClass.internal_static_EffigyDailyInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyDailyInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EffigyDailyInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeId_ = 0;
                this.isFirstPassRewardTaken_ = false;
                this.unk3300NEBCDALEFEC_ = 0;
                this.dayIndex_ = 0;
                this.challengeMaxScore_ = 0;
                this.beginTime_ = 0;
                this.unk3300NNHICCGELHP_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EffigyDailyInfoOuterClass.internal_static_EffigyDailyInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EffigyDailyInfo getDefaultInstanceForType() {
                return EffigyDailyInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyDailyInfo build() {
                EffigyDailyInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyDailyInfo buildPartial() {
                EffigyDailyInfo result = new EffigyDailyInfo(this);
                result.challengeId_ = this.challengeId_;
                result.isFirstPassRewardTaken_ = this.isFirstPassRewardTaken_;
                result.unk3300NEBCDALEFEC_ = this.unk3300NEBCDALEFEC_;
                result.dayIndex_ = this.dayIndex_;
                result.challengeMaxScore_ = this.challengeMaxScore_;
                result.beginTime_ = this.beginTime_;
                result.unk3300NNHICCGELHP_ = this.unk3300NNHICCGELHP_;
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
                if (other instanceof EffigyDailyInfo) {
                    return mergeFrom((EffigyDailyInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EffigyDailyInfo other) {
                if (other == EffigyDailyInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeId() != 0) {
                    setChallengeId(other.getChallengeId());
                }
                if (other.getIsFirstPassRewardTaken()) {
                    setIsFirstPassRewardTaken(other.getIsFirstPassRewardTaken());
                }
                if (other.getUnk3300NEBCDALEFEC() != 0) {
                    setUnk3300NEBCDALEFEC(other.getUnk3300NEBCDALEFEC());
                }
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (other.getChallengeMaxScore() != 0) {
                    setChallengeMaxScore(other.getChallengeMaxScore());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getUnk3300NNHICCGELHP() != 0) {
                    setUnk3300NNHICCGELHP(other.getUnk3300NNHICCGELHP());
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
                EffigyDailyInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EffigyDailyInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EffigyDailyInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
            public int getChallengeId() {
                return this.challengeId_;
            }

            public Builder setChallengeId(int value) {
                this.challengeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeId() {
                this.challengeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
            public boolean getIsFirstPassRewardTaken() {
                return this.isFirstPassRewardTaken_;
            }

            public Builder setIsFirstPassRewardTaken(boolean value) {
                this.isFirstPassRewardTaken_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFirstPassRewardTaken() {
                this.isFirstPassRewardTaken_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
            public int getUnk3300NEBCDALEFEC() {
                return this.unk3300NEBCDALEFEC_;
            }

            public Builder setUnk3300NEBCDALEFEC(int value) {
                this.unk3300NEBCDALEFEC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NEBCDALEFEC() {
                this.unk3300NEBCDALEFEC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
            public int getDayIndex() {
                return this.dayIndex_;
            }

            public Builder setDayIndex(int value) {
                this.dayIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearDayIndex() {
                this.dayIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
            public int getChallengeMaxScore() {
                return this.challengeMaxScore_;
            }

            public Builder setChallengeMaxScore(int value) {
                this.challengeMaxScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeMaxScore() {
                this.challengeMaxScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyDailyInfoOuterClass.EffigyDailyInfoOrBuilder
            public int getUnk3300NNHICCGELHP() {
                return this.unk3300NNHICCGELHP_;
            }

            public Builder setUnk3300NNHICCGELHP(int value) {
                this.unk3300NNHICCGELHP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NNHICCGELHP() {
                this.unk3300NNHICCGELHP_ = 0;
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

        public static EffigyDailyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EffigyDailyInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EffigyDailyInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EffigyDailyInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
