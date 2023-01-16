package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass;
import emu.grasscutter.net.proto.SalvageScoreChallengeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageChallengeInfoOuterClass.class */
public final class SalvageChallengeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSalvageChallengeInfo.proto\u001a SalvageBundleChallengeInfo.proto\u001a\u001fSalvageScoreChallengeInfo.proto\"â\u0001\n\u0014SalvageChallengeInfo\u0012\u0016\n\u000echallenge_type\u0018\u000b \u0001(\r\u0012\u0011\n\tis_unlock\u0018\u000e \u0001(\b\u00122\n\u000bbundle_info\u0018\u0002 \u0001(\u000b2\u001b.SalvageBundleChallengeInfoH��\u0012:\n\u0014score_challenge_info\u0018\t \u0001(\u000b2\u001a.SalvageScoreChallengeInfoH��\u0012\u001b\n\u0011boss_challenge_id\u0018\f \u0001(\rH��B\u0012\n\u0010challenge_detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SalvageBundleChallengeInfoOuterClass.getDescriptor(), SalvageScoreChallengeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SalvageChallengeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SalvageChallengeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SalvageChallengeInfo_descriptor, new String[]{"ChallengeType", "IsUnlock", "BundleInfo", "ScoreChallengeInfo", "BossChallengeId", "ChallengeDetail"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageChallengeInfoOuterClass$SalvageChallengeInfoOrBuilder.class */
    public interface SalvageChallengeInfoOrBuilder extends MessageOrBuilder {
        int getChallengeType();

        boolean getIsUnlock();

        boolean hasBundleInfo();

        SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo getBundleInfo();

        SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder getBundleInfoOrBuilder();

        boolean hasScoreChallengeInfo();

        SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo getScoreChallengeInfo();

        SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfoOrBuilder getScoreChallengeInfoOrBuilder();

        boolean hasBossChallengeId();

        int getBossChallengeId();

        SalvageChallengeInfo.ChallengeDetailCase getChallengeDetailCase();
    }

    private SalvageChallengeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageChallengeInfoOuterClass$SalvageChallengeInfo.class */
    public static final class SalvageChallengeInfo extends GeneratedMessageV3 implements SalvageChallengeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int challengeDetailCase_;
        private Object challengeDetail_;
        public static final int CHALLENGE_TYPE_FIELD_NUMBER = 11;
        private int challengeType_;
        public static final int IS_UNLOCK_FIELD_NUMBER = 14;
        private boolean isUnlock_;
        public static final int BUNDLE_INFO_FIELD_NUMBER = 2;
        public static final int SCORE_CHALLENGE_INFO_FIELD_NUMBER = 9;
        public static final int BOSS_CHALLENGE_ID_FIELD_NUMBER = 12;
        private byte memoizedIsInitialized;
        private static final SalvageChallengeInfo DEFAULT_INSTANCE = new SalvageChallengeInfo();
        private static final Parser<SalvageChallengeInfo> PARSER = new AbstractParser<SalvageChallengeInfo>() { // from class: emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public SalvageChallengeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SalvageChallengeInfo(input, extensionRegistry);
            }
        };

        private SalvageChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.challengeDetailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private SalvageChallengeInfo() {
            this.challengeDetailCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SalvageChallengeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SalvageChallengeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.Builder subBuilder = this.challengeDetailCase_ == 2 ? ((SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_).toBuilder() : null;
                                this.challengeDetail_ = input.readMessage(SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_);
                                    this.challengeDetail_ = subBuilder.buildPartial();
                                }
                                this.challengeDetailCase_ = 2;
                                break;
                            case 74:
                                SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.Builder subBuilder2 = this.challengeDetailCase_ == 9 ? ((SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_).toBuilder() : null;
                                this.challengeDetail_ = input.readMessage(SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_);
                                    this.challengeDetail_ = subBuilder2.buildPartial();
                                }
                                this.challengeDetailCase_ = 9;
                                break;
                            case 88:
                                this.challengeType_ = input.readUInt32();
                                break;
                            case 96:
                                this.challengeDetailCase_ = 12;
                                this.challengeDetail_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 112:
                                this.isUnlock_ = input.readBool();
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
            return SalvageChallengeInfoOuterClass.internal_static_SalvageChallengeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SalvageChallengeInfoOuterClass.internal_static_SalvageChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalvageChallengeInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageChallengeInfoOuterClass$SalvageChallengeInfo$ChallengeDetailCase.class */
        public enum ChallengeDetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            BUNDLE_INFO(2),
            SCORE_CHALLENGE_INFO(9),
            BOSS_CHALLENGE_ID(12),
            CHALLENGEDETAIL_NOT_SET(0);
            
            private final int value;

            ChallengeDetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ChallengeDetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static ChallengeDetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return CHALLENGEDETAIL_NOT_SET;
                    case 2:
                        return BUNDLE_INFO;
                    case 9:
                        return SCORE_CHALLENGE_INFO;
                    case 12:
                        return BOSS_CHALLENGE_ID;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public ChallengeDetailCase getChallengeDetailCase() {
            return ChallengeDetailCase.forNumber(this.challengeDetailCase_);
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public int getChallengeType() {
            return this.challengeType_;
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public boolean getIsUnlock() {
            return this.isUnlock_;
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public boolean hasBundleInfo() {
            return this.challengeDetailCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo getBundleInfo() {
            if (this.challengeDetailCase_ == 2) {
                return (SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_;
            }
            return SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder getBundleInfoOrBuilder() {
            if (this.challengeDetailCase_ == 2) {
                return (SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_;
            }
            return SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public boolean hasScoreChallengeInfo() {
            return this.challengeDetailCase_ == 9;
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo getScoreChallengeInfo() {
            if (this.challengeDetailCase_ == 9) {
                return (SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_;
            }
            return SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfoOrBuilder getScoreChallengeInfoOrBuilder() {
            if (this.challengeDetailCase_ == 9) {
                return (SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_;
            }
            return SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public boolean hasBossChallengeId() {
            return this.challengeDetailCase_ == 12;
        }

        @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
        public int getBossChallengeId() {
            if (this.challengeDetailCase_ == 12) {
                return ((Integer) this.challengeDetail_).intValue();
            }
            return 0;
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
            if (this.challengeDetailCase_ == 2) {
                output.writeMessage(2, (SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_);
            }
            if (this.challengeDetailCase_ == 9) {
                output.writeMessage(9, (SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_);
            }
            if (this.challengeType_ != 0) {
                output.writeUInt32(11, this.challengeType_);
            }
            if (this.challengeDetailCase_ == 12) {
                output.writeUInt32(12, ((Integer) this.challengeDetail_).intValue());
            }
            if (this.isUnlock_) {
                output.writeBool(14, this.isUnlock_);
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
            if (this.challengeDetailCase_ == 2) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, (SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_);
            }
            if (this.challengeDetailCase_ == 9) {
                size2 += CodedOutputStream.computeMessageSize(9, (SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_);
            }
            if (this.challengeType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.challengeType_);
            }
            if (this.challengeDetailCase_ == 12) {
                size2 += CodedOutputStream.computeUInt32Size(12, ((Integer) this.challengeDetail_).intValue());
            }
            if (this.isUnlock_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isUnlock_);
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
            if (!(obj instanceof SalvageChallengeInfo)) {
                return equals(obj);
            }
            SalvageChallengeInfo other = (SalvageChallengeInfo) obj;
            if (getChallengeType() != other.getChallengeType() || getIsUnlock() != other.getIsUnlock() || !getChallengeDetailCase().equals(other.getChallengeDetailCase())) {
                return false;
            }
            switch (this.challengeDetailCase_) {
                case 2:
                    if (!getBundleInfo().equals(other.getBundleInfo())) {
                        return false;
                    }
                    break;
                case 9:
                    if (!getScoreChallengeInfo().equals(other.getScoreChallengeInfo())) {
                        return false;
                    }
                    break;
                case 12:
                    if (getBossChallengeId() != other.getBossChallengeId()) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getChallengeType())) + 14)) + Internal.hashBoolean(getIsUnlock());
            switch (this.challengeDetailCase_) {
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getBundleInfo().hashCode();
                    break;
                case 9:
                    hash = (53 * ((37 * hash) + 9)) + getScoreChallengeInfo().hashCode();
                    break;
                case 12:
                    hash = (53 * ((37 * hash) + 12)) + getBossChallengeId();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SalvageChallengeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageChallengeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageChallengeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageChallengeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageChallengeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageChallengeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageChallengeInfo parseFrom(InputStream input) throws IOException {
            return (SalvageChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalvageChallengeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalvageChallengeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SalvageChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SalvageChallengeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalvageChallengeInfo parseFrom(CodedInputStream input) throws IOException {
            return (SalvageChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalvageChallengeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SalvageChallengeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageChallengeInfoOuterClass$SalvageChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SalvageChallengeInfoOrBuilder {
            private int challengeDetailCase_ = 0;
            private Object challengeDetail_;
            private int challengeType_;
            private boolean isUnlock_;
            private SingleFieldBuilderV3<SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo, SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.Builder, SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder> bundleInfoBuilder_;
            private SingleFieldBuilderV3<SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo, SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.Builder, SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfoOrBuilder> scoreChallengeInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SalvageChallengeInfoOuterClass.internal_static_SalvageChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SalvageChallengeInfoOuterClass.internal_static_SalvageChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalvageChallengeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SalvageChallengeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeType_ = 0;
                this.isUnlock_ = false;
                this.challengeDetailCase_ = 0;
                this.challengeDetail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SalvageChallengeInfoOuterClass.internal_static_SalvageChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SalvageChallengeInfo getDefaultInstanceForType() {
                return SalvageChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalvageChallengeInfo build() {
                SalvageChallengeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalvageChallengeInfo buildPartial() {
                SalvageChallengeInfo result = new SalvageChallengeInfo(this);
                result.challengeType_ = this.challengeType_;
                result.isUnlock_ = this.isUnlock_;
                if (this.challengeDetailCase_ == 2) {
                    if (this.bundleInfoBuilder_ == null) {
                        result.challengeDetail_ = this.challengeDetail_;
                    } else {
                        result.challengeDetail_ = this.bundleInfoBuilder_.build();
                    }
                }
                if (this.challengeDetailCase_ == 9) {
                    if (this.scoreChallengeInfoBuilder_ == null) {
                        result.challengeDetail_ = this.challengeDetail_;
                    } else {
                        result.challengeDetail_ = this.scoreChallengeInfoBuilder_.build();
                    }
                }
                if (this.challengeDetailCase_ == 12) {
                    result.challengeDetail_ = this.challengeDetail_;
                }
                result.challengeDetailCase_ = this.challengeDetailCase_;
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
                if (other instanceof SalvageChallengeInfo) {
                    return mergeFrom((SalvageChallengeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SalvageChallengeInfo other) {
                if (other == SalvageChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeType() != 0) {
                    setChallengeType(other.getChallengeType());
                }
                if (other.getIsUnlock()) {
                    setIsUnlock(other.getIsUnlock());
                }
                switch (other.getChallengeDetailCase()) {
                    case BUNDLE_INFO:
                        mergeBundleInfo(other.getBundleInfo());
                        break;
                    case SCORE_CHALLENGE_INFO:
                        mergeScoreChallengeInfo(other.getScoreChallengeInfo());
                        break;
                    case BOSS_CHALLENGE_ID:
                        setBossChallengeId(other.getBossChallengeId());
                        break;
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
                SalvageChallengeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SalvageChallengeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SalvageChallengeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public ChallengeDetailCase getChallengeDetailCase() {
                return ChallengeDetailCase.forNumber(this.challengeDetailCase_);
            }

            public Builder clearChallengeDetail() {
                this.challengeDetailCase_ = 0;
                this.challengeDetail_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public int getChallengeType() {
                return this.challengeType_;
            }

            public Builder setChallengeType(int value) {
                this.challengeType_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeType() {
                this.challengeType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public boolean getIsUnlock() {
                return this.isUnlock_;
            }

            public Builder setIsUnlock(boolean value) {
                this.isUnlock_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUnlock() {
                this.isUnlock_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public boolean hasBundleInfo() {
                return this.challengeDetailCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo getBundleInfo() {
                if (this.bundleInfoBuilder_ == null) {
                    if (this.challengeDetailCase_ == 2) {
                        return (SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_;
                    }
                    return SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.getDefaultInstance();
                } else if (this.challengeDetailCase_ == 2) {
                    return this.bundleInfoBuilder_.getMessage();
                } else {
                    return SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.getDefaultInstance();
                }
            }

            public Builder setBundleInfo(SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo value) {
                if (this.bundleInfoBuilder_ != null) {
                    this.bundleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.challengeDetail_ = value;
                    onChanged();
                }
                this.challengeDetailCase_ = 2;
                return this;
            }

            public Builder setBundleInfo(SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.Builder builderForValue) {
                if (this.bundleInfoBuilder_ == null) {
                    this.challengeDetail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bundleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.challengeDetailCase_ = 2;
                return this;
            }

            public Builder mergeBundleInfo(SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo value) {
                if (this.bundleInfoBuilder_ == null) {
                    if (this.challengeDetailCase_ != 2 || this.challengeDetail_ == SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.getDefaultInstance()) {
                        this.challengeDetail_ = value;
                    } else {
                        this.challengeDetail_ = SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.newBuilder((SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.challengeDetailCase_ == 2) {
                        this.bundleInfoBuilder_.mergeFrom(value);
                    }
                    this.bundleInfoBuilder_.setMessage(value);
                }
                this.challengeDetailCase_ = 2;
                return this;
            }

            public Builder clearBundleInfo() {
                if (this.bundleInfoBuilder_ != null) {
                    if (this.challengeDetailCase_ == 2) {
                        this.challengeDetailCase_ = 0;
                        this.challengeDetail_ = null;
                    }
                    this.bundleInfoBuilder_.clear();
                } else if (this.challengeDetailCase_ == 2) {
                    this.challengeDetailCase_ = 0;
                    this.challengeDetail_ = null;
                    onChanged();
                }
                return this;
            }

            public SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.Builder getBundleInfoBuilder() {
                return getBundleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder getBundleInfoOrBuilder() {
                if (this.challengeDetailCase_ == 2 && this.bundleInfoBuilder_ != null) {
                    return this.bundleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.challengeDetailCase_ == 2) {
                    return (SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_;
                }
                return SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo, SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.Builder, SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder> getBundleInfoFieldBuilder() {
                if (this.bundleInfoBuilder_ == null) {
                    if (this.challengeDetailCase_ != 2) {
                        this.challengeDetail_ = SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.getDefaultInstance();
                    }
                    this.bundleInfoBuilder_ = new SingleFieldBuilderV3<>((SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo) this.challengeDetail_, getParentForChildren(), isClean());
                    this.challengeDetail_ = null;
                }
                this.challengeDetailCase_ = 2;
                onChanged();
                return this.bundleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public boolean hasScoreChallengeInfo() {
                return this.challengeDetailCase_ == 9;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo getScoreChallengeInfo() {
                if (this.scoreChallengeInfoBuilder_ == null) {
                    if (this.challengeDetailCase_ == 9) {
                        return (SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_;
                    }
                    return SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.getDefaultInstance();
                } else if (this.challengeDetailCase_ == 9) {
                    return this.scoreChallengeInfoBuilder_.getMessage();
                } else {
                    return SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.getDefaultInstance();
                }
            }

            public Builder setScoreChallengeInfo(SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo value) {
                if (this.scoreChallengeInfoBuilder_ != null) {
                    this.scoreChallengeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.challengeDetail_ = value;
                    onChanged();
                }
                this.challengeDetailCase_ = 9;
                return this;
            }

            public Builder setScoreChallengeInfo(SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.Builder builderForValue) {
                if (this.scoreChallengeInfoBuilder_ == null) {
                    this.challengeDetail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.scoreChallengeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.challengeDetailCase_ = 9;
                return this;
            }

            public Builder mergeScoreChallengeInfo(SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo value) {
                if (this.scoreChallengeInfoBuilder_ == null) {
                    if (this.challengeDetailCase_ != 9 || this.challengeDetail_ == SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.getDefaultInstance()) {
                        this.challengeDetail_ = value;
                    } else {
                        this.challengeDetail_ = SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.newBuilder((SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.challengeDetailCase_ == 9) {
                        this.scoreChallengeInfoBuilder_.mergeFrom(value);
                    }
                    this.scoreChallengeInfoBuilder_.setMessage(value);
                }
                this.challengeDetailCase_ = 9;
                return this;
            }

            public Builder clearScoreChallengeInfo() {
                if (this.scoreChallengeInfoBuilder_ != null) {
                    if (this.challengeDetailCase_ == 9) {
                        this.challengeDetailCase_ = 0;
                        this.challengeDetail_ = null;
                    }
                    this.scoreChallengeInfoBuilder_.clear();
                } else if (this.challengeDetailCase_ == 9) {
                    this.challengeDetailCase_ = 0;
                    this.challengeDetail_ = null;
                    onChanged();
                }
                return this;
            }

            public SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.Builder getScoreChallengeInfoBuilder() {
                return getScoreChallengeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfoOrBuilder getScoreChallengeInfoOrBuilder() {
                if (this.challengeDetailCase_ == 9 && this.scoreChallengeInfoBuilder_ != null) {
                    return this.scoreChallengeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.challengeDetailCase_ == 9) {
                    return (SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_;
                }
                return SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo, SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.Builder, SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfoOrBuilder> getScoreChallengeInfoFieldBuilder() {
                if (this.scoreChallengeInfoBuilder_ == null) {
                    if (this.challengeDetailCase_ != 9) {
                        this.challengeDetail_ = SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo.getDefaultInstance();
                    }
                    this.scoreChallengeInfoBuilder_ = new SingleFieldBuilderV3<>((SalvageScoreChallengeInfoOuterClass.SalvageScoreChallengeInfo) this.challengeDetail_, getParentForChildren(), isClean());
                    this.challengeDetail_ = null;
                }
                this.challengeDetailCase_ = 9;
                onChanged();
                return this.scoreChallengeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public boolean hasBossChallengeId() {
                return this.challengeDetailCase_ == 12;
            }

            @Override // emu.grasscutter.net.proto.SalvageChallengeInfoOuterClass.SalvageChallengeInfoOrBuilder
            public int getBossChallengeId() {
                if (this.challengeDetailCase_ == 12) {
                    return ((Integer) this.challengeDetail_).intValue();
                }
                return 0;
            }

            public Builder setBossChallengeId(int value) {
                this.challengeDetailCase_ = 12;
                this.challengeDetail_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearBossChallengeId() {
                if (this.challengeDetailCase_ == 12) {
                    this.challengeDetailCase_ = 0;
                    this.challengeDetail_ = null;
                    onChanged();
                }
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

        public static SalvageChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SalvageChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SalvageChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SalvageChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SalvageBundleChallengeInfoOuterClass.getDescriptor();
        SalvageScoreChallengeInfoOuterClass.getDescriptor();
    }
}
