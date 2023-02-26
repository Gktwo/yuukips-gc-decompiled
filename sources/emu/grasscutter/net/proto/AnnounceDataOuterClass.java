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
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012AnnounceData.proto\"ö\u0001\n\fAnnounceData\u0012\u0010\n\bconfigId\u0018\t \u0001(\r\u0012\u001d\n\u0015centerSystemFrequency\u0018\u000e \u0001(\r\u0012\u000f\n\u0007endTime\u0018\u0005 \u0001(\r\u0012\u0011\n\tbeginTime\u0018\u0004 \u0001(\r\u0012\u0015\n\rcountDownText\u0018\u0007 \u0001(\t\u0012(\n isCenterSystemLast_5EveryMinutes\u0018\f \u0001(\b\u0012\u001a\n\u0012dungeonConfirmText\u0018\u0002 \u0001(\t\u0012\u001a\n\u0012countDownFrequency\u0018\b \u0001(\r\u0012\u0018\n\u0010centerSystemText\u0018\r \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AnnounceData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AnnounceData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AnnounceData_descriptor, new String[]{"ConfigId", "CenterSystemFrequency", "EndTime", "BeginTime", "CountDownText", "IsCenterSystemLast5EveryMinutes", "DungeonConfirmText", "CountDownFrequency", "CenterSystemText"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AnnounceDataOuterClass$AnnounceDataOrBuilder.class */
    public interface AnnounceDataOrBuilder extends MessageOrBuilder {
        int getConfigId();

        int getCenterSystemFrequency();

        int getEndTime();

        int getBeginTime();

        String getCountDownText();

        ByteString getCountDownTextBytes();

        boolean getIsCenterSystemLast5EveryMinutes();

        String getDungeonConfirmText();

        ByteString getDungeonConfirmTextBytes();

        int getCountDownFrequency();

        String getCenterSystemText();

        ByteString getCenterSystemTextBytes();
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
        public static final int CONFIGID_FIELD_NUMBER = 9;
        private int configId_;
        public static final int CENTERSYSTEMFREQUENCY_FIELD_NUMBER = 14;
        private int centerSystemFrequency_;
        public static final int ENDTIME_FIELD_NUMBER = 5;
        private int endTime_;
        public static final int BEGINTIME_FIELD_NUMBER = 4;
        private int beginTime_;
        public static final int COUNTDOWNTEXT_FIELD_NUMBER = 7;
        private volatile Object countDownText_;
        public static final int ISCENTERSYSTEMLAST_5EVERYMINUTES_FIELD_NUMBER = 12;
        private boolean isCenterSystemLast5EveryMinutes_;
        public static final int DUNGEONCONFIRMTEXT_FIELD_NUMBER = 2;
        private volatile Object dungeonConfirmText_;
        public static final int COUNTDOWNFREQUENCY_FIELD_NUMBER = 8;
        private int countDownFrequency_;
        public static final int CENTERSYSTEMTEXT_FIELD_NUMBER = 13;
        private volatile Object centerSystemText_;
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
            this.countDownText_ = "";
            this.dungeonConfirmText_ = "";
            this.centerSystemText_ = "";
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
                            case 18:
                                this.dungeonConfirmText_ = input.readStringRequireUtf8();
                                break;
                            case 32:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 40:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 58:
                                this.countDownText_ = input.readStringRequireUtf8();
                                break;
                            case 64:
                                this.countDownFrequency_ = input.readUInt32();
                                break;
                            case 72:
                                this.configId_ = input.readUInt32();
                                break;
                            case 96:
                                this.isCenterSystemLast5EveryMinutes_ = input.readBool();
                                break;
                            case 106:
                                this.centerSystemText_ = input.readStringRequireUtf8();
                                break;
                            case 112:
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
        public int getConfigId() {
            return this.configId_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getCenterSystemFrequency() {
            return this.centerSystemFrequency_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
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

        @Override // emu.grasscutter.net.proto.AnnounceDataOuterClass.AnnounceDataOrBuilder
        public boolean getIsCenterSystemLast5EveryMinutes() {
            return this.isCenterSystemLast5EveryMinutes_;
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
        public int getCountDownFrequency() {
            return this.countDownFrequency_;
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
            if (!GeneratedMessageV3.isStringEmpty(this.dungeonConfirmText_)) {
                GeneratedMessageV3.writeString(output, 2, this.dungeonConfirmText_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(4, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(5, this.endTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countDownText_)) {
                GeneratedMessageV3.writeString(output, 7, this.countDownText_);
            }
            if (this.countDownFrequency_ != 0) {
                output.writeUInt32(8, this.countDownFrequency_);
            }
            if (this.configId_ != 0) {
                output.writeUInt32(9, this.configId_);
            }
            if (this.isCenterSystemLast5EveryMinutes_) {
                output.writeBool(12, this.isCenterSystemLast5EveryMinutes_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.centerSystemText_)) {
                GeneratedMessageV3.writeString(output, 13, this.centerSystemText_);
            }
            if (this.centerSystemFrequency_ != 0) {
                output.writeUInt32(14, this.centerSystemFrequency_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.dungeonConfirmText_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(2, this.dungeonConfirmText_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.beginTime_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.endTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.countDownText_)) {
                size2 += GeneratedMessageV3.computeStringSize(7, this.countDownText_);
            }
            if (this.countDownFrequency_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.countDownFrequency_);
            }
            if (this.configId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.configId_);
            }
            if (this.isCenterSystemLast5EveryMinutes_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isCenterSystemLast5EveryMinutes_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.centerSystemText_)) {
                size2 += GeneratedMessageV3.computeStringSize(13, this.centerSystemText_);
            }
            if (this.centerSystemFrequency_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.centerSystemFrequency_);
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
            return getConfigId() == other.getConfigId() && getCenterSystemFrequency() == other.getCenterSystemFrequency() && getEndTime() == other.getEndTime() && getBeginTime() == other.getBeginTime() && getCountDownText().equals(other.getCountDownText()) && getIsCenterSystemLast5EveryMinutes() == other.getIsCenterSystemLast5EveryMinutes() && getDungeonConfirmText().equals(other.getDungeonConfirmText()) && getCountDownFrequency() == other.getCountDownFrequency() && getCenterSystemText().equals(other.getCenterSystemText()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getConfigId())) + 14)) + getCenterSystemFrequency())) + 5)) + getEndTime())) + 4)) + getBeginTime())) + 7)) + getCountDownText().hashCode())) + 12)) + Internal.hashBoolean(getIsCenterSystemLast5EveryMinutes()))) + 2)) + getDungeonConfirmText().hashCode())) + 8)) + getCountDownFrequency())) + 13)) + getCenterSystemText().hashCode())) + this.unknownFields.hashCode();
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
            private int configId_;
            private int centerSystemFrequency_;
            private int endTime_;
            private int beginTime_;
            private boolean isCenterSystemLast5EveryMinutes_;
            private int countDownFrequency_;
            private Object countDownText_ = "";
            private Object dungeonConfirmText_ = "";
            private Object centerSystemText_ = "";

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
                this.configId_ = 0;
                this.centerSystemFrequency_ = 0;
                this.endTime_ = 0;
                this.beginTime_ = 0;
                this.countDownText_ = "";
                this.isCenterSystemLast5EveryMinutes_ = false;
                this.dungeonConfirmText_ = "";
                this.countDownFrequency_ = 0;
                this.centerSystemText_ = "";
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
                result.configId_ = this.configId_;
                result.centerSystemFrequency_ = this.centerSystemFrequency_;
                result.endTime_ = this.endTime_;
                result.beginTime_ = this.beginTime_;
                result.countDownText_ = this.countDownText_;
                result.isCenterSystemLast5EveryMinutes_ = this.isCenterSystemLast5EveryMinutes_;
                result.dungeonConfirmText_ = this.dungeonConfirmText_;
                result.countDownFrequency_ = this.countDownFrequency_;
                result.centerSystemText_ = this.centerSystemText_;
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
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
                }
                if (other.getCenterSystemFrequency() != 0) {
                    setCenterSystemFrequency(other.getCenterSystemFrequency());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (!other.getCountDownText().isEmpty()) {
                    this.countDownText_ = other.countDownText_;
                    onChanged();
                }
                if (other.getIsCenterSystemLast5EveryMinutes()) {
                    setIsCenterSystemLast5EveryMinutes(other.getIsCenterSystemLast5EveryMinutes());
                }
                if (!other.getDungeonConfirmText().isEmpty()) {
                    this.dungeonConfirmText_ = other.dungeonConfirmText_;
                    onChanged();
                }
                if (other.getCountDownFrequency() != 0) {
                    setCountDownFrequency(other.getCountDownFrequency());
                }
                if (!other.getCenterSystemText().isEmpty()) {
                    this.centerSystemText_ = other.centerSystemText_;
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
