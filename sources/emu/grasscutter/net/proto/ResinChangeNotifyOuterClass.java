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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResinChangeNotifyOuterClass.class */
public final class ResinChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017ResinChangeNotify.proto\"Y\n\u0011ResinChangeNotify\u0012\u0015\n\rcur_buy_count\u0018\u000b \u0001(\r\u0012\u001a\n\u0012next_add_timestamp\u0018\r \u0001(\r\u0012\u0011\n\tcur_value\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ResinChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ResinChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ResinChangeNotify_descriptor, new String[]{"CurBuyCount", "NextAddTimestamp", "CurValue"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResinChangeNotifyOuterClass$ResinChangeNotifyOrBuilder.class */
    public interface ResinChangeNotifyOrBuilder extends MessageOrBuilder {
        int getCurBuyCount();

        int getNextAddTimestamp();

        int getCurValue();
    }

    private ResinChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResinChangeNotifyOuterClass$ResinChangeNotify.class */
    public static final class ResinChangeNotify extends GeneratedMessageV3 implements ResinChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CUR_BUY_COUNT_FIELD_NUMBER = 11;
        private int curBuyCount_;
        public static final int NEXT_ADD_TIMESTAMP_FIELD_NUMBER = 13;
        private int nextAddTimestamp_;
        public static final int CUR_VALUE_FIELD_NUMBER = 10;
        private int curValue_;
        private byte memoizedIsInitialized;
        private static final ResinChangeNotify DEFAULT_INSTANCE = new ResinChangeNotify();
        private static final Parser<ResinChangeNotify> PARSER = new AbstractParser<ResinChangeNotify>() { // from class: emu.grasscutter.net.proto.ResinChangeNotifyOuterClass.ResinChangeNotify.1
            @Override // com.google.protobuf.Parser
            public ResinChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ResinChangeNotify(input, extensionRegistry);
            }
        };

        private ResinChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ResinChangeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ResinChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ResinChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 80:
                                    this.curValue_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.curBuyCount_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.nextAddTimestamp_ = input.readUInt32();
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
            return ResinChangeNotifyOuterClass.internal_static_ResinChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ResinChangeNotifyOuterClass.internal_static_ResinChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ResinChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ResinChangeNotifyOuterClass.ResinChangeNotifyOrBuilder
        public int getCurBuyCount() {
            return this.curBuyCount_;
        }

        @Override // emu.grasscutter.net.proto.ResinChangeNotifyOuterClass.ResinChangeNotifyOrBuilder
        public int getNextAddTimestamp() {
            return this.nextAddTimestamp_;
        }

        @Override // emu.grasscutter.net.proto.ResinChangeNotifyOuterClass.ResinChangeNotifyOrBuilder
        public int getCurValue() {
            return this.curValue_;
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
            if (this.curValue_ != 0) {
                output.writeUInt32(10, this.curValue_);
            }
            if (this.curBuyCount_ != 0) {
                output.writeUInt32(11, this.curBuyCount_);
            }
            if (this.nextAddTimestamp_ != 0) {
                output.writeUInt32(13, this.nextAddTimestamp_);
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
            if (this.curValue_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(10, this.curValue_);
            }
            if (this.curBuyCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.curBuyCount_);
            }
            if (this.nextAddTimestamp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.nextAddTimestamp_);
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
            if (!(obj instanceof ResinChangeNotify)) {
                return equals(obj);
            }
            ResinChangeNotify other = (ResinChangeNotify) obj;
            return getCurBuyCount() == other.getCurBuyCount() && getNextAddTimestamp() == other.getNextAddTimestamp() && getCurValue() == other.getCurValue() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getCurBuyCount())) + 13)) + getNextAddTimestamp())) + 10)) + getCurValue())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ResinChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResinChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResinChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResinChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResinChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ResinChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ResinChangeNotify parseFrom(InputStream input) throws IOException {
            return (ResinChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResinChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResinChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResinChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ResinChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ResinChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResinChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ResinChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (ResinChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ResinChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ResinChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ResinChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ResinChangeNotifyOuterClass$ResinChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ResinChangeNotifyOrBuilder {
            private int curBuyCount_;
            private int nextAddTimestamp_;
            private int curValue_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ResinChangeNotifyOuterClass.internal_static_ResinChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ResinChangeNotifyOuterClass.internal_static_ResinChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ResinChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ResinChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curBuyCount_ = 0;
                this.nextAddTimestamp_ = 0;
                this.curValue_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ResinChangeNotifyOuterClass.internal_static_ResinChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ResinChangeNotify getDefaultInstanceForType() {
                return ResinChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResinChangeNotify build() {
                ResinChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ResinChangeNotify buildPartial() {
                ResinChangeNotify result = new ResinChangeNotify(this);
                result.curBuyCount_ = this.curBuyCount_;
                result.nextAddTimestamp_ = this.nextAddTimestamp_;
                result.curValue_ = this.curValue_;
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
                if (other instanceof ResinChangeNotify) {
                    return mergeFrom((ResinChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ResinChangeNotify other) {
                if (other == ResinChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getCurBuyCount() != 0) {
                    setCurBuyCount(other.getCurBuyCount());
                }
                if (other.getNextAddTimestamp() != 0) {
                    setNextAddTimestamp(other.getNextAddTimestamp());
                }
                if (other.getCurValue() != 0) {
                    setCurValue(other.getCurValue());
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
                ResinChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ResinChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ResinChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ResinChangeNotifyOuterClass.ResinChangeNotifyOrBuilder
            public int getCurBuyCount() {
                return this.curBuyCount_;
            }

            public Builder setCurBuyCount(int value) {
                this.curBuyCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurBuyCount() {
                this.curBuyCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResinChangeNotifyOuterClass.ResinChangeNotifyOrBuilder
            public int getNextAddTimestamp() {
                return this.nextAddTimestamp_;
            }

            public Builder setNextAddTimestamp(int value) {
                this.nextAddTimestamp_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextAddTimestamp() {
                this.nextAddTimestamp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ResinChangeNotifyOuterClass.ResinChangeNotifyOrBuilder
            public int getCurValue() {
                return this.curValue_;
            }

            public Builder setCurValue(int value) {
                this.curValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurValue() {
                this.curValue_ = 0;
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

        public static ResinChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ResinChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ResinChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ResinChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
