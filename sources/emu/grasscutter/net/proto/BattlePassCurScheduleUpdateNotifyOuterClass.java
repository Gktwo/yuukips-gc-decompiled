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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BattlePassScheduleOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassCurScheduleUpdateNotifyOuterClass.class */
public final class BattlePassCurScheduleUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n'BattlePassCurScheduleUpdateNotify.proto\u001a\u0018BattlePassSchedule.proto\"i\n!BattlePassCurScheduleUpdateNotify\u0012)\n\fcur_schedule\u0018\u0002 \u0001(\u000b2\u0013.BattlePassSchedule\u0012\u0019\n\u0011have_cur_schedule\u0018\f \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassScheduleOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BattlePassCurScheduleUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_BattlePassCurScheduleUpdateNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f657x99bf377b = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassCurScheduleUpdateNotify_descriptor, new String[]{"CurSchedule", "HaveCurSchedule"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassCurScheduleUpdateNotifyOuterClass$BattlePassCurScheduleUpdateNotifyOrBuilder.class */
    public interface BattlePassCurScheduleUpdateNotifyOrBuilder extends MessageOrBuilder {
        boolean hasCurSchedule();

        BattlePassScheduleOuterClass.BattlePassSchedule getCurSchedule();

        BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder getCurScheduleOrBuilder();

        boolean getHaveCurSchedule();
    }

    private BattlePassCurScheduleUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassCurScheduleUpdateNotifyOuterClass$BattlePassCurScheduleUpdateNotify.class */
    public static final class BattlePassCurScheduleUpdateNotify extends GeneratedMessageV3 implements BattlePassCurScheduleUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CUR_SCHEDULE_FIELD_NUMBER = 2;
        private BattlePassScheduleOuterClass.BattlePassSchedule curSchedule_;
        public static final int HAVE_CUR_SCHEDULE_FIELD_NUMBER = 12;
        private boolean haveCurSchedule_;
        private byte memoizedIsInitialized;
        private static final BattlePassCurScheduleUpdateNotify DEFAULT_INSTANCE = new BattlePassCurScheduleUpdateNotify();
        private static final Parser<BattlePassCurScheduleUpdateNotify> PARSER = new AbstractParser<BattlePassCurScheduleUpdateNotify>() { // from class: emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public BattlePassCurScheduleUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassCurScheduleUpdateNotify(input, extensionRegistry);
            }
        };

        private BattlePassCurScheduleUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassCurScheduleUpdateNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassCurScheduleUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassCurScheduleUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    BattlePassScheduleOuterClass.BattlePassSchedule.Builder subBuilder = this.curSchedule_ != null ? this.curSchedule_.toBuilder() : null;
                                    this.curSchedule_ = (BattlePassScheduleOuterClass.BattlePassSchedule) input.readMessage(BattlePassScheduleOuterClass.BattlePassSchedule.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.curSchedule_);
                                        this.curSchedule_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 96:
                                    this.haveCurSchedule_ = input.readBool();
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
            return BattlePassCurScheduleUpdateNotifyOuterClass.internal_static_BattlePassCurScheduleUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassCurScheduleUpdateNotifyOuterClass.f657x99bf377b.ensureFieldAccessorsInitialized(BattlePassCurScheduleUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
        public boolean hasCurSchedule() {
            return this.curSchedule_ != null;
        }

        @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
        public BattlePassScheduleOuterClass.BattlePassSchedule getCurSchedule() {
            return this.curSchedule_ == null ? BattlePassScheduleOuterClass.BattlePassSchedule.getDefaultInstance() : this.curSchedule_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
        public BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder getCurScheduleOrBuilder() {
            return getCurSchedule();
        }

        @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
        public boolean getHaveCurSchedule() {
            return this.haveCurSchedule_;
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
            if (this.curSchedule_ != null) {
                output.writeMessage(2, getCurSchedule());
            }
            if (this.haveCurSchedule_) {
                output.writeBool(12, this.haveCurSchedule_);
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
            if (this.curSchedule_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getCurSchedule());
            }
            if (this.haveCurSchedule_) {
                size2 += CodedOutputStream.computeBoolSize(12, this.haveCurSchedule_);
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
            if (!(obj instanceof BattlePassCurScheduleUpdateNotify)) {
                return equals(obj);
            }
            BattlePassCurScheduleUpdateNotify other = (BattlePassCurScheduleUpdateNotify) obj;
            if (hasCurSchedule() != other.hasCurSchedule()) {
                return false;
            }
            return (!hasCurSchedule() || getCurSchedule().equals(other.getCurSchedule())) && getHaveCurSchedule() == other.getHaveCurSchedule() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasCurSchedule()) {
                hash = (53 * ((37 * hash) + 2)) + getCurSchedule().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + Internal.hashBoolean(getHaveCurSchedule()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(InputStream input) throws IOException {
            return (BattlePassCurScheduleUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassCurScheduleUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassCurScheduleUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassCurScheduleUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassCurScheduleUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassCurScheduleUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassCurScheduleUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassCurScheduleUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassCurScheduleUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassCurScheduleUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassCurScheduleUpdateNotifyOuterClass$BattlePassCurScheduleUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassCurScheduleUpdateNotifyOrBuilder {
            private BattlePassScheduleOuterClass.BattlePassSchedule curSchedule_;
            private SingleFieldBuilderV3<BattlePassScheduleOuterClass.BattlePassSchedule, BattlePassScheduleOuterClass.BattlePassSchedule.Builder, BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder> curScheduleBuilder_;
            private boolean haveCurSchedule_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassCurScheduleUpdateNotifyOuterClass.internal_static_BattlePassCurScheduleUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassCurScheduleUpdateNotifyOuterClass.f657x99bf377b.ensureFieldAccessorsInitialized(BattlePassCurScheduleUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassCurScheduleUpdateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.curScheduleBuilder_ == null) {
                    this.curSchedule_ = null;
                } else {
                    this.curSchedule_ = null;
                    this.curScheduleBuilder_ = null;
                }
                this.haveCurSchedule_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BattlePassCurScheduleUpdateNotifyOuterClass.internal_static_BattlePassCurScheduleUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassCurScheduleUpdateNotify getDefaultInstanceForType() {
                return BattlePassCurScheduleUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassCurScheduleUpdateNotify build() {
                BattlePassCurScheduleUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassCurScheduleUpdateNotify buildPartial() {
                BattlePassCurScheduleUpdateNotify result = new BattlePassCurScheduleUpdateNotify(this);
                if (this.curScheduleBuilder_ == null) {
                    result.curSchedule_ = this.curSchedule_;
                } else {
                    result.curSchedule_ = this.curScheduleBuilder_.build();
                }
                result.haveCurSchedule_ = this.haveCurSchedule_;
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
                if (other instanceof BattlePassCurScheduleUpdateNotify) {
                    return mergeFrom((BattlePassCurScheduleUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassCurScheduleUpdateNotify other) {
                if (other == BattlePassCurScheduleUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasCurSchedule()) {
                    mergeCurSchedule(other.getCurSchedule());
                }
                if (other.getHaveCurSchedule()) {
                    setHaveCurSchedule(other.getHaveCurSchedule());
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
                BattlePassCurScheduleUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassCurScheduleUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassCurScheduleUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
            public boolean hasCurSchedule() {
                return (this.curScheduleBuilder_ == null && this.curSchedule_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
            public BattlePassScheduleOuterClass.BattlePassSchedule getCurSchedule() {
                if (this.curScheduleBuilder_ == null) {
                    return this.curSchedule_ == null ? BattlePassScheduleOuterClass.BattlePassSchedule.getDefaultInstance() : this.curSchedule_;
                }
                return this.curScheduleBuilder_.getMessage();
            }

            public Builder setCurSchedule(BattlePassScheduleOuterClass.BattlePassSchedule value) {
                if (this.curScheduleBuilder_ != null) {
                    this.curScheduleBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.curSchedule_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCurSchedule(BattlePassScheduleOuterClass.BattlePassSchedule.Builder builderForValue) {
                if (this.curScheduleBuilder_ == null) {
                    this.curSchedule_ = builderForValue.build();
                    onChanged();
                } else {
                    this.curScheduleBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCurSchedule(BattlePassScheduleOuterClass.BattlePassSchedule value) {
                if (this.curScheduleBuilder_ == null) {
                    if (this.curSchedule_ != null) {
                        this.curSchedule_ = BattlePassScheduleOuterClass.BattlePassSchedule.newBuilder(this.curSchedule_).mergeFrom(value).buildPartial();
                    } else {
                        this.curSchedule_ = value;
                    }
                    onChanged();
                } else {
                    this.curScheduleBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCurSchedule() {
                if (this.curScheduleBuilder_ == null) {
                    this.curSchedule_ = null;
                    onChanged();
                } else {
                    this.curSchedule_ = null;
                    this.curScheduleBuilder_ = null;
                }
                return this;
            }

            public BattlePassScheduleOuterClass.BattlePassSchedule.Builder getCurScheduleBuilder() {
                onChanged();
                return getCurScheduleFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
            public BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder getCurScheduleOrBuilder() {
                if (this.curScheduleBuilder_ != null) {
                    return this.curScheduleBuilder_.getMessageOrBuilder();
                }
                return this.curSchedule_ == null ? BattlePassScheduleOuterClass.BattlePassSchedule.getDefaultInstance() : this.curSchedule_;
            }

            private SingleFieldBuilderV3<BattlePassScheduleOuterClass.BattlePassSchedule, BattlePassScheduleOuterClass.BattlePassSchedule.Builder, BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder> getCurScheduleFieldBuilder() {
                if (this.curScheduleBuilder_ == null) {
                    this.curScheduleBuilder_ = new SingleFieldBuilderV3<>(getCurSchedule(), getParentForChildren(), isClean());
                    this.curSchedule_ = null;
                }
                return this.curScheduleBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BattlePassCurScheduleUpdateNotifyOuterClass.BattlePassCurScheduleUpdateNotifyOrBuilder
            public boolean getHaveCurSchedule() {
                return this.haveCurSchedule_;
            }

            public Builder setHaveCurSchedule(boolean value) {
                this.haveCurSchedule_ = value;
                onChanged();
                return this;
            }

            public Builder clearHaveCurSchedule() {
                this.haveCurSchedule_ = false;
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

        public static BattlePassCurScheduleUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassCurScheduleUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassCurScheduleUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassCurScheduleUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassScheduleOuterClass.getDescriptor();
    }
}
