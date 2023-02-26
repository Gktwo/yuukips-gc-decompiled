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
import emu.grasscutter.net.proto.GravenInnocenceCarveStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCarveInfoOuterClass.class */
public final class GravenInnocenceCarveInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eGravenInnocenceCarveInfo.proto\u001a#GravenInnocenceCarveStageInfo.proto\"\u0001\n\u0018GravenInnocenceCarveInfo\u0012\u001b\n\u0013hasEditConfigIdList\u0018\f \u0003(\r\u0012\u0014\n\fcanEditCount\u0018\u000f \u0001(\r\u00125\n\rstageInfoList\u0018\u0004 \u0003(\u000b2\u001e.GravenInnocenceCarveStageInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GravenInnocenceCarveStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GravenInnocenceCarveInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GravenInnocenceCarveInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GravenInnocenceCarveInfo_descriptor, new String[]{"HasEditConfigIdList", "CanEditCount", "StageInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCarveInfoOuterClass$GravenInnocenceCarveInfoOrBuilder.class */
    public interface GravenInnocenceCarveInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getHasEditConfigIdListList();

        int getHasEditConfigIdListCount();

        int getHasEditConfigIdList(int i);

        int getCanEditCount();

        List<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo> getStageInfoListList();

        GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo getStageInfoList(int i);

        int getStageInfoListCount();

        List<? extends GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder> getStageInfoListOrBuilderList();

        GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder getStageInfoListOrBuilder(int i);
    }

    private GravenInnocenceCarveInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCarveInfoOuterClass$GravenInnocenceCarveInfo.class */
    public static final class GravenInnocenceCarveInfo extends GeneratedMessageV3 implements GravenInnocenceCarveInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HASEDITCONFIGIDLIST_FIELD_NUMBER = 12;
        private Internal.IntList hasEditConfigIdList_;
        private int hasEditConfigIdListMemoizedSerializedSize;
        public static final int CANEDITCOUNT_FIELD_NUMBER = 15;
        private int canEditCount_;
        public static final int STAGEINFOLIST_FIELD_NUMBER = 4;
        private List<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo> stageInfoList_;
        private byte memoizedIsInitialized;
        private static final GravenInnocenceCarveInfo DEFAULT_INSTANCE = new GravenInnocenceCarveInfo();
        private static final Parser<GravenInnocenceCarveInfo> PARSER = new AbstractParser<GravenInnocenceCarveInfo>() { // from class: emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.1
            @Override // com.google.protobuf.Parser
            public GravenInnocenceCarveInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GravenInnocenceCarveInfo(input, extensionRegistry);
            }
        };

        private GravenInnocenceCarveInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.hasEditConfigIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GravenInnocenceCarveInfo() {
            this.hasEditConfigIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.hasEditConfigIdList_ = emptyIntList();
            this.stageInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GravenInnocenceCarveInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:70:0x010d */
        private GravenInnocenceCarveInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.stageInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.stageInfoList_.add((GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo) input.readMessage(GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.parser(), extensionRegistry));
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.hasEditConfigIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.hasEditConfigIdList_.addInt(input.readUInt32());
                                break;
                            case 98:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.hasEditConfigIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.hasEditConfigIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 120:
                                this.canEditCount_ = input.readUInt32();
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
                    this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.hasEditConfigIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GravenInnocenceCarveInfoOuterClass.internal_static_GravenInnocenceCarveInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GravenInnocenceCarveInfoOuterClass.internal_static_GravenInnocenceCarveInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceCarveInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public List<Integer> getHasEditConfigIdListList() {
            return this.hasEditConfigIdList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public int getHasEditConfigIdListCount() {
            return this.hasEditConfigIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public int getHasEditConfigIdList(int index) {
            return this.hasEditConfigIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public int getCanEditCount() {
            return this.canEditCount_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public List<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo> getStageInfoListList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public List<? extends GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder> getStageInfoListOrBuilderList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public int getStageInfoListCount() {
            return this.stageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo getStageInfoList(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
        public GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
            return this.stageInfoList_.get(index);
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                output.writeMessage(4, this.stageInfoList_.get(i));
            }
            if (getHasEditConfigIdListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.hasEditConfigIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.hasEditConfigIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.hasEditConfigIdList_.getInt(i2));
            }
            if (this.canEditCount_ != 0) {
                output.writeUInt32(15, this.canEditCount_);
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.stageInfoList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.hasEditConfigIdList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.hasEditConfigIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getHasEditConfigIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.hasEditConfigIdListMemoizedSerializedSize = dataSize;
            if (this.canEditCount_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.canEditCount_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GravenInnocenceCarveInfo)) {
                return equals(obj);
            }
            GravenInnocenceCarveInfo other = (GravenInnocenceCarveInfo) obj;
            return getHasEditConfigIdListList().equals(other.getHasEditConfigIdListList()) && getCanEditCount() == other.getCanEditCount() && getStageInfoListList().equals(other.getStageInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getHasEditConfigIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getHasEditConfigIdListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 15)) + getCanEditCount();
            if (getStageInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 4)) + getStageInfoListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GravenInnocenceCarveInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceCarveInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceCarveInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceCarveInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceCarveInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceCarveInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceCarveInfo parseFrom(InputStream input) throws IOException {
            return (GravenInnocenceCarveInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceCarveInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceCarveInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceCarveInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GravenInnocenceCarveInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GravenInnocenceCarveInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceCarveInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceCarveInfo parseFrom(CodedInputStream input) throws IOException {
            return (GravenInnocenceCarveInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceCarveInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceCarveInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GravenInnocenceCarveInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCarveInfoOuterClass$GravenInnocenceCarveInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GravenInnocenceCarveInfoOrBuilder {
            private int bitField0_;
            private int canEditCount_;
            private RepeatedFieldBuilderV3<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder> stageInfoListBuilder_;
            private Internal.IntList hasEditConfigIdList_ = GravenInnocenceCarveInfo.emptyIntList();
            private List<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo> stageInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GravenInnocenceCarveInfoOuterClass.internal_static_GravenInnocenceCarveInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GravenInnocenceCarveInfoOuterClass.internal_static_GravenInnocenceCarveInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceCarveInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GravenInnocenceCarveInfo.alwaysUseFieldBuilders) {
                    getStageInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.hasEditConfigIdList_ = GravenInnocenceCarveInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.canEditCount_ = 0;
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GravenInnocenceCarveInfoOuterClass.internal_static_GravenInnocenceCarveInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GravenInnocenceCarveInfo getDefaultInstanceForType() {
                return GravenInnocenceCarveInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceCarveInfo build() {
                GravenInnocenceCarveInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceCarveInfo buildPartial() {
                GravenInnocenceCarveInfo result = new GravenInnocenceCarveInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.hasEditConfigIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.hasEditConfigIdList_ = this.hasEditConfigIdList_;
                result.canEditCount_ = this.canEditCount_;
                if (this.stageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.stageInfoList_ = this.stageInfoList_;
                } else {
                    result.stageInfoList_ = this.stageInfoListBuilder_.build();
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
                if (other instanceof GravenInnocenceCarveInfo) {
                    return mergeFrom((GravenInnocenceCarveInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GravenInnocenceCarveInfo other) {
                if (other == GravenInnocenceCarveInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.hasEditConfigIdList_.isEmpty()) {
                    if (this.hasEditConfigIdList_.isEmpty()) {
                        this.hasEditConfigIdList_ = other.hasEditConfigIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureHasEditConfigIdListIsMutable();
                        this.hasEditConfigIdList_.addAll(other.hasEditConfigIdList_);
                    }
                    onChanged();
                }
                if (other.getCanEditCount() != 0) {
                    setCanEditCount(other.getCanEditCount());
                }
                if (this.stageInfoListBuilder_ == null) {
                    if (!other.stageInfoList_.isEmpty()) {
                        if (this.stageInfoList_.isEmpty()) {
                            this.stageInfoList_ = other.stageInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureStageInfoListIsMutable();
                            this.stageInfoList_.addAll(other.stageInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageInfoList_.isEmpty()) {
                    if (this.stageInfoListBuilder_.isEmpty()) {
                        this.stageInfoListBuilder_.dispose();
                        this.stageInfoListBuilder_ = null;
                        this.stageInfoList_ = other.stageInfoList_;
                        this.bitField0_ &= -3;
                        this.stageInfoListBuilder_ = GravenInnocenceCarveInfo.alwaysUseFieldBuilders ? getStageInfoListFieldBuilder() : null;
                    } else {
                        this.stageInfoListBuilder_.addAllMessages(other.stageInfoList_);
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
                GravenInnocenceCarveInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GravenInnocenceCarveInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GravenInnocenceCarveInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureHasEditConfigIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.hasEditConfigIdList_ = GravenInnocenceCarveInfo.mutableCopy(this.hasEditConfigIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public List<Integer> getHasEditConfigIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.hasEditConfigIdList_) : this.hasEditConfigIdList_;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public int getHasEditConfigIdListCount() {
                return this.hasEditConfigIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public int getHasEditConfigIdList(int index) {
                return this.hasEditConfigIdList_.getInt(index);
            }

            public Builder setHasEditConfigIdList(int index, int value) {
                ensureHasEditConfigIdListIsMutable();
                this.hasEditConfigIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addHasEditConfigIdList(int value) {
                ensureHasEditConfigIdListIsMutable();
                this.hasEditConfigIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllHasEditConfigIdList(Iterable<? extends Integer> values) {
                ensureHasEditConfigIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.hasEditConfigIdList_);
                onChanged();
                return this;
            }

            public Builder clearHasEditConfigIdList() {
                this.hasEditConfigIdList_ = GravenInnocenceCarveInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public int getCanEditCount() {
                return this.canEditCount_;
            }

            public Builder setCanEditCount(int value) {
                this.canEditCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCanEditCount() {
                this.canEditCount_ = 0;
                onChanged();
                return this;
            }

            private void ensureStageInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.stageInfoList_ = new ArrayList(this.stageInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public List<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo> getStageInfoListList() {
                if (this.stageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageInfoList_);
                }
                return this.stageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public int getStageInfoListCount() {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.size();
                }
                return this.stageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo getStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessage(index);
            }

            public Builder setStageInfoList(int index, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageInfoList(int index, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(int index, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(int index, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageInfoList(Iterable<? extends GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo> values) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageInfoList_);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageInfoList() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.remove(index);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.remove(index);
                }
                return this;
            }

            public GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder getStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder
            public List<? extends GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder> getStageInfoListOrBuilderList() {
                if (this.stageInfoListBuilder_ != null) {
                    return this.stageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageInfoList_);
            }

            public GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder addStageInfoListBuilder() {
                return getStageInfoListFieldBuilder().addBuilder(GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.getDefaultInstance());
            }

            public GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder addStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().addBuilder(index, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.getDefaultInstance());
            }

            public List<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder> getStageInfoListBuilderList() {
                return getStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfo.Builder, GravenInnocenceCarveStageInfoOuterClass.GravenInnocenceCarveStageInfoOrBuilder> getStageInfoListFieldBuilder() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.stageInfoList_ = null;
                }
                return this.stageInfoListBuilder_;
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

        public static GravenInnocenceCarveInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GravenInnocenceCarveInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GravenInnocenceCarveInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GravenInnocenceCarveInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GravenInnocenceCarveStageInfoOuterClass.getDescriptor();
    }
}
