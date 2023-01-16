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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkTargetInvestigationMonsterNotifyOuterClass.class */
public final class MarkTargetInvestigationMonsterNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n*MarkTargetInvestigationMonsterNotify.proto\"\u0001\n$MarkTargetInvestigationMonsterNotify\u0012\u0012\n\nmonster_id\u0018\n \u0001(\r\u0012\u0010\n\bscene_id\u0018\u0007 \u0001(\r\u0012\u0010\n\bgroup_id\u0018\u000f \u0001(\r\u0012 \n\u0018investigation_monster_id\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MarkTargetInvestigationMonsterNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_MarkTargetInvestigationMonsterNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f776xc305d0be = new GeneratedMessageV3.FieldAccessorTable(internal_static_MarkTargetInvestigationMonsterNotify_descriptor, new String[]{"MonsterId", "SceneId", "GroupId", "InvestigationMonsterId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkTargetInvestigationMonsterNotifyOuterClass$MarkTargetInvestigationMonsterNotifyOrBuilder.class */
    public interface MarkTargetInvestigationMonsterNotifyOrBuilder extends MessageOrBuilder {
        int getMonsterId();

        int getSceneId();

        int getGroupId();

        int getInvestigationMonsterId();
    }

    private MarkTargetInvestigationMonsterNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkTargetInvestigationMonsterNotifyOuterClass$MarkTargetInvestigationMonsterNotify.class */
    public static final class MarkTargetInvestigationMonsterNotify extends GeneratedMessageV3 implements MarkTargetInvestigationMonsterNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MONSTER_ID_FIELD_NUMBER = 10;
        private int monsterId_;
        public static final int SCENE_ID_FIELD_NUMBER = 7;
        private int sceneId_;
        public static final int GROUP_ID_FIELD_NUMBER = 15;
        private int groupId_;
        public static final int INVESTIGATION_MONSTER_ID_FIELD_NUMBER = 3;
        private int investigationMonsterId_;
        private byte memoizedIsInitialized;
        private static final MarkTargetInvestigationMonsterNotify DEFAULT_INSTANCE = new MarkTargetInvestigationMonsterNotify();
        private static final Parser<MarkTargetInvestigationMonsterNotify> PARSER = new AbstractParser<MarkTargetInvestigationMonsterNotify>() { // from class: emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotify.1
            @Override // com.google.protobuf.Parser
            public MarkTargetInvestigationMonsterNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MarkTargetInvestigationMonsterNotify(input, extensionRegistry);
            }
        };

        private MarkTargetInvestigationMonsterNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MarkTargetInvestigationMonsterNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MarkTargetInvestigationMonsterNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MarkTargetInvestigationMonsterNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.investigationMonsterId_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.monsterId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.groupId_ = input.readUInt32();
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
            return MarkTargetInvestigationMonsterNotifyOuterClass.internal_static_MarkTargetInvestigationMonsterNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MarkTargetInvestigationMonsterNotifyOuterClass.f776xc305d0be.ensureFieldAccessorsInitialized(MarkTargetInvestigationMonsterNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
        public int getMonsterId() {
            return this.monsterId_;
        }

        @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
        public int getSceneId() {
            return this.sceneId_;
        }

        @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
        public int getInvestigationMonsterId() {
            return this.investigationMonsterId_;
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
            if (this.investigationMonsterId_ != 0) {
                output.writeUInt32(3, this.investigationMonsterId_);
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(7, this.sceneId_);
            }
            if (this.monsterId_ != 0) {
                output.writeUInt32(10, this.monsterId_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(15, this.groupId_);
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
            if (this.investigationMonsterId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.investigationMonsterId_);
            }
            if (this.sceneId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.sceneId_);
            }
            if (this.monsterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.monsterId_);
            }
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.groupId_);
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
            if (!(obj instanceof MarkTargetInvestigationMonsterNotify)) {
                return equals(obj);
            }
            MarkTargetInvestigationMonsterNotify other = (MarkTargetInvestigationMonsterNotify) obj;
            return getMonsterId() == other.getMonsterId() && getSceneId() == other.getSceneId() && getGroupId() == other.getGroupId() && getInvestigationMonsterId() == other.getInvestigationMonsterId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getMonsterId())) + 7)) + getSceneId())) + 15)) + getGroupId())) + 3)) + getInvestigationMonsterId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(InputStream input) throws IOException {
            return (MarkTargetInvestigationMonsterNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkTargetInvestigationMonsterNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MarkTargetInvestigationMonsterNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MarkTargetInvestigationMonsterNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MarkTargetInvestigationMonsterNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkTargetInvestigationMonsterNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(CodedInputStream input) throws IOException {
            return (MarkTargetInvestigationMonsterNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MarkTargetInvestigationMonsterNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkTargetInvestigationMonsterNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MarkTargetInvestigationMonsterNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkTargetInvestigationMonsterNotifyOuterClass$MarkTargetInvestigationMonsterNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MarkTargetInvestigationMonsterNotifyOrBuilder {
            private int monsterId_;
            private int sceneId_;
            private int groupId_;
            private int investigationMonsterId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MarkTargetInvestigationMonsterNotifyOuterClass.internal_static_MarkTargetInvestigationMonsterNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MarkTargetInvestigationMonsterNotifyOuterClass.f776xc305d0be.ensureFieldAccessorsInitialized(MarkTargetInvestigationMonsterNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MarkTargetInvestigationMonsterNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.monsterId_ = 0;
                this.sceneId_ = 0;
                this.groupId_ = 0;
                this.investigationMonsterId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MarkTargetInvestigationMonsterNotifyOuterClass.internal_static_MarkTargetInvestigationMonsterNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MarkTargetInvestigationMonsterNotify getDefaultInstanceForType() {
                return MarkTargetInvestigationMonsterNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MarkTargetInvestigationMonsterNotify build() {
                MarkTargetInvestigationMonsterNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MarkTargetInvestigationMonsterNotify buildPartial() {
                MarkTargetInvestigationMonsterNotify result = new MarkTargetInvestigationMonsterNotify(this);
                result.monsterId_ = this.monsterId_;
                result.sceneId_ = this.sceneId_;
                result.groupId_ = this.groupId_;
                result.investigationMonsterId_ = this.investigationMonsterId_;
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
                if (other instanceof MarkTargetInvestigationMonsterNotify) {
                    return mergeFrom((MarkTargetInvestigationMonsterNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MarkTargetInvestigationMonsterNotify other) {
                if (other == MarkTargetInvestigationMonsterNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getMonsterId() != 0) {
                    setMonsterId(other.getMonsterId());
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.getInvestigationMonsterId() != 0) {
                    setInvestigationMonsterId(other.getInvestigationMonsterId());
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
                MarkTargetInvestigationMonsterNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = MarkTargetInvestigationMonsterNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MarkTargetInvestigationMonsterNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            public Builder setGroupId(int value) {
                this.groupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MarkTargetInvestigationMonsterNotifyOuterClass.MarkTargetInvestigationMonsterNotifyOrBuilder
            public int getInvestigationMonsterId() {
                return this.investigationMonsterId_;
            }

            public Builder setInvestigationMonsterId(int value) {
                this.investigationMonsterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearInvestigationMonsterId() {
                this.investigationMonsterId_ = 0;
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

        public static MarkTargetInvestigationMonsterNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MarkTargetInvestigationMonsterNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MarkTargetInvestigationMonsterNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MarkTargetInvestigationMonsterNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
