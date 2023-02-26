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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartReqOuterClass.class */
public final class MusicGameStartReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017MusicGameStartReq.proto\"O\n\u0011MusicGameStartReq\u0012\u000f\n\u0007ugcGuid\u0018\u0005 \u0001(\u0004\u0012\u0014\n\fmusicBasicId\u0018\u0007 \u0001(\r\u0012\u0013\n\u000bisSaveScore\u0018\u000f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MusicGameStartReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MusicGameStartReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameStartReq_descriptor, new String[]{"UgcGuid", "MusicBasicId", "IsSaveScore"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartReqOuterClass$MusicGameStartReqOrBuilder.class */
    public interface MusicGameStartReqOrBuilder extends MessageOrBuilder {
        long getUgcGuid();

        int getMusicBasicId();

        boolean getIsSaveScore();
    }

    private MusicGameStartReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartReqOuterClass$MusicGameStartReq.class */
    public static final class MusicGameStartReq extends GeneratedMessageV3 implements MusicGameStartReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UGCGUID_FIELD_NUMBER = 5;
        private long ugcGuid_;
        public static final int MUSICBASICID_FIELD_NUMBER = 7;
        private int musicBasicId_;
        public static final int ISSAVESCORE_FIELD_NUMBER = 15;
        private boolean isSaveScore_;
        private byte memoizedIsInitialized;
        private static final MusicGameStartReq DEFAULT_INSTANCE = new MusicGameStartReq();
        private static final Parser<MusicGameStartReq> PARSER = new AbstractParser<MusicGameStartReq>() { // from class: emu.grasscutter.net.proto.MusicGameStartReqOuterClass.MusicGameStartReq.1
            @Override // com.google.protobuf.Parser
            public MusicGameStartReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameStartReq(input, extensionRegistry);
            }
        };

        private MusicGameStartReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MusicGameStartReq() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameStartReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameStartReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 40:
                                    this.ugcGuid_ = input.readUInt64();
                                    break;
                                case 56:
                                    this.musicBasicId_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.isSaveScore_ = input.readBool();
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
            return MusicGameStartReqOuterClass.internal_static_MusicGameStartReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameStartReqOuterClass.internal_static_MusicGameStartReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameStartReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartReqOuterClass.MusicGameStartReqOrBuilder
        public long getUgcGuid() {
            return this.ugcGuid_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartReqOuterClass.MusicGameStartReqOrBuilder
        public int getMusicBasicId() {
            return this.musicBasicId_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartReqOuterClass.MusicGameStartReqOrBuilder
        public boolean getIsSaveScore() {
            return this.isSaveScore_;
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
            if (this.ugcGuid_ != 0) {
                output.writeUInt64(5, this.ugcGuid_);
            }
            if (this.musicBasicId_ != 0) {
                output.writeUInt32(7, this.musicBasicId_);
            }
            if (this.isSaveScore_) {
                output.writeBool(15, this.isSaveScore_);
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
            if (this.ugcGuid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(5, this.ugcGuid_);
            }
            if (this.musicBasicId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.musicBasicId_);
            }
            if (this.isSaveScore_) {
                size2 += CodedOutputStream.computeBoolSize(15, this.isSaveScore_);
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
            if (!(obj instanceof MusicGameStartReq)) {
                return equals(obj);
            }
            MusicGameStartReq other = (MusicGameStartReq) obj;
            return getUgcGuid() == other.getUgcGuid() && getMusicBasicId() == other.getMusicBasicId() && getIsSaveScore() == other.getIsSaveScore() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + Internal.hashLong(getUgcGuid()))) + 7)) + getMusicBasicId())) + 15)) + Internal.hashBoolean(getIsSaveScore()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static MusicGameStartReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameStartReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameStartReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameStartReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameStartReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameStartReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameStartReq parseFrom(InputStream input) throws IOException {
            return (MusicGameStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameStartReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameStartReq parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameStartReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameStartReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameStartReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameStartReq parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameStartReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameStartReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameStartReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartReqOuterClass$MusicGameStartReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameStartReqOrBuilder {
            private long ugcGuid_;
            private int musicBasicId_;
            private boolean isSaveScore_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameStartReqOuterClass.internal_static_MusicGameStartReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameStartReqOuterClass.internal_static_MusicGameStartReq_fieldAccessorTable.ensureFieldAccessorsInitialized(MusicGameStartReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameStartReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.ugcGuid_ = 0;
                this.musicBasicId_ = 0;
                this.isSaveScore_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameStartReqOuterClass.internal_static_MusicGameStartReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameStartReq getDefaultInstanceForType() {
                return MusicGameStartReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameStartReq build() {
                MusicGameStartReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameStartReq buildPartial() {
                MusicGameStartReq result = new MusicGameStartReq(this);
                result.ugcGuid_ = this.ugcGuid_;
                result.musicBasicId_ = this.musicBasicId_;
                result.isSaveScore_ = this.isSaveScore_;
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
                if (other instanceof MusicGameStartReq) {
                    return mergeFrom((MusicGameStartReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameStartReq other) {
                if (other == MusicGameStartReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getUgcGuid() != 0) {
                    setUgcGuid(other.getUgcGuid());
                }
                if (other.getMusicBasicId() != 0) {
                    setMusicBasicId(other.getMusicBasicId());
                }
                if (other.getIsSaveScore()) {
                    setIsSaveScore(other.getIsSaveScore());
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
                MusicGameStartReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameStartReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameStartReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartReqOuterClass.MusicGameStartReqOrBuilder
            public long getUgcGuid() {
                return this.ugcGuid_;
            }

            public Builder setUgcGuid(long value) {
                this.ugcGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUgcGuid() {
                this.ugcGuid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartReqOuterClass.MusicGameStartReqOrBuilder
            public int getMusicBasicId() {
                return this.musicBasicId_;
            }

            public Builder setMusicBasicId(int value) {
                this.musicBasicId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMusicBasicId() {
                this.musicBasicId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartReqOuterClass.MusicGameStartReqOrBuilder
            public boolean getIsSaveScore() {
                return this.isSaveScore_;
            }

            public Builder setIsSaveScore(boolean value) {
                this.isSaveScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsSaveScore() {
                this.isSaveScore_ = false;
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

        public static MusicGameStartReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameStartReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameStartReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameStartReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
