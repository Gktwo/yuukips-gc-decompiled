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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BirthdayOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerBirthdayRspOuterClass.class */
public final class SetPlayerBirthdayRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSetPlayerBirthdayRsp.proto\u001a\u000eBirthday.proto\"D\n\u0014SetPlayerBirthdayRsp\u0012\u001b\n\bbirthday\u0018\r \u0001(\u000b2\t.Birthday\u0012\u000f\n\u0007retcode\u0018\u0007 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BirthdayOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetPlayerBirthdayRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetPlayerBirthdayRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetPlayerBirthdayRsp_descriptor, new String[]{"Birthday", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerBirthdayRspOuterClass$SetPlayerBirthdayRspOrBuilder.class */
    public interface SetPlayerBirthdayRspOrBuilder extends MessageOrBuilder {
        boolean hasBirthday();

        BirthdayOuterClass.Birthday getBirthday();

        BirthdayOuterClass.BirthdayOrBuilder getBirthdayOrBuilder();

        int getRetcode();
    }

    private SetPlayerBirthdayRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerBirthdayRspOuterClass$SetPlayerBirthdayRsp.class */
    public static final class SetPlayerBirthdayRsp extends GeneratedMessageV3 implements SetPlayerBirthdayRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BIRTHDAY_FIELD_NUMBER = 13;
        private BirthdayOuterClass.Birthday birthday_;
        public static final int RETCODE_FIELD_NUMBER = 7;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final SetPlayerBirthdayRsp DEFAULT_INSTANCE = new SetPlayerBirthdayRsp();
        private static final Parser<SetPlayerBirthdayRsp> PARSER = new AbstractParser<SetPlayerBirthdayRsp>() { // from class: emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRsp.1
            @Override // com.google.protobuf.Parser
            public SetPlayerBirthdayRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetPlayerBirthdayRsp(input, extensionRegistry);
            }
        };

        private SetPlayerBirthdayRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetPlayerBirthdayRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetPlayerBirthdayRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetPlayerBirthdayRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 106:
                                    BirthdayOuterClass.Birthday.Builder subBuilder = this.birthday_ != null ? this.birthday_.toBuilder() : null;
                                    this.birthday_ = (BirthdayOuterClass.Birthday) input.readMessage(BirthdayOuterClass.Birthday.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.birthday_);
                                        this.birthday_ = subBuilder.buildPartial();
                                        break;
                                    }
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
            return SetPlayerBirthdayRspOuterClass.internal_static_SetPlayerBirthdayRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetPlayerBirthdayRspOuterClass.internal_static_SetPlayerBirthdayRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerBirthdayRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
        public boolean hasBirthday() {
            return this.birthday_ != null;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
        public BirthdayOuterClass.Birthday getBirthday() {
            return this.birthday_ == null ? BirthdayOuterClass.Birthday.getDefaultInstance() : this.birthday_;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
        public BirthdayOuterClass.BirthdayOrBuilder getBirthdayOrBuilder() {
            return getBirthday();
        }

        @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.retcode_ != 0) {
                output.writeInt32(7, this.retcode_);
            }
            if (this.birthday_ != null) {
                output.writeMessage(13, getBirthday());
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(7, this.retcode_);
            }
            if (this.birthday_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getBirthday());
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
            if (!(obj instanceof SetPlayerBirthdayRsp)) {
                return equals(obj);
            }
            SetPlayerBirthdayRsp other = (SetPlayerBirthdayRsp) obj;
            if (hasBirthday() != other.hasBirthday()) {
                return false;
            }
            return (!hasBirthday() || getBirthday().equals(other.getBirthday())) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasBirthday()) {
                hash = (53 * ((37 * hash) + 13)) + getBirthday().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 7)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetPlayerBirthdayRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerBirthdayRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerBirthdayRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerBirthdayRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerBirthdayRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerBirthdayRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerBirthdayRsp parseFrom(InputStream input) throws IOException {
            return (SetPlayerBirthdayRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerBirthdayRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerBirthdayRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerBirthdayRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SetPlayerBirthdayRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetPlayerBirthdayRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerBirthdayRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerBirthdayRsp parseFrom(CodedInputStream input) throws IOException {
            return (SetPlayerBirthdayRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerBirthdayRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerBirthdayRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetPlayerBirthdayRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerBirthdayRspOuterClass$SetPlayerBirthdayRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetPlayerBirthdayRspOrBuilder {
            private BirthdayOuterClass.Birthday birthday_;
            private SingleFieldBuilderV3<BirthdayOuterClass.Birthday, BirthdayOuterClass.Birthday.Builder, BirthdayOuterClass.BirthdayOrBuilder> birthdayBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetPlayerBirthdayRspOuterClass.internal_static_SetPlayerBirthdayRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetPlayerBirthdayRspOuterClass.internal_static_SetPlayerBirthdayRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerBirthdayRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetPlayerBirthdayRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.birthdayBuilder_ == null) {
                    this.birthday_ = null;
                } else {
                    this.birthday_ = null;
                    this.birthdayBuilder_ = null;
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetPlayerBirthdayRspOuterClass.internal_static_SetPlayerBirthdayRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetPlayerBirthdayRsp getDefaultInstanceForType() {
                return SetPlayerBirthdayRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerBirthdayRsp build() {
                SetPlayerBirthdayRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerBirthdayRsp buildPartial() {
                SetPlayerBirthdayRsp result = new SetPlayerBirthdayRsp(this);
                if (this.birthdayBuilder_ == null) {
                    result.birthday_ = this.birthday_;
                } else {
                    result.birthday_ = this.birthdayBuilder_.build();
                }
                result.retcode_ = this.retcode_;
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
                if (other instanceof SetPlayerBirthdayRsp) {
                    return mergeFrom((SetPlayerBirthdayRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetPlayerBirthdayRsp other) {
                if (other == SetPlayerBirthdayRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.hasBirthday()) {
                    mergeBirthday(other.getBirthday());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                SetPlayerBirthdayRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetPlayerBirthdayRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetPlayerBirthdayRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
            public boolean hasBirthday() {
                return (this.birthdayBuilder_ == null && this.birthday_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
            public BirthdayOuterClass.Birthday getBirthday() {
                if (this.birthdayBuilder_ == null) {
                    return this.birthday_ == null ? BirthdayOuterClass.Birthday.getDefaultInstance() : this.birthday_;
                }
                return this.birthdayBuilder_.getMessage();
            }

            public Builder setBirthday(BirthdayOuterClass.Birthday value) {
                if (this.birthdayBuilder_ != null) {
                    this.birthdayBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.birthday_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBirthday(BirthdayOuterClass.Birthday.Builder builderForValue) {
                if (this.birthdayBuilder_ == null) {
                    this.birthday_ = builderForValue.build();
                    onChanged();
                } else {
                    this.birthdayBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBirthday(BirthdayOuterClass.Birthday value) {
                if (this.birthdayBuilder_ == null) {
                    if (this.birthday_ != null) {
                        this.birthday_ = BirthdayOuterClass.Birthday.newBuilder(this.birthday_).mergeFrom(value).buildPartial();
                    } else {
                        this.birthday_ = value;
                    }
                    onChanged();
                } else {
                    this.birthdayBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBirthday() {
                if (this.birthdayBuilder_ == null) {
                    this.birthday_ = null;
                    onChanged();
                } else {
                    this.birthday_ = null;
                    this.birthdayBuilder_ = null;
                }
                return this;
            }

            public BirthdayOuterClass.Birthday.Builder getBirthdayBuilder() {
                onChanged();
                return getBirthdayFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
            public BirthdayOuterClass.BirthdayOrBuilder getBirthdayOrBuilder() {
                if (this.birthdayBuilder_ != null) {
                    return this.birthdayBuilder_.getMessageOrBuilder();
                }
                return this.birthday_ == null ? BirthdayOuterClass.Birthday.getDefaultInstance() : this.birthday_;
            }

            private SingleFieldBuilderV3<BirthdayOuterClass.Birthday, BirthdayOuterClass.Birthday.Builder, BirthdayOuterClass.BirthdayOrBuilder> getBirthdayFieldBuilder() {
                if (this.birthdayBuilder_ == null) {
                    this.birthdayBuilder_ = new SingleFieldBuilderV3<>(getBirthday(), getParentForChildren(), isClean());
                    this.birthday_ = null;
                }
                return this.birthdayBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
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

        public static SetPlayerBirthdayRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetPlayerBirthdayRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetPlayerBirthdayRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetPlayerBirthdayRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BirthdayOuterClass.getDescriptor();
    }
}
