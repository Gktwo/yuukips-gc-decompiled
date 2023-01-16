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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PingReqOuterClass.class */
public final class PingReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\rPingReq.proto\"f\n\u0007PingReq\u0012\u0013\n\u000bclient_time\u0018\u0006 \u0001(\r\u0012\u0017\n\u000ftotal_tick_time\u0018\t \u0001(\u0001\u0012\u000f\n\u0007ue_time\u0018\u0002 \u0001(\u0002\u0012\u000b\n\u0003seq\u0018\f \u0001(\r\u0012\u000f\n\u0007sc_data\u0018\u0003 \u0001(\fB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_PingReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PingReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PingReq_descriptor, new String[]{"ClientTime", "TotalTickTime", "UeTime", "Seq", "ScData"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PingReqOuterClass$PingReqOrBuilder.class */
    public interface PingReqOrBuilder extends MessageOrBuilder {
        int getClientTime();

        double getTotalTickTime();

        float getUeTime();

        int getSeq();

        ByteString getScData();
    }

    private PingReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PingReqOuterClass$PingReq.class */
    public static final class PingReq extends GeneratedMessageV3 implements PingReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CLIENT_TIME_FIELD_NUMBER = 6;
        private int clientTime_;
        public static final int TOTAL_TICK_TIME_FIELD_NUMBER = 9;
        private double totalTickTime_;
        public static final int UE_TIME_FIELD_NUMBER = 2;
        private float ueTime_;
        public static final int SEQ_FIELD_NUMBER = 12;
        private int seq_;
        public static final int SC_DATA_FIELD_NUMBER = 3;
        private ByteString scData_;
        private byte memoizedIsInitialized;
        private static final PingReq DEFAULT_INSTANCE = new PingReq();
        private static final Parser<PingReq> PARSER = new AbstractParser<PingReq>() { // from class: emu.grasscutter.net.proto.PingReqOuterClass.PingReq.1
            @Override // com.google.protobuf.Parser
            public PingReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PingReq(input, extensionRegistry);
            }
        };

        private PingReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private PingReq() {
            this.memoizedIsInitialized = -1;
            this.scData_ = ByteString.EMPTY;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PingReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private PingReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 21:
                                this.ueTime_ = input.readFloat();
                                break;
                            case 26:
                                this.scData_ = input.readBytes();
                                break;
                            case 48:
                                this.clientTime_ = input.readUInt32();
                                break;
                            case 73:
                                this.totalTickTime_ = input.readDouble();
                                break;
                            case 96:
                                this.seq_ = input.readUInt32();
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
            return PingReqOuterClass.internal_static_PingReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PingReqOuterClass.internal_static_PingReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PingReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
        public int getClientTime() {
            return this.clientTime_;
        }

        @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
        public double getTotalTickTime() {
            return this.totalTickTime_;
        }

        @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
        public float getUeTime() {
            return this.ueTime_;
        }

        @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
        public int getSeq() {
            return this.seq_;
        }

        @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
        public ByteString getScData() {
            return this.scData_;
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
            if (this.ueTime_ != 0.0f) {
                output.writeFloat(2, this.ueTime_);
            }
            if (!this.scData_.isEmpty()) {
                output.writeBytes(3, this.scData_);
            }
            if (this.clientTime_ != 0) {
                output.writeUInt32(6, this.clientTime_);
            }
            if (this.totalTickTime_ != 0.0d) {
                output.writeDouble(9, this.totalTickTime_);
            }
            if (this.seq_ != 0) {
                output.writeUInt32(12, this.seq_);
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
            if (this.ueTime_ != 0.0f) {
                size2 = 0 + CodedOutputStream.computeFloatSize(2, this.ueTime_);
            }
            if (!this.scData_.isEmpty()) {
                size2 += CodedOutputStream.computeBytesSize(3, this.scData_);
            }
            if (this.clientTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.clientTime_);
            }
            if (this.totalTickTime_ != 0.0d) {
                size2 += CodedOutputStream.computeDoubleSize(9, this.totalTickTime_);
            }
            if (this.seq_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.seq_);
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
            if (!(obj instanceof PingReq)) {
                return equals(obj);
            }
            PingReq other = (PingReq) obj;
            return getClientTime() == other.getClientTime() && Double.doubleToLongBits(getTotalTickTime()) == Double.doubleToLongBits(other.getTotalTickTime()) && Float.floatToIntBits(getUeTime()) == Float.floatToIntBits(other.getUeTime()) && getSeq() == other.getSeq() && getScData().equals(other.getScData()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getClientTime())) + 9)) + Internal.hashLong(Double.doubleToLongBits(getTotalTickTime())))) + 2)) + Float.floatToIntBits(getUeTime()))) + 12)) + getSeq())) + 3)) + getScData().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static PingReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PingReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PingReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PingReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PingReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PingReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PingReq parseFrom(InputStream input) throws IOException {
            return (PingReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PingReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PingReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PingReq parseDelimitedFrom(InputStream input) throws IOException {
            return (PingReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PingReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PingReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PingReq parseFrom(CodedInputStream input) throws IOException {
            return (PingReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PingReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PingReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PingReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PingReqOuterClass$PingReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PingReqOrBuilder {
            private int clientTime_;
            private double totalTickTime_;
            private float ueTime_;
            private int seq_;
            private ByteString scData_ = ByteString.EMPTY;

            public static final Descriptors.Descriptor getDescriptor() {
                return PingReqOuterClass.internal_static_PingReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PingReqOuterClass.internal_static_PingReq_fieldAccessorTable.ensureFieldAccessorsInitialized(PingReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PingReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.clientTime_ = 0;
                this.totalTickTime_ = 0.0d;
                this.ueTime_ = 0.0f;
                this.seq_ = 0;
                this.scData_ = ByteString.EMPTY;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PingReqOuterClass.internal_static_PingReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PingReq getDefaultInstanceForType() {
                return PingReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PingReq build() {
                PingReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PingReq buildPartial() {
                PingReq result = new PingReq(this);
                result.clientTime_ = this.clientTime_;
                result.totalTickTime_ = this.totalTickTime_;
                result.ueTime_ = this.ueTime_;
                result.seq_ = this.seq_;
                result.scData_ = this.scData_;
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
                if (other instanceof PingReq) {
                    return mergeFrom((PingReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PingReq other) {
                if (other == PingReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getClientTime() != 0) {
                    setClientTime(other.getClientTime());
                }
                if (other.getTotalTickTime() != 0.0d) {
                    setTotalTickTime(other.getTotalTickTime());
                }
                if (other.getUeTime() != 0.0f) {
                    setUeTime(other.getUeTime());
                }
                if (other.getSeq() != 0) {
                    setSeq(other.getSeq());
                }
                if (other.getScData() != ByteString.EMPTY) {
                    setScData(other.getScData());
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
                PingReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = PingReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PingReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
            public int getClientTime() {
                return this.clientTime_;
            }

            public Builder setClientTime(int value) {
                this.clientTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientTime() {
                this.clientTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
            public double getTotalTickTime() {
                return this.totalTickTime_;
            }

            public Builder setTotalTickTime(double value) {
                this.totalTickTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalTickTime() {
                this.totalTickTime_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
            public float getUeTime() {
                return this.ueTime_;
            }

            public Builder setUeTime(float value) {
                this.ueTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearUeTime() {
                this.ueTime_ = 0.0f;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
            public int getSeq() {
                return this.seq_;
            }

            public Builder setSeq(int value) {
                this.seq_ = value;
                onChanged();
                return this;
            }

            public Builder clearSeq() {
                this.seq_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PingReqOuterClass.PingReqOrBuilder
            public ByteString getScData() {
                return this.scData_;
            }

            public Builder setScData(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.scData_ = value;
                onChanged();
                return this;
            }

            public Builder clearScData() {
                this.scData_ = PingReq.getDefaultInstance().getScData();
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

        public static PingReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PingReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PingReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PingReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
