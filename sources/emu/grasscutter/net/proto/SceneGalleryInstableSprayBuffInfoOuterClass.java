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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryInstableSprayBuffInfoOuterClass.class */
public final class SceneGalleryInstableSprayBuffInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'SceneGalleryInstableSprayBuffInfo.proto\"m\n!SceneGalleryInstableSprayBuffInfo\u0012\u000e\n\u0006buffId\u0018\t \u0001(\r\u0012\u001b\n\u0013Unk3300_EPHAABKNLHC\u0018\u0003 \u0001(\u0004\u0012\u001b\n\u0013Unk3300_KKDFLBMKGEF\u0018\b \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SceneGalleryInstableSprayBuffInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_SceneGalleryInstableSprayBuffInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f842xaa131e33 = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneGalleryInstableSprayBuffInfo_descriptor, new String[]{"BuffId", "Unk3300EPHAABKNLHC", "Unk3300KKDFLBMKGEF"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryInstableSprayBuffInfoOuterClass$SceneGalleryInstableSprayBuffInfoOrBuilder.class */
    public interface SceneGalleryInstableSprayBuffInfoOrBuilder extends MessageOrBuilder {
        int getBuffId();

        long getUnk3300EPHAABKNLHC();

        long getUnk3300KKDFLBMKGEF();
    }

    private SceneGalleryInstableSprayBuffInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryInstableSprayBuffInfoOuterClass$SceneGalleryInstableSprayBuffInfo.class */
    public static final class SceneGalleryInstableSprayBuffInfo extends GeneratedMessageV3 implements SceneGalleryInstableSprayBuffInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BUFFID_FIELD_NUMBER = 9;
        private int buffId_;
        public static final int UNK3300_EPHAABKNLHC_FIELD_NUMBER = 3;
        private long unk3300EPHAABKNLHC_;
        public static final int UNK3300_KKDFLBMKGEF_FIELD_NUMBER = 8;
        private long unk3300KKDFLBMKGEF_;
        private byte memoizedIsInitialized;
        private static final SceneGalleryInstableSprayBuffInfo DEFAULT_INSTANCE = new SceneGalleryInstableSprayBuffInfo();
        private static final Parser<SceneGalleryInstableSprayBuffInfo> PARSER = new AbstractParser<SceneGalleryInstableSprayBuffInfo>() { // from class: emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfo.1
            @Override // com.google.protobuf.Parser
            public SceneGalleryInstableSprayBuffInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneGalleryInstableSprayBuffInfo(input, extensionRegistry);
            }
        };

        private SceneGalleryInstableSprayBuffInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneGalleryInstableSprayBuffInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneGalleryInstableSprayBuffInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneGalleryInstableSprayBuffInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.unk3300EPHAABKNLHC_ = input.readUInt64();
                                    break;
                                case 64:
                                    this.unk3300KKDFLBMKGEF_ = input.readUInt64();
                                    break;
                                case 72:
                                    this.buffId_ = input.readUInt32();
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
            return SceneGalleryInstableSprayBuffInfoOuterClass.internal_static_SceneGalleryInstableSprayBuffInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneGalleryInstableSprayBuffInfoOuterClass.f842xaa131e33.ensureFieldAccessorsInitialized(SceneGalleryInstableSprayBuffInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder
        public int getBuffId() {
            return this.buffId_;
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder
        public long getUnk3300EPHAABKNLHC() {
            return this.unk3300EPHAABKNLHC_;
        }

        @Override // emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder
        public long getUnk3300KKDFLBMKGEF() {
            return this.unk3300KKDFLBMKGEF_;
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
            if (this.unk3300EPHAABKNLHC_ != 0) {
                output.writeUInt64(3, this.unk3300EPHAABKNLHC_);
            }
            if (this.unk3300KKDFLBMKGEF_ != 0) {
                output.writeUInt64(8, this.unk3300KKDFLBMKGEF_);
            }
            if (this.buffId_ != 0) {
                output.writeUInt32(9, this.buffId_);
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
            if (this.unk3300EPHAABKNLHC_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt64Size(3, this.unk3300EPHAABKNLHC_);
            }
            if (this.unk3300KKDFLBMKGEF_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(8, this.unk3300KKDFLBMKGEF_);
            }
            if (this.buffId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.buffId_);
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
            if (!(obj instanceof SceneGalleryInstableSprayBuffInfo)) {
                return equals(obj);
            }
            SceneGalleryInstableSprayBuffInfo other = (SceneGalleryInstableSprayBuffInfo) obj;
            return getBuffId() == other.getBuffId() && getUnk3300EPHAABKNLHC() == other.getUnk3300EPHAABKNLHC() && getUnk3300KKDFLBMKGEF() == other.getUnk3300KKDFLBMKGEF() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + getBuffId())) + 3)) + Internal.hashLong(getUnk3300EPHAABKNLHC()))) + 8)) + Internal.hashLong(getUnk3300KKDFLBMKGEF()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(InputStream input) throws IOException {
            return (SceneGalleryInstableSprayBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGalleryInstableSprayBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneGalleryInstableSprayBuffInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneGalleryInstableSprayBuffInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneGalleryInstableSprayBuffInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGalleryInstableSprayBuffInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneGalleryInstableSprayBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneGalleryInstableSprayBuffInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneGalleryInstableSprayBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneGalleryInstableSprayBuffInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneGalleryInstableSprayBuffInfoOuterClass$SceneGalleryInstableSprayBuffInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneGalleryInstableSprayBuffInfoOrBuilder {
            private int buffId_;
            private long unk3300EPHAABKNLHC_;
            private long unk3300KKDFLBMKGEF_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneGalleryInstableSprayBuffInfoOuterClass.internal_static_SceneGalleryInstableSprayBuffInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneGalleryInstableSprayBuffInfoOuterClass.f842xaa131e33.ensureFieldAccessorsInitialized(SceneGalleryInstableSprayBuffInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneGalleryInstableSprayBuffInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.buffId_ = 0;
                this.unk3300EPHAABKNLHC_ = 0;
                this.unk3300KKDFLBMKGEF_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneGalleryInstableSprayBuffInfoOuterClass.internal_static_SceneGalleryInstableSprayBuffInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneGalleryInstableSprayBuffInfo getDefaultInstanceForType() {
                return SceneGalleryInstableSprayBuffInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneGalleryInstableSprayBuffInfo build() {
                SceneGalleryInstableSprayBuffInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneGalleryInstableSprayBuffInfo buildPartial() {
                SceneGalleryInstableSprayBuffInfo result = new SceneGalleryInstableSprayBuffInfo(this);
                result.buffId_ = this.buffId_;
                result.unk3300EPHAABKNLHC_ = this.unk3300EPHAABKNLHC_;
                result.unk3300KKDFLBMKGEF_ = this.unk3300KKDFLBMKGEF_;
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
                if (other instanceof SceneGalleryInstableSprayBuffInfo) {
                    return mergeFrom((SceneGalleryInstableSprayBuffInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneGalleryInstableSprayBuffInfo other) {
                if (other == SceneGalleryInstableSprayBuffInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getBuffId() != 0) {
                    setBuffId(other.getBuffId());
                }
                if (other.getUnk3300EPHAABKNLHC() != 0) {
                    setUnk3300EPHAABKNLHC(other.getUnk3300EPHAABKNLHC());
                }
                if (other.getUnk3300KKDFLBMKGEF() != 0) {
                    setUnk3300KKDFLBMKGEF(other.getUnk3300KKDFLBMKGEF());
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
                SceneGalleryInstableSprayBuffInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneGalleryInstableSprayBuffInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneGalleryInstableSprayBuffInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder
            public int getBuffId() {
                return this.buffId_;
            }

            public Builder setBuffId(int value) {
                this.buffId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBuffId() {
                this.buffId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder
            public long getUnk3300EPHAABKNLHC() {
                return this.unk3300EPHAABKNLHC_;
            }

            public Builder setUnk3300EPHAABKNLHC(long value) {
                this.unk3300EPHAABKNLHC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EPHAABKNLHC() {
                this.unk3300EPHAABKNLHC_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneGalleryInstableSprayBuffInfoOuterClass.SceneGalleryInstableSprayBuffInfoOrBuilder
            public long getUnk3300KKDFLBMKGEF() {
                return this.unk3300KKDFLBMKGEF_;
            }

            public Builder setUnk3300KKDFLBMKGEF(long value) {
                this.unk3300KKDFLBMKGEF_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KKDFLBMKGEF() {
                this.unk3300KKDFLBMKGEF_ = 0;
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

        public static SceneGalleryInstableSprayBuffInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneGalleryInstableSprayBuffInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneGalleryInstableSprayBuffInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneGalleryInstableSprayBuffInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
