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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieInfoOuterClass.class */
public final class TreasureSeelieInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018TreasureSeelieInfo.proto\"4\n\u0012TreasureSeelieInfo\u0012\u0010\n\bprogress\u0018\u000b \u0001(\r\u0012\f\n\u0004goal\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TreasureSeelieInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TreasureSeelieInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TreasureSeelieInfo_descriptor, new String[]{"Progress", "Goal"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieInfoOuterClass$TreasureSeelieInfoOrBuilder.class */
    public interface TreasureSeelieInfoOrBuilder extends MessageOrBuilder {
        int getProgress();

        int getGoal();
    }

    private TreasureSeelieInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieInfoOuterClass$TreasureSeelieInfo.class */
    public static final class TreasureSeelieInfo extends GeneratedMessageV3 implements TreasureSeelieInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROGRESS_FIELD_NUMBER = 11;
        private int progress_;
        public static final int GOAL_FIELD_NUMBER = 2;
        private int goal_;
        private byte memoizedIsInitialized;
        private static final TreasureSeelieInfo DEFAULT_INSTANCE = new TreasureSeelieInfo();
        private static final Parser<TreasureSeelieInfo> PARSER = new AbstractParser<TreasureSeelieInfo>() { // from class: emu.grasscutter.net.proto.TreasureSeelieInfoOuterClass.TreasureSeelieInfo.1
            @Override // com.google.protobuf.Parser
            public TreasureSeelieInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TreasureSeelieInfo(input, extensionRegistry);
            }
        };

        private TreasureSeelieInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TreasureSeelieInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TreasureSeelieInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TreasureSeelieInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.goal_ = input.readUInt32();
                                break;
                            case 88:
                                this.progress_ = input.readUInt32();
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
            return TreasureSeelieInfoOuterClass.internal_static_TreasureSeelieInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TreasureSeelieInfoOuterClass.internal_static_TreasureSeelieInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureSeelieInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // emu.grasscutter.net.proto.TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder
        public int getGoal() {
            return this.goal_;
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
            if (this.goal_ != 0) {
                output.writeUInt32(2, this.goal_);
            }
            if (this.progress_ != 0) {
                output.writeUInt32(11, this.progress_);
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
            if (this.goal_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.goal_);
            }
            if (this.progress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.progress_);
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
            if (!(obj instanceof TreasureSeelieInfo)) {
                return equals(obj);
            }
            TreasureSeelieInfo other = (TreasureSeelieInfo) obj;
            return getProgress() == other.getProgress() && getGoal() == other.getGoal() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getProgress())) + 2)) + getGoal())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TreasureSeelieInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TreasureSeelieInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TreasureSeelieInfo parseFrom(InputStream input) throws IOException {
            return (TreasureSeelieInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureSeelieInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureSeelieInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TreasureSeelieInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TreasureSeelieInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TreasureSeelieInfo parseFrom(CodedInputStream input) throws IOException {
            return (TreasureSeelieInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TreasureSeelieInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TreasureSeelieInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TreasureSeelieInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TreasureSeelieInfoOuterClass$TreasureSeelieInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TreasureSeelieInfoOrBuilder {
            private int progress_;
            private int goal_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TreasureSeelieInfoOuterClass.internal_static_TreasureSeelieInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TreasureSeelieInfoOuterClass.internal_static_TreasureSeelieInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TreasureSeelieInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TreasureSeelieInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.progress_ = 0;
                this.goal_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TreasureSeelieInfoOuterClass.internal_static_TreasureSeelieInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TreasureSeelieInfo getDefaultInstanceForType() {
                return TreasureSeelieInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureSeelieInfo build() {
                TreasureSeelieInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TreasureSeelieInfo buildPartial() {
                TreasureSeelieInfo result = new TreasureSeelieInfo(this);
                result.progress_ = this.progress_;
                result.goal_ = this.goal_;
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
                if (other instanceof TreasureSeelieInfo) {
                    return mergeFrom((TreasureSeelieInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TreasureSeelieInfo other) {
                if (other == TreasureSeelieInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getProgress() != 0) {
                    setProgress(other.getProgress());
                }
                if (other.getGoal() != 0) {
                    setGoal(other.getGoal());
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
                TreasureSeelieInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TreasureSeelieInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TreasureSeelieInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder
            public int getProgress() {
                return this.progress_;
            }

            public Builder setProgress(int value) {
                this.progress_ = value;
                onChanged();
                return this;
            }

            public Builder clearProgress() {
                this.progress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder
            public int getGoal() {
                return this.goal_;
            }

            public Builder setGoal(int value) {
                this.goal_ = value;
                onChanged();
                return this;
            }

            public Builder clearGoal() {
                this.goal_ = 0;
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

        public static TreasureSeelieInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TreasureSeelieInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TreasureSeelieInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TreasureSeelieInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
