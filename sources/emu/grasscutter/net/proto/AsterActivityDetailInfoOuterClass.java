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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AsterLargeDetailInfoOuterClass;
import emu.grasscutter.net.proto.AsterLittleDetailInfoOuterClass;
import emu.grasscutter.net.proto.AsterMidDetailInfoOuterClass;
import emu.grasscutter.net.proto.AsterProgressDetailInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterActivityDetailInfoOuterClass.class */
public final class AsterActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAsterActivityDetailInfo.proto\u001a\u001aAsterLargeDetailInfo.proto\u001a\u001bAsterLittleDetailInfo.proto\u001a\u0018AsterMidDetailInfo.proto\u001a\u001dAsterProgressDetailInfo.proto\"ß\u0002\n\u0017AsterActivityDetailInfo\u0012\u001a\n\u0012content_close_time\u0018\u0001 \u0001(\r\u0012,\n\faster_little\u0018\u0005 \u0001(\u000b2\u0016.AsterLittleDetailInfo\u0012\u001b\n\u0013Unk3300_DCHBFEJNBHP\u0018\r \u0001(\r\u0012&\n\taster_mid\u0018\f \u0001(\u000b2\u0013.AsterMidDetailInfo\u0012\u001f\n\u0017is_special_reward_taken\u0018\u0003 \u0001(\b\u0012\u001b\n\u0013Unk3300_KFDGFFPJGJC\u0018\u0004 \u0001(\r\u00120\n\u000easter_progress\u0018\b \u0001(\u000b2\u0018.AsterProgressDetailInfo\u0012*\n\u000baster_large\u0018\n \u0001(\u000b2\u0015.AsterLargeDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\u0006 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AsterLargeDetailInfoOuterClass.getDescriptor(), AsterLittleDetailInfoOuterClass.getDescriptor(), AsterMidDetailInfoOuterClass.getDescriptor(), AsterProgressDetailInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AsterActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AsterActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AsterActivityDetailInfo_descriptor, new String[]{"ContentCloseTime", "AsterLittle", "Unk3300DCHBFEJNBHP", "AsterMid", "IsSpecialRewardTaken", "Unk3300KFDGFFPJGJC", "AsterProgress", "AsterLarge", "IsContentClosed"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterActivityDetailInfoOuterClass$AsterActivityDetailInfoOrBuilder.class */
    public interface AsterActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getContentCloseTime();

        boolean hasAsterLittle();

        AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo getAsterLittle();

        AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder getAsterLittleOrBuilder();

        int getUnk3300DCHBFEJNBHP();

        boolean hasAsterMid();

        AsterMidDetailInfoOuterClass.AsterMidDetailInfo getAsterMid();

        AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder getAsterMidOrBuilder();

        boolean getIsSpecialRewardTaken();

        int getUnk3300KFDGFFPJGJC();

        boolean hasAsterProgress();

        AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo getAsterProgress();

        AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder getAsterProgressOrBuilder();

        boolean hasAsterLarge();

        AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo getAsterLarge();

        AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder getAsterLargeOrBuilder();

        boolean getIsContentClosed();
    }

    private AsterActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterActivityDetailInfoOuterClass$AsterActivityDetailInfo.class */
    public static final class AsterActivityDetailInfo extends GeneratedMessageV3 implements AsterActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 1;
        private int contentCloseTime_;
        public static final int ASTER_LITTLE_FIELD_NUMBER = 5;
        private AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo asterLittle_;
        public static final int UNK3300_DCHBFEJNBHP_FIELD_NUMBER = 13;
        private int unk3300DCHBFEJNBHP_;
        public static final int ASTER_MID_FIELD_NUMBER = 12;
        private AsterMidDetailInfoOuterClass.AsterMidDetailInfo asterMid_;
        public static final int IS_SPECIAL_REWARD_TAKEN_FIELD_NUMBER = 3;
        private boolean isSpecialRewardTaken_;
        public static final int UNK3300_KFDGFFPJGJC_FIELD_NUMBER = 4;
        private int unk3300KFDGFFPJGJC_;
        public static final int ASTER_PROGRESS_FIELD_NUMBER = 8;
        private AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo asterProgress_;
        public static final int ASTER_LARGE_FIELD_NUMBER = 10;
        private AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo asterLarge_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 6;
        private boolean isContentClosed_;
        private byte memoizedIsInitialized;
        private static final AsterActivityDetailInfo DEFAULT_INSTANCE = new AsterActivityDetailInfo();
        private static final Parser<AsterActivityDetailInfo> PARSER = new AbstractParser<AsterActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public AsterActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AsterActivityDetailInfo(input, extensionRegistry);
            }
        };

        private AsterActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AsterActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AsterActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AsterActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 24:
                                this.isSpecialRewardTaken_ = input.readBool();
                                break;
                            case 32:
                                this.unk3300KFDGFFPJGJC_ = input.readUInt32();
                                break;
                            case 42:
                                AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.Builder subBuilder = this.asterLittle_ != null ? this.asterLittle_.toBuilder() : null;
                                this.asterLittle_ = (AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo) input.readMessage(AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.asterLittle_);
                                    this.asterLittle_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 48:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 66:
                                AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.Builder subBuilder2 = this.asterProgress_ != null ? this.asterProgress_.toBuilder() : null;
                                this.asterProgress_ = (AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo) input.readMessage(AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.asterProgress_);
                                    this.asterProgress_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 82:
                                AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.Builder subBuilder3 = this.asterLarge_ != null ? this.asterLarge_.toBuilder() : null;
                                this.asterLarge_ = (AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo) input.readMessage(AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.asterLarge_);
                                    this.asterLarge_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 98:
                                AsterMidDetailInfoOuterClass.AsterMidDetailInfo.Builder subBuilder4 = this.asterMid_ != null ? this.asterMid_.toBuilder() : null;
                                this.asterMid_ = (AsterMidDetailInfoOuterClass.AsterMidDetailInfo) input.readMessage(AsterMidDetailInfoOuterClass.AsterMidDetailInfo.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.asterMid_);
                                    this.asterMid_ = subBuilder4.buildPartial();
                                    break;
                                }
                            case 104:
                                this.unk3300DCHBFEJNBHP_ = input.readUInt32();
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
            return AsterActivityDetailInfoOuterClass.internal_static_AsterActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AsterActivityDetailInfoOuterClass.internal_static_AsterActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public boolean hasAsterLittle() {
            return this.asterLittle_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo getAsterLittle() {
            return this.asterLittle_ == null ? AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.getDefaultInstance() : this.asterLittle_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder getAsterLittleOrBuilder() {
            return getAsterLittle();
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public int getUnk3300DCHBFEJNBHP() {
            return this.unk3300DCHBFEJNBHP_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public boolean hasAsterMid() {
            return this.asterMid_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterMidDetailInfoOuterClass.AsterMidDetailInfo getAsterMid() {
            return this.asterMid_ == null ? AsterMidDetailInfoOuterClass.AsterMidDetailInfo.getDefaultInstance() : this.asterMid_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder getAsterMidOrBuilder() {
            return getAsterMid();
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public boolean getIsSpecialRewardTaken() {
            return this.isSpecialRewardTaken_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public int getUnk3300KFDGFFPJGJC() {
            return this.unk3300KFDGFFPJGJC_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public boolean hasAsterProgress() {
            return this.asterProgress_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo getAsterProgress() {
            return this.asterProgress_ == null ? AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.getDefaultInstance() : this.asterProgress_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder getAsterProgressOrBuilder() {
            return getAsterProgress();
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public boolean hasAsterLarge() {
            return this.asterLarge_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo getAsterLarge() {
            return this.asterLarge_ == null ? AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.getDefaultInstance() : this.asterLarge_;
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder getAsterLargeOrBuilder() {
            return getAsterLarge();
        }

        @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
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
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(1, this.contentCloseTime_);
            }
            if (this.isSpecialRewardTaken_) {
                output.writeBool(3, this.isSpecialRewardTaken_);
            }
            if (this.unk3300KFDGFFPJGJC_ != 0) {
                output.writeUInt32(4, this.unk3300KFDGFFPJGJC_);
            }
            if (this.asterLittle_ != null) {
                output.writeMessage(5, getAsterLittle());
            }
            if (this.isContentClosed_) {
                output.writeBool(6, this.isContentClosed_);
            }
            if (this.asterProgress_ != null) {
                output.writeMessage(8, getAsterProgress());
            }
            if (this.asterLarge_ != null) {
                output.writeMessage(10, getAsterLarge());
            }
            if (this.asterMid_ != null) {
                output.writeMessage(12, getAsterMid());
            }
            if (this.unk3300DCHBFEJNBHP_ != 0) {
                output.writeUInt32(13, this.unk3300DCHBFEJNBHP_);
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
            if (this.contentCloseTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.contentCloseTime_);
            }
            if (this.isSpecialRewardTaken_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isSpecialRewardTaken_);
            }
            if (this.unk3300KFDGFFPJGJC_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.unk3300KFDGFFPJGJC_);
            }
            if (this.asterLittle_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getAsterLittle());
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isContentClosed_);
            }
            if (this.asterProgress_ != null) {
                size2 += CodedOutputStream.computeMessageSize(8, getAsterProgress());
            }
            if (this.asterLarge_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getAsterLarge());
            }
            if (this.asterMid_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getAsterMid());
            }
            if (this.unk3300DCHBFEJNBHP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unk3300DCHBFEJNBHP_);
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
            if (!(obj instanceof AsterActivityDetailInfo)) {
                return equals(obj);
            }
            AsterActivityDetailInfo other = (AsterActivityDetailInfo) obj;
            if (getContentCloseTime() != other.getContentCloseTime() || hasAsterLittle() != other.hasAsterLittle()) {
                return false;
            }
            if ((hasAsterLittle() && !getAsterLittle().equals(other.getAsterLittle())) || getUnk3300DCHBFEJNBHP() != other.getUnk3300DCHBFEJNBHP() || hasAsterMid() != other.hasAsterMid()) {
                return false;
            }
            if ((hasAsterMid() && !getAsterMid().equals(other.getAsterMid())) || getIsSpecialRewardTaken() != other.getIsSpecialRewardTaken() || getUnk3300KFDGFFPJGJC() != other.getUnk3300KFDGFFPJGJC() || hasAsterProgress() != other.hasAsterProgress()) {
                return false;
            }
            if ((!hasAsterProgress() || getAsterProgress().equals(other.getAsterProgress())) && hasAsterLarge() == other.hasAsterLarge()) {
                return (!hasAsterLarge() || getAsterLarge().equals(other.getAsterLarge())) && getIsContentClosed() == other.getIsContentClosed() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getContentCloseTime();
            if (hasAsterLittle()) {
                hash = (53 * ((37 * hash) + 5)) + getAsterLittle().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 13)) + getUnk3300DCHBFEJNBHP();
            if (hasAsterMid()) {
                hash2 = (53 * ((37 * hash2) + 12)) + getAsterMid().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * hash2) + 3)) + Internal.hashBoolean(getIsSpecialRewardTaken()))) + 4)) + getUnk3300KFDGFFPJGJC();
            if (hasAsterProgress()) {
                hash3 = (53 * ((37 * hash3) + 8)) + getAsterProgress().hashCode();
            }
            if (hasAsterLarge()) {
                hash3 = (53 * ((37 * hash3) + 10)) + getAsterLarge().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * hash3) + 6)) + Internal.hashBoolean(getIsContentClosed()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static AsterActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (AsterActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AsterActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AsterActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (AsterActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AsterActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterActivityDetailInfoOuterClass$AsterActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AsterActivityDetailInfoOrBuilder {
            private int contentCloseTime_;
            private AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo asterLittle_;
            private SingleFieldBuilderV3<AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo, AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.Builder, AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder> asterLittleBuilder_;
            private int unk3300DCHBFEJNBHP_;
            private AsterMidDetailInfoOuterClass.AsterMidDetailInfo asterMid_;
            private SingleFieldBuilderV3<AsterMidDetailInfoOuterClass.AsterMidDetailInfo, AsterMidDetailInfoOuterClass.AsterMidDetailInfo.Builder, AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder> asterMidBuilder_;
            private boolean isSpecialRewardTaken_;
            private int unk3300KFDGFFPJGJC_;
            private AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo asterProgress_;
            private SingleFieldBuilderV3<AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo, AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.Builder, AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder> asterProgressBuilder_;
            private AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo asterLarge_;
            private SingleFieldBuilderV3<AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo, AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.Builder, AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder> asterLargeBuilder_;
            private boolean isContentClosed_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AsterActivityDetailInfoOuterClass.internal_static_AsterActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AsterActivityDetailInfoOuterClass.internal_static_AsterActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AsterActivityDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.contentCloseTime_ = 0;
                if (this.asterLittleBuilder_ == null) {
                    this.asterLittle_ = null;
                } else {
                    this.asterLittle_ = null;
                    this.asterLittleBuilder_ = null;
                }
                this.unk3300DCHBFEJNBHP_ = 0;
                if (this.asterMidBuilder_ == null) {
                    this.asterMid_ = null;
                } else {
                    this.asterMid_ = null;
                    this.asterMidBuilder_ = null;
                }
                this.isSpecialRewardTaken_ = false;
                this.unk3300KFDGFFPJGJC_ = 0;
                if (this.asterProgressBuilder_ == null) {
                    this.asterProgress_ = null;
                } else {
                    this.asterProgress_ = null;
                    this.asterProgressBuilder_ = null;
                }
                if (this.asterLargeBuilder_ == null) {
                    this.asterLarge_ = null;
                } else {
                    this.asterLarge_ = null;
                    this.asterLargeBuilder_ = null;
                }
                this.isContentClosed_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AsterActivityDetailInfoOuterClass.internal_static_AsterActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AsterActivityDetailInfo getDefaultInstanceForType() {
                return AsterActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterActivityDetailInfo build() {
                AsterActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterActivityDetailInfo buildPartial() {
                AsterActivityDetailInfo result = new AsterActivityDetailInfo(this);
                result.contentCloseTime_ = this.contentCloseTime_;
                if (this.asterLittleBuilder_ == null) {
                    result.asterLittle_ = this.asterLittle_;
                } else {
                    result.asterLittle_ = this.asterLittleBuilder_.build();
                }
                result.unk3300DCHBFEJNBHP_ = this.unk3300DCHBFEJNBHP_;
                if (this.asterMidBuilder_ == null) {
                    result.asterMid_ = this.asterMid_;
                } else {
                    result.asterMid_ = this.asterMidBuilder_.build();
                }
                result.isSpecialRewardTaken_ = this.isSpecialRewardTaken_;
                result.unk3300KFDGFFPJGJC_ = this.unk3300KFDGFFPJGJC_;
                if (this.asterProgressBuilder_ == null) {
                    result.asterProgress_ = this.asterProgress_;
                } else {
                    result.asterProgress_ = this.asterProgressBuilder_.build();
                }
                if (this.asterLargeBuilder_ == null) {
                    result.asterLarge_ = this.asterLarge_;
                } else {
                    result.asterLarge_ = this.asterLargeBuilder_.build();
                }
                result.isContentClosed_ = this.isContentClosed_;
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
                if (other instanceof AsterActivityDetailInfo) {
                    return mergeFrom((AsterActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AsterActivityDetailInfo other) {
                if (other == AsterActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.hasAsterLittle()) {
                    mergeAsterLittle(other.getAsterLittle());
                }
                if (other.getUnk3300DCHBFEJNBHP() != 0) {
                    setUnk3300DCHBFEJNBHP(other.getUnk3300DCHBFEJNBHP());
                }
                if (other.hasAsterMid()) {
                    mergeAsterMid(other.getAsterMid());
                }
                if (other.getIsSpecialRewardTaken()) {
                    setIsSpecialRewardTaken(other.getIsSpecialRewardTaken());
                }
                if (other.getUnk3300KFDGFFPJGJC() != 0) {
                    setUnk3300KFDGFFPJGJC(other.getUnk3300KFDGFFPJGJC());
                }
                if (other.hasAsterProgress()) {
                    mergeAsterProgress(other.getAsterProgress());
                }
                if (other.hasAsterLarge()) {
                    mergeAsterLarge(other.getAsterLarge());
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
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
                AsterActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AsterActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AsterActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public boolean hasAsterLittle() {
                return (this.asterLittleBuilder_ == null && this.asterLittle_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo getAsterLittle() {
                if (this.asterLittleBuilder_ == null) {
                    return this.asterLittle_ == null ? AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.getDefaultInstance() : this.asterLittle_;
                }
                return this.asterLittleBuilder_.getMessage();
            }

            public Builder setAsterLittle(AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo value) {
                if (this.asterLittleBuilder_ != null) {
                    this.asterLittleBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.asterLittle_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAsterLittle(AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.Builder builderForValue) {
                if (this.asterLittleBuilder_ == null) {
                    this.asterLittle_ = builderForValue.build();
                    onChanged();
                } else {
                    this.asterLittleBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAsterLittle(AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo value) {
                if (this.asterLittleBuilder_ == null) {
                    if (this.asterLittle_ != null) {
                        this.asterLittle_ = AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.newBuilder(this.asterLittle_).mergeFrom(value).buildPartial();
                    } else {
                        this.asterLittle_ = value;
                    }
                    onChanged();
                } else {
                    this.asterLittleBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAsterLittle() {
                if (this.asterLittleBuilder_ == null) {
                    this.asterLittle_ = null;
                    onChanged();
                } else {
                    this.asterLittle_ = null;
                    this.asterLittleBuilder_ = null;
                }
                return this;
            }

            public AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.Builder getAsterLittleBuilder() {
                onChanged();
                return getAsterLittleFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder getAsterLittleOrBuilder() {
                if (this.asterLittleBuilder_ != null) {
                    return this.asterLittleBuilder_.getMessageOrBuilder();
                }
                return this.asterLittle_ == null ? AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.getDefaultInstance() : this.asterLittle_;
            }

            private SingleFieldBuilderV3<AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo, AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.Builder, AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder> getAsterLittleFieldBuilder() {
                if (this.asterLittleBuilder_ == null) {
                    this.asterLittleBuilder_ = new SingleFieldBuilderV3<>(getAsterLittle(), getParentForChildren(), isClean());
                    this.asterLittle_ = null;
                }
                return this.asterLittleBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public int getUnk3300DCHBFEJNBHP() {
                return this.unk3300DCHBFEJNBHP_;
            }

            public Builder setUnk3300DCHBFEJNBHP(int value) {
                this.unk3300DCHBFEJNBHP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DCHBFEJNBHP() {
                this.unk3300DCHBFEJNBHP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public boolean hasAsterMid() {
                return (this.asterMidBuilder_ == null && this.asterMid_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterMidDetailInfoOuterClass.AsterMidDetailInfo getAsterMid() {
                if (this.asterMidBuilder_ == null) {
                    return this.asterMid_ == null ? AsterMidDetailInfoOuterClass.AsterMidDetailInfo.getDefaultInstance() : this.asterMid_;
                }
                return this.asterMidBuilder_.getMessage();
            }

            public Builder setAsterMid(AsterMidDetailInfoOuterClass.AsterMidDetailInfo value) {
                if (this.asterMidBuilder_ != null) {
                    this.asterMidBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.asterMid_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAsterMid(AsterMidDetailInfoOuterClass.AsterMidDetailInfo.Builder builderForValue) {
                if (this.asterMidBuilder_ == null) {
                    this.asterMid_ = builderForValue.build();
                    onChanged();
                } else {
                    this.asterMidBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAsterMid(AsterMidDetailInfoOuterClass.AsterMidDetailInfo value) {
                if (this.asterMidBuilder_ == null) {
                    if (this.asterMid_ != null) {
                        this.asterMid_ = AsterMidDetailInfoOuterClass.AsterMidDetailInfo.newBuilder(this.asterMid_).mergeFrom(value).buildPartial();
                    } else {
                        this.asterMid_ = value;
                    }
                    onChanged();
                } else {
                    this.asterMidBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAsterMid() {
                if (this.asterMidBuilder_ == null) {
                    this.asterMid_ = null;
                    onChanged();
                } else {
                    this.asterMid_ = null;
                    this.asterMidBuilder_ = null;
                }
                return this;
            }

            public AsterMidDetailInfoOuterClass.AsterMidDetailInfo.Builder getAsterMidBuilder() {
                onChanged();
                return getAsterMidFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder getAsterMidOrBuilder() {
                if (this.asterMidBuilder_ != null) {
                    return this.asterMidBuilder_.getMessageOrBuilder();
                }
                return this.asterMid_ == null ? AsterMidDetailInfoOuterClass.AsterMidDetailInfo.getDefaultInstance() : this.asterMid_;
            }

            private SingleFieldBuilderV3<AsterMidDetailInfoOuterClass.AsterMidDetailInfo, AsterMidDetailInfoOuterClass.AsterMidDetailInfo.Builder, AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder> getAsterMidFieldBuilder() {
                if (this.asterMidBuilder_ == null) {
                    this.asterMidBuilder_ = new SingleFieldBuilderV3<>(getAsterMid(), getParentForChildren(), isClean());
                    this.asterMid_ = null;
                }
                return this.asterMidBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public boolean getIsSpecialRewardTaken() {
                return this.isSpecialRewardTaken_;
            }

            public Builder setIsSpecialRewardTaken(boolean value) {
                this.isSpecialRewardTaken_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSpecialRewardTaken() {
                this.isSpecialRewardTaken_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public int getUnk3300KFDGFFPJGJC() {
                return this.unk3300KFDGFFPJGJC_;
            }

            public Builder setUnk3300KFDGFFPJGJC(int value) {
                this.unk3300KFDGFFPJGJC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KFDGFFPJGJC() {
                this.unk3300KFDGFFPJGJC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public boolean hasAsterProgress() {
                return (this.asterProgressBuilder_ == null && this.asterProgress_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo getAsterProgress() {
                if (this.asterProgressBuilder_ == null) {
                    return this.asterProgress_ == null ? AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.getDefaultInstance() : this.asterProgress_;
                }
                return this.asterProgressBuilder_.getMessage();
            }

            public Builder setAsterProgress(AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo value) {
                if (this.asterProgressBuilder_ != null) {
                    this.asterProgressBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.asterProgress_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAsterProgress(AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.Builder builderForValue) {
                if (this.asterProgressBuilder_ == null) {
                    this.asterProgress_ = builderForValue.build();
                    onChanged();
                } else {
                    this.asterProgressBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAsterProgress(AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo value) {
                if (this.asterProgressBuilder_ == null) {
                    if (this.asterProgress_ != null) {
                        this.asterProgress_ = AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.newBuilder(this.asterProgress_).mergeFrom(value).buildPartial();
                    } else {
                        this.asterProgress_ = value;
                    }
                    onChanged();
                } else {
                    this.asterProgressBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAsterProgress() {
                if (this.asterProgressBuilder_ == null) {
                    this.asterProgress_ = null;
                    onChanged();
                } else {
                    this.asterProgress_ = null;
                    this.asterProgressBuilder_ = null;
                }
                return this;
            }

            public AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.Builder getAsterProgressBuilder() {
                onChanged();
                return getAsterProgressFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder getAsterProgressOrBuilder() {
                if (this.asterProgressBuilder_ != null) {
                    return this.asterProgressBuilder_.getMessageOrBuilder();
                }
                return this.asterProgress_ == null ? AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.getDefaultInstance() : this.asterProgress_;
            }

            private SingleFieldBuilderV3<AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo, AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.Builder, AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder> getAsterProgressFieldBuilder() {
                if (this.asterProgressBuilder_ == null) {
                    this.asterProgressBuilder_ = new SingleFieldBuilderV3<>(getAsterProgress(), getParentForChildren(), isClean());
                    this.asterProgress_ = null;
                }
                return this.asterProgressBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public boolean hasAsterLarge() {
                return (this.asterLargeBuilder_ == null && this.asterLarge_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo getAsterLarge() {
                if (this.asterLargeBuilder_ == null) {
                    return this.asterLarge_ == null ? AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.getDefaultInstance() : this.asterLarge_;
                }
                return this.asterLargeBuilder_.getMessage();
            }

            public Builder setAsterLarge(AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo value) {
                if (this.asterLargeBuilder_ != null) {
                    this.asterLargeBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.asterLarge_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAsterLarge(AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.Builder builderForValue) {
                if (this.asterLargeBuilder_ == null) {
                    this.asterLarge_ = builderForValue.build();
                    onChanged();
                } else {
                    this.asterLargeBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAsterLarge(AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo value) {
                if (this.asterLargeBuilder_ == null) {
                    if (this.asterLarge_ != null) {
                        this.asterLarge_ = AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.newBuilder(this.asterLarge_).mergeFrom(value).buildPartial();
                    } else {
                        this.asterLarge_ = value;
                    }
                    onChanged();
                } else {
                    this.asterLargeBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAsterLarge() {
                if (this.asterLargeBuilder_ == null) {
                    this.asterLarge_ = null;
                    onChanged();
                } else {
                    this.asterLarge_ = null;
                    this.asterLargeBuilder_ = null;
                }
                return this;
            }

            public AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.Builder getAsterLargeBuilder() {
                onChanged();
                return getAsterLargeFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder getAsterLargeOrBuilder() {
                if (this.asterLargeBuilder_ != null) {
                    return this.asterLargeBuilder_.getMessageOrBuilder();
                }
                return this.asterLarge_ == null ? AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.getDefaultInstance() : this.asterLarge_;
            }

            private SingleFieldBuilderV3<AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo, AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.Builder, AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder> getAsterLargeFieldBuilder() {
                if (this.asterLargeBuilder_ == null) {
                    this.asterLargeBuilder_ = new SingleFieldBuilderV3<>(getAsterLarge(), getParentForChildren(), isClean());
                    this.asterLarge_ = null;
                }
                return this.asterLargeBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
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

        public static AsterActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AsterActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AsterActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AsterActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AsterLargeDetailInfoOuterClass.getDescriptor();
        AsterLittleDetailInfoOuterClass.getDescriptor();
        AsterMidDetailInfoOuterClass.getDescriptor();
        AsterProgressDetailInfoOuterClass.getDescriptor();
    }
}
