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
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockedPersonallineDataOuterClass.class */
public final class LockedPersonallineDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cLockedPersonallineData.proto\"×\u0001\n\u0016LockedPersonallineData\u00127\n\u000block_reason\u0018\r \u0001(\u000e2\".LockedPersonallineData.LockReason\u0012\u0018\n\u0010personal_line_id\u0018\u0003 \u0001(\r\u0012\u0014\n\nchapter_id\u0018\u0004 \u0001(\rH��\u0012\u000f\n\u0005level\u0018\u000f \u0001(\rH��\":\n\nLockReason\u0012\u0015\n\u0011LOCK_REASON_LEVEL\u0010��\u0012\u0015\n\u0011LOCK_REASON_QUEST\u0010\u0001B\u0007\n\u0005paramB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_LockedPersonallineData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LockedPersonallineData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LockedPersonallineData_descriptor, new String[]{"LockReason", "PersonalLineId", "ChapterId", "Level", "Param"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockedPersonallineDataOuterClass$LockedPersonallineDataOrBuilder.class */
    public interface LockedPersonallineDataOrBuilder extends MessageOrBuilder {
        int getLockReasonValue();

        LockedPersonallineData.LockReason getLockReason();

        int getPersonalLineId();

        boolean hasChapterId();

        int getChapterId();

        boolean hasLevel();

        int getLevel();

        LockedPersonallineData.ParamCase getParamCase();
    }

    private LockedPersonallineDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockedPersonallineDataOuterClass$LockedPersonallineData.class */
    public static final class LockedPersonallineData extends GeneratedMessageV3 implements LockedPersonallineDataOrBuilder {
        private static final long serialVersionUID = 0;
        private int paramCase_;
        private Object param_;
        public static final int LOCK_REASON_FIELD_NUMBER = 13;
        private int lockReason_;
        public static final int PERSONAL_LINE_ID_FIELD_NUMBER = 3;
        private int personalLineId_;
        public static final int CHAPTER_ID_FIELD_NUMBER = 4;
        public static final int LEVEL_FIELD_NUMBER = 15;
        private byte memoizedIsInitialized;
        private static final LockedPersonallineData DEFAULT_INSTANCE = new LockedPersonallineData();
        private static final Parser<LockedPersonallineData> PARSER = new AbstractParser<LockedPersonallineData>() { // from class: emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineData.1
            @Override // com.google.protobuf.Parser
            public LockedPersonallineData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LockedPersonallineData(input, extensionRegistry);
            }
        };

        private LockedPersonallineData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.paramCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private LockedPersonallineData() {
            this.paramCase_ = 0;
            this.memoizedIsInitialized = -1;
            this.lockReason_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LockedPersonallineData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LockedPersonallineData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.personalLineId_ = input.readUInt32();
                                break;
                            case 32:
                                this.paramCase_ = 4;
                                this.param_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 104:
                                this.lockReason_ = input.readEnum();
                                break;
                            case 120:
                                this.paramCase_ = 15;
                                this.param_ = Integer.valueOf(input.readUInt32());
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
            return LockedPersonallineDataOuterClass.internal_static_LockedPersonallineData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LockedPersonallineDataOuterClass.internal_static_LockedPersonallineData_fieldAccessorTable.ensureFieldAccessorsInitialized(LockedPersonallineData.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockedPersonallineDataOuterClass$LockedPersonallineData$LockReason.class */
        public enum LockReason implements ProtocolMessageEnum {
            LOCK_REASON_LEVEL(0),
            LOCK_REASON_QUEST(1),
            UNRECOGNIZED(-1);
            
            public static final int LOCK_REASON_LEVEL_VALUE = 0;
            public static final int LOCK_REASON_QUEST_VALUE = 1;
            private static final Internal.EnumLiteMap<LockReason> internalValueMap = new Internal.EnumLiteMap<LockReason>() { // from class: emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineData.LockReason.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public LockReason findValueByNumber(int number) {
                    return LockReason.forNumber(number);
                }
            };
            private static final LockReason[] VALUES = values();
            private final int value;

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static LockReason valueOf(int value) {
                return forNumber(value);
            }

            public static LockReason forNumber(int value) {
                switch (value) {
                    case 0:
                        return LOCK_REASON_LEVEL;
                    case 1:
                        return LOCK_REASON_QUEST;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<LockReason> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                if (this != UNRECOGNIZED) {
                    return getDescriptor().getValues().get(ordinal());
                }
                throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return LockedPersonallineData.getDescriptor().getEnumTypes().get(0);
            }

            public static LockReason valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                } else if (desc.getIndex() == -1) {
                    return UNRECOGNIZED;
                } else {
                    return VALUES[desc.getIndex()];
                }
            }

            LockReason(int value) {
                this.value = value;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockedPersonallineDataOuterClass$LockedPersonallineData$ParamCase.class */
        public enum ParamCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            CHAPTER_ID(4),
            LEVEL(15),
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
                    case 4:
                        return CHAPTER_ID;
                    case 15:
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

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public ParamCase getParamCase() {
            return ParamCase.forNumber(this.paramCase_);
        }

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public int getLockReasonValue() {
            return this.lockReason_;
        }

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public LockReason getLockReason() {
            LockReason result = LockReason.valueOf(this.lockReason_);
            return result == null ? LockReason.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public int getPersonalLineId() {
            return this.personalLineId_;
        }

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public boolean hasChapterId() {
            return this.paramCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public int getChapterId() {
            if (this.paramCase_ == 4) {
                return ((Integer) this.param_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public boolean hasLevel() {
            return this.paramCase_ == 15;
        }

        @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
        public int getLevel() {
            if (this.paramCase_ == 15) {
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
            if (this.personalLineId_ != 0) {
                output.writeUInt32(3, this.personalLineId_);
            }
            if (this.paramCase_ == 4) {
                output.writeUInt32(4, ((Integer) this.param_).intValue());
            }
            if (this.lockReason_ != LockReason.LOCK_REASON_LEVEL.getNumber()) {
                output.writeEnum(13, this.lockReason_);
            }
            if (this.paramCase_ == 15) {
                output.writeUInt32(15, ((Integer) this.param_).intValue());
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
            if (this.personalLineId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.personalLineId_);
            }
            if (this.paramCase_ == 4) {
                size2 += CodedOutputStream.computeUInt32Size(4, ((Integer) this.param_).intValue());
            }
            if (this.lockReason_ != LockReason.LOCK_REASON_LEVEL.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.lockReason_);
            }
            if (this.paramCase_ == 15) {
                size2 += CodedOutputStream.computeUInt32Size(15, ((Integer) this.param_).intValue());
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
            if (!(obj instanceof LockedPersonallineData)) {
                return equals(obj);
            }
            LockedPersonallineData other = (LockedPersonallineData) obj;
            if (this.lockReason_ != other.lockReason_ || getPersonalLineId() != other.getPersonalLineId() || !getParamCase().equals(other.getParamCase())) {
                return false;
            }
            switch (this.paramCase_) {
                case 4:
                    if (getChapterId() != other.getChapterId()) {
                        return false;
                    }
                    break;
                case 15:
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
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + this.lockReason_)) + 3)) + getPersonalLineId();
            switch (this.paramCase_) {
                case 4:
                    hash = (53 * ((37 * hash) + 4)) + getChapterId();
                    break;
                case 15:
                    hash = (53 * ((37 * hash) + 15)) + getLevel();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static LockedPersonallineData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LockedPersonallineData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LockedPersonallineData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LockedPersonallineData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LockedPersonallineData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LockedPersonallineData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LockedPersonallineData parseFrom(InputStream input) throws IOException {
            return (LockedPersonallineData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LockedPersonallineData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LockedPersonallineData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LockedPersonallineData parseDelimitedFrom(InputStream input) throws IOException {
            return (LockedPersonallineData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LockedPersonallineData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LockedPersonallineData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LockedPersonallineData parseFrom(CodedInputStream input) throws IOException {
            return (LockedPersonallineData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LockedPersonallineData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LockedPersonallineData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LockedPersonallineData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LockedPersonallineDataOuterClass$LockedPersonallineData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LockedPersonallineDataOrBuilder {
            private Object param_;
            private int personalLineId_;
            private int paramCase_ = 0;
            private int lockReason_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return LockedPersonallineDataOuterClass.internal_static_LockedPersonallineData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LockedPersonallineDataOuterClass.internal_static_LockedPersonallineData_fieldAccessorTable.ensureFieldAccessorsInitialized(LockedPersonallineData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LockedPersonallineData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.lockReason_ = 0;
                this.personalLineId_ = 0;
                this.paramCase_ = 0;
                this.param_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LockedPersonallineDataOuterClass.internal_static_LockedPersonallineData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LockedPersonallineData getDefaultInstanceForType() {
                return LockedPersonallineData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LockedPersonallineData build() {
                LockedPersonallineData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LockedPersonallineData buildPartial() {
                LockedPersonallineData result = new LockedPersonallineData(this);
                result.lockReason_ = this.lockReason_;
                result.personalLineId_ = this.personalLineId_;
                if (this.paramCase_ == 4) {
                    result.param_ = this.param_;
                }
                if (this.paramCase_ == 15) {
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
                if (other instanceof LockedPersonallineData) {
                    return mergeFrom((LockedPersonallineData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LockedPersonallineData other) {
                if (other == LockedPersonallineData.getDefaultInstance()) {
                    return this;
                }
                if (other.lockReason_ != 0) {
                    setLockReasonValue(other.getLockReasonValue());
                }
                if (other.getPersonalLineId() != 0) {
                    setPersonalLineId(other.getPersonalLineId());
                }
                switch (other.getParamCase()) {
                    case CHAPTER_ID:
                        setChapterId(other.getChapterId());
                        break;
                    case LEVEL:
                        setLevel(other.getLevel());
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
                LockedPersonallineData parsedMessage = null;
                try {
                    try {
                        parsedMessage = LockedPersonallineData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LockedPersonallineData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
            public ParamCase getParamCase() {
                return ParamCase.forNumber(this.paramCase_);
            }

            public Builder clearParam() {
                this.paramCase_ = 0;
                this.param_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
            public int getLockReasonValue() {
                return this.lockReason_;
            }

            public Builder setLockReasonValue(int value) {
                this.lockReason_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
            public LockReason getLockReason() {
                LockReason result = LockReason.valueOf(this.lockReason_);
                return result == null ? LockReason.UNRECOGNIZED : result;
            }

            public Builder setLockReason(LockReason value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.lockReason_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearLockReason() {
                this.lockReason_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
            public boolean hasChapterId() {
                return this.paramCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
            public int getChapterId() {
                if (this.paramCase_ == 4) {
                    return ((Integer) this.param_).intValue();
                }
                return 0;
            }

            public Builder setChapterId(int value) {
                this.paramCase_ = 4;
                this.param_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearChapterId() {
                if (this.paramCase_ == 4) {
                    this.paramCase_ = 0;
                    this.param_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
            public boolean hasLevel() {
                return this.paramCase_ == 15;
            }

            @Override // emu.grasscutter.net.proto.LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder
            public int getLevel() {
                if (this.paramCase_ == 15) {
                    return ((Integer) this.param_).intValue();
                }
                return 0;
            }

            public Builder setLevel(int value) {
                this.paramCase_ = 15;
                this.param_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                if (this.paramCase_ == 15) {
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

        public static LockedPersonallineData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LockedPersonallineData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LockedPersonallineData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LockedPersonallineData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
