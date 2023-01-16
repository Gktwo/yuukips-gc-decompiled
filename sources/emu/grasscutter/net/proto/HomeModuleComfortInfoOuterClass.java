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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleComfortInfoOuterClass.class */
public final class HomeModuleComfortInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bHomeModuleComfortInfo.proto\"z\n\u0015HomeModuleComfortInfo\u0012 \n\u0018room_scene_comfort_value\u0018\u0005 \u0001(\r\u0012,\n$world_scene_block_comfort_value_list\u0018\n \u0003(\r\u0012\u0011\n\tmodule_id\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_HomeModuleComfortInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeModuleComfortInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeModuleComfortInfo_descriptor, new String[]{"RoomSceneComfortValue", "WorldSceneBlockComfortValueList", "ModuleId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleComfortInfoOuterClass$HomeModuleComfortInfoOrBuilder.class */
    public interface HomeModuleComfortInfoOrBuilder extends MessageOrBuilder {
        int getRoomSceneComfortValue();

        List<Integer> getWorldSceneBlockComfortValueListList();

        int getWorldSceneBlockComfortValueListCount();

        int getWorldSceneBlockComfortValueList(int i);

        int getModuleId();
    }

    private HomeModuleComfortInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleComfortInfoOuterClass$HomeModuleComfortInfo.class */
    public static final class HomeModuleComfortInfo extends GeneratedMessageV3 implements HomeModuleComfortInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ROOM_SCENE_COMFORT_VALUE_FIELD_NUMBER = 5;
        private int roomSceneComfortValue_;
        public static final int WORLD_SCENE_BLOCK_COMFORT_VALUE_LIST_FIELD_NUMBER = 10;
        private Internal.IntList worldSceneBlockComfortValueList_;
        private int worldSceneBlockComfortValueListMemoizedSerializedSize;
        public static final int MODULE_ID_FIELD_NUMBER = 15;
        private int moduleId_;
        private byte memoizedIsInitialized;
        private static final HomeModuleComfortInfo DEFAULT_INSTANCE = new HomeModuleComfortInfo();
        private static final Parser<HomeModuleComfortInfo> PARSER = new AbstractParser<HomeModuleComfortInfo>() { // from class: emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfo.1
            @Override // com.google.protobuf.Parser
            public HomeModuleComfortInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeModuleComfortInfo(input, extensionRegistry);
            }
        };

        private HomeModuleComfortInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.worldSceneBlockComfortValueListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HomeModuleComfortInfo() {
            this.worldSceneBlockComfortValueListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.worldSceneBlockComfortValueList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeModuleComfortInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeModuleComfortInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.roomSceneComfortValue_ = input.readUInt32();
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.worldSceneBlockComfortValueList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.worldSceneBlockComfortValueList_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.worldSceneBlockComfortValueList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.worldSceneBlockComfortValueList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 120:
                                this.moduleId_ = input.readUInt32();
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
                    this.worldSceneBlockComfortValueList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HomeModuleComfortInfoOuterClass.internal_static_HomeModuleComfortInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeModuleComfortInfoOuterClass.internal_static_HomeModuleComfortInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeModuleComfortInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
        public int getRoomSceneComfortValue() {
            return this.roomSceneComfortValue_;
        }

        @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
        public List<Integer> getWorldSceneBlockComfortValueListList() {
            return this.worldSceneBlockComfortValueList_;
        }

        @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
        public int getWorldSceneBlockComfortValueListCount() {
            return this.worldSceneBlockComfortValueList_.size();
        }

        @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
        public int getWorldSceneBlockComfortValueList(int index) {
            return this.worldSceneBlockComfortValueList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
        public int getModuleId() {
            return this.moduleId_;
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
            getSerializedSize();
            if (this.roomSceneComfortValue_ != 0) {
                output.writeUInt32(5, this.roomSceneComfortValue_);
            }
            if (getWorldSceneBlockComfortValueListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.worldSceneBlockComfortValueListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.worldSceneBlockComfortValueList_.size(); i++) {
                output.writeUInt32NoTag(this.worldSceneBlockComfortValueList_.getInt(i));
            }
            if (this.moduleId_ != 0) {
                output.writeUInt32(15, this.moduleId_);
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
            if (this.roomSceneComfortValue_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.roomSceneComfortValue_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.worldSceneBlockComfortValueList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.worldSceneBlockComfortValueList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getWorldSceneBlockComfortValueListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.worldSceneBlockComfortValueListMemoizedSerializedSize = dataSize;
            if (this.moduleId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(15, this.moduleId_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HomeModuleComfortInfo)) {
                return equals(obj);
            }
            HomeModuleComfortInfo other = (HomeModuleComfortInfo) obj;
            return getRoomSceneComfortValue() == other.getRoomSceneComfortValue() && getWorldSceneBlockComfortValueListList().equals(other.getWorldSceneBlockComfortValueListList()) && getModuleId() == other.getModuleId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getRoomSceneComfortValue();
            if (getWorldSceneBlockComfortValueListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getWorldSceneBlockComfortValueListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getModuleId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HomeModuleComfortInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleComfortInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleComfortInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleComfortInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleComfortInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeModuleComfortInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeModuleComfortInfo parseFrom(InputStream input) throws IOException {
            return (HomeModuleComfortInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeModuleComfortInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleComfortInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeModuleComfortInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeModuleComfortInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeModuleComfortInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleComfortInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeModuleComfortInfo parseFrom(CodedInputStream input) throws IOException {
            return (HomeModuleComfortInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeModuleComfortInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeModuleComfortInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeModuleComfortInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeModuleComfortInfoOuterClass$HomeModuleComfortInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeModuleComfortInfoOrBuilder {
            private int bitField0_;
            private int roomSceneComfortValue_;
            private Internal.IntList worldSceneBlockComfortValueList_ = HomeModuleComfortInfo.emptyIntList();
            private int moduleId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeModuleComfortInfoOuterClass.internal_static_HomeModuleComfortInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeModuleComfortInfoOuterClass.internal_static_HomeModuleComfortInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeModuleComfortInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeModuleComfortInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.roomSceneComfortValue_ = 0;
                this.worldSceneBlockComfortValueList_ = HomeModuleComfortInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.moduleId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeModuleComfortInfoOuterClass.internal_static_HomeModuleComfortInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeModuleComfortInfo getDefaultInstanceForType() {
                return HomeModuleComfortInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeModuleComfortInfo build() {
                HomeModuleComfortInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeModuleComfortInfo buildPartial() {
                HomeModuleComfortInfo result = new HomeModuleComfortInfo(this);
                int i = this.bitField0_;
                result.roomSceneComfortValue_ = this.roomSceneComfortValue_;
                if ((this.bitField0_ & 1) != 0) {
                    this.worldSceneBlockComfortValueList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.worldSceneBlockComfortValueList_ = this.worldSceneBlockComfortValueList_;
                result.moduleId_ = this.moduleId_;
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
                if (other instanceof HomeModuleComfortInfo) {
                    return mergeFrom((HomeModuleComfortInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeModuleComfortInfo other) {
                if (other == HomeModuleComfortInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getRoomSceneComfortValue() != 0) {
                    setRoomSceneComfortValue(other.getRoomSceneComfortValue());
                }
                if (!other.worldSceneBlockComfortValueList_.isEmpty()) {
                    if (this.worldSceneBlockComfortValueList_.isEmpty()) {
                        this.worldSceneBlockComfortValueList_ = other.worldSceneBlockComfortValueList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureWorldSceneBlockComfortValueListIsMutable();
                        this.worldSceneBlockComfortValueList_.addAll(other.worldSceneBlockComfortValueList_);
                    }
                    onChanged();
                }
                if (other.getModuleId() != 0) {
                    setModuleId(other.getModuleId());
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
                HomeModuleComfortInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeModuleComfortInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeModuleComfortInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
            public int getRoomSceneComfortValue() {
                return this.roomSceneComfortValue_;
            }

            public Builder setRoomSceneComfortValue(int value) {
                this.roomSceneComfortValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearRoomSceneComfortValue() {
                this.roomSceneComfortValue_ = 0;
                onChanged();
                return this;
            }

            private void ensureWorldSceneBlockComfortValueListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.worldSceneBlockComfortValueList_ = HomeModuleComfortInfo.mutableCopy(this.worldSceneBlockComfortValueList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
            public List<Integer> getWorldSceneBlockComfortValueListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.worldSceneBlockComfortValueList_) : this.worldSceneBlockComfortValueList_;
            }

            @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
            public int getWorldSceneBlockComfortValueListCount() {
                return this.worldSceneBlockComfortValueList_.size();
            }

            @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
            public int getWorldSceneBlockComfortValueList(int index) {
                return this.worldSceneBlockComfortValueList_.getInt(index);
            }

            public Builder setWorldSceneBlockComfortValueList(int index, int value) {
                ensureWorldSceneBlockComfortValueListIsMutable();
                this.worldSceneBlockComfortValueList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addWorldSceneBlockComfortValueList(int value) {
                ensureWorldSceneBlockComfortValueListIsMutable();
                this.worldSceneBlockComfortValueList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllWorldSceneBlockComfortValueList(Iterable<? extends Integer> values) {
                ensureWorldSceneBlockComfortValueListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.worldSceneBlockComfortValueList_);
                onChanged();
                return this;
            }

            public Builder clearWorldSceneBlockComfortValueList() {
                this.worldSceneBlockComfortValueList_ = HomeModuleComfortInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeModuleComfortInfoOuterClass.HomeModuleComfortInfoOrBuilder
            public int getModuleId() {
                return this.moduleId_;
            }

            public Builder setModuleId(int value) {
                this.moduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearModuleId() {
                this.moduleId_ = 0;
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

        public static HomeModuleComfortInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeModuleComfortInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeModuleComfortInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeModuleComfortInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
