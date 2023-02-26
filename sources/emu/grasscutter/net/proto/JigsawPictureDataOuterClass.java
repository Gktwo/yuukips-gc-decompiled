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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/JigsawPictureDataOuterClass.class */
public final class JigsawPictureDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017JigsawPictureData.proto\"q\n\u0011JigsawPictureData\u0012\u001b\n\u0013Unk3300_DFGHKDBENED\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_FIKPLGJIBGP\u0018\u000b \u0001(\r\u0012\u000e\n\u0006isOpen\u0018\u0004 \u0001(\b\u0012\u0012\n\nisFinished\u0018\b \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_JigsawPictureData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_JigsawPictureData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_JigsawPictureData_descriptor, new String[]{"Unk3300DFGHKDBENED", "Unk3300FIKPLGJIBGP", "IsOpen", "IsFinished"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/JigsawPictureDataOuterClass$JigsawPictureDataOrBuilder.class */
    public interface JigsawPictureDataOrBuilder extends MessageOrBuilder {
        int getUnk3300DFGHKDBENED();

        int getUnk3300FIKPLGJIBGP();

        boolean getIsOpen();

        boolean getIsFinished();
    }

    private JigsawPictureDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/JigsawPictureDataOuterClass$JigsawPictureData.class */
    public static final class JigsawPictureData extends GeneratedMessageV3 implements JigsawPictureDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_DFGHKDBENED_FIELD_NUMBER = 12;
        private int unk3300DFGHKDBENED_;
        public static final int UNK3300_FIKPLGJIBGP_FIELD_NUMBER = 11;
        private int unk3300FIKPLGJIBGP_;
        public static final int ISOPEN_FIELD_NUMBER = 4;
        private boolean isOpen_;
        public static final int ISFINISHED_FIELD_NUMBER = 8;
        private boolean isFinished_;
        private byte memoizedIsInitialized;
        private static final JigsawPictureData DEFAULT_INSTANCE = new JigsawPictureData();
        private static final Parser<JigsawPictureData> PARSER = new AbstractParser<JigsawPictureData>() { // from class: emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureData.1
            @Override // com.google.protobuf.Parser
            public JigsawPictureData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new JigsawPictureData(input, extensionRegistry);
            }
        };

        private JigsawPictureData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private JigsawPictureData() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new JigsawPictureData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private JigsawPictureData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 64:
                                    this.isFinished_ = input.readBool();
                                    break;
                                case 88:
                                    this.unk3300FIKPLGJIBGP_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.unk3300DFGHKDBENED_ = input.readUInt32();
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return JigsawPictureDataOuterClass.internal_static_JigsawPictureData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return JigsawPictureDataOuterClass.internal_static_JigsawPictureData_fieldAccessorTable.ensureFieldAccessorsInitialized(JigsawPictureData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
        public int getUnk3300DFGHKDBENED() {
            return this.unk3300DFGHKDBENED_;
        }

        @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
        public int getUnk3300FIKPLGJIBGP() {
            return this.unk3300FIKPLGJIBGP_;
        }

        @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
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
            if (this.isOpen_) {
                output.writeBool(4, this.isOpen_);
            }
            if (this.isFinished_) {
                output.writeBool(8, this.isFinished_);
            }
            if (this.unk3300FIKPLGJIBGP_ != 0) {
                output.writeUInt32(11, this.unk3300FIKPLGJIBGP_);
            }
            if (this.unk3300DFGHKDBENED_ != 0) {
                output.writeUInt32(12, this.unk3300DFGHKDBENED_);
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
            if (this.isOpen_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(4, this.isOpen_);
            }
            if (this.isFinished_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isFinished_);
            }
            if (this.unk3300FIKPLGJIBGP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.unk3300FIKPLGJIBGP_);
            }
            if (this.unk3300DFGHKDBENED_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300DFGHKDBENED_);
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
            if (!(obj instanceof JigsawPictureData)) {
                return equals(obj);
            }
            JigsawPictureData other = (JigsawPictureData) obj;
            return getUnk3300DFGHKDBENED() == other.getUnk3300DFGHKDBENED() && getUnk3300FIKPLGJIBGP() == other.getUnk3300FIKPLGJIBGP() && getIsOpen() == other.getIsOpen() && getIsFinished() == other.getIsFinished() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getUnk3300DFGHKDBENED())) + 11)) + getUnk3300FIKPLGJIBGP())) + 4)) + Internal.hashBoolean(getIsOpen()))) + 8)) + Internal.hashBoolean(getIsFinished()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static JigsawPictureData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JigsawPictureData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JigsawPictureData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JigsawPictureData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JigsawPictureData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static JigsawPictureData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static JigsawPictureData parseFrom(InputStream input) throws IOException {
            return (JigsawPictureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static JigsawPictureData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JigsawPictureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static JigsawPictureData parseDelimitedFrom(InputStream input) throws IOException {
            return (JigsawPictureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static JigsawPictureData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JigsawPictureData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static JigsawPictureData parseFrom(CodedInputStream input) throws IOException {
            return (JigsawPictureData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static JigsawPictureData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (JigsawPictureData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(JigsawPictureData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/JigsawPictureDataOuterClass$JigsawPictureData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements JigsawPictureDataOrBuilder {
            private int unk3300DFGHKDBENED_;
            private int unk3300FIKPLGJIBGP_;
            private boolean isOpen_;
            private boolean isFinished_;

            public static final Descriptors.Descriptor getDescriptor() {
                return JigsawPictureDataOuterClass.internal_static_JigsawPictureData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return JigsawPictureDataOuterClass.internal_static_JigsawPictureData_fieldAccessorTable.ensureFieldAccessorsInitialized(JigsawPictureData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (JigsawPictureData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300DFGHKDBENED_ = 0;
                this.unk3300FIKPLGJIBGP_ = 0;
                this.isOpen_ = false;
                this.isFinished_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return JigsawPictureDataOuterClass.internal_static_JigsawPictureData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public JigsawPictureData getDefaultInstanceForType() {
                return JigsawPictureData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JigsawPictureData build() {
                JigsawPictureData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public JigsawPictureData buildPartial() {
                JigsawPictureData result = new JigsawPictureData(this);
                result.unk3300DFGHKDBENED_ = this.unk3300DFGHKDBENED_;
                result.unk3300FIKPLGJIBGP_ = this.unk3300FIKPLGJIBGP_;
                result.isOpen_ = this.isOpen_;
                result.isFinished_ = this.isFinished_;
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
                if (other instanceof JigsawPictureData) {
                    return mergeFrom((JigsawPictureData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(JigsawPictureData other) {
                if (other == JigsawPictureData.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300DFGHKDBENED() != 0) {
                    setUnk3300DFGHKDBENED(other.getUnk3300DFGHKDBENED());
                }
                if (other.getUnk3300FIKPLGJIBGP() != 0) {
                    setUnk3300FIKPLGJIBGP(other.getUnk3300FIKPLGJIBGP());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
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
                JigsawPictureData parsedMessage = null;
                try {
                    try {
                        parsedMessage = JigsawPictureData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (JigsawPictureData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
            public int getUnk3300DFGHKDBENED() {
                return this.unk3300DFGHKDBENED_;
            }

            public Builder setUnk3300DFGHKDBENED(int value) {
                this.unk3300DFGHKDBENED_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DFGHKDBENED() {
                this.unk3300DFGHKDBENED_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
            public int getUnk3300FIKPLGJIBGP() {
                return this.unk3300FIKPLGJIBGP_;
            }

            public Builder setUnk3300FIKPLGJIBGP(int value) {
                this.unk3300FIKPLGJIBGP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FIKPLGJIBGP() {
                this.unk3300FIKPLGJIBGP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
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

            @Override // emu.grasscutter.net.proto.JigsawPictureDataOuterClass.JigsawPictureDataOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
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

        public static JigsawPictureData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<JigsawPictureData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<JigsawPictureData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public JigsawPictureData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
