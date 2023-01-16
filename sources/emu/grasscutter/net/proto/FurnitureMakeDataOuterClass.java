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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeDataOuterClass.class */
public final class FurnitureMakeDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017FurnitureMakeData.proto\"\u0001\n\u0011FurnitureMakeData\u0012\u0012\n\nbegin_time\u0018\u0001 \u0001(\u0007\u0012\u0011\n\tavatar_id\u0018\u0005 \u0001(\r\u0012\u000f\n\u0007make_id\u0018\n \u0001(\r\u0012\r\n\u0005index\u0018\u0006 \u0001(\r\u0012\u0010\n\bdur_time\u0018\b \u0001(\r\u0012\u0017\n\u000faccelerate_time\u0018\u0007 \u0001(\u0007B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FurnitureMakeData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeData_descriptor, new String[]{"BeginTime", "AvatarId", "MakeId", "Index", "DurTime", "AccelerateTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeDataOuterClass$FurnitureMakeDataOrBuilder.class */
    public interface FurnitureMakeDataOrBuilder extends MessageOrBuilder {
        int getBeginTime();

        int getAvatarId();

        int getMakeId();

        int getIndex();

        int getDurTime();

        int getAccelerateTime();
    }

    private FurnitureMakeDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeDataOuterClass$FurnitureMakeData.class */
    public static final class FurnitureMakeData extends GeneratedMessageV3 implements FurnitureMakeDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEGIN_TIME_FIELD_NUMBER = 1;
        private int beginTime_;
        public static final int AVATAR_ID_FIELD_NUMBER = 5;
        private int avatarId_;
        public static final int MAKE_ID_FIELD_NUMBER = 10;
        private int makeId_;
        public static final int INDEX_FIELD_NUMBER = 6;
        private int index_;
        public static final int DUR_TIME_FIELD_NUMBER = 8;
        private int durTime_;
        public static final int ACCELERATE_TIME_FIELD_NUMBER = 7;
        private int accelerateTime_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeData DEFAULT_INSTANCE = new FurnitureMakeData();
        private static final Parser<FurnitureMakeData> PARSER = new AbstractParser<FurnitureMakeData>() { // from class: emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeData.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeData(input, extensionRegistry);
            }
        };

        private FurnitureMakeData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 13:
                                this.beginTime_ = input.readFixed32();
                                break;
                            case 40:
                                this.avatarId_ = input.readUInt32();
                                break;
                            case 48:
                                this.index_ = input.readUInt32();
                                break;
                            case 61:
                                this.accelerateTime_ = input.readFixed32();
                                break;
                            case 64:
                                this.durTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.makeId_ = input.readUInt32();
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
            return FurnitureMakeDataOuterClass.internal_static_FurnitureMakeData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeDataOuterClass.internal_static_FurnitureMakeData_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
        public int getAvatarId() {
            return this.avatarId_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
        public int getMakeId() {
            return this.makeId_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
        public int getDurTime() {
            return this.durTime_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
        public int getAccelerateTime() {
            return this.accelerateTime_;
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
            if (this.beginTime_ != 0) {
                output.writeFixed32(1, this.beginTime_);
            }
            if (this.avatarId_ != 0) {
                output.writeUInt32(5, this.avatarId_);
            }
            if (this.index_ != 0) {
                output.writeUInt32(6, this.index_);
            }
            if (this.accelerateTime_ != 0) {
                output.writeFixed32(7, this.accelerateTime_);
            }
            if (this.durTime_ != 0) {
                output.writeUInt32(8, this.durTime_);
            }
            if (this.makeId_ != 0) {
                output.writeUInt32(10, this.makeId_);
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
            if (this.beginTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeFixed32Size(1, this.beginTime_);
            }
            if (this.avatarId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.avatarId_);
            }
            if (this.index_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.index_);
            }
            if (this.accelerateTime_ != 0) {
                size2 += CodedOutputStream.computeFixed32Size(7, this.accelerateTime_);
            }
            if (this.durTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.durTime_);
            }
            if (this.makeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.makeId_);
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
            if (!(obj instanceof FurnitureMakeData)) {
                return equals(obj);
            }
            FurnitureMakeData other = (FurnitureMakeData) obj;
            return getBeginTime() == other.getBeginTime() && getAvatarId() == other.getAvatarId() && getMakeId() == other.getMakeId() && getIndex() == other.getIndex() && getDurTime() == other.getDurTime() && getAccelerateTime() == other.getAccelerateTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getBeginTime())) + 5)) + getAvatarId())) + 10)) + getMakeId())) + 6)) + getIndex())) + 8)) + getDurTime())) + 7)) + getAccelerateTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FurnitureMakeData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeData parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeData parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeData parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeDataOuterClass$FurnitureMakeData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeDataOrBuilder {
            private int beginTime_;
            private int avatarId_;
            private int makeId_;
            private int index_;
            private int durTime_;
            private int accelerateTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeDataOuterClass.internal_static_FurnitureMakeData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeDataOuterClass.internal_static_FurnitureMakeData_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.beginTime_ = 0;
                this.avatarId_ = 0;
                this.makeId_ = 0;
                this.index_ = 0;
                this.durTime_ = 0;
                this.accelerateTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeDataOuterClass.internal_static_FurnitureMakeData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeData getDefaultInstanceForType() {
                return FurnitureMakeData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeData build() {
                FurnitureMakeData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeData buildPartial() {
                FurnitureMakeData result = new FurnitureMakeData(this);
                result.beginTime_ = this.beginTime_;
                result.avatarId_ = this.avatarId_;
                result.makeId_ = this.makeId_;
                result.index_ = this.index_;
                result.durTime_ = this.durTime_;
                result.accelerateTime_ = this.accelerateTime_;
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
                if (other instanceof FurnitureMakeData) {
                    return mergeFrom((FurnitureMakeData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeData other) {
                if (other == FurnitureMakeData.getDefaultInstance()) {
                    return this;
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getAvatarId() != 0) {
                    setAvatarId(other.getAvatarId());
                }
                if (other.getMakeId() != 0) {
                    setMakeId(other.getMakeId());
                }
                if (other.getIndex() != 0) {
                    setIndex(other.getIndex());
                }
                if (other.getDurTime() != 0) {
                    setDurTime(other.getDurTime());
                }
                if (other.getAccelerateTime() != 0) {
                    setAccelerateTime(other.getAccelerateTime());
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
                FurnitureMakeData parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
            public int getAvatarId() {
                return this.avatarId_;
            }

            public Builder setAvatarId(int value) {
                this.avatarId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAvatarId() {
                this.avatarId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
            public int getDurTime() {
                return this.durTime_;
            }

            public Builder setDurTime(int value) {
                this.durTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearDurTime() {
                this.durTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeDataOuterClass.FurnitureMakeDataOrBuilder
            public int getAccelerateTime() {
                return this.accelerateTime_;
            }

            public Builder setAccelerateTime(int value) {
                this.accelerateTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearAccelerateTime() {
                this.accelerateTime_ = 0;
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

        public static FurnitureMakeData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
