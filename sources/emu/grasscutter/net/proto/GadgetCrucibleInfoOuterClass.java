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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetCrucibleInfoOuterClass.class */
public final class GadgetCrucibleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018GadgetCrucibleInfo.proto\"B\n\u0012GadgetCrucibleInfo\u0012\u0012\n\nmp_play_id\u0018\u0001 \u0001(\r\u0012\u0018\n\u0010prepare_end_time\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GadgetCrucibleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GadgetCrucibleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GadgetCrucibleInfo_descriptor, new String[]{"MpPlayId", "PrepareEndTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetCrucibleInfoOuterClass$GadgetCrucibleInfoOrBuilder.class */
    public interface GadgetCrucibleInfoOrBuilder extends MessageOrBuilder {
        int getMpPlayId();

        int getPrepareEndTime();
    }

    private GadgetCrucibleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetCrucibleInfoOuterClass$GadgetCrucibleInfo.class */
    public static final class GadgetCrucibleInfo extends GeneratedMessageV3 implements GadgetCrucibleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MP_PLAY_ID_FIELD_NUMBER = 1;
        private int mpPlayId_;
        public static final int PREPARE_END_TIME_FIELD_NUMBER = 2;
        private int prepareEndTime_;
        private byte memoizedIsInitialized;
        private static final GadgetCrucibleInfo DEFAULT_INSTANCE = new GadgetCrucibleInfo();
        private static final Parser<GadgetCrucibleInfo> PARSER = new AbstractParser<GadgetCrucibleInfo>() { // from class: emu.grasscutter.net.proto.GadgetCrucibleInfoOuterClass.GadgetCrucibleInfo.1
            @Override // com.google.protobuf.Parser
            public GadgetCrucibleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GadgetCrucibleInfo(input, extensionRegistry);
            }
        };

        private GadgetCrucibleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GadgetCrucibleInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GadgetCrucibleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GadgetCrucibleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.mpPlayId_ = input.readUInt32();
                                break;
                            case 16:
                                this.prepareEndTime_ = input.readUInt32();
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
            return GadgetCrucibleInfoOuterClass.internal_static_GadgetCrucibleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GadgetCrucibleInfoOuterClass.internal_static_GadgetCrucibleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetCrucibleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder
        public int getMpPlayId() {
            return this.mpPlayId_;
        }

        @Override // emu.grasscutter.net.proto.GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder
        public int getPrepareEndTime() {
            return this.prepareEndTime_;
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
            if (this.mpPlayId_ != 0) {
                output.writeUInt32(1, this.mpPlayId_);
            }
            if (this.prepareEndTime_ != 0) {
                output.writeUInt32(2, this.prepareEndTime_);
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
            if (this.mpPlayId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.mpPlayId_);
            }
            if (this.prepareEndTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.prepareEndTime_);
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
            if (!(obj instanceof GadgetCrucibleInfo)) {
                return equals(obj);
            }
            GadgetCrucibleInfo other = (GadgetCrucibleInfo) obj;
            return getMpPlayId() == other.getMpPlayId() && getPrepareEndTime() == other.getPrepareEndTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getMpPlayId())) + 2)) + getPrepareEndTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static GadgetCrucibleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetCrucibleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetCrucibleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetCrucibleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetCrucibleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GadgetCrucibleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GadgetCrucibleInfo parseFrom(InputStream input) throws IOException {
            return (GadgetCrucibleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetCrucibleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetCrucibleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetCrucibleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GadgetCrucibleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GadgetCrucibleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetCrucibleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GadgetCrucibleInfo parseFrom(CodedInputStream input) throws IOException {
            return (GadgetCrucibleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GadgetCrucibleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GadgetCrucibleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GadgetCrucibleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GadgetCrucibleInfoOuterClass$GadgetCrucibleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GadgetCrucibleInfoOrBuilder {
            private int mpPlayId_;
            private int prepareEndTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GadgetCrucibleInfoOuterClass.internal_static_GadgetCrucibleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GadgetCrucibleInfoOuterClass.internal_static_GadgetCrucibleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GadgetCrucibleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GadgetCrucibleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.mpPlayId_ = 0;
                this.prepareEndTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GadgetCrucibleInfoOuterClass.internal_static_GadgetCrucibleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GadgetCrucibleInfo getDefaultInstanceForType() {
                return GadgetCrucibleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetCrucibleInfo build() {
                GadgetCrucibleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GadgetCrucibleInfo buildPartial() {
                GadgetCrucibleInfo result = new GadgetCrucibleInfo(this);
                result.mpPlayId_ = this.mpPlayId_;
                result.prepareEndTime_ = this.prepareEndTime_;
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
                if (other instanceof GadgetCrucibleInfo) {
                    return mergeFrom((GadgetCrucibleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GadgetCrucibleInfo other) {
                if (other == GadgetCrucibleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getMpPlayId() != 0) {
                    setMpPlayId(other.getMpPlayId());
                }
                if (other.getPrepareEndTime() != 0) {
                    setPrepareEndTime(other.getPrepareEndTime());
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
                GadgetCrucibleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GadgetCrucibleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GadgetCrucibleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder
            public int getMpPlayId() {
                return this.mpPlayId_;
            }

            public Builder setMpPlayId(int value) {
                this.mpPlayId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMpPlayId() {
                this.mpPlayId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GadgetCrucibleInfoOuterClass.GadgetCrucibleInfoOrBuilder
            public int getPrepareEndTime() {
                return this.prepareEndTime_;
            }

            public Builder setPrepareEndTime(int value) {
                this.prepareEndTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearPrepareEndTime() {
                this.prepareEndTime_ = 0;
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

        public static GadgetCrucibleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GadgetCrucibleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GadgetCrucibleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GadgetCrucibleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
