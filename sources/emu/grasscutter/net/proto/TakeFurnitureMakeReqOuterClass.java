package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeReqOuterClass.class */
public final class TakeFurnitureMakeReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aTakeFurnitureMakeReq.proto\"N\n\u0014TakeFurnitureMakeReq\u0012\r\n\u0005index\u0018\f \u0001(\r\u0012\u0016\n\u000eis_fast_finish\u0018\u0002 \u0001(\b\u0012\u000f\n\u0007make_id\u0018\u0007 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TakeFurnitureMakeReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeFurnitureMakeReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeFurnitureMakeReq_descriptor, new String[]{"Index", "IsFastFinish", "MakeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeReqOuterClass$TakeFurnitureMakeReqOrBuilder.class */
    public interface TakeFurnitureMakeReqOrBuilder extends MessageOrBuilder {
        int getIndex();

        boolean getIsFastFinish();

        int getMakeId();
    }

    private TakeFurnitureMakeReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeReqOuterClass$TakeFurnitureMakeReq.class */
    public static final class TakeFurnitureMakeReq extends GeneratedMessageV3 implements TakeFurnitureMakeReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INDEX_FIELD_NUMBER = 12;
        private int index_;
        public static final int IS_FAST_FINISH_FIELD_NUMBER = 2;
        private boolean isFastFinish_;
        public static final int MAKE_ID_FIELD_NUMBER = 7;
        private int makeId_;
        private byte memoizedIsInitialized;
        private static final TakeFurnitureMakeReq DEFAULT_INSTANCE = new TakeFurnitureMakeReq();
        private static final Parser<TakeFurnitureMakeReq> PARSER = new AbstractParser<TakeFurnitureMakeReq>() { // from class: emu.grasscutter.net.proto.TakeFurnitureMakeReqOuterClass.TakeFurnitureMakeReq.1
            @Override // com.google.protobuf.Parser
            public TakeFurnitureMakeReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeFurnitureMakeReq(input, extensionRegistry);
            }
        };

        private TakeFurnitureMakeReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TakeFurnitureMakeReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeFurnitureMakeReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeFurnitureMakeReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.isFastFinish_ = input.readBool();
                                    break;
                                case 56:
                                    this.makeId_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.index_ = input.readUInt32();
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
            return TakeFurnitureMakeReqOuterClass.internal_static_TakeFurnitureMakeReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeFurnitureMakeReqOuterClass.internal_static_TakeFurnitureMakeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeFurnitureMakeReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeReqOuterClass.TakeFurnitureMakeReqOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeReqOuterClass.TakeFurnitureMakeReqOrBuilder
        public boolean getIsFastFinish() {
            return this.isFastFinish_;
        }

        @Override // emu.grasscutter.net.proto.TakeFurnitureMakeReqOuterClass.TakeFurnitureMakeReqOrBuilder
        public int getMakeId() {
            return this.makeId_;
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
            if (this.isFastFinish_) {
                output.writeBool(2, this.isFastFinish_);
            }
            if (this.makeId_ != 0) {
                output.writeUInt32(7, this.makeId_);
            }
            if (this.index_ != 0) {
                output.writeUInt32(12, this.index_);
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
            if (this.isFastFinish_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isFastFinish_);
            }
            if (this.makeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.makeId_);
            }
            if (this.index_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.index_);
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
            if (!(obj instanceof TakeFurnitureMakeReq)) {
                return equals(obj);
            }
            TakeFurnitureMakeReq other = (TakeFurnitureMakeReq) obj;
            return getIndex() == other.getIndex() && getIsFastFinish() == other.getIsFastFinish() && getMakeId() == other.getMakeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getIndex())) + 2)) + Internal.hashBoolean(getIsFastFinish()))) + 7)) + getMakeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TakeFurnitureMakeReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeFurnitureMakeReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeFurnitureMakeReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeFurnitureMakeReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeFurnitureMakeReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeFurnitureMakeReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeFurnitureMakeReq parseFrom(InputStream input) throws IOException {
            return (TakeFurnitureMakeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeFurnitureMakeReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeFurnitureMakeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeFurnitureMakeReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeFurnitureMakeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeFurnitureMakeReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeFurnitureMakeReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeFurnitureMakeReq parseFrom(CodedInputStream input) throws IOException {
            return (TakeFurnitureMakeReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeFurnitureMakeReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeFurnitureMakeReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeFurnitureMakeReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeFurnitureMakeReqOuterClass$TakeFurnitureMakeReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeFurnitureMakeReqOrBuilder {
            private int index_;
            private boolean isFastFinish_;
            private int makeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeFurnitureMakeReqOuterClass.internal_static_TakeFurnitureMakeReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeFurnitureMakeReqOuterClass.internal_static_TakeFurnitureMakeReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeFurnitureMakeReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeFurnitureMakeReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.index_ = 0;
                this.isFastFinish_ = false;
                this.makeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeFurnitureMakeReqOuterClass.internal_static_TakeFurnitureMakeReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeFurnitureMakeReq getDefaultInstanceForType() {
                return TakeFurnitureMakeReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeFurnitureMakeReq build() {
                TakeFurnitureMakeReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeFurnitureMakeReq buildPartial() {
                TakeFurnitureMakeReq result = new TakeFurnitureMakeReq(this);
                result.index_ = this.index_;
                result.isFastFinish_ = this.isFastFinish_;
                result.makeId_ = this.makeId_;
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
                if (other instanceof TakeFurnitureMakeReq) {
                    return mergeFrom((TakeFurnitureMakeReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeFurnitureMakeReq other) {
                if (other == TakeFurnitureMakeReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getIndex() != 0) {
                    setIndex(other.getIndex());
                }
                if (other.getIsFastFinish()) {
                    setIsFastFinish(other.getIsFastFinish());
                }
                if (other.getMakeId() != 0) {
                    setMakeId(other.getMakeId());
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
                TakeFurnitureMakeReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeFurnitureMakeReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeFurnitureMakeReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeReqOuterClass.TakeFurnitureMakeReqOrBuilder
            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int value) {
                this.index_ = value;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeReqOuterClass.TakeFurnitureMakeReqOrBuilder
            public boolean getIsFastFinish() {
                return this.isFastFinish_;
            }

            public Builder setIsFastFinish(boolean value) {
                this.isFastFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFastFinish() {
                this.isFastFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeFurnitureMakeReqOuterClass.TakeFurnitureMakeReqOrBuilder
            public int getMakeId() {
                return this.makeId_;
            }

            public Builder setMakeId(int value) {
                this.makeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMakeId() {
                this.makeId_ = 0;
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

        public static TakeFurnitureMakeReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeFurnitureMakeReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeFurnitureMakeReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeFurnitureMakeReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
