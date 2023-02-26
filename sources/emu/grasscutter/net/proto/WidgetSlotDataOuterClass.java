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
import emu.grasscutter.net.proto.WidgetSlotTagOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotDataOuterClass.class */
public final class WidgetSlotDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014WidgetSlotData.proto\u001a\u0013WidgetSlotTag.proto\"g\n\u000eWidgetSlotData\u0012\u0012\n\nmaterialId\u0018\u000b \u0001(\r\u0012\u0012\n\ncdOverTime\u0018\u0002 \u0001(\r\u0012\u0010\n\bisActive\u0018\f \u0001(\b\u0012\u001b\n\u0003tag\u0018\b \u0001(\u000e2\u000e.WidgetSlotTagB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetSlotTagOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WidgetSlotData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WidgetSlotData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WidgetSlotData_descriptor, new String[]{"MaterialId", "CdOverTime", "IsActive", "Tag"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotDataOuterClass$WidgetSlotDataOrBuilder.class */
    public interface WidgetSlotDataOrBuilder extends MessageOrBuilder {
        int getMaterialId();

        int getCdOverTime();

        boolean getIsActive();

        int getTagValue();

        WidgetSlotTagOuterClass.WidgetSlotTag getTag();
    }

    private WidgetSlotDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotDataOuterClass$WidgetSlotData.class */
    public static final class WidgetSlotData extends GeneratedMessageV3 implements WidgetSlotDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MATERIALID_FIELD_NUMBER = 11;
        private int materialId_;
        public static final int CDOVERTIME_FIELD_NUMBER = 2;
        private int cdOverTime_;
        public static final int ISACTIVE_FIELD_NUMBER = 12;
        private boolean isActive_;
        public static final int TAG_FIELD_NUMBER = 8;
        private int tag_;
        private byte memoizedIsInitialized;
        private static final WidgetSlotData DEFAULT_INSTANCE = new WidgetSlotData();
        private static final Parser<WidgetSlotData> PARSER = new AbstractParser<WidgetSlotData>() { // from class: emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotData.1
            @Override // com.google.protobuf.Parser
            public WidgetSlotData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WidgetSlotData(input, extensionRegistry);
            }
        };

        private WidgetSlotData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WidgetSlotData() {
            this.memoizedIsInitialized = -1;
            this.tag_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WidgetSlotData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WidgetSlotData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.cdOverTime_ = input.readUInt32();
                                break;
                            case 64:
                                this.tag_ = input.readEnum();
                                break;
                            case 88:
                                this.materialId_ = input.readUInt32();
                                break;
                            case 96:
                                this.isActive_ = input.readBool();
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
            return WidgetSlotDataOuterClass.internal_static_WidgetSlotData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WidgetSlotDataOuterClass.internal_static_WidgetSlotData_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetSlotData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
        public int getMaterialId() {
            return this.materialId_;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
        public int getCdOverTime() {
            return this.cdOverTime_;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
        public boolean getIsActive() {
            return this.isActive_;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
        public int getTagValue() {
            return this.tag_;
        }

        @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
        public WidgetSlotTagOuterClass.WidgetSlotTag getTag() {
            WidgetSlotTagOuterClass.WidgetSlotTag result = WidgetSlotTagOuterClass.WidgetSlotTag.valueOf(this.tag_);
            return result == null ? WidgetSlotTagOuterClass.WidgetSlotTag.UNRECOGNIZED : result;
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
            if (this.cdOverTime_ != 0) {
                output.writeUInt32(2, this.cdOverTime_);
            }
            if (this.tag_ != WidgetSlotTagOuterClass.WidgetSlotTag.WIDGET_SLOT_TAG_QUICK_USE.getNumber()) {
                output.writeEnum(8, this.tag_);
            }
            if (this.materialId_ != 0) {
                output.writeUInt32(11, this.materialId_);
            }
            if (this.isActive_) {
                output.writeBool(12, this.isActive_);
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
            if (this.cdOverTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.cdOverTime_);
            }
            if (this.tag_ != WidgetSlotTagOuterClass.WidgetSlotTag.WIDGET_SLOT_TAG_QUICK_USE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(8, this.tag_);
            }
            if (this.materialId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.materialId_);
            }
            if (this.isActive_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.isActive_);
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
            if (!(obj instanceof WidgetSlotData)) {
                return equals(obj);
            }
            WidgetSlotData other = (WidgetSlotData) obj;
            return getMaterialId() == other.getMaterialId() && getCdOverTime() == other.getCdOverTime() && getIsActive() == other.getIsActive() && this.tag_ == other.tag_ && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getMaterialId())) + 2)) + getCdOverTime())) + 12)) + Internal.hashBoolean(getIsActive()))) + 8)) + this.tag_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static WidgetSlotData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetSlotData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetSlotData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetSlotData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetSlotData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WidgetSlotData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WidgetSlotData parseFrom(InputStream input) throws IOException {
            return (WidgetSlotData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetSlotData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetSlotData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetSlotData parseDelimitedFrom(InputStream input) throws IOException {
            return (WidgetSlotData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WidgetSlotData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetSlotData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WidgetSlotData parseFrom(CodedInputStream input) throws IOException {
            return (WidgetSlotData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WidgetSlotData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WidgetSlotData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WidgetSlotData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WidgetSlotDataOuterClass$WidgetSlotData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WidgetSlotDataOrBuilder {
            private int materialId_;
            private int cdOverTime_;
            private boolean isActive_;
            private int tag_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return WidgetSlotDataOuterClass.internal_static_WidgetSlotData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WidgetSlotDataOuterClass.internal_static_WidgetSlotData_fieldAccessorTable.ensureFieldAccessorsInitialized(WidgetSlotData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WidgetSlotData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.materialId_ = 0;
                this.cdOverTime_ = 0;
                this.isActive_ = false;
                this.tag_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WidgetSlotDataOuterClass.internal_static_WidgetSlotData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WidgetSlotData getDefaultInstanceForType() {
                return WidgetSlotData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetSlotData build() {
                WidgetSlotData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WidgetSlotData buildPartial() {
                WidgetSlotData result = new WidgetSlotData(this);
                result.materialId_ = this.materialId_;
                result.cdOverTime_ = this.cdOverTime_;
                result.isActive_ = this.isActive_;
                result.tag_ = this.tag_;
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
                if (other instanceof WidgetSlotData) {
                    return mergeFrom((WidgetSlotData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WidgetSlotData other) {
                if (other == WidgetSlotData.getDefaultInstance()) {
                    return this;
                }
                if (other.getMaterialId() != 0) {
                    setMaterialId(other.getMaterialId());
                }
                if (other.getCdOverTime() != 0) {
                    setCdOverTime(other.getCdOverTime());
                }
                if (other.getIsActive()) {
                    setIsActive(other.getIsActive());
                }
                if (other.tag_ != 0) {
                    setTagValue(other.getTagValue());
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
                WidgetSlotData parsedMessage = null;
                try {
                    try {
                        parsedMessage = WidgetSlotData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WidgetSlotData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
            public int getMaterialId() {
                return this.materialId_;
            }

            public Builder setMaterialId(int value) {
                this.materialId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaterialId() {
                this.materialId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
            public int getCdOverTime() {
                return this.cdOverTime_;
            }

            public Builder setCdOverTime(int value) {
                this.cdOverTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearCdOverTime() {
                this.cdOverTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
            public boolean getIsActive() {
                return this.isActive_;
            }

            public Builder setIsActive(boolean value) {
                this.isActive_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsActive() {
                this.isActive_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
            public int getTagValue() {
                return this.tag_;
            }

            public Builder setTagValue(int value) {
                this.tag_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder
            public WidgetSlotTagOuterClass.WidgetSlotTag getTag() {
                WidgetSlotTagOuterClass.WidgetSlotTag result = WidgetSlotTagOuterClass.WidgetSlotTag.valueOf(this.tag_);
                return result == null ? WidgetSlotTagOuterClass.WidgetSlotTag.UNRECOGNIZED : result;
            }

            public Builder setTag(WidgetSlotTagOuterClass.WidgetSlotTag value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.tag_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearTag() {
                this.tag_ = 0;
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

        public static WidgetSlotData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WidgetSlotData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WidgetSlotData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WidgetSlotData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetSlotTagOuterClass.getDescriptor();
    }
}
