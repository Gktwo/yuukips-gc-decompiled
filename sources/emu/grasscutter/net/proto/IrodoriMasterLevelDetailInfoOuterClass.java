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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelDetailInfoOuterClass.class */
public final class IrodoriMasterLevelDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"IrodoriMasterLevelDetailInfo.proto\"n\n\u001cIrodoriMasterLevelDetailInfo\u0012\u0010\n\bisFinish\u0018\u0006 \u0001(\b\u0012\u0011\n\tisHaveTry\u0018\u0005 \u0001(\b\u0012\u0015\n\rminFinishTime\u0018\u000e \u0001(\r\u0012\u0012\n\ndifficulty\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_IrodoriMasterLevelDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriMasterLevelDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriMasterLevelDetailInfo_descriptor, new String[]{"IsFinish", "IsHaveTry", "MinFinishTime", "Difficulty"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelDetailInfoOuterClass$IrodoriMasterLevelDetailInfoOrBuilder.class */
    public interface IrodoriMasterLevelDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsFinish();

        boolean getIsHaveTry();

        int getMinFinishTime();

        int getDifficulty();
    }

    private IrodoriMasterLevelDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelDetailInfoOuterClass$IrodoriMasterLevelDetailInfo.class */
    public static final class IrodoriMasterLevelDetailInfo extends GeneratedMessageV3 implements IrodoriMasterLevelDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISFINISH_FIELD_NUMBER = 6;
        private boolean isFinish_;
        public static final int ISHAVETRY_FIELD_NUMBER = 5;
        private boolean isHaveTry_;
        public static final int MINFINISHTIME_FIELD_NUMBER = 14;
        private int minFinishTime_;
        public static final int DIFFICULTY_FIELD_NUMBER = 3;
        private int difficulty_;
        private byte memoizedIsInitialized;
        private static final IrodoriMasterLevelDetailInfo DEFAULT_INSTANCE = new IrodoriMasterLevelDetailInfo();
        private static final Parser<IrodoriMasterLevelDetailInfo> PARSER = new AbstractParser<IrodoriMasterLevelDetailInfo>() { // from class: emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfo.1
            @Override // com.google.protobuf.Parser
            public IrodoriMasterLevelDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriMasterLevelDetailInfo(input, extensionRegistry);
            }
        };

        private IrodoriMasterLevelDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriMasterLevelDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriMasterLevelDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriMasterLevelDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.difficulty_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.isHaveTry_ = input.readBool();
                                    break;
                                case 48:
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 112:
                                    this.minFinishTime_ = input.readUInt32();
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
            return IrodoriMasterLevelDetailInfoOuterClass.internal_static_IrodoriMasterLevelDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriMasterLevelDetailInfoOuterClass.internal_static_IrodoriMasterLevelDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriMasterLevelDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
        public boolean getIsHaveTry() {
            return this.isHaveTry_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
        public int getMinFinishTime() {
            return this.minFinishTime_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
        public int getDifficulty() {
            return this.difficulty_;
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
            if (this.difficulty_ != 0) {
                output.writeUInt32(3, this.difficulty_);
            }
            if (this.isHaveTry_) {
                output.writeBool(5, this.isHaveTry_);
            }
            if (this.isFinish_) {
                output.writeBool(6, this.isFinish_);
            }
            if (this.minFinishTime_ != 0) {
                output.writeUInt32(14, this.minFinishTime_);
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
            if (this.difficulty_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.difficulty_);
            }
            if (this.isHaveTry_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isHaveTry_);
            }
            if (this.isFinish_) {
                size2 += CodedOutputStream.computeBoolSize(6, this.isFinish_);
            }
            if (this.minFinishTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.minFinishTime_);
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
            if (!(obj instanceof IrodoriMasterLevelDetailInfo)) {
                return equals(obj);
            }
            IrodoriMasterLevelDetailInfo other = (IrodoriMasterLevelDetailInfo) obj;
            return getIsFinish() == other.getIsFinish() && getIsHaveTry() == other.getIsHaveTry() && getMinFinishTime() == other.getMinFinishTime() && getDifficulty() == other.getDifficulty() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + Internal.hashBoolean(getIsFinish()))) + 5)) + Internal.hashBoolean(getIsHaveTry()))) + 14)) + getMinFinishTime())) + 3)) + getDifficulty())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(InputStream input) throws IOException {
            return (IrodoriMasterLevelDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriMasterLevelDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriMasterLevelDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriMasterLevelDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriMasterLevelDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriMasterLevelDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriMasterLevelDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriMasterLevelDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriMasterLevelDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriMasterLevelDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriMasterLevelDetailInfoOuterClass$IrodoriMasterLevelDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriMasterLevelDetailInfoOrBuilder {
            private boolean isFinish_;
            private boolean isHaveTry_;
            private int minFinishTime_;
            private int difficulty_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriMasterLevelDetailInfoOuterClass.internal_static_IrodoriMasterLevelDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriMasterLevelDetailInfoOuterClass.internal_static_IrodoriMasterLevelDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriMasterLevelDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriMasterLevelDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinish_ = false;
                this.isHaveTry_ = false;
                this.minFinishTime_ = 0;
                this.difficulty_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriMasterLevelDetailInfoOuterClass.internal_static_IrodoriMasterLevelDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriMasterLevelDetailInfo getDefaultInstanceForType() {
                return IrodoriMasterLevelDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriMasterLevelDetailInfo build() {
                IrodoriMasterLevelDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriMasterLevelDetailInfo buildPartial() {
                IrodoriMasterLevelDetailInfo result = new IrodoriMasterLevelDetailInfo(this);
                result.isFinish_ = this.isFinish_;
                result.isHaveTry_ = this.isHaveTry_;
                result.minFinishTime_ = this.minFinishTime_;
                result.difficulty_ = this.difficulty_;
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
                if (other instanceof IrodoriMasterLevelDetailInfo) {
                    return mergeFrom((IrodoriMasterLevelDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriMasterLevelDetailInfo other) {
                if (other == IrodoriMasterLevelDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getIsHaveTry()) {
                    setIsHaveTry(other.getIsHaveTry());
                }
                if (other.getMinFinishTime() != 0) {
                    setMinFinishTime(other.getMinFinishTime());
                }
                if (other.getDifficulty() != 0) {
                    setDifficulty(other.getDifficulty());
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
                IrodoriMasterLevelDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriMasterLevelDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriMasterLevelDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
            public boolean getIsHaveTry() {
                return this.isHaveTry_;
            }

            public Builder setIsHaveTry(boolean value) {
                this.isHaveTry_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHaveTry() {
                this.isHaveTry_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
            public int getMinFinishTime() {
                return this.minFinishTime_;
            }

            public Builder setMinFinishTime(int value) {
                this.minFinishTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearMinFinishTime() {
                this.minFinishTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriMasterLevelDetailInfoOuterClass.IrodoriMasterLevelDetailInfoOrBuilder
            public int getDifficulty() {
                return this.difficulty_;
            }

            public Builder setDifficulty(int value) {
                this.difficulty_ = value;
                onChanged();
                return this;
            }

            public Builder clearDifficulty() {
                this.difficulty_ = 0;
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

        public static IrodoriMasterLevelDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriMasterLevelDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriMasterLevelDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriMasterLevelDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
