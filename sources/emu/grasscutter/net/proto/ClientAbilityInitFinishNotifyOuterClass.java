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
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAbilityInitFinishNotifyOuterClass.class */
public final class ClientAbilityInitFinishNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#ClientAbilityInitFinishNotify.proto\u001a\u0018AbilityInvokeEntry.proto\"W\n\u001dClientAbilityInitFinishNotify\u0012\u0010\n\bentityId\u0018\u0001 \u0001(\r\u0012$\n\u0007invokes\u0018\u000e \u0003(\u000b2\u0013.AbilityInvokeEntryB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityInvokeEntryOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ClientAbilityInitFinishNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ClientAbilityInitFinishNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ClientAbilityInitFinishNotify_descriptor, new String[]{"EntityId", "Invokes"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAbilityInitFinishNotifyOuterClass$ClientAbilityInitFinishNotifyOrBuilder.class */
    public interface ClientAbilityInitFinishNotifyOrBuilder extends MessageOrBuilder {
        int getEntityId();

        List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getInvokesList();

        AbilityInvokeEntryOuterClass.AbilityInvokeEntry getInvokes(int i);

        int getInvokesCount();

        List<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesOrBuilderList();

        AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder getInvokesOrBuilder(int i);
    }

    private ClientAbilityInitFinishNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAbilityInitFinishNotifyOuterClass$ClientAbilityInitFinishNotify.class */
    public static final class ClientAbilityInitFinishNotify extends GeneratedMessageV3 implements ClientAbilityInitFinishNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ENTITYID_FIELD_NUMBER = 1;
        private int entityId_;
        public static final int INVOKES_FIELD_NUMBER = 14;
        private List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> invokes_;
        private byte memoizedIsInitialized;
        private static final ClientAbilityInitFinishNotify DEFAULT_INSTANCE = new ClientAbilityInitFinishNotify();
        private static final Parser<ClientAbilityInitFinishNotify> PARSER = new AbstractParser<ClientAbilityInitFinishNotify>() { // from class: emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotify.1
            @Override // com.google.protobuf.Parser
            public ClientAbilityInitFinishNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ClientAbilityInitFinishNotify(input, extensionRegistry);
            }
        };

        private ClientAbilityInitFinishNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ClientAbilityInitFinishNotify() {
            this.memoizedIsInitialized = -1;
            this.invokes_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ClientAbilityInitFinishNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ClientAbilityInitFinishNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 8:
                                    this.entityId_ = input.readUInt32();
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.invokes_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.invokes_.add((AbilityInvokeEntryOuterClass.AbilityInvokeEntry) input.readMessage(AbilityInvokeEntryOuterClass.AbilityInvokeEntry.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.invokes_ = Collections.unmodifiableList(this.invokes_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ClientAbilityInitFinishNotifyOuterClass.internal_static_ClientAbilityInitFinishNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ClientAbilityInitFinishNotifyOuterClass.internal_static_ClientAbilityInitFinishNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientAbilityInitFinishNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
        public int getEntityId() {
            return this.entityId_;
        }

        @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
        public List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getInvokesList() {
            return this.invokes_;
        }

        @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
        public List<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesOrBuilderList() {
            return this.invokes_;
        }

        @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
        public int getInvokesCount() {
            return this.invokes_.size();
        }

        @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
        public AbilityInvokeEntryOuterClass.AbilityInvokeEntry getInvokes(int index) {
            return this.invokes_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
        public AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder getInvokesOrBuilder(int index) {
            return this.invokes_.get(index);
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
            if (this.entityId_ != 0) {
                output.writeUInt32(1, this.entityId_);
            }
            for (int i = 0; i < this.invokes_.size(); i++) {
                output.writeMessage(14, this.invokes_.get(i));
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
            if (this.entityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.entityId_);
            }
            for (int i = 0; i < this.invokes_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.invokes_.get(i));
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
            if (!(obj instanceof ClientAbilityInitFinishNotify)) {
                return equals(obj);
            }
            ClientAbilityInitFinishNotify other = (ClientAbilityInitFinishNotify) obj;
            return getEntityId() == other.getEntityId() && getInvokesList().equals(other.getInvokesList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getEntityId();
            if (getInvokesCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getInvokesList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ClientAbilityInitFinishNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientAbilityInitFinishNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientAbilityInitFinishNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientAbilityInitFinishNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientAbilityInitFinishNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ClientAbilityInitFinishNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ClientAbilityInitFinishNotify parseFrom(InputStream input) throws IOException {
            return (ClientAbilityInitFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientAbilityInitFinishNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientAbilityInitFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientAbilityInitFinishNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ClientAbilityInitFinishNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ClientAbilityInitFinishNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientAbilityInitFinishNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ClientAbilityInitFinishNotify parseFrom(CodedInputStream input) throws IOException {
            return (ClientAbilityInitFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ClientAbilityInitFinishNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ClientAbilityInitFinishNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ClientAbilityInitFinishNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ClientAbilityInitFinishNotifyOuterClass$ClientAbilityInitFinishNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ClientAbilityInitFinishNotifyOrBuilder {
            private int bitField0_;
            private int entityId_;
            private List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> invokes_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AbilityInvokeEntryOuterClass.AbilityInvokeEntry, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder, AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> invokesBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ClientAbilityInitFinishNotifyOuterClass.internal_static_ClientAbilityInitFinishNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ClientAbilityInitFinishNotifyOuterClass.internal_static_ClientAbilityInitFinishNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ClientAbilityInitFinishNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ClientAbilityInitFinishNotify.alwaysUseFieldBuilders) {
                    getInvokesFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.entityId_ = 0;
                if (this.invokesBuilder_ == null) {
                    this.invokes_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.invokesBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ClientAbilityInitFinishNotifyOuterClass.internal_static_ClientAbilityInitFinishNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ClientAbilityInitFinishNotify getDefaultInstanceForType() {
                return ClientAbilityInitFinishNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientAbilityInitFinishNotify build() {
                ClientAbilityInitFinishNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ClientAbilityInitFinishNotify buildPartial() {
                ClientAbilityInitFinishNotify result = new ClientAbilityInitFinishNotify(this);
                int i = this.bitField0_;
                result.entityId_ = this.entityId_;
                if (this.invokesBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.invokes_ = Collections.unmodifiableList(this.invokes_);
                        this.bitField0_ &= -2;
                    }
                    result.invokes_ = this.invokes_;
                } else {
                    result.invokes_ = this.invokesBuilder_.build();
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
                if (other instanceof ClientAbilityInitFinishNotify) {
                    return mergeFrom((ClientAbilityInitFinishNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ClientAbilityInitFinishNotify other) {
                if (other == ClientAbilityInitFinishNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getEntityId() != 0) {
                    setEntityId(other.getEntityId());
                }
                if (this.invokesBuilder_ == null) {
                    if (!other.invokes_.isEmpty()) {
                        if (this.invokes_.isEmpty()) {
                            this.invokes_ = other.invokes_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInvokesIsMutable();
                            this.invokes_.addAll(other.invokes_);
                        }
                        onChanged();
                    }
                } else if (!other.invokes_.isEmpty()) {
                    if (this.invokesBuilder_.isEmpty()) {
                        this.invokesBuilder_.dispose();
                        this.invokesBuilder_ = null;
                        this.invokes_ = other.invokes_;
                        this.bitField0_ &= -2;
                        this.invokesBuilder_ = ClientAbilityInitFinishNotify.alwaysUseFieldBuilders ? getInvokesFieldBuilder() : null;
                    } else {
                        this.invokesBuilder_.addAllMessages(other.invokes_);
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
                ClientAbilityInitFinishNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ClientAbilityInitFinishNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ClientAbilityInitFinishNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
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

            private void ensureInvokesIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.invokes_ = new ArrayList(this.invokes_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
            public List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getInvokesList() {
                if (this.invokesBuilder_ == null) {
                    return Collections.unmodifiableList(this.invokes_);
                }
                return this.invokesBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
            public int getInvokesCount() {
                if (this.invokesBuilder_ == null) {
                    return this.invokes_.size();
                }
                return this.invokesBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry getInvokes(int index) {
                if (this.invokesBuilder_ == null) {
                    return this.invokes_.get(index);
                }
                return this.invokesBuilder_.getMessage(index);
            }

            public Builder setInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry value) {
                if (this.invokesBuilder_ != null) {
                    this.invokesBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokesIsMutable();
                    this.invokes_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder builderForValue) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.invokesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInvokes(AbilityInvokeEntryOuterClass.AbilityInvokeEntry value) {
                if (this.invokesBuilder_ != null) {
                    this.invokesBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokesIsMutable();
                    this.invokes_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry value) {
                if (this.invokesBuilder_ != null) {
                    this.invokesBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokesIsMutable();
                    this.invokes_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInvokes(AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder builderForValue) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.invokesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInvokes(int index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder builderForValue) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.invokesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInvokes(Iterable<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntry> values) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.invokes_);
                    onChanged();
                } else {
                    this.invokesBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInvokes() {
                if (this.invokesBuilder_ == null) {
                    this.invokes_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.invokesBuilder_.clear();
                }
                return this;
            }

            public Builder removeInvokes(int index) {
                if (this.invokesBuilder_ == null) {
                    ensureInvokesIsMutable();
                    this.invokes_.remove(index);
                    onChanged();
                } else {
                    this.invokesBuilder_.remove(index);
                }
                return this;
            }

            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder getInvokesBuilder(int index) {
                return getInvokesFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
            public AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder getInvokesOrBuilder(int index) {
                if (this.invokesBuilder_ == null) {
                    return this.invokes_.get(index);
                }
                return this.invokesBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotifyOrBuilder
            public List<? extends AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesOrBuilderList() {
                if (this.invokesBuilder_ != null) {
                    return this.invokesBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.invokes_);
            }

            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder addInvokesBuilder() {
                return getInvokesFieldBuilder().addBuilder(AbilityInvokeEntryOuterClass.AbilityInvokeEntry.getDefaultInstance());
            }

            public AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder addInvokesBuilder(int index) {
                return getInvokesFieldBuilder().addBuilder(index, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.getDefaultInstance());
            }

            public List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder> getInvokesBuilderList() {
                return getInvokesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityInvokeEntryOuterClass.AbilityInvokeEntry, AbilityInvokeEntryOuterClass.AbilityInvokeEntry.Builder, AbilityInvokeEntryOuterClass.AbilityInvokeEntryOrBuilder> getInvokesFieldBuilder() {
                if (this.invokesBuilder_ == null) {
                    this.invokesBuilder_ = new RepeatedFieldBuilderV3<>(this.invokes_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.invokes_ = null;
                }
                return this.invokesBuilder_;
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

        public static ClientAbilityInitFinishNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ClientAbilityInitFinishNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ClientAbilityInitFinishNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ClientAbilityInitFinishNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityInvokeEntryOuterClass.getDescriptor();
    }
}
