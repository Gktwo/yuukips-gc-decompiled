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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkReqOuterClass.class */
public final class NpcTalkReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010NpcTalkReq.proto\"G\n\nNpcTalkReq\u0012\u0011\n\tentity_id\u0018\u000e \u0001(\r\u0012\u0015\n\rnpc_entity_id\u0018\u000b \u0001(\r\u0012\u000f\n\u0007talk_id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_NpcTalkReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_NpcTalkReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_NpcTalkReq_descriptor, new String[]{"EntityId", "NpcEntityId", "TalkId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkReqOuterClass$NpcTalkReqOrBuilder.class */
    public interface NpcTalkReqOrBuilder extends MessageOrBuilder {
        int getEntityId();

        int getNpcEntityId();

        int getTalkId();
    }

    private NpcTalkReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkReqOuterClass$NpcTalkReq.class */
    public static final class NpcTalkReq extends GeneratedMessageV3 implements NpcTalkReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITY_ID_FIELD_NUMBER = 14;
        private int entityId_;
        public static final int NPC_ENTITY_ID_FIELD_NUMBER = 11;
        private int npcEntityId_;
        public static final int TALK_ID_FIELD_NUMBER = 12;
        private int talkId_;
        private byte memoizedIsInitialized;
        private static final NpcTalkReq DEFAULT_INSTANCE = new NpcTalkReq();
        private static final Parser<NpcTalkReq> PARSER = new AbstractParser<NpcTalkReq>() { // from class: emu.grasscutter.net.proto.NpcTalkReqOuterClass.NpcTalkReq.1
            @Override // com.google.protobuf.Parser
            public NpcTalkReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new NpcTalkReq(input, extensionRegistry);
            }
        };

        private NpcTalkReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private NpcTalkReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new NpcTalkReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NpcTalkReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 88:
                                    this.npcEntityId_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.talkId_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.entityId_ = input.readUInt32();
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
                        }
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
            return NpcTalkReqOuterClass.internal_static_NpcTalkReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return NpcTalkReqOuterClass.internal_static_NpcTalkReq_fieldAccessorTable.ensureFieldAccessorsInitialized(NpcTalkReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.NpcTalkReqOuterClass.NpcTalkReqOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.NpcTalkReqOuterClass.NpcTalkReqOrBuilder
        public int getNpcEntityId() {
            return this.npcEntityId_;
        }

        @Override // emu.grasscutter.net.proto.NpcTalkReqOuterClass.NpcTalkReqOrBuilder
        public int getTalkId() {
            return this.talkId_;
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
            if (this.npcEntityId_ != 0) {
                output.writeUInt32(11, this.npcEntityId_);
            }
            if (this.talkId_ != 0) {
                output.writeUInt32(12, this.talkId_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(14, this.entityId_);
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
            if (this.npcEntityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(11, this.npcEntityId_);
            }
            if (this.talkId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.talkId_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.entityId_);
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
            if (!(obj instanceof NpcTalkReq)) {
                return equals(obj);
            }
            NpcTalkReq other = (NpcTalkReq) obj;
            return getEntityId() == other.getEntityId() && getNpcEntityId() == other.getNpcEntityId() && getTalkId() == other.getTalkId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getEntityId())) + 11)) + getNpcEntityId())) + 12)) + getTalkId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static NpcTalkReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NpcTalkReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NpcTalkReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NpcTalkReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NpcTalkReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NpcTalkReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NpcTalkReq parseFrom(InputStream input) throws IOException {
            return (NpcTalkReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static NpcTalkReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NpcTalkReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static NpcTalkReq parseDelimitedFrom(InputStream input) throws IOException {
            return (NpcTalkReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static NpcTalkReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NpcTalkReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static NpcTalkReq parseFrom(CodedInputStream input) throws IOException {
            return (NpcTalkReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static NpcTalkReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NpcTalkReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(NpcTalkReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkReqOuterClass$NpcTalkReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NpcTalkReqOrBuilder {
            private int entityId_;
            private int npcEntityId_;
            private int talkId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return NpcTalkReqOuterClass.internal_static_NpcTalkReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return NpcTalkReqOuterClass.internal_static_NpcTalkReq_fieldAccessorTable.ensureFieldAccessorsInitialized(NpcTalkReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (NpcTalkReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                this.npcEntityId_ = 0;
                this.talkId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return NpcTalkReqOuterClass.internal_static_NpcTalkReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NpcTalkReq getDefaultInstanceForType() {
                return NpcTalkReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NpcTalkReq build() {
                NpcTalkReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NpcTalkReq buildPartial() {
                NpcTalkReq result = new NpcTalkReq(this);
                result.entityId_ = this.entityId_;
                result.npcEntityId_ = this.npcEntityId_;
                result.talkId_ = this.talkId_;
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
                if (other instanceof NpcTalkReq) {
                    return mergeFrom((NpcTalkReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(NpcTalkReq other) {
                if (other == NpcTalkReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (other.getNpcEntityId() != 0) {
                    setNpcEntityId(other.getNpcEntityId());
                }
                if (other.getTalkId() != 0) {
                    setTalkId(other.getTalkId());
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
                NpcTalkReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = NpcTalkReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (NpcTalkReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.NpcTalkReqOuterClass.NpcTalkReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.NpcTalkReqOuterClass.NpcTalkReqOrBuilder
            public int getNpcEntityId() {
                return this.npcEntityId_;
            }

            public Builder setNpcEntityId(int value) {
                this.npcEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNpcEntityId() {
                this.npcEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.NpcTalkReqOuterClass.NpcTalkReqOrBuilder
            public int getTalkId() {
                return this.talkId_;
            }

            public Builder setTalkId(int value) {
                this.talkId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTalkId() {
                this.talkId_ = 0;
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

        public static NpcTalkReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NpcTalkReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<NpcTalkReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NpcTalkReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
