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
import emu.grasscutter.net.proto.InvestigationMonsterOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterUpdateNotifyOuterClass.class */
public final class InvestigationMonsterUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n&InvestigationMonsterUpdateNotify.proto\u001a\u001aInvestigationMonster.proto\"X\n InvestigationMonsterUpdateNotify\u00124\n\u0015investigation_monster\u0018\u0006 \u0001(\u000b2\u0015.InvestigationMonsterB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{InvestigationMonsterOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_InvestigationMonsterUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_InvestigationMonsterUpdateNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f765x14f02893 = new GeneratedMessageV3.FieldAccessorTable(internal_static_InvestigationMonsterUpdateNotify_descriptor, new String[]{"InvestigationMonster"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterUpdateNotifyOuterClass$InvestigationMonsterUpdateNotifyOrBuilder.class */
    public interface InvestigationMonsterUpdateNotifyOrBuilder extends MessageOrBuilder {
        boolean hasInvestigationMonster();

        InvestigationMonsterOuterClass.InvestigationMonster getInvestigationMonster();

        InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder getInvestigationMonsterOrBuilder();
    }

    private InvestigationMonsterUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterUpdateNotifyOuterClass$InvestigationMonsterUpdateNotify.class */
    public static final class InvestigationMonsterUpdateNotify extends GeneratedMessageV3 implements InvestigationMonsterUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INVESTIGATION_MONSTER_FIELD_NUMBER = 6;
        private InvestigationMonsterOuterClass.InvestigationMonster investigationMonster_;
        private byte memoizedIsInitialized;
        private static final InvestigationMonsterUpdateNotify DEFAULT_INSTANCE = new InvestigationMonsterUpdateNotify();
        private static final Parser<InvestigationMonsterUpdateNotify> PARSER = new AbstractParser<InvestigationMonsterUpdateNotify>() { // from class: emu.grasscutter.net.proto.InvestigationMonsterUpdateNotifyOuterClass.InvestigationMonsterUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public InvestigationMonsterUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new InvestigationMonsterUpdateNotify(input, extensionRegistry);
            }
        };

        private InvestigationMonsterUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private InvestigationMonsterUpdateNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new InvestigationMonsterUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private InvestigationMonsterUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 50:
                                InvestigationMonsterOuterClass.InvestigationMonster.Builder subBuilder = this.investigationMonster_ != null ? this.investigationMonster_.toBuilder() : null;
                                this.investigationMonster_ = (InvestigationMonsterOuterClass.InvestigationMonster) input.readMessage(InvestigationMonsterOuterClass.InvestigationMonster.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.investigationMonster_);
                                    this.investigationMonster_ = subBuilder.buildPartial();
                                    break;
                                }
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
            return InvestigationMonsterUpdateNotifyOuterClass.internal_static_InvestigationMonsterUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return InvestigationMonsterUpdateNotifyOuterClass.f765x14f02893.ensureFieldAccessorsInitialized(InvestigationMonsterUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterUpdateNotifyOuterClass.InvestigationMonsterUpdateNotifyOrBuilder
        public boolean hasInvestigationMonster() {
            return this.investigationMonster_ != null;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterUpdateNotifyOuterClass.InvestigationMonsterUpdateNotifyOrBuilder
        public InvestigationMonsterOuterClass.InvestigationMonster getInvestigationMonster() {
            return this.investigationMonster_ == null ? InvestigationMonsterOuterClass.InvestigationMonster.getDefaultInstance() : this.investigationMonster_;
        }

        @Override // emu.grasscutter.net.proto.InvestigationMonsterUpdateNotifyOuterClass.InvestigationMonsterUpdateNotifyOrBuilder
        public InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder getInvestigationMonsterOrBuilder() {
            return getInvestigationMonster();
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
            if (this.investigationMonster_ != null) {
                output.writeMessage(6, getInvestigationMonster());
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
            if (this.investigationMonster_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(6, getInvestigationMonster());
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
            if (!(obj instanceof InvestigationMonsterUpdateNotify)) {
                return equals(obj);
            }
            InvestigationMonsterUpdateNotify other = (InvestigationMonsterUpdateNotify) obj;
            if (hasInvestigationMonster() != other.hasInvestigationMonster()) {
                return false;
            }
            return (!hasInvestigationMonster() || getInvestigationMonster().equals(other.getInvestigationMonster())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasInvestigationMonster()) {
                hash = (53 * ((37 * hash) + 6)) + getInvestigationMonster().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static InvestigationMonsterUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(InputStream input) throws IOException {
            return (InvestigationMonsterUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InvestigationMonsterUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static InvestigationMonsterUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (InvestigationMonsterUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static InvestigationMonsterUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InvestigationMonsterUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (InvestigationMonsterUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static InvestigationMonsterUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InvestigationMonsterUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(InvestigationMonsterUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/InvestigationMonsterUpdateNotifyOuterClass$InvestigationMonsterUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements InvestigationMonsterUpdateNotifyOrBuilder {
            private InvestigationMonsterOuterClass.InvestigationMonster investigationMonster_;
            private SingleFieldBuilderV3<InvestigationMonsterOuterClass.InvestigationMonster, InvestigationMonsterOuterClass.InvestigationMonster.Builder, InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder> investigationMonsterBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return InvestigationMonsterUpdateNotifyOuterClass.internal_static_InvestigationMonsterUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return InvestigationMonsterUpdateNotifyOuterClass.f765x14f02893.ensureFieldAccessorsInitialized(InvestigationMonsterUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (InvestigationMonsterUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.investigationMonsterBuilder_ == null) {
                    this.investigationMonster_ = null;
                } else {
                    this.investigationMonster_ = null;
                    this.investigationMonsterBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return InvestigationMonsterUpdateNotifyOuterClass.internal_static_InvestigationMonsterUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public InvestigationMonsterUpdateNotify getDefaultInstanceForType() {
                return InvestigationMonsterUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InvestigationMonsterUpdateNotify build() {
                InvestigationMonsterUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public InvestigationMonsterUpdateNotify buildPartial() {
                InvestigationMonsterUpdateNotify result = new InvestigationMonsterUpdateNotify(this);
                if (this.investigationMonsterBuilder_ == null) {
                    result.investigationMonster_ = this.investigationMonster_;
                } else {
                    result.investigationMonster_ = this.investigationMonsterBuilder_.build();
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
                if (other instanceof InvestigationMonsterUpdateNotify) {
                    return mergeFrom((InvestigationMonsterUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(InvestigationMonsterUpdateNotify other) {
                if (other == InvestigationMonsterUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasInvestigationMonster()) {
                    mergeInvestigationMonster(other.getInvestigationMonster());
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
                InvestigationMonsterUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = InvestigationMonsterUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (InvestigationMonsterUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterUpdateNotifyOuterClass.InvestigationMonsterUpdateNotifyOrBuilder
            public boolean hasInvestigationMonster() {
                return (this.investigationMonsterBuilder_ == null && this.investigationMonster_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterUpdateNotifyOuterClass.InvestigationMonsterUpdateNotifyOrBuilder
            public InvestigationMonsterOuterClass.InvestigationMonster getInvestigationMonster() {
                if (this.investigationMonsterBuilder_ == null) {
                    return this.investigationMonster_ == null ? InvestigationMonsterOuterClass.InvestigationMonster.getDefaultInstance() : this.investigationMonster_;
                }
                return this.investigationMonsterBuilder_.getMessage();
            }

            public Builder setInvestigationMonster(InvestigationMonsterOuterClass.InvestigationMonster value) {
                if (this.investigationMonsterBuilder_ != null) {
                    this.investigationMonsterBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.investigationMonster_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setInvestigationMonster(InvestigationMonsterOuterClass.InvestigationMonster.Builder builderForValue) {
                if (this.investigationMonsterBuilder_ == null) {
                    this.investigationMonster_ = builderForValue.build();
                    onChanged();
                } else {
                    this.investigationMonsterBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeInvestigationMonster(InvestigationMonsterOuterClass.InvestigationMonster value) {
                if (this.investigationMonsterBuilder_ == null) {
                    if (this.investigationMonster_ != null) {
                        this.investigationMonster_ = InvestigationMonsterOuterClass.InvestigationMonster.newBuilder(this.investigationMonster_).mergeFrom(value).buildPartial();
                    } else {
                        this.investigationMonster_ = value;
                    }
                    onChanged();
                } else {
                    this.investigationMonsterBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearInvestigationMonster() {
                if (this.investigationMonsterBuilder_ == null) {
                    this.investigationMonster_ = null;
                    onChanged();
                } else {
                    this.investigationMonster_ = null;
                    this.investigationMonsterBuilder_ = null;
                }
                return this;
            }

            public InvestigationMonsterOuterClass.InvestigationMonster.Builder getInvestigationMonsterBuilder() {
                onChanged();
                return getInvestigationMonsterFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.InvestigationMonsterUpdateNotifyOuterClass.InvestigationMonsterUpdateNotifyOrBuilder
            public InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder getInvestigationMonsterOrBuilder() {
                if (this.investigationMonsterBuilder_ != null) {
                    return this.investigationMonsterBuilder_.getMessageOrBuilder();
                }
                return this.investigationMonster_ == null ? InvestigationMonsterOuterClass.InvestigationMonster.getDefaultInstance() : this.investigationMonster_;
            }

            private SingleFieldBuilderV3<InvestigationMonsterOuterClass.InvestigationMonster, InvestigationMonsterOuterClass.InvestigationMonster.Builder, InvestigationMonsterOuterClass.InvestigationMonsterOrBuilder> getInvestigationMonsterFieldBuilder() {
                if (this.investigationMonsterBuilder_ == null) {
                    this.investigationMonsterBuilder_ = new SingleFieldBuilderV3<>(getInvestigationMonster(), getParentForChildren(), isClean());
                    this.investigationMonster_ = null;
                }
                return this.investigationMonsterBuilder_;
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

        public static InvestigationMonsterUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InvestigationMonsterUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<InvestigationMonsterUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public InvestigationMonsterUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        InvestigationMonsterOuterClass.getDescriptor();
    }
}
