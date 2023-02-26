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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkRspOuterClass.class */
public final class NpcTalkRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010NpcTalkRsp.proto\"W\n\nNpcTalkRsp\u0012\u000f\n\u0007retcode\u0018\u0005 \u0001(\u0005\u0012\u0013\n\u000bnpcEntityId\u0018\u000b \u0001(\r\u0012\u0011\n\tcurTalkId\u0018\u0001 \u0001(\r\u0012\u0010\n\bentityId\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_NpcTalkRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_NpcTalkRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_NpcTalkRsp_descriptor, new String[]{"Retcode", "NpcEntityId", "CurTalkId", "EntityId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkRspOuterClass$NpcTalkRspOrBuilder.class */
    public interface NpcTalkRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getNpcEntityId();

        int getCurTalkId();

        int getEntityId();
    }

    private NpcTalkRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkRspOuterClass$NpcTalkRsp.class */
    public static final class NpcTalkRsp extends GeneratedMessageV3 implements NpcTalkRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 5;
        private int retcode_;
        public static final int NPCENTITYID_FIELD_NUMBER = 11;
        private int npcEntityId_;
        public static final int CURTALKID_FIELD_NUMBER = 1;
        private int curTalkId_;
        public static final int ENTITYID_FIELD_NUMBER = 9;
        private int entityId_;
        private byte memoizedIsInitialized;
        private static final NpcTalkRsp DEFAULT_INSTANCE = new NpcTalkRsp();
        private static final Parser<NpcTalkRsp> PARSER = new AbstractParser<NpcTalkRsp>() { // from class: emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRsp.1
            @Override // com.google.protobuf.Parser
            public NpcTalkRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new NpcTalkRsp(input, extensionRegistry);
            }
        };

        private NpcTalkRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private NpcTalkRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new NpcTalkRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private NpcTalkRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.curTalkId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 72:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.npcEntityId_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return NpcTalkRspOuterClass.internal_static_NpcTalkRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return NpcTalkRspOuterClass.internal_static_NpcTalkRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(NpcTalkRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
        public int getNpcEntityId() {
            return this.npcEntityId_;
        }

        @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
        public int getCurTalkId() {
            return this.curTalkId_;
        }

        @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
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
            if (this.curTalkId_ != 0) {
                output.writeUInt32(1, this.curTalkId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(5, this.retcode_);
            }
            if (this.entityId_ != 0) {
                output.writeUInt32(9, this.entityId_);
            }
            if (this.npcEntityId_ != 0) {
                output.writeUInt32(11, this.npcEntityId_);
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
            if (this.curTalkId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.curTalkId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.retcode_);
            }
            if (this.entityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.entityId_);
            }
            if (this.npcEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.npcEntityId_);
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
            if (!(obj instanceof NpcTalkRsp)) {
                return equals(obj);
            }
            NpcTalkRsp other = (NpcTalkRsp) obj;
            return getRetcode() == other.getRetcode() && getNpcEntityId() == other.getNpcEntityId() && getCurTalkId() == other.getCurTalkId() && getEntityId() == other.getEntityId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getRetcode())) + 11)) + getNpcEntityId())) + 1)) + getCurTalkId())) + 9)) + getEntityId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static NpcTalkRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NpcTalkRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NpcTalkRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NpcTalkRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NpcTalkRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static NpcTalkRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static NpcTalkRsp parseFrom(InputStream input) throws IOException {
            return (NpcTalkRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static NpcTalkRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NpcTalkRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static NpcTalkRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (NpcTalkRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static NpcTalkRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NpcTalkRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static NpcTalkRsp parseFrom(CodedInputStream input) throws IOException {
            return (NpcTalkRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static NpcTalkRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (NpcTalkRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(NpcTalkRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/NpcTalkRspOuterClass$NpcTalkRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NpcTalkRspOrBuilder {
            private int retcode_;
            private int npcEntityId_;
            private int curTalkId_;
            private int entityId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return NpcTalkRspOuterClass.internal_static_NpcTalkRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return NpcTalkRspOuterClass.internal_static_NpcTalkRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(NpcTalkRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (NpcTalkRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.npcEntityId_ = 0;
                this.curTalkId_ = 0;
                this.entityId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return NpcTalkRspOuterClass.internal_static_NpcTalkRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NpcTalkRsp getDefaultInstanceForType() {
                return NpcTalkRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NpcTalkRsp build() {
                NpcTalkRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public NpcTalkRsp buildPartial() {
                NpcTalkRsp result = new NpcTalkRsp(this);
                result.retcode_ = this.retcode_;
                result.npcEntityId_ = this.npcEntityId_;
                result.curTalkId_ = this.curTalkId_;
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
                if (other instanceof NpcTalkRsp) {
                    return mergeFrom((NpcTalkRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(NpcTalkRsp other) {
                if (other == NpcTalkRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getNpcEntityId() != 0) {
                    setNpcEntityId(other.getNpcEntityId());
                }
                if (other.getCurTalkId() != 0) {
                    setCurTalkId(other.getCurTalkId());
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
                NpcTalkRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = NpcTalkRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (NpcTalkRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
            public int getCurTalkId() {
                return this.curTalkId_;
            }

            public Builder setCurTalkId(int value) {
                this.curTalkId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurTalkId() {
                this.curTalkId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.NpcTalkRspOuterClass.NpcTalkRspOrBuilder
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

        public static NpcTalkRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<NpcTalkRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<NpcTalkRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public NpcTalkRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
