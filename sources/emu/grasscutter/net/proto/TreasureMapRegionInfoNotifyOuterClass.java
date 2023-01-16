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
import emu.grasscutter.net.proto.TreasureMapRegionInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoNotifyOuterClass.class */
public final class TreasureMapRegionInfoNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!TreasureMapRegionInfoNotify.proto\u001a\u001bTreasureMapRegionInfo.proto\"J\n\u001bTreasureMapRegionInfoNotify\u0012+\n\u000bregion_info\u0018\u0007 \u0001(\u000b2\u0016.TreasureMapRegionInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TreasureMapRegionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TreasureMapRegionInfoNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TreasureMapRegionInfoNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureMapRegionInfoNotify_descriptor, new String[]{"RegionInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoNotifyOuterClass$TreasureMapRegionInfoNotifyOrBuilder.class */
    public interface TreasureMapRegionInfoNotifyOrBuilder extends MessageOrBuilder {
        boolean hasRegionInfo();

        TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfo();

        TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoOrBuilder();
    }

    private TreasureMapRegionInfoNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoNotifyOuterClass$TreasureMapRegionInfoNotify.class */
    public static final class TreasureMapRegionInfoNotify extends GeneratedMessageV3 implements TreasureMapRegionInfoNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int REGION_INFO_FIELD_NUMBER = 7;
        private TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo regionInfo_;
        private byte memoizedIsInitialized;
        private static final TreasureMapRegionInfoNotify DEFAULT_INSTANCE = new TreasureMapRegionInfoNotify();
        private static final Parser<TreasureMapRegionInfoNotify> PARSER = new AbstractParser<TreasureMapRegionInfoNotify>() { // from class: emu.grasscutter.net.proto.TreasureMapRegionInfoNotifyOuterClass.TreasureMapRegionInfoNotify.1
            @Override // com.google.protobuf.Parser
            public TreasureMapRegionInfoNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureMapRegionInfoNotify(input, extensionRegistry);
            }
        };

        private TreasureMapRegionInfoNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureMapRegionInfoNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureMapRegionInfoNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TreasureMapRegionInfoNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 58:
                                TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder subBuilder = this.regionInfo_ != null ? this.regionInfo_.toBuilder() : null;
                                this.regionInfo_ = (TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo) input.readMessage(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.regionInfo_);
                                    this.regionInfo_ = subBuilder.buildPartial();
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
            return TreasureMapRegionInfoNotifyOuterClass.internal_static_TreasureMapRegionInfoNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureMapRegionInfoNotifyOuterClass.internal_static_TreasureMapRegionInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapRegionInfoNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoNotifyOuterClass.TreasureMapRegionInfoNotifyOrBuilder
        public boolean hasRegionInfo() {
            return this.regionInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoNotifyOuterClass.TreasureMapRegionInfoNotifyOrBuilder
        public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfo() {
            return this.regionInfo_ == null ? TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.getDefaultInstance() : this.regionInfo_;
        }

        @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoNotifyOuterClass.TreasureMapRegionInfoNotifyOrBuilder
        public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoOrBuilder() {
            return getRegionInfo();
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
            if (this.regionInfo_ != null) {
                output.writeMessage(7, getRegionInfo());
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
            if (this.regionInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(7, getRegionInfo());
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
            if (!(obj instanceof TreasureMapRegionInfoNotify)) {
                return equals(obj);
            }
            TreasureMapRegionInfoNotify other = (TreasureMapRegionInfoNotify) obj;
            if (hasRegionInfo() != other.hasRegionInfo()) {
                return false;
            }
            return (!hasRegionInfo() || getRegionInfo().equals(other.getRegionInfo())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRegionInfo()) {
                hash = (53 * ((37 * hash) + 7)) + getRegionInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TreasureMapRegionInfoNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapRegionInfoNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapRegionInfoNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapRegionInfoNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapRegionInfoNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureMapRegionInfoNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureMapRegionInfoNotify parseFrom(InputStream input) throws IOException {
            return (TreasureMapRegionInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapRegionInfoNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapRegionInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapRegionInfoNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureMapRegionInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureMapRegionInfoNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapRegionInfoNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureMapRegionInfoNotify parseFrom(CodedInputStream input) throws IOException {
            return (TreasureMapRegionInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureMapRegionInfoNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureMapRegionInfoNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureMapRegionInfoNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureMapRegionInfoNotifyOuterClass$TreasureMapRegionInfoNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureMapRegionInfoNotifyOrBuilder {
            private TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo regionInfo_;
            private SingleFieldBuilderV3<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> regionInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureMapRegionInfoNotifyOuterClass.internal_static_TreasureMapRegionInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureMapRegionInfoNotifyOuterClass.internal_static_TreasureMapRegionInfoNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureMapRegionInfoNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureMapRegionInfoNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfo_ = null;
                } else {
                    this.regionInfo_ = null;
                    this.regionInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureMapRegionInfoNotifyOuterClass.internal_static_TreasureMapRegionInfoNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureMapRegionInfoNotify getDefaultInstanceForType() {
                return TreasureMapRegionInfoNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapRegionInfoNotify build() {
                TreasureMapRegionInfoNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureMapRegionInfoNotify buildPartial() {
                TreasureMapRegionInfoNotify result = new TreasureMapRegionInfoNotify(this);
                if (this.regionInfoBuilder_ == null) {
                    result.regionInfo_ = this.regionInfo_;
                } else {
                    result.regionInfo_ = this.regionInfoBuilder_.build();
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
                if (other instanceof TreasureMapRegionInfoNotify) {
                    return mergeFrom((TreasureMapRegionInfoNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureMapRegionInfoNotify other) {
                if (other == TreasureMapRegionInfoNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRegionInfo()) {
                    mergeRegionInfo(other.getRegionInfo());
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
                TreasureMapRegionInfoNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureMapRegionInfoNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureMapRegionInfoNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoNotifyOuterClass.TreasureMapRegionInfoNotifyOrBuilder
            public boolean hasRegionInfo() {
                return (this.regionInfoBuilder_ == null && this.regionInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoNotifyOuterClass.TreasureMapRegionInfoNotifyOrBuilder
            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo getRegionInfo() {
                if (this.regionInfoBuilder_ == null) {
                    return this.regionInfo_ == null ? TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.getDefaultInstance() : this.regionInfo_;
                }
                return this.regionInfoBuilder_.getMessage();
            }

            public Builder setRegionInfo(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo value) {
                if (this.regionInfoBuilder_ != null) {
                    this.regionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.regionInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRegionInfo(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder builderForValue) {
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.regionInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRegionInfo(TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo value) {
                if (this.regionInfoBuilder_ == null) {
                    if (this.regionInfo_ != null) {
                        this.regionInfo_ = TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.newBuilder(this.regionInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.regionInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.regionInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRegionInfo() {
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfo_ = null;
                    onChanged();
                } else {
                    this.regionInfo_ = null;
                    this.regionInfoBuilder_ = null;
                }
                return this;
            }

            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder getRegionInfoBuilder() {
                onChanged();
                return getRegionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TreasureMapRegionInfoNotifyOuterClass.TreasureMapRegionInfoNotifyOrBuilder
            public TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder getRegionInfoOrBuilder() {
                if (this.regionInfoBuilder_ != null) {
                    return this.regionInfoBuilder_.getMessageOrBuilder();
                }
                return this.regionInfo_ == null ? TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.getDefaultInstance() : this.regionInfo_;
            }

            private SingleFieldBuilderV3<TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfo.Builder, TreasureMapRegionInfoOuterClass.TreasureMapRegionInfoOrBuilder> getRegionInfoFieldBuilder() {
                if (this.regionInfoBuilder_ == null) {
                    this.regionInfoBuilder_ = new SingleFieldBuilderV3<>(getRegionInfo(), getParentForChildren(), isClean());
                    this.regionInfo_ = null;
                }
                return this.regionInfoBuilder_;
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

        public static TreasureMapRegionInfoNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureMapRegionInfoNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureMapRegionInfoNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureMapRegionInfoNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TreasureMapRegionInfoOuterClass.getDescriptor();
    }
}
