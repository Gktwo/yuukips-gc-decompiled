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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataNotifyOuterClass.class */
public final class GCGTCTavernChallengeDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$GCGTCTavernChallengeDataNotify.proto\"F\n\u001eGCGTCTavernChallengeDataNotify\u0012\u000f\n\u0007levelId\u0018\u0002 \u0001(\r\u0012\u0013\n\u000bcaaaccpgkff\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GCGTCTavernChallengeDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GCGTCTavernChallengeDataNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f719x8763fc19 = new GeneratedMessageV3.FieldAccessorTable(internal_static_GCGTCTavernChallengeDataNotify_descriptor, new String[]{"LevelId", "Caaaccpgkff"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataNotifyOuterClass$GCGTCTavernChallengeDataNotifyOrBuilder.class */
    public interface GCGTCTavernChallengeDataNotifyOrBuilder extends MessageOrBuilder {
        int getLevelId();

        int getCaaaccpgkff();
    }

    private GCGTCTavernChallengeDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataNotifyOuterClass$GCGTCTavernChallengeDataNotify.class */
    public static final class GCGTCTavernChallengeDataNotify extends GeneratedMessageV3 implements GCGTCTavernChallengeDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVELID_FIELD_NUMBER = 2;
        private int levelId_;
        public static final int CAAACCPGKFF_FIELD_NUMBER = 3;
        private int caaaccpgkff_;
        private byte memoizedIsInitialized;
        private static final GCGTCTavernChallengeDataNotify DEFAULT_INSTANCE = new GCGTCTavernChallengeDataNotify();
        private static final Parser<GCGTCTavernChallengeDataNotify> PARSER = new AbstractParser<GCGTCTavernChallengeDataNotify>() { // from class: emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotify.1
            @Override // com.google.protobuf.Parser
            public GCGTCTavernChallengeDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GCGTCTavernChallengeDataNotify(input, extensionRegistry);
            }
        };

        private GCGTCTavernChallengeDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GCGTCTavernChallengeDataNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GCGTCTavernChallengeDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GCGTCTavernChallengeDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.levelId_ = input.readUInt32();
                                break;
                            case 24:
                                this.caaaccpgkff_ = input.readUInt32();
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
            return GCGTCTavernChallengeDataNotifyOuterClass.internal_static_GCGTCTavernChallengeDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GCGTCTavernChallengeDataNotifyOuterClass.f719x8763fc19.ensureFieldAccessorsInitialized(GCGTCTavernChallengeDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
        public int getLevelId() {
            return this.levelId_;
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
        public int getCaaaccpgkff() {
            return this.caaaccpgkff_;
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
            if (this.levelId_ != 0) {
                output.writeUInt32(2, this.levelId_);
            }
            if (this.caaaccpgkff_ != 0) {
                output.writeUInt32(3, this.caaaccpgkff_);
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
            if (this.levelId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.levelId_);
            }
            if (this.caaaccpgkff_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.caaaccpgkff_);
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
            if (!(obj instanceof GCGTCTavernChallengeDataNotify)) {
                return equals(obj);
            }
            GCGTCTavernChallengeDataNotify other = (GCGTCTavernChallengeDataNotify) obj;
            return getLevelId() == other.getLevelId() && getCaaaccpgkff() == other.getCaaaccpgkff() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getLevelId())) + 3)) + getCaaaccpgkff())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(InputStream input) throws IOException {
            return (GCGTCTavernChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GCGTCTavernChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GCGTCTavernChallengeDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (GCGTCTavernChallengeDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GCGTCTavernChallengeDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GCGTCTavernChallengeDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (GCGTCTavernChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GCGTCTavernChallengeDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GCGTCTavernChallengeDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GCGTCTavernChallengeDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataNotifyOuterClass$GCGTCTavernChallengeDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GCGTCTavernChallengeDataNotifyOrBuilder {
            private int levelId_;
            private int caaaccpgkff_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GCGTCTavernChallengeDataNotifyOuterClass.internal_static_GCGTCTavernChallengeDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GCGTCTavernChallengeDataNotifyOuterClass.f719x8763fc19.ensureFieldAccessorsInitialized(GCGTCTavernChallengeDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GCGTCTavernChallengeDataNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.levelId_ = 0;
                this.caaaccpgkff_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GCGTCTavernChallengeDataNotifyOuterClass.internal_static_GCGTCTavernChallengeDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GCGTCTavernChallengeDataNotify getDefaultInstanceForType() {
                return GCGTCTavernChallengeDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GCGTCTavernChallengeDataNotify build() {
                GCGTCTavernChallengeDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GCGTCTavernChallengeDataNotify buildPartial() {
                GCGTCTavernChallengeDataNotify result = new GCGTCTavernChallengeDataNotify(this);
                result.levelId_ = this.levelId_;
                result.caaaccpgkff_ = this.caaaccpgkff_;
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
                if (other instanceof GCGTCTavernChallengeDataNotify) {
                    return mergeFrom((GCGTCTavernChallengeDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GCGTCTavernChallengeDataNotify other) {
                if (other == GCGTCTavernChallengeDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevelId() != 0) {
                    setLevelId(other.getLevelId());
                }
                if (other.getCaaaccpgkff() != 0) {
                    setCaaaccpgkff(other.getCaaaccpgkff());
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
                GCGTCTavernChallengeDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = GCGTCTavernChallengeDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GCGTCTavernChallengeDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
            public int getLevelId() {
                return this.levelId_;
            }

            public Builder setLevelId(int value) {
                this.levelId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevelId() {
                this.levelId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
            public int getCaaaccpgkff() {
                return this.caaaccpgkff_;
            }

            public Builder setCaaaccpgkff(int value) {
                this.caaaccpgkff_ = value;
                onChanged();
                return this;
            }

            public Builder clearCaaaccpgkff() {
                this.caaaccpgkff_ = 0;
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

        public static GCGTCTavernChallengeDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GCGTCTavernChallengeDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GCGTCTavernChallengeDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GCGTCTavernChallengeDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
