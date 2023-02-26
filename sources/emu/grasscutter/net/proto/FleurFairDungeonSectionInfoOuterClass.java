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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairDungeonSectionInfoOuterClass.class */
public final class FleurFairDungeonSectionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!FleurFairDungeonSectionInfo.proto\"R\n\u001bFleurFairDungeonSectionInfo\u0012\u0010\n\bopenTime\u0018\u000b \u0001(\r\u0012\u0011\n\tsectionId\u0018\u0002 \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\u0005 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FleurFairDungeonSectionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FleurFairDungeonSectionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FleurFairDungeonSectionInfo_descriptor, new String[]{"OpenTime", "SectionId", "IsOpen"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairDungeonSectionInfoOuterClass$FleurFairDungeonSectionInfoOrBuilder.class */
    public interface FleurFairDungeonSectionInfoOrBuilder extends MessageOrBuilder {
        int getOpenTime();

        int getSectionId();

        boolean getIsOpen();
    }

    private FleurFairDungeonSectionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairDungeonSectionInfoOuterClass$FleurFairDungeonSectionInfo.class */
    public static final class FleurFairDungeonSectionInfo extends GeneratedMessageV3 implements FleurFairDungeonSectionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OPENTIME_FIELD_NUMBER = 11;
        private int openTime_;
        public static final int SECTIONID_FIELD_NUMBER = 2;
        private int sectionId_;
        public static final int ISOPEN_FIELD_NUMBER = 5;
        private boolean isOpen_;
        private byte memoizedIsInitialized;
        private static final FleurFairDungeonSectionInfo DEFAULT_INSTANCE = new FleurFairDungeonSectionInfo();
        private static final Parser<FleurFairDungeonSectionInfo> PARSER = new AbstractParser<FleurFairDungeonSectionInfo>() { // from class: emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfo.1
            @Override // com.google.protobuf.Parser
            public FleurFairDungeonSectionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FleurFairDungeonSectionInfo(input, extensionRegistry);
            }
        };

        private FleurFairDungeonSectionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FleurFairDungeonSectionInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FleurFairDungeonSectionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FleurFairDungeonSectionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.sectionId_ = input.readUInt32();
                                    break;
                                case 40:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 88:
                                    this.openTime_ = input.readUInt32();
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
                        }
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
            return FleurFairDungeonSectionInfoOuterClass.internal_static_FleurFairDungeonSectionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FleurFairDungeonSectionInfoOuterClass.internal_static_FleurFairDungeonSectionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairDungeonSectionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfoOrBuilder
        public int getSectionId() {
            return this.sectionId_;
        }

        @Override // emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfoOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
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
            if (this.sectionId_ != 0) {
                output.writeUInt32(2, this.sectionId_);
            }
            if (this.isOpen_) {
                output.writeBool(5, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(11, this.openTime_);
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
            if (this.sectionId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.sectionId_);
            }
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isOpen_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.openTime_);
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
            if (!(obj instanceof FleurFairDungeonSectionInfo)) {
                return equals(obj);
            }
            FleurFairDungeonSectionInfo other = (FleurFairDungeonSectionInfo) obj;
            return getOpenTime() == other.getOpenTime() && getSectionId() == other.getSectionId() && getIsOpen() == other.getIsOpen() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getOpenTime())) + 2)) + getSectionId())) + 5)) + Internal.hashBoolean(getIsOpen()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FleurFairDungeonSectionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairDungeonSectionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairDungeonSectionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairDungeonSectionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairDungeonSectionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FleurFairDungeonSectionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FleurFairDungeonSectionInfo parseFrom(InputStream input) throws IOException {
            return (FleurFairDungeonSectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairDungeonSectionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairDungeonSectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairDungeonSectionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FleurFairDungeonSectionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FleurFairDungeonSectionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairDungeonSectionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FleurFairDungeonSectionInfo parseFrom(CodedInputStream input) throws IOException {
            return (FleurFairDungeonSectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FleurFairDungeonSectionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FleurFairDungeonSectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FleurFairDungeonSectionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FleurFairDungeonSectionInfoOuterClass$FleurFairDungeonSectionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FleurFairDungeonSectionInfoOrBuilder {
            private int openTime_;
            private int sectionId_;
            private boolean isOpen_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FleurFairDungeonSectionInfoOuterClass.internal_static_FleurFairDungeonSectionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FleurFairDungeonSectionInfoOuterClass.internal_static_FleurFairDungeonSectionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FleurFairDungeonSectionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FleurFairDungeonSectionInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.openTime_ = 0;
                this.sectionId_ = 0;
                this.isOpen_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FleurFairDungeonSectionInfoOuterClass.internal_static_FleurFairDungeonSectionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FleurFairDungeonSectionInfo getDefaultInstanceForType() {
                return FleurFairDungeonSectionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairDungeonSectionInfo build() {
                FleurFairDungeonSectionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FleurFairDungeonSectionInfo buildPartial() {
                FleurFairDungeonSectionInfo result = new FleurFairDungeonSectionInfo(this);
                result.openTime_ = this.openTime_;
                result.sectionId_ = this.sectionId_;
                result.isOpen_ = this.isOpen_;
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
                if (other instanceof FleurFairDungeonSectionInfo) {
                    return mergeFrom((FleurFairDungeonSectionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FleurFairDungeonSectionInfo other) {
                if (other == FleurFairDungeonSectionInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.getSectionId() != 0) {
                    setSectionId(other.getSectionId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
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
                FleurFairDungeonSectionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FleurFairDungeonSectionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FleurFairDungeonSectionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfoOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfoOrBuilder
            public int getSectionId() {
                return this.sectionId_;
            }

            public Builder setSectionId(int value) {
                this.sectionId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSectionId() {
                this.sectionId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FleurFairDungeonSectionInfoOuterClass.FleurFairDungeonSectionInfoOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
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

        public static FleurFairDungeonSectionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FleurFairDungeonSectionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FleurFairDungeonSectionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FleurFairDungeonSectionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
