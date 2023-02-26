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
import emu.grasscutter.net.proto.AbilityEmbryoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityControlBlockOuterClass.class */
public final class AbilityControlBlockOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019AbilityControlBlock.proto\u001a\u0013AbilityEmbryo.proto\"@\n\u0013AbilityControlBlock\u0012)\n\u0011abilityEmbryoList\u0018\u0001 \u0003(\u000b2\u000e.AbilityEmbryoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityEmbryoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityControlBlock_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityControlBlock_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityControlBlock_descriptor, new String[]{"AbilityEmbryoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityControlBlockOuterClass$AbilityControlBlockOrBuilder.class */
    public interface AbilityControlBlockOrBuilder extends MessageOrBuilder {
        List<AbilityEmbryoOuterClass.AbilityEmbryo> getAbilityEmbryoListList();

        AbilityEmbryoOuterClass.AbilityEmbryo getAbilityEmbryoList(int i);

        int getAbilityEmbryoListCount();

        List<? extends AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder> getAbilityEmbryoListOrBuilderList();

        AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder getAbilityEmbryoListOrBuilder(int i);
    }

    private AbilityControlBlockOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityControlBlockOuterClass$AbilityControlBlock.class */
    public static final class AbilityControlBlock extends GeneratedMessageV3 implements AbilityControlBlockOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ABILITYEMBRYOLIST_FIELD_NUMBER = 1;
        private List<AbilityEmbryoOuterClass.AbilityEmbryo> abilityEmbryoList_;
        private byte memoizedIsInitialized;
        private static final AbilityControlBlock DEFAULT_INSTANCE = new AbilityControlBlock();
        private static final Parser<AbilityControlBlock> PARSER = new AbstractParser<AbilityControlBlock>() { // from class: emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlock.1
            @Override // com.google.protobuf.Parser
            public AbilityControlBlock parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityControlBlock(input, extensionRegistry);
            }
        };

        private AbilityControlBlock(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityControlBlock() {
            this.memoizedIsInitialized = -1;
            this.abilityEmbryoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityControlBlock();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityControlBlock(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.abilityEmbryoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.abilityEmbryoList_.add((AbilityEmbryoOuterClass.AbilityEmbryo) input.readMessage(AbilityEmbryoOuterClass.AbilityEmbryo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.abilityEmbryoList_ = Collections.unmodifiableList(this.abilityEmbryoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbilityControlBlockOuterClass.internal_static_AbilityControlBlock_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityControlBlockOuterClass.internal_static_AbilityControlBlock_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityControlBlock.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
        public List<AbilityEmbryoOuterClass.AbilityEmbryo> getAbilityEmbryoListList() {
            return this.abilityEmbryoList_;
        }

        @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
        public List<? extends AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder> getAbilityEmbryoListOrBuilderList() {
            return this.abilityEmbryoList_;
        }

        @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
        public int getAbilityEmbryoListCount() {
            return this.abilityEmbryoList_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
        public AbilityEmbryoOuterClass.AbilityEmbryo getAbilityEmbryoList(int index) {
            return this.abilityEmbryoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
        public AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder getAbilityEmbryoListOrBuilder(int index) {
            return this.abilityEmbryoList_.get(index);
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
            for (int i = 0; i < this.abilityEmbryoList_.size(); i++) {
                output.writeMessage(1, this.abilityEmbryoList_.get(i));
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
            for (int i = 0; i < this.abilityEmbryoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.abilityEmbryoList_.get(i));
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
            if (!(obj instanceof AbilityControlBlock)) {
                return equals(obj);
            }
            AbilityControlBlock other = (AbilityControlBlock) obj;
            return getAbilityEmbryoListList().equals(other.getAbilityEmbryoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAbilityEmbryoListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getAbilityEmbryoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AbilityControlBlock parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityControlBlock parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityControlBlock parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityControlBlock parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityControlBlock parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityControlBlock parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityControlBlock parseFrom(InputStream input) throws IOException {
            return (AbilityControlBlock) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityControlBlock parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityControlBlock) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityControlBlock parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityControlBlock) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityControlBlock parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityControlBlock) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityControlBlock parseFrom(CodedInputStream input) throws IOException {
            return (AbilityControlBlock) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityControlBlock parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityControlBlock) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityControlBlock prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityControlBlockOuterClass$AbilityControlBlock$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityControlBlockOrBuilder {
            private int bitField0_;
            private List<AbilityEmbryoOuterClass.AbilityEmbryo> abilityEmbryoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AbilityEmbryoOuterClass.AbilityEmbryo, AbilityEmbryoOuterClass.AbilityEmbryo.Builder, AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder> abilityEmbryoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityControlBlockOuterClass.internal_static_AbilityControlBlock_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityControlBlockOuterClass.internal_static_AbilityControlBlock_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityControlBlock.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityControlBlock.alwaysUseFieldBuilders) {
                    getAbilityEmbryoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.abilityEmbryoListBuilder_ == null) {
                    this.abilityEmbryoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.abilityEmbryoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityControlBlockOuterClass.internal_static_AbilityControlBlock_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityControlBlock getDefaultInstanceForType() {
                return AbilityControlBlock.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityControlBlock build() {
                AbilityControlBlock result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityControlBlock buildPartial() {
                AbilityControlBlock result = new AbilityControlBlock(this);
                int i = this.bitField0_;
                if (this.abilityEmbryoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.abilityEmbryoList_ = Collections.unmodifiableList(this.abilityEmbryoList_);
                        this.bitField0_ &= -2;
                    }
                    result.abilityEmbryoList_ = this.abilityEmbryoList_;
                } else {
                    result.abilityEmbryoList_ = this.abilityEmbryoListBuilder_.build();
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
                if (other instanceof AbilityControlBlock) {
                    return mergeFrom((AbilityControlBlock) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityControlBlock other) {
                if (other == AbilityControlBlock.getDefaultInstance()) {
                    return this;
                }
                if (this.abilityEmbryoListBuilder_ == null) {
                    if (!other.abilityEmbryoList_.isEmpty()) {
                        if (this.abilityEmbryoList_.isEmpty()) {
                            this.abilityEmbryoList_ = other.abilityEmbryoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureAbilityEmbryoListIsMutable();
                            this.abilityEmbryoList_.addAll(other.abilityEmbryoList_);
                        }
                        onChanged();
                    }
                } else if (!other.abilityEmbryoList_.isEmpty()) {
                    if (this.abilityEmbryoListBuilder_.isEmpty()) {
                        this.abilityEmbryoListBuilder_.dispose();
                        this.abilityEmbryoListBuilder_ = null;
                        this.abilityEmbryoList_ = other.abilityEmbryoList_;
                        this.bitField0_ &= -2;
                        this.abilityEmbryoListBuilder_ = AbilityControlBlock.alwaysUseFieldBuilders ? getAbilityEmbryoListFieldBuilder() : null;
                    } else {
                        this.abilityEmbryoListBuilder_.addAllMessages(other.abilityEmbryoList_);
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
                AbilityControlBlock parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityControlBlock.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityControlBlock) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAbilityEmbryoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.abilityEmbryoList_ = new ArrayList(this.abilityEmbryoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
            public List<AbilityEmbryoOuterClass.AbilityEmbryo> getAbilityEmbryoListList() {
                if (this.abilityEmbryoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.abilityEmbryoList_);
                }
                return this.abilityEmbryoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
            public int getAbilityEmbryoListCount() {
                if (this.abilityEmbryoListBuilder_ == null) {
                    return this.abilityEmbryoList_.size();
                }
                return this.abilityEmbryoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
            public AbilityEmbryoOuterClass.AbilityEmbryo getAbilityEmbryoList(int index) {
                if (this.abilityEmbryoListBuilder_ == null) {
                    return this.abilityEmbryoList_.get(index);
                }
                return this.abilityEmbryoListBuilder_.getMessage(index);
            }

            public Builder setAbilityEmbryoList(int index, AbilityEmbryoOuterClass.AbilityEmbryo value) {
                if (this.abilityEmbryoListBuilder_ != null) {
                    this.abilityEmbryoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAbilityEmbryoListIsMutable();
                    this.abilityEmbryoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAbilityEmbryoList(int index, AbilityEmbryoOuterClass.AbilityEmbryo.Builder builderForValue) {
                if (this.abilityEmbryoListBuilder_ == null) {
                    ensureAbilityEmbryoListIsMutable();
                    this.abilityEmbryoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.abilityEmbryoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAbilityEmbryoList(AbilityEmbryoOuterClass.AbilityEmbryo value) {
                if (this.abilityEmbryoListBuilder_ != null) {
                    this.abilityEmbryoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAbilityEmbryoListIsMutable();
                    this.abilityEmbryoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAbilityEmbryoList(int index, AbilityEmbryoOuterClass.AbilityEmbryo value) {
                if (this.abilityEmbryoListBuilder_ != null) {
                    this.abilityEmbryoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAbilityEmbryoListIsMutable();
                    this.abilityEmbryoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAbilityEmbryoList(AbilityEmbryoOuterClass.AbilityEmbryo.Builder builderForValue) {
                if (this.abilityEmbryoListBuilder_ == null) {
                    ensureAbilityEmbryoListIsMutable();
                    this.abilityEmbryoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.abilityEmbryoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAbilityEmbryoList(int index, AbilityEmbryoOuterClass.AbilityEmbryo.Builder builderForValue) {
                if (this.abilityEmbryoListBuilder_ == null) {
                    ensureAbilityEmbryoListIsMutable();
                    this.abilityEmbryoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.abilityEmbryoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAbilityEmbryoList(Iterable<? extends AbilityEmbryoOuterClass.AbilityEmbryo> values) {
                if (this.abilityEmbryoListBuilder_ == null) {
                    ensureAbilityEmbryoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.abilityEmbryoList_);
                    onChanged();
                } else {
                    this.abilityEmbryoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAbilityEmbryoList() {
                if (this.abilityEmbryoListBuilder_ == null) {
                    this.abilityEmbryoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.abilityEmbryoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAbilityEmbryoList(int index) {
                if (this.abilityEmbryoListBuilder_ == null) {
                    ensureAbilityEmbryoListIsMutable();
                    this.abilityEmbryoList_.remove(index);
                    onChanged();
                } else {
                    this.abilityEmbryoListBuilder_.remove(index);
                }
                return this;
            }

            public AbilityEmbryoOuterClass.AbilityEmbryo.Builder getAbilityEmbryoListBuilder(int index) {
                return getAbilityEmbryoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
            public AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder getAbilityEmbryoListOrBuilder(int index) {
                if (this.abilityEmbryoListBuilder_ == null) {
                    return this.abilityEmbryoList_.get(index);
                }
                return this.abilityEmbryoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityControlBlockOuterClass.AbilityControlBlockOrBuilder
            public List<? extends AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder> getAbilityEmbryoListOrBuilderList() {
                if (this.abilityEmbryoListBuilder_ != null) {
                    return this.abilityEmbryoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.abilityEmbryoList_);
            }

            public AbilityEmbryoOuterClass.AbilityEmbryo.Builder addAbilityEmbryoListBuilder() {
                return getAbilityEmbryoListFieldBuilder().addBuilder(AbilityEmbryoOuterClass.AbilityEmbryo.getDefaultInstance());
            }

            public AbilityEmbryoOuterClass.AbilityEmbryo.Builder addAbilityEmbryoListBuilder(int index) {
                return getAbilityEmbryoListFieldBuilder().addBuilder(index, AbilityEmbryoOuterClass.AbilityEmbryo.getDefaultInstance());
            }

            public List<AbilityEmbryoOuterClass.AbilityEmbryo.Builder> getAbilityEmbryoListBuilderList() {
                return getAbilityEmbryoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityEmbryoOuterClass.AbilityEmbryo, AbilityEmbryoOuterClass.AbilityEmbryo.Builder, AbilityEmbryoOuterClass.AbilityEmbryoOrBuilder> getAbilityEmbryoListFieldBuilder() {
                if (this.abilityEmbryoListBuilder_ == null) {
                    this.abilityEmbryoListBuilder_ = new RepeatedFieldBuilderV3<>(this.abilityEmbryoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.abilityEmbryoList_ = null;
                }
                return this.abilityEmbryoListBuilder_;
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

        public static AbilityControlBlock getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityControlBlock> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityControlBlock> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityControlBlock getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityEmbryoOuterClass.getDescriptor();
    }
}
