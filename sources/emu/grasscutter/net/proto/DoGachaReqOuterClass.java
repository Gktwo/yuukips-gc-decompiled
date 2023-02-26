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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaReqOuterClass.class */
public final class DoGachaReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010DoGachaReq.proto\"s\n\nDoGachaReq\u0012\u0013\n\u000bgachaRandom\u0018\f \u0001(\r\u0012\u0011\n\tgachaType\u0018\u0002 \u0001(\r\u0012\u0017\n\u000fgachaScheduleId\u0018\u0003 \u0001(\r\u0012\u0010\n\bgachaTag\u0018\u000f \u0001(\t\u0012\u0012\n\ngachaTimes\u0018\n \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_DoGachaReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DoGachaReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DoGachaReq_descriptor, new String[]{"GachaRandom", "GachaType", "GachaScheduleId", "GachaTag", "GachaTimes"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaReqOuterClass$DoGachaReqOrBuilder.class */
    public interface DoGachaReqOrBuilder extends MessageOrBuilder {
        int getGachaRandom();

        int getGachaType();

        int getGachaScheduleId();

        String getGachaTag();

        ByteString getGachaTagBytes();

        int getGachaTimes();
    }

    private DoGachaReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaReqOuterClass$DoGachaReq.class */
    public static final class DoGachaReq extends GeneratedMessageV3 implements DoGachaReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GACHARANDOM_FIELD_NUMBER = 12;
        private int gachaRandom_;
        public static final int GACHATYPE_FIELD_NUMBER = 2;
        private int gachaType_;
        public static final int GACHASCHEDULEID_FIELD_NUMBER = 3;
        private int gachaScheduleId_;
        public static final int GACHATAG_FIELD_NUMBER = 15;
        private volatile Object gachaTag_;
        public static final int GACHATIMES_FIELD_NUMBER = 10;
        private int gachaTimes_;
        private byte memoizedIsInitialized;
        private static final DoGachaReq DEFAULT_INSTANCE = new DoGachaReq();
        private static final Parser<DoGachaReq> PARSER = new AbstractParser<DoGachaReq>() { // from class: emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReq.1
            @Override // com.google.protobuf.Parser
            public DoGachaReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DoGachaReq(input, extensionRegistry);
            }
        };

        private DoGachaReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DoGachaReq() {
            this.memoizedIsInitialized = -1;
            this.gachaTag_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DoGachaReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DoGachaReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.gachaType_ = input.readUInt32();
                                break;
                            case 24:
                                this.gachaScheduleId_ = input.readUInt32();
                                break;
                            case 80:
                                this.gachaTimes_ = input.readUInt32();
                                break;
                            case 96:
                                this.gachaRandom_ = input.readUInt32();
                                break;
                            case 122:
                                this.gachaTag_ = input.readStringRequireUtf8();
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
            return DoGachaReqOuterClass.internal_static_DoGachaReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DoGachaReqOuterClass.internal_static_DoGachaReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DoGachaReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
        public int getGachaRandom() {
            return this.gachaRandom_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
        public int getGachaType() {
            return this.gachaType_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
        public int getGachaScheduleId() {
            return this.gachaScheduleId_;
        }

        @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
        public String getGachaTag() {
            Object ref = this.gachaTag_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaTag_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
        public ByteString getGachaTagBytes() {
            Object ref = this.gachaTag_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaTag_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
        public int getGachaTimes() {
            return this.gachaTimes_;
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
            if (this.gachaType_ != 0) {
                output.writeUInt32(2, this.gachaType_);
            }
            if (this.gachaScheduleId_ != 0) {
                output.writeUInt32(3, this.gachaScheduleId_);
            }
            if (this.gachaTimes_ != 0) {
                output.writeUInt32(10, this.gachaTimes_);
            }
            if (this.gachaRandom_ != 0) {
                output.writeUInt32(12, this.gachaRandom_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaTag_)) {
                GeneratedMessageV3.writeString(output, 15, this.gachaTag_);
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
            if (this.gachaType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.gachaType_);
            }
            if (this.gachaScheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.gachaScheduleId_);
            }
            if (this.gachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.gachaTimes_);
            }
            if (this.gachaRandom_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.gachaRandom_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaTag_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.gachaTag_);
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
            if (!(obj instanceof DoGachaReq)) {
                return equals(obj);
            }
            DoGachaReq other = (DoGachaReq) obj;
            return getGachaRandom() == other.getGachaRandom() && getGachaType() == other.getGachaType() && getGachaScheduleId() == other.getGachaScheduleId() && getGachaTag().equals(other.getGachaTag()) && getGachaTimes() == other.getGachaTimes() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getGachaRandom())) + 2)) + getGachaType())) + 3)) + getGachaScheduleId())) + 15)) + getGachaTag().hashCode())) + 10)) + getGachaTimes())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static DoGachaReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DoGachaReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DoGachaReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DoGachaReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DoGachaReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DoGachaReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DoGachaReq parseFrom(InputStream input) throws IOException {
            return (DoGachaReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DoGachaReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DoGachaReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DoGachaReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DoGachaReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DoGachaReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DoGachaReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DoGachaReq parseFrom(CodedInputStream input) throws IOException {
            return (DoGachaReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DoGachaReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DoGachaReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DoGachaReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DoGachaReqOuterClass$DoGachaReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DoGachaReqOrBuilder {
            private int gachaRandom_;
            private int gachaType_;
            private int gachaScheduleId_;
            private Object gachaTag_ = "";
            private int gachaTimes_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DoGachaReqOuterClass.internal_static_DoGachaReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DoGachaReqOuterClass.internal_static_DoGachaReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DoGachaReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DoGachaReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.gachaRandom_ = 0;
                this.gachaType_ = 0;
                this.gachaScheduleId_ = 0;
                this.gachaTag_ = "";
                this.gachaTimes_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DoGachaReqOuterClass.internal_static_DoGachaReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DoGachaReq getDefaultInstanceForType() {
                return DoGachaReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DoGachaReq build() {
                DoGachaReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DoGachaReq buildPartial() {
                DoGachaReq result = new DoGachaReq(this);
                result.gachaRandom_ = this.gachaRandom_;
                result.gachaType_ = this.gachaType_;
                result.gachaScheduleId_ = this.gachaScheduleId_;
                result.gachaTag_ = this.gachaTag_;
                result.gachaTimes_ = this.gachaTimes_;
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
                if (other instanceof DoGachaReq) {
                    return mergeFrom((DoGachaReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DoGachaReq other) {
                if (other == DoGachaReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getGachaRandom() != 0) {
                    setGachaRandom(other.getGachaRandom());
                }
                if (other.getGachaType() != 0) {
                    setGachaType(other.getGachaType());
                }
                if (other.getGachaScheduleId() != 0) {
                    setGachaScheduleId(other.getGachaScheduleId());
                }
                if (!other.getGachaTag().isEmpty()) {
                    this.gachaTag_ = other.gachaTag_;
                    onChanged();
                }
                if (other.getGachaTimes() != 0) {
                    setGachaTimes(other.getGachaTimes());
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
                DoGachaReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DoGachaReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DoGachaReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
            public int getGachaRandom() {
                return this.gachaRandom_;
            }

            public Builder setGachaRandom(int value) {
                this.gachaRandom_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaRandom() {
                this.gachaRandom_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
            public int getGachaType() {
                return this.gachaType_;
            }

            public Builder setGachaType(int value) {
                this.gachaType_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaType() {
                this.gachaType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
            public int getGachaScheduleId() {
                return this.gachaScheduleId_;
            }

            public Builder setGachaScheduleId(int value) {
                this.gachaScheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaScheduleId() {
                this.gachaScheduleId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
            public String getGachaTag() {
                Object ref = this.gachaTag_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaTag_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
            public ByteString getGachaTagBytes() {
                Object ref = this.gachaTag_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaTag_ = b;
                return b;
            }

            public Builder setGachaTag(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaTag_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaTag() {
                this.gachaTag_ = DoGachaReq.getDefaultInstance().getGachaTag();
                onChanged();
                return this;
            }

            public Builder setGachaTagBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                DoGachaReq.checkByteStringIsUtf8(value);
                this.gachaTag_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DoGachaReqOuterClass.DoGachaReqOrBuilder
            public int getGachaTimes() {
                return this.gachaTimes_;
            }

            public Builder setGachaTimes(int value) {
                this.gachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaTimes() {
                this.gachaTimes_ = 0;
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

        public static DoGachaReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DoGachaReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DoGachaReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DoGachaReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
