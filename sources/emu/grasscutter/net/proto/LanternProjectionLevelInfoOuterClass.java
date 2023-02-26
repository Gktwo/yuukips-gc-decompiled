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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionLevelInfoOuterClass.class */
public final class LanternProjectionLevelInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n LanternProjectionLevelInfo.proto\"{\n\u001aLanternProjectionLevelInfo\u0012\u0012\n\nisCanStart\u0018\u0004 \u0001(\b\u0012\n\n\u0002id\u0018\u0007 \u0001(\r\u0012\u0015\n\rminFinishTime\u0018\u0001 \u0001(\r\u0012\u0012\n\nisFinished\u0018\u000e \u0001(\b\u0012\u0012\n\nisShowTips\u0018\u0002 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_LanternProjectionLevelInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LanternProjectionLevelInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LanternProjectionLevelInfo_descriptor, new String[]{"IsCanStart", "Id", "MinFinishTime", "IsFinished", "IsShowTips"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionLevelInfoOuterClass$LanternProjectionLevelInfoOrBuilder.class */
    public interface LanternProjectionLevelInfoOrBuilder extends MessageOrBuilder {
        boolean getIsCanStart();

        int getId();

        int getMinFinishTime();

        boolean getIsFinished();

        boolean getIsShowTips();
    }

    private LanternProjectionLevelInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionLevelInfoOuterClass$LanternProjectionLevelInfo.class */
    public static final class LanternProjectionLevelInfo extends GeneratedMessageV3 implements LanternProjectionLevelInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISCANSTART_FIELD_NUMBER = 4;
        private boolean isCanStart_;
        public static final int ID_FIELD_NUMBER = 7;
        private int id_;
        public static final int MINFINISHTIME_FIELD_NUMBER = 1;
        private int minFinishTime_;
        public static final int ISFINISHED_FIELD_NUMBER = 14;
        private boolean isFinished_;
        public static final int ISSHOWTIPS_FIELD_NUMBER = 2;
        private boolean isShowTips_;
        private byte memoizedIsInitialized;
        private static final LanternProjectionLevelInfo DEFAULT_INSTANCE = new LanternProjectionLevelInfo();
        private static final Parser<LanternProjectionLevelInfo> PARSER = new AbstractParser<LanternProjectionLevelInfo>() { // from class: emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.1
            @Override // com.google.protobuf.Parser
            public LanternProjectionLevelInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LanternProjectionLevelInfo(input, extensionRegistry);
            }
        };

        private LanternProjectionLevelInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LanternProjectionLevelInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LanternProjectionLevelInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LanternProjectionLevelInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.minFinishTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.isShowTips_ = input.readBool();
                                break;
                            case 32:
                                this.isCanStart_ = input.readBool();
                                break;
                            case 56:
                                this.id_ = input.readUInt32();
                                break;
                            case 112:
                                this.isFinished_ = input.readBool();
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
            return LanternProjectionLevelInfoOuterClass.internal_static_LanternProjectionLevelInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LanternProjectionLevelInfoOuterClass.internal_static_LanternProjectionLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternProjectionLevelInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
        public boolean getIsCanStart() {
            return this.isCanStart_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
        public int getMinFinishTime() {
            return this.minFinishTime_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
        public boolean getIsShowTips() {
            return this.isShowTips_;
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
            if (this.minFinishTime_ != 0) {
                output.writeUInt32(1, this.minFinishTime_);
            }
            if (this.isShowTips_) {
                output.writeBool(2, this.isShowTips_);
            }
            if (this.isCanStart_) {
                output.writeBool(4, this.isCanStart_);
            }
            if (this.id_ != 0) {
                output.writeUInt32(7, this.id_);
            }
            if (this.isFinished_) {
                output.writeBool(14, this.isFinished_);
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
            if (this.minFinishTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.minFinishTime_);
            }
            if (this.isShowTips_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.isShowTips_);
            }
            if (this.isCanStart_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isCanStart_);
            }
            if (this.id_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.id_);
            }
            if (this.isFinished_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isFinished_);
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
            if (!(obj instanceof LanternProjectionLevelInfo)) {
                return equals(obj);
            }
            LanternProjectionLevelInfo other = (LanternProjectionLevelInfo) obj;
            return getIsCanStart() == other.getIsCanStart() && getId() == other.getId() && getMinFinishTime() == other.getMinFinishTime() && getIsFinished() == other.getIsFinished() && getIsShowTips() == other.getIsShowTips() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + Internal.hashBoolean(getIsCanStart()))) + 7)) + getId())) + 1)) + getMinFinishTime())) + 14)) + Internal.hashBoolean(getIsFinished()))) + 2)) + Internal.hashBoolean(getIsShowTips()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static LanternProjectionLevelInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternProjectionLevelInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternProjectionLevelInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternProjectionLevelInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternProjectionLevelInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternProjectionLevelInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternProjectionLevelInfo parseFrom(InputStream input) throws IOException {
            return (LanternProjectionLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternProjectionLevelInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternProjectionLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternProjectionLevelInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LanternProjectionLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LanternProjectionLevelInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternProjectionLevelInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternProjectionLevelInfo parseFrom(CodedInputStream input) throws IOException {
            return (LanternProjectionLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternProjectionLevelInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternProjectionLevelInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LanternProjectionLevelInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionLevelInfoOuterClass$LanternProjectionLevelInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LanternProjectionLevelInfoOrBuilder {
            private boolean isCanStart_;
            private int id_;
            private int minFinishTime_;
            private boolean isFinished_;
            private boolean isShowTips_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LanternProjectionLevelInfoOuterClass.internal_static_LanternProjectionLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LanternProjectionLevelInfoOuterClass.internal_static_LanternProjectionLevelInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternProjectionLevelInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LanternProjectionLevelInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isCanStart_ = false;
                this.id_ = 0;
                this.minFinishTime_ = 0;
                this.isFinished_ = false;
                this.isShowTips_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LanternProjectionLevelInfoOuterClass.internal_static_LanternProjectionLevelInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LanternProjectionLevelInfo getDefaultInstanceForType() {
                return LanternProjectionLevelInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternProjectionLevelInfo build() {
                LanternProjectionLevelInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternProjectionLevelInfo buildPartial() {
                LanternProjectionLevelInfo result = new LanternProjectionLevelInfo(this);
                result.isCanStart_ = this.isCanStart_;
                result.id_ = this.id_;
                result.minFinishTime_ = this.minFinishTime_;
                result.isFinished_ = this.isFinished_;
                result.isShowTips_ = this.isShowTips_;
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
                if (other instanceof LanternProjectionLevelInfo) {
                    return mergeFrom((LanternProjectionLevelInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LanternProjectionLevelInfo other) {
                if (other == LanternProjectionLevelInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsCanStart()) {
                    setIsCanStart(other.getIsCanStart());
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getMinFinishTime() != 0) {
                    setMinFinishTime(other.getMinFinishTime());
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                if (other.getIsShowTips()) {
                    setIsShowTips(other.getIsShowTips());
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
                LanternProjectionLevelInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LanternProjectionLevelInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LanternProjectionLevelInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
            public boolean getIsCanStart() {
                return this.isCanStart_;
            }

            public Builder setIsCanStart(boolean value) {
                this.isCanStart_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCanStart() {
                this.isCanStart_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder
            public boolean getIsShowTips() {
                return this.isShowTips_;
            }

            public Builder setIsShowTips(boolean value) {
                this.isShowTips_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsShowTips() {
                this.isShowTips_ = false;
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

        public static LanternProjectionLevelInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LanternProjectionLevelInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LanternProjectionLevelInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanternProjectionLevelInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
