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
import emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayInfoOuterClass.class */
public final class InstableSprayInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017InstableSprayInfo.proto\u001a'SceneGalleryInstableSprayBuffInfo.proto\"\\\n\u0011InstableSprayInfo\u0012\r\n\u0005score\u0018\r \u0001(\r\u00128\n\fbuffInfoList\u0018\u0006 \u0003(\u000b2\".SceneGalleryInstableSprayBuffInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SceneGalleryInstableSprayBuffInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_InstableSprayInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_InstableSprayInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_InstableSprayInfo_descriptor, new String[]{"Score", "BuffInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayInfoOuterClass$InstableSprayInfoOrBuilder.class */
    public interface InstableSprayInfoOrBuilder extends MessageOrBuilder {
        int getScore();

        List<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo> getBuffInfoListList();

        SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo getBuffInfoList(int i);

        int getBuffInfoListCount();

        List<? extends SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder> getBuffInfoListOrBuilderList();

        SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder getBuffInfoListOrBuilder(int i);
    }

    private InstableSprayInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayInfoOuterClass$InstableSprayInfo.class */
    public static final class InstableSprayInfo extends GeneratedMessageV3 implements InstableSprayInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCORE_FIELD_NUMBER = 13;
        private int score_;
        public static final int BUFFINFOLIST_FIELD_NUMBER = 6;
        private List<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo> buffInfoList_;
        private byte memoizedIsInitialized;
        private static final InstableSprayInfo DEFAULT_INSTANCE = new InstableSprayInfo();
        private static final Parser<InstableSprayInfo> PARSER = new AbstractParser<InstableSprayInfo>() { // from class: emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfo.1
            @Override // com.google.protobuf.Parser
            public InstableSprayInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InstableSprayInfo(input, extensionRegistry);
            }
        };

        private InstableSprayInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private InstableSprayInfo() {
            this.memoizedIsInitialized = -1;
            this.buffInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InstableSprayInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InstableSprayInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 50:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.buffInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.buffInfoList_.add((SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo) input.readMessage(SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.parser(), extensionRegistry));
                                    break;
                                case 104:
                                    this.score_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.buffInfoList_ = Collections.unmodifiableList(this.buffInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return InstableSprayInfoOuterClass.internal_static_InstableSprayInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InstableSprayInfoOuterClass.internal_static_InstableSprayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InstableSprayInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
        public int getScore() {
            return this.score_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
        public List<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo> getBuffInfoListList() {
            return this.buffInfoList_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
        public List<? extends SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder> getBuffInfoListOrBuilderList() {
            return this.buffInfoList_;
        }

        @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
        public int getBuffInfoListCount() {
            return this.buffInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
        public SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo getBuffInfoList(int index) {
            return this.buffInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
        public SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder getBuffInfoListOrBuilder(int index) {
            return this.buffInfoList_.get(index);
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
            for (int i = 0; i < this.buffInfoList_.size(); i++) {
                output.writeMessage(6, this.buffInfoList_.get(i));
            }
            if (this.score_ != 0) {
                output.writeUInt32(13, this.score_);
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
            for (int i = 0; i < this.buffInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.buffInfoList_.get(i));
            }
            if (this.score_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.score_);
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
            if (!(obj instanceof InstableSprayInfo)) {
                return equals(obj);
            }
            InstableSprayInfo other = (InstableSprayInfo) obj;
            return getScore() == other.getScore() && getBuffInfoListList().equals(other.getBuffInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getScore();
            if (getBuffInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getBuffInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static InstableSprayInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InstableSprayInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InstableSprayInfo parseFrom(InputStream input) throws IOException {
            return (InstableSprayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (InstableSprayInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InstableSprayInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InstableSprayInfo parseFrom(CodedInputStream input) throws IOException {
            return (InstableSprayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InstableSprayInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InstableSprayInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InstableSprayInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InstableSprayInfoOuterClass$InstableSprayInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InstableSprayInfoOrBuilder {
            private int bitField0_;
            private int score_;
            private List<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo> buffInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder> buffInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InstableSprayInfoOuterClass.internal_static_InstableSprayInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InstableSprayInfoOuterClass.internal_static_InstableSprayInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(InstableSprayInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InstableSprayInfo.alwaysUseFieldBuilders) {
                    getBuffInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.score_ = 0;
                if (this.buffInfoListBuilder_ == null) {
                    this.buffInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.buffInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InstableSprayInfoOuterClass.internal_static_InstableSprayInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InstableSprayInfo getDefaultInstanceForType() {
                return InstableSprayInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayInfo build() {
                InstableSprayInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InstableSprayInfo buildPartial() {
                InstableSprayInfo result = new InstableSprayInfo(this);
                int i = this.bitField0_;
                result.score_ = this.score_;
                if (this.buffInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.buffInfoList_ = Collections.unmodifiableList(this.buffInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.buffInfoList_ = this.buffInfoList_;
                } else {
                    result.buffInfoList_ = this.buffInfoListBuilder_.build();
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
                if (other instanceof InstableSprayInfo) {
                    return mergeFrom((InstableSprayInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InstableSprayInfo other) {
                if (other == InstableSprayInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getScore() != 0) {
                    setScore(other.getScore());
                }
                if (this.buffInfoListBuilder_ == null) {
                    if (!other.buffInfoList_.isEmpty()) {
                        if (this.buffInfoList_.isEmpty()) {
                            this.buffInfoList_ = other.buffInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBuffInfoListIsMutable();
                            this.buffInfoList_.addAll(other.buffInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.buffInfoList_.isEmpty()) {
                    if (this.buffInfoListBuilder_.isEmpty()) {
                        this.buffInfoListBuilder_.dispose();
                        this.buffInfoListBuilder_ = null;
                        this.buffInfoList_ = other.buffInfoList_;
                        this.bitField0_ &= -2;
                        this.buffInfoListBuilder_ = InstableSprayInfo.alwaysUseFieldBuilders ? getBuffInfoListFieldBuilder() : null;
                    } else {
                        this.buffInfoListBuilder_.addAllMessages(other.buffInfoList_);
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
                InstableSprayInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = InstableSprayInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InstableSprayInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
            public int getScore() {
                return this.score_;
            }

            public Builder setScore(int value) {
                this.score_ = value;
                onChanged();
                return this;
            }

            public Builder clearScore() {
                this.score_ = 0;
                onChanged();
                return this;
            }

            private void ensureBuffInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.buffInfoList_ = new ArrayList(this.buffInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
            public List<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo> getBuffInfoListList() {
                if (this.buffInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.buffInfoList_);
                }
                return this.buffInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
            public int getBuffInfoListCount() {
                if (this.buffInfoListBuilder_ == null) {
                    return this.buffInfoList_.size();
                }
                return this.buffInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
            public SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo getBuffInfoList(int index) {
                if (this.buffInfoListBuilder_ == null) {
                    return this.buffInfoList_.get(index);
                }
                return this.buffInfoListBuilder_.getMessage(index);
            }

            public Builder setBuffInfoList(int index, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo value) {
                if (this.buffInfoListBuilder_ != null) {
                    this.buffInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBuffInfoList(int index, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder builderForValue) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBuffInfoList(SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo value) {
                if (this.buffInfoListBuilder_ != null) {
                    this.buffInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuffInfoList(int index, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo value) {
                if (this.buffInfoListBuilder_ != null) {
                    this.buffInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBuffInfoList(SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder builderForValue) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBuffInfoList(int index, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder builderForValue) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBuffInfoList(Iterable<? extends SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo> values) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.buffInfoList_);
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBuffInfoList() {
                if (this.buffInfoListBuilder_ == null) {
                    this.buffInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBuffInfoList(int index) {
                if (this.buffInfoListBuilder_ == null) {
                    ensureBuffInfoListIsMutable();
                    this.buffInfoList_.remove(index);
                    onChanged();
                } else {
                    this.buffInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder getBuffInfoListBuilder(int index) {
                return getBuffInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
            public SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder getBuffInfoListOrBuilder(int index) {
                if (this.buffInfoListBuilder_ == null) {
                    return this.buffInfoList_.get(index);
                }
                return this.buffInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder
            public List<? extends SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder> getBuffInfoListOrBuilderList() {
                if (this.buffInfoListBuilder_ != null) {
                    return this.buffInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.buffInfoList_);
            }

            public SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder addBuffInfoListBuilder() {
                return getBuffInfoListFieldBuilder().addBuilder(SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.getDefaultInstance());
            }

            public SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder addBuffInfoListBuilder(int index) {
                return getBuffInfoListFieldBuilder().addBuilder(index, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.getDefaultInstance());
            }

            public List<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder> getBuffInfoListBuilderList() {
                return getBuffInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.Builder, SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder> getBuffInfoListFieldBuilder() {
                if (this.buffInfoListBuilder_ == null) {
                    this.buffInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.buffInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.buffInfoList_ = null;
                }
                return this.buffInfoListBuilder_;
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

        public static InstableSprayInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InstableSprayInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InstableSprayInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InstableSprayInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SceneGalleryInstableSprayBuffInfoOuterClass.getDescriptor();
    }
}
