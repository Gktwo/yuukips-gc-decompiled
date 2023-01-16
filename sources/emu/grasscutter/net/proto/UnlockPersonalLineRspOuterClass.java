package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockPersonalLineRspOuterClass.class */
public final class UnlockPersonalLineRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bUnlockPersonalLineRsp.proto\"r\n\u0015UnlockPersonalLineRsp\u0012\u0018\n\u0010personal_line_id\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005\u0012\u000f\n\u0005level\u0018\n \u0001(\rH��\u0012\u0014\n\nchapter_id\u0018\u0003 \u0001(\rH��B\u0007\n\u0005paramB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_UnlockPersonalLineRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UnlockPersonalLineRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UnlockPersonalLineRsp_descriptor, new String[]{"PersonalLineId", "Retcode", "Level", "ChapterId", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockPersonalLineRspOuterClass$UnlockPersonalLineRspOrBuilder.class */
    public interface UnlockPersonalLineRspOrBuilder extends MessageOrBuilder {
        int getPersonalLineId();

        int getRetcode();

        boolean hasLevel();

        int getLevel();

        boolean hasChapterId();

        int getChapterId();

        UnlockPersonalLineRsp.ParamCase getParamCase();
    }

    private UnlockPersonalLineRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockPersonalLineRspOuterClass$UnlockPersonalLineRsp.class */
    public static final class UnlockPersonalLineRsp extends GeneratedMessageV3 implements UnlockPersonalLineRspOrBuilder {
        private static final long serialVersionUID = 0;
        private int paramCase_;
        private Object param_;
        public static final int PERSONAL_LINE_ID_FIELD_NUMBER = 4;
        private int personalLineId_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        public static final int LEVEL_FIELD_NUMBER = 10;
        public static final int CHAPTER_ID_FIELD_NUMBER = 3;
        private byte memoizedIsInitialized;
        private static final UnlockPersonalLineRsp DEFAULT_INSTANCE = new UnlockPersonalLineRsp();
        private static final Parser<UnlockPersonalLineRsp> PARSER = new AbstractParser<UnlockPersonalLineRsp>() { // from class: emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRsp.1
            @Override // com.google.protobuf.Parser
            public UnlockPersonalLineRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UnlockPersonalLineRsp(input, extensionRegistry);
            }
        };

        private UnlockPersonalLineRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.paramCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private UnlockPersonalLineRsp() {
            this.paramCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UnlockPersonalLineRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UnlockPersonalLineRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.paramCase_ = 3;
                                this.param_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 32:
                                this.personalLineId_ = input.readUInt32();
                                break;
                            case 80:
                                this.paramCase_ = 10;
                                this.param_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 96:
                                this.retcode_ = input.readInt32();
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
            return UnlockPersonalLineRspOuterClass.internal_static_UnlockPersonalLineRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UnlockPersonalLineRspOuterClass.internal_static_UnlockPersonalLineRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(UnlockPersonalLineRsp.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockPersonalLineRspOuterClass$UnlockPersonalLineRsp$ParamCase.class */
        public enum ParamCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            LEVEL(10),
            CHAPTER_ID(3),
            PARAM_NOT_SET(0);
            
            private final int value;

            ParamCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ParamCase valueOf(int value) {
                return forNumber(value);
            }

            public static ParamCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return PARAM_NOT_SET;
                    case 3:
                        return CHAPTER_ID;
                    case 10:
                        return LEVEL;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
        public ParamCase getParamCase() {
            return ParamCase.forNumber(this.paramCase_);
        }

        @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
        public int getPersonalLineId() {
            return this.personalLineId_;
        }

        @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
        public boolean hasLevel() {
            return this.paramCase_ == 10;
        }

        @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
        public int getLevel() {
            if (this.paramCase_ == 10) {
                return ((Integer) this.param_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
        public boolean hasChapterId() {
            return this.paramCase_ == 3;
        }

        @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
        public int getChapterId() {
            if (this.paramCase_ == 3) {
                return ((Integer) this.param_).intValue();
            }
            return 0;
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
            if (this.paramCase_ == 3) {
                output.writeUInt32(3, ((Integer) this.param_).intValue());
            }
            if (this.personalLineId_ != 0) {
                output.writeUInt32(4, this.personalLineId_);
            }
            if (this.paramCase_ == 10) {
                output.writeUInt32(10, ((Integer) this.param_).intValue());
            }
            if (this.retcode_ != 0) {
                output.writeInt32(12, this.retcode_);
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
            if (this.paramCase_ == 3) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, ((Integer) this.param_).intValue());
            }
            if (this.personalLineId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.personalLineId_);
            }
            if (this.paramCase_ == 10) {
                size2 += CodedOutputStream.computeUInt32Size(10, ((Integer) this.param_).intValue());
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.retcode_);
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
            if (!(obj instanceof UnlockPersonalLineRsp)) {
                return equals(obj);
            }
            UnlockPersonalLineRsp other = (UnlockPersonalLineRsp) obj;
            if (getPersonalLineId() != other.getPersonalLineId() || getRetcode() != other.getRetcode() || !getParamCase().equals(other.getParamCase())) {
                return false;
            }
            switch (this.paramCase_) {
                case 3:
                    if (getChapterId() != other.getChapterId()) {
                        return false;
                    }
                    break;
                case 10:
                    if (getLevel() != other.getLevel()) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getPersonalLineId())) + 12)) + getRetcode();
            switch (this.paramCase_) {
                case 3:
                    hash = (53 * ((37 * hash) + 3)) + getChapterId();
                    break;
                case 10:
                    hash = (53 * ((37 * hash) + 10)) + getLevel();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UnlockPersonalLineRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockPersonalLineRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockPersonalLineRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockPersonalLineRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockPersonalLineRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnlockPersonalLineRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnlockPersonalLineRsp parseFrom(InputStream input) throws IOException {
            return (UnlockPersonalLineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockPersonalLineRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockPersonalLineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockPersonalLineRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (UnlockPersonalLineRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UnlockPersonalLineRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockPersonalLineRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnlockPersonalLineRsp parseFrom(CodedInputStream input) throws IOException {
            return (UnlockPersonalLineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnlockPersonalLineRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnlockPersonalLineRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnlockPersonalLineRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnlockPersonalLineRspOuterClass$UnlockPersonalLineRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UnlockPersonalLineRspOrBuilder {
            private int paramCase_ = 0;
            private Object param_;
            private int personalLineId_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UnlockPersonalLineRspOuterClass.internal_static_UnlockPersonalLineRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UnlockPersonalLineRspOuterClass.internal_static_UnlockPersonalLineRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(UnlockPersonalLineRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UnlockPersonalLineRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.personalLineId_ = 0;
                this.retcode_ = 0;
                this.paramCase_ = 0;
                this.param_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UnlockPersonalLineRspOuterClass.internal_static_UnlockPersonalLineRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UnlockPersonalLineRsp getDefaultInstanceForType() {
                return UnlockPersonalLineRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockPersonalLineRsp build() {
                UnlockPersonalLineRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnlockPersonalLineRsp buildPartial() {
                UnlockPersonalLineRsp result = new UnlockPersonalLineRsp(this);
                result.personalLineId_ = this.personalLineId_;
                result.retcode_ = this.retcode_;
                if (this.paramCase_ == 10) {
                    result.param_ = this.param_;
                }
                if (this.paramCase_ == 3) {
                    result.param_ = this.param_;
                }
                result.paramCase_ = this.paramCase_;
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
                if (other instanceof UnlockPersonalLineRsp) {
                    return mergeFrom((UnlockPersonalLineRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UnlockPersonalLineRsp other) {
                if (other == UnlockPersonalLineRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getPersonalLineId() != 0) {
                    setPersonalLineId(other.getPersonalLineId());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                switch (other.getParamCase()) {
                    case LEVEL:
                        setLevel(other.getLevel());
                        break;
                    case CHAPTER_ID:
                        setChapterId(other.getChapterId());
                        break;
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
                UnlockPersonalLineRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = UnlockPersonalLineRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UnlockPersonalLineRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
            public ParamCase getParamCase() {
                return ParamCase.forNumber(this.paramCase_);
            }

            public Builder clearParam() {
                this.paramCase_ = 0;
                this.param_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
            public int getPersonalLineId() {
                return this.personalLineId_;
            }

            public Builder setPersonalLineId(int value) {
                this.personalLineId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPersonalLineId() {
                this.personalLineId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
            public boolean hasLevel() {
                return this.paramCase_ == 10;
            }

            @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
            public int getLevel() {
                if (this.paramCase_ == 10) {
                    return ((Integer) this.param_).intValue();
                }
                return 0;
            }

            public Builder setLevel(int value) {
                this.paramCase_ = 10;
                this.param_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                if (this.paramCase_ == 10) {
                    this.paramCase_ = 0;
                    this.param_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
            public boolean hasChapterId() {
                return this.paramCase_ == 3;
            }

            @Override // emu.grasscutter.net.proto.UnlockPersonalLineRspOuterClass.UnlockPersonalLineRspOrBuilder
            public int getChapterId() {
                if (this.paramCase_ == 3) {
                    return ((Integer) this.param_).intValue();
                }
                return 0;
            }

            public Builder setChapterId(int value) {
                this.paramCase_ = 3;
                this.param_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearChapterId() {
                if (this.paramCase_ == 3) {
                    this.paramCase_ = 0;
                    this.param_ = null;
                    onChanged();
                }
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

        public static UnlockPersonalLineRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnlockPersonalLineRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UnlockPersonalLineRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnlockPersonalLineRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
