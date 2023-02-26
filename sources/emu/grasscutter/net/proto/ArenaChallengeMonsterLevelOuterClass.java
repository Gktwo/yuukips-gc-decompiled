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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeMonsterLevelOuterClass.class */
public final class ArenaChallengeMonsterLevelOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n ArenaChallengeMonsterLevel.proto\"V\n\u001aArenaChallengeMonsterLevel\u0012\u001b\n\u0013Unk3300_FDFNFLAKONG\u0018\r \u0001(\r\u0012\u001b\n\u0013Unk3300_DBHAGHMMLAI\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_ArenaChallengeMonsterLevel_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ArenaChallengeMonsterLevel_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ArenaChallengeMonsterLevel_descriptor, new String[]{"Unk3300FDFNFLAKONG", "Unk3300DBHAGHMMLAI"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeMonsterLevelOuterClass$ArenaChallengeMonsterLevelOrBuilder.class */
    public interface ArenaChallengeMonsterLevelOrBuilder extends MessageOrBuilder {
        int getUnk3300FDFNFLAKONG();

        int getUnk3300DBHAGHMMLAI();
    }

    private ArenaChallengeMonsterLevelOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeMonsterLevelOuterClass$ArenaChallengeMonsterLevel.class */
    public static final class ArenaChallengeMonsterLevel extends GeneratedMessageV3 implements ArenaChallengeMonsterLevelOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_FDFNFLAKONG_FIELD_NUMBER = 13;
        private int unk3300FDFNFLAKONG_;
        public static final int UNK3300_DBHAGHMMLAI_FIELD_NUMBER = 3;
        private int unk3300DBHAGHMMLAI_;
        private byte memoizedIsInitialized;
        private static final ArenaChallengeMonsterLevel DEFAULT_INSTANCE = new ArenaChallengeMonsterLevel();
        private static final Parser<ArenaChallengeMonsterLevel> PARSER = new AbstractParser<ArenaChallengeMonsterLevel>() { // from class: emu.grasscutter.net.proto.ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevel.1
            @Override // com.google.protobuf.Parser
            public ArenaChallengeMonsterLevel parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ArenaChallengeMonsterLevel(input, extensionRegistry);
            }
        };

        private ArenaChallengeMonsterLevel(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ArenaChallengeMonsterLevel() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ArenaChallengeMonsterLevel();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ArenaChallengeMonsterLevel(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300DBHAGHMMLAI_ = input.readUInt32();
                                break;
                            case 104:
                                this.unk3300FDFNFLAKONG_ = input.readUInt32();
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
            return ArenaChallengeMonsterLevelOuterClass.internal_static_ArenaChallengeMonsterLevel_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ArenaChallengeMonsterLevelOuterClass.internal_static_ArenaChallengeMonsterLevel_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaChallengeMonsterLevel.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder
        public int getUnk3300FDFNFLAKONG() {
            return this.unk3300FDFNFLAKONG_;
        }

        @Override // emu.grasscutter.net.proto.ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder
        public int getUnk3300DBHAGHMMLAI() {
            return this.unk3300DBHAGHMMLAI_;
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
            if (this.unk3300DBHAGHMMLAI_ != 0) {
                output.writeUInt32(3, this.unk3300DBHAGHMMLAI_);
            }
            if (this.unk3300FDFNFLAKONG_ != 0) {
                output.writeUInt32(13, this.unk3300FDFNFLAKONG_);
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
            if (this.unk3300DBHAGHMMLAI_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.unk3300DBHAGHMMLAI_);
            }
            if (this.unk3300FDFNFLAKONG_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unk3300FDFNFLAKONG_);
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
            if (!(obj instanceof ArenaChallengeMonsterLevel)) {
                return equals(obj);
            }
            ArenaChallengeMonsterLevel other = (ArenaChallengeMonsterLevel) obj;
            return getUnk3300FDFNFLAKONG() == other.getUnk3300FDFNFLAKONG() && getUnk3300DBHAGHMMLAI() == other.getUnk3300DBHAGHMMLAI() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getUnk3300FDFNFLAKONG())) + 3)) + getUnk3300DBHAGHMMLAI())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static ArenaChallengeMonsterLevel parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ArenaChallengeMonsterLevel parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaChallengeMonsterLevel parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ArenaChallengeMonsterLevel parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaChallengeMonsterLevel parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ArenaChallengeMonsterLevel parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ArenaChallengeMonsterLevel parseFrom(InputStream input) throws IOException {
            return (ArenaChallengeMonsterLevel) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ArenaChallengeMonsterLevel parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaChallengeMonsterLevel) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ArenaChallengeMonsterLevel parseDelimitedFrom(InputStream input) throws IOException {
            return (ArenaChallengeMonsterLevel) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ArenaChallengeMonsterLevel parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaChallengeMonsterLevel) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ArenaChallengeMonsterLevel parseFrom(CodedInputStream input) throws IOException {
            return (ArenaChallengeMonsterLevel) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ArenaChallengeMonsterLevel parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ArenaChallengeMonsterLevel) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ArenaChallengeMonsterLevel prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ArenaChallengeMonsterLevelOuterClass$ArenaChallengeMonsterLevel$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ArenaChallengeMonsterLevelOrBuilder {
            private int unk3300FDFNFLAKONG_;
            private int unk3300DBHAGHMMLAI_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ArenaChallengeMonsterLevelOuterClass.internal_static_ArenaChallengeMonsterLevel_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ArenaChallengeMonsterLevelOuterClass.internal_static_ArenaChallengeMonsterLevel_fieldAccessorTable.ensureFieldAccessorsInitialized(ArenaChallengeMonsterLevel.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ArenaChallengeMonsterLevel.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300FDFNFLAKONG_ = 0;
                this.unk3300DBHAGHMMLAI_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ArenaChallengeMonsterLevelOuterClass.internal_static_ArenaChallengeMonsterLevel_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ArenaChallengeMonsterLevel getDefaultInstanceForType() {
                return ArenaChallengeMonsterLevel.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ArenaChallengeMonsterLevel build() {
                ArenaChallengeMonsterLevel result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ArenaChallengeMonsterLevel buildPartial() {
                ArenaChallengeMonsterLevel result = new ArenaChallengeMonsterLevel(this);
                result.unk3300FDFNFLAKONG_ = this.unk3300FDFNFLAKONG_;
                result.unk3300DBHAGHMMLAI_ = this.unk3300DBHAGHMMLAI_;
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
                if (other instanceof ArenaChallengeMonsterLevel) {
                    return mergeFrom((ArenaChallengeMonsterLevel) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ArenaChallengeMonsterLevel other) {
                if (other == ArenaChallengeMonsterLevel.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300FDFNFLAKONG() != 0) {
                    setUnk3300FDFNFLAKONG(other.getUnk3300FDFNFLAKONG());
                }
                if (other.getUnk3300DBHAGHMMLAI() != 0) {
                    setUnk3300DBHAGHMMLAI(other.getUnk3300DBHAGHMMLAI());
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
                ArenaChallengeMonsterLevel parsedMessage = null;
                try {
                    try {
                        parsedMessage = ArenaChallengeMonsterLevel.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ArenaChallengeMonsterLevel) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder
            public int getUnk3300FDFNFLAKONG() {
                return this.unk3300FDFNFLAKONG_;
            }

            public Builder setUnk3300FDFNFLAKONG(int value) {
                this.unk3300FDFNFLAKONG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FDFNFLAKONG() {
                this.unk3300FDFNFLAKONG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ArenaChallengeMonsterLevelOuterClass.ArenaChallengeMonsterLevelOrBuilder
            public int getUnk3300DBHAGHMMLAI() {
                return this.unk3300DBHAGHMMLAI_;
            }

            public Builder setUnk3300DBHAGHMMLAI(int value) {
                this.unk3300DBHAGHMMLAI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DBHAGHMMLAI() {
                this.unk3300DBHAGHMMLAI_ = 0;
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

        public static ArenaChallengeMonsterLevel getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ArenaChallengeMonsterLevel> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ArenaChallengeMonsterLevel> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ArenaChallengeMonsterLevel getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
