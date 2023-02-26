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
import emu.grasscutter.net.proto.MapMarkFromTypeOuterClass;
import emu.grasscutter.net.proto.MapMarkPointTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkPointOuterClass.class */
public final class MapMarkPointOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012MapMarkPoint.proto\u001a\fVector.proto\u001a\u0016MapMarkPointType.proto\u001a\u0015MapMarkFromType.proto\"±\u0001\n\fMapMarkPoint\u0012\u000f\n\u0007sceneId\u0018\u0001 \u0001(\r\u0012\f\n\u0004name\u0018\u0002 \u0001(\t\u0012\u0014\n\u0003pos\u0018\u0003 \u0001(\u000b2\u0007.Vector\u0012$\n\tpointType\u0018\u0004 \u0001(\u000e2\u0011.MapMarkPointType\u0012\u0011\n\tmonsterId\u0018\u0005 \u0001(\r\u0012\"\n\bfromType\u0018\u0006 \u0001(\u000e2\u0010.MapMarkFromType\u0012\u000f\n\u0007questId\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor(), MapMarkPointTypeOuterClass.getDescriptor(), MapMarkFromTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MapMarkPoint_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MapMarkPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MapMarkPoint_descriptor, new String[]{"SceneId", "Name", "Pos", "PointType", "MonsterId", "FromType", "QuestId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkPointOuterClass$MapMarkPointOrBuilder.class */
    public interface MapMarkPointOrBuilder extends MessageOrBuilder {
        int getSceneId();

        String getName();

        ByteString getNameBytes();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getPointTypeValue();

        MapMarkPointTypeOuterClass.MapMarkPointType getPointType();

        int getMonsterId();

        int getFromTypeValue();

        MapMarkFromTypeOuterClass.MapMarkFromType getFromType();

        int getQuestId();
    }

    private MapMarkPointOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkPointOuterClass$MapMarkPoint.class */
    public static final class MapMarkPoint extends GeneratedMessageV3 implements MapMarkPointOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENEID_FIELD_NUMBER = 1;
        private int sceneId_;
        public static final int NAME_FIELD_NUMBER = 2;
        private volatile Object name_;
        public static final int POS_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector pos_;
        public static final int POINTTYPE_FIELD_NUMBER = 4;
        private int pointType_;
        public static final int MONSTERID_FIELD_NUMBER = 5;
        private int monsterId_;
        public static final int FROMTYPE_FIELD_NUMBER = 6;
        private int fromType_;
        public static final int QUESTID_FIELD_NUMBER = 7;
        private int questId_;
        private byte memoizedIsInitialized;
        private static final MapMarkPoint DEFAULT_INSTANCE = new MapMarkPoint();
        private static final Parser<MapMarkPoint> PARSER = new AbstractParser<MapMarkPoint>() { // from class: emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPoint.1
            @Override // com.google.protobuf.Parser
            public MapMarkPoint parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MapMarkPoint(input, extensionRegistry);
            }
        };

        private MapMarkPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MapMarkPoint() {
            this.memoizedIsInitialized = -1;
            this.name_ = "";
            this.pointType_ = 0;
            this.fromType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MapMarkPoint();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MapMarkPoint(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 18:
                                this.name_ = input.readStringRequireUtf8();
                                break;
                            case 26:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 32:
                                this.pointType_ = input.readEnum();
                                break;
                            case 40:
                                this.monsterId_ = input.readUInt32();
                                break;
                            case 48:
                                this.fromType_ = input.readEnum();
                                break;
                            case 56:
                                this.questId_ = input.readUInt32();
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
            return MapMarkPointOuterClass.internal_static_MapMarkPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MapMarkPointOuterClass.internal_static_MapMarkPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(MapMarkPoint.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.name_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public int getPointTypeValue() {
            return this.pointType_;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public MapMarkPointTypeOuterClass.MapMarkPointType getPointType() {
            MapMarkPointTypeOuterClass.MapMarkPointType result = MapMarkPointTypeOuterClass.MapMarkPointType.valueOf(this.pointType_);
            return result == null ? MapMarkPointTypeOuterClass.MapMarkPointType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public int getMonsterId() {
            return this.monsterId_;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public int getFromTypeValue() {
            return this.fromType_;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public MapMarkFromTypeOuterClass.MapMarkFromType getFromType() {
            MapMarkFromTypeOuterClass.MapMarkFromType result = MapMarkFromTypeOuterClass.MapMarkFromType.valueOf(this.fromType_);
            return result == null ? MapMarkFromTypeOuterClass.MapMarkFromType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
        public int getQuestId() {
            return this.questId_;
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
            if (this.sceneId_ != 0) {
                output.writeUInt32(1, this.sceneId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                GeneratedMessageV3.writeString(output, 2, this.name_);
            }
            if (this.pos_ != null) {
                output.writeMessage(3, getPos());
            }
            if (this.pointType_ != MapMarkPointTypeOuterClass.MapMarkPointType.MAP_MARK_POINT_TYPE_NPC.getNumber()) {
                output.writeEnum(4, this.pointType_);
            }
            if (this.monsterId_ != 0) {
                output.writeUInt32(5, this.monsterId_);
            }
            if (this.fromType_ != MapMarkFromTypeOuterClass.MapMarkFromType.MAP_MARK_FROM_TYPE_NONE.getNumber()) {
                output.writeEnum(6, this.fromType_);
            }
            if (this.questId_ != 0) {
                output.writeUInt32(7, this.questId_);
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
            if (this.sceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.sceneId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.name_)) {
                size2 += GeneratedMessageV3.computeStringSize(2, this.name_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getPos());
            }
            if (this.pointType_ != MapMarkPointTypeOuterClass.MapMarkPointType.MAP_MARK_POINT_TYPE_NPC.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(4, this.pointType_);
            }
            if (this.monsterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.monsterId_);
            }
            if (this.fromType_ != MapMarkFromTypeOuterClass.MapMarkFromType.MAP_MARK_FROM_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.fromType_);
            }
            if (this.questId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.questId_);
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
            if (!(obj instanceof MapMarkPoint)) {
                return equals(obj);
            }
            MapMarkPoint other = (MapMarkPoint) obj;
            if (getSceneId() == other.getSceneId() && getName().equals(other.getName()) && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && this.pointType_ == other.pointType_ && getMonsterId() == other.getMonsterId() && this.fromType_ == other.fromType_ && getQuestId() == other.getQuestId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getSceneId())) + 2)) + getName().hashCode();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 3)) + getPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + this.pointType_)) + 5)) + getMonsterId())) + 6)) + this.fromType_)) + 7)) + getQuestId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MapMarkPoint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MapMarkPoint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MapMarkPoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MapMarkPoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MapMarkPoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MapMarkPoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MapMarkPoint parseFrom(InputStream input) throws IOException {
            return (MapMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MapMarkPoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MapMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MapMarkPoint parseDelimitedFrom(InputStream input) throws IOException {
            return (MapMarkPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MapMarkPoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MapMarkPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MapMarkPoint parseFrom(CodedInputStream input) throws IOException {
            return (MapMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MapMarkPoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MapMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MapMarkPoint prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MapMarkPointOuterClass$MapMarkPoint$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MapMarkPointOrBuilder {
            private int sceneId_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int monsterId_;
            private int questId_;
            private Object name_ = "";
            private int pointType_ = 0;
            private int fromType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return MapMarkPointOuterClass.internal_static_MapMarkPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MapMarkPointOuterClass.internal_static_MapMarkPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(MapMarkPoint.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MapMarkPoint.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneId_ = 0;
                this.name_ = "";
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.pointType_ = 0;
                this.monsterId_ = 0;
                this.fromType_ = 0;
                this.questId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MapMarkPointOuterClass.internal_static_MapMarkPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MapMarkPoint getDefaultInstanceForType() {
                return MapMarkPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MapMarkPoint build() {
                MapMarkPoint result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MapMarkPoint buildPartial() {
                MapMarkPoint result = new MapMarkPoint(this);
                result.sceneId_ = this.sceneId_;
                result.name_ = this.name_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.pointType_ = this.pointType_;
                result.monsterId_ = this.monsterId_;
                result.fromType_ = this.fromType_;
                result.questId_ = this.questId_;
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
                if (other instanceof MapMarkPoint) {
                    return mergeFrom((MapMarkPoint) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MapMarkPoint other) {
                if (other == MapMarkPoint.getDefaultInstance()) {
                    return this;
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (!other.getName().isEmpty()) {
                    this.name_ = other.name_;
                    onChanged();
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.pointType_ != 0) {
                    setPointTypeValue(other.getPointTypeValue());
                }
                if (other.getMonsterId() != 0) {
                    setMonsterId(other.getMonsterId());
                }
                if (other.fromType_ != 0) {
                    setFromTypeValue(other.getFromTypeValue());
                }
                if (other.getQuestId() != 0) {
                    setQuestId(other.getQuestId());
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
                MapMarkPoint parsedMessage = null;
                try {
                    try {
                        parsedMessage = MapMarkPoint.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MapMarkPoint) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
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

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public ByteString getNameBytes() {
                Object ref = this.name_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.name_ = b;
                return b;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.name_ = MapMarkPoint.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                MapMarkPoint.checkByteStringIsUtf8(value);
                this.name_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public VectorOuterClass.Vector getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = VectorOuterClass.Vector.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public int getPointTypeValue() {
                return this.pointType_;
            }

            public Builder setPointTypeValue(int value) {
                this.pointType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public MapMarkPointTypeOuterClass.MapMarkPointType getPointType() {
                MapMarkPointTypeOuterClass.MapMarkPointType result = MapMarkPointTypeOuterClass.MapMarkPointType.valueOf(this.pointType_);
                return result == null ? MapMarkPointTypeOuterClass.MapMarkPointType.UNRECOGNIZED : result;
            }

            public Builder setPointType(MapMarkPointTypeOuterClass.MapMarkPointType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.pointType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearPointType() {
                this.pointType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public int getMonsterId() {
                return this.monsterId_;
            }

            public Builder setMonsterId(int value) {
                this.monsterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMonsterId() {
                this.monsterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public int getFromTypeValue() {
                return this.fromType_;
            }

            public Builder setFromTypeValue(int value) {
                this.fromType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public MapMarkFromTypeOuterClass.MapMarkFromType getFromType() {
                MapMarkFromTypeOuterClass.MapMarkFromType result = MapMarkFromTypeOuterClass.MapMarkFromType.valueOf(this.fromType_);
                return result == null ? MapMarkFromTypeOuterClass.MapMarkFromType.UNRECOGNIZED : result;
            }

            public Builder setFromType(MapMarkFromTypeOuterClass.MapMarkFromType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.fromType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearFromType() {
                this.fromType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MapMarkPointOuterClass.MapMarkPointOrBuilder
            public int getQuestId() {
                return this.questId_;
            }

            public Builder setQuestId(int value) {
                this.questId_ = value;
                onChanged();
                return this;
            }

            public Builder clearQuestId() {
                this.questId_ = 0;
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

        public static MapMarkPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MapMarkPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MapMarkPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MapMarkPoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
        MapMarkPointTypeOuterClass.getDescriptor();
        MapMarkFromTypeOuterClass.getDescriptor();
    }
}
