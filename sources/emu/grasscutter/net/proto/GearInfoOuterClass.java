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
import emu.grasscutter.net.proto.GearLevelDataOuterClass;
import emu.grasscutter.net.proto.JigsawPictureDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GearInfoOuterClass.class */
public final class GearInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eGearInfo.proto\u001a\u0017JigsawPictureData.proto\u001a\u0013GearLevelData.proto\"d\n\bGearInfo\u0012)\n\u0011gearLevelDataList\u0018\t \u0003(\u000b2\u000e.GearLevelData\u0012-\n\u0011jigsawPictureData\u0018\r \u0001(\u000b2\u0012.JigsawPictureDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{JigsawPictureDataOuterClass.getDescriptor(), GearLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GearInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GearInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GearInfo_descriptor, new String[]{"GearLevelDataList", "JigsawPictureData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GearInfoOuterClass$GearInfoOrBuilder.class */
    public interface GearInfoOrBuilder extends MessageOrBuilder {
        List<GearLevelDataOuterClass.GearLevelData> getGearLevelDataListList();

        GearLevelDataOuterClass.GearLevelData getGearLevelDataList(int i);

        int getGearLevelDataListCount();

        List<? extends GearLevelDataOuterClass.GearLevelDataOrBuilder> getGearLevelDataListOrBuilderList();

        GearLevelDataOuterClass.GearLevelDataOrBuilder getGearLevelDataListOrBuilder(int i);

        boolean hasJigsawPictureData();

        JigsawPictureDataOuterClass.JigsawPictureData getJigsawPictureData();

        JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder getJigsawPictureDataOrBuilder();
    }

    private GearInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GearInfoOuterClass$GearInfo.class */
    public static final class GearInfo extends GeneratedMessageV3 implements GearInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GEARLEVELDATALIST_FIELD_NUMBER = 9;
        private List<GearLevelDataOuterClass.GearLevelData> gearLevelDataList_;
        public static final int JIGSAWPICTUREDATA_FIELD_NUMBER = 13;
        private JigsawPictureDataOuterClass.JigsawPictureData jigsawPictureData_;
        private byte memoizedIsInitialized;
        private static final GearInfo DEFAULT_INSTANCE = new GearInfo();
        private static final Parser<GearInfo> PARSER = new AbstractParser<GearInfo>() { // from class: emu.grasscutter.net.proto.GearInfoOuterClass.GearInfo.1
            @Override // com.google.protobuf.Parser
            public GearInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GearInfo(input, extensionRegistry);
            }
        };

        private GearInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GearInfo() {
            this.memoizedIsInitialized = -1;
            this.gearLevelDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GearInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GearInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.gearLevelDataList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.gearLevelDataList_.add((GearLevelDataOuterClass.GearLevelData) input.readMessage(GearLevelDataOuterClass.GearLevelData.parser(), extensionRegistry));
                                break;
                            case 106:
                                JigsawPictureDataOuterClass.JigsawPictureData.Builder subBuilder = this.jigsawPictureData_ != null ? this.jigsawPictureData_.toBuilder() : null;
                                this.jigsawPictureData_ = (JigsawPictureDataOuterClass.JigsawPictureData) input.readMessage(JigsawPictureDataOuterClass.JigsawPictureData.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.jigsawPictureData_);
                                    this.jigsawPictureData_ = subBuilder.buildPartial();
                                    break;
                                }
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
                    this.gearLevelDataList_ = Collections.unmodifiableList(this.gearLevelDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GearInfoOuterClass.internal_static_GearInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GearInfoOuterClass.internal_static_GearInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GearInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public List<GearLevelDataOuterClass.GearLevelData> getGearLevelDataListList() {
            return this.gearLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public List<? extends GearLevelDataOuterClass.GearLevelDataOrBuilder> getGearLevelDataListOrBuilderList() {
            return this.gearLevelDataList_;
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public int getGearLevelDataListCount() {
            return this.gearLevelDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public GearLevelDataOuterClass.GearLevelData getGearLevelDataList(int index) {
            return this.gearLevelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public GearLevelDataOuterClass.GearLevelDataOrBuilder getGearLevelDataListOrBuilder(int index) {
            return this.gearLevelDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public boolean hasJigsawPictureData() {
            return this.jigsawPictureData_ != null;
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public JigsawPictureDataOuterClass.JigsawPictureData getJigsawPictureData() {
            return this.jigsawPictureData_ == null ? JigsawPictureDataOuterClass.JigsawPictureData.getDefaultInstance() : this.jigsawPictureData_;
        }

        @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
        public JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder getJigsawPictureDataOrBuilder() {
            return getJigsawPictureData();
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
            for (int i = 0; i < this.gearLevelDataList_.size(); i++) {
                output.writeMessage(9, this.gearLevelDataList_.get(i));
            }
            if (this.jigsawPictureData_ != null) {
                output.writeMessage(13, getJigsawPictureData());
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
            for (int i = 0; i < this.gearLevelDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.gearLevelDataList_.get(i));
            }
            if (this.jigsawPictureData_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getJigsawPictureData());
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
            if (!(obj instanceof GearInfo)) {
                return equals(obj);
            }
            GearInfo other = (GearInfo) obj;
            if (getGearLevelDataListList().equals(other.getGearLevelDataListList()) && hasJigsawPictureData() == other.hasJigsawPictureData()) {
                return (!hasJigsawPictureData() || getJigsawPictureData().equals(other.getJigsawPictureData())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getGearLevelDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getGearLevelDataListList().hashCode();
            }
            if (hasJigsawPictureData()) {
                hash = (53 * ((37 * hash) + 13)) + getJigsawPictureData().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GearInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GearInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GearInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GearInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GearInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GearInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GearInfo parseFrom(InputStream input) throws IOException {
            return (GearInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GearInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GearInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GearInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GearInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GearInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GearInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GearInfo parseFrom(CodedInputStream input) throws IOException {
            return (GearInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GearInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GearInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GearInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GearInfoOuterClass$GearInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GearInfoOrBuilder {
            private int bitField0_;
            private List<GearLevelDataOuterClass.GearLevelData> gearLevelDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GearLevelDataOuterClass.GearLevelData, GearLevelDataOuterClass.GearLevelData.Builder, GearLevelDataOuterClass.GearLevelDataOrBuilder> gearLevelDataListBuilder_;
            private JigsawPictureDataOuterClass.JigsawPictureData jigsawPictureData_;
            private SingleFieldBuilderV3<JigsawPictureDataOuterClass.JigsawPictureData, JigsawPictureDataOuterClass.JigsawPictureData.Builder, JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder> jigsawPictureDataBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GearInfoOuterClass.internal_static_GearInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GearInfoOuterClass.internal_static_GearInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GearInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GearInfo.alwaysUseFieldBuilders) {
                    getGearLevelDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.gearLevelDataListBuilder_ == null) {
                    this.gearLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.gearLevelDataListBuilder_.clear();
                }
                if (this.jigsawPictureDataBuilder_ == null) {
                    this.jigsawPictureData_ = null;
                } else {
                    this.jigsawPictureData_ = null;
                    this.jigsawPictureDataBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GearInfoOuterClass.internal_static_GearInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GearInfo getDefaultInstanceForType() {
                return GearInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GearInfo build() {
                GearInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GearInfo buildPartial() {
                GearInfo result = new GearInfo(this);
                int i = this.bitField0_;
                if (this.gearLevelDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.gearLevelDataList_ = Collections.unmodifiableList(this.gearLevelDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.gearLevelDataList_ = this.gearLevelDataList_;
                } else {
                    result.gearLevelDataList_ = this.gearLevelDataListBuilder_.build();
                }
                if (this.jigsawPictureDataBuilder_ == null) {
                    result.jigsawPictureData_ = this.jigsawPictureData_;
                } else {
                    result.jigsawPictureData_ = this.jigsawPictureDataBuilder_.build();
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
                if (other instanceof GearInfo) {
                    return mergeFrom((GearInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GearInfo other) {
                if (other == GearInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.gearLevelDataListBuilder_ == null) {
                    if (!other.gearLevelDataList_.isEmpty()) {
                        if (this.gearLevelDataList_.isEmpty()) {
                            this.gearLevelDataList_ = other.gearLevelDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureGearLevelDataListIsMutable();
                            this.gearLevelDataList_.addAll(other.gearLevelDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.gearLevelDataList_.isEmpty()) {
                    if (this.gearLevelDataListBuilder_.isEmpty()) {
                        this.gearLevelDataListBuilder_.dispose();
                        this.gearLevelDataListBuilder_ = null;
                        this.gearLevelDataList_ = other.gearLevelDataList_;
                        this.bitField0_ &= -2;
                        this.gearLevelDataListBuilder_ = GearInfo.alwaysUseFieldBuilders ? getGearLevelDataListFieldBuilder() : null;
                    } else {
                        this.gearLevelDataListBuilder_.addAllMessages(other.gearLevelDataList_);
                    }
                }
                if (other.hasJigsawPictureData()) {
                    mergeJigsawPictureData(other.getJigsawPictureData());
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
                GearInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GearInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GearInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureGearLevelDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.gearLevelDataList_ = new ArrayList(this.gearLevelDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public List<GearLevelDataOuterClass.GearLevelData> getGearLevelDataListList() {
                if (this.gearLevelDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.gearLevelDataList_);
                }
                return this.gearLevelDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public int getGearLevelDataListCount() {
                if (this.gearLevelDataListBuilder_ == null) {
                    return this.gearLevelDataList_.size();
                }
                return this.gearLevelDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public GearLevelDataOuterClass.GearLevelData getGearLevelDataList(int index) {
                if (this.gearLevelDataListBuilder_ == null) {
                    return this.gearLevelDataList_.get(index);
                }
                return this.gearLevelDataListBuilder_.getMessage(index);
            }

            public Builder setGearLevelDataList(int index, GearLevelDataOuterClass.GearLevelData value) {
                if (this.gearLevelDataListBuilder_ != null) {
                    this.gearLevelDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGearLevelDataListIsMutable();
                    this.gearLevelDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGearLevelDataList(int index, GearLevelDataOuterClass.GearLevelData.Builder builderForValue) {
                if (this.gearLevelDataListBuilder_ == null) {
                    ensureGearLevelDataListIsMutable();
                    this.gearLevelDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gearLevelDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGearLevelDataList(GearLevelDataOuterClass.GearLevelData value) {
                if (this.gearLevelDataListBuilder_ != null) {
                    this.gearLevelDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGearLevelDataListIsMutable();
                    this.gearLevelDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGearLevelDataList(int index, GearLevelDataOuterClass.GearLevelData value) {
                if (this.gearLevelDataListBuilder_ != null) {
                    this.gearLevelDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGearLevelDataListIsMutable();
                    this.gearLevelDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGearLevelDataList(GearLevelDataOuterClass.GearLevelData.Builder builderForValue) {
                if (this.gearLevelDataListBuilder_ == null) {
                    ensureGearLevelDataListIsMutable();
                    this.gearLevelDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.gearLevelDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGearLevelDataList(int index, GearLevelDataOuterClass.GearLevelData.Builder builderForValue) {
                if (this.gearLevelDataListBuilder_ == null) {
                    ensureGearLevelDataListIsMutable();
                    this.gearLevelDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gearLevelDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGearLevelDataList(Iterable<? extends GearLevelDataOuterClass.GearLevelData> values) {
                if (this.gearLevelDataListBuilder_ == null) {
                    ensureGearLevelDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.gearLevelDataList_);
                    onChanged();
                } else {
                    this.gearLevelDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGearLevelDataList() {
                if (this.gearLevelDataListBuilder_ == null) {
                    this.gearLevelDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.gearLevelDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGearLevelDataList(int index) {
                if (this.gearLevelDataListBuilder_ == null) {
                    ensureGearLevelDataListIsMutable();
                    this.gearLevelDataList_.remove(index);
                    onChanged();
                } else {
                    this.gearLevelDataListBuilder_.remove(index);
                }
                return this;
            }

            public GearLevelDataOuterClass.GearLevelData.Builder getGearLevelDataListBuilder(int index) {
                return getGearLevelDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public GearLevelDataOuterClass.GearLevelDataOrBuilder getGearLevelDataListOrBuilder(int index) {
                if (this.gearLevelDataListBuilder_ == null) {
                    return this.gearLevelDataList_.get(index);
                }
                return this.gearLevelDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public List<? extends GearLevelDataOuterClass.GearLevelDataOrBuilder> getGearLevelDataListOrBuilderList() {
                if (this.gearLevelDataListBuilder_ != null) {
                    return this.gearLevelDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.gearLevelDataList_);
            }

            public GearLevelDataOuterClass.GearLevelData.Builder addGearLevelDataListBuilder() {
                return getGearLevelDataListFieldBuilder().addBuilder(GearLevelDataOuterClass.GearLevelData.getDefaultInstance());
            }

            public GearLevelDataOuterClass.GearLevelData.Builder addGearLevelDataListBuilder(int index) {
                return getGearLevelDataListFieldBuilder().addBuilder(index, GearLevelDataOuterClass.GearLevelData.getDefaultInstance());
            }

            public List<GearLevelDataOuterClass.GearLevelData.Builder> getGearLevelDataListBuilderList() {
                return getGearLevelDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GearLevelDataOuterClass.GearLevelData, GearLevelDataOuterClass.GearLevelData.Builder, GearLevelDataOuterClass.GearLevelDataOrBuilder> getGearLevelDataListFieldBuilder() {
                if (this.gearLevelDataListBuilder_ == null) {
                    this.gearLevelDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.gearLevelDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.gearLevelDataList_ = null;
                }
                return this.gearLevelDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public boolean hasJigsawPictureData() {
                return (this.jigsawPictureDataBuilder_ == null && this.jigsawPictureData_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public JigsawPictureDataOuterClass.JigsawPictureData getJigsawPictureData() {
                if (this.jigsawPictureDataBuilder_ == null) {
                    return this.jigsawPictureData_ == null ? JigsawPictureDataOuterClass.JigsawPictureData.getDefaultInstance() : this.jigsawPictureData_;
                }
                return this.jigsawPictureDataBuilder_.getMessage();
            }

            public Builder setJigsawPictureData(JigsawPictureDataOuterClass.JigsawPictureData value) {
                if (this.jigsawPictureDataBuilder_ != null) {
                    this.jigsawPictureDataBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.jigsawPictureData_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setJigsawPictureData(JigsawPictureDataOuterClass.JigsawPictureData.Builder builderForValue) {
                if (this.jigsawPictureDataBuilder_ == null) {
                    this.jigsawPictureData_ = builderForValue.build();
                    onChanged();
                } else {
                    this.jigsawPictureDataBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeJigsawPictureData(JigsawPictureDataOuterClass.JigsawPictureData value) {
                if (this.jigsawPictureDataBuilder_ == null) {
                    if (this.jigsawPictureData_ != null) {
                        this.jigsawPictureData_ = JigsawPictureDataOuterClass.JigsawPictureData.newBuilder(this.jigsawPictureData_).mergeFrom(value).buildPartial();
                    } else {
                        this.jigsawPictureData_ = value;
                    }
                    onChanged();
                } else {
                    this.jigsawPictureDataBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearJigsawPictureData() {
                if (this.jigsawPictureDataBuilder_ == null) {
                    this.jigsawPictureData_ = null;
                    onChanged();
                } else {
                    this.jigsawPictureData_ = null;
                    this.jigsawPictureDataBuilder_ = null;
                }
                return this;
            }

            public JigsawPictureDataOuterClass.JigsawPictureData.Builder getJigsawPictureDataBuilder() {
                onChanged();
                return getJigsawPictureDataFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GearInfoOuterClass.GearInfoOrBuilder
            public JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder getJigsawPictureDataOrBuilder() {
                if (this.jigsawPictureDataBuilder_ != null) {
                    return this.jigsawPictureDataBuilder_.getMessageOrBuilder();
                }
                return this.jigsawPictureData_ == null ? JigsawPictureDataOuterClass.JigsawPictureData.getDefaultInstance() : this.jigsawPictureData_;
            }

            private SingleFieldBuilderV3<JigsawPictureDataOuterClass.JigsawPictureData, JigsawPictureDataOuterClass.JigsawPictureData.Builder, JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder> getJigsawPictureDataFieldBuilder() {
                if (this.jigsawPictureDataBuilder_ == null) {
                    this.jigsawPictureDataBuilder_ = new SingleFieldBuilderV3<>(getJigsawPictureData(), getParentForChildren(), isClean());
                    this.jigsawPictureData_ = null;
                }
                return this.jigsawPictureDataBuilder_;
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

        public static GearInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GearInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GearInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GearInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        JigsawPictureDataOuterClass.getDescriptor();
        GearLevelDataOuterClass.getDescriptor();
    }
}
