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
import emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordChangeNotifyOuterClass.class */
public final class TowerCurLevelRecordChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%TowerCurLevelRecordChangeNotify.proto\u001a\u0019TowerCurLevelRecord.proto\"O\n\u001fTowerCurLevelRecordChangeNotify\u0012,\n\u000ecurLevelRecord\u0018\u0005 \u0001(\u000b2\u0014.TowerCurLevelRecordB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerCurLevelRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerCurLevelRecordChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_TowerCurLevelRecordChangeNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f861xf8627a84 = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerCurLevelRecordChangeNotify_descriptor, new String[]{"CurLevelRecord"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordChangeNotifyOuterClass$TowerCurLevelRecordChangeNotifyOrBuilder.class */
    public interface TowerCurLevelRecordChangeNotifyOrBuilder extends MessageOrBuilder {
        boolean hasCurLevelRecord();

        TowerCurLevelRecordOuterClass.TowerCurLevelRecord getCurLevelRecord();

        TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder getCurLevelRecordOrBuilder();
    }

    private TowerCurLevelRecordChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordChangeNotifyOuterClass$TowerCurLevelRecordChangeNotify.class */
    public static final class TowerCurLevelRecordChangeNotify extends GeneratedMessageV3 implements TowerCurLevelRecordChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CURLEVELRECORD_FIELD_NUMBER = 5;
        private TowerCurLevelRecordOuterClass.TowerCurLevelRecord curLevelRecord_;
        private byte memoizedIsInitialized;
        private static final TowerCurLevelRecordChangeNotify DEFAULT_INSTANCE = new TowerCurLevelRecordChangeNotify();
        private static final Parser<TowerCurLevelRecordChangeNotify> PARSER = new AbstractParser<TowerCurLevelRecordChangeNotify>() { // from class: emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotify.1
            @Override // com.google.protobuf.Parser
            public TowerCurLevelRecordChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerCurLevelRecordChangeNotify(input, extensionRegistry);
            }
        };

        private TowerCurLevelRecordChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerCurLevelRecordChangeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerCurLevelRecordChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerCurLevelRecordChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder subBuilder = this.curLevelRecord_ != null ? this.curLevelRecord_.toBuilder() : null;
                                this.curLevelRecord_ = (TowerCurLevelRecordOuterClass.TowerCurLevelRecord) input.readMessage(TowerCurLevelRecordOuterClass.TowerCurLevelRecord.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.curLevelRecord_);
                                    this.curLevelRecord_ = subBuilder.buildPartial();
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
            return TowerCurLevelRecordChangeNotifyOuterClass.internal_static_TowerCurLevelRecordChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerCurLevelRecordChangeNotifyOuterClass.f861xf8627a84.ensureFieldAccessorsInitialized(TowerCurLevelRecordChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotifyOrBuilder
        public boolean hasCurLevelRecord() {
            return this.curLevelRecord_ != null;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotifyOrBuilder
        public TowerCurLevelRecordOuterClass.TowerCurLevelRecord getCurLevelRecord() {
            return this.curLevelRecord_ == null ? TowerCurLevelRecordOuterClass.TowerCurLevelRecord.getDefaultInstance() : this.curLevelRecord_;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotifyOrBuilder
        public TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder getCurLevelRecordOrBuilder() {
            return getCurLevelRecord();
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
            if (this.curLevelRecord_ != null) {
                output.writeMessage(5, getCurLevelRecord());
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
            if (this.curLevelRecord_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getCurLevelRecord());
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
            if (!(obj instanceof TowerCurLevelRecordChangeNotify)) {
                return equals(obj);
            }
            TowerCurLevelRecordChangeNotify other = (TowerCurLevelRecordChangeNotify) obj;
            if (hasCurLevelRecord() != other.hasCurLevelRecord()) {
                return false;
            }
            return (!hasCurLevelRecord() || getCurLevelRecord().equals(other.getCurLevelRecord())) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasCurLevelRecord()) {
                hash = (53 * ((37 * hash) + 5)) + getCurLevelRecord().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(InputStream input) throws IOException {
            return (TowerCurLevelRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerCurLevelRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerCurLevelRecordChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerCurLevelRecordChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerCurLevelRecordChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerCurLevelRecordChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (TowerCurLevelRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerCurLevelRecordChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerCurLevelRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerCurLevelRecordChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordChangeNotifyOuterClass$TowerCurLevelRecordChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerCurLevelRecordChangeNotifyOrBuilder {
            private TowerCurLevelRecordOuterClass.TowerCurLevelRecord curLevelRecord_;
            private SingleFieldBuilderV3<TowerCurLevelRecordOuterClass.TowerCurLevelRecord, TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder, TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder> curLevelRecordBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerCurLevelRecordChangeNotifyOuterClass.internal_static_TowerCurLevelRecordChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerCurLevelRecordChangeNotifyOuterClass.f861xf8627a84.ensureFieldAccessorsInitialized(TowerCurLevelRecordChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerCurLevelRecordChangeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecord_ = null;
                } else {
                    this.curLevelRecord_ = null;
                    this.curLevelRecordBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerCurLevelRecordChangeNotifyOuterClass.internal_static_TowerCurLevelRecordChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerCurLevelRecordChangeNotify getDefaultInstanceForType() {
                return TowerCurLevelRecordChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerCurLevelRecordChangeNotify build() {
                TowerCurLevelRecordChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerCurLevelRecordChangeNotify buildPartial() {
                TowerCurLevelRecordChangeNotify result = new TowerCurLevelRecordChangeNotify(this);
                if (this.curLevelRecordBuilder_ == null) {
                    result.curLevelRecord_ = this.curLevelRecord_;
                } else {
                    result.curLevelRecord_ = this.curLevelRecordBuilder_.build();
                }
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
                if (other instanceof TowerCurLevelRecordChangeNotify) {
                    return mergeFrom((TowerCurLevelRecordChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerCurLevelRecordChangeNotify other) {
                if (other == TowerCurLevelRecordChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasCurLevelRecord()) {
                    mergeCurLevelRecord(other.getCurLevelRecord());
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
                TowerCurLevelRecordChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerCurLevelRecordChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerCurLevelRecordChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotifyOrBuilder
            public boolean hasCurLevelRecord() {
                return (this.curLevelRecordBuilder_ == null && this.curLevelRecord_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotifyOrBuilder
            public TowerCurLevelRecordOuterClass.TowerCurLevelRecord getCurLevelRecord() {
                if (this.curLevelRecordBuilder_ == null) {
                    return this.curLevelRecord_ == null ? TowerCurLevelRecordOuterClass.TowerCurLevelRecord.getDefaultInstance() : this.curLevelRecord_;
                }
                return this.curLevelRecordBuilder_.getMessage();
            }

            public Builder setCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord value) {
                if (this.curLevelRecordBuilder_ != null) {
                    this.curLevelRecordBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.curLevelRecord_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder builderForValue) {
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecord_ = builderForValue.build();
                    onChanged();
                } else {
                    this.curLevelRecordBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCurLevelRecord(TowerCurLevelRecordOuterClass.TowerCurLevelRecord value) {
                if (this.curLevelRecordBuilder_ == null) {
                    if (this.curLevelRecord_ != null) {
                        this.curLevelRecord_ = TowerCurLevelRecordOuterClass.TowerCurLevelRecord.newBuilder(this.curLevelRecord_).mergeFrom(value).buildPartial();
                    } else {
                        this.curLevelRecord_ = value;
                    }
                    onChanged();
                } else {
                    this.curLevelRecordBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCurLevelRecord() {
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecord_ = null;
                    onChanged();
                } else {
                    this.curLevelRecord_ = null;
                    this.curLevelRecordBuilder_ = null;
                }
                return this;
            }

            public TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder getCurLevelRecordBuilder() {
                onChanged();
                return getCurLevelRecordFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordChangeNotifyOuterClass.TowerCurLevelRecordChangeNotifyOrBuilder
            public TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder getCurLevelRecordOrBuilder() {
                if (this.curLevelRecordBuilder_ != null) {
                    return this.curLevelRecordBuilder_.getMessageOrBuilder();
                }
                return this.curLevelRecord_ == null ? TowerCurLevelRecordOuterClass.TowerCurLevelRecord.getDefaultInstance() : this.curLevelRecord_;
            }

            private SingleFieldBuilderV3<TowerCurLevelRecordOuterClass.TowerCurLevelRecord, TowerCurLevelRecordOuterClass.TowerCurLevelRecord.Builder, TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder> getCurLevelRecordFieldBuilder() {
                if (this.curLevelRecordBuilder_ == null) {
                    this.curLevelRecordBuilder_ = new SingleFieldBuilderV3<>(getCurLevelRecord(), getParentForChildren(), isClean());
                    this.curLevelRecord_ = null;
                }
                return this.curLevelRecordBuilder_;
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

        public static TowerCurLevelRecordChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerCurLevelRecordChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerCurLevelRecordChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerCurLevelRecordChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerCurLevelRecordOuterClass.getDescriptor();
    }
}
