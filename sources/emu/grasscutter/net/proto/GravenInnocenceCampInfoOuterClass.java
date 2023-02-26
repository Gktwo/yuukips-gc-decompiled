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
import emu.grasscutter.net.proto.GravenInnocenceCampStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCampInfoOuterClass.class */
public final class GravenInnocenceCampInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dGravenInnocenceCampInfo.proto\u001a\"GravenInnocenceCampStageInfo.proto\"O\n\u0017GravenInnocenceCampInfo\u00124\n\rstageInfoList\u0018\u0004 \u0003(\u000b2\u001d.GravenInnocenceCampStageInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GravenInnocenceCampStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GravenInnocenceCampInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GravenInnocenceCampInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GravenInnocenceCampInfo_descriptor, new String[]{"StageInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCampInfoOuterClass$GravenInnocenceCampInfoOrBuilder.class */
    public interface GravenInnocenceCampInfoOrBuilder extends MessageOrBuilder {
        List<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo> getStageInfoListList();

        GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo getStageInfoList(int i);

        int getStageInfoListCount();

        List<? extends GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder> getStageInfoListOrBuilderList();

        GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder getStageInfoListOrBuilder(int i);
    }

    private GravenInnocenceCampInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCampInfoOuterClass$GravenInnocenceCampInfo.class */
    public static final class GravenInnocenceCampInfo extends GeneratedMessageV3 implements GravenInnocenceCampInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGEINFOLIST_FIELD_NUMBER = 4;
        private List<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo> stageInfoList_;
        private byte memoizedIsInitialized;
        private static final GravenInnocenceCampInfo DEFAULT_INSTANCE = new GravenInnocenceCampInfo();
        private static final Parser<GravenInnocenceCampInfo> PARSER = new AbstractParser<GravenInnocenceCampInfo>() { // from class: emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.1
            @Override // com.google.protobuf.Parser
            public GravenInnocenceCampInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GravenInnocenceCampInfo(input, extensionRegistry);
            }
        };

        private GravenInnocenceCampInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GravenInnocenceCampInfo() {
            this.memoizedIsInitialized = -1;
            this.stageInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GravenInnocenceCampInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GravenInnocenceCampInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.stageInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.stageInfoList_.add((GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo) input.readMessage(GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.parser(), extensionRegistry));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GravenInnocenceCampInfoOuterClass.internal_static_GravenInnocenceCampInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GravenInnocenceCampInfoOuterClass.internal_static_GravenInnocenceCampInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceCampInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
        public List<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo> getStageInfoListList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
        public List<? extends GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder> getStageInfoListOrBuilderList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
        public int getStageInfoListCount() {
            return this.stageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
        public GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo getStageInfoList(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
        public GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                output.writeMessage(4, this.stageInfoList_.get(i));
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
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GravenInnocenceCampInfo)) {
                return equals(obj);
            }
            GravenInnocenceCampInfo other = (GravenInnocenceCampInfo) obj;
            return getStageInfoListList().equals(other.getStageInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getStageInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GravenInnocenceCampInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceCampInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceCampInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceCampInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceCampInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceCampInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceCampInfo parseFrom(InputStream input) throws IOException {
            return (GravenInnocenceCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceCampInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceCampInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GravenInnocenceCampInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GravenInnocenceCampInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceCampInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceCampInfo parseFrom(CodedInputStream input) throws IOException {
            return (GravenInnocenceCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceCampInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceCampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GravenInnocenceCampInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceCampInfoOuterClass$GravenInnocenceCampInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GravenInnocenceCampInfoOrBuilder {
            private int bitField0_;
            private List<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo> stageInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder> stageInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GravenInnocenceCampInfoOuterClass.internal_static_GravenInnocenceCampInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GravenInnocenceCampInfoOuterClass.internal_static_GravenInnocenceCampInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceCampInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GravenInnocenceCampInfo.alwaysUseFieldBuilders) {
                    getStageInfoListFieldBuilder();
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
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GravenInnocenceCampInfoOuterClass.internal_static_GravenInnocenceCampInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GravenInnocenceCampInfo getDefaultInstanceForType() {
                return GravenInnocenceCampInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceCampInfo build() {
                GravenInnocenceCampInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceCampInfo buildPartial() {
                GravenInnocenceCampInfo result = new GravenInnocenceCampInfo(this);
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
                if (other instanceof GravenInnocenceCampInfo) {
                    return mergeFrom((GravenInnocenceCampInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GravenInnocenceCampInfo other) {
                if (other == GravenInnocenceCampInfo.getDefaultInstance()) {
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
                        this.stageInfoListBuilder_ = GravenInnocenceCampInfo.alwaysUseFieldBuilders ? getStageInfoListFieldBuilder() : null;
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
                GravenInnocenceCampInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GravenInnocenceCampInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GravenInnocenceCampInfo) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
            public List<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo> getStageInfoListList() {
                if (this.stageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageInfoList_);
                }
                return this.stageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
            public int getStageInfoListCount() {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.size();
                }
                return this.stageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
            public GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo getStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessage(index);
            }

            public Builder setStageInfoList(int index, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo value) {
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

            public Builder setStageInfoList(int index, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo value) {
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

            public Builder addStageInfoList(int index, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo value) {
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

            public Builder addStageInfoList(GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(int index, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageInfoList(Iterable<? extends GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo> values) {
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

            public GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder getStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
            public GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder
            public List<? extends GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder> getStageInfoListOrBuilderList() {
                if (this.stageInfoListBuilder_ != null) {
                    return this.stageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageInfoList_);
            }

            public GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder addStageInfoListBuilder() {
                return getStageInfoListFieldBuilder().addBuilder(GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.getDefaultInstance());
            }

            public GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder addStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().addBuilder(index, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.getDefaultInstance());
            }

            public List<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder> getStageInfoListBuilderList() {
                return getStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfo.Builder, GravenInnocenceCampStageInfoOuterClass.GravenInnocenceCampStageInfoOrBuilder> getStageInfoListFieldBuilder() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
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

        public static GravenInnocenceCampInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GravenInnocenceCampInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GravenInnocenceCampInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GravenInnocenceCampInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GravenInnocenceCampStageInfoOuterClass.getDescriptor();
    }
}
