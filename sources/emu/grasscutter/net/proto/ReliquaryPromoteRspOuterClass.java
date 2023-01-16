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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteRspOuterClass.class */
public final class ReliquaryPromoteRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019ReliquaryPromoteRsp.proto\"·\u0001\n\u0013ReliquaryPromoteRsp\u0012\u001c\n\u0014old_append_prop_list\u0018\b \u0003(\r\u0012\u0019\n\u0011old_promote_level\u0018\t \u0001(\r\u0012\u001c\n\u0014cur_append_prop_list\u0018\r \u0003(\r\u0012\u000f\n\u0007retcode\u0018\n \u0001(\u0005\u0012\u001d\n\u0015target_reliquary_guid\u0018\u0006 \u0001(\u0004\u0012\u0019\n\u0011cur_promote_level\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ReliquaryPromoteRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ReliquaryPromoteRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ReliquaryPromoteRsp_descriptor, new String[]{"OldAppendPropList", "OldPromoteLevel", "CurAppendPropList", "Retcode", "TargetReliquaryGuid", "CurPromoteLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteRspOuterClass$ReliquaryPromoteRspOrBuilder.class */
    public interface ReliquaryPromoteRspOrBuilder extends MessageOrBuilder {
        List<Integer> getOldAppendPropListList();

        int getOldAppendPropListCount();

        int getOldAppendPropList(int i);

        int getOldPromoteLevel();

        List<Integer> getCurAppendPropListList();

        int getCurAppendPropListCount();

        int getCurAppendPropList(int i);

        int getRetcode();

        long getTargetReliquaryGuid();

        int getCurPromoteLevel();
    }

    private ReliquaryPromoteRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteRspOuterClass$ReliquaryPromoteRsp.class */
    public static final class ReliquaryPromoteRsp extends GeneratedMessageV3 implements ReliquaryPromoteRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OLD_APPEND_PROP_LIST_FIELD_NUMBER = 8;
        private Internal.IntList oldAppendPropList_;
        private int oldAppendPropListMemoizedSerializedSize;
        public static final int OLD_PROMOTE_LEVEL_FIELD_NUMBER = 9;
        private int oldPromoteLevel_;
        public static final int CUR_APPEND_PROP_LIST_FIELD_NUMBER = 13;
        private Internal.IntList curAppendPropList_;
        private int curAppendPropListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 10;
        private int retcode_;
        public static final int TARGET_RELIQUARY_GUID_FIELD_NUMBER = 6;
        private long targetReliquaryGuid_;
        public static final int CUR_PROMOTE_LEVEL_FIELD_NUMBER = 4;
        private int curPromoteLevel_;
        private byte memoizedIsInitialized;
        private static final ReliquaryPromoteRsp DEFAULT_INSTANCE = new ReliquaryPromoteRsp();
        private static final Parser<ReliquaryPromoteRsp> PARSER = new AbstractParser<ReliquaryPromoteRsp>() { // from class: emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRsp.1
            @Override // com.google.protobuf.Parser
            public ReliquaryPromoteRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ReliquaryPromoteRsp(input, extensionRegistry);
            }
        };

        private ReliquaryPromoteRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.oldAppendPropListMemoizedSerializedSize = -1;
            this.curAppendPropListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ReliquaryPromoteRsp() {
            this.oldAppendPropListMemoizedSerializedSize = -1;
            this.curAppendPropListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.oldAppendPropList_ = emptyIntList();
            this.curAppendPropList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ReliquaryPromoteRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x0188 */
        private ReliquaryPromoteRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.curPromoteLevel_ = input.readUInt32();
                                    break;
                                case 48:
                                    this.targetReliquaryGuid_ = input.readUInt64();
                                    break;
                                case 64:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.oldAppendPropList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.oldAppendPropList_.addInt(input.readUInt32());
                                    break;
                                case 66:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.oldAppendPropList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.oldAppendPropList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 72:
                                    this.oldPromoteLevel_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 104:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.curAppendPropList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.curAppendPropList_.addInt(input.readUInt32());
                                    break;
                                case 106:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.curAppendPropList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.curAppendPropList_.addInt(input.readUInt32());
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.oldAppendPropList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.curAppendPropList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReliquaryPromoteRspOuterClass.internal_static_ReliquaryPromoteRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReliquaryPromoteRspOuterClass.internal_static_ReliquaryPromoteRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryPromoteRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public List<Integer> getOldAppendPropListList() {
            return this.oldAppendPropList_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public int getOldAppendPropListCount() {
            return this.oldAppendPropList_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public int getOldAppendPropList(int index) {
            return this.oldAppendPropList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public int getOldPromoteLevel() {
            return this.oldPromoteLevel_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public List<Integer> getCurAppendPropListList() {
            return this.curAppendPropList_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public int getCurAppendPropListCount() {
            return this.curAppendPropList_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public int getCurAppendPropList(int index) {
            return this.curAppendPropList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public long getTargetReliquaryGuid() {
            return this.targetReliquaryGuid_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
        public int getCurPromoteLevel() {
            return this.curPromoteLevel_;
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
            if (this.curPromoteLevel_ != 0) {
                output.writeUInt32(4, this.curPromoteLevel_);
            }
            if (this.targetReliquaryGuid_ != 0) {
                output.writeUInt64(6, this.targetReliquaryGuid_);
            }
            if (getOldAppendPropListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.oldAppendPropListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.oldAppendPropList_.size(); i++) {
                output.writeUInt32NoTag(this.oldAppendPropList_.getInt(i));
            }
            if (this.oldPromoteLevel_ != 0) {
                output.writeUInt32(9, this.oldPromoteLevel_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(10, this.retcode_);
            }
            if (getCurAppendPropListList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.curAppendPropListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.curAppendPropList_.size(); i2++) {
                output.writeUInt32NoTag(this.curAppendPropList_.getInt(i2));
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
            if (this.curPromoteLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.curPromoteLevel_);
            }
            if (this.targetReliquaryGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(6, this.targetReliquaryGuid_);
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
            if (this.oldPromoteLevel_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(9, this.oldPromoteLevel_);
            }
            if (this.retcode_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(10, this.retcode_);
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
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ReliquaryPromoteRsp)) {
                return equals(obj);
            }
            ReliquaryPromoteRsp other = (ReliquaryPromoteRsp) obj;
            return getOldAppendPropListList().equals(other.getOldAppendPropListList()) && getOldPromoteLevel() == other.getOldPromoteLevel() && getCurAppendPropListList().equals(other.getCurAppendPropListList()) && getRetcode() == other.getRetcode() && getTargetReliquaryGuid() == other.getTargetReliquaryGuid() && getCurPromoteLevel() == other.getCurPromoteLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getOldAppendPropListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getOldAppendPropListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 9)) + getOldPromoteLevel();
            if (getCurAppendPropListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 13)) + getCurAppendPropListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 10)) + getRetcode())) + 6)) + Internal.hashLong(getTargetReliquaryGuid()))) + 4)) + getCurPromoteLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ReliquaryPromoteRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryPromoteRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryPromoteRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryPromoteRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryPromoteRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ReliquaryPromoteRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ReliquaryPromoteRsp parseFrom(InputStream input) throws IOException {
            return (ReliquaryPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryPromoteRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryPromoteRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ReliquaryPromoteRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ReliquaryPromoteRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryPromoteRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ReliquaryPromoteRsp parseFrom(CodedInputStream input) throws IOException {
            return (ReliquaryPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ReliquaryPromoteRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReliquaryPromoteRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ReliquaryPromoteRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryPromoteRspOuterClass$ReliquaryPromoteRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReliquaryPromoteRspOrBuilder {
            private int bitField0_;
            private int oldPromoteLevel_;
            private int retcode_;
            private long targetReliquaryGuid_;
            private int curPromoteLevel_;
            private Internal.IntList oldAppendPropList_ = ReliquaryPromoteRsp.emptyIntList();
            private Internal.IntList curAppendPropList_ = ReliquaryPromoteRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ReliquaryPromoteRspOuterClass.internal_static_ReliquaryPromoteRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReliquaryPromoteRspOuterClass.internal_static_ReliquaryPromoteRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ReliquaryPromoteRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ReliquaryPromoteRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.oldAppendPropList_ = ReliquaryPromoteRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.oldPromoteLevel_ = 0;
                this.curAppendPropList_ = ReliquaryPromoteRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.retcode_ = 0;
                this.targetReliquaryGuid_ = 0;
                this.curPromoteLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReliquaryPromoteRspOuterClass.internal_static_ReliquaryPromoteRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ReliquaryPromoteRsp getDefaultInstanceForType() {
                return ReliquaryPromoteRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryPromoteRsp build() {
                ReliquaryPromoteRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ReliquaryPromoteRsp buildPartial() {
                ReliquaryPromoteRsp result = new ReliquaryPromoteRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.oldAppendPropList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.oldAppendPropList_ = this.oldAppendPropList_;
                result.oldPromoteLevel_ = this.oldPromoteLevel_;
                if ((this.bitField0_ & 2) != 0) {
                    this.curAppendPropList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.curAppendPropList_ = this.curAppendPropList_;
                result.retcode_ = this.retcode_;
                result.targetReliquaryGuid_ = this.targetReliquaryGuid_;
                result.curPromoteLevel_ = this.curPromoteLevel_;
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
                if (other instanceof ReliquaryPromoteRsp) {
                    return mergeFrom((ReliquaryPromoteRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ReliquaryPromoteRsp other) {
                if (other == ReliquaryPromoteRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.oldAppendPropList_.isEmpty()) {
                    if (this.oldAppendPropList_.isEmpty()) {
                        this.oldAppendPropList_ = other.oldAppendPropList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOldAppendPropListIsMutable();
                        this.oldAppendPropList_.addAll(other.oldAppendPropList_);
                    }
                    onChanged();
                }
                if (other.getOldPromoteLevel() != 0) {
                    setOldPromoteLevel(other.getOldPromoteLevel());
                }
                if (!other.curAppendPropList_.isEmpty()) {
                    if (this.curAppendPropList_.isEmpty()) {
                        this.curAppendPropList_ = other.curAppendPropList_;
                        this.bitField0_ &= -3;
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
                if (other.getCurPromoteLevel() != 0) {
                    setCurPromoteLevel(other.getCurPromoteLevel());
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
                ReliquaryPromoteRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ReliquaryPromoteRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ReliquaryPromoteRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureOldAppendPropListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.oldAppendPropList_ = ReliquaryPromoteRsp.mutableCopy(this.oldAppendPropList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
            public List<Integer> getOldAppendPropListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.oldAppendPropList_) : this.oldAppendPropList_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
            public int getOldAppendPropListCount() {
                return this.oldAppendPropList_.size();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
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
                this.oldAppendPropList_ = ReliquaryPromoteRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
            public int getOldPromoteLevel() {
                return this.oldPromoteLevel_;
            }

            public Builder setOldPromoteLevel(int value) {
                this.oldPromoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearOldPromoteLevel() {
                this.oldPromoteLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureCurAppendPropListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.curAppendPropList_ = ReliquaryPromoteRsp.mutableCopy(this.curAppendPropList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
            public List<Integer> getCurAppendPropListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.curAppendPropList_) : this.curAppendPropList_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
            public int getCurAppendPropListCount() {
                return this.curAppendPropList_.size();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
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
                this.curAppendPropList_ = ReliquaryPromoteRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.ReliquaryPromoteRspOuterClass.ReliquaryPromoteRspOrBuilder
            public int getCurPromoteLevel() {
                return this.curPromoteLevel_;
            }

            public Builder setCurPromoteLevel(int value) {
                this.curPromoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurPromoteLevel() {
                this.curPromoteLevel_ = 0;
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

        public static ReliquaryPromoteRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReliquaryPromoteRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ReliquaryPromoteRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ReliquaryPromoteRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
