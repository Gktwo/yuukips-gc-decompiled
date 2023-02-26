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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityInfoOuterClass.class */
public final class CityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000eCityInfo.proto\"=\n\bCityInfo\u0012\u0012\n\ncrystalNum\u0018\u000f \u0001(\r\u0012\u000e\n\u0006cityId\u0018\u0006 \u0001(\r\u0012\r\n\u0005level\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CityInfo_descriptor, new String[]{"CrystalNum", "CityId", "Level"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityInfoOuterClass$CityInfoOrBuilder.class */
    public interface CityInfoOrBuilder extends MessageOrBuilder {
        int getCrystalNum();

        int getCityId();

        int getLevel();
    }

    private CityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityInfoOuterClass$CityInfo.class */
    public static final class CityInfo extends GeneratedMessageV3 implements CityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CRYSTALNUM_FIELD_NUMBER = 15;
        private int crystalNum_;
        public static final int CITYID_FIELD_NUMBER = 6;
        private int cityId_;
        public static final int LEVEL_FIELD_NUMBER = 11;
        private int level_;
        private byte memoizedIsInitialized;
        private static final CityInfo DEFAULT_INSTANCE = new CityInfo();
        private static final Parser<CityInfo> PARSER = new AbstractParser<CityInfo>() { // from class: emu.grasscutter.net.proto.CityInfoOuterClass.CityInfo.1
            @Override // com.google.protobuf.Parser
            public CityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CityInfo(input, extensionRegistry);
            }
        };

        private CityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CityInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.cityId_ = input.readUInt32();
                                    break;
                                case 88:
                                    this.level_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.crystalNum_ = input.readUInt32();
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
            return CityInfoOuterClass.internal_static_CityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CityInfoOuterClass.internal_static_CityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CityInfoOuterClass.CityInfoOrBuilder
        public int getCrystalNum() {
            return this.crystalNum_;
        }

        @Override // emu.grasscutter.net.proto.CityInfoOuterClass.CityInfoOrBuilder
        public int getCityId() {
            return this.cityId_;
        }

        @Override // emu.grasscutter.net.proto.CityInfoOuterClass.CityInfoOrBuilder
        public int getLevel() {
            return this.level_;
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
            if (this.cityId_ != 0) {
                output.writeUInt32(6, this.cityId_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(11, this.level_);
            }
            if (this.crystalNum_ != 0) {
                output.writeUInt32(15, this.crystalNum_);
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
            if (this.cityId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.cityId_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.level_);
            }
            if (this.crystalNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.crystalNum_);
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
            if (!(obj instanceof CityInfo)) {
                return equals(obj);
            }
            CityInfo other = (CityInfo) obj;
            return getCrystalNum() == other.getCrystalNum() && getCityId() == other.getCityId() && getLevel() == other.getLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getCrystalNum())) + 6)) + getCityId())) + 11)) + getLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CityInfo parseFrom(InputStream input) throws IOException {
            return (CityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CityInfo parseFrom(CodedInputStream input) throws IOException {
            return (CityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CityInfoOuterClass$CityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CityInfoOrBuilder {
            private int crystalNum_;
            private int cityId_;
            private int level_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CityInfoOuterClass.internal_static_CityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CityInfoOuterClass.internal_static_CityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CityInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.crystalNum_ = 0;
                this.cityId_ = 0;
                this.level_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CityInfoOuterClass.internal_static_CityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CityInfo getDefaultInstanceForType() {
                return CityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CityInfo build() {
                CityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CityInfo buildPartial() {
                CityInfo result = new CityInfo(this);
                result.crystalNum_ = this.crystalNum_;
                result.cityId_ = this.cityId_;
                result.level_ = this.level_;
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
                if (other instanceof CityInfo) {
                    return mergeFrom((CityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CityInfo other) {
                if (other == CityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getCrystalNum() != 0) {
                    setCrystalNum(other.getCrystalNum());
                }
                if (other.getCityId() != 0) {
                    setCityId(other.getCityId());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
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
                CityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CityInfoOuterClass.CityInfoOrBuilder
            public int getCrystalNum() {
                return this.crystalNum_;
            }

            public Builder setCrystalNum(int value) {
                this.crystalNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCrystalNum() {
                this.crystalNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CityInfoOuterClass.CityInfoOrBuilder
            public int getCityId() {
                return this.cityId_;
            }

            public Builder setCityId(int value) {
                this.cityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCityId() {
                this.cityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CityInfoOuterClass.CityInfoOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
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

        public static CityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
