package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.RouteOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFollowRouteNotifyOuterClass.class */
public final class AvatarFollowRouteNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAvatarFollowRouteNotify.proto\u001a\u000bRoute.proto\"\u0001\n\u0017AvatarFollowRouteNotify\u0012\u0018\n\u0010startSceneTimeMs\u0018\u0006 \u0001(\r\u0012\u0012\n\ntemplateId\u0018\u0002 \u0001(\r\u0012\u0014\n\fclientParams\u0018\n \u0001(\t\u0012\u0015\n\u0005route\u0018\u0004 \u0001(\u000b2\u0006.Route\u0012\u0010\n\bentityId\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RouteOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarFollowRouteNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarFollowRouteNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarFollowRouteNotify_descriptor, new String[]{"StartSceneTimeMs", "TemplateId", "ClientParams", "Route", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFollowRouteNotifyOuterClass$AvatarFollowRouteNotifyOrBuilder.class */
    public interface AvatarFollowRouteNotifyOrBuilder extends MessageOrBuilder {
        int getStartSceneTimeMs();

        int getTemplateId();

        String getClientParams();

        ByteString getClientParamsBytes();

        boolean hasRoute();

        RouteOuterClass.Route getRoute();

        RouteOuterClass.RouteOrBuilder getRouteOrBuilder();

        int getEntityId();
    }

    private AvatarFollowRouteNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFollowRouteNotifyOuterClass$AvatarFollowRouteNotify.class */
    public static final class AvatarFollowRouteNotify extends GeneratedMessageV3 implements AvatarFollowRouteNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STARTSCENETIMEMS_FIELD_NUMBER = 6;
        private int startSceneTimeMs_;
        public static final int TEMPLATEID_FIELD_NUMBER = 2;
        private int templateId_;
        public static final int CLIENTPARAMS_FIELD_NUMBER = 10;
        private volatile Object clientParams_;
        public static final int ROUTE_FIELD_NUMBER = 4;
        private RouteOuterClass.Route route_;
        public static final int ENTITYID_FIELD_NUMBER = 1;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final AvatarFollowRouteNotify DEFAULT_INSTANCE = new AvatarFollowRouteNotify();
        private static final Parser<AvatarFollowRouteNotify> PARSER = new AbstractParser<AvatarFollowRouteNotify>() { // from class: emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotify.1
            @Override // com.google.protobuf.Parser
            public AvatarFollowRouteNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarFollowRouteNotify(input, extensionRegistry);
            }
        };

        private AvatarFollowRouteNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AvatarFollowRouteNotify() {
            this.memoizedIsInitialized = -1;
            this.clientParams_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarFollowRouteNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarFollowRouteNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                this.entityId_ = input.readUInt32();
                                break;
                            case 16:
                                this.templateId_ = input.readUInt32();
                                break;
                            case 34:
                                RouteOuterClass.Route.Builder subBuilder = this.route_ != null ? this.route_.toBuilder() : null;
                                this.route_ = (RouteOuterClass.Route) input.readMessage(RouteOuterClass.Route.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.route_);
                                    this.route_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 48:
                                this.startSceneTimeMs_ = input.readUInt32();
                                break;
                            case 82:
                                this.clientParams_ = input.readStringRequireUtf8();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarFollowRouteNotifyOuterClass.internal_static_AvatarFollowRouteNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarFollowRouteNotifyOuterClass.internal_static_AvatarFollowRouteNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFollowRouteNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public int getStartSceneTimeMs() {
            return this.startSceneTimeMs_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public int getTemplateId() {
            return this.templateId_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public String getClientParams() {
            Object ref = this.clientParams_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientParams_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public ByteString getClientParamsBytes() {
            Object ref = this.clientParams_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientParams_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public boolean hasRoute() {
            return this.route_ != null;
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public RouteOuterClass.Route getRoute() {
            return this.route_ == null ? RouteOuterClass.Route.getDefaultInstance() : this.route_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public RouteOuterClass.RouteOrBuilder getRouteOrBuilder() {
            return getRoute();
        }

        @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
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
            if (this.entityId_ != 0) {
                output.writeUInt32(1, this.entityId_);
            }
            if (this.templateId_ != 0) {
                output.writeUInt32(2, this.templateId_);
            }
            if (this.route_ != null) {
                output.writeMessage(4, getRoute());
            }
            if (this.startSceneTimeMs_ != 0) {
                output.writeUInt32(6, this.startSceneTimeMs_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientParams_)) {
                GeneratedMessageV3.writeString(output, 10, this.clientParams_);
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.entityId_);
            }
            if (this.templateId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.templateId_);
            }
            if (this.route_ != null) {
                size2 += CodedOutputStream.computeMessageSize(4, getRoute());
            }
            if (this.startSceneTimeMs_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.startSceneTimeMs_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientParams_)) {
                size2 += GeneratedMessageV3.computeStringSize(10, this.clientParams_);
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
            if (!(obj instanceof AvatarFollowRouteNotify)) {
                return equals(obj);
            }
            AvatarFollowRouteNotify other = (AvatarFollowRouteNotify) obj;
            if (getStartSceneTimeMs() == other.getStartSceneTimeMs() && getTemplateId() == other.getTemplateId() && getClientParams().equals(other.getClientParams()) && hasRoute() == other.hasRoute()) {
                return (!hasRoute() || getRoute().equals(other.getRoute())) && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getStartSceneTimeMs())) + 2)) + getTemplateId())) + 10)) + getClientParams().hashCode();
            if (hasRoute()) {
                hash = (53 * ((37 * hash) + 4)) + getRoute().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 1)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarFollowRouteNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFollowRouteNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFollowRouteNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFollowRouteNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFollowRouteNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFollowRouteNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFollowRouteNotify parseFrom(InputStream input) throws IOException {
            return (AvatarFollowRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFollowRouteNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFollowRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFollowRouteNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarFollowRouteNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarFollowRouteNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFollowRouteNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFollowRouteNotify parseFrom(CodedInputStream input) throws IOException {
            return (AvatarFollowRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFollowRouteNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFollowRouteNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarFollowRouteNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFollowRouteNotifyOuterClass$AvatarFollowRouteNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarFollowRouteNotifyOrBuilder {
            private int startSceneTimeMs_;
            private int templateId_;
            private Object clientParams_ = "";
            private RouteOuterClass.Route route_;
            private SingleFieldBuilderV3<RouteOuterClass.Route, RouteOuterClass.Route.Builder, RouteOuterClass.RouteOrBuilder> routeBuilder_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarFollowRouteNotifyOuterClass.internal_static_AvatarFollowRouteNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarFollowRouteNotifyOuterClass.internal_static_AvatarFollowRouteNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFollowRouteNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarFollowRouteNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.startSceneTimeMs_ = 0;
                this.templateId_ = 0;
                this.clientParams_ = "";
                if (this.routeBuilder_ == null) {
                    this.route_ = null;
                } else {
                    this.route_ = null;
                    this.routeBuilder_ = null;
                }
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarFollowRouteNotifyOuterClass.internal_static_AvatarFollowRouteNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarFollowRouteNotify getDefaultInstanceForType() {
                return AvatarFollowRouteNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFollowRouteNotify build() {
                AvatarFollowRouteNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFollowRouteNotify buildPartial() {
                AvatarFollowRouteNotify result = new AvatarFollowRouteNotify(this);
                result.startSceneTimeMs_ = this.startSceneTimeMs_;
                result.templateId_ = this.templateId_;
                result.clientParams_ = this.clientParams_;
                if (this.routeBuilder_ == null) {
                    result.route_ = this.route_;
                } else {
                    result.route_ = this.routeBuilder_.build();
                }
                result.entityId_ = this.entityId_;
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
                if (other instanceof AvatarFollowRouteNotify) {
                    return mergeFrom((AvatarFollowRouteNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarFollowRouteNotify other) {
                if (other == AvatarFollowRouteNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getStartSceneTimeMs() != 0) {
                    setStartSceneTimeMs(other.getStartSceneTimeMs());
                }
                if (other.getTemplateId() != 0) {
                    setTemplateId(other.getTemplateId());
                }
                if (!other.getClientParams().isEmpty()) {
                    this.clientParams_ = other.clientParams_;
                    onChanged();
                }
                if (other.hasRoute()) {
                    mergeRoute(other.getRoute());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                AvatarFollowRouteNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarFollowRouteNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarFollowRouteNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public int getStartSceneTimeMs() {
                return this.startSceneTimeMs_;
            }

            public Builder setStartSceneTimeMs(int value) {
                this.startSceneTimeMs_ = value;
                onChanged();
                return this;
            }

            public Builder clearStartSceneTimeMs() {
                this.startSceneTimeMs_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public int getTemplateId() {
                return this.templateId_;
            }

            public Builder setTemplateId(int value) {
                this.templateId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTemplateId() {
                this.templateId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public String getClientParams() {
                Object ref = this.clientParams_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientParams_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public ByteString getClientParamsBytes() {
                Object ref = this.clientParams_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientParams_ = b;
                return b;
            }

            public Builder setClientParams(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientParams_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientParams() {
                this.clientParams_ = AvatarFollowRouteNotify.getDefaultInstance().getClientParams();
                onChanged();
                return this;
            }

            public Builder setClientParamsBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AvatarFollowRouteNotify.checkByteStringIsUtf8(value);
                this.clientParams_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public boolean hasRoute() {
                return (this.routeBuilder_ == null && this.route_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public RouteOuterClass.Route getRoute() {
                if (this.routeBuilder_ == null) {
                    return this.route_ == null ? RouteOuterClass.Route.getDefaultInstance() : this.route_;
                }
                return this.routeBuilder_.getMessage();
            }

            public Builder setRoute(RouteOuterClass.Route value) {
                if (this.routeBuilder_ != null) {
                    this.routeBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.route_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRoute(RouteOuterClass.Route.Builder builderForValue) {
                if (this.routeBuilder_ == null) {
                    this.route_ = builderForValue.build();
                    onChanged();
                } else {
                    this.routeBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRoute(RouteOuterClass.Route value) {
                if (this.routeBuilder_ == null) {
                    if (this.route_ != null) {
                        this.route_ = RouteOuterClass.Route.newBuilder(this.route_).mergeFrom(value).buildPartial();
                    } else {
                        this.route_ = value;
                    }
                    onChanged();
                } else {
                    this.routeBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRoute() {
                if (this.routeBuilder_ == null) {
                    this.route_ = null;
                    onChanged();
                } else {
                    this.route_ = null;
                    this.routeBuilder_ = null;
                }
                return this;
            }

            public RouteOuterClass.Route.Builder getRouteBuilder() {
                onChanged();
                return getRouteFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public RouteOuterClass.RouteOrBuilder getRouteOrBuilder() {
                if (this.routeBuilder_ != null) {
                    return this.routeBuilder_.getMessageOrBuilder();
                }
                return this.route_ == null ? RouteOuterClass.Route.getDefaultInstance() : this.route_;
            }

            private SingleFieldBuilderV3<RouteOuterClass.Route, RouteOuterClass.Route.Builder, RouteOuterClass.RouteOrBuilder> getRouteFieldBuilder() {
                if (this.routeBuilder_ == null) {
                    this.routeBuilder_ = new SingleFieldBuilderV3<>(getRoute(), getParentForChildren(), isClean());
                    this.route_ = null;
                }
                return this.routeBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AvatarFollowRouteNotifyOuterClass.AvatarFollowRouteNotifyOrBuilder
            public int getEntityId() {
                return this.entityId_;
            }

            public Builder setEntityId(int value) {
                this.entityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEntityId() {
                this.entityId_ = 0;
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

        public static AvatarFollowRouteNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarFollowRouteNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarFollowRouteNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarFollowRouteNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RouteOuterClass.getDescriptor();
    }
}
