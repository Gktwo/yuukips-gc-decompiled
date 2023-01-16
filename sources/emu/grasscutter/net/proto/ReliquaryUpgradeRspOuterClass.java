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
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryUpgradeRspOuterClass.class */
public final class ReliquaryUpgradeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ReliquaryUpgradeRsp.proto\"¾\u0001\n\u0013ReliquaryUpgradeRsp\u0012\u001c\n\u0014cur_append_prop_list\u0018\r \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u0012\u001d\n\u0015target_reliquary_guid\u0018\u000e \u0001(\u0004\u0012\u0011\n\tcur_level\u0018\u0002 \u0001(\r\u0012\u0011\n\told_level\u0018\u0006 \u0001(\r\u0012\u001c\n\u0014old_append_prop_list\u0018\n \u0003(\r\u0012\u0015\n\rpower_up_rate\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ReliquaryUpgradeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ReliquaryUpgradeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ReliquaryUpgradeRsp_descriptor, new String[]{"CurAppendPropList", "Retcode", "TargetReliquaryGuid", "CurLevel", "OldLevel", "OldAppendPropList", "PowerUpRate"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryUpgradeRspOuterClass$ReliquaryUpgradeRspOrBuilder.class */
    public interface ReliquaryUpgradeRspOrBuilder extends MessageOrBuilder {
        List<Integer> getCurAppendPropListList();

        int getCurAppendPropListCount();

        int getCurAppendPropList(int i);

        int getRetcode();

        long getTargetReliquaryGuid();

        int getCurLevel();

        int getOldLevel();

        List<Integer> getOldAppendPropListList();

        int getOldAppendPropListCount();

        int getOldAppendPropList(int i);

        int getPowerUpRate();
    }

    private ReliquaryUpgradeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryUpgradeRspOuterClass$ReliquaryUpgradeRsp.class */
    public static final class ReliquaryUpgradeRsp extends GeneratedMessageV3 implements ReliquaryUpgradeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CUR_APPEND_PROP_LIST_FIELD_NUMBER = 13;
        private Internal.IntList curAppendPropList_;
        private int curAppendPropListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int TARGET_RELIQUARY_GUID_FIELD_NUMBER = 14;
        private long targetReliquaryGuid_;
        public static final int CUR_LEVEL_FIELD_NUMBER = 2;
        private int curLevel_;
        public static final int OLD_LEVEL_FIELD_NUMBER = 6;
        private int oldLevel_;
        public static final int OLD_APPEND_PROP_LIST_FIELD_NUMBER = 10;
        private Internal.IntList oldAppendPropList_;
        private int oldAppendPropListMemoizedSerializedSize;
        public static final int POWER_UP_RATE_FIELD_NUMBER = 1;
        private int powerUpRate_;
        private byte memoizedIsInitialized;
        private static final ReliquaryUpgradeRsp DEFAULT_INSTANCE = new ReliquaryUpgradeRsp();
        private static final Parser<ReliquaryUpgradeRsp> PARSER = new AbstractParser<ReliquaryUpgradeRsp>() { // from class: emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRsp.1
            @Override // com.google.protobuf.Parser
            public ReliquaryUpgradeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ReliquaryUpgradeRsp(input, extensionRegistry);
            }
        };

        private ReliquaryUpgradeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.curAppendPropListMemoizedSerializedSize = -1;
            this.oldAppendPropListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ReliquaryUpgradeRsp() {
            this.curAppendPropListMemoizedSerializedSize = -1;
            this.oldAppendPropListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.curAppendPropList_ = emptyIntList();
            this.oldAppendPropList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ReliquaryUpgradeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x019b */
        private ReliquaryUpgradeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.powerUpRate_ = input.readUInt32();
                                break;
                            case 16:
                                this.curLevel_ = input.readUInt32();
                                break;
                            case 48:
                                this.oldLevel_ = input.readUInt32();
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.oldAppendPropList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.oldAppendPropList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.oldAppendPropList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.oldAppendPropList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                this.retcode_ = input.readInt32();
                                break;
                            case 104:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.curAppendPropList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.curAppendPropList_.addInt(input.readUInt32());
                                break;
                            case 106:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.curAppendPropList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.curAppendPropList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 112:
                                this.targetReliquaryGuid_ = input.readUInt64();
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.oldAppendPropList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.curAppendPropList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReliquaryUpgradeRspOuterClass.internal_static_ReliquaryUpgradeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReliquaryUpgradeRspOuterClass.internal_static_ReliquaryUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryUpgradeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public List<Integer> getCurAppendPropListList() {
            return this.curAppendPropList_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getCurAppendPropListCount() {
            return this.curAppendPropList_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getCurAppendPropList(int index) {
            return this.curAppendPropList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public long getTargetReliquaryGuid() {
            return this.targetReliquaryGuid_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getCurLevel() {
            return this.curLevel_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getOldLevel() {
            return this.oldLevel_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public List<Integer> getOldAppendPropListList() {
            return this.oldAppendPropList_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getOldAppendPropListCount() {
            return this.oldAppendPropList_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getOldAppendPropList(int index) {
            return this.oldAppendPropList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
        public int getPowerUpRate() {
            return this.powerUpRate_;
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
            if (this.powerUpRate_ != 0) {
                output.writeUInt32(1, this.powerUpRate_);
            }
            if (this.curLevel_ != 0) {
                output.writeUInt32(2, this.curLevel_);
            }
            if (this.oldLevel_ != 0) {
                output.writeUInt32(6, this.oldLevel_);
            }
            if (getOldAppendPropListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.oldAppendPropListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.oldAppendPropList_.size(); i++) {
                output.writeUInt32NoTag(this.oldAppendPropList_.getInt(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
            }
            if (getCurAppendPropListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.curAppendPropListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.curAppendPropList_.size(); i2++) {
                output.writeUInt32NoTag(this.curAppendPropList_.getInt(i2));
            }
            if (this.targetReliquaryGuid_ != 0) {
                output.writeUInt64(14, this.targetReliquaryGuid_);
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
            if (this.powerUpRate_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.powerUpRate_);
            }
            if (this.curLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.curLevel_);
            }
            if (this.oldLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.oldLevel_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.oldAppendPropList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.oldAppendPropList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getOldAppendPropListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.oldAppendPropListMemoizedSerializedSize = dataSize;
            if (this.retcode_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(11, this.retcode_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.curAppendPropList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.curAppendPropList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getCurAppendPropListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.curAppendPropListMemoizedSerializedSize = dataSize2;
            if (this.targetReliquaryGuid_ != 0) {
                size4 += CodedOutputStream.computeUInt64Size(14, this.targetReliquaryGuid_);
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReliquaryUpgradeRsp)) {
                return equals(obj);
            }
            ReliquaryUpgradeRsp other = (ReliquaryUpgradeRsp) obj;
            return getCurAppendPropListList().equals(other.getCurAppendPropListList()) && getRetcode() == other.getRetcode() && getTargetReliquaryGuid() == other.getTargetReliquaryGuid() && getCurLevel() == other.getCurLevel() && getOldLevel() == other.getOldLevel() && getOldAppendPropListList().equals(other.getOldAppendPropListList()) && getPowerUpRate() == other.getPowerUpRate() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCurAppendPropListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getCurAppendPropListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 11)) + getRetcode())) + 14)) + Internal.hashLong(getTargetReliquaryGuid()))) + 2)) + getCurLevel())) + 6)) + getOldLevel();
            if (getOldAppendPropListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 10)) + getOldAppendPropListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 1)) + getPowerUpRate())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ReliquaryUpgradeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryUpgradeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryUpgradeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryUpgradeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryUpgradeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryUpgradeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryUpgradeRsp parseFrom(InputStream input) throws IOException {
            return (ReliquaryUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryUpgradeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryUpgradeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ReliquaryUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ReliquaryUpgradeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryUpgradeRsp parseFrom(CodedInputStream input) throws IOException {
            return (ReliquaryUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryUpgradeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReliquaryUpgradeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryUpgradeRspOuterClass$ReliquaryUpgradeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReliquaryUpgradeRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private long targetReliquaryGuid_;
            private int curLevel_;
            private int oldLevel_;
            private int powerUpRate_;
            private Internal.IntList curAppendPropList_ = ReliquaryUpgradeRsp.emptyIntList();
            private Internal.IntList oldAppendPropList_ = ReliquaryUpgradeRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ReliquaryUpgradeRspOuterClass.internal_static_ReliquaryUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReliquaryUpgradeRspOuterClass.internal_static_ReliquaryUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryUpgradeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ReliquaryUpgradeRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curAppendPropList_ = ReliquaryUpgradeRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                this.targetReliquaryGuid_ = 0;
                this.curLevel_ = 0;
                this.oldLevel_ = 0;
                this.oldAppendPropList_ = ReliquaryUpgradeRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.powerUpRate_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReliquaryUpgradeRspOuterClass.internal_static_ReliquaryUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReliquaryUpgradeRsp getDefaultInstanceForType() {
                return ReliquaryUpgradeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryUpgradeRsp build() {
                ReliquaryUpgradeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryUpgradeRsp buildPartial() {
                ReliquaryUpgradeRsp result = new ReliquaryUpgradeRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.curAppendPropList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.curAppendPropList_ = this.curAppendPropList_;
                result.retcode_ = this.retcode_;
                result.targetReliquaryGuid_ = this.targetReliquaryGuid_;
                result.curLevel_ = this.curLevel_;
                result.oldLevel_ = this.oldLevel_;
                if ((this.bitField0_ & 2) != 0) {
                    this.oldAppendPropList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.oldAppendPropList_ = this.oldAppendPropList_;
                result.powerUpRate_ = this.powerUpRate_;
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
                if (other instanceof ReliquaryUpgradeRsp) {
                    return mergeFrom((ReliquaryUpgradeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ReliquaryUpgradeRsp other) {
                if (other == ReliquaryUpgradeRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.curAppendPropList_.isEmpty()) {
                    if (this.curAppendPropList_.isEmpty()) {
                        this.curAppendPropList_ = other.curAppendPropList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureCurAppendPropListIsMutable();
                        this.curAppendPropList_.addAll(other.curAppendPropList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getTargetReliquaryGuid() != 0) {
                    setTargetReliquaryGuid(other.getTargetReliquaryGuid());
                }
                if (other.getCurLevel() != 0) {
                    setCurLevel(other.getCurLevel());
                }
                if (other.getOldLevel() != 0) {
                    setOldLevel(other.getOldLevel());
                }
                if (!other.oldAppendPropList_.isEmpty()) {
                    if (this.oldAppendPropList_.isEmpty()) {
                        this.oldAppendPropList_ = other.oldAppendPropList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureOldAppendPropListIsMutable();
                        this.oldAppendPropList_.addAll(other.oldAppendPropList_);
                    }
                    onChanged();
                }
                if (other.getPowerUpRate() != 0) {
                    setPowerUpRate(other.getPowerUpRate());
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
                ReliquaryUpgradeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ReliquaryUpgradeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ReliquaryUpgradeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCurAppendPropListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.curAppendPropList_ = ReliquaryUpgradeRsp.mutableCopy(this.curAppendPropList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public List<Integer> getCurAppendPropListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.curAppendPropList_) : this.curAppendPropList_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getCurAppendPropListCount() {
                return this.curAppendPropList_.size();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getCurAppendPropList(int index) {
                return this.curAppendPropList_.getInt(index);
            }

            public Builder setCurAppendPropList(int index, int value) {
                ensureCurAppendPropListIsMutable();
                this.curAppendPropList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCurAppendPropList(int value) {
                ensureCurAppendPropListIsMutable();
                this.curAppendPropList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCurAppendPropList(Iterable<? extends Integer> values) {
                ensureCurAppendPropListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.curAppendPropList_);
                onChanged();
                return this;
            }

            public Builder clearCurAppendPropList() {
                this.curAppendPropList_ = ReliquaryUpgradeRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public long getTargetReliquaryGuid() {
                return this.targetReliquaryGuid_;
            }

            public Builder setTargetReliquaryGuid(long value) {
                this.targetReliquaryGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetReliquaryGuid() {
                this.targetReliquaryGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getCurLevel() {
                return this.curLevel_;
            }

            public Builder setCurLevel(int value) {
                this.curLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurLevel() {
                this.curLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getOldLevel() {
                return this.oldLevel_;
            }

            public Builder setOldLevel(int value) {
                this.oldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearOldLevel() {
                this.oldLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureOldAppendPropListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.oldAppendPropList_ = ReliquaryUpgradeRsp.mutableCopy(this.oldAppendPropList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public List<Integer> getOldAppendPropListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.oldAppendPropList_) : this.oldAppendPropList_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getOldAppendPropListCount() {
                return this.oldAppendPropList_.size();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getOldAppendPropList(int index) {
                return this.oldAppendPropList_.getInt(index);
            }

            public Builder setOldAppendPropList(int index, int value) {
                ensureOldAppendPropListIsMutable();
                this.oldAppendPropList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOldAppendPropList(int value) {
                ensureOldAppendPropListIsMutable();
                this.oldAppendPropList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOldAppendPropList(Iterable<? extends Integer> values) {
                ensureOldAppendPropListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.oldAppendPropList_);
                onChanged();
                return this;
            }

            public Builder clearOldAppendPropList() {
                this.oldAppendPropList_ = ReliquaryUpgradeRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRspOrBuilder
            public int getPowerUpRate() {
                return this.powerUpRate_;
            }

            public Builder setPowerUpRate(int value) {
                this.powerUpRate_ = value;
                onChanged();
                return this;
            }

            public Builder clearPowerUpRate() {
                this.powerUpRate_ = 0;
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

        public static ReliquaryUpgradeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReliquaryUpgradeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReliquaryUpgradeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReliquaryUpgradeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
