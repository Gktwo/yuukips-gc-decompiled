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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnnounceDataOuterClass.class */
public final class AnnounceDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012AnnounceData.proto\"\u0002\n\fAnnounceData\u0012\u0012\n\nbegin_time\u0018\n \u0001(\r\u0012-\n%is_center_system_last_5_every_minutes\u0018\u0003 \u0001(\b\u0012\u0010\n\bend_time\u0018\u0001 \u0001(\r\u0012\u0011\n\tconfig_id\u0018\u0002 \u0001(\r\u0012\u001a\n\u0012center_system_text\u0018\u000b \u0001(\t\u0012\u001c\n\u0014count_down_frequency\u0018\u0005 \u0001(\r\u0012\u001f\n\u0017center_system_frequency\u0018\r \u0001(\r\u0012\u001c\n\u0014dungeon_confirm_text\u0018\u0004 \u0001(\t\u0012\u0017\n\u000fcount_down_text\u0018\u0006 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AnnounceData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AnnounceData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AnnounceData_descriptor, new String[]{"BeginTime", "IsCenterSystemLast5EveryMinutes", "EndTime", "ConfigId", "CenterSystemText", "CountDownFrequency", "CenterSystemFrequency", "DungeonConfirmText", "CountDownText"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnnounceDataOuterClass$AnnounceDataOrBuilder.class */
    public interface AnnounceDataOrBuilder extends MessageOrBuilder {
        int getBeginTime();

        boolean getIsCenterSystemLast5EveryMinutes();

        int getEndTime();

        int getConfigId();

        String getCenterSystemText();

        ByteString getCenterSystemTextBytes();

        int getCountDownFrequency();

        int getCenterSystemFrequency();

        String getDungeonConfirmText();

        ByteString getDungeonConfirmTextBytes();

        String getCountDownText();

        ByteString getCountDownTextBytes();
    }

    private AnnounceDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnnounceDataOuterClass$AnnounceData.class */
    public static final class AnnounceData extends GeneratedMessageV3 implements AnnounceDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BEGIN_TIME_FIELD_NUMBER = 10;
        private int beginTime_;
        public static final int IS_CENTER_SYSTEM_LAST_5_EVERY_MINUTES_FIELD_NUMBER = 3;
        private boolean isCenterSystemLast5EveryMinutes_;
        public static final int END_TIME_FIELD_NUMBER = 1;
        private int endTime_;
        public static final int CONFIG_ID_FIELD_NUMBER = 2;
        private int configId_;
        public static final int CENTER_SYSTEM_TEXT_FIELD_NUMBER = 11;
        private volatile Object centerSystemText_;
        public static final int COUNT_DOWN_FREQUENCY_FIELD_NUMBER = 5;
        private int countDownFrequency_;
        public static final int CENTER_SYSTEM_FREQUENCY_FIELD_NUMBER = 13;
        private int centerSystemFrequency_;
        public static final int DUNGEON_CONFIRM_TEXT_FIELD_NUMBER = 4;
        private volatile Object dungeonConfirmText_;
        public static final int COUNT_DOWN_TEXT_FIELD_NUMBER = 6;
        private volatile Object countDownText_;
        private byte memoizedIsInitialized;
        private static final AnnounceData DEFAULT_INSTANCE = new AnnounceData();
        private static final Parser<AnnounceData> PARSER = new AbstractParser<AnnounceData>() { // from class: emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceData.1
            @Override // com.google.protobuf.Parser
            public AnnounceData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AnnounceData(input, extensionRegistry);
            }
        };

        private AnnounceData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AnnounceData() {
            this.memoizedIsInitialized = -1;
            this.centerSystemText_ = "";
            this.dungeonConfirmText_ = "";
            this.countDownText_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AnnounceData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AnnounceData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.endTime_ = input.readUInt32();
                                break;
                            case 16:
                                this.configId_ = input.readUInt32();
                                break;
                            case 24:
                                this.isCenterSystemLast5EveryMinutes_ = input.readBool();
                                break;
                            case 34:
                                this.dungeonConfirmText_ = input.readStringRequireUtf8();
                                break;
                            case 40:
                                this.countDownFrequency_ = input.readUInt32();
                                break;
                            case 50:
                                this.countDownText_ = input.readStringRequireUtf8();
                                break;
                            case 80:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 90:
                                this.centerSystemText_ = input.readStringRequireUtf8();
                                break;
                            case 104:
                                this.centerSystemFrequency_ = input.readUInt32();
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
            return AnnounceDataOuterClass.internal_static_AnnounceData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AnnounceDataOuterClass.internal_static_AnnounceData_fieldAccessorTable.ensureFieldAccessorsInitialized(AnnounceData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public boolean getIsCenterSystemLast5EveryMinutes() {
            return this.isCenterSystemLast5EveryMinutes_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public String getCenterSystemText() {
            Object ref = this.centerSystemText_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.centerSystemText_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public ByteString getCenterSystemTextBytes() {
            Object ref = this.centerSystemText_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.centerSystemText_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getCountDownFrequency() {
            return this.countDownFrequency_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getCenterSystemFrequency() {
            return this.centerSystemFrequency_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public String getDungeonConfirmText() {
            Object ref = this.dungeonConfirmText_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.dungeonConfirmText_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public ByteString getDungeonConfirmTextBytes() {
            Object ref = this.dungeonConfirmText_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.dungeonConfirmText_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public String getCountDownText() {
            Object ref = this.countDownText_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.countDownText_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public ByteString getCountDownTextBytes() {
            Object ref = this.countDownText_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.countDownText_ = b;
            return b;
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
            if (this.endTime_ != 0) {
                output.writeUInt32(1, this.endTime_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(2, this.configId_);
            }
            if (this.isCenterSystemLast5EveryMinutes_) {
                output.writeBool(3, this.isCenterSystemLast5EveryMinutes_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dungeonConfirmText_)) {
                GeneratedMessageV3.writeString(output, 4, this.dungeonConfirmText_);
            }
            if (this.countDownFrequency_ != 0) {
                output.writeUInt32(5, this.countDownFrequency_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countDownText_)) {
                GeneratedMessageV3.writeString(output, 6, this.countDownText_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(10, this.beginTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.centerSystemText_)) {
                GeneratedMessageV3.writeString(output, 11, this.centerSystemText_);
            }
            if (this.centerSystemFrequency_ != 0) {
                output.writeUInt32(13, this.centerSystemFrequency_);
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
            if (this.endTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.endTime_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.configId_);
            }
            if (this.isCenterSystemLast5EveryMinutes_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isCenterSystemLast5EveryMinutes_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.dungeonConfirmText_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.dungeonConfirmText_);
            }
            if (this.countDownFrequency_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.countDownFrequency_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countDownText_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.countDownText_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.beginTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.centerSystemText_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.centerSystemText_);
            }
            if (this.centerSystemFrequency_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.centerSystemFrequency_);
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
            if (!(obj instanceof AnnounceData)) {
                return equals(obj);
            }
            AnnounceData other = (AnnounceData) obj;
            return getBeginTime() == other.getBeginTime() && getIsCenterSystemLast5EveryMinutes() == other.getIsCenterSystemLast5EveryMinutes() && getEndTime() == other.getEndTime() && getConfigId() == other.getConfigId() && getCenterSystemText().equals(other.getCenterSystemText()) && getCountDownFrequency() == other.getCountDownFrequency() && getCenterSystemFrequency() == other.getCenterSystemFrequency() && getDungeonConfirmText().equals(other.getDungeonConfirmText()) && getCountDownText().equals(other.getCountDownText()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getBeginTime())) + 3)) + Internal.hashBoolean(getIsCenterSystemLast5EveryMinutes()))) + 1)) + getEndTime())) + 2)) + getConfigId())) + 11)) + getCenterSystemText().hashCode())) + 5)) + getCountDownFrequency())) + 13)) + getCenterSystemFrequency())) + 4)) + getDungeonConfirmText().hashCode())) + 6)) + getCountDownText().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AnnounceData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnnounceData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnnounceData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnnounceData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnnounceData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AnnounceData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AnnounceData parseFrom(InputStream input) throws IOException {
            return (AnnounceData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AnnounceData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnnounceData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AnnounceData parseDelimitedFrom(InputStream input) throws IOException {
            return (AnnounceData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AnnounceData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnnounceData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AnnounceData parseFrom(CodedInputStream input) throws IOException {
            return (AnnounceData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AnnounceData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AnnounceData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AnnounceData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnnounceDataOuterClass$AnnounceData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AnnounceDataOrBuilder {
            private int beginTime_;
            private boolean isCenterSystemLast5EveryMinutes_;
            private int endTime_;
            private int configId_;
            private int countDownFrequency_;
            private int centerSystemFrequency_;
            private Object centerSystemText_ = "";
            private Object dungeonConfirmText_ = "";
            private Object countDownText_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return AnnounceDataOuterClass.internal_static_AnnounceData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AnnounceDataOuterClass.internal_static_AnnounceData_fieldAccessorTable.ensureFieldAccessorsInitialized(AnnounceData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AnnounceData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.beginTime_ = 0;
                this.isCenterSystemLast5EveryMinutes_ = false;
                this.endTime_ = 0;
                this.configId_ = 0;
                this.centerSystemText_ = "";
                this.countDownFrequency_ = 0;
                this.centerSystemFrequency_ = 0;
                this.dungeonConfirmText_ = "";
                this.countDownText_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AnnounceDataOuterClass.internal_static_AnnounceData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AnnounceData getDefaultInstanceForType() {
                return AnnounceData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AnnounceData build() {
                AnnounceData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AnnounceData buildPartial() {
                AnnounceData result = new AnnounceData(this);
                result.beginTime_ = this.beginTime_;
                result.isCenterSystemLast5EveryMinutes_ = this.isCenterSystemLast5EveryMinutes_;
                result.endTime_ = this.endTime_;
                result.configId_ = this.configId_;
                result.centerSystemText_ = this.centerSystemText_;
                result.countDownFrequency_ = this.countDownFrequency_;
                result.centerSystemFrequency_ = this.centerSystemFrequency_;
                result.dungeonConfirmText_ = this.dungeonConfirmText_;
                result.countDownText_ = this.countDownText_;
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
                if (other instanceof AnnounceData) {
                    return mergeFrom((AnnounceData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AnnounceData other) {
                if (other == AnnounceData.getDefaultInstance()) {
                    return this;
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getIsCenterSystemLast5EveryMinutes()) {
                    setIsCenterSystemLast5EveryMinutes(other.getIsCenterSystemLast5EveryMinutes());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (!other.getCenterSystemText().isEmpty()) {
                    this.centerSystemText_ = other.centerSystemText_;
                    onChanged();
                }
                if (other.getCountDownFrequency() != 0) {
                    setCountDownFrequency(other.getCountDownFrequency());
                }
                if (other.getCenterSystemFrequency() != 0) {
                    setCenterSystemFrequency(other.getCenterSystemFrequency());
                }
                if (!other.getDungeonConfirmText().isEmpty()) {
                    this.dungeonConfirmText_ = other.dungeonConfirmText_;
                    onChanged();
                }
                if (!other.getCountDownText().isEmpty()) {
                    this.countDownText_ = other.countDownText_;
                    onChanged();
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
                AnnounceData parsedMessage = null;
                try {
                    try {
                        parsedMessage = AnnounceData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AnnounceData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public boolean getIsCenterSystemLast5EveryMinutes() {
                return this.isCenterSystemLast5EveryMinutes_;
            }

            public Builder setIsCenterSystemLast5EveryMinutes(boolean value) {
                this.isCenterSystemLast5EveryMinutes_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCenterSystemLast5EveryMinutes() {
                this.isCenterSystemLast5EveryMinutes_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public String getCenterSystemText() {
                Object ref = this.centerSystemText_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.centerSystemText_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public ByteString getCenterSystemTextBytes() {
                Object ref = this.centerSystemText_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.centerSystemText_ = b;
                return b;
            }

            public Builder setCenterSystemText(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.centerSystemText_ = value;
                onChanged();
                return this;
            }

            public Builder clearCenterSystemText() {
                this.centerSystemText_ = AnnounceData.getDefaultInstance().getCenterSystemText();
                onChanged();
                return this;
            }

            public Builder setCenterSystemTextBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AnnounceData.checkByteStringIsUtf8(value);
                this.centerSystemText_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public int getCountDownFrequency() {
                return this.countDownFrequency_;
            }

            public Builder setCountDownFrequency(int value) {
                this.countDownFrequency_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountDownFrequency() {
                this.countDownFrequency_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public int getCenterSystemFrequency() {
                return this.centerSystemFrequency_;
            }

            public Builder setCenterSystemFrequency(int value) {
                this.centerSystemFrequency_ = value;
                onChanged();
                return this;
            }

            public Builder clearCenterSystemFrequency() {
                this.centerSystemFrequency_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public String getDungeonConfirmText() {
                Object ref = this.dungeonConfirmText_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.dungeonConfirmText_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public ByteString getDungeonConfirmTextBytes() {
                Object ref = this.dungeonConfirmText_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.dungeonConfirmText_ = b;
                return b;
            }

            public Builder setDungeonConfirmText(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.dungeonConfirmText_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonConfirmText() {
                this.dungeonConfirmText_ = AnnounceData.getDefaultInstance().getDungeonConfirmText();
                onChanged();
                return this;
            }

            public Builder setDungeonConfirmTextBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AnnounceData.checkByteStringIsUtf8(value);
                this.dungeonConfirmText_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public String getCountDownText() {
                Object ref = this.countDownText_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.countDownText_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
            public ByteString getCountDownTextBytes() {
                Object ref = this.countDownText_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.countDownText_ = b;
                return b;
            }

            public Builder setCountDownText(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.countDownText_ = value;
                onChanged();
                return this;
            }

            public Builder clearCountDownText() {
                this.countDownText_ = AnnounceData.getDefaultInstance().getCountDownText();
                onChanged();
                return this;
            }

            public Builder setCountDownTextBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AnnounceData.checkByteStringIsUtf8(value);
                this.countDownText_ = value;
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

        public static AnnounceData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AnnounceData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AnnounceData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AnnounceData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
