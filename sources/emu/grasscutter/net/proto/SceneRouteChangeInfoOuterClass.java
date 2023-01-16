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
import emu.grasscutter.net.proto.RoutePointChangeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeInfoOuterClass.class */
public final class SceneRouteChangeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSceneRouteChangeInfo.proto\u001a\u001aRoutePointChangeInfo.proto\"u\n\u0014SceneRouteChangeInfo\u0012\u0012\n\nis_forward\u0018\u000f \u0001(\b\u0012\f\n\u0004type\u0018\u000b \u0001(\r\u0012)\n\npoint_list\u0018\n \u0003(\u000b2\u0015.RoutePointChangeInfo\u0012\u0010\n\broute_id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RoutePointChangeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneRouteChangeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneRouteChangeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneRouteChangeInfo_descriptor, new String[]{"IsForward", "Type", "PointList", "RouteId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeInfoOuterClass$SceneRouteChangeInfoOrBuilder.class */
    public interface SceneRouteChangeInfoOrBuilder extends MessageOrBuilder {
        boolean getIsForward();

        int getType();

        List<RoutePointChangeInfoOuterClass.RoutePointChangeInfo> getPointListList();

        RoutePointChangeInfoOuterClass.RoutePointChangeInfo getPointList(int i);

        int getPointListCount();

        List<? extends RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder> getPointListOrBuilderList();

        RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder getPointListOrBuilder(int i);

        int getRouteId();
    }

    private SceneRouteChangeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeInfoOuterClass$SceneRouteChangeInfo.class */
    public static final class SceneRouteChangeInfo extends GeneratedMessageV3 implements SceneRouteChangeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_FORWARD_FIELD_NUMBER = 15;
        private boolean isForward_;
        public static final int TYPE_FIELD_NUMBER = 11;
        private int type_;
        public static final int POINT_LIST_FIELD_NUMBER = 10;
        private List<RoutePointChangeInfoOuterClass.RoutePointChangeInfo> pointList_;
        public static final int ROUTE_ID_FIELD_NUMBER = 12;
        private int routeId_;
        private byte memoizedIsInitialized;
        private static final SceneRouteChangeInfo DEFAULT_INSTANCE = new SceneRouteChangeInfo();
        private static final Parser<SceneRouteChangeInfo> PARSER = new AbstractParser<SceneRouteChangeInfo>() { // from class: emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfo.1
            @Override // com.google.protobuf.Parser
            public SceneRouteChangeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneRouteChangeInfo(input, extensionRegistry);
            }
        };

        private SceneRouteChangeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneRouteChangeInfo() {
            this.memoizedIsInitialized = -1;
            this.pointList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneRouteChangeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneRouteChangeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.pointList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.pointList_.add((RoutePointChangeInfoOuterClass.RoutePointChangeInfo) input.readMessage(RoutePointChangeInfoOuterClass.RoutePointChangeInfo.parser(), extensionRegistry));
                                break;
                            case 88:
                                this.type_ = input.readUInt32();
                                break;
                            case 96:
                                this.routeId_ = input.readUInt32();
                                break;
                            case 120:
                                this.isForward_ = input.readBool();
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
                    this.pointList_ = Collections.unmodifiableList(this.pointList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneRouteChangeInfoOuterClass.internal_static_SceneRouteChangeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneRouteChangeInfoOuterClass.internal_static_SceneRouteChangeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneRouteChangeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public boolean getIsForward() {
            return this.isForward_;
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public List<RoutePointChangeInfoOuterClass.RoutePointChangeInfo> getPointListList() {
            return this.pointList_;
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public List<? extends RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder> getPointListOrBuilderList() {
            return this.pointList_;
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public int getPointListCount() {
            return this.pointList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public RoutePointChangeInfoOuterClass.RoutePointChangeInfo getPointList(int index) {
            return this.pointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder getPointListOrBuilder(int index) {
            return this.pointList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
        public int getRouteId() {
            return this.routeId_;
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
            for (int i = 0; i < this.pointList_.size(); i++) {
                output.writeMessage(10, this.pointList_.get(i));
            }
            if (this.type_ != 0) {
                output.writeUInt32(11, this.type_);
            }
            if (this.routeId_ != 0) {
                output.writeUInt32(12, this.routeId_);
            }
            if (this.isForward_) {
                output.writeBool(15, this.isForward_);
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
            for (int i = 0; i < this.pointList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.pointList_.get(i));
            }
            if (this.type_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.type_);
            }
            if (this.routeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.routeId_);
            }
            if (this.isForward_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isForward_);
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
            if (!(obj instanceof SceneRouteChangeInfo)) {
                return equals(obj);
            }
            SceneRouteChangeInfo other = (SceneRouteChangeInfo) obj;
            return getIsForward() == other.getIsForward() && getType() == other.getType() && getPointListList().equals(other.getPointListList()) && getRouteId() == other.getRouteId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + Internal.hashBoolean(getIsForward()))) + 11)) + getType();
            if (getPointListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getPointListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getRouteId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneRouteChangeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneRouteChangeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneRouteChangeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneRouteChangeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneRouteChangeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneRouteChangeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneRouteChangeInfo parseFrom(InputStream input) throws IOException {
            return (SceneRouteChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneRouteChangeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneRouteChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneRouteChangeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneRouteChangeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneRouteChangeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneRouteChangeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneRouteChangeInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneRouteChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneRouteChangeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneRouteChangeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneRouteChangeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneRouteChangeInfoOuterClass$SceneRouteChangeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneRouteChangeInfoOrBuilder {
            private int bitField0_;
            private boolean isForward_;
            private int type_;
            private List<RoutePointChangeInfoOuterClass.RoutePointChangeInfo> pointList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<RoutePointChangeInfoOuterClass.RoutePointChangeInfo, RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder, RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder> pointListBuilder_;
            private int routeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneRouteChangeInfoOuterClass.internal_static_SceneRouteChangeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneRouteChangeInfoOuterClass.internal_static_SceneRouteChangeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneRouteChangeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneRouteChangeInfo.alwaysUseFieldBuilders) {
                    getPointListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isForward_ = false;
                this.type_ = 0;
                if (this.pointListBuilder_ == null) {
                    this.pointList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.pointListBuilder_.clear();
                }
                this.routeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneRouteChangeInfoOuterClass.internal_static_SceneRouteChangeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneRouteChangeInfo getDefaultInstanceForType() {
                return SceneRouteChangeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneRouteChangeInfo build() {
                SceneRouteChangeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneRouteChangeInfo buildPartial() {
                SceneRouteChangeInfo result = new SceneRouteChangeInfo(this);
                int i = this.bitField0_;
                result.isForward_ = this.isForward_;
                result.type_ = this.type_;
                if (this.pointListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.pointList_ = Collections.unmodifiableList(this.pointList_);
                        this.bitField0_ &= -2;
                    }
                    result.pointList_ = this.pointList_;
                } else {
                    result.pointList_ = this.pointListBuilder_.build();
                }
                result.routeId_ = this.routeId_;
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
                if (other instanceof SceneRouteChangeInfo) {
                    return mergeFrom((SceneRouteChangeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneRouteChangeInfo other) {
                if (other == SceneRouteChangeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsForward()) {
                    setIsForward(other.getIsForward());
                }
                if (other.getType() != 0) {
                    setType(other.getType());
                }
                if (this.pointListBuilder_ == null) {
                    if (!other.pointList_.isEmpty()) {
                        if (this.pointList_.isEmpty()) {
                            this.pointList_ = other.pointList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePointListIsMutable();
                            this.pointList_.addAll(other.pointList_);
                        }
                        onChanged();
                    }
                } else if (!other.pointList_.isEmpty()) {
                    if (this.pointListBuilder_.isEmpty()) {
                        this.pointListBuilder_.dispose();
                        this.pointListBuilder_ = null;
                        this.pointList_ = other.pointList_;
                        this.bitField0_ &= -2;
                        this.pointListBuilder_ = SceneRouteChangeInfo.alwaysUseFieldBuilders ? getPointListFieldBuilder() : null;
                    } else {
                        this.pointListBuilder_.addAllMessages(other.pointList_);
                    }
                }
                if (other.getRouteId() != 0) {
                    setRouteId(other.getRouteId());
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
                SceneRouteChangeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneRouteChangeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneRouteChangeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public boolean getIsForward() {
                return this.isForward_;
            }

            public Builder setIsForward(boolean value) {
                this.isForward_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsForward() {
                this.isForward_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            private void ensurePointListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.pointList_ = new ArrayList(this.pointList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public List<RoutePointChangeInfoOuterClass.RoutePointChangeInfo> getPointListList() {
                if (this.pointListBuilder_ == null) {
                    return Collections.unmodifiableList(this.pointList_);
                }
                return this.pointListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public int getPointListCount() {
                if (this.pointListBuilder_ == null) {
                    return this.pointList_.size();
                }
                return this.pointListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public RoutePointChangeInfoOuterClass.RoutePointChangeInfo getPointList(int index) {
                if (this.pointListBuilder_ == null) {
                    return this.pointList_.get(index);
                }
                return this.pointListBuilder_.getMessage(index);
            }

            public Builder setPointList(int index, RoutePointChangeInfoOuterClass.RoutePointChangeInfo value) {
                if (this.pointListBuilder_ != null) {
                    this.pointListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointListIsMutable();
                    this.pointList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPointList(int index, RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder builderForValue) {
                if (this.pointListBuilder_ == null) {
                    ensurePointListIsMutable();
                    this.pointList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.pointListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPointList(RoutePointChangeInfoOuterClass.RoutePointChangeInfo value) {
                if (this.pointListBuilder_ != null) {
                    this.pointListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointListIsMutable();
                    this.pointList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPointList(int index, RoutePointChangeInfoOuterClass.RoutePointChangeInfo value) {
                if (this.pointListBuilder_ != null) {
                    this.pointListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePointListIsMutable();
                    this.pointList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPointList(RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder builderForValue) {
                if (this.pointListBuilder_ == null) {
                    ensurePointListIsMutable();
                    this.pointList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.pointListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPointList(int index, RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder builderForValue) {
                if (this.pointListBuilder_ == null) {
                    ensurePointListIsMutable();
                    this.pointList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.pointListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPointList(Iterable<? extends RoutePointChangeInfoOuterClass.RoutePointChangeInfo> values) {
                if (this.pointListBuilder_ == null) {
                    ensurePointListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.pointList_);
                    onChanged();
                } else {
                    this.pointListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPointList() {
                if (this.pointListBuilder_ == null) {
                    this.pointList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.pointListBuilder_.clear();
                }
                return this;
            }

            public Builder removePointList(int index) {
                if (this.pointListBuilder_ == null) {
                    ensurePointListIsMutable();
                    this.pointList_.remove(index);
                    onChanged();
                } else {
                    this.pointListBuilder_.remove(index);
                }
                return this;
            }

            public RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder getPointListBuilder(int index) {
                return getPointListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder getPointListOrBuilder(int index) {
                if (this.pointListBuilder_ == null) {
                    return this.pointList_.get(index);
                }
                return this.pointListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public List<? extends RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder> getPointListOrBuilderList() {
                if (this.pointListBuilder_ != null) {
                    return this.pointListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.pointList_);
            }

            public RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder addPointListBuilder() {
                return getPointListFieldBuilder().addBuilder(RoutePointChangeInfoOuterClass.RoutePointChangeInfo.getDefaultInstance());
            }

            public RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder addPointListBuilder(int index) {
                return getPointListFieldBuilder().addBuilder(index, RoutePointChangeInfoOuterClass.RoutePointChangeInfo.getDefaultInstance());
            }

            public List<RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder> getPointListBuilderList() {
                return getPointListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RoutePointChangeInfoOuterClass.RoutePointChangeInfo, RoutePointChangeInfoOuterClass.RoutePointChangeInfo.Builder, RoutePointChangeInfoOuterClass.RoutePointChangeInfoOrBuilder> getPointListFieldBuilder() {
                if (this.pointListBuilder_ == null) {
                    this.pointListBuilder_ = new RepeatedFieldBuilderV3<>(this.pointList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.pointList_ = null;
                }
                return this.pointListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneRouteChangeInfoOuterClass.SceneRouteChangeInfoOrBuilder
            public int getRouteId() {
                return this.routeId_;
            }

            public Builder setRouteId(int value) {
                this.routeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRouteId() {
                this.routeId_ = 0;
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

        public static SceneRouteChangeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneRouteChangeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneRouteChangeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneRouteChangeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RoutePointChangeInfoOuterClass.getDescriptor();
    }
}
