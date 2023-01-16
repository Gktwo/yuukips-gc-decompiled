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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeeklyBossResinDiscountInfoOuterClass.class */
public final class WeeklyBossResinDiscountInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!WeeklyBossResinDiscountInfo.proto\"\u0001\n\u001bWeeklyBossResinDiscountInfo\u0012\u0014\n\fdiscount_num\u0018\u0001 \u0001(\r\u0012\u001a\n\u0012discount_num_limit\u0018\u0002 \u0001(\r\u0012\u0012\n\nresin_cost\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013original_resin_cost\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WeeklyBossResinDiscountInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WeeklyBossResinDiscountInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeeklyBossResinDiscountInfo_descriptor, new String[]{"DiscountNum", "DiscountNumLimit", "ResinCost", "OriginalResinCost"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeeklyBossResinDiscountInfoOuterClass$WeeklyBossResinDiscountInfoOrBuilder.class */
    public interface WeeklyBossResinDiscountInfoOrBuilder extends MessageOrBuilder {
        int getDiscountNum();

        int getDiscountNumLimit();

        int getResinCost();

        int getOriginalResinCost();
    }

    private WeeklyBossResinDiscountInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeeklyBossResinDiscountInfoOuterClass$WeeklyBossResinDiscountInfo.class */
    public static final class WeeklyBossResinDiscountInfo extends GeneratedMessageV3 implements WeeklyBossResinDiscountInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DISCOUNT_NUM_FIELD_NUMBER = 1;
        private int discountNum_;
        public static final int DISCOUNT_NUM_LIMIT_FIELD_NUMBER = 2;
        private int discountNumLimit_;
        public static final int RESIN_COST_FIELD_NUMBER = 3;
        private int resinCost_;
        public static final int ORIGINAL_RESIN_COST_FIELD_NUMBER = 4;
        private int originalResinCost_;
        private byte memoizedIsInitialized;
        private static final WeeklyBossResinDiscountInfo DEFAULT_INSTANCE = new WeeklyBossResinDiscountInfo();
        private static final Parser<WeeklyBossResinDiscountInfo> PARSER = new AbstractParser<WeeklyBossResinDiscountInfo>() { // from class: emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfo.1
            @Override // com.google.protobuf.Parser
            public WeeklyBossResinDiscountInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WeeklyBossResinDiscountInfo(input, extensionRegistry);
            }
        };

        private WeeklyBossResinDiscountInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WeeklyBossResinDiscountInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WeeklyBossResinDiscountInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WeeklyBossResinDiscountInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.discountNum_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.discountNumLimit_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.resinCost_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.originalResinCost_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WeeklyBossResinDiscountInfoOuterClass.internal_static_WeeklyBossResinDiscountInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WeeklyBossResinDiscountInfoOuterClass.internal_static_WeeklyBossResinDiscountInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WeeklyBossResinDiscountInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
        public int getDiscountNum() {
            return this.discountNum_;
        }

        @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
        public int getDiscountNumLimit() {
            return this.discountNumLimit_;
        }

        @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
        public int getResinCost() {
            return this.resinCost_;
        }

        @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
        public int getOriginalResinCost() {
            return this.originalResinCost_;
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
            if (this.discountNum_ != 0) {
                output.writeUInt32(1, this.discountNum_);
            }
            if (this.discountNumLimit_ != 0) {
                output.writeUInt32(2, this.discountNumLimit_);
            }
            if (this.resinCost_ != 0) {
                output.writeUInt32(3, this.resinCost_);
            }
            if (this.originalResinCost_ != 0) {
                output.writeUInt32(4, this.originalResinCost_);
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
            if (this.discountNum_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.discountNum_);
            }
            if (this.discountNumLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.discountNumLimit_);
            }
            if (this.resinCost_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.resinCost_);
            }
            if (this.originalResinCost_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.originalResinCost_);
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
            if (!(obj instanceof WeeklyBossResinDiscountInfo)) {
                return equals(obj);
            }
            WeeklyBossResinDiscountInfo other = (WeeklyBossResinDiscountInfo) obj;
            return getDiscountNum() == other.getDiscountNum() && getDiscountNumLimit() == other.getDiscountNumLimit() && getResinCost() == other.getResinCost() && getOriginalResinCost() == other.getOriginalResinCost() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getDiscountNum())) + 2)) + getDiscountNumLimit())) + 3)) + getResinCost())) + 4)) + getOriginalResinCost())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static WeeklyBossResinDiscountInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(InputStream input) throws IOException {
            return (WeeklyBossResinDiscountInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeeklyBossResinDiscountInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeeklyBossResinDiscountInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WeeklyBossResinDiscountInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WeeklyBossResinDiscountInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeeklyBossResinDiscountInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(CodedInputStream input) throws IOException {
            return (WeeklyBossResinDiscountInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeeklyBossResinDiscountInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeeklyBossResinDiscountInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WeeklyBossResinDiscountInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeeklyBossResinDiscountInfoOuterClass$WeeklyBossResinDiscountInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WeeklyBossResinDiscountInfoOrBuilder {
            private int discountNum_;
            private int discountNumLimit_;
            private int resinCost_;
            private int originalResinCost_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WeeklyBossResinDiscountInfoOuterClass.internal_static_WeeklyBossResinDiscountInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WeeklyBossResinDiscountInfoOuterClass.internal_static_WeeklyBossResinDiscountInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WeeklyBossResinDiscountInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WeeklyBossResinDiscountInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.discountNum_ = 0;
                this.discountNumLimit_ = 0;
                this.resinCost_ = 0;
                this.originalResinCost_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WeeklyBossResinDiscountInfoOuterClass.internal_static_WeeklyBossResinDiscountInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WeeklyBossResinDiscountInfo getDefaultInstanceForType() {
                return WeeklyBossResinDiscountInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeeklyBossResinDiscountInfo build() {
                WeeklyBossResinDiscountInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeeklyBossResinDiscountInfo buildPartial() {
                WeeklyBossResinDiscountInfo result = new WeeklyBossResinDiscountInfo(this);
                result.discountNum_ = this.discountNum_;
                result.discountNumLimit_ = this.discountNumLimit_;
                result.resinCost_ = this.resinCost_;
                result.originalResinCost_ = this.originalResinCost_;
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
                if (other instanceof WeeklyBossResinDiscountInfo) {
                    return mergeFrom((WeeklyBossResinDiscountInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WeeklyBossResinDiscountInfo other) {
                if (other == WeeklyBossResinDiscountInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDiscountNum() != 0) {
                    setDiscountNum(other.getDiscountNum());
                }
                if (other.getDiscountNumLimit() != 0) {
                    setDiscountNumLimit(other.getDiscountNumLimit());
                }
                if (other.getResinCost() != 0) {
                    setResinCost(other.getResinCost());
                }
                if (other.getOriginalResinCost() != 0) {
                    setOriginalResinCost(other.getOriginalResinCost());
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
                WeeklyBossResinDiscountInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WeeklyBossResinDiscountInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WeeklyBossResinDiscountInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
            public int getDiscountNum() {
                return this.discountNum_;
            }

            public Builder setDiscountNum(int value) {
                this.discountNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearDiscountNum() {
                this.discountNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
            public int getDiscountNumLimit() {
                return this.discountNumLimit_;
            }

            public Builder setDiscountNumLimit(int value) {
                this.discountNumLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearDiscountNumLimit() {
                this.discountNumLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
            public int getResinCost() {
                return this.resinCost_;
            }

            public Builder setResinCost(int value) {
                this.resinCost_ = value;
                onChanged();
                return this;
            }

            public Builder clearResinCost() {
                this.resinCost_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeeklyBossResinDiscountInfoOuterClass.WeeklyBossResinDiscountInfoOrBuilder
            public int getOriginalResinCost() {
                return this.originalResinCost_;
            }

            public Builder setOriginalResinCost(int value) {
                this.originalResinCost_ = value;
                onChanged();
                return this;
            }

            public Builder clearOriginalResinCost() {
                this.originalResinCost_ = 0;
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

        public static WeeklyBossResinDiscountInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WeeklyBossResinDiscountInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WeeklyBossResinDiscountInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WeeklyBossResinDiscountInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
