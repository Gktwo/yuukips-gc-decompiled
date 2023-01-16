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
import emu.grasscutter.net.proto.PlayerLocationInfoOuterClass;
import emu.grasscutter.net.proto.VehicleLocationInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerLocationNotifyOuterClass.class */
public final class ScenePlayerLocationNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fScenePlayerLocationNotify.proto\u001a\u0018PlayerLocationInfo.proto\u001a\u0019VehicleLocationInfo.proto\"\u0001\n\u0019ScenePlayerLocationNotify\u0012\u0010\n\bscene_id\u0018\u000b \u0001(\r\u0012.\n\u0010vehicle_loc_list\u0018\u0006 \u0003(\u000b2\u0014.VehicleLocationInfo\u0012,\n\u000fplayer_loc_list\u0018\u0004 \u0003(\u000b2\u0013.PlayerLocationInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerLocationInfoOuterClass.getDescriptor(), VehicleLocationInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ScenePlayerLocationNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ScenePlayerLocationNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ScenePlayerLocationNotify_descriptor, new String[]{"SceneId", "VehicleLocList", "PlayerLocList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerLocationNotifyOuterClass$ScenePlayerLocationNotifyOrBuilder.class */
    public interface ScenePlayerLocationNotifyOrBuilder extends MessageOrBuilder {
        int getSceneId();

        List<VehicleLocationInfoOuterClass.VehicleLocationInfo> getVehicleLocListList();

        VehicleLocationInfoOuterClass.VehicleLocationInfo getVehicleLocList(int i);

        int getVehicleLocListCount();

        List<? extends VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder> getVehicleLocListOrBuilderList();

        VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder getVehicleLocListOrBuilder(int i);

        List<PlayerLocationInfoOuterClass.PlayerLocationInfo> getPlayerLocListList();

        PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLocList(int i);

        int getPlayerLocListCount();

        List<? extends PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListOrBuilderList();

        PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocListOrBuilder(int i);
    }

    private ScenePlayerLocationNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerLocationNotifyOuterClass$ScenePlayerLocationNotify.class */
    public static final class ScenePlayerLocationNotify extends GeneratedMessageV3 implements ScenePlayerLocationNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SCENE_ID_FIELD_NUMBER = 11;
        private int sceneId_;
        public static final int VEHICLE_LOC_LIST_FIELD_NUMBER = 6;
        private List<VehicleLocationInfoOuterClass.VehicleLocationInfo> vehicleLocList_;
        public static final int PLAYER_LOC_LIST_FIELD_NUMBER = 4;
        private List<PlayerLocationInfoOuterClass.PlayerLocationInfo> playerLocList_;
        private byte memoizedIsInitialized;
        private static final ScenePlayerLocationNotify DEFAULT_INSTANCE = new ScenePlayerLocationNotify();
        private static final Parser<ScenePlayerLocationNotify> PARSER = new AbstractParser<ScenePlayerLocationNotify>() { // from class: emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotify.1
            @Override // com.google.protobuf.Parser
            public ScenePlayerLocationNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ScenePlayerLocationNotify(input, extensionRegistry);
            }
        };

        private ScenePlayerLocationNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ScenePlayerLocationNotify() {
            this.memoizedIsInitialized = -1;
            this.vehicleLocList_ = Collections.emptyList();
            this.playerLocList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ScenePlayerLocationNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x00cb */
        private ScenePlayerLocationNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.playerLocList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.playerLocList_.add((PlayerLocationInfoOuterClass.PlayerLocationInfo) input.readMessage(PlayerLocationInfoOuterClass.PlayerLocationInfo.parser(), extensionRegistry));
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.vehicleLocList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.vehicleLocList_.add((VehicleLocationInfoOuterClass.VehicleLocationInfo) input.readMessage(VehicleLocationInfoOuterClass.VehicleLocationInfo.parser(), extensionRegistry));
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
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.playerLocList_ = Collections.unmodifiableList(this.playerLocList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.vehicleLocList_ = Collections.unmodifiableList(this.vehicleLocList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ScenePlayerLocationNotifyOuterClass.internal_static_ScenePlayerLocationNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ScenePlayerLocationNotifyOuterClass.internal_static_ScenePlayerLocationNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePlayerLocationNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public List<VehicleLocationInfoOuterClass.VehicleLocationInfo> getVehicleLocListList() {
            return this.vehicleLocList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public List<? extends VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder> getVehicleLocListOrBuilderList() {
            return this.vehicleLocList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public int getVehicleLocListCount() {
            return this.vehicleLocList_.size();
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public VehicleLocationInfoOuterClass.VehicleLocationInfo getVehicleLocList(int index) {
            return this.vehicleLocList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder getVehicleLocListOrBuilder(int index) {
            return this.vehicleLocList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public List<PlayerLocationInfoOuterClass.PlayerLocationInfo> getPlayerLocListList() {
            return this.playerLocList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public List<? extends PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListOrBuilderList() {
            return this.playerLocList_;
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public int getPlayerLocListCount() {
            return this.playerLocList_.size();
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLocList(int index) {
            return this.playerLocList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
        public PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocListOrBuilder(int index) {
            return this.playerLocList_.get(index);
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
            for (int i = 0; i < this.playerLocList_.size(); i++) {
                output.writeMessage(4, this.playerLocList_.get(i));
            }
            for (int i2 = 0; i2 < this.vehicleLocList_.size(); i2++) {
                output.writeMessage(6, this.vehicleLocList_.get(i2));
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
            for (int i = 0; i < this.playerLocList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.playerLocList_.get(i));
            }
            for (int i2 = 0; i2 < this.vehicleLocList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.vehicleLocList_.get(i2));
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
            if (!(obj instanceof ScenePlayerLocationNotify)) {
                return equals(obj);
            }
            ScenePlayerLocationNotify other = (ScenePlayerLocationNotify) obj;
            return getSceneId() == other.getSceneId() && getVehicleLocListList().equals(other.getVehicleLocListList()) && getPlayerLocListList().equals(other.getPlayerLocListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getSceneId();
            if (getVehicleLocListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getVehicleLocListList().hashCode();
            }
            if (getPlayerLocListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getPlayerLocListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ScenePlayerLocationNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerLocationNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerLocationNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerLocationNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerLocationNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ScenePlayerLocationNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ScenePlayerLocationNotify parseFrom(InputStream input) throws IOException {
            return (ScenePlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePlayerLocationNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePlayerLocationNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ScenePlayerLocationNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ScenePlayerLocationNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerLocationNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ScenePlayerLocationNotify parseFrom(CodedInputStream input) throws IOException {
            return (ScenePlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ScenePlayerLocationNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ScenePlayerLocationNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ScenePlayerLocationNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ScenePlayerLocationNotifyOuterClass$ScenePlayerLocationNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ScenePlayerLocationNotifyOrBuilder {
            private int bitField0_;
            private int sceneId_;
            private RepeatedFieldBuilderV3<VehicleLocationInfoOuterClass.VehicleLocationInfo, VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder, VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder> vehicleLocListBuilder_;
            private RepeatedFieldBuilderV3<PlayerLocationInfoOuterClass.PlayerLocationInfo, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder, PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> playerLocListBuilder_;
            private List<VehicleLocationInfoOuterClass.VehicleLocationInfo> vehicleLocList_ = Collections.emptyList();
            private List<PlayerLocationInfoOuterClass.PlayerLocationInfo> playerLocList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ScenePlayerLocationNotifyOuterClass.internal_static_ScenePlayerLocationNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ScenePlayerLocationNotifyOuterClass.internal_static_ScenePlayerLocationNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ScenePlayerLocationNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ScenePlayerLocationNotify.alwaysUseFieldBuilders) {
                    getVehicleLocListFieldBuilder();
                    getPlayerLocListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.sceneId_ = 0;
                if (this.vehicleLocListBuilder_ == null) {
                    this.vehicleLocList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.vehicleLocListBuilder_.clear();
                }
                if (this.playerLocListBuilder_ == null) {
                    this.playerLocList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.playerLocListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ScenePlayerLocationNotifyOuterClass.internal_static_ScenePlayerLocationNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ScenePlayerLocationNotify getDefaultInstanceForType() {
                return ScenePlayerLocationNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePlayerLocationNotify build() {
                ScenePlayerLocationNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ScenePlayerLocationNotify buildPartial() {
                ScenePlayerLocationNotify result = new ScenePlayerLocationNotify(this);
                int i = this.bitField0_;
                result.sceneId_ = this.sceneId_;
                if (this.vehicleLocListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.vehicleLocList_ = Collections.unmodifiableList(this.vehicleLocList_);
                        this.bitField0_ &= -2;
                    }
                    result.vehicleLocList_ = this.vehicleLocList_;
                } else {
                    result.vehicleLocList_ = this.vehicleLocListBuilder_.build();
                }
                if (this.playerLocListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.playerLocList_ = Collections.unmodifiableList(this.playerLocList_);
                        this.bitField0_ &= -3;
                    }
                    result.playerLocList_ = this.playerLocList_;
                } else {
                    result.playerLocList_ = this.playerLocListBuilder_.build();
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
                if (other instanceof ScenePlayerLocationNotify) {
                    return mergeFrom((ScenePlayerLocationNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ScenePlayerLocationNotify other) {
                if (other == ScenePlayerLocationNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (this.vehicleLocListBuilder_ == null) {
                    if (!other.vehicleLocList_.isEmpty()) {
                        if (this.vehicleLocList_.isEmpty()) {
                            this.vehicleLocList_ = other.vehicleLocList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureVehicleLocListIsMutable();
                            this.vehicleLocList_.addAll(other.vehicleLocList_);
                        }
                        onChanged();
                    }
                } else if (!other.vehicleLocList_.isEmpty()) {
                    if (this.vehicleLocListBuilder_.isEmpty()) {
                        this.vehicleLocListBuilder_.dispose();
                        this.vehicleLocListBuilder_ = null;
                        this.vehicleLocList_ = other.vehicleLocList_;
                        this.bitField0_ &= -2;
                        this.vehicleLocListBuilder_ = ScenePlayerLocationNotify.alwaysUseFieldBuilders ? getVehicleLocListFieldBuilder() : null;
                    } else {
                        this.vehicleLocListBuilder_.addAllMessages(other.vehicleLocList_);
                    }
                }
                if (this.playerLocListBuilder_ == null) {
                    if (!other.playerLocList_.isEmpty()) {
                        if (this.playerLocList_.isEmpty()) {
                            this.playerLocList_ = other.playerLocList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensurePlayerLocListIsMutable();
                            this.playerLocList_.addAll(other.playerLocList_);
                        }
                        onChanged();
                    }
                } else if (!other.playerLocList_.isEmpty()) {
                    if (this.playerLocListBuilder_.isEmpty()) {
                        this.playerLocListBuilder_.dispose();
                        this.playerLocListBuilder_ = null;
                        this.playerLocList_ = other.playerLocList_;
                        this.bitField0_ &= -3;
                        this.playerLocListBuilder_ = ScenePlayerLocationNotify.alwaysUseFieldBuilders ? getPlayerLocListFieldBuilder() : null;
                    } else {
                        this.playerLocListBuilder_.addAllMessages(other.playerLocList_);
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
                ScenePlayerLocationNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ScenePlayerLocationNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ScenePlayerLocationNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
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

            private void ensureVehicleLocListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.vehicleLocList_ = new ArrayList(this.vehicleLocList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public List<VehicleLocationInfoOuterClass.VehicleLocationInfo> getVehicleLocListList() {
                if (this.vehicleLocListBuilder_ == null) {
                    return Collections.unmodifiableList(this.vehicleLocList_);
                }
                return this.vehicleLocListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public int getVehicleLocListCount() {
                if (this.vehicleLocListBuilder_ == null) {
                    return this.vehicleLocList_.size();
                }
                return this.vehicleLocListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public VehicleLocationInfoOuterClass.VehicleLocationInfo getVehicleLocList(int index) {
                if (this.vehicleLocListBuilder_ == null) {
                    return this.vehicleLocList_.get(index);
                }
                return this.vehicleLocListBuilder_.getMessage(index);
            }

            public Builder setVehicleLocList(int index, VehicleLocationInfoOuterClass.VehicleLocationInfo value) {
                if (this.vehicleLocListBuilder_ != null) {
                    this.vehicleLocListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVehicleLocListIsMutable();
                    this.vehicleLocList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setVehicleLocList(int index, VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder builderForValue) {
                if (this.vehicleLocListBuilder_ == null) {
                    ensureVehicleLocListIsMutable();
                    this.vehicleLocList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.vehicleLocListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addVehicleLocList(VehicleLocationInfoOuterClass.VehicleLocationInfo value) {
                if (this.vehicleLocListBuilder_ != null) {
                    this.vehicleLocListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVehicleLocListIsMutable();
                    this.vehicleLocList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addVehicleLocList(int index, VehicleLocationInfoOuterClass.VehicleLocationInfo value) {
                if (this.vehicleLocListBuilder_ != null) {
                    this.vehicleLocListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureVehicleLocListIsMutable();
                    this.vehicleLocList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addVehicleLocList(VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder builderForValue) {
                if (this.vehicleLocListBuilder_ == null) {
                    ensureVehicleLocListIsMutable();
                    this.vehicleLocList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.vehicleLocListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addVehicleLocList(int index, VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder builderForValue) {
                if (this.vehicleLocListBuilder_ == null) {
                    ensureVehicleLocListIsMutable();
                    this.vehicleLocList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.vehicleLocListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllVehicleLocList(Iterable<? extends VehicleLocationInfoOuterClass.VehicleLocationInfo> values) {
                if (this.vehicleLocListBuilder_ == null) {
                    ensureVehicleLocListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.vehicleLocList_);
                    onChanged();
                } else {
                    this.vehicleLocListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearVehicleLocList() {
                if (this.vehicleLocListBuilder_ == null) {
                    this.vehicleLocList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.vehicleLocListBuilder_.clear();
                }
                return this;
            }

            public Builder removeVehicleLocList(int index) {
                if (this.vehicleLocListBuilder_ == null) {
                    ensureVehicleLocListIsMutable();
                    this.vehicleLocList_.remove(index);
                    onChanged();
                } else {
                    this.vehicleLocListBuilder_.remove(index);
                }
                return this;
            }

            public VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder getVehicleLocListBuilder(int index) {
                return getVehicleLocListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder getVehicleLocListOrBuilder(int index) {
                if (this.vehicleLocListBuilder_ == null) {
                    return this.vehicleLocList_.get(index);
                }
                return this.vehicleLocListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public List<? extends VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder> getVehicleLocListOrBuilderList() {
                if (this.vehicleLocListBuilder_ != null) {
                    return this.vehicleLocListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.vehicleLocList_);
            }

            public VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder addVehicleLocListBuilder() {
                return getVehicleLocListFieldBuilder().addBuilder(VehicleLocationInfoOuterClass.VehicleLocationInfo.getDefaultInstance());
            }

            public VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder addVehicleLocListBuilder(int index) {
                return getVehicleLocListFieldBuilder().addBuilder(index, VehicleLocationInfoOuterClass.VehicleLocationInfo.getDefaultInstance());
            }

            public List<VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder> getVehicleLocListBuilderList() {
                return getVehicleLocListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<VehicleLocationInfoOuterClass.VehicleLocationInfo, VehicleLocationInfoOuterClass.VehicleLocationInfo.Builder, VehicleLocationInfoOuterClass.VehicleLocationInfoOrBuilder> getVehicleLocListFieldBuilder() {
                if (this.vehicleLocListBuilder_ == null) {
                    this.vehicleLocListBuilder_ = new RepeatedFieldBuilderV3<>(this.vehicleLocList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.vehicleLocList_ = null;
                }
                return this.vehicleLocListBuilder_;
            }

            private void ensurePlayerLocListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.playerLocList_ = new ArrayList(this.playerLocList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public List<PlayerLocationInfoOuterClass.PlayerLocationInfo> getPlayerLocListList() {
                if (this.playerLocListBuilder_ == null) {
                    return Collections.unmodifiableList(this.playerLocList_);
                }
                return this.playerLocListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public int getPlayerLocListCount() {
                if (this.playerLocListBuilder_ == null) {
                    return this.playerLocList_.size();
                }
                return this.playerLocListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLocList(int index) {
                if (this.playerLocListBuilder_ == null) {
                    return this.playerLocList_.get(index);
                }
                return this.playerLocListBuilder_.getMessage(index);
            }

            public Builder setPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocListBuilder_ != null) {
                    this.playerLocListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder builderForValue) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerLocListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerLocList(PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocListBuilder_ != null) {
                    this.playerLocListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo value) {
                if (this.playerLocListBuilder_ != null) {
                    this.playerLocListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlayerLocList(PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder builderForValue) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.playerLocListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlayerLocList(int index, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder builderForValue) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.playerLocListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlayerLocList(Iterable<? extends PlayerLocationInfoOuterClass.PlayerLocationInfo> values) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.playerLocList_);
                    onChanged();
                } else {
                    this.playerLocListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlayerLocList() {
                if (this.playerLocListBuilder_ == null) {
                    this.playerLocList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.playerLocListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlayerLocList(int index) {
                if (this.playerLocListBuilder_ == null) {
                    ensurePlayerLocListIsMutable();
                    this.playerLocList_.remove(index);
                    onChanged();
                } else {
                    this.playerLocListBuilder_.remove(index);
                }
                return this;
            }

            public PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder getPlayerLocListBuilder(int index) {
                return getPlayerLocListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder getPlayerLocListOrBuilder(int index) {
                if (this.playerLocListBuilder_ == null) {
                    return this.playerLocList_.get(index);
                }
                return this.playerLocListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotifyOrBuilder
            public List<? extends PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListOrBuilderList() {
                if (this.playerLocListBuilder_ != null) {
                    return this.playerLocListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.playerLocList_);
            }

            public PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder addPlayerLocListBuilder() {
                return getPlayerLocListFieldBuilder().addBuilder(PlayerLocationInfoOuterClass.PlayerLocationInfo.getDefaultInstance());
            }

            public PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder addPlayerLocListBuilder(int index) {
                return getPlayerLocListFieldBuilder().addBuilder(index, PlayerLocationInfoOuterClass.PlayerLocationInfo.getDefaultInstance());
            }

            public List<PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder> getPlayerLocListBuilderList() {
                return getPlayerLocListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PlayerLocationInfoOuterClass.PlayerLocationInfo, PlayerLocationInfoOuterClass.PlayerLocationInfo.Builder, PlayerLocationInfoOuterClass.PlayerLocationInfoOrBuilder> getPlayerLocListFieldBuilder() {
                if (this.playerLocListBuilder_ == null) {
                    this.playerLocListBuilder_ = new RepeatedFieldBuilderV3<>(this.playerLocList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.playerLocList_ = null;
                }
                return this.playerLocListBuilder_;
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

        public static ScenePlayerLocationNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ScenePlayerLocationNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ScenePlayerLocationNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ScenePlayerLocationNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerLocationInfoOuterClass.getDescriptor();
        VehicleLocationInfoOuterClass.getDescriptor();
    }
}
