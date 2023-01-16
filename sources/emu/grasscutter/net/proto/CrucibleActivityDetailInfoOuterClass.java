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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.CrucibleBattleUidInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrucibleActivityDetailInfoOuterClass.class */
public final class CrucibleActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n CrucibleActivityDetailInfo.proto\u001a\u001bCrucibleBattleUidInfo.proto\u001a\fVector.proto\"\u0001\n\u001aCrucibleActivityDetailInfo\u0012\u001a\n\u0012battle_world_level\u0018\u0005 \u0001(\r\u0012\u0011\n\tcost_time\u0018\u0007 \u0001(\r\u0012\u0014\n\u0003pos\u0018\t \u0001(\u000b2\u0007.Vector\u0012-\n\ruid_info_list\u0018\u000b \u0003(\u000b2\u0016.CrucibleBattleUidInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CrucibleBattleUidInfoOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CrucibleActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CrucibleActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CrucibleActivityDetailInfo_descriptor, new String[]{"BattleWorldLevel", "CostTime", "Pos", "UidInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrucibleActivityDetailInfoOuterClass$CrucibleActivityDetailInfoOrBuilder.class */
    public interface CrucibleActivityDetailInfoOrBuilder extends MessageOrBuilder {
        int getBattleWorldLevel();

        int getCostTime();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        List<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo> getUidInfoListList();

        CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo getUidInfoList(int i);

        int getUidInfoListCount();

        List<? extends CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder> getUidInfoListOrBuilderList();

        CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder getUidInfoListOrBuilder(int i);
    }

    private CrucibleActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrucibleActivityDetailInfoOuterClass$CrucibleActivityDetailInfo.class */
    public static final class CrucibleActivityDetailInfo extends GeneratedMessageV3 implements CrucibleActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BATTLE_WORLD_LEVEL_FIELD_NUMBER = 5;
        private int battleWorldLevel_;
        public static final int COST_TIME_FIELD_NUMBER = 7;
        private int costTime_;
        public static final int POS_FIELD_NUMBER = 9;
        private VectorOuterClass.Vector pos_;
        public static final int UID_INFO_LIST_FIELD_NUMBER = 11;
        private List<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo> uidInfoList_;
        private byte memoizedIsInitialized;
        private static final CrucibleActivityDetailInfo DEFAULT_INSTANCE = new CrucibleActivityDetailInfo();
        private static final Parser<CrucibleActivityDetailInfo> PARSER = new AbstractParser<CrucibleActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public CrucibleActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CrucibleActivityDetailInfo(input, extensionRegistry);
            }
        };

        private CrucibleActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CrucibleActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.uidInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CrucibleActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CrucibleActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 40:
                                this.battleWorldLevel_ = input.readUInt32();
                                break;
                            case 56:
                                this.costTime_ = input.readUInt32();
                                break;
                            case 74:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.uidInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.uidInfoList_.add((CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo) input.readMessage(CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.uidInfoList_ = Collections.unmodifiableList(this.uidInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CrucibleActivityDetailInfoOuterClass.internal_static_CrucibleActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CrucibleActivityDetailInfoOuterClass.internal_static_CrucibleActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrucibleActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public int getBattleWorldLevel() {
            return this.battleWorldLevel_;
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public int getCostTime() {
            return this.costTime_;
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public List<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo> getUidInfoListList() {
            return this.uidInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public List<? extends CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder> getUidInfoListOrBuilderList() {
            return this.uidInfoList_;
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public int getUidInfoListCount() {
            return this.uidInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo getUidInfoList(int index) {
            return this.uidInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
        public CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder getUidInfoListOrBuilder(int index) {
            return this.uidInfoList_.get(index);
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
            if (this.battleWorldLevel_ != 0) {
                output.writeUInt32(5, this.battleWorldLevel_);
            }
            if (this.costTime_ != 0) {
                output.writeUInt32(7, this.costTime_);
            }
            if (this.pos_ != null) {
                output.writeMessage(9, getPos());
            }
            for (int i = 0; i < this.uidInfoList_.size(); i++) {
                output.writeMessage(11, this.uidInfoList_.get(i));
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
            if (this.battleWorldLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.battleWorldLevel_);
            }
            if (this.costTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.costTime_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getPos());
            }
            for (int i = 0; i < this.uidInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.uidInfoList_.get(i));
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
            if (!(obj instanceof CrucibleActivityDetailInfo)) {
                return equals(obj);
            }
            CrucibleActivityDetailInfo other = (CrucibleActivityDetailInfo) obj;
            if (getBattleWorldLevel() == other.getBattleWorldLevel() && getCostTime() == other.getCostTime() && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && getUidInfoListList().equals(other.getUidInfoListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getBattleWorldLevel())) + 7)) + getCostTime();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 9)) + getPos().hashCode();
            }
            if (getUidInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getUidInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CrucibleActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrucibleActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrucibleActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrucibleActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrucibleActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrucibleActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrucibleActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (CrucibleActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrucibleActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrucibleActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrucibleActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CrucibleActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CrucibleActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrucibleActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrucibleActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (CrucibleActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrucibleActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrucibleActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CrucibleActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrucibleActivityDetailInfoOuterClass$CrucibleActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CrucibleActivityDetailInfoOrBuilder {
            private int bitField0_;
            private int battleWorldLevel_;
            private int costTime_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private List<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo> uidInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder> uidInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CrucibleActivityDetailInfoOuterClass.internal_static_CrucibleActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CrucibleActivityDetailInfoOuterClass.internal_static_CrucibleActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrucibleActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CrucibleActivityDetailInfo.alwaysUseFieldBuilders) {
                    getUidInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.battleWorldLevel_ = 0;
                this.costTime_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                if (this.uidInfoListBuilder_ == null) {
                    this.uidInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uidInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CrucibleActivityDetailInfoOuterClass.internal_static_CrucibleActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CrucibleActivityDetailInfo getDefaultInstanceForType() {
                return CrucibleActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrucibleActivityDetailInfo build() {
                CrucibleActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrucibleActivityDetailInfo buildPartial() {
                CrucibleActivityDetailInfo result = new CrucibleActivityDetailInfo(this);
                int i = this.bitField0_;
                result.battleWorldLevel_ = this.battleWorldLevel_;
                result.costTime_ = this.costTime_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                if (this.uidInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.uidInfoList_ = Collections.unmodifiableList(this.uidInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.uidInfoList_ = this.uidInfoList_;
                } else {
                    result.uidInfoList_ = this.uidInfoListBuilder_.build();
                }
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
                if (other instanceof CrucibleActivityDetailInfo) {
                    return mergeFrom((CrucibleActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CrucibleActivityDetailInfo other) {
                if (other == CrucibleActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getBattleWorldLevel() != 0) {
                    setBattleWorldLevel(other.getBattleWorldLevel());
                }
                if (other.getCostTime() != 0) {
                    setCostTime(other.getCostTime());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (this.uidInfoListBuilder_ == null) {
                    if (!other.uidInfoList_.isEmpty()) {
                        if (this.uidInfoList_.isEmpty()) {
                            this.uidInfoList_ = other.uidInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureUidInfoListIsMutable();
                            this.uidInfoList_.addAll(other.uidInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.uidInfoList_.isEmpty()) {
                    if (this.uidInfoListBuilder_.isEmpty()) {
                        this.uidInfoListBuilder_.dispose();
                        this.uidInfoListBuilder_ = null;
                        this.uidInfoList_ = other.uidInfoList_;
                        this.bitField0_ &= -2;
                        this.uidInfoListBuilder_ = CrucibleActivityDetailInfo.alwaysUseFieldBuilders ? getUidInfoListFieldBuilder() : null;
                    } else {
                        this.uidInfoListBuilder_.addAllMessages(other.uidInfoList_);
                    }
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
                CrucibleActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CrucibleActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CrucibleActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public int getBattleWorldLevel() {
                return this.battleWorldLevel_;
            }

            public Builder setBattleWorldLevel(int value) {
                this.battleWorldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearBattleWorldLevel() {
                this.battleWorldLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public int getCostTime() {
                return this.costTime_;
            }

            public Builder setCostTime(int value) {
                this.costTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostTime() {
                this.costTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public VectorOuterClass.Vector getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = VectorOuterClass.Vector.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            private void ensureUidInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.uidInfoList_ = new ArrayList(this.uidInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public List<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo> getUidInfoListList() {
                if (this.uidInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.uidInfoList_);
                }
                return this.uidInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public int getUidInfoListCount() {
                if (this.uidInfoListBuilder_ == null) {
                    return this.uidInfoList_.size();
                }
                return this.uidInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo getUidInfoList(int index) {
                if (this.uidInfoListBuilder_ == null) {
                    return this.uidInfoList_.get(index);
                }
                return this.uidInfoListBuilder_.getMessage(index);
            }

            public Builder setUidInfoList(int index, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo value) {
                if (this.uidInfoListBuilder_ != null) {
                    this.uidInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUidInfoList(int index, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder builderForValue) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUidInfoList(CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo value) {
                if (this.uidInfoListBuilder_ != null) {
                    this.uidInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUidInfoList(int index, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo value) {
                if (this.uidInfoListBuilder_ != null) {
                    this.uidInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUidInfoList(CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder builderForValue) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUidInfoList(int index, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder builderForValue) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUidInfoList(Iterable<? extends CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo> values) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.uidInfoList_);
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUidInfoList() {
                if (this.uidInfoListBuilder_ == null) {
                    this.uidInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeUidInfoList(int index) {
                if (this.uidInfoListBuilder_ == null) {
                    ensureUidInfoListIsMutable();
                    this.uidInfoList_.remove(index);
                    onChanged();
                } else {
                    this.uidInfoListBuilder_.remove(index);
                }
                return this;
            }

            public CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder getUidInfoListBuilder(int index) {
                return getUidInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder getUidInfoListOrBuilder(int index) {
                if (this.uidInfoListBuilder_ == null) {
                    return this.uidInfoList_.get(index);
                }
                return this.uidInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder
            public List<? extends CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder> getUidInfoListOrBuilderList() {
                if (this.uidInfoListBuilder_ != null) {
                    return this.uidInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.uidInfoList_);
            }

            public CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder addUidInfoListBuilder() {
                return getUidInfoListFieldBuilder().addBuilder(CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.getDefaultInstance());
            }

            public CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder addUidInfoListBuilder(int index) {
                return getUidInfoListFieldBuilder().addBuilder(index, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.getDefaultInstance());
            }

            public List<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder> getUidInfoListBuilderList() {
                return getUidInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfo.Builder, CrucibleBattleUidInfoOuterClass.CrucibleBattleUidInfoOrBuilder> getUidInfoListFieldBuilder() {
                if (this.uidInfoListBuilder_ == null) {
                    this.uidInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.uidInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.uidInfoList_ = null;
                }
                return this.uidInfoListBuilder_;
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

        public static CrucibleActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CrucibleActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CrucibleActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CrucibleActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CrucibleBattleUidInfoOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
