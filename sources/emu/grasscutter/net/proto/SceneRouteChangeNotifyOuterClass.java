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
import emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeNotifyOuterClass.class */
public final class SceneRouteChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSceneRouteChangeNotify.proto\u001a\u001aSceneRouteChangeInfo.proto\"i\n\u0016SceneRouteChangeNotify\u0012\u0012\n\nscene_time\u0018\u0003 \u0001(\r\u0012)\n\nroute_list\u0018\u0004 \u0003(\u000b2\u0015.SceneRouteChangeInfo\u0012\u0010\n\bscene_id\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SceneRouteChangeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneRouteChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneRouteChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneRouteChangeNotify_descriptor, new String[]{"SceneTime", "RouteList", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeNotifyOuterClass$SceneRouteChangeNotifyOrBuilder.class */
    public interface SceneRouteChangeNotifyOrBuilder extends MessageOrBuilder {
        int getSceneTime();

        List<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo> getRouteListList();

        SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo getRouteList(int i);

        int getRouteListCount();

        List<? extends SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder> getRouteListOrBuilderList();

        SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder getRouteListOrBuilder(int i);

        int getSceneId();
    }

    private SceneRouteChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeNotifyOuterClass$SceneRouteChangeNotify.class */
    public static final class SceneRouteChangeNotify extends GeneratedMessageV3 implements SceneRouteChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_TIME_FIELD_NUMBER = 3;
        private int sceneTime_;
        public static final int ROUTE_LIST_FIELD_NUMBER = 4;
        private List<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo> routeList_;
        public static final int SCENE_ID_FIELD_NUMBER = 11;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final SceneRouteChangeNotify DEFAULT_INSTANCE = new SceneRouteChangeNotify();
        private static final Parser<SceneRouteChangeNotify> PARSER = new AbstractParser<SceneRouteChangeNotify>() { // from class: emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotify.1
            @Override // com.google.protobuf.Parser
            public SceneRouteChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneRouteChangeNotify(input, extensionRegistry);
            }
        };

        private SceneRouteChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneRouteChangeNotify() {
            this.memoizedIsInitialized = -1;
            this.routeList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneRouteChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneRouteChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.sceneTime_ = input.readUInt32();
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.routeList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.routeList_.add((SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo) input.readMessage(SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.parser(), extensionRegistry));
                                break;
                            case 88:
                                this.sceneId_ = input.readUInt32();
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.routeList_ = Collections.unmodifiableList(this.routeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneRouteChangeNotifyOuterClass.internal_static_SceneRouteChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneRouteChangeNotifyOuterClass.internal_static_SceneRouteChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneRouteChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
        public int getSceneTime() {
            return this.sceneTime_;
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
        public List<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo> getRouteListList() {
            return this.routeList_;
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
        public List<? extends SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder> getRouteListOrBuilderList() {
            return this.routeList_;
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
        public int getRouteListCount() {
            return this.routeList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
        public SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo getRouteList(int index) {
            return this.routeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
        public SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder getRouteListOrBuilder(int index) {
            return this.routeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (this.sceneTime_ != 0) {
                output.writeUInt32(3, this.sceneTime_);
            }
            for (int i = 0; i < this.routeList_.size(); i++) {
                output.writeMessage(4, this.routeList_.get(i));
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(11, this.sceneId_);
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
            if (this.sceneTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.sceneTime_);
            }
            for (int i = 0; i < this.routeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.routeList_.get(i));
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.sceneId_);
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
            if (!(obj instanceof SceneRouteChangeNotify)) {
                return equals(obj);
            }
            SceneRouteChangeNotify other = (SceneRouteChangeNotify) obj;
            return getSceneTime() == other.getSceneTime() && getRouteListList().equals(other.getRouteListList()) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getSceneTime();
            if (getRouteListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getRouteListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneRouteChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneRouteChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneRouteChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneRouteChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneRouteChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneRouteChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneRouteChangeNotify parseFrom(InputStream input) throws IOException {
            return (SceneRouteChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneRouteChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneRouteChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneRouteChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneRouteChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneRouteChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneRouteChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneRouteChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneRouteChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneRouteChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneRouteChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneRouteChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeNotifyOuterClass$SceneRouteChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneRouteChangeNotifyOrBuilder {
            private int bitField0_;
            private int sceneTime_;
            private List<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo> routeList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder> routeListBuilder_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneRouteChangeNotifyOuterClass.internal_static_SceneRouteChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneRouteChangeNotifyOuterClass.internal_static_SceneRouteChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneRouteChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneRouteChangeNotify.alwaysUseFieldBuilders) {
                    getRouteListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneTime_ = 0;
                if (this.routeListBuilder_ == null) {
                    this.routeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.routeListBuilder_.clear();
                }
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneRouteChangeNotifyOuterClass.internal_static_SceneRouteChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneRouteChangeNotify getDefaultInstanceForType() {
                return SceneRouteChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneRouteChangeNotify build() {
                SceneRouteChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneRouteChangeNotify buildPartial() {
                SceneRouteChangeNotify result = new SceneRouteChangeNotify(this);
                int i = this.bitField0_;
                result.sceneTime_ = this.sceneTime_;
                if (this.routeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.routeList_ = Collections.unmodifiableList(this.routeList_);
                        this.bitField0_ &= -2;
                    }
                    result.routeList_ = this.routeList_;
                } else {
                    result.routeList_ = this.routeListBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof SceneRouteChangeNotify) {
                    return mergeFrom((SceneRouteChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneRouteChangeNotify other) {
                if (other == SceneRouteChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getSceneTime() != 0) {
                    setSceneTime(other.getSceneTime());
                }
                if (this.routeListBuilder_ == null) {
                    if (!other.routeList_.isEmpty()) {
                        if (this.routeList_.isEmpty()) {
                            this.routeList_ = other.routeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRouteListIsMutable();
                            this.routeList_.addAll(other.routeList_);
                        }
                        onChanged();
                    }
                } else if (!other.routeList_.isEmpty()) {
                    if (this.routeListBuilder_.isEmpty()) {
                        this.routeListBuilder_.dispose();
                        this.routeListBuilder_ = null;
                        this.routeList_ = other.routeList_;
                        this.bitField0_ &= -2;
                        this.routeListBuilder_ = SceneRouteChangeNotify.alwaysUseFieldBuilders ? getRouteListFieldBuilder() : null;
                    } else {
                        this.routeListBuilder_.addAllMessages(other.routeList_);
                    }
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                SceneRouteChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneRouteChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneRouteChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
            public int getSceneTime() {
                return this.sceneTime_;
            }

            public Builder setSceneTime(int value) {
                this.sceneTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneTime() {
                this.sceneTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureRouteListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.routeList_ = new ArrayList(this.routeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
            public List<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo> getRouteListList() {
                if (this.routeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.routeList_);
                }
                return this.routeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
            public int getRouteListCount() {
                if (this.routeListBuilder_ == null) {
                    return this.routeList_.size();
                }
                return this.routeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
            public SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo getRouteList(int index) {
                if (this.routeListBuilder_ == null) {
                    return this.routeList_.get(index);
                }
                return this.routeListBuilder_.getMessage(index);
            }

            public Builder setRouteList(int index, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo value) {
                if (this.routeListBuilder_ != null) {
                    this.routeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRouteListIsMutable();
                    this.routeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRouteList(int index, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder builderForValue) {
                if (this.routeListBuilder_ == null) {
                    ensureRouteListIsMutable();
                    this.routeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.routeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRouteList(SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo value) {
                if (this.routeListBuilder_ != null) {
                    this.routeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRouteListIsMutable();
                    this.routeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRouteList(int index, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo value) {
                if (this.routeListBuilder_ != null) {
                    this.routeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRouteListIsMutable();
                    this.routeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRouteList(SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder builderForValue) {
                if (this.routeListBuilder_ == null) {
                    ensureRouteListIsMutable();
                    this.routeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.routeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRouteList(int index, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder builderForValue) {
                if (this.routeListBuilder_ == null) {
                    ensureRouteListIsMutable();
                    this.routeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.routeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRouteList(Iterable<? extends SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo> values) {
                if (this.routeListBuilder_ == null) {
                    ensureRouteListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.routeList_);
                    onChanged();
                } else {
                    this.routeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRouteList() {
                if (this.routeListBuilder_ == null) {
                    this.routeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.routeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRouteList(int index) {
                if (this.routeListBuilder_ == null) {
                    ensureRouteListIsMutable();
                    this.routeList_.remove(index);
                    onChanged();
                } else {
                    this.routeListBuilder_.remove(index);
                }
                return this;
            }

            public SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder getRouteListBuilder(int index) {
                return getRouteListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
            public SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder getRouteListOrBuilder(int index) {
                if (this.routeListBuilder_ == null) {
                    return this.routeList_.get(index);
                }
                return this.routeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
            public List<? extends SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder> getRouteListOrBuilderList() {
                if (this.routeListBuilder_ != null) {
                    return this.routeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.routeList_);
            }

            public SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder addRouteListBuilder() {
                return getRouteListFieldBuilder().addBuilder(SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.getDefaultInstance());
            }

            public SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder addRouteListBuilder(int index) {
                return getRouteListFieldBuilder().addBuilder(index, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.getDefaultInstance());
            }

            public List<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder> getRouteListBuilderList() {
                return getRouteListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.Builder, SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder> getRouteListFieldBuilder() {
                if (this.routeListBuilder_ == null) {
                    this.routeListBuilder_ = new RepeatedFieldBuilderV3<>(this.routeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.routeList_ = null;
                }
                return this.routeListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeNotifyOuterClass.SceneRouteChangeNotifyOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static SceneRouteChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneRouteChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneRouteChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneRouteChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SceneRouteChangeInfoOuterClass.getDescriptor();
    }
}
