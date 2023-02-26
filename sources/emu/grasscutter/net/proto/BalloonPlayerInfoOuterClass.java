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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonPlayerInfoOuterClass.class */
public final class BalloonPlayerInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017BalloonPlayerInfo.proto\"[\n\u0011BalloonPlayerInfo\u0012\u0018\n\u0010comboDisableTime\u0018\b \u0001(\r\u0012\u0010\n\bcurScore\u0018\r \u0001(\r\u0012\u000b\n\u0003uid\u0018\n \u0001(\r\u0012\r\n\u0005combo\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BalloonPlayerInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BalloonPlayerInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BalloonPlayerInfo_descriptor, new String[]{"ComboDisableTime", "CurScore", "Uid", "Combo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonPlayerInfoOuterClass$BalloonPlayerInfoOrBuilder.class */
    public interface BalloonPlayerInfoOrBuilder extends MessageOrBuilder {
        int getComboDisableTime();

        int getCurScore();

        int getUid();

        int getCombo();
    }

    private BalloonPlayerInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonPlayerInfoOuterClass$BalloonPlayerInfo.class */
    public static final class BalloonPlayerInfo extends GeneratedMessageV3 implements BalloonPlayerInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int COMBODISABLETIME_FIELD_NUMBER = 8;
        private int comboDisableTime_;
        public static final int CURSCORE_FIELD_NUMBER = 13;
        private int curScore_;
        public static final int UID_FIELD_NUMBER = 10;
        private int uid_;
        public static final int COMBO_FIELD_NUMBER = 6;
        private int combo_;
        private byte memoizedIsInitialized;
        private static final BalloonPlayerInfo DEFAULT_INSTANCE = new BalloonPlayerInfo();
        private static final Parser<BalloonPlayerInfo> PARSER = new AbstractParser<BalloonPlayerInfo>() { // from class: emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfo.1
            @Override // com.google.protobuf.Parser
            public BalloonPlayerInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BalloonPlayerInfo(input, extensionRegistry);
            }
        };

        private BalloonPlayerInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BalloonPlayerInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BalloonPlayerInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BalloonPlayerInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.combo_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.comboDisableTime_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.uid_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.curScore_ = input.readUInt32();
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
            return BalloonPlayerInfoOuterClass.internal_static_BalloonPlayerInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BalloonPlayerInfoOuterClass.internal_static_BalloonPlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BalloonPlayerInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
        public int getComboDisableTime() {
            return this.comboDisableTime_;
        }

        @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
        public int getCurScore() {
            return this.curScore_;
        }

        @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
        public int getCombo() {
            return this.combo_;
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
            if (this.combo_ != 0) {
                output.writeUInt32(6, this.combo_);
            }
            if (this.comboDisableTime_ != 0) {
                output.writeUInt32(8, this.comboDisableTime_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(10, this.uid_);
            }
            if (this.curScore_ != 0) {
                output.writeUInt32(13, this.curScore_);
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
            if (this.combo_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.combo_);
            }
            if (this.comboDisableTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.comboDisableTime_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.uid_);
            }
            if (this.curScore_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.curScore_);
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
            if (!(obj instanceof BalloonPlayerInfo)) {
                return equals(obj);
            }
            BalloonPlayerInfo other = (BalloonPlayerInfo) obj;
            return getComboDisableTime() == other.getComboDisableTime() && getCurScore() == other.getCurScore() && getUid() == other.getUid() && getCombo() == other.getCombo() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getComboDisableTime())) + 13)) + getCurScore())) + 10)) + getUid())) + 6)) + getCombo())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BalloonPlayerInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BalloonPlayerInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BalloonPlayerInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BalloonPlayerInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BalloonPlayerInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BalloonPlayerInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BalloonPlayerInfo parseFrom(InputStream input) throws IOException {
            return (BalloonPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BalloonPlayerInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BalloonPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BalloonPlayerInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BalloonPlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BalloonPlayerInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BalloonPlayerInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BalloonPlayerInfo parseFrom(CodedInputStream input) throws IOException {
            return (BalloonPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BalloonPlayerInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BalloonPlayerInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BalloonPlayerInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BalloonPlayerInfoOuterClass$BalloonPlayerInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BalloonPlayerInfoOrBuilder {
            private int comboDisableTime_;
            private int curScore_;
            private int uid_;
            private int combo_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BalloonPlayerInfoOuterClass.internal_static_BalloonPlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BalloonPlayerInfoOuterClass.internal_static_BalloonPlayerInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BalloonPlayerInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BalloonPlayerInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.comboDisableTime_ = 0;
                this.curScore_ = 0;
                this.uid_ = 0;
                this.combo_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BalloonPlayerInfoOuterClass.internal_static_BalloonPlayerInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BalloonPlayerInfo getDefaultInstanceForType() {
                return BalloonPlayerInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BalloonPlayerInfo build() {
                BalloonPlayerInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BalloonPlayerInfo buildPartial() {
                BalloonPlayerInfo result = new BalloonPlayerInfo(this);
                result.comboDisableTime_ = this.comboDisableTime_;
                result.curScore_ = this.curScore_;
                result.uid_ = this.uid_;
                result.combo_ = this.combo_;
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
                if (other instanceof BalloonPlayerInfo) {
                    return mergeFrom((BalloonPlayerInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BalloonPlayerInfo other) {
                if (other == BalloonPlayerInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getComboDisableTime() != 0) {
                    setComboDisableTime(other.getComboDisableTime());
                }
                if (other.getCurScore() != 0) {
                    setCurScore(other.getCurScore());
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.getCombo() != 0) {
                    setCombo(other.getCombo());
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
                BalloonPlayerInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BalloonPlayerInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BalloonPlayerInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
            public int getComboDisableTime() {
                return this.comboDisableTime_;
            }

            public Builder setComboDisableTime(int value) {
                this.comboDisableTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearComboDisableTime() {
                this.comboDisableTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
            public int getCurScore() {
                return this.curScore_;
            }

            public Builder setCurScore(int value) {
                this.curScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurScore() {
                this.curScore_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BalloonPlayerInfoOuterClass.BalloonPlayerInfoOrBuilder
            public int getCombo() {
                return this.combo_;
            }

            public Builder setCombo(int value) {
                this.combo_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombo() {
                this.combo_ = 0;
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

        public static BalloonPlayerInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BalloonPlayerInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BalloonPlayerInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BalloonPlayerInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
