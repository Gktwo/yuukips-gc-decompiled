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
import emu.grasscutter.net.proto.RoutePointOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterRouteOuterClass.class */
public final class MonsterRouteOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012MonsterRoute.proto\u001a\u0010RoutePoint.proto\"p\n\fMonsterRoute\u0012!\n\froute_points\u0018\u0001 \u0003(\u000b2\u000b.RoutePoint\u0012\u0013\n\u000bspeed_level\u0018\u0002 \u0001(\r\u0012\u0012\n\nroute_type\u0018\u0003 \u0001(\r\u0012\u0014\n\farrive_range\u0018\u0004 \u0001(\u0002B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RoutePointOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MonsterRoute_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MonsterRoute_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MonsterRoute_descriptor, new String[]{"RoutePoints", "SpeedLevel", "RouteType", "ArriveRange"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterRouteOuterClass$MonsterRouteOrBuilder.class */
    public interface MonsterRouteOrBuilder extends MessageOrBuilder {
        List<RoutePointOuterClass.RoutePoint> getRoutePointsList();

        RoutePointOuterClass.RoutePoint getRoutePoints(int i);

        int getRoutePointsCount();

        List<? extends RoutePointOuterClass.RoutePointOrBuilder> getRoutePointsOrBuilderList();

        RoutePointOuterClass.RoutePointOrBuilder getRoutePointsOrBuilder(int i);

        int getSpeedLevel();

        int getRouteType();

        float getArriveRange();
    }

    private MonsterRouteOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterRouteOuterClass$MonsterRoute.class */
    public static final class MonsterRoute extends GeneratedMessageV3 implements MonsterRouteOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ROUTE_POINTS_FIELD_NUMBER = 1;
        private List<RoutePointOuterClass.RoutePoint> routePoints_;
        public static final int SPEED_LEVEL_FIELD_NUMBER = 2;
        private int speedLevel_;
        public static final int ROUTE_TYPE_FIELD_NUMBER = 3;
        private int routeType_;
        public static final int ARRIVE_RANGE_FIELD_NUMBER = 4;
        private float arriveRange_;
        private byte memoizedIsInitialized;
        private static final MonsterRoute DEFAULT_INSTANCE = new MonsterRoute();
        private static final Parser<MonsterRoute> PARSER = new AbstractParser<MonsterRoute>() { // from class: emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRoute.1
            @Override // com.google.protobuf.Parser
            public MonsterRoute parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MonsterRoute(input, extensionRegistry);
            }
        };

        private MonsterRoute(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MonsterRoute() {
            this.memoizedIsInitialized = -1;
            this.routePoints_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MonsterRoute();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MonsterRoute(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.routePoints_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.routePoints_.add((RoutePointOuterClass.RoutePoint) input.readMessage(RoutePointOuterClass.RoutePoint.parser(), extensionRegistry));
                                break;
                            case 16:
                                this.speedLevel_ = input.readUInt32();
                                break;
                            case 24:
                                this.routeType_ = input.readUInt32();
                                break;
                            case 37:
                                this.arriveRange_ = input.readFloat();
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
                    this.routePoints_ = Collections.unmodifiableList(this.routePoints_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MonsterRouteOuterClass.internal_static_MonsterRoute_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MonsterRouteOuterClass.internal_static_MonsterRoute_fieldAccessorTable.ensureFieldAccessorsInitialized(MonsterRoute.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public List<RoutePointOuterClass.RoutePoint> getRoutePointsList() {
            return this.routePoints_;
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public List<? extends RoutePointOuterClass.RoutePointOrBuilder> getRoutePointsOrBuilderList() {
            return this.routePoints_;
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public int getRoutePointsCount() {
            return this.routePoints_.size();
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public RoutePointOuterClass.RoutePoint getRoutePoints(int index) {
            return this.routePoints_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public RoutePointOuterClass.RoutePointOrBuilder getRoutePointsOrBuilder(int index) {
            return this.routePoints_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public int getSpeedLevel() {
            return this.speedLevel_;
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public int getRouteType() {
            return this.routeType_;
        }

        @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
        public float getArriveRange() {
            return this.arriveRange_;
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
            for (int i = 0; i < this.routePoints_.size(); i++) {
                output.writeMessage(1, this.routePoints_.get(i));
            }
            if (this.speedLevel_ != 0) {
                output.writeUInt32(2, this.speedLevel_);
            }
            if (this.routeType_ != 0) {
                output.writeUInt32(3, this.routeType_);
            }
            if (this.arriveRange_ != 0.0f) {
                output.writeFloat(4, this.arriveRange_);
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
            for (int i = 0; i < this.routePoints_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.routePoints_.get(i));
            }
            if (this.speedLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.speedLevel_);
            }
            if (this.routeType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.routeType_);
            }
            if (this.arriveRange_ != 0.0f) {
                size2 += CodedOutputStream.computeFloatSize(4, this.arriveRange_);
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
            if (!(obj instanceof MonsterRoute)) {
                return equals(obj);
            }
            MonsterRoute other = (MonsterRoute) obj;
            return getRoutePointsList().equals(other.getRoutePointsList()) && getSpeedLevel() == other.getSpeedLevel() && getRouteType() == other.getRouteType() && Float.floatToIntBits(getArriveRange()) == Float.floatToIntBits(other.getArriveRange()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRoutePointsCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getRoutePointsList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getSpeedLevel())) + 3)) + getRouteType())) + 4)) + Float.floatToIntBits(getArriveRange()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MonsterRoute parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterRoute parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterRoute parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterRoute parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterRoute parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MonsterRoute parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MonsterRoute parseFrom(InputStream input) throws IOException {
            return (MonsterRoute) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MonsterRoute parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterRoute) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MonsterRoute parseDelimitedFrom(InputStream input) throws IOException {
            return (MonsterRoute) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MonsterRoute parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterRoute) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MonsterRoute parseFrom(CodedInputStream input) throws IOException {
            return (MonsterRoute) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MonsterRoute parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MonsterRoute) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MonsterRoute prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MonsterRouteOuterClass$MonsterRoute$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MonsterRouteOrBuilder {
            private int bitField0_;
            private List<RoutePointOuterClass.RoutePoint> routePoints_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<RoutePointOuterClass.RoutePoint, RoutePointOuterClass.RoutePoint.Builder, RoutePointOuterClass.RoutePointOrBuilder> routePointsBuilder_;
            private int speedLevel_;
            private int routeType_;
            private float arriveRange_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MonsterRouteOuterClass.internal_static_MonsterRoute_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MonsterRouteOuterClass.internal_static_MonsterRoute_fieldAccessorTable.ensureFieldAccessorsInitialized(MonsterRoute.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MonsterRoute.alwaysUseFieldBuilders) {
                    getRoutePointsFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.routePointsBuilder_ == null) {
                    this.routePoints_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.routePointsBuilder_.clear();
                }
                this.speedLevel_ = 0;
                this.routeType_ = 0;
                this.arriveRange_ = 0.0f;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MonsterRouteOuterClass.internal_static_MonsterRoute_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MonsterRoute getDefaultInstanceForType() {
                return MonsterRoute.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonsterRoute build() {
                MonsterRoute result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MonsterRoute buildPartial() {
                MonsterRoute result = new MonsterRoute(this);
                int i = this.bitField0_;
                if (this.routePointsBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.routePoints_ = Collections.unmodifiableList(this.routePoints_);
                        this.bitField0_ &= -2;
                    }
                    result.routePoints_ = this.routePoints_;
                } else {
                    result.routePoints_ = this.routePointsBuilder_.build();
                }
                result.speedLevel_ = this.speedLevel_;
                result.routeType_ = this.routeType_;
                result.arriveRange_ = this.arriveRange_;
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
                if (other instanceof MonsterRoute) {
                    return mergeFrom((MonsterRoute) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MonsterRoute other) {
                if (other == MonsterRoute.getDefaultInstance()) {
                    return this;
                }
                if (this.routePointsBuilder_ == null) {
                    if (!other.routePoints_.isEmpty()) {
                        if (this.routePoints_.isEmpty()) {
                            this.routePoints_ = other.routePoints_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRoutePointsIsMutable();
                            this.routePoints_.addAll(other.routePoints_);
                        }
                        onChanged();
                    }
                } else if (!other.routePoints_.isEmpty()) {
                    if (this.routePointsBuilder_.isEmpty()) {
                        this.routePointsBuilder_.dispose();
                        this.routePointsBuilder_ = null;
                        this.routePoints_ = other.routePoints_;
                        this.bitField0_ &= -2;
                        this.routePointsBuilder_ = MonsterRoute.alwaysUseFieldBuilders ? getRoutePointsFieldBuilder() : null;
                    } else {
                        this.routePointsBuilder_.addAllMessages(other.routePoints_);
                    }
                }
                if (other.getSpeedLevel() != 0) {
                    setSpeedLevel(other.getSpeedLevel());
                }
                if (other.getRouteType() != 0) {
                    setRouteType(other.getRouteType());
                }
                if (other.getArriveRange() != 0.0f) {
                    setArriveRange(other.getArriveRange());
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
                MonsterRoute parsedMessage = null;
                try {
                    try {
                        parsedMessage = MonsterRoute.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MonsterRoute) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRoutePointsIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.routePoints_ = new ArrayList(this.routePoints_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public List<RoutePointOuterClass.RoutePoint> getRoutePointsList() {
                if (this.routePointsBuilder_ == null) {
                    return Collections.unmodifiableList(this.routePoints_);
                }
                return this.routePointsBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public int getRoutePointsCount() {
                if (this.routePointsBuilder_ == null) {
                    return this.routePoints_.size();
                }
                return this.routePointsBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public RoutePointOuterClass.RoutePoint getRoutePoints(int index) {
                if (this.routePointsBuilder_ == null) {
                    return this.routePoints_.get(index);
                }
                return this.routePointsBuilder_.getMessage(index);
            }

            public Builder setRoutePoints(int index, RoutePointOuterClass.RoutePoint value) {
                if (this.routePointsBuilder_ != null) {
                    this.routePointsBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRoutePointsIsMutable();
                    this.routePoints_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRoutePoints(int index, RoutePointOuterClass.RoutePoint.Builder builderForValue) {
                if (this.routePointsBuilder_ == null) {
                    ensureRoutePointsIsMutable();
                    this.routePoints_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.routePointsBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRoutePoints(RoutePointOuterClass.RoutePoint value) {
                if (this.routePointsBuilder_ != null) {
                    this.routePointsBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRoutePointsIsMutable();
                    this.routePoints_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRoutePoints(int index, RoutePointOuterClass.RoutePoint value) {
                if (this.routePointsBuilder_ != null) {
                    this.routePointsBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRoutePointsIsMutable();
                    this.routePoints_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRoutePoints(RoutePointOuterClass.RoutePoint.Builder builderForValue) {
                if (this.routePointsBuilder_ == null) {
                    ensureRoutePointsIsMutable();
                    this.routePoints_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.routePointsBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRoutePoints(int index, RoutePointOuterClass.RoutePoint.Builder builderForValue) {
                if (this.routePointsBuilder_ == null) {
                    ensureRoutePointsIsMutable();
                    this.routePoints_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.routePointsBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRoutePoints(Iterable<? extends RoutePointOuterClass.RoutePoint> values) {
                if (this.routePointsBuilder_ == null) {
                    ensureRoutePointsIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.routePoints_);
                    onChanged();
                } else {
                    this.routePointsBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRoutePoints() {
                if (this.routePointsBuilder_ == null) {
                    this.routePoints_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.routePointsBuilder_.clear();
                }
                return this;
            }

            public Builder removeRoutePoints(int index) {
                if (this.routePointsBuilder_ == null) {
                    ensureRoutePointsIsMutable();
                    this.routePoints_.remove(index);
                    onChanged();
                } else {
                    this.routePointsBuilder_.remove(index);
                }
                return this;
            }

            public RoutePointOuterClass.RoutePoint.Builder getRoutePointsBuilder(int index) {
                return getRoutePointsFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public RoutePointOuterClass.RoutePointOrBuilder getRoutePointsOrBuilder(int index) {
                if (this.routePointsBuilder_ == null) {
                    return this.routePoints_.get(index);
                }
                return this.routePointsBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public List<? extends RoutePointOuterClass.RoutePointOrBuilder> getRoutePointsOrBuilderList() {
                if (this.routePointsBuilder_ != null) {
                    return this.routePointsBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.routePoints_);
            }

            public RoutePointOuterClass.RoutePoint.Builder addRoutePointsBuilder() {
                return getRoutePointsFieldBuilder().addBuilder(RoutePointOuterClass.RoutePoint.getDefaultInstance());
            }

            public RoutePointOuterClass.RoutePoint.Builder addRoutePointsBuilder(int index) {
                return getRoutePointsFieldBuilder().addBuilder(index, RoutePointOuterClass.RoutePoint.getDefaultInstance());
            }

            public List<RoutePointOuterClass.RoutePoint.Builder> getRoutePointsBuilderList() {
                return getRoutePointsFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RoutePointOuterClass.RoutePoint, RoutePointOuterClass.RoutePoint.Builder, RoutePointOuterClass.RoutePointOrBuilder> getRoutePointsFieldBuilder() {
                if (this.routePointsBuilder_ == null) {
                    this.routePointsBuilder_ = new RepeatedFieldBuilderV3<>(this.routePoints_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.routePoints_ = null;
                }
                return this.routePointsBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public int getSpeedLevel() {
                return this.speedLevel_;
            }

            public Builder setSpeedLevel(int value) {
                this.speedLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearSpeedLevel() {
                this.speedLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public int getRouteType() {
                return this.routeType_;
            }

            public Builder setRouteType(int value) {
                this.routeType_ = value;
                onChanged();
                return this;
            }

            public Builder clearRouteType() {
                this.routeType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MonsterRouteOuterClass.MonsterRouteOrBuilder
            public float getArriveRange() {
                return this.arriveRange_;
            }

            public Builder setArriveRange(float value) {
                this.arriveRange_ = value;
                onChanged();
                return this;
            }

            public Builder clearArriveRange() {
                this.arriveRange_ = 0.0f;
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

        public static MonsterRoute getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MonsterRoute> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MonsterRoute> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MonsterRoute getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RoutePointOuterClass.getDescriptor();
    }
}
