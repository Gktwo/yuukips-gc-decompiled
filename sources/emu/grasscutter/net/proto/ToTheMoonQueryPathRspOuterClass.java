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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.PathStatusTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathRspOuterClass.class */
public final class ToTheMoonQueryPathRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bToTheMoonQueryPathRsp.proto\u001a\u0014PathStatusType.proto\u001a\fVector.proto\"\u0001\n\u0015ToTheMoonQueryPathRsp\u0012\u000f\n\u0007queryId\u0018\u000b \u0001(\u0005\u0012$\n\u000bqueryStatus\u0018\u000f \u0001(\u000e2\u000f.PathStatusType\u0012\r\n\u0005index\u0018\n \u0003(\u0003\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012\u0018\n\u0007corners\u0018\u0003 \u0003(\u000b2\u0007.Vector\u0012\r\n\u0005level\u0018\r \u0003(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PathStatusTypeOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ToTheMoonQueryPathRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ToTheMoonQueryPathRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ToTheMoonQueryPathRsp_descriptor, new String[]{"QueryId", "QueryStatus", "Index", "Retcode", "Corners", "Level"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathRspOuterClass$ToTheMoonQueryPathRspOrBuilder.class */
    public interface ToTheMoonQueryPathRspOrBuilder extends MessageOrBuilder {
        int getQueryId();

        int getQueryStatusValue();

        PathStatusTypeOuterClass.PathStatusType getQueryStatus();

        List<Long> getIndexList();

        int getIndexCount();

        long getIndex(int i);

        int getRetcode();

        List<VectorOuterClass.Vector> getCornersList();

        VectorOuterClass.Vector getCorners(int i);

        int getCornersCount();

        List<? extends VectorOuterClass.VectorOrBuilder> getCornersOrBuilderList();

        VectorOuterClass.VectorOrBuilder getCornersOrBuilder(int i);

        List<Integer> getLevelList();

        int getLevelCount();

        int getLevel(int i);
    }

    private ToTheMoonQueryPathRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathRspOuterClass$ToTheMoonQueryPathRsp.class */
    public static final class ToTheMoonQueryPathRsp extends GeneratedMessageV3 implements ToTheMoonQueryPathRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int QUERYID_FIELD_NUMBER = 11;
        private int queryId_;
        public static final int QUERYSTATUS_FIELD_NUMBER = 15;
        private int queryStatus_;
        public static final int INDEX_FIELD_NUMBER = 10;
        private Internal.LongList index_;
        private int indexMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int CORNERS_FIELD_NUMBER = 3;
        private List<VectorOuterClass.Vector> corners_;
        public static final int LEVEL_FIELD_NUMBER = 13;
        private Internal.IntList level_;
        private int levelMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final ToTheMoonQueryPathRsp DEFAULT_INSTANCE = new ToTheMoonQueryPathRsp();
        private static final Parser<ToTheMoonQueryPathRsp> PARSER = new AbstractParser<ToTheMoonQueryPathRsp>() { // from class: emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRsp.1
            @Override // com.google.protobuf.Parser
            public ToTheMoonQueryPathRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ToTheMoonQueryPathRsp(input, extensionRegistry);
            }
        };

        private ToTheMoonQueryPathRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.indexMemoizedSerializedSize = -1;
            this.levelMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ToTheMoonQueryPathRsp() {
            this.indexMemoizedSerializedSize = -1;
            this.levelMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.queryStatus_ = 0;
            this.index_ = emptyLongList();
            this.corners_ = Collections.emptyList();
            this.level_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ToTheMoonQueryPathRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x01ae */
        private ToTheMoonQueryPathRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.retcode_ = input.readInt32();
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.corners_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.corners_.add((VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry));
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.index_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.index_.addLong(input.readInt64());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.index_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.index_.addLong(input.readInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                this.queryId_ = input.readInt32();
                                break;
                            case 104:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.level_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.level_.addInt(input.readInt32());
                                break;
                            case 106:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.level_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.level_.addInt(input.readInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 120:
                                this.queryStatus_ = input.readEnum();
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
                    this.corners_ = Collections.unmodifiableList(this.corners_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.index_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.level_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ToTheMoonQueryPathRspOuterClass.internal_static_ToTheMoonQueryPathRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ToTheMoonQueryPathRspOuterClass.internal_static_ToTheMoonQueryPathRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ToTheMoonQueryPathRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public int getQueryId() {
            return this.queryId_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public int getQueryStatusValue() {
            return this.queryStatus_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public PathStatusTypeOuterClass.PathStatusType getQueryStatus() {
            PathStatusTypeOuterClass.PathStatusType result = PathStatusTypeOuterClass.PathStatusType.valueOf(this.queryStatus_);
            return result == null ? PathStatusTypeOuterClass.PathStatusType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public List<Long> getIndexList() {
            return this.index_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public int getIndexCount() {
            return this.index_.size();
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public long getIndex(int index) {
            return this.index_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public List<VectorOuterClass.Vector> getCornersList() {
            return this.corners_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public List<? extends VectorOuterClass.VectorOrBuilder> getCornersOrBuilderList() {
            return this.corners_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public int getCornersCount() {
            return this.corners_.size();
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public VectorOuterClass.Vector getCorners(int index) {
            return this.corners_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public VectorOuterClass.VectorOrBuilder getCornersOrBuilder(int index) {
            return this.corners_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public List<Integer> getLevelList() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public int getLevelCount() {
            return this.level_.size();
        }

        @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
        public int getLevel(int index) {
            return this.level_.getInt(index);
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
            if (this.retcode_ != 0) {
                output.writeInt32(1, this.retcode_);
            }
            for (int i = 0; i < this.corners_.size(); i++) {
                output.writeMessage(3, this.corners_.get(i));
            }
            if (getIndexList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.indexMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.index_.size(); i2++) {
                output.writeInt64NoTag(this.index_.getLong(i2));
            }
            if (this.queryId_ != 0) {
                output.writeInt32(11, this.queryId_);
            }
            if (getLevelList().size() > 0) {
                output.writeUInt32NoTag(106);
                output.writeUInt32NoTag(this.levelMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.level_.size(); i3++) {
                output.writeInt32NoTag(this.level_.getInt(i3));
            }
            if (this.queryStatus_ != PathStatusTypeOuterClass.PathStatusType.PATH_STATUS_TYPE_FAIL.getNumber()) {
                output.writeEnum(15, this.queryStatus_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            for (int i = 0; i < this.corners_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.corners_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.index_.size(); i2++) {
                dataSize += CodedOutputStream.computeInt64SizeNoTag(this.index_.getLong(i2));
            }
            int size3 = size2 + dataSize;
            if (!getIndexList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.indexMemoizedSerializedSize = dataSize;
            if (this.queryId_ != 0) {
                size3 += CodedOutputStream.computeInt32Size(11, this.queryId_);
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.level_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeInt32SizeNoTag(this.level_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getLevelList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.levelMemoizedSerializedSize = dataSize2;
            if (this.queryStatus_ != PathStatusTypeOuterClass.PathStatusType.PATH_STATUS_TYPE_FAIL.getNumber()) {
                size4 += CodedOutputStream.computeEnumSize(15, this.queryStatus_);
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
            if (!(obj instanceof ToTheMoonQueryPathRsp)) {
                return equals(obj);
            }
            ToTheMoonQueryPathRsp other = (ToTheMoonQueryPathRsp) obj;
            return getQueryId() == other.getQueryId() && this.queryStatus_ == other.queryStatus_ && getIndexList().equals(other.getIndexList()) && getRetcode() == other.getRetcode() && getCornersList().equals(other.getCornersList()) && getLevelList().equals(other.getLevelList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getQueryId())) + 15)) + this.queryStatus_;
            if (getIndexCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getIndexList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 1)) + getRetcode();
            if (getCornersCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getCornersList().hashCode();
            }
            if (getLevelCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 13)) + getLevelList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ToTheMoonQueryPathRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ToTheMoonQueryPathRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ToTheMoonQueryPathRsp parseFrom(InputStream input) throws IOException {
            return (ToTheMoonQueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ToTheMoonQueryPathRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (ToTheMoonQueryPathRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ToTheMoonQueryPathRsp parseFrom(CodedInputStream input) throws IOException {
            return (ToTheMoonQueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ToTheMoonQueryPathRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ToTheMoonQueryPathRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ToTheMoonQueryPathRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ToTheMoonQueryPathRspOuterClass$ToTheMoonQueryPathRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ToTheMoonQueryPathRspOrBuilder {
            private int bitField0_;
            private int queryId_;
            private int retcode_;
            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> cornersBuilder_;
            private int queryStatus_ = 0;
            private Internal.LongList index_ = ToTheMoonQueryPathRsp.emptyLongList();
            private List<VectorOuterClass.Vector> corners_ = Collections.emptyList();
            private Internal.IntList level_ = ToTheMoonQueryPathRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ToTheMoonQueryPathRspOuterClass.internal_static_ToTheMoonQueryPathRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ToTheMoonQueryPathRspOuterClass.internal_static_ToTheMoonQueryPathRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(ToTheMoonQueryPathRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ToTheMoonQueryPathRsp.alwaysUseFieldBuilders) {
                    getCornersFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.queryId_ = 0;
                this.queryStatus_ = 0;
                this.index_ = ToTheMoonQueryPathRsp.emptyLongList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                if (this.cornersBuilder_ == null) {
                    this.corners_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.cornersBuilder_.clear();
                }
                this.level_ = ToTheMoonQueryPathRsp.emptyIntList();
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ToTheMoonQueryPathRspOuterClass.internal_static_ToTheMoonQueryPathRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ToTheMoonQueryPathRsp getDefaultInstanceForType() {
                return ToTheMoonQueryPathRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ToTheMoonQueryPathRsp build() {
                ToTheMoonQueryPathRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ToTheMoonQueryPathRsp buildPartial() {
                ToTheMoonQueryPathRsp result = new ToTheMoonQueryPathRsp(this);
                int i = this.bitField0_;
                result.queryId_ = this.queryId_;
                result.queryStatus_ = this.queryStatus_;
                if ((this.bitField0_ & 1) != 0) {
                    this.index_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.index_ = this.index_;
                result.retcode_ = this.retcode_;
                if (this.cornersBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.corners_ = Collections.unmodifiableList(this.corners_);
                        this.bitField0_ &= -3;
                    }
                    result.corners_ = this.corners_;
                } else {
                    result.corners_ = this.cornersBuilder_.build();
                }
                if ((this.bitField0_ & 4) != 0) {
                    this.level_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.level_ = this.level_;
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
                if (other instanceof ToTheMoonQueryPathRsp) {
                    return mergeFrom((ToTheMoonQueryPathRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ToTheMoonQueryPathRsp other) {
                if (other == ToTheMoonQueryPathRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getQueryId() != 0) {
                    setQueryId(other.getQueryId());
                }
                if (other.queryStatus_ != 0) {
                    setQueryStatusValue(other.getQueryStatusValue());
                }
                if (!other.index_.isEmpty()) {
                    if (this.index_.isEmpty()) {
                        this.index_ = other.index_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureIndexIsMutable();
                        this.index_.addAll(other.index_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.cornersBuilder_ == null) {
                    if (!other.corners_.isEmpty()) {
                        if (this.corners_.isEmpty()) {
                            this.corners_ = other.corners_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureCornersIsMutable();
                            this.corners_.addAll(other.corners_);
                        }
                        onChanged();
                    }
                } else if (!other.corners_.isEmpty()) {
                    if (this.cornersBuilder_.isEmpty()) {
                        this.cornersBuilder_.dispose();
                        this.cornersBuilder_ = null;
                        this.corners_ = other.corners_;
                        this.bitField0_ &= -3;
                        this.cornersBuilder_ = ToTheMoonQueryPathRsp.alwaysUseFieldBuilders ? getCornersFieldBuilder() : null;
                    } else {
                        this.cornersBuilder_.addAllMessages(other.corners_);
                    }
                }
                if (!other.level_.isEmpty()) {
                    if (this.level_.isEmpty()) {
                        this.level_ = other.level_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureLevelIsMutable();
                        this.level_.addAll(other.level_);
                    }
                    onChanged();
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
                ToTheMoonQueryPathRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = ToTheMoonQueryPathRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ToTheMoonQueryPathRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public int getQueryId() {
                return this.queryId_;
            }

            public Builder setQueryId(int value) {
                this.queryId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQueryId() {
                this.queryId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public int getQueryStatusValue() {
                return this.queryStatus_;
            }

            public Builder setQueryStatusValue(int value) {
                this.queryStatus_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public PathStatusTypeOuterClass.PathStatusType getQueryStatus() {
                PathStatusTypeOuterClass.PathStatusType result = PathStatusTypeOuterClass.PathStatusType.valueOf(this.queryStatus_);
                return result == null ? PathStatusTypeOuterClass.PathStatusType.UNRECOGNIZED : result;
            }

            public Builder setQueryStatus(PathStatusTypeOuterClass.PathStatusType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.queryStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearQueryStatus() {
                this.queryStatus_ = 0;
                onChanged();
                return this;
            }

            private void ensureIndexIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.index_ = ToTheMoonQueryPathRsp.mutableCopy(this.index_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public List<Long> getIndexList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.index_) : this.index_;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public int getIndexCount() {
                return this.index_.size();
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public long getIndex(int index) {
                return this.index_.getLong(index);
            }

            public Builder setIndex(int index, long value) {
                ensureIndexIsMutable();
                this.index_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addIndex(long value) {
                ensureIndexIsMutable();
                this.index_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllIndex(Iterable<? extends Long> values) {
                ensureIndexIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.index_);
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = ToTheMoonQueryPathRsp.emptyLongList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
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

            private void ensureCornersIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.corners_ = new ArrayList(this.corners_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public List<VectorOuterClass.Vector> getCornersList() {
                if (this.cornersBuilder_ == null) {
                    return Collections.unmodifiableList(this.corners_);
                }
                return this.cornersBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public int getCornersCount() {
                if (this.cornersBuilder_ == null) {
                    return this.corners_.size();
                }
                return this.cornersBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public VectorOuterClass.Vector getCorners(int index) {
                if (this.cornersBuilder_ == null) {
                    return this.corners_.get(index);
                }
                return this.cornersBuilder_.getMessage(index);
            }

            public Builder setCorners(int index, VectorOuterClass.Vector value) {
                if (this.cornersBuilder_ != null) {
                    this.cornersBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCornersIsMutable();
                    this.corners_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCorners(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cornersBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCorners(VectorOuterClass.Vector value) {
                if (this.cornersBuilder_ != null) {
                    this.cornersBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCornersIsMutable();
                    this.corners_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCorners(int index, VectorOuterClass.Vector value) {
                if (this.cornersBuilder_ != null) {
                    this.cornersBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCornersIsMutable();
                    this.corners_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCorners(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.cornersBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCorners(int index, VectorOuterClass.Vector.Builder builderForValue) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cornersBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCorners(Iterable<? extends VectorOuterClass.Vector> values) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.corners_);
                    onChanged();
                } else {
                    this.cornersBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCorners() {
                if (this.cornersBuilder_ == null) {
                    this.corners_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.cornersBuilder_.clear();
                }
                return this;
            }

            public Builder removeCorners(int index) {
                if (this.cornersBuilder_ == null) {
                    ensureCornersIsMutable();
                    this.corners_.remove(index);
                    onChanged();
                } else {
                    this.cornersBuilder_.remove(index);
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getCornersBuilder(int index) {
                return getCornersFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public VectorOuterClass.VectorOrBuilder getCornersOrBuilder(int index) {
                if (this.cornersBuilder_ == null) {
                    return this.corners_.get(index);
                }
                return this.cornersBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public List<? extends VectorOuterClass.VectorOrBuilder> getCornersOrBuilderList() {
                if (this.cornersBuilder_ != null) {
                    return this.cornersBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.corners_);
            }

            public VectorOuterClass.Vector.Builder addCornersBuilder() {
                return getCornersFieldBuilder().addBuilder(VectorOuterClass.Vector.getDefaultInstance());
            }

            public VectorOuterClass.Vector.Builder addCornersBuilder(int index) {
                return getCornersFieldBuilder().addBuilder(index, VectorOuterClass.Vector.getDefaultInstance());
            }

            public List<VectorOuterClass.Vector.Builder> getCornersBuilderList() {
                return getCornersFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getCornersFieldBuilder() {
                if (this.cornersBuilder_ == null) {
                    this.cornersBuilder_ = new RepeatedFieldBuilderV3<>(this.corners_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.corners_ = null;
                }
                return this.cornersBuilder_;
            }

            private void ensureLevelIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.level_ = ToTheMoonQueryPathRsp.mutableCopy(this.level_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public List<Integer> getLevelList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.level_) : this.level_;
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public int getLevelCount() {
                return this.level_.size();
            }

            @Override // emu.grasscutter.net.proto.ToTheMoonQueryPathRspOuterClass.ToTheMoonQueryPathRspOrBuilder
            public int getLevel(int index) {
                return this.level_.getInt(index);
            }

            public Builder setLevel(int index, int value) {
                ensureLevelIsMutable();
                this.level_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLevel(int value) {
                ensureLevelIsMutable();
                this.level_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLevel(Iterable<? extends Integer> values) {
                ensureLevelIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.level_);
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = ToTheMoonQueryPathRsp.emptyIntList();
                this.bitField0_ &= -5;
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

        public static ToTheMoonQueryPathRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ToTheMoonQueryPathRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ToTheMoonQueryPathRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ToTheMoonQueryPathRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PathStatusTypeOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
