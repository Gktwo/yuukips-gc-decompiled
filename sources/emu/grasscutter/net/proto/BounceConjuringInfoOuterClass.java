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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringInfoOuterClass.class */
public final class BounceConjuringInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019BounceConjuringInfo.proto\"M\n\u0013BounceConjuringInfo\u0012\"\n\u001atotalDestroyedMachineCount\u0018\u0005 \u0001(\r\u0012\u0012\n\ntotalScore\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BounceConjuringInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BounceConjuringInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BounceConjuringInfo_descriptor, new String[]{"TotalDestroyedMachineCount", "TotalScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringInfoOuterClass$BounceConjuringInfoOrBuilder.class */
    public interface BounceConjuringInfoOrBuilder extends MessageOrBuilder {
        int getTotalDestroyedMachineCount();

        int getTotalScore();
    }

    private BounceConjuringInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringInfoOuterClass$BounceConjuringInfo.class */
    public static final class BounceConjuringInfo extends GeneratedMessageV3 implements BounceConjuringInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TOTALDESTROYEDMACHINECOUNT_FIELD_NUMBER = 5;
        private int totalDestroyedMachineCount_;
        public static final int TOTALSCORE_FIELD_NUMBER = 4;
        private int totalScore_;
        private byte memoizedIsInitialized;
        private static final BounceConjuringInfo DEFAULT_INSTANCE = new BounceConjuringInfo();
        private static final Parser<BounceConjuringInfo> PARSER = new AbstractParser<BounceConjuringInfo>() { // from class: emu.grasscutter.net.proto.BounceConjuringInfoOuterClass.BounceConjuringInfo.1
            @Override // com.google.protobuf.Parser
            public BounceConjuringInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BounceConjuringInfo(input, extensionRegistry);
            }
        };

        private BounceConjuringInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BounceConjuringInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BounceConjuringInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BounceConjuringInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.totalScore_ = input.readUInt32();
                                break;
                            case 40:
                                this.totalDestroyedMachineCount_ = input.readUInt32();
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
            return BounceConjuringInfoOuterClass.internal_static_BounceConjuringInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BounceConjuringInfoOuterClass.internal_static_BounceConjuringInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BounceConjuringInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder
        public int getTotalDestroyedMachineCount() {
            return this.totalDestroyedMachineCount_;
        }

        @Override // emu.grasscutter.net.proto.BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder
        public int getTotalScore() {
            return this.totalScore_;
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
            if (this.totalScore_ != 0) {
                output.writeUInt32(4, this.totalScore_);
            }
            if (this.totalDestroyedMachineCount_ != 0) {
                output.writeUInt32(5, this.totalDestroyedMachineCount_);
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
            if (this.totalScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.totalScore_);
            }
            if (this.totalDestroyedMachineCount_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.totalDestroyedMachineCount_);
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
            if (!(obj instanceof BounceConjuringInfo)) {
                return equals(obj);
            }
            BounceConjuringInfo other = (BounceConjuringInfo) obj;
            return getTotalDestroyedMachineCount() == other.getTotalDestroyedMachineCount() && getTotalScore() == other.getTotalScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getTotalDestroyedMachineCount())) + 4)) + getTotalScore())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BounceConjuringInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BounceConjuringInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BounceConjuringInfo parseFrom(InputStream input) throws IOException {
            return (BounceConjuringInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BounceConjuringInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BounceConjuringInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BounceConjuringInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BounceConjuringInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BounceConjuringInfo parseFrom(CodedInputStream input) throws IOException {
            return (BounceConjuringInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BounceConjuringInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BounceConjuringInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BounceConjuringInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BounceConjuringInfoOuterClass$BounceConjuringInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BounceConjuringInfoOrBuilder {
            private int totalDestroyedMachineCount_;
            private int totalScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BounceConjuringInfoOuterClass.internal_static_BounceConjuringInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BounceConjuringInfoOuterClass.internal_static_BounceConjuringInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BounceConjuringInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BounceConjuringInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.totalDestroyedMachineCount_ = 0;
                this.totalScore_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BounceConjuringInfoOuterClass.internal_static_BounceConjuringInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BounceConjuringInfo getDefaultInstanceForType() {
                return BounceConjuringInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BounceConjuringInfo build() {
                BounceConjuringInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BounceConjuringInfo buildPartial() {
                BounceConjuringInfo result = new BounceConjuringInfo(this);
                result.totalDestroyedMachineCount_ = this.totalDestroyedMachineCount_;
                result.totalScore_ = this.totalScore_;
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
                if (other instanceof BounceConjuringInfo) {
                    return mergeFrom((BounceConjuringInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BounceConjuringInfo other) {
                if (other == BounceConjuringInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTotalDestroyedMachineCount() != 0) {
                    setTotalDestroyedMachineCount(other.getTotalDestroyedMachineCount());
                }
                if (other.getTotalScore() != 0) {
                    setTotalScore(other.getTotalScore());
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
                BounceConjuringInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BounceConjuringInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BounceConjuringInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder
            public int getTotalDestroyedMachineCount() {
                return this.totalDestroyedMachineCount_;
            }

            public Builder setTotalDestroyedMachineCount(int value) {
                this.totalDestroyedMachineCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalDestroyedMachineCount() {
                this.totalDestroyedMachineCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder
            public int getTotalScore() {
                return this.totalScore_;
            }

            public Builder setTotalScore(int value) {
                this.totalScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalScore() {
                this.totalScore_ = 0;
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

        public static BounceConjuringInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BounceConjuringInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BounceConjuringInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BounceConjuringInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}