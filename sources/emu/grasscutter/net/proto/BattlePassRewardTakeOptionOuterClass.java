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
import emu.grasscutter.net.proto.BattlePassRewardTagOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTakeOptionOuterClass.class */
public final class BattlePassRewardTakeOptionOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n BattlePassRewardTakeOption.proto\u001a\u0019BattlePassRewardTag.proto\"R\n\u001aBattlePassRewardTakeOption\u0012!\n\u0003tag\u0018\u000f \u0001(\u000b2\u0014.BattlePassRewardTag\u0012\u0011\n\toptionIdx\u0018\u000e \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassRewardTagOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BattlePassRewardTakeOption_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BattlePassRewardTakeOption_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassRewardTakeOption_descriptor, new String[]{"Tag", "OptionIdx"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTakeOptionOuterClass$BattlePassRewardTakeOptionOrBuilder.class */
    public interface BattlePassRewardTakeOptionOrBuilder extends MessageOrBuilder {
        boolean hasTag();

        BattlePassRewardTagOuterClass.BattlePassRewardTag getTag();

        BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder getTagOrBuilder();

        int getOptionIdx();
    }

    private BattlePassRewardTakeOptionOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTakeOptionOuterClass$BattlePassRewardTakeOption.class */
    public static final class BattlePassRewardTakeOption extends GeneratedMessageV3 implements BattlePassRewardTakeOptionOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TAG_FIELD_NUMBER = 15;
        private BattlePassRewardTagOuterClass.BattlePassRewardTag tag_;
        public static final int OPTIONIDX_FIELD_NUMBER = 14;
        private int optionIdx_;
        private byte memoizedIsInitialized;
        private static final BattlePassRewardTakeOption DEFAULT_INSTANCE = new BattlePassRewardTakeOption();
        private static final Parser<BattlePassRewardTakeOption> PARSER = new AbstractParser<BattlePassRewardTakeOption>() { // from class: emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOption.1
            @Override // com.google.protobuf.Parser
            public BattlePassRewardTakeOption parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassRewardTakeOption(input, extensionRegistry);
            }
        };

        private BattlePassRewardTakeOption(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassRewardTakeOption() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassRewardTakeOption();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassRewardTakeOption(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 112:
                                    this.optionIdx_ = input.readUInt32();
                                    break;
                                case 122:
                                    BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder subBuilder = this.tag_ != null ? this.tag_.toBuilder() : null;
                                    this.tag_ = (BattlePassRewardTagOuterClass.BattlePassRewardTag) input.readMessage(BattlePassRewardTagOuterClass.BattlePassRewardTag.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.tag_);
                                        this.tag_ = subBuilder.buildPartial();
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
            return BattlePassRewardTakeOptionOuterClass.internal_static_BattlePassRewardTakeOption_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassRewardTakeOptionOuterClass.internal_static_BattlePassRewardTakeOption_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassRewardTakeOption.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
        public boolean hasTag() {
            return this.tag_ != null;
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
        public BattlePassRewardTagOuterClass.BattlePassRewardTag getTag() {
            return this.tag_ == null ? BattlePassRewardTagOuterClass.BattlePassRewardTag.getDefaultInstance() : this.tag_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
        public BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder getTagOrBuilder() {
            return getTag();
        }

        @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
        public int getOptionIdx() {
            return this.optionIdx_;
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
            if (this.optionIdx_ != 0) {
                output.writeUInt32(14, this.optionIdx_);
            }
            if (this.tag_ != null) {
                output.writeMessage(15, getTag());
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
            if (this.optionIdx_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(14, this.optionIdx_);
            }
            if (this.tag_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getTag());
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
            if (!(obj instanceof BattlePassRewardTakeOption)) {
                return equals(obj);
            }
            BattlePassRewardTakeOption other = (BattlePassRewardTakeOption) obj;
            if (hasTag() != other.hasTag()) {
                return false;
            }
            return (!hasTag() || getTag().equals(other.getTag())) && getOptionIdx() == other.getOptionIdx() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasTag()) {
                hash = (53 * ((37 * hash) + 15)) + getTag().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 14)) + getOptionIdx())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BattlePassRewardTakeOption parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassRewardTakeOption parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassRewardTakeOption parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassRewardTakeOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassRewardTakeOption parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassRewardTakeOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassRewardTakeOption parseFrom(InputStream input) throws IOException {
            return (BattlePassRewardTakeOption) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassRewardTakeOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassRewardTakeOption) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassRewardTakeOption parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassRewardTakeOption) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassRewardTakeOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassRewardTakeOption) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassRewardTakeOption parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassRewardTakeOption) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassRewardTakeOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassRewardTakeOption) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassRewardTakeOption prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassRewardTakeOptionOuterClass$BattlePassRewardTakeOption$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassRewardTakeOptionOrBuilder {
            private BattlePassRewardTagOuterClass.BattlePassRewardTag tag_;
            private SingleFieldBuilderV3<BattlePassRewardTagOuterClass.BattlePassRewardTag, BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder, BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder> tagBuilder_;
            private int optionIdx_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassRewardTakeOptionOuterClass.internal_static_BattlePassRewardTakeOption_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassRewardTakeOptionOuterClass.internal_static_BattlePassRewardTakeOption_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassRewardTakeOption.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassRewardTakeOption.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.tagBuilder_ == null) {
                    this.tag_ = null;
                } else {
                    this.tag_ = null;
                    this.tagBuilder_ = null;
                }
                this.optionIdx_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BattlePassRewardTakeOptionOuterClass.internal_static_BattlePassRewardTakeOption_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassRewardTakeOption getDefaultInstanceForType() {
                return BattlePassRewardTakeOption.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassRewardTakeOption build() {
                BattlePassRewardTakeOption result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassRewardTakeOption buildPartial() {
                BattlePassRewardTakeOption result = new BattlePassRewardTakeOption(this);
                if (this.tagBuilder_ == null) {
                    result.tag_ = this.tag_;
                } else {
                    result.tag_ = this.tagBuilder_.build();
                }
                result.optionIdx_ = this.optionIdx_;
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
                if (other instanceof BattlePassRewardTakeOption) {
                    return mergeFrom((BattlePassRewardTakeOption) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassRewardTakeOption other) {
                if (other == BattlePassRewardTakeOption.getDefaultInstance()) {
                    return this;
                }
                if (other.hasTag()) {
                    mergeTag(other.getTag());
                }
                if (other.getOptionIdx() != 0) {
                    setOptionIdx(other.getOptionIdx());
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
                BattlePassRewardTakeOption parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassRewardTakeOption.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassRewardTakeOption) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
            public boolean hasTag() {
                return (this.tagBuilder_ == null && this.tag_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
            public BattlePassRewardTagOuterClass.BattlePassRewardTag getTag() {
                if (this.tagBuilder_ == null) {
                    return this.tag_ == null ? BattlePassRewardTagOuterClass.BattlePassRewardTag.getDefaultInstance() : this.tag_;
                }
                return this.tagBuilder_.getMessage();
            }

            public Builder setTag(BattlePassRewardTagOuterClass.BattlePassRewardTag value) {
                if (this.tagBuilder_ != null) {
                    this.tagBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.tag_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTag(BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder builderForValue) {
                if (this.tagBuilder_ == null) {
                    this.tag_ = builderForValue.build();
                    onChanged();
                } else {
                    this.tagBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTag(BattlePassRewardTagOuterClass.BattlePassRewardTag value) {
                if (this.tagBuilder_ == null) {
                    if (this.tag_ != null) {
                        this.tag_ = BattlePassRewardTagOuterClass.BattlePassRewardTag.newBuilder(this.tag_).mergeFrom(value).buildPartial();
                    } else {
                        this.tag_ = value;
                    }
                    onChanged();
                } else {
                    this.tagBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTag() {
                if (this.tagBuilder_ == null) {
                    this.tag_ = null;
                    onChanged();
                } else {
                    this.tag_ = null;
                    this.tagBuilder_ = null;
                }
                return this;
            }

            public BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder getTagBuilder() {
                onChanged();
                return getTagFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
            public BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder getTagOrBuilder() {
                if (this.tagBuilder_ != null) {
                    return this.tagBuilder_.getMessageOrBuilder();
                }
                return this.tag_ == null ? BattlePassRewardTagOuterClass.BattlePassRewardTag.getDefaultInstance() : this.tag_;
            }

            private SingleFieldBuilderV3<BattlePassRewardTagOuterClass.BattlePassRewardTag, BattlePassRewardTagOuterClass.BattlePassRewardTag.Builder, BattlePassRewardTagOuterClass.BattlePassRewardTagOrBuilder> getTagFieldBuilder() {
                if (this.tagBuilder_ == null) {
                    this.tagBuilder_ = new SingleFieldBuilderV3<>(getTag(), getParentForChildren(), isClean());
                    this.tag_ = null;
                }
                return this.tagBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BattlePassRewardTakeOptionOuterClass.BattlePassRewardTakeOptionOrBuilder
            public int getOptionIdx() {
                return this.optionIdx_;
            }

            public Builder setOptionIdx(int value) {
                this.optionIdx_ = value;
                onChanged();
                return this;
            }

            public Builder clearOptionIdx() {
                this.optionIdx_ = 0;
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

        public static BattlePassRewardTakeOption getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassRewardTakeOption> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassRewardTakeOption> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassRewardTakeOption getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassRewardTagOuterClass.getDescriptor();
    }
}
