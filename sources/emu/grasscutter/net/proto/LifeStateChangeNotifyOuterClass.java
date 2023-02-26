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
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LifeStateChangeNotifyOuterClass.class */
public final class LifeStateChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bLifeStateChangeNotify.proto\u001a\u0013PlayerDieType.proto\u001a\u0010ServerBuff.proto\"Æ\u0001\n\u0015LifeStateChangeNotify\u0012\u0010\n\bentityId\u0018\u0007 \u0001(\r\u0012#\n\u000eserverBuffList\u0018\u0002 \u0003(\u000b2\u000b.ServerBuff\u0012\u0017\n\u000fmoveReliableSeq\u0018\u0005 \u0001(\r\u0012\u0011\n\tattackTag\u0018\r \u0001(\t\u0012\u0016\n\u000esourceEntityId\u0018\u000f \u0001(\r\u0012\u0011\n\tlifeState\u0018\t \u0001(\r\u0012\u001f\n\u0007dieType\u0018\u0006 \u0001(\u000e2\u000e.PlayerDieTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PlayerDieTypeOuterClass.getDescriptor(), ServerBuffOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LifeStateChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LifeStateChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LifeStateChangeNotify_descriptor, new String[]{"EntityId", "ServerBuffList", "MoveReliableSeq", "AttackTag", "SourceEntityId", "LifeState", "DieType"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LifeStateChangeNotifyOuterClass$LifeStateChangeNotifyOrBuilder.class */
    public interface LifeStateChangeNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        List<ServerBuffOuterClass.ServerBuff> getServerBuffListList();

        ServerBuffOuterClass.ServerBuff getServerBuffList(int i);

        int getServerBuffListCount();

        List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList();

        ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int i);

        int getMoveReliableSeq();

        String getAttackTag();

        ByteString getAttackTagBytes();

        int getSourceEntityId();

        int getLifeState();

        int getDieTypeValue();

        PlayerDieTypeOuterClass.PlayerDieType getDieType();
    }

    private LifeStateChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LifeStateChangeNotifyOuterClass$LifeStateChangeNotify.class */
    public static final class LifeStateChangeNotify extends GeneratedMessageV3 implements LifeStateChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 7;
        private int entityId_;
        public static final int SERVERBUFFLIST_FIELD_NUMBER = 2;
        private List<ServerBuffOuterClass.ServerBuff> serverBuffList_;
        public static final int MOVERELIABLESEQ_FIELD_NUMBER = 5;
        private int moveReliableSeq_;
        public static final int ATTACKTAG_FIELD_NUMBER = 13;
        private volatile Object attackTag_;
        public static final int SOURCEENTITYID_FIELD_NUMBER = 15;
        private int sourceEntityId_;
        public static final int LIFESTATE_FIELD_NUMBER = 9;
        private int lifeState_;
        public static final int DIETYPE_FIELD_NUMBER = 6;
        private int dieType_;
        private byte memoizedIsInitialized;
        private static final LifeStateChangeNotify DEFAULT_INSTANCE = new LifeStateChangeNotify();
        private static final Parser<LifeStateChangeNotify> PARSER = new AbstractParser<LifeStateChangeNotify>() { // from class: emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotify.1
            @Override // com.google.protobuf.Parser
            public LifeStateChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LifeStateChangeNotify(input, extensionRegistry);
            }
        };

        private LifeStateChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LifeStateChangeNotify() {
            this.memoizedIsInitialized = -1;
            this.serverBuffList_ = Collections.emptyList();
            this.attackTag_ = "";
            this.dieType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LifeStateChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LifeStateChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.serverBuffList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.serverBuffList_.add((ServerBuffOuterClass.ServerBuff) input.readMessage(ServerBuffOuterClass.ServerBuff.parser(), extensionRegistry));
                                break;
                            case 40:
                                this.moveReliableSeq_ = input.readUInt32();
                                break;
                            case 48:
                                this.dieType_ = input.readEnum();
                                break;
                            case 56:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 72:
                                this.lifeState_ = input.readUInt32();
                                break;
                            case 106:
                                this.attackTag_ = input.readStringRequireUtf8();
                                break;
                            case 120:
                                this.sourceEntityId_ = input.readUInt32();
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
                    this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LifeStateChangeNotifyOuterClass.internal_static_LifeStateChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LifeStateChangeNotifyOuterClass.internal_static_LifeStateChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(LifeStateChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public List<? extends ServerBuffOuterClass.ServerBuffOrBuilder> getServerBuffListOrBuilderList() {
            return this.serverBuffList_;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public int getServerBuffListCount() {
            return this.serverBuffList_.size();
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public ServerBuffOuterClass.ServerBuff getServerBuffList(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
            return this.serverBuffList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public int getMoveReliableSeq() {
            return this.moveReliableSeq_;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public String getAttackTag() {
            Object ref = this.attackTag_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.attackTag_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public ByteString getAttackTagBytes() {
            Object ref = this.attackTag_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.attackTag_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public int getSourceEntityId() {
            return this.sourceEntityId_;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public int getLifeState() {
            return this.lifeState_;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public int getDieTypeValue() {
            return this.dieType_;
        }

        @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
        public PlayerDieTypeOuterClass.PlayerDieType getDieType() {
            PlayerDieTypeOuterClass.PlayerDieType result = PlayerDieTypeOuterClass.PlayerDieType.valueOf(this.dieType_);
            return result == null ? PlayerDieTypeOuterClass.PlayerDieType.UNRECOGNIZED : result;
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
            for (int i = 0; i < this.serverBuffList_.size(); i++) {
                output.writeMessage(2, this.serverBuffList_.get(i));
            }
            if (this.moveReliableSeq_ != 0) {
                output.writeUInt32(5, this.moveReliableSeq_);
            }
            if (this.dieType_ != PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE.getNumber()) {
                output.writeEnum(6, this.dieType_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(7, this.entityId_);
            }
            if (this.lifeState_ != 0) {
                output.writeUInt32(9, this.lifeState_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.attackTag_)) {
                GeneratedMessageV3.writeString(output, 13, this.attackTag_);
            }
            if (this.sourceEntityId_ != 0) {
                output.writeUInt32(15, this.sourceEntityId_);
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
            for (int i = 0; i < this.serverBuffList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.serverBuffList_.get(i));
            }
            if (this.moveReliableSeq_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.moveReliableSeq_);
            }
            if (this.dieType_ != PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(6, this.dieType_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.entityId_);
            }
            if (this.lifeState_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.lifeState_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.attackTag_)) {
                size2 += GeneratedMessageV3.computeStringSize(13, this.attackTag_);
            }
            if (this.sourceEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.sourceEntityId_);
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
            if (!(obj instanceof LifeStateChangeNotify)) {
                return equals(obj);
            }
            LifeStateChangeNotify other = (LifeStateChangeNotify) obj;
            return getEntityId() == other.getEntityId() && getServerBuffListList().equals(other.getServerBuffListList()) && getMoveReliableSeq() == other.getMoveReliableSeq() && getAttackTag().equals(other.getAttackTag()) && getSourceEntityId() == other.getSourceEntityId() && getLifeState() == other.getLifeState() && this.dieType_ == other.dieType_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + getEntityId();
            if (getServerBuffListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getServerBuffListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 5)) + getMoveReliableSeq())) + 13)) + getAttackTag().hashCode())) + 15)) + getSourceEntityId())) + 9)) + getLifeState())) + 6)) + this.dieType_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static LifeStateChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LifeStateChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LifeStateChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LifeStateChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LifeStateChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LifeStateChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LifeStateChangeNotify parseFrom(InputStream input) throws IOException {
            return (LifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LifeStateChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LifeStateChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (LifeStateChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LifeStateChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LifeStateChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LifeStateChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (LifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LifeStateChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LifeStateChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LifeStateChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LifeStateChangeNotifyOuterClass$LifeStateChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LifeStateChangeNotifyOrBuilder {
            private int bitField0_;
            private int entityId_;
            private RepeatedFieldBuilderV3<ServerBuffOuterClass.ServerBuff, ServerBuffOuterClass.ServerBuff.Builder, ServerBuffOuterClass.ServerBuffOrBuilder> serverBuffListBuilder_;
            private int moveReliableSeq_;
            private int sourceEntityId_;
            private int lifeState_;
            private List<ServerBuffOuterClass.ServerBuff> serverBuffList_ = Collections.emptyList();
            private Object attackTag_ = "";
            private int dieType_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return LifeStateChangeNotifyOuterClass.internal_static_LifeStateChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LifeStateChangeNotifyOuterClass.internal_static_LifeStateChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(LifeStateChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LifeStateChangeNotify.alwaysUseFieldBuilders) {
                    getServerBuffListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                if (this.serverBuffListBuilder_ == null) {
                    this.serverBuffList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.serverBuffListBuilder_.clear();
                }
                this.moveReliableSeq_ = 0;
                this.attackTag_ = "";
                this.sourceEntityId_ = 0;
                this.lifeState_ = 0;
                this.dieType_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LifeStateChangeNotifyOuterClass.internal_static_LifeStateChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LifeStateChangeNotify getDefaultInstanceForType() {
                return LifeStateChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LifeStateChangeNotify build() {
                LifeStateChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LifeStateChangeNotify buildPartial() {
                LifeStateChangeNotify result = new LifeStateChangeNotify(this);
                int i = this.bitField0_;
                result.entityId_ = this.entityId_;
                if (this.serverBuffListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.serverBuffList_ = Collections.unmodifiableList(this.serverBuffList_);
                        this.bitField0_ &= -2;
                    }
                    result.serverBuffList_ = this.serverBuffList_;
                } else {
                    result.serverBuffList_ = this.serverBuffListBuilder_.build();
                }
                result.moveReliableSeq_ = this.moveReliableSeq_;
                result.attackTag_ = this.attackTag_;
                result.sourceEntityId_ = this.sourceEntityId_;
                result.lifeState_ = this.lifeState_;
                result.dieType_ = this.dieType_;
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
                if (other instanceof LifeStateChangeNotify) {
                    return mergeFrom((LifeStateChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LifeStateChangeNotify other) {
                if (other == LifeStateChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
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
                        this.serverBuffListBuilder_ = LifeStateChangeNotify.alwaysUseFieldBuilders ? getServerBuffListFieldBuilder() : null;
                    } else {
                        this.serverBuffListBuilder_.addAllMessages(other.serverBuffList_);
                    }
                }
                if (other.getMoveReliableSeq() != 0) {
                    setMoveReliableSeq(other.getMoveReliableSeq());
                }
                if (!other.getAttackTag().isEmpty()) {
                    this.attackTag_ = other.attackTag_;
                    onChanged();
                }
                if (other.getSourceEntityId() != 0) {
                    setSourceEntityId(other.getSourceEntityId());
                }
                if (other.getLifeState() != 0) {
                    setLifeState(other.getLifeState());
                }
                if (other.dieType_ != 0) {
                    setDieTypeValue(other.getDieTypeValue());
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
                LifeStateChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = LifeStateChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LifeStateChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
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

            private void ensureServerBuffListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.serverBuffList_ = new ArrayList(this.serverBuffList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public List<ServerBuffOuterClass.ServerBuff> getServerBuffListList() {
                if (this.serverBuffListBuilder_ == null) {
                    return Collections.unmodifiableList(this.serverBuffList_);
                }
                return this.serverBuffListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public int getServerBuffListCount() {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.size();
                }
                return this.serverBuffListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public ServerBuffOuterClass.ServerBuffOrBuilder getServerBuffListOrBuilder(int index) {
                if (this.serverBuffListBuilder_ == null) {
                    return this.serverBuffList_.get(index);
                }
                return this.serverBuffListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public int getMoveReliableSeq() {
                return this.moveReliableSeq_;
            }

            public Builder setMoveReliableSeq(int value) {
                this.moveReliableSeq_ = value;
                onChanged();
                return this;
            }

            public Builder clearMoveReliableSeq() {
                this.moveReliableSeq_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public String getAttackTag() {
                Object ref = this.attackTag_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.attackTag_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public ByteString getAttackTagBytes() {
                Object ref = this.attackTag_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.attackTag_ = b;
                return b;
            }

            public Builder setAttackTag(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.attackTag_ = value;
                onChanged();
                return this;
            }

            public Builder clearAttackTag() {
                this.attackTag_ = LifeStateChangeNotify.getDefaultInstance().getAttackTag();
                onChanged();
                return this;
            }

            public Builder setAttackTagBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                LifeStateChangeNotify.checkByteStringIsUtf8(value);
                this.attackTag_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public int getSourceEntityId() {
                return this.sourceEntityId_;
            }

            public Builder setSourceEntityId(int value) {
                this.sourceEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSourceEntityId() {
                this.sourceEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public int getLifeState() {
                return this.lifeState_;
            }

            public Builder setLifeState(int value) {
                this.lifeState_ = value;
                onChanged();
                return this;
            }

            public Builder clearLifeState() {
                this.lifeState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public int getDieTypeValue() {
                return this.dieType_;
            }

            public Builder setDieTypeValue(int value) {
                this.dieType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LifeStateChangeNotifyOuterClass.LifeStateChangeNotifyOrBuilder
            public PlayerDieTypeOuterClass.PlayerDieType getDieType() {
                PlayerDieTypeOuterClass.PlayerDieType result = PlayerDieTypeOuterClass.PlayerDieType.valueOf(this.dieType_);
                return result == null ? PlayerDieTypeOuterClass.PlayerDieType.UNRECOGNIZED : result;
            }

            public Builder setDieType(PlayerDieTypeOuterClass.PlayerDieType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dieType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearDieType() {
                this.dieType_ = 0;
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

        public static LifeStateChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LifeStateChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LifeStateChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LifeStateChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PlayerDieTypeOuterClass.getDescriptor();
        ServerBuffOuterClass.getDescriptor();
    }
}
