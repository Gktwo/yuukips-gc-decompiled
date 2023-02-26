package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilityInvokeArgumentOuterClass;
import emu.grasscutter.net.proto.AbilityInvokeEntryHeadOuterClass;
import emu.grasscutter.net.proto.ForwardTypeOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryOuterClass.class */
public final class AbilityInvokeEntryOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018AbilityInvokeEntry.proto\u001a\u001cAbilityInvokeEntryHead.proto\u001a\u0011ForwardType.proto\u001a\u001bAbilityInvokeArgument.proto\"\u0002\n\u0012AbilityInvokeEntry\u0012%\n\u0004head\u0018\r \u0001(\u000b2\u0017.AbilityInvokeEntryHead\u0012!\n\u000bforwardType\u0018\u000f \u0001(\u000e2\f.ForwardType\u0012,\n\fargumentType\u0018\f \u0001(\u000e2\u0016.AbilityInvokeArgument\u0012\u0013\n\u000bforwardPeer\u0018\n \u0001(\r\u0012\u0013\n\u000babilityData\u0018\u0004 \u0001(\f\u0012\u000f\n\u0007eventId\u0018\b \u0001(\r\u0012\u0010\n\bentityId\u0018\u000b \u0001(\r\u0012\u0015\n\rtotalTickTime\u0018\u000e \u0001(\u0001\u0012\u0014\n\fisIgnoreAuth\u0018\u0006 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityInvokeEntryHeadOuterClass.getDescriptor(), ForwardTypeOuterClass.getDescriptor(), AbilityInvokeArgumentOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityInvokeEntry_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityInvokeEntry_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityInvokeEntry_descriptor, new String[]{"Head", "ForwardType", "ArgumentType", "ForwardPeer", "AbilityData", "EventId", "EntityId", "TotalTickTime", "IsIgnoreAuth"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryOuterClass$AbilityInvokeEntryOrBuilder.class */
    public interface AbilityInvokeEntryOrBuilder extends MessageOrBuilder {
        boolean hasHead();

        AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead getHead();

        AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder getHeadOrBuilder();

        int getForwardTypeValue();

        ForwardTypeOuterClass.ForwardType getForwardType();

        int getArgumentTypeValue();

        AbilityInvokeArgumentOuterClass.AbilityInvokeArgument getArgumentType();

        int getForwardPeer();

        ByteString getAbilityData();

        int getEventId();

        int getEntityId();

        double getTotalTickTime();

        boolean getIsIgnoreAuth();
    }

    private AbilityInvokeEntryOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryOuterClass$AbilityInvokeEntry.class */
    public static final class AbilityInvokeEntry extends GeneratedMessageV3 implements AbilityInvokeEntryOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HEAD_FIELD_NUMBER = 13;
        private AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead head_;
        public static final int FORWARDTYPE_FIELD_NUMBER = 15;
        private int forwardType_;
        public static final int ARGUMENTTYPE_FIELD_NUMBER = 12;
        private int argumentType_;
        public static final int FORWARDPEER_FIELD_NUMBER = 10;
        private int forwardPeer_;
        public static final int ABILITYDATA_FIELD_NUMBER = 4;
        private ByteString abilityData_;
        public static final int EVENTID_FIELD_NUMBER = 8;
        private int eventId_;
        public static final int ENTITYID_FIELD_NUMBER = 11;
        private int entityId_;
        public static final int TOTALTICKTIME_FIELD_NUMBER = 14;
        private double totalTickTime_;
        public static final int ISIGNOREAUTH_FIELD_NUMBER = 6;
        private boolean isIgnoreAuth_;
        private byte memoizedIsInitialized;
        private static final AbilityInvokeEntry DEFAULT_INSTANCE = new AbilityInvokeEntry();
        private static final Parser<AbilityInvokeEntry> PARSER = new AbstractParser<AbilityInvokeEntry>() { // from class: emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntry.1
            @Override // com.google.protobuf.Parser
            public AbilityInvokeEntry parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityInvokeEntry(input, extensionRegistry);
            }
        };

        private AbilityInvokeEntry(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityInvokeEntry() {
            this.memoizedIsInitialized = -1;
            this.forwardType_ = 0;
            this.argumentType_ = 0;
            this.abilityData_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityInvokeEntry();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityInvokeEntry(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                this.abilityData_ = input.readBytes();
                                break;
                            case 48:
                                this.isIgnoreAuth_ = input.readBool();
                                break;
                            case 64:
                                this.eventId_ = input.readUInt32();
                                break;
                            case 80:
                                this.forwardPeer_ = input.readUInt32();
                                break;
                            case 88:
                                this.entityId_ = input.readUInt32();
                                break;
                            case 96:
                                this.argumentType_ = input.readEnum();
                                break;
                            case 106:
                                AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.Builder subBuilder = this.head_ != null ? this.head_.toBuilder() : null;
                                this.head_ = (AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead) input.readMessage(AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.head_);
                                    this.head_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 113:
                                this.totalTickTime_ = input.readDouble();
                                break;
                            case 120:
                                this.forwardType_ = input.readEnum();
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
            return AbilityInvokeEntryOuterClass.internal_static_AbilityInvokeEntry_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityInvokeEntryOuterClass.internal_static_AbilityInvokeEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityInvokeEntry.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public boolean hasHead() {
            return this.head_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead getHead() {
            return this.head_ == null ? AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.getDefaultInstance() : this.head_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder getHeadOrBuilder() {
            return getHead();
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public int getForwardTypeValue() {
            return this.forwardType_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public ForwardTypeOuterClass.ForwardType getForwardType() {
            ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
            return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public int getArgumentTypeValue() {
            return this.argumentType_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public AbilityInvokeArgumentOuterClass.AbilityInvokeArgument getArgumentType() {
            AbilityInvokeArgumentOuterClass.AbilityInvokeArgument result = AbilityInvokeArgumentOuterClass.AbilityInvokeArgument.valueOf(this.argumentType_);
            return result == null ? AbilityInvokeArgumentOuterClass.AbilityInvokeArgument.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public int getForwardPeer() {
            return this.forwardPeer_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public ByteString getAbilityData() {
            return this.abilityData_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public int getEventId() {
            return this.eventId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public double getTotalTickTime() {
            return this.totalTickTime_;
        }

        @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
        public boolean getIsIgnoreAuth() {
            return this.isIgnoreAuth_;
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
            if (!this.abilityData_.isEmpty()) {
                output.writeBytes(4, this.abilityData_);
            }
            if (this.isIgnoreAuth_) {
                output.writeBool(6, this.isIgnoreAuth_);
            }
            if (this.eventId_ != 0) {
                output.writeUInt32(8, this.eventId_);
            }
            if (this.forwardPeer_ != 0) {
                output.writeUInt32(10, this.forwardPeer_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(11, this.entityId_);
            }
            if (this.argumentType_ != AbilityInvokeArgumentOuterClass.AbilityInvokeArgument.ABILITY_INVOKE_ARGUMENT_NONE.getNumber()) {
                output.writeEnum(12, this.argumentType_);
            }
            if (this.head_ != null) {
                output.writeMessage(13, getHead());
            }
            if (this.totalTickTime_ != 0.0d) {
                output.writeDouble(14, this.totalTickTime_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                output.writeEnum(15, this.forwardType_);
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
            if (!this.abilityData_.isEmpty()) {
                size2 = 0 + CodedOutputStream.computeBytesSize(4, this.abilityData_);
            }
            if (this.isIgnoreAuth_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isIgnoreAuth_);
            }
            if (this.eventId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.eventId_);
            }
            if (this.forwardPeer_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.forwardPeer_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.entityId_);
            }
            if (this.argumentType_ != AbilityInvokeArgumentOuterClass.AbilityInvokeArgument.ABILITY_INVOKE_ARGUMENT_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.argumentType_);
            }
            if (this.head_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getHead());
            }
            if (this.totalTickTime_ != 0.0d) {
                size2 += CodedOutputStream.computeDoubleSize(14, this.totalTickTime_);
            }
            if (this.forwardType_ != ForwardTypeOuterClass.ForwardType.FORWARD_TYPE_LOCAL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(15, this.forwardType_);
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
            if (!(obj instanceof AbilityInvokeEntry)) {
                return equals(obj);
            }
            AbilityInvokeEntry other = (AbilityInvokeEntry) obj;
            if (hasHead() != other.hasHead()) {
                return false;
            }
            return (!hasHead() || getHead().equals(other.getHead())) && this.forwardType_ == other.forwardType_ && this.argumentType_ == other.argumentType_ && getForwardPeer() == other.getForwardPeer() && getAbilityData().equals(other.getAbilityData()) && getEventId() == other.getEventId() && getEntityId() == other.getEntityId() && Double.doubleToLongBits(getTotalTickTime()) == Double.doubleToLongBits(other.getTotalTickTime()) && getIsIgnoreAuth() == other.getIsIgnoreAuth() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasHead()) {
                hash = (53 * ((37 * hash) + 13)) + getHead().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 15)) + this.forwardType_)) + 12)) + this.argumentType_)) + 10)) + getForwardPeer())) + 4)) + getAbilityData().hashCode())) + 8)) + getEventId())) + 11)) + getEntityId())) + 14)) + Internal.hashLong(Double.doubleToLongBits(getTotalTickTime())))) + 6)) + Internal.hashBoolean(getIsIgnoreAuth()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AbilityInvokeEntry parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityInvokeEntry parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityInvokeEntry parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityInvokeEntry parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityInvokeEntry parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityInvokeEntry parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityInvokeEntry parseFrom(InputStream input) throws IOException {
            return (AbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityInvokeEntry parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityInvokeEntry parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityInvokeEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityInvokeEntry parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityInvokeEntry) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityInvokeEntry parseFrom(CodedInputStream input) throws IOException {
            return (AbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityInvokeEntry parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityInvokeEntry) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityInvokeEntry prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityInvokeEntryOuterClass$AbilityInvokeEntry$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityInvokeEntryOrBuilder {
            private AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead head_;
            private SingleFieldBuilderV3<AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead, AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.Builder, AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder> headBuilder_;
            private int forwardPeer_;
            private int eventId_;
            private int entityId_;
            private double totalTickTime_;
            private boolean isIgnoreAuth_;
            private int forwardType_ = 0;
            private int argumentType_ = 0;
            private ByteString abilityData_ = ByteString.EMPTY;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityInvokeEntryOuterClass.internal_static_AbilityInvokeEntry_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityInvokeEntryOuterClass.internal_static_AbilityInvokeEntry_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityInvokeEntry.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityInvokeEntry.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.headBuilder_ == null) {
                    this.head_ = null;
                } else {
                    this.head_ = null;
                    this.headBuilder_ = null;
                }
                this.forwardType_ = 0;
                this.argumentType_ = 0;
                this.forwardPeer_ = 0;
                this.abilityData_ = ByteString.EMPTY;
                this.eventId_ = 0;
                this.entityId_ = 0;
                this.totalTickTime_ = 0.0d;
                this.isIgnoreAuth_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityInvokeEntryOuterClass.internal_static_AbilityInvokeEntry_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityInvokeEntry getDefaultInstanceForType() {
                return AbilityInvokeEntry.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityInvokeEntry build() {
                AbilityInvokeEntry result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityInvokeEntry buildPartial() {
                AbilityInvokeEntry result = new AbilityInvokeEntry(this);
                if (this.headBuilder_ == null) {
                    result.head_ = this.head_;
                } else {
                    result.head_ = this.headBuilder_.build();
                }
                result.forwardType_ = this.forwardType_;
                result.argumentType_ = this.argumentType_;
                result.forwardPeer_ = this.forwardPeer_;
                result.abilityData_ = this.abilityData_;
                result.eventId_ = this.eventId_;
                result.entityId_ = this.entityId_;
                result.totalTickTime_ = this.totalTickTime_;
                result.isIgnoreAuth_ = this.isIgnoreAuth_;
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
                if (other instanceof AbilityInvokeEntry) {
                    return mergeFrom((AbilityInvokeEntry) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityInvokeEntry other) {
                if (other == AbilityInvokeEntry.getDefaultInstance()) {
                    return this;
                }
                if (other.hasHead()) {
                    mergeHead(other.getHead());
                }
                if (other.forwardType_ != 0) {
                    setForwardTypeValue(other.getForwardTypeValue());
                }
                if (other.argumentType_ != 0) {
                    setArgumentTypeValue(other.getArgumentTypeValue());
                }
                if (other.getForwardPeer() != 0) {
                    setForwardPeer(other.getForwardPeer());
                }
                if (other.getAbilityData() != ByteString.EMPTY) {
                    setAbilityData(other.getAbilityData());
                }
                if (other.getEventId() != 0) {
                    setEventId(other.getEventId());
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getTotalTickTime() != 0.0d) {
                    setTotalTickTime(other.getTotalTickTime());
                }
                if (other.getIsIgnoreAuth()) {
                    setIsIgnoreAuth(other.getIsIgnoreAuth());
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
                AbilityInvokeEntry parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityInvokeEntry.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityInvokeEntry) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public boolean hasHead() {
                return (this.headBuilder_ == null && this.head_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead getHead() {
                if (this.headBuilder_ == null) {
                    return this.head_ == null ? AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.getDefaultInstance() : this.head_;
                }
                return this.headBuilder_.getMessage();
            }

            public Builder setHead(AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead value) {
                if (this.headBuilder_ != null) {
                    this.headBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.head_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setHead(AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.Builder builderForValue) {
                if (this.headBuilder_ == null) {
                    this.head_ = builderForValue.build();
                    onChanged();
                } else {
                    this.headBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeHead(AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead value) {
                if (this.headBuilder_ == null) {
                    if (this.head_ != null) {
                        this.head_ = AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.newBuilder(this.head_).mergeFrom(value).buildPartial();
                    } else {
                        this.head_ = value;
                    }
                    onChanged();
                } else {
                    this.headBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearHead() {
                if (this.headBuilder_ == null) {
                    this.head_ = null;
                    onChanged();
                } else {
                    this.head_ = null;
                    this.headBuilder_ = null;
                }
                return this;
            }

            public AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.Builder getHeadBuilder() {
                onChanged();
                return getHeadFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder getHeadOrBuilder() {
                if (this.headBuilder_ != null) {
                    return this.headBuilder_.getMessageOrBuilder();
                }
                return this.head_ == null ? AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.getDefaultInstance() : this.head_;
            }

            private SingleFieldBuilderV3<AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead, AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHead.Builder, AbilityInvokeEntryHeadOuterClass.AbilityInvokeEntryHeadOrBuilder> getHeadFieldBuilder() {
                if (this.headBuilder_ == null) {
                    this.headBuilder_ = new SingleFieldBuilderV3<>(getHead(), getParentForChildren(), isClean());
                    this.head_ = null;
                }
                return this.headBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public int getForwardTypeValue() {
                return this.forwardType_;
            }

            public Builder setForwardTypeValue(int value) {
                this.forwardType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public ForwardTypeOuterClass.ForwardType getForwardType() {
                ForwardTypeOuterClass.ForwardType result = ForwardTypeOuterClass.ForwardType.valueOf(this.forwardType_);
                return result == null ? ForwardTypeOuterClass.ForwardType.UNRECOGNIZED : result;
            }

            public Builder setForwardType(ForwardTypeOuterClass.ForwardType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.forwardType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearForwardType() {
                this.forwardType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public int getArgumentTypeValue() {
                return this.argumentType_;
            }

            public Builder setArgumentTypeValue(int value) {
                this.argumentType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public AbilityInvokeArgumentOuterClass.AbilityInvokeArgument getArgumentType() {
                AbilityInvokeArgumentOuterClass.AbilityInvokeArgument result = AbilityInvokeArgumentOuterClass.AbilityInvokeArgument.valueOf(this.argumentType_);
                return result == null ? AbilityInvokeArgumentOuterClass.AbilityInvokeArgument.UNRECOGNIZED : result;
            }

            public Builder setArgumentType(AbilityInvokeArgumentOuterClass.AbilityInvokeArgument value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.argumentType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearArgumentType() {
                this.argumentType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public int getForwardPeer() {
                return this.forwardPeer_;
            }

            public Builder setForwardPeer(int value) {
                this.forwardPeer_ = value;
                onChanged();
                return this;
            }

            public Builder clearForwardPeer() {
                this.forwardPeer_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public ByteString getAbilityData() {
                return this.abilityData_;
            }

            public Builder setAbilityData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.abilityData_ = value;
                onChanged();
                return this;
            }

            public Builder clearAbilityData() {
                this.abilityData_ = AbilityInvokeEntry.getDefaultInstance().getAbilityData();
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public int getEventId() {
                return this.eventId_;
            }

            public Builder setEventId(int value) {
                this.eventId_ = value;
                onChanged();
                return this;
            }

            public Builder clearEventId() {
                this.eventId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
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

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public double getTotalTickTime() {
                return this.totalTickTime_;
            }

            public Builder setTotalTickTime(double value) {
                this.totalTickTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalTickTime() {
                this.totalTickTime_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder
            public boolean getIsIgnoreAuth() {
                return this.isIgnoreAuth_;
            }

            public Builder setIsIgnoreAuth(boolean value) {
                this.isIgnoreAuth_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsIgnoreAuth() {
                this.isIgnoreAuth_ = false;
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

        public static AbilityInvokeEntry getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityInvokeEntry> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityInvokeEntry> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityInvokeEntry getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityInvokeEntryHeadOuterClass.getDescriptor();
        ForwardTypeOuterClass.getDescriptor();
        AbilityInvokeArgumentOuterClass.getDescriptor();
    }
}
