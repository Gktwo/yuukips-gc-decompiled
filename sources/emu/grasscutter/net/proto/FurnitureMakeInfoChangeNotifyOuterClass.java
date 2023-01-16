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
import emu.grasscutter.net.proto.FurnitureMakeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeInfoChangeNotifyOuterClass.class */
public final class FurnitureMakeInfoChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#FurnitureMakeInfoChangeNotify.proto\u001a\u0017FurnitureMakeInfo.proto\"F\n\u001dFurnitureMakeInfoChangeNotify\u0012%\n\tmake_info\u0018\n \u0001(\u000b2\u0012.FurnitureMakeInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FurnitureMakeInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FurnitureMakeInfoChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeInfoChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeInfoChangeNotify_descriptor, new String[]{"MakeInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeInfoChangeNotifyOuterClass$FurnitureMakeInfoChangeNotifyOrBuilder.class */
    public interface FurnitureMakeInfoChangeNotifyOrBuilder extends MessageOrBuilder {
        boolean hasMakeInfo();

        FurnitureMakeInfoOuterClass.FurnitureMakeInfo getMakeInfo();

        FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder getMakeInfoOrBuilder();
    }

    private FurnitureMakeInfoChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeInfoChangeNotifyOuterClass$FurnitureMakeInfoChangeNotify.class */
    public static final class FurnitureMakeInfoChangeNotify extends GeneratedMessageV3 implements FurnitureMakeInfoChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAKE_INFO_FIELD_NUMBER = 10;
        private FurnitureMakeInfoOuterClass.FurnitureMakeInfo makeInfo_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeInfoChangeNotify DEFAULT_INSTANCE = new FurnitureMakeInfoChangeNotify();
        private static final Parser<FurnitureMakeInfoChangeNotify> PARSER = new AbstractParser<FurnitureMakeInfoChangeNotify>() { // from class: emu.grasscutter.net.proto.FurnitureMakeInfoChangeNotifyOuterClass.FurnitureMakeInfoChangeNotify.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeInfoChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeInfoChangeNotify(input, extensionRegistry);
            }
        };

        private FurnitureMakeInfoChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeInfoChangeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeInfoChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeInfoChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 82:
                                FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder subBuilder = this.makeInfo_ != null ? this.makeInfo_.toBuilder() : null;
                                this.makeInfo_ = (FurnitureMakeInfoOuterClass.FurnitureMakeInfo) input.readMessage(FurnitureMakeInfoOuterClass.FurnitureMakeInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.makeInfo_);
                                    this.makeInfo_ = subBuilder.buildPartial();
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
            return FurnitureMakeInfoChangeNotifyOuterClass.internal_static_FurnitureMakeInfoChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeInfoChangeNotifyOuterClass.internal_static_FurnitureMakeInfoChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeInfoChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeInfoChangeNotifyOuterClass.FurnitureMakeInfoChangeNotifyOrBuilder
        public boolean hasMakeInfo() {
            return this.makeInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeInfoChangeNotifyOuterClass.FurnitureMakeInfoChangeNotifyOrBuilder
        public FurnitureMakeInfoOuterClass.FurnitureMakeInfo getMakeInfo() {
            return this.makeInfo_ == null ? FurnitureMakeInfoOuterClass.FurnitureMakeInfo.getDefaultInstance() : this.makeInfo_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeInfoChangeNotifyOuterClass.FurnitureMakeInfoChangeNotifyOrBuilder
        public FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder getMakeInfoOrBuilder() {
            return getMakeInfo();
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
            if (this.makeInfo_ != null) {
                output.writeMessage(10, getMakeInfo());
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
            if (this.makeInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(10, getMakeInfo());
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
            if (!(obj instanceof FurnitureMakeInfoChangeNotify)) {
                return equals(obj);
            }
            FurnitureMakeInfoChangeNotify other = (FurnitureMakeInfoChangeNotify) obj;
            if (hasMakeInfo() != other.hasMakeInfo()) {
                return false;
            }
            return (!hasMakeInfo() || getMakeInfo().equals(other.getMakeInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasMakeInfo()) {
                hash = (53 * ((37 * hash) + 10)) + getMakeInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeInfoChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeInfoChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeInfoChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeInfoChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeInfoChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeInfoChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeInfoChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeInfoChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeInfoChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeInfoChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeInfoChangeNotifyOuterClass$FurnitureMakeInfoChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeInfoChangeNotifyOrBuilder {
            private FurnitureMakeInfoOuterClass.FurnitureMakeInfo makeInfo_;
            private SingleFieldBuilderV3<FurnitureMakeInfoOuterClass.FurnitureMakeInfo, FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder, FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder> makeInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeInfoChangeNotifyOuterClass.internal_static_FurnitureMakeInfoChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeInfoChangeNotifyOuterClass.internal_static_FurnitureMakeInfoChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeInfoChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeInfoChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.makeInfoBuilder_ == null) {
                    this.makeInfo_ = null;
                } else {
                    this.makeInfo_ = null;
                    this.makeInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeInfoChangeNotifyOuterClass.internal_static_FurnitureMakeInfoChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeInfoChangeNotify getDefaultInstanceForType() {
                return FurnitureMakeInfoChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeInfoChangeNotify build() {
                FurnitureMakeInfoChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeInfoChangeNotify buildPartial() {
                FurnitureMakeInfoChangeNotify result = new FurnitureMakeInfoChangeNotify(this);
                if (this.makeInfoBuilder_ == null) {
                    result.makeInfo_ = this.makeInfo_;
                } else {
                    result.makeInfo_ = this.makeInfoBuilder_.build();
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
                if (other instanceof FurnitureMakeInfoChangeNotify) {
                    return mergeFrom((FurnitureMakeInfoChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeInfoChangeNotify other) {
                if (other == FurnitureMakeInfoChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasMakeInfo()) {
                    mergeMakeInfo(other.getMakeInfo());
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
                FurnitureMakeInfoChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeInfoChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeInfoChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeInfoChangeNotifyOuterClass.FurnitureMakeInfoChangeNotifyOrBuilder
            public boolean hasMakeInfo() {
                return (this.makeInfoBuilder_ == null && this.makeInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeInfoChangeNotifyOuterClass.FurnitureMakeInfoChangeNotifyOrBuilder
            public FurnitureMakeInfoOuterClass.FurnitureMakeInfo getMakeInfo() {
                if (this.makeInfoBuilder_ == null) {
                    return this.makeInfo_ == null ? FurnitureMakeInfoOuterClass.FurnitureMakeInfo.getDefaultInstance() : this.makeInfo_;
                }
                return this.makeInfoBuilder_.getMessage();
            }

            public Builder setMakeInfo(FurnitureMakeInfoOuterClass.FurnitureMakeInfo value) {
                if (this.makeInfoBuilder_ != null) {
                    this.makeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.makeInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setMakeInfo(FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder builderForValue) {
                if (this.makeInfoBuilder_ == null) {
                    this.makeInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.makeInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeMakeInfo(FurnitureMakeInfoOuterClass.FurnitureMakeInfo value) {
                if (this.makeInfoBuilder_ == null) {
                    if (this.makeInfo_ != null) {
                        this.makeInfo_ = FurnitureMakeInfoOuterClass.FurnitureMakeInfo.newBuilder(this.makeInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.makeInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.makeInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearMakeInfo() {
                if (this.makeInfoBuilder_ == null) {
                    this.makeInfo_ = null;
                    onChanged();
                } else {
                    this.makeInfo_ = null;
                    this.makeInfoBuilder_ = null;
                }
                return this;
            }

            public FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder getMakeInfoBuilder() {
                onChanged();
                return getMakeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeInfoChangeNotifyOuterClass.FurnitureMakeInfoChangeNotifyOrBuilder
            public FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder getMakeInfoOrBuilder() {
                if (this.makeInfoBuilder_ != null) {
                    return this.makeInfoBuilder_.getMessageOrBuilder();
                }
                return this.makeInfo_ == null ? FurnitureMakeInfoOuterClass.FurnitureMakeInfo.getDefaultInstance() : this.makeInfo_;
            }

            private SingleFieldBuilderV3<FurnitureMakeInfoOuterClass.FurnitureMakeInfo, FurnitureMakeInfoOuterClass.FurnitureMakeInfo.Builder, FurnitureMakeInfoOuterClass.FurnitureMakeInfoOrBuilder> getMakeInfoFieldBuilder() {
                if (this.makeInfoBuilder_ == null) {
                    this.makeInfoBuilder_ = new SingleFieldBuilderV3<>(getMakeInfo(), getParentForChildren(), isClean());
                    this.makeInfo_ = null;
                }
                return this.makeInfoBuilder_;
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

        public static FurnitureMakeInfoChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeInfoChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeInfoChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeInfoChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FurnitureMakeInfoOuterClass.getDescriptor();
    }
}
