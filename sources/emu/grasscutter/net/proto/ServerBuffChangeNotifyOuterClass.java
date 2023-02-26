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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffChangeNotifyOuterClass.class */
public final class ServerBuffChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cServerBuffChangeNotify.proto\u001a\u0010ServerBuff.proto\"Á\u0002\n\u0016ServerBuffChangeNotify\u0012#\n\u000eserverBuffList\u0018\f \u0003(\u000b2\u000b.ServerBuff\u0012\u0016\n\u000eavatarGuidList\u0018\n \u0003(\u0004\u0012J\n\u0014serverBuffChangeType\u0018\u0004 \u0001(\u000e2,.ServerBuffChangeNotify.ServerBuffChangeType\u0012\u0014\n\fentityIdList\u0018\u0001 \u0003(\r\u0012\u0016\n\u000eisCreatureBuff\u0018\u0005 \u0001(\b\"p\n\u0014ServerBuffChangeType\u0012+\n'SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF\u0010��\u0012+\n'SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF\u0010\u0001B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ServerBuffOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ServerBuffChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ServerBuffChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ServerBuffChangeNotify_descriptor, new String[]{"ServerBuffList", "AvatarGuidList", "ServerBuffChangeType", "EntityIdList", "IsCreatureBuff"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffChangeNotifyOuterClass$ServerBuffChangeNotifyOrBuilder.class */
    public interface ServerBuffChangeNotifyOrBuilder extends MessageOrBuilder {
        List<ServerBuffOuterClass.ServerBuff> getServerBuffListList();

        ServerBuffOuterClass.ServerBuff getServerBuffList(int i);

        int getServerBuffListCount();

        List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList();

        ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int i);

        List<Long> getAvatarGuidListList();

        int getAvatarGuidListCount();

        long getAvatarGuidList(int i);

        int getServerBuffChangeTypeValue();

        ServerBuffChangeNotify.ServerBuffChangeType getServerBuffChangeType();

        List<Integer> getEntityIdListList();

        int getEntityIdListCount();

        int getEntityIdList(int i);

        boolean getIsCreatureBuff();
    }

    private ServerBuffChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffChangeNotifyOuterClass$ServerBuffChangeNotify.class */
    public static final class ServerBuffChangeNotify extends GeneratedMessageV3 implements ServerBuffChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int SERVERBUFFLIST_FIELD_NUMBER = 12;
        private List<ServerBuffOuterClass.ServerBuff> serverBuffList_;
        public static final int AVATARGUIDLIST_FIELD_NUMBER = 10;
        private Internal.LongList avatarGuidList_;
        private int avatarGuidListMemoizedSerializedSize;
        public static final int SERVERBUFFCHANGETYPE_FIELD_NUMBER = 4;
        private int serverBuffChangeType_;
        public static final int ENTITYIDLIST_FIELD_NUMBER = 1;
        private Internal.IntList entityIdList_;
        private int entityIdListMemoizedSerializedSize;
        public static final int ISCREATUREBUFF_FIELD_NUMBER = 5;
        private boolean isCreatureBuff_;
        private byte memoizedIsInitialized;
        private static final ServerBuffChangeNotify DEFAULT_INSTANCE = new ServerBuffChangeNotify();
        private static final Parser<ServerBuffChangeNotify> PARSER = new AbstractParser<ServerBuffChangeNotify>() { // from class: emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.1
            @Override // com.google.protobuf.Parser
            public ServerBuffChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ServerBuffChangeNotify(input, extensionRegistry);
            }
        };

        private ServerBuffChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.entityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ServerBuffChangeNotify() {
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.entityIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.serverBuffList_ = Collections.emptyList();
            this.avatarGuidList_ = emptyLongList();
            this.serverBuffChangeType_ = 0;
            this.entityIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ServerBuffChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x019b */
        private ServerBuffChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.entityIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.entityIdList_.addInt(input.readUInt32());
                                break;
                            case 10:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.entityIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.entityIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 32:
                                this.serverBuffChangeType_ = input.readEnum();
                                break;
                            case 40:
                                this.isCreatureBuff_ = input.readBool();
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.avatarGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.avatarGuidList_.addLong(input.readUInt64());
                                break;
                            case 82:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.avatarGuidList_ = newLongList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.avatarGuidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit2);
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.serverBuffList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.serverBuffList_.add((ServerBuffOuterClass.ServerBuff) input.readMessage(ServerBuffOuterClass.ServerBuff.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 4) != 0) {
                    this.entityIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.avatarGuidList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ServerBuffChangeNotifyOuterClass.internal_static_ServerBuffChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ServerBuffChangeNotifyOuterClass.internal_static_ServerBuffChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerBuffChangeNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffChangeNotifyOuterClass$ServerBuffChangeNotify$ServerBuffChangeType.class */
        public enum ServerBuffChangeType implements ProtocolMessageEnum {
            SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF(0),
            SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF(1),
            UNRECOGNIZED(-1);
            
            public static final int SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF_VALUE = 0;
            public static final int SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF_VALUE = 1;
            private static final Internal.EnumLiteMap<ServerBuffChangeType> internalValueMap = new Internal.EnumLiteMap<ServerBuffChangeType>() { // from class: emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public ServerBuffChangeType findValueByNumber(int number) {
                    return ServerBuffChangeType.forNumber(number);
                }
            };
            private static final ServerBuffChangeType[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ServerBuffChangeType valueOf(int value) {
                return forNumber(value);
            }

            public static ServerBuffChangeType forNumber(int value) {
                switch (value) {
                    case 0:
                        return SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF;
                    case 1:
                        return SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<ServerBuffChangeType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return ServerBuffChangeNotify.getDescriptor().getEnumTypes().get(0);
            }

            public static ServerBuffChangeType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            ServerBuffChangeType(int value) {
                this.value = value;
            }
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public int getServerBuffListCount() {
            return this.serverBuffList_.size();
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public List<Long> getAvatarGuidListList() {
            return this.avatarGuidList_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public int getAvatarGuidListCount() {
            return this.avatarGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public long getAvatarGuidList(int index) {
            return this.avatarGuidList_.getLong(index);
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public int getServerBuffChangeTypeValue() {
            return this.serverBuffChangeType_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public ServerBuffChangeType getServerBuffChangeType() {
            ServerBuffChangeType result = ServerBuffChangeType.valueOf(this.serverBuffChangeType_);
            return result == null ? ServerBuffChangeType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public List<Integer> getEntityIdListList() {
            return this.entityIdList_;
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public int getEntityIdListCount() {
            return this.entityIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public int getEntityIdList(int index) {
            return this.entityIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
        public boolean getIsCreatureBuff() {
            return this.isCreatureBuff_;
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
            if (getEntityIdListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.entityIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.entityIdList_.size(); i++) {
                output.writeUInt32NoTag(this.entityIdList_.getInt(i));
            }
            if (this.serverBuffChangeType_ != ServerBuffChangeType.SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF.getNumber()) {
                output.writeEnum(4, this.serverBuffChangeType_);
            }
            if (this.isCreatureBuff_) {
                output.writeBool(5, this.isCreatureBuff_);
            }
            if (getAvatarGuidListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.avatarGuidListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.avatarGuidList_.size(); i2++) {
                output.writeUInt64NoTag(this.avatarGuidList_.getLong(i2));
            }
            for (int i3 = 0; i3 < this.serverBuffList_.size(); i3++) {
                output.writeMessage(12, this.serverBuffList_.get(i3));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.entityIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.entityIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getEntityIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.entityIdListMemoizedSerializedSize = dataSize;
            if (this.serverBuffChangeType_ != ServerBuffChangeType.SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(4, this.serverBuffChangeType_);
            }
            if (this.isCreatureBuff_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isCreatureBuff_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.avatarGuidList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt64SizeNoTag(this.avatarGuidList_.getLong(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getAvatarGuidListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.avatarGuidListMemoizedSerializedSize = dataSize2;
            for (int i3 = 0; i3 < this.serverBuffList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(12, this.serverBuffList_.get(i3));
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
            if (!(obj instanceof ServerBuffChangeNotify)) {
                return equals(obj);
            }
            ServerBuffChangeNotify other = (ServerBuffChangeNotify) obj;
            return getServerBuffListList().equals(other.getServerBuffListList()) && getAvatarGuidListList().equals(other.getAvatarGuidListList()) && this.serverBuffChangeType_ == other.serverBuffChangeType_ && getEntityIdListList().equals(other.getEntityIdListList()) && getIsCreatureBuff() == other.getIsCreatureBuff() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getServerBuffListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getServerBuffListList().hashCode();
            }
            if (getAvatarGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getAvatarGuidListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 4)) + this.serverBuffChangeType_;
            if (getEntityIdListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1)) + getEntityIdListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 5)) + Internal.hashBoolean(getIsCreatureBuff()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static ServerBuffChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerBuffChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerBuffChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerBuffChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerBuffChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ServerBuffChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ServerBuffChangeNotify parseFrom(InputStream input) throws IOException {
            return (ServerBuffChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerBuffChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerBuffChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerBuffChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ServerBuffChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ServerBuffChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerBuffChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ServerBuffChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (ServerBuffChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ServerBuffChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ServerBuffChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ServerBuffChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ServerBuffChangeNotifyOuterClass$ServerBuffChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ServerBuffChangeNotifyOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> serverBuffListBuilder_;
            private boolean isCreatureBuff_;
            private List<ServerBuffOuterClass.ServerBuff> serverBuffList_ = Collections.emptyList();
            private Internal.LongList avatarGuidList_ = ServerBuffChangeNotify.emptyLongList();
            private int serverBuffChangeType_ = 0;
            private Internal.IntList entityIdList_ = ServerBuffChangeNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ServerBuffChangeNotifyOuterClass.internal_static_ServerBuffChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ServerBuffChangeNotifyOuterClass.internal_static_ServerBuffChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ServerBuffChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ServerBuffChangeNotify.alwaysUseFieldBuilders) {
                    getServerBuffListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                this.avatarGuidList_ = ServerBuffChangeNotify.emptyLongList();
                this.bitField0_ &= -3;
                this.serverBuffChangeType_ = 0;
                this.entityIdList_ = ServerBuffChangeNotify.emptyIntList();
                this.bitField0_ &= -5;
                this.isCreatureBuff_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServerBuffChangeNotifyOuterClass.internal_static_ServerBuffChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServerBuffChangeNotify getDefaultInstanceForType() {
                return ServerBuffChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerBuffChangeNotify build() {
                ServerBuffChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServerBuffChangeNotify buildPartial() {
                ServerBuffChangeNotify result = new ServerBuffChangeNotify(this);
                int i = this.bitField0_;
                if (this.serverBuffListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                        this.bitField0_ &= -2;
                    }
                    result.serverBuffList_ = this.serverBuffList_;
                } else {
                    result.serverBuffList_ = this.serverBuffListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.avatarGuidList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.avatarGuidList_ = this.avatarGuidList_;
                result.serverBuffChangeType_ = this.serverBuffChangeType_;
                if ((this.bitField0_ & 4) != 0) {
                    this.entityIdList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.entityIdList_ = this.entityIdList_;
                result.isCreatureBuff_ = this.isCreatureBuff_;
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
                if (other instanceof ServerBuffChangeNotify) {
                    return mergeFrom((ServerBuffChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServerBuffChangeNotify other) {
                if (other == ServerBuffChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.serverBuffListBuilder_ == null) {
                    if (!other.serverBuffList_.isEmpty()) {
                        if (this.serverBuffList_.isEmpty()) {
                            this.serverBuffList_ = other.serverBuffList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureServerBuffListIsMutable();
                            this.serverBuffList_.addAll(other.serverBuffList_);
                        }
                        onChanged();
                    }
                } else if (!other.serverBuffList_.isEmpty()) {
                    if (this.serverBuffListBuilder_.isEmpty()) {
                        this.serverBuffListBuilder_.dispose();
                        this.serverBuffListBuilder_ = null;
                        this.serverBuffList_ = other.serverBuffList_;
                        this.bitField0_ &= -2;
                        this.serverBuffListBuilder_ = ServerBuffChangeNotify.alwaysUseFieldBuilders ? getServerBuffListFieldBuilder() : null;
                    } else {
                        this.serverBuffListBuilder_.addAllMessages(other.serverBuffList_);
                    }
                }
                if (!other.avatarGuidList_.isEmpty()) {
                    if (this.avatarGuidList_.isEmpty()) {
                        this.avatarGuidList_ = other.avatarGuidList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureAvatarGuidListIsMutable();
                        this.avatarGuidList_.addAll(other.avatarGuidList_);
                    }
                    onChanged();
                }
                if (other.serverBuffChangeType_ != 0) {
                    setServerBuffChangeTypeValue(other.getServerBuffChangeTypeValue());
                }
                if (!other.entityIdList_.isEmpty()) {
                    if (this.entityIdList_.isEmpty()) {
                        this.entityIdList_ = other.entityIdList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureEntityIdListIsMutable();
                        this.entityIdList_.addAll(other.entityIdList_);
                    }
                    onChanged();
                }
                if (other.getIsCreatureBuff()) {
                    setIsCreatureBuff(other.getIsCreatureBuff());
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
                ServerBuffChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ServerBuffChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ServerBuffChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureServerBuffListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.serverBuffList_ = new ArrayList(this.serverBuffList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
                if (this.serverBuffListBuilder_ == null) {
                    return Collections.unmodifiableList(this.serverBuffList_);
                }
                return this.serverBuffListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public int getServerBuffListCount() {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.size();
                }
                return this.serverBuffListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessage(index);
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff value) {
                if (this.serverBuffListBuilder_ != null) {
                    this.serverBuffListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addServerBuffList(ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addServerBuffList(int index, ServerBuffOuterClass.ServerBuff.Builder builderForValue) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllServerBuffList(Iterable<? extends ServerBuffOuterClass.ServerBuff> values) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.serverBuffList_);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearServerBuffList() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                return this;
            }

            public Builder removeServerBuffList(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    ensureServerBuffListIsMutable();
                    this.serverBuffList_.remove(index);
                    onChanged();
                } else {
                    this.serverBuffListBuilder_.remove(index);
                }
                return this;
            }

            public ServerBuffOuterClass.ServerBuff.Builder getServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
                if (this.serverBuffListBuilder_ != null) {
                    return this.serverBuffListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.serverBuffList_);
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder() {
                return getServerBuffListFieldBuilder().addBuilder(ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public ServerBuffOuterClass.ServerBuff.Builder addServerBuffListBuilder(int index) {
                return getServerBuffListFieldBuilder().addBuilder(index, ServerBuffOuterClass.ServerBuff.getDefaultInstance());
            }

            public List<ServerBuffOuterClass.ServerBuff.Builder> getServerBuffListBuilderList() {
                return getServerBuffListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListFieldBuilder() {
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffListBuilder_ = new RepeatedFieldBuilderV3<>(this.serverBuffList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.serverBuffList_ = null;
                }
                return this.serverBuffListBuilder_;
            }

            private void ensureAvatarGuidListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.avatarGuidList_ = ServerBuffChangeNotify.mutableCopy(this.avatarGuidList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public List<Long> getAvatarGuidListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.avatarGuidList_) : this.avatarGuidList_;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public int getAvatarGuidListCount() {
                return this.avatarGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public long getAvatarGuidList(int index) {
                return this.avatarGuidList_.getLong(index);
            }

            public Builder setAvatarGuidList(int index, long value) {
                ensureAvatarGuidListIsMutable();
                this.avatarGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addAvatarGuidList(long value) {
                ensureAvatarGuidListIsMutable();
                this.avatarGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllAvatarGuidList(Iterable<? extends Long> values) {
                ensureAvatarGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarGuidList_);
                onChanged();
                return this;
            }

            public Builder clearAvatarGuidList() {
                this.avatarGuidList_ = ServerBuffChangeNotify.emptyLongList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public int getServerBuffChangeTypeValue() {
                return this.serverBuffChangeType_;
            }

            public Builder setServerBuffChangeTypeValue(int value) {
                this.serverBuffChangeType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public ServerBuffChangeType getServerBuffChangeType() {
                ServerBuffChangeType result = ServerBuffChangeType.valueOf(this.serverBuffChangeType_);
                return result == null ? ServerBuffChangeType.UNRECOGNIZED : result;
            }

            public Builder setServerBuffChangeType(ServerBuffChangeType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.serverBuffChangeType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearServerBuffChangeType() {
                this.serverBuffChangeType_ = 0;
                onChanged();
                return this;
            }

            private void ensureEntityIdListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.entityIdList_ = ServerBuffChangeNotify.mutableCopy(this.entityIdList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public List<Integer> getEntityIdListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.entityIdList_) : this.entityIdList_;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public int getEntityIdListCount() {
                return this.entityIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public int getEntityIdList(int index) {
                return this.entityIdList_.getInt(index);
            }

            public Builder setEntityIdList(int index, int value) {
                ensureEntityIdListIsMutable();
                this.entityIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addEntityIdList(int value) {
                ensureEntityIdListIsMutable();
                this.entityIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllEntityIdList(Iterable<? extends Integer> values) {
                ensureEntityIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.entityIdList_);
                onChanged();
                return this;
            }

            public Builder clearEntityIdList() {
                this.entityIdList_ = ServerBuffChangeNotify.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotifyOrBuilder
            public boolean getIsCreatureBuff() {
                return this.isCreatureBuff_;
            }

            public Builder setIsCreatureBuff(boolean value) {
                this.isCreatureBuff_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCreatureBuff() {
                this.isCreatureBuff_ = false;
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

        public static ServerBuffChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ServerBuffChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ServerBuffChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServerBuffChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ServerBuffOuterClass.getDescriptor();
    }
}
