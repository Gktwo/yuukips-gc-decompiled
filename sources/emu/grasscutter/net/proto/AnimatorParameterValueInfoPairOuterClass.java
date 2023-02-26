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
import emu.grasscutter.net.proto.AnimatorParameterValueInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoPairOuterClass.class */
public final class AnimatorParameterValueInfoPairOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$AnimatorParameterValueInfoPair.proto\u001a AnimatorParameterValueInfo.proto\"c\n\u001eAnimatorParameterValueInfoPair\u0012\u000e\n\u0006nameId\u0018\u0001 \u0001(\u0005\u00121\n\fanimatorPara\u0018\u0002 \u0001(\u000b2\u001b.AnimatorParameterValueInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AnimatorParameterValueInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AnimatorParameterValueInfoPair_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_AnimatorParameterValueInfoPair_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f622xb1a4abe6 = new GeneratedMessageV3.FieldAccessorTable(internal_static_AnimatorParameterValueInfoPair_descriptor, new String[]{"NameId", "AnimatorPara"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoPairOuterClass$AnimatorParameterValueInfoPairOrBuilder.class */
    public interface AnimatorParameterValueInfoPairOrBuilder extends MessageOrBuilder {
        int getNameId();

        boolean hasAnimatorPara();

        AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo getAnimatorPara();

        AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder getAnimatorParaOrBuilder();
    }

    private AnimatorParameterValueInfoPairOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoPairOuterClass$AnimatorParameterValueInfoPair.class */
    public static final class AnimatorParameterValueInfoPair extends GeneratedMessageV3 implements AnimatorParameterValueInfoPairOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NAMEID_FIELD_NUMBER = 1;
        private int nameId_;
        public static final int ANIMATORPARA_FIELD_NUMBER = 2;
        private AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo animatorPara_;
        private byte memoizedIsInitialized;
        private static final AnimatorParameterValueInfoPair DEFAULT_INSTANCE = new AnimatorParameterValueInfoPair();
        private static final Parser<AnimatorParameterValueInfoPair> PARSER = new AbstractParser<AnimatorParameterValueInfoPair>() { // from class: emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.1
            @Override // com.google.protobuf.Parser
            public AnimatorParameterValueInfoPair parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AnimatorParameterValueInfoPair(input, extensionRegistry);
            }
        };

        private AnimatorParameterValueInfoPair(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AnimatorParameterValueInfoPair() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AnimatorParameterValueInfoPair();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AnimatorParameterValueInfoPair(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.nameId_ = input.readInt32();
                                    break;
                                case 18:
                                    AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder subBuilder = this.animatorPara_ != null ? this.animatorPara_.toBuilder() : null;
                                    this.animatorPara_ = (AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo) input.readMessage(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.animatorPara_);
                                        this.animatorPara_ = subBuilder.buildPartial();
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
            return AnimatorParameterValueInfoPairOuterClass.internal_static_AnimatorParameterValueInfoPair_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnimatorParameterValueInfoPairOuterClass.f622xb1a4abe6.ensureFieldAccessorsInitialized(AnimatorParameterValueInfoPair.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
        public int getNameId() {
            return this.nameId_;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
        public boolean hasAnimatorPara() {
            return this.animatorPara_ != null;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
        public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo getAnimatorPara() {
            return this.animatorPara_ == null ? AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.getDefaultInstance() : this.animatorPara_;
        }

        @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
        public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder getAnimatorParaOrBuilder() {
            return getAnimatorPara();
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
            if (this.nameId_ != 0) {
                output.writeInt32(1, this.nameId_);
            }
            if (this.animatorPara_ != null) {
                output.writeMessage(2, getAnimatorPara());
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
            if (this.nameId_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
            }
            if (this.animatorPara_ != null) {
                size2 += CodedOutputStream.computeMessageSize(2, getAnimatorPara());
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
            if (!(obj instanceof AnimatorParameterValueInfoPair)) {
                return equals(obj);
            }
            AnimatorParameterValueInfoPair other = (AnimatorParameterValueInfoPair) obj;
            if (getNameId() == other.getNameId() && hasAnimatorPara() == other.hasAnimatorPara()) {
                return (!hasAnimatorPara() || getAnimatorPara().equals(other.getAnimatorPara())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getNameId();
            if (hasAnimatorPara()) {
                hash = (53 * ((37 * hash) + 2)) + getAnimatorPara().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AnimatorParameterValueInfoPair parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnimatorParameterValueInfoPair parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnimatorParameterValueInfoPair parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnimatorParameterValueInfoPair parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnimatorParameterValueInfoPair parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnimatorParameterValueInfoPair parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnimatorParameterValueInfoPair parseFrom(InputStream input) throws IOException {
            return (AnimatorParameterValueInfoPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AnimatorParameterValueInfoPair parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnimatorParameterValueInfoPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AnimatorParameterValueInfoPair parseDelimitedFrom(InputStream input) throws IOException {
            return (AnimatorParameterValueInfoPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AnimatorParameterValueInfoPair parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnimatorParameterValueInfoPair) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AnimatorParameterValueInfoPair parseFrom(CodedInputStream input) throws IOException {
            return (AnimatorParameterValueInfoPair) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AnimatorParameterValueInfoPair parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnimatorParameterValueInfoPair) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AnimatorParameterValueInfoPair prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnimatorParameterValueInfoPairOuterClass$AnimatorParameterValueInfoPair$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnimatorParameterValueInfoPairOrBuilder {
            private int nameId_;
            private AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo animatorPara_;
            private SingleFieldBuilderV3<AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder> animatorParaBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AnimatorParameterValueInfoPairOuterClass.internal_static_AnimatorParameterValueInfoPair_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AnimatorParameterValueInfoPairOuterClass.f622xb1a4abe6.ensureFieldAccessorsInitialized(AnimatorParameterValueInfoPair.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AnimatorParameterValueInfoPair.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.nameId_ = 0;
                if (this.animatorParaBuilder_ == null) {
                    this.animatorPara_ = null;
                } else {
                    this.animatorPara_ = null;
                    this.animatorParaBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AnimatorParameterValueInfoPairOuterClass.internal_static_AnimatorParameterValueInfoPair_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AnimatorParameterValueInfoPair getDefaultInstanceForType() {
                return AnimatorParameterValueInfoPair.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AnimatorParameterValueInfoPair build() {
                AnimatorParameterValueInfoPair result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AnimatorParameterValueInfoPair buildPartial() {
                AnimatorParameterValueInfoPair result = new AnimatorParameterValueInfoPair(this);
                result.nameId_ = this.nameId_;
                if (this.animatorParaBuilder_ == null) {
                    result.animatorPara_ = this.animatorPara_;
                } else {
                    result.animatorPara_ = this.animatorParaBuilder_.build();
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
                if (other instanceof AnimatorParameterValueInfoPair) {
                    return mergeFrom((AnimatorParameterValueInfoPair) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AnimatorParameterValueInfoPair other) {
                if (other == AnimatorParameterValueInfoPair.getDefaultInstance()) {
                    return this;
                }
                if (other.getNameId() != 0) {
                    setNameId(other.getNameId());
                }
                if (other.hasAnimatorPara()) {
                    mergeAnimatorPara(other.getAnimatorPara());
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
                AnimatorParameterValueInfoPair parsedMessage = null;
                try {
                    try {
                        parsedMessage = AnimatorParameterValueInfoPair.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AnimatorParameterValueInfoPair) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
            public int getNameId() {
                return this.nameId_;
            }

            public Builder setNameId(int value) {
                this.nameId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNameId() {
                this.nameId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
            public boolean hasAnimatorPara() {
                return (this.animatorParaBuilder_ == null && this.animatorPara_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
            public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo getAnimatorPara() {
                if (this.animatorParaBuilder_ == null) {
                    return this.animatorPara_ == null ? AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.getDefaultInstance() : this.animatorPara_;
                }
                return this.animatorParaBuilder_.getMessage();
            }

            public Builder setAnimatorPara(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo value) {
                if (this.animatorParaBuilder_ != null) {
                    this.animatorParaBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.animatorPara_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAnimatorPara(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder builderForValue) {
                if (this.animatorParaBuilder_ == null) {
                    this.animatorPara_ = builderForValue.build();
                    onChanged();
                } else {
                    this.animatorParaBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAnimatorPara(AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo value) {
                if (this.animatorParaBuilder_ == null) {
                    if (this.animatorPara_ != null) {
                        this.animatorPara_ = AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.newBuilder(this.animatorPara_).mergeFrom(value).buildPartial();
                    } else {
                        this.animatorPara_ = value;
                    }
                    onChanged();
                } else {
                    this.animatorParaBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAnimatorPara() {
                if (this.animatorParaBuilder_ == null) {
                    this.animatorPara_ = null;
                    onChanged();
                } else {
                    this.animatorPara_ = null;
                    this.animatorParaBuilder_ = null;
                }
                return this;
            }

            public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder getAnimatorParaBuilder() {
                onChanged();
                return getAnimatorParaFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPairOrBuilder
            public AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder getAnimatorParaOrBuilder() {
                if (this.animatorParaBuilder_ != null) {
                    return this.animatorParaBuilder_.getMessageOrBuilder();
                }
                return this.animatorPara_ == null ? AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.getDefaultInstance() : this.animatorPara_;
            }

            private SingleFieldBuilderV3<AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfo.Builder, AnimatorParameterValueInfoOuterClass.AnimatorParameterValueInfoOrBuilder> getAnimatorParaFieldBuilder() {
                if (this.animatorParaBuilder_ == null) {
                    this.animatorParaBuilder_ = new SingleFieldBuilderV3<>(getAnimatorPara(), getParentForChildren(), isClean());
                    this.animatorPara_ = null;
                }
                return this.animatorParaBuilder_;
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

        public static AnimatorParameterValueInfoPair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AnimatorParameterValueInfoPair> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AnimatorParameterValueInfoPair> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AnimatorParameterValueInfoPair getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AnimatorParameterValueInfoOuterClass.getDescriptor();
    }
}
