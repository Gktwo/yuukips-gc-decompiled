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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.DungeonEntryInfoOuterClass;
import emu.grasscutter.net.proto.DungeonEntryPointInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoRspOuterClass.class */
public final class DungeonEntryInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019DungeonEntryInfoRsp.proto\u001a\u0016DungeonEntryInfo.proto\u001a\u001bDungeonEntryPointInfo.proto\"¿\u0001\n\u0013DungeonEntryInfoRsp\u0012-\n\u0012dungeon_entry_list\u0018\b \u0003(\u000b2\u0011.DungeonEntryInfo\u0012\u001c\n\u0014recommend_dungeon_id\u0018\u000f \u0001(\r\u00128\n\u0018dungeon_entry_point_list\u0018\n \u0003(\u000b2\u0016.DungeonEntryPointInfo\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012\u0010\n\bpoint_id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DungeonEntryInfoOuterClass.getDescriptor(), DungeonEntryPointInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DungeonEntryInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonEntryInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonEntryInfoRsp_descriptor, new String[]{"DungeonEntryList", "RecommendDungeonId", "DungeonEntryPointList", "Retcode", "PointId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoRspOuterClass$DungeonEntryInfoRspOrBuilder.class */
    public interface DungeonEntryInfoRspOrBuilder extends MessageOrBuilder {
        List<DungeonEntryInfoOuterClass.DungeonEntryInfo> getDungeonEntryListList();

        DungeonEntryInfoOuterClass.DungeonEntryInfo getDungeonEntryList(int i);

        int getDungeonEntryListCount();

        List<? extends DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListOrBuilderList();

        DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getDungeonEntryListOrBuilder(int i);

        int getRecommendDungeonId();

        List<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo> getDungeonEntryPointListList();

        DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo getDungeonEntryPointList(int i);

        int getDungeonEntryPointListCount();

        List<? extends DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder> getDungeonEntryPointListOrBuilderList();

        DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder getDungeonEntryPointListOrBuilder(int i);

        int getRetcode();

        int getPointId();
    }

    private DungeonEntryInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoRspOuterClass$DungeonEntryInfoRsp.class */
    public static final class DungeonEntryInfoRsp extends GeneratedMessageV3 implements DungeonEntryInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DUNGEON_ENTRY_LIST_FIELD_NUMBER = 8;
        private List<DungeonEntryInfoOuterClass.DungeonEntryInfo> dungeonEntryList_;
        public static final int RECOMMEND_DUNGEON_ID_FIELD_NUMBER = 15;
        private int recommendDungeonId_;
        public static final int DUNGEON_ENTRY_POINT_LIST_FIELD_NUMBER = 10;
        private List<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo> dungeonEntryPointList_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int POINT_ID_FIELD_NUMBER = 12;
        private int pointId_;
        private byte memoizedIsInitialized;
        private static final DungeonEntryInfoRsp DEFAULT_INSTANCE = new DungeonEntryInfoRsp();
        private static final Parser<DungeonEntryInfoRsp> PARSER = new AbstractParser<DungeonEntryInfoRsp>() { // from class: emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRsp.1
            @Override // com.google.protobuf.Parser
            public DungeonEntryInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonEntryInfoRsp(input, extensionRegistry);
            }
        };

        private DungeonEntryInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DungeonEntryInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.dungeonEntryList_ = Collections.emptyList();
            this.dungeonEntryPointList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonEntryInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x00f1 */
        private DungeonEntryInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 66:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.dungeonEntryList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.dungeonEntryList_.add((DungeonEntryInfoOuterClass.DungeonEntryInfo) input.readMessage(DungeonEntryInfoOuterClass.DungeonEntryInfo.parser(), extensionRegistry));
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.dungeonEntryPointList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.dungeonEntryPointList_.add((DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo) input.readMessage(DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                this.pointId_ = input.readUInt32();
                                break;
                            case 112:
                                this.retcode_ = input.readInt32();
                                break;
                            case 120:
                                this.recommendDungeonId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.dungeonEntryList_ = Collections.unmodifiableList(this.dungeonEntryList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.dungeonEntryPointList_ = Collections.unmodifiableList(this.dungeonEntryPointList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonEntryInfoRspOuterClass.internal_static_DungeonEntryInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonEntryInfoRspOuterClass.internal_static_DungeonEntryInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public List<DungeonEntryInfoOuterClass.DungeonEntryInfo> getDungeonEntryListList() {
            return this.dungeonEntryList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public List<? extends DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListOrBuilderList() {
            return this.dungeonEntryList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public int getDungeonEntryListCount() {
            return this.dungeonEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public DungeonEntryInfoOuterClass.DungeonEntryInfo getDungeonEntryList(int index) {
            return this.dungeonEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getDungeonEntryListOrBuilder(int index) {
            return this.dungeonEntryList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public int getRecommendDungeonId() {
            return this.recommendDungeonId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public List<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo> getDungeonEntryPointListList() {
            return this.dungeonEntryPointList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public List<? extends DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder> getDungeonEntryPointListOrBuilderList() {
            return this.dungeonEntryPointList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public int getDungeonEntryPointListCount() {
            return this.dungeonEntryPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo getDungeonEntryPointList(int index) {
            return this.dungeonEntryPointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder getDungeonEntryPointListOrBuilder(int index) {
            return this.dungeonEntryPointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
        public int getPointId() {
            return this.pointId_;
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
            for (int i = 0; i < this.dungeonEntryList_.size(); i++) {
                output.writeMessage(8, this.dungeonEntryList_.get(i));
            }
            for (int i2 = 0; i2 < this.dungeonEntryPointList_.size(); i2++) {
                output.writeMessage(10, this.dungeonEntryPointList_.get(i2));
            }
            if (this.pointId_ != 0) {
                output.writeUInt32(12, this.pointId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
            }
            if (this.recommendDungeonId_ != 0) {
                output.writeUInt32(15, this.recommendDungeonId_);
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
            for (int i = 0; i < this.dungeonEntryList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.dungeonEntryList_.get(i));
            }
            for (int i2 = 0; i2 < this.dungeonEntryPointList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.dungeonEntryPointList_.get(i2));
            }
            if (this.pointId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.pointId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
            }
            if (this.recommendDungeonId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.recommendDungeonId_);
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
            if (!(obj instanceof DungeonEntryInfoRsp)) {
                return equals(obj);
            }
            DungeonEntryInfoRsp other = (DungeonEntryInfoRsp) obj;
            return getDungeonEntryListList().equals(other.getDungeonEntryListList()) && getRecommendDungeonId() == other.getRecommendDungeonId() && getDungeonEntryPointListList().equals(other.getDungeonEntryPointListList()) && getRetcode() == other.getRetcode() && getPointId() == other.getPointId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDungeonEntryListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getDungeonEntryListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 15)) + getRecommendDungeonId();
            if (getDungeonEntryPointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 10)) + getDungeonEntryPointListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * ((53 * ((37 * hash2) + 14)) + getRetcode())) + 12)) + getPointId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static DungeonEntryInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfoRsp parseFrom(InputStream input) throws IOException {
            return (DungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonEntryInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonEntryInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (DungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonEntryInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoRspOuterClass$DungeonEntryInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonEntryInfoRspOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<DungeonEntryInfoOuterClass.DungeonEntryInfo, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder, DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> dungeonEntryListBuilder_;
            private int recommendDungeonId_;
            private RepeatedFieldBuilderV3<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder> dungeonEntryPointListBuilder_;
            private int retcode_;
            private int pointId_;
            private List<DungeonEntryInfoOuterClass.DungeonEntryInfo> dungeonEntryList_ = Collections.emptyList();
            private List<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo> dungeonEntryPointList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonEntryInfoRspOuterClass.internal_static_DungeonEntryInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonEntryInfoRspOuterClass.internal_static_DungeonEntryInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonEntryInfoRsp.alwaysUseFieldBuilders) {
                    getDungeonEntryListFieldBuilder();
                    getDungeonEntryPointListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.dungeonEntryListBuilder_ == null) {
                    this.dungeonEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dungeonEntryListBuilder_.clear();
                }
                this.recommendDungeonId_ = 0;
                if (this.dungeonEntryPointListBuilder_ == null) {
                    this.dungeonEntryPointList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.dungeonEntryPointListBuilder_.clear();
                }
                this.retcode_ = 0;
                this.pointId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonEntryInfoRspOuterClass.internal_static_DungeonEntryInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonEntryInfoRsp getDefaultInstanceForType() {
                return DungeonEntryInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryInfoRsp build() {
                DungeonEntryInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryInfoRsp buildPartial() {
                DungeonEntryInfoRsp result = new DungeonEntryInfoRsp(this);
                int i = this.bitField0_;
                if (this.dungeonEntryListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dungeonEntryList_ = Collections.unmodifiableList(this.dungeonEntryList_);
                        this.bitField0_ &= -2;
                    }
                    result.dungeonEntryList_ = this.dungeonEntryList_;
                } else {
                    result.dungeonEntryList_ = this.dungeonEntryListBuilder_.build();
                }
                result.recommendDungeonId_ = this.recommendDungeonId_;
                if (this.dungeonEntryPointListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.dungeonEntryPointList_ = Collections.unmodifiableList(this.dungeonEntryPointList_);
                        this.bitField0_ &= -3;
                    }
                    result.dungeonEntryPointList_ = this.dungeonEntryPointList_;
                } else {
                    result.dungeonEntryPointList_ = this.dungeonEntryPointListBuilder_.build();
                }
                result.retcode_ = this.retcode_;
                result.pointId_ = this.pointId_;
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
                if (other instanceof DungeonEntryInfoRsp) {
                    return mergeFrom((DungeonEntryInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonEntryInfoRsp other) {
                if (other == DungeonEntryInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.dungeonEntryListBuilder_ == null) {
                    if (!other.dungeonEntryList_.isEmpty()) {
                        if (this.dungeonEntryList_.isEmpty()) {
                            this.dungeonEntryList_ = other.dungeonEntryList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDungeonEntryListIsMutable();
                            this.dungeonEntryList_.addAll(other.dungeonEntryList_);
                        }
                        onChanged();
                    }
                } else if (!other.dungeonEntryList_.isEmpty()) {
                    if (this.dungeonEntryListBuilder_.isEmpty()) {
                        this.dungeonEntryListBuilder_.dispose();
                        this.dungeonEntryListBuilder_ = null;
                        this.dungeonEntryList_ = other.dungeonEntryList_;
                        this.bitField0_ &= -2;
                        this.dungeonEntryListBuilder_ = DungeonEntryInfoRsp.alwaysUseFieldBuilders ? getDungeonEntryListFieldBuilder() : null;
                    } else {
                        this.dungeonEntryListBuilder_.addAllMessages(other.dungeonEntryList_);
                    }
                }
                if (other.getRecommendDungeonId() != 0) {
                    setRecommendDungeonId(other.getRecommendDungeonId());
                }
                if (this.dungeonEntryPointListBuilder_ == null) {
                    if (!other.dungeonEntryPointList_.isEmpty()) {
                        if (this.dungeonEntryPointList_.isEmpty()) {
                            this.dungeonEntryPointList_ = other.dungeonEntryPointList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureDungeonEntryPointListIsMutable();
                            this.dungeonEntryPointList_.addAll(other.dungeonEntryPointList_);
                        }
                        onChanged();
                    }
                } else if (!other.dungeonEntryPointList_.isEmpty()) {
                    if (this.dungeonEntryPointListBuilder_.isEmpty()) {
                        this.dungeonEntryPointListBuilder_.dispose();
                        this.dungeonEntryPointListBuilder_ = null;
                        this.dungeonEntryPointList_ = other.dungeonEntryPointList_;
                        this.bitField0_ &= -3;
                        this.dungeonEntryPointListBuilder_ = DungeonEntryInfoRsp.alwaysUseFieldBuilders ? getDungeonEntryPointListFieldBuilder() : null;
                    } else {
                        this.dungeonEntryPointListBuilder_.addAllMessages(other.dungeonEntryPointList_);
                    }
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getPointId() != 0) {
                    setPointId(other.getPointId());
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
                DungeonEntryInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonEntryInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonEntryInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDungeonEntryListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dungeonEntryList_ = new ArrayList(this.dungeonEntryList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public List<DungeonEntryInfoOuterClass.DungeonEntryInfo> getDungeonEntryListList() {
                if (this.dungeonEntryListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dungeonEntryList_);
                }
                return this.dungeonEntryListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public int getDungeonEntryListCount() {
                if (this.dungeonEntryListBuilder_ == null) {
                    return this.dungeonEntryList_.size();
                }
                return this.dungeonEntryListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public DungeonEntryInfoOuterClass.DungeonEntryInfo getDungeonEntryList(int index) {
                if (this.dungeonEntryListBuilder_ == null) {
                    return this.dungeonEntryList_.get(index);
                }
                return this.dungeonEntryListBuilder_.getMessage(index);
            }

            public Builder setDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.dungeonEntryListBuilder_ != null) {
                    this.dungeonEntryListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder builderForValue) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonEntryList(DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.dungeonEntryListBuilder_ != null) {
                    this.dungeonEntryListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.dungeonEntryListBuilder_ != null) {
                    this.dungeonEntryListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonEntryList(DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder builderForValue) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonEntryList(int index, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder builderForValue) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDungeonEntryList(Iterable<? extends DungeonEntryInfoOuterClass.DungeonEntryInfo> values) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dungeonEntryList_);
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDungeonEntryList() {
                if (this.dungeonEntryListBuilder_ == null) {
                    this.dungeonEntryList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDungeonEntryList(int index) {
                if (this.dungeonEntryListBuilder_ == null) {
                    ensureDungeonEntryListIsMutable();
                    this.dungeonEntryList_.remove(index);
                    onChanged();
                } else {
                    this.dungeonEntryListBuilder_.remove(index);
                }
                return this;
            }

            public DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder getDungeonEntryListBuilder(int index) {
                return getDungeonEntryListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getDungeonEntryListOrBuilder(int index) {
                if (this.dungeonEntryListBuilder_ == null) {
                    return this.dungeonEntryList_.get(index);
                }
                return this.dungeonEntryListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public List<? extends DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListOrBuilderList() {
                if (this.dungeonEntryListBuilder_ != null) {
                    return this.dungeonEntryListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dungeonEntryList_);
            }

            public DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder addDungeonEntryListBuilder() {
                return getDungeonEntryListFieldBuilder().addBuilder(DungeonEntryInfoOuterClass.DungeonEntryInfo.getDefaultInstance());
            }

            public DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder addDungeonEntryListBuilder(int index) {
                return getDungeonEntryListFieldBuilder().addBuilder(index, DungeonEntryInfoOuterClass.DungeonEntryInfo.getDefaultInstance());
            }

            public List<DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder> getDungeonEntryListBuilderList() {
                return getDungeonEntryListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DungeonEntryInfoOuterClass.DungeonEntryInfo, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder, DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getDungeonEntryListFieldBuilder() {
                if (this.dungeonEntryListBuilder_ == null) {
                    this.dungeonEntryListBuilder_ = new RepeatedFieldBuilderV3<>(this.dungeonEntryList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dungeonEntryList_ = null;
                }
                return this.dungeonEntryListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public int getRecommendDungeonId() {
                return this.recommendDungeonId_;
            }

            public Builder setRecommendDungeonId(int value) {
                this.recommendDungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecommendDungeonId() {
                this.recommendDungeonId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDungeonEntryPointListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.dungeonEntryPointList_ = new ArrayList(this.dungeonEntryPointList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public List<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo> getDungeonEntryPointListList() {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dungeonEntryPointList_);
                }
                return this.dungeonEntryPointListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public int getDungeonEntryPointListCount() {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    return this.dungeonEntryPointList_.size();
                }
                return this.dungeonEntryPointListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo getDungeonEntryPointList(int index) {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    return this.dungeonEntryPointList_.get(index);
                }
                return this.dungeonEntryPointListBuilder_.getMessage(index);
            }

            public Builder setDungeonEntryPointList(int index, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo value) {
                if (this.dungeonEntryPointListBuilder_ != null) {
                    this.dungeonEntryPointListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryPointListIsMutable();
                    this.dungeonEntryPointList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDungeonEntryPointList(int index, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder builderForValue) {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    ensureDungeonEntryPointListIsMutable();
                    this.dungeonEntryPointList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryPointListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonEntryPointList(DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo value) {
                if (this.dungeonEntryPointListBuilder_ != null) {
                    this.dungeonEntryPointListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryPointListIsMutable();
                    this.dungeonEntryPointList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonEntryPointList(int index, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo value) {
                if (this.dungeonEntryPointListBuilder_ != null) {
                    this.dungeonEntryPointListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonEntryPointListIsMutable();
                    this.dungeonEntryPointList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonEntryPointList(DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder builderForValue) {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    ensureDungeonEntryPointListIsMutable();
                    this.dungeonEntryPointList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryPointListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonEntryPointList(int index, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder builderForValue) {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    ensureDungeonEntryPointListIsMutable();
                    this.dungeonEntryPointList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonEntryPointListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDungeonEntryPointList(Iterable<? extends DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo> values) {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    ensureDungeonEntryPointListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dungeonEntryPointList_);
                    onChanged();
                } else {
                    this.dungeonEntryPointListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDungeonEntryPointList() {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    this.dungeonEntryPointList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.dungeonEntryPointListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDungeonEntryPointList(int index) {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    ensureDungeonEntryPointListIsMutable();
                    this.dungeonEntryPointList_.remove(index);
                    onChanged();
                } else {
                    this.dungeonEntryPointListBuilder_.remove(index);
                }
                return this;
            }

            public DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder getDungeonEntryPointListBuilder(int index) {
                return getDungeonEntryPointListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder getDungeonEntryPointListOrBuilder(int index) {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    return this.dungeonEntryPointList_.get(index);
                }
                return this.dungeonEntryPointListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public List<? extends DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder> getDungeonEntryPointListOrBuilderList() {
                if (this.dungeonEntryPointListBuilder_ != null) {
                    return this.dungeonEntryPointListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dungeonEntryPointList_);
            }

            public DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder addDungeonEntryPointListBuilder() {
                return getDungeonEntryPointListFieldBuilder().addBuilder(DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.getDefaultInstance());
            }

            public DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder addDungeonEntryPointListBuilder(int index) {
                return getDungeonEntryPointListFieldBuilder().addBuilder(index, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.getDefaultInstance());
            }

            public List<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder> getDungeonEntryPointListBuilderList() {
                return getDungeonEntryPointListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfo.Builder, DungeonEntryPointInfoOuterClass.DungeonEntryPointInfoOrBuilder> getDungeonEntryPointListFieldBuilder() {
                if (this.dungeonEntryPointListBuilder_ == null) {
                    this.dungeonEntryPointListBuilder_ = new RepeatedFieldBuilderV3<>(this.dungeonEntryPointList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.dungeonEntryPointList_ = null;
                }
                return this.dungeonEntryPointListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoRspOuterClass.DungeonEntryInfoRspOrBuilder
            public int getPointId() {
                return this.pointId_;
            }

            public Builder setPointId(int value) {
                this.pointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointId() {
                this.pointId_ = 0;
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

        public static DungeonEntryInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonEntryInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonEntryInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonEntryInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DungeonEntryInfoOuterClass.getDescriptor();
        DungeonEntryPointInfoOuterClass.getDescriptor();
    }
}
