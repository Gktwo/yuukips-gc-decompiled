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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.LunaRiteHintStatusTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteAreaInfoOuterClass.class */
public final class LunaRiteAreaInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016LunaRiteAreaInfo.proto\u001a\u001cLunaRiteHintStatusType.proto\"\u0001\n\u0010LunaRiteAreaInfo\u0012\u0016\n\u000echallengeIndex\u0018\t \u0001(\r\u0012\u001b\n\u0013sacrificeRewardList\u0018\r \u0003(\r\u0012\u0015\n\rsacrificeList\u0018\u0002 \u0003(\r\u0012+\n\nhintStatus\u0018\u0003 \u0001(\u000e2\u0017.LunaRiteHintStatusType\u0012\u000e\n\u0006areaId\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LunaRiteHintStatusTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LunaRiteAreaInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LunaRiteAreaInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LunaRiteAreaInfo_descriptor, new String[]{"ChallengeIndex", "SacrificeRewardList", "SacrificeList", "HintStatus", "AreaId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteAreaInfoOuterClass$LunaRiteAreaInfoOrBuilder.class */
    public interface LunaRiteAreaInfoOrBuilder extends MessageOrBuilder {
        int getChallengeIndex();

        List<Integer> getSacrificeRewardListList();

        int getSacrificeRewardListCount();

        int getSacrificeRewardList(int i);

        List<Integer> getSacrificeListList();

        int getSacrificeListCount();

        int getSacrificeList(int i);

        int getHintStatusValue();

        LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType getHintStatus();

        int getAreaId();
    }

    private LunaRiteAreaInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteAreaInfoOuterClass$LunaRiteAreaInfo.class */
    public static final class LunaRiteAreaInfo extends GeneratedMessageV3 implements LunaRiteAreaInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHALLENGEINDEX_FIELD_NUMBER = 9;
        private int challengeIndex_;
        public static final int SACRIFICEREWARDLIST_FIELD_NUMBER = 13;
        private Internal.IntList sacrificeRewardList_;
        private int sacrificeRewardListMemoizedSerializedSize;
        public static final int SACRIFICELIST_FIELD_NUMBER = 2;
        private Internal.IntList sacrificeList_;
        private int sacrificeListMemoizedSerializedSize;
        public static final int HINTSTATUS_FIELD_NUMBER = 3;
        private int hintStatus_;
        public static final int AREAID_FIELD_NUMBER = 12;
        private int areaId_;
        private byte memoizedIsInitialized;
        private static final LunaRiteAreaInfo DEFAULT_INSTANCE = new LunaRiteAreaInfo();
        private static final Parser<LunaRiteAreaInfo> PARSER = new AbstractParser<LunaRiteAreaInfo>() { // from class: emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.1
            @Override // com.google.protobuf.Parser
            public LunaRiteAreaInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LunaRiteAreaInfo(input, extensionRegistry);
            }
        };

        private LunaRiteAreaInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.sacrificeRewardListMemoizedSerializedSize = -1;
            this.sacrificeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private LunaRiteAreaInfo() {
            this.sacrificeRewardListMemoizedSerializedSize = -1;
            this.sacrificeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.sacrificeRewardList_ = emptyIntList();
            this.sacrificeList_ = emptyIntList();
            this.hintStatus_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LunaRiteAreaInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x0179 */
        private LunaRiteAreaInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 16:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.sacrificeList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.sacrificeList_.addInt(input.readUInt32());
                                    break;
                                case 18:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.sacrificeList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.sacrificeList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 24:
                                    this.hintStatus_ = input.readEnum();
                                    break;
                                case 72:
                                    this.challengeIndex_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.areaId_ = input.readUInt32();
                                    break;
                                case 104:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.sacrificeRewardList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.sacrificeRewardList_.addInt(input.readUInt32());
                                    break;
                                case 106:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.sacrificeRewardList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.sacrificeRewardList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                            done = done;
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.sacrificeList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.sacrificeRewardList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LunaRiteAreaInfoOuterClass.internal_static_LunaRiteAreaInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LunaRiteAreaInfoOuterClass.internal_static_LunaRiteAreaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LunaRiteAreaInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public int getChallengeIndex() {
            return this.challengeIndex_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public List<Integer> getSacrificeRewardListList() {
            return this.sacrificeRewardList_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public int getSacrificeRewardListCount() {
            return this.sacrificeRewardList_.size();
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public int getSacrificeRewardList(int index) {
            return this.sacrificeRewardList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public List<Integer> getSacrificeListList() {
            return this.sacrificeList_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public int getSacrificeListCount() {
            return this.sacrificeList_.size();
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public int getSacrificeList(int index) {
            return this.sacrificeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public int getHintStatusValue() {
            return this.hintStatus_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType getHintStatus() {
            LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType result = LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType.valueOf(this.hintStatus_);
            return result == null ? LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
        public int getAreaId() {
            return this.areaId_;
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
            getSerializedSize();
            if (getSacrificeListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.sacrificeListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.sacrificeList_.size(); i++) {
                output.writeUInt32NoTag(this.sacrificeList_.getInt(i));
            }
            if (this.hintStatus_ != LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType.LUNA_RITE_HINT_STATUS_TYPE_DEFAULT.getNumber()) {
                output.writeEnum(3, this.hintStatus_);
            }
            if (this.challengeIndex_ != 0) {
                output.writeUInt32(9, this.challengeIndex_);
            }
            if (this.areaId_ != 0) {
                output.writeUInt32(12, this.areaId_);
            }
            if (getSacrificeRewardListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.sacrificeRewardListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.sacrificeRewardList_.size(); i2++) {
                output.writeUInt32NoTag(this.sacrificeRewardList_.getInt(i2));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.sacrificeList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.sacrificeList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getSacrificeListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.sacrificeListMemoizedSerializedSize = dataSize;
            if (this.hintStatus_ != LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType.LUNA_RITE_HINT_STATUS_TYPE_DEFAULT.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(3, this.hintStatus_);
            }
            if (this.challengeIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.challengeIndex_);
            }
            if (this.areaId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.areaId_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.sacrificeRewardList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.sacrificeRewardList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getSacrificeRewardListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.sacrificeRewardListMemoizedSerializedSize = dataSize2;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LunaRiteAreaInfo)) {
                return equals(obj);
            }
            LunaRiteAreaInfo other = (LunaRiteAreaInfo) obj;
            return getChallengeIndex() == other.getChallengeIndex() && getSacrificeRewardListList().equals(other.getSacrificeRewardListList()) && getSacrificeListList().equals(other.getSacrificeListList()) && this.hintStatus_ == other.hintStatus_ && getAreaId() == other.getAreaId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getChallengeIndex();
            if (getSacrificeRewardListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getSacrificeRewardListList().hashCode();
            }
            if (getSacrificeListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getSacrificeListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 3)) + this.hintStatus_)) + 12)) + getAreaId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static LunaRiteAreaInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteAreaInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteAreaInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteAreaInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteAreaInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteAreaInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteAreaInfo parseFrom(InputStream input) throws IOException {
            return (LunaRiteAreaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LunaRiteAreaInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteAreaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LunaRiteAreaInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LunaRiteAreaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LunaRiteAreaInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteAreaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LunaRiteAreaInfo parseFrom(CodedInputStream input) throws IOException {
            return (LunaRiteAreaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LunaRiteAreaInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteAreaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LunaRiteAreaInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteAreaInfoOuterClass$LunaRiteAreaInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LunaRiteAreaInfoOrBuilder {
            private int bitField0_;
            private int challengeIndex_;
            private Internal.IntList sacrificeRewardList_ = LunaRiteAreaInfo.emptyIntList();
            private Internal.IntList sacrificeList_ = LunaRiteAreaInfo.emptyIntList();
            private int hintStatus_ = 0;
            private int areaId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LunaRiteAreaInfoOuterClass.internal_static_LunaRiteAreaInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LunaRiteAreaInfoOuterClass.internal_static_LunaRiteAreaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LunaRiteAreaInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LunaRiteAreaInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.challengeIndex_ = 0;
                this.sacrificeRewardList_ = LunaRiteAreaInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.sacrificeList_ = LunaRiteAreaInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.hintStatus_ = 0;
                this.areaId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LunaRiteAreaInfoOuterClass.internal_static_LunaRiteAreaInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LunaRiteAreaInfo getDefaultInstanceForType() {
                return LunaRiteAreaInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LunaRiteAreaInfo build() {
                LunaRiteAreaInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LunaRiteAreaInfo buildPartial() {
                LunaRiteAreaInfo result = new LunaRiteAreaInfo(this);
                int i = this.bitField0_;
                result.challengeIndex_ = this.challengeIndex_;
                if ((this.bitField0_ & 1) != 0) {
                    this.sacrificeRewardList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.sacrificeRewardList_ = this.sacrificeRewardList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.sacrificeList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.sacrificeList_ = this.sacrificeList_;
                result.hintStatus_ = this.hintStatus_;
                result.areaId_ = this.areaId_;
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
                if (other instanceof LunaRiteAreaInfo) {
                    return mergeFrom((LunaRiteAreaInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LunaRiteAreaInfo other) {
                if (other == LunaRiteAreaInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getChallengeIndex() != 0) {
                    setChallengeIndex(other.getChallengeIndex());
                }
                if (!other.sacrificeRewardList_.isEmpty()) {
                    if (this.sacrificeRewardList_.isEmpty()) {
                        this.sacrificeRewardList_ = other.sacrificeRewardList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureSacrificeRewardListIsMutable();
                        this.sacrificeRewardList_.addAll(other.sacrificeRewardList_);
                    }
                    onChanged();
                }
                if (!other.sacrificeList_.isEmpty()) {
                    if (this.sacrificeList_.isEmpty()) {
                        this.sacrificeList_ = other.sacrificeList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureSacrificeListIsMutable();
                        this.sacrificeList_.addAll(other.sacrificeList_);
                    }
                    onChanged();
                }
                if (other.hintStatus_ != 0) {
                    setHintStatusValue(other.getHintStatusValue());
                }
                if (other.getAreaId() != 0) {
                    setAreaId(other.getAreaId());
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
                LunaRiteAreaInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LunaRiteAreaInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LunaRiteAreaInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public int getChallengeIndex() {
                return this.challengeIndex_;
            }

            public Builder setChallengeIndex(int value) {
                this.challengeIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeIndex() {
                this.challengeIndex_ = 0;
                onChanged();
                return this;
            }

            private void ensureSacrificeRewardListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sacrificeRewardList_ = LunaRiteAreaInfo.mutableCopy(this.sacrificeRewardList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public List<Integer> getSacrificeRewardListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.sacrificeRewardList_) : this.sacrificeRewardList_;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public int getSacrificeRewardListCount() {
                return this.sacrificeRewardList_.size();
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public int getSacrificeRewardList(int index) {
                return this.sacrificeRewardList_.getInt(index);
            }

            public Builder setSacrificeRewardList(int index, int value) {
                ensureSacrificeRewardListIsMutable();
                this.sacrificeRewardList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSacrificeRewardList(int value) {
                ensureSacrificeRewardListIsMutable();
                this.sacrificeRewardList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSacrificeRewardList(Iterable<? extends Integer> values) {
                ensureSacrificeRewardListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sacrificeRewardList_);
                onChanged();
                return this;
            }

            public Builder clearSacrificeRewardList() {
                this.sacrificeRewardList_ = LunaRiteAreaInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureSacrificeListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.sacrificeList_ = LunaRiteAreaInfo.mutableCopy(this.sacrificeList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public List<Integer> getSacrificeListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.sacrificeList_) : this.sacrificeList_;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public int getSacrificeListCount() {
                return this.sacrificeList_.size();
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public int getSacrificeList(int index) {
                return this.sacrificeList_.getInt(index);
            }

            public Builder setSacrificeList(int index, int value) {
                ensureSacrificeListIsMutable();
                this.sacrificeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addSacrificeList(int value) {
                ensureSacrificeListIsMutable();
                this.sacrificeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllSacrificeList(Iterable<? extends Integer> values) {
                ensureSacrificeListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sacrificeList_);
                onChanged();
                return this;
            }

            public Builder clearSacrificeList() {
                this.sacrificeList_ = LunaRiteAreaInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public int getHintStatusValue() {
                return this.hintStatus_;
            }

            public Builder setHintStatusValue(int value) {
                this.hintStatus_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType getHintStatus() {
                LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType result = LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType.valueOf(this.hintStatus_);
                return result == null ? LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType.UNRECOGNIZED : result;
            }

            public Builder setHintStatus(LunaRiteHintStatusTypeOuterClass.LunaRiteHintStatusType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.hintStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearHintStatus() {
                this.hintStatus_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder
            public int getAreaId() {
                return this.areaId_;
            }

            public Builder setAreaId(int value) {
                this.areaId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaId() {
                this.areaId_ = 0;
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

        public static LunaRiteAreaInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LunaRiteAreaInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LunaRiteAreaInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LunaRiteAreaInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LunaRiteHintStatusTypeOuterClass.getDescriptor();
    }
}
