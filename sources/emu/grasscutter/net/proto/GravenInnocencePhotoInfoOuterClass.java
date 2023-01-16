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
import emu.grasscutter.net.proto.GravenInnocencePhotoObjectInfoOuterClass;
import emu.grasscutter.net.proto.GravenInnocencePhotoStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoInfoOuterClass.class */
public final class GravenInnocencePhotoInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eGravenInnocencePhotoInfo.proto\u001a$GravenInnocencePhotoObjectInfo.proto\u001a#GravenInnocencePhotoStageInfo.proto\"\u0001\n\u0018GravenInnocencePhotoInfo\u00127\n\u000fstage_info_list\u0018\u0003 \u0003(\u000b2\u001e.GravenInnocencePhotoStageInfo\u00129\n\u0010object_info_list\u0018\u000f \u0003(\u000b2\u001f.GravenInnocencePhotoObjectInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GravenInnocencePhotoObjectInfoOuterClass.getDescriptor(), GravenInnocencePhotoStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GravenInnocencePhotoInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GravenInnocencePhotoInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GravenInnocencePhotoInfo_descriptor, new String[]{"StageInfoList", "ObjectInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoInfoOuterClass$GravenInnocencePhotoInfoOrBuilder.class */
    public interface GravenInnocencePhotoInfoOrBuilder extends MessageOrBuilder {
        List<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo> getStageInfoListList();

        GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo getStageInfoList(int i);

        int getStageInfoListCount();

        List<? extends GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder> getStageInfoListOrBuilderList();

        GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder getStageInfoListOrBuilder(int i);

        List<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo> getObjectInfoListList();

        GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo getObjectInfoList(int i);

        int getObjectInfoListCount();

        List<? extends GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder> getObjectInfoListOrBuilderList();

        GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder getObjectInfoListOrBuilder(int i);
    }

    private GravenInnocencePhotoInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoInfoOuterClass$GravenInnocencePhotoInfo.class */
    public static final class GravenInnocencePhotoInfo extends GeneratedMessageV3 implements GravenInnocencePhotoInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_INFO_LIST_FIELD_NUMBER = 3;
        private List<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo> stageInfoList_;
        public static final int OBJECT_INFO_LIST_FIELD_NUMBER = 15;
        private List<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo> objectInfoList_;
        private byte memoizedIsInitialized;
        private static final GravenInnocencePhotoInfo DEFAULT_INSTANCE = new GravenInnocencePhotoInfo();
        private static final Parser<GravenInnocencePhotoInfo> PARSER = new AbstractParser<GravenInnocencePhotoInfo>() { // from class: emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.1
            @Override // com.google.protobuf.Parser
            public GravenInnocencePhotoInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GravenInnocencePhotoInfo(input, extensionRegistry);
            }
        };

        private GravenInnocencePhotoInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GravenInnocencePhotoInfo() {
            this.memoizedIsInitialized = -1;
            this.stageInfoList_ = Collections.emptyList();
            this.objectInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GravenInnocencePhotoInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00b8 */
        private GravenInnocencePhotoInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.stageInfoList_.add((GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo) input.readMessage(GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.parser(), extensionRegistry));
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.objectInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.objectInfoList_.add((GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo) input.readMessage(GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.parser(), extensionRegistry));
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
                    this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.objectInfoList_ = Collections.unmodifiableList(this.objectInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GravenInnocencePhotoInfoOuterClass.internal_static_GravenInnocencePhotoInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GravenInnocencePhotoInfoOuterClass.internal_static_GravenInnocencePhotoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocencePhotoInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public List<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo> getStageInfoListList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public List<? extends GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder> getStageInfoListOrBuilderList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public int getStageInfoListCount() {
            return this.stageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo getStageInfoList(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public List<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo> getObjectInfoListList() {
            return this.objectInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public List<? extends GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder> getObjectInfoListOrBuilderList() {
            return this.objectInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public int getObjectInfoListCount() {
            return this.objectInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo getObjectInfoList(int index) {
            return this.objectInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
        public GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder getObjectInfoListOrBuilder(int index) {
            return this.objectInfoList_.get(index);
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                output.writeMessage(3, this.stageInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.objectInfoList_.size(); i2++) {
                output.writeMessage(15, this.objectInfoList_.get(i2));
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
                size2 += CodedOutputStream.computeMessageSize(3, this.stageInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.objectInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.objectInfoList_.get(i2));
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
            if (!(obj instanceof GravenInnocencePhotoInfo)) {
                return equals(obj);
            }
            GravenInnocencePhotoInfo other = (GravenInnocencePhotoInfo) obj;
            return getStageInfoListList().equals(other.getStageInfoListList()) && getObjectInfoListList().equals(other.getObjectInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getStageInfoListList().hashCode();
            }
            if (getObjectInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getObjectInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GravenInnocencePhotoInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocencePhotoInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocencePhotoInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocencePhotoInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocencePhotoInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocencePhotoInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocencePhotoInfo parseFrom(InputStream input) throws IOException {
            return (GravenInnocencePhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocencePhotoInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocencePhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocencePhotoInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GravenInnocencePhotoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GravenInnocencePhotoInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocencePhotoInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocencePhotoInfo parseFrom(CodedInputStream input) throws IOException {
            return (GravenInnocencePhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocencePhotoInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocencePhotoInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GravenInnocencePhotoInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocencePhotoInfoOuterClass$GravenInnocencePhotoInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GravenInnocencePhotoInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder> stageInfoListBuilder_;
            private RepeatedFieldBuilderV3<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder> objectInfoListBuilder_;
            private List<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo> stageInfoList_ = Collections.emptyList();
            private List<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo> objectInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GravenInnocencePhotoInfoOuterClass.internal_static_GravenInnocencePhotoInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GravenInnocencePhotoInfoOuterClass.internal_static_GravenInnocencePhotoInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocencePhotoInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GravenInnocencePhotoInfo.alwaysUseFieldBuilders) {
                    getStageInfoListFieldBuilder();
                    getObjectInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                if (this.objectInfoListBuilder_ == null) {
                    this.objectInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.objectInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GravenInnocencePhotoInfoOuterClass.internal_static_GravenInnocencePhotoInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GravenInnocencePhotoInfo getDefaultInstanceForType() {
                return GravenInnocencePhotoInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocencePhotoInfo build() {
                GravenInnocencePhotoInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocencePhotoInfo buildPartial() {
                GravenInnocencePhotoInfo result = new GravenInnocencePhotoInfo(this);
                int i = this.bitField0_;
                if (this.stageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageInfoList_ = this.stageInfoList_;
                } else {
                    result.stageInfoList_ = this.stageInfoListBuilder_.build();
                }
                if (this.objectInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.objectInfoList_ = Collections.unmodifiableList(this.objectInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.objectInfoList_ = this.objectInfoList_;
                } else {
                    result.objectInfoList_ = this.objectInfoListBuilder_.build();
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
                if (other instanceof GravenInnocencePhotoInfo) {
                    return mergeFrom((GravenInnocencePhotoInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GravenInnocencePhotoInfo other) {
                if (other == GravenInnocencePhotoInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.stageInfoListBuilder_ == null) {
                    if (!other.stageInfoList_.isEmpty()) {
                        if (this.stageInfoList_.isEmpty()) {
                            this.stageInfoList_ = other.stageInfoList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.stageInfoListBuilder_ = GravenInnocencePhotoInfo.alwaysUseFieldBuilders ? getStageInfoListFieldBuilder() : null;
                    } else {
                        this.stageInfoListBuilder_.addAllMessages(other.stageInfoList_);
                    }
                }
                if (this.objectInfoListBuilder_ == null) {
                    if (!other.objectInfoList_.isEmpty()) {
                        if (this.objectInfoList_.isEmpty()) {
                            this.objectInfoList_ = other.objectInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureObjectInfoListIsMutable();
                            this.objectInfoList_.addAll(other.objectInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.objectInfoList_.isEmpty()) {
                    if (this.objectInfoListBuilder_.isEmpty()) {
                        this.objectInfoListBuilder_.dispose();
                        this.objectInfoListBuilder_ = null;
                        this.objectInfoList_ = other.objectInfoList_;
                        this.bitField0_ &= -3;
                        this.objectInfoListBuilder_ = GravenInnocencePhotoInfo.alwaysUseFieldBuilders ? getObjectInfoListFieldBuilder() : null;
                    } else {
                        this.objectInfoListBuilder_.addAllMessages(other.objectInfoList_);
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
                GravenInnocencePhotoInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GravenInnocencePhotoInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GravenInnocencePhotoInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureStageInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageInfoList_ = new ArrayList(this.stageInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public List<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo> getStageInfoListList() {
                if (this.stageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageInfoList_);
                }
                return this.stageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public int getStageInfoListCount() {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.size();
                }
                return this.stageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo getStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessage(index);
            }

            public Builder setStageInfoList(int index, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo value) {
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

            public Builder setStageInfoList(int index, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo value) {
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

            public Builder addStageInfoList(int index, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo value) {
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

            public Builder addStageInfoList(GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(int index, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageInfoList(Iterable<? extends GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo> values) {
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
                    this.bitField0_ &= -2;
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

            public GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder getStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public List<? extends GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder> getStageInfoListOrBuilderList() {
                if (this.stageInfoListBuilder_ != null) {
                    return this.stageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageInfoList_);
            }

            public GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder addStageInfoListBuilder() {
                return getStageInfoListFieldBuilder().addBuilder(GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.getDefaultInstance());
            }

            public GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder addStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().addBuilder(index, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.getDefaultInstance());
            }

            public List<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder> getStageInfoListBuilderList() {
                return getStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfo.Builder, GravenInnocencePhotoStageInfoOuterClass.GravenInnocencePhotoStageInfoOrBuilder> getStageInfoListFieldBuilder() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageInfoList_ = null;
                }
                return this.stageInfoListBuilder_;
            }

            private void ensureObjectInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.objectInfoList_ = new ArrayList(this.objectInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public List<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo> getObjectInfoListList() {
                if (this.objectInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.objectInfoList_);
                }
                return this.objectInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public int getObjectInfoListCount() {
                if (this.objectInfoListBuilder_ == null) {
                    return this.objectInfoList_.size();
                }
                return this.objectInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo getObjectInfoList(int index) {
                if (this.objectInfoListBuilder_ == null) {
                    return this.objectInfoList_.get(index);
                }
                return this.objectInfoListBuilder_.getMessage(index);
            }

            public Builder setObjectInfoList(int index, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo value) {
                if (this.objectInfoListBuilder_ != null) {
                    this.objectInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureObjectInfoListIsMutable();
                    this.objectInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setObjectInfoList(int index, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder builderForValue) {
                if (this.objectInfoListBuilder_ == null) {
                    ensureObjectInfoListIsMutable();
                    this.objectInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.objectInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addObjectInfoList(GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo value) {
                if (this.objectInfoListBuilder_ != null) {
                    this.objectInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureObjectInfoListIsMutable();
                    this.objectInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addObjectInfoList(int index, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo value) {
                if (this.objectInfoListBuilder_ != null) {
                    this.objectInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureObjectInfoListIsMutable();
                    this.objectInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addObjectInfoList(GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder builderForValue) {
                if (this.objectInfoListBuilder_ == null) {
                    ensureObjectInfoListIsMutable();
                    this.objectInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.objectInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addObjectInfoList(int index, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder builderForValue) {
                if (this.objectInfoListBuilder_ == null) {
                    ensureObjectInfoListIsMutable();
                    this.objectInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.objectInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllObjectInfoList(Iterable<? extends GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo> values) {
                if (this.objectInfoListBuilder_ == null) {
                    ensureObjectInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.objectInfoList_);
                    onChanged();
                } else {
                    this.objectInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearObjectInfoList() {
                if (this.objectInfoListBuilder_ == null) {
                    this.objectInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.objectInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeObjectInfoList(int index) {
                if (this.objectInfoListBuilder_ == null) {
                    ensureObjectInfoListIsMutable();
                    this.objectInfoList_.remove(index);
                    onChanged();
                } else {
                    this.objectInfoListBuilder_.remove(index);
                }
                return this;
            }

            public GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder getObjectInfoListBuilder(int index) {
                return getObjectInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder getObjectInfoListOrBuilder(int index) {
                if (this.objectInfoListBuilder_ == null) {
                    return this.objectInfoList_.get(index);
                }
                return this.objectInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder
            public List<? extends GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder> getObjectInfoListOrBuilderList() {
                if (this.objectInfoListBuilder_ != null) {
                    return this.objectInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.objectInfoList_);
            }

            public GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder addObjectInfoListBuilder() {
                return getObjectInfoListFieldBuilder().addBuilder(GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.getDefaultInstance());
            }

            public GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder addObjectInfoListBuilder(int index) {
                return getObjectInfoListFieldBuilder().addBuilder(index, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.getDefaultInstance());
            }

            public List<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder> getObjectInfoListBuilderList() {
                return getObjectInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfo.Builder, GravenInnocencePhotoObjectInfoOuterClass.GravenInnocencePhotoObjectInfoOrBuilder> getObjectInfoListFieldBuilder() {
                if (this.objectInfoListBuilder_ == null) {
                    this.objectInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.objectInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.objectInfoList_ = null;
                }
                return this.objectInfoListBuilder_;
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

        public static GravenInnocencePhotoInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GravenInnocencePhotoInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GravenInnocencePhotoInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GravenInnocencePhotoInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GravenInnocencePhotoObjectInfoOuterClass.getDescriptor();
        GravenInnocencePhotoStageInfoOuterClass.getDescriptor();
    }
}
