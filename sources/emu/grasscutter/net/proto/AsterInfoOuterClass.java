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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterInfoOuterClass.class */
public final class AsterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fAsterInfo.proto\u001a\u001aAsterLargeDetailInfo.proto\u001a\u001bAsterLittleDetailInfo.proto\u001a\u0018AsterMidDetailInfo.proto\u001a\u001dAsterProgressDetailInfo.proto\"Ã\u0002\n\tAsterInfo\u0012)\n\nasterLarge\u0018\u0002 \u0001(\u000b2\u0015.AsterLargeDetailInfo\u0012\u001b\n\u0013Unk3300_KFDGFFPJGJC\u0018\b \u0001(\r\u0012\u001c\n\u0014isSpecialRewardTaken\u0018\t \u0001(\b\u0012+\n\u000basterLittle\u0018\u0003 \u0001(\u000b2\u0016.AsterLittleDetailInfo\u0012\u0018\n\u0010contentCloseTime\u0018\u000e \u0001(\r\u0012\u001b\n\u0013Unk3300_DCHBFEJNBHP\u0018\n \u0001(\r\u0012%\n\basterMid\u0018\u0004 \u0001(\u000b2\u0013.AsterMidDetailInfo\u0012/\n\rasterProgress\u0018\u0007 \u0001(\u000b2\u0018.AsterProgressDetailInfo\u0012\u0014\n\fleftMonsters\u0018\u000f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AsterLargeDetailInfoOuterClass.getDescriptor(), AsterLittleDetailInfoOuterClass.getDescriptor(), AsterMidDetailInfoOuterClass.getDescriptor(), AsterProgressDetailInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AsterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AsterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AsterInfo_descriptor, new String[]{"AsterLarge", "Unk3300KFDGFFPJGJC", "IsSpecialRewardTaken", "AsterLittle", "ContentCloseTime", "Unk3300DCHBFEJNBHP", "AsterMid", "AsterProgress", "LeftMonsters"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterInfoOuterClass$AsterInfoOrBuilder.class */
    public interface AsterInfoOrBuilder extends MessageOrBuilder {
        boolean hasAsterLarge();

        AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo getAsterLarge();

        AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder getAsterLargeOrBuilder();

        int getUnk3300KFDGFFPJGJC();

        boolean getIsSpecialRewardTaken();

        boolean hasAsterLittle();

        AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo getAsterLittle();

        AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder getAsterLittleOrBuilder();

        int getContentCloseTime();

        int getUnk3300DCHBFEJNBHP();

        boolean hasAsterMid();

        AsterMidDetailInfoOuterClass.AsterMidDetailInfo getAsterMid();

        AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder getAsterMidOrBuilder();

        boolean hasAsterProgress();

        AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo getAsterProgress();

        AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder getAsterProgressOrBuilder();

        boolean getLeftMonsters();
    }

    private AsterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterInfoOuterClass$AsterInfo.class */
    public static final class AsterInfo extends GeneratedMessageV3 implements AsterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ASTERLARGE_FIELD_NUMBER = 2;
        private AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo asterLarge_;
        public static final int UNK3300_KFDGFFPJGJC_FIELD_NUMBER = 8;
        private int unk3300KFDGFFPJGJC_;
        public static final int ISSPECIALREWARDTAKEN_FIELD_NUMBER = 9;
        private boolean isSpecialRewardTaken_;
        public static final int ASTERLITTLE_FIELD_NUMBER = 3;
        private AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo asterLittle_;
        public static final int CONTENTCLOSETIME_FIELD_NUMBER = 14;
        private int contentCloseTime_;
        public static final int UNK3300_DCHBFEJNBHP_FIELD_NUMBER = 10;
        private int unk3300DCHBFEJNBHP_;
        public static final int ASTERMID_FIELD_NUMBER = 4;
        private AsterMidDetailInfoOuterClass.AsterMidDetailInfo asterMid_;
        public static final int ASTERPROGRESS_FIELD_NUMBER = 7;
        private AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo asterProgress_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 15;
        private boolean leftMonsters_;
        private byte memoizedIsInitialized;
        private static final AsterInfo DEFAULT_INSTANCE = new AsterInfo();
        private static final Parser<AsterInfo> PARSER = new AbstractParser<AsterInfo>() { // from class: emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfo.1
            @Override // com.google.protobuf.Parser
            public AsterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AsterInfo(input, extensionRegistry);
            }
        };

        private AsterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AsterInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AsterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AsterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.Builder subBuilder = this.asterLarge_ != null ? this.asterLarge_.toBuilder() : null;
                                this.asterLarge_ = (AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo) input.readMessage(AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.asterLarge_);
                                    this.asterLarge_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 26:
                                AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.Builder subBuilder2 = this.asterLittle_ != null ? this.asterLittle_.toBuilder() : null;
                                this.asterLittle_ = (AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo) input.readMessage(AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.asterLittle_);
                                    this.asterLittle_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 34:
                                AsterMidDetailInfoOuterClass.AsterMidDetailInfo.Builder subBuilder3 = this.asterMid_ != null ? this.asterMid_.toBuilder() : null;
                                this.asterMid_ = (AsterMidDetailInfoOuterClass.AsterMidDetailInfo) input.readMessage(AsterMidDetailInfoOuterClass.AsterMidDetailInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.asterMid_);
                                    this.asterMid_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 58:
                                AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.Builder subBuilder4 = this.asterProgress_ != null ? this.asterProgress_.toBuilder() : null;
                                this.asterProgress_ = (AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo) input.readMessage(AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.asterProgress_);
                                    this.asterProgress_ = subBuilder4.buildPartial();
                                    break;
                                }
                            case 64:
                                this.unk3300KFDGFFPJGJC_ = input.readUInt32();
                                break;
                            case 72:
                                this.isSpecialRewardTaken_ = input.readBool();
                                break;
                            case 80:
                                this.unk3300DCHBFEJNBHP_ = input.readUInt32();
                                break;
                            case 112:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 120:
                                this.leftMonsters_ = input.readBool();
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
            return AsterInfoOuterClass.internal_static_AsterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AsterInfoOuterClass.internal_static_AsterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public boolean hasAsterLarge() {
            return this.asterLarge_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo getAsterLarge() {
            return this.asterLarge_ == null ? AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.getDefaultInstance() : this.asterLarge_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder getAsterLargeOrBuilder() {
            return getAsterLarge();
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public int getUnk3300KFDGFFPJGJC() {
            return this.unk3300KFDGFFPJGJC_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public boolean getIsSpecialRewardTaken() {
            return this.isSpecialRewardTaken_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public boolean hasAsterLittle() {
            return this.asterLittle_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo getAsterLittle() {
            return this.asterLittle_ == null ? AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.getDefaultInstance() : this.asterLittle_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder getAsterLittleOrBuilder() {
            return getAsterLittle();
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public int getUnk3300DCHBFEJNBHP() {
            return this.unk3300DCHBFEJNBHP_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public boolean hasAsterMid() {
            return this.asterMid_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterMidDetailInfoOuterClass.AsterMidDetailInfo getAsterMid() {
            return this.asterMid_ == null ? AsterMidDetailInfoOuterClass.AsterMidDetailInfo.getDefaultInstance() : this.asterMid_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder getAsterMidOrBuilder() {
            return getAsterMid();
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public boolean hasAsterProgress() {
            return this.asterProgress_ != null;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo getAsterProgress() {
            return this.asterProgress_ == null ? AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.getDefaultInstance() : this.asterProgress_;
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder getAsterProgressOrBuilder() {
            return getAsterProgress();
        }

        @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
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
            if (this.asterLarge_ != null) {
                output.writeMessage(2, getAsterLarge());
            }
            if (this.asterLittle_ != null) {
                output.writeMessage(3, getAsterLittle());
            }
            if (this.asterMid_ != null) {
                output.writeMessage(4, getAsterMid());
            }
            if (this.asterProgress_ != null) {
                output.writeMessage(7, getAsterProgress());
            }
            if (this.unk3300KFDGFFPJGJC_ != 0) {
                output.writeUInt32(8, this.unk3300KFDGFFPJGJC_);
            }
            if (this.isSpecialRewardTaken_) {
                output.writeBool(9, this.isSpecialRewardTaken_);
            }
            if (this.unk3300DCHBFEJNBHP_ != 0) {
                output.writeUInt32(10, this.unk3300DCHBFEJNBHP_);
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(14, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                output.writeBool(15, this.leftMonsters_);
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
            if (this.asterLarge_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getAsterLarge());
            }
            if (this.asterLittle_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getAsterLittle());
            }
            if (this.asterMid_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getAsterMid());
            }
            if (this.asterProgress_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getAsterProgress());
            }
            if (this.unk3300KFDGFFPJGJC_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300KFDGFFPJGJC_);
            }
            if (this.isSpecialRewardTaken_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isSpecialRewardTaken_);
            }
            if (this.unk3300DCHBFEJNBHP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300DCHBFEJNBHP_);
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.leftMonsters_);
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
            if (!(obj instanceof AsterInfo)) {
                return equals(obj);
            }
            AsterInfo other = (AsterInfo) obj;
            if (hasAsterLarge() != other.hasAsterLarge()) {
                return false;
            }
            if ((hasAsterLarge() && !getAsterLarge().equals(other.getAsterLarge())) || getUnk3300KFDGFFPJGJC() != other.getUnk3300KFDGFFPJGJC() || getIsSpecialRewardTaken() != other.getIsSpecialRewardTaken() || hasAsterLittle() != other.hasAsterLittle()) {
                return false;
            }
            if ((hasAsterLittle() && !getAsterLittle().equals(other.getAsterLittle())) || getContentCloseTime() != other.getContentCloseTime() || getUnk3300DCHBFEJNBHP() != other.getUnk3300DCHBFEJNBHP() || hasAsterMid() != other.hasAsterMid()) {
                return false;
            }
            if ((!hasAsterMid() || getAsterMid().equals(other.getAsterMid())) && hasAsterProgress() == other.hasAsterProgress()) {
                return (!hasAsterProgress() || getAsterProgress().equals(other.getAsterProgress())) && getLeftMonsters() == other.getLeftMonsters() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasAsterLarge()) {
                hash = (53 * ((37 * hash) + 2)) + getAsterLarge().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 8)) + getUnk3300KFDGFFPJGJC())) + 9)) + Internal.hashBoolean(getIsSpecialRewardTaken());
            if (hasAsterLittle()) {
                hash2 = (53 * ((37 * hash2) + 3)) + getAsterLittle().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * hash2) + 14)) + getContentCloseTime())) + 10)) + getUnk3300DCHBFEJNBHP();
            if (hasAsterMid()) {
                hash3 = (53 * ((37 * hash3) + 4)) + getAsterMid().hashCode();
            }
            if (hasAsterProgress()) {
                hash3 = (53 * ((37 * hash3) + 7)) + getAsterProgress().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * hash3) + 15)) + Internal.hashBoolean(getLeftMonsters()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static AsterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AsterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AsterInfo parseFrom(InputStream input) throws IOException {
            return (AsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AsterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AsterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AsterInfo parseFrom(CodedInputStream input) throws IOException {
            return (AsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AsterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AsterInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AsterInfoOuterClass$AsterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AsterInfoOrBuilder {
            private AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo asterLarge_;
            private SingleFieldBuilderV3<AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo, AsterLargeDetailInfoOuterClass.AsterLargeDetailInfo.Builder, AsterLargeDetailInfoOuterClass.AsterLargeDetailInfoOrBuilder> asterLargeBuilder_;
            private int unk3300KFDGFFPJGJC_;
            private boolean isSpecialRewardTaken_;
            private AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo asterLittle_;
            private SingleFieldBuilderV3<AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo, AsterLittleDetailInfoOuterClass.AsterLittleDetailInfo.Builder, AsterLittleDetailInfoOuterClass.AsterLittleDetailInfoOrBuilder> asterLittleBuilder_;
            private int contentCloseTime_;
            private int unk3300DCHBFEJNBHP_;
            private AsterMidDetailInfoOuterClass.AsterMidDetailInfo asterMid_;
            private SingleFieldBuilderV3<AsterMidDetailInfoOuterClass.AsterMidDetailInfo, AsterMidDetailInfoOuterClass.AsterMidDetailInfo.Builder, AsterMidDetailInfoOuterClass.AsterMidDetailInfoOrBuilder> asterMidBuilder_;
            private AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo asterProgress_;
            private SingleFieldBuilderV3<AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo, AsterProgressDetailInfoOuterClass.AsterProgressDetailInfo.Builder, AsterProgressDetailInfoOuterClass.AsterProgressDetailInfoOrBuilder> asterProgressBuilder_;
            private boolean leftMonsters_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AsterInfoOuterClass.internal_static_AsterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AsterInfoOuterClass.internal_static_AsterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AsterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AsterInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.asterLargeBuilder_ == null) {
                    this.asterLarge_ = null;
                } else {
                    this.asterLarge_ = null;
                    this.asterLargeBuilder_ = null;
                }
                this.unk3300KFDGFFPJGJC_ = 0;
                this.isSpecialRewardTaken_ = false;
                if (this.asterLittleBuilder_ == null) {
                    this.asterLittle_ = null;
                } else {
                    this.asterLittle_ = null;
                    this.asterLittleBuilder_ = null;
                }
                this.contentCloseTime_ = 0;
                this.unk3300DCHBFEJNBHP_ = 0;
                if (this.asterMidBuilder_ == null) {
                    this.asterMid_ = null;
                } else {
                    this.asterMid_ = null;
                    this.asterMidBuilder_ = null;
                }
                if (this.asterProgressBuilder_ == null) {
                    this.asterProgress_ = null;
                } else {
                    this.asterProgress_ = null;
                    this.asterProgressBuilder_ = null;
                }
                this.leftMonsters_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AsterInfoOuterClass.internal_static_AsterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AsterInfo getDefaultInstanceForType() {
                return AsterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterInfo build() {
                AsterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AsterInfo buildPartial() {
                AsterInfo result = new AsterInfo(this);
                if (this.asterLargeBuilder_ == null) {
                    result.asterLarge_ = this.asterLarge_;
                } else {
                    result.asterLarge_ = this.asterLargeBuilder_.build();
                }
                result.unk3300KFDGFFPJGJC_ = this.unk3300KFDGFFPJGJC_;
                result.isSpecialRewardTaken_ = this.isSpecialRewardTaken_;
                if (this.asterLittleBuilder_ == null) {
                    result.asterLittle_ = this.asterLittle_;
                } else {
                    result.asterLittle_ = this.asterLittleBuilder_.build();
                }
                result.contentCloseTime_ = this.contentCloseTime_;
                result.unk3300DCHBFEJNBHP_ = this.unk3300DCHBFEJNBHP_;
                if (this.asterMidBuilder_ == null) {
                    result.asterMid_ = this.asterMid_;
                } else {
                    result.asterMid_ = this.asterMidBuilder_.build();
                }
                if (this.asterProgressBuilder_ == null) {
                    result.asterProgress_ = this.asterProgress_;
                } else {
                    result.asterProgress_ = this.asterProgressBuilder_.build();
                }
                result.leftMonsters_ = this.leftMonsters_;
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
                if (other instanceof AsterInfo) {
                    return mergeFrom((AsterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AsterInfo other) {
                if (other == AsterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasAsterLarge()) {
                    mergeAsterLarge(other.getAsterLarge());
                }
                if (other.getUnk3300KFDGFFPJGJC() != 0) {
                    setUnk3300KFDGFFPJGJC(other.getUnk3300KFDGFFPJGJC());
                }
                if (other.getIsSpecialRewardTaken()) {
                    setIsSpecialRewardTaken(other.getIsSpecialRewardTaken());
                }
                if (other.hasAsterLittle()) {
                    mergeAsterLittle(other.getAsterLittle());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (other.getUnk3300DCHBFEJNBHP() != 0) {
                    setUnk3300DCHBFEJNBHP(other.getUnk3300DCHBFEJNBHP());
                }
                if (other.hasAsterMid()) {
                    mergeAsterMid(other.getAsterMid());
                }
                if (other.hasAsterProgress()) {
                    mergeAsterProgress(other.getAsterProgress());
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
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
                AsterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AsterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AsterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
            public boolean hasAsterLarge() {
                return (this.asterLargeBuilder_ == null && this.asterLarge_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
            public boolean hasAsterLittle() {
                return (this.asterLittleBuilder_ == null && this.asterLittle_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
            public boolean hasAsterMid() {
                return (this.asterMidBuilder_ == null && this.asterMid_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
            public boolean hasAsterProgress() {
                return (this.asterProgressBuilder_ == null && this.asterProgress_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.AsterInfoOuterClass.AsterInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
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

        public static AsterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AsterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AsterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AsterInfo getDefaultInstanceForType() {
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
