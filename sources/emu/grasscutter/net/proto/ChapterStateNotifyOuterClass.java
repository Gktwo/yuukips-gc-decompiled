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
import emu.grasscutter.net.proto.ChapterStateOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass.class */
public final class ChapterStateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018ChapterStateNotify.proto\u001a\u0012ChapterState.proto\"Æ\u0002\n\u0012ChapterStateNotify\u0012<\n\u000fneedPlayerLevel\u0018\u0002 \u0001(\u000b2#.ChapterStateNotify.NeedPlayerLevel\u00128\n\rneedBeginTime\u0018\t \u0001(\u000b2!.ChapterStateNotify.NeedBeginTime\u0012#\n\fchapterState\u0018\r \u0001(\u000e2\r.ChapterState\u0012\u0011\n\tchapterId\u0018\u000f \u0001(\r\u001aA\n\u000fNeedPlayerLevel\u0012\u001d\n\u0015configNeedPlayerLevel\u0018\u0004 \u0001(\r\u0012\u000f\n\u0007isLimit\u0018\u000e \u0001(\b\u001a=\n\rNeedBeginTime\u0012\u001b\n\u0013configNeedBeginTime\u0018\u0005 \u0001(\r\u0012\u000f\n\u0007isLimit\u0018\u0004 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChapterStateOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ChapterStateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChapterStateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChapterStateNotify_descriptor, new String[]{"NeedPlayerLevel", "NeedBeginTime", "ChapterState", "ChapterId"});
    private static final Descriptors.Descriptor internal_static_ChapterStateNotify_NeedPlayerLevel_descriptor = internal_static_ChapterStateNotify_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ChapterStateNotify_NeedPlayerLevel_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f673x914871c2 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChapterStateNotify_NeedPlayerLevel_descriptor, new String[]{"ConfigNeedPlayerLevel", "IsLimit"});
    private static final Descriptors.Descriptor internal_static_ChapterStateNotify_NeedBeginTime_descriptor = internal_static_ChapterStateNotify_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_ChapterStateNotify_NeedBeginTime_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f674xbfb0fb2f = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChapterStateNotify_NeedBeginTime_descriptor, new String[]{"ConfigNeedBeginTime", "IsLimit"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotifyOrBuilder.class */
    public interface ChapterStateNotifyOrBuilder extends MessageOrBuilder {
        boolean hasNeedPlayerLevel();

        ChapterStateNotify.NeedPlayerLevel getNeedPlayerLevel();

        ChapterStateNotify.NeedPlayerLevelOrBuilder getNeedPlayerLevelOrBuilder();

        boolean hasNeedBeginTime();

        ChapterStateNotify.NeedBeginTime getNeedBeginTime();

        ChapterStateNotify.NeedBeginTimeOrBuilder getNeedBeginTimeOrBuilder();

        int getChapterStateValue();

        ChapterStateOuterClass.ChapterState getChapterState();

        int getChapterId();
    }

    private ChapterStateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify.class */
    public static final class ChapterStateNotify extends GeneratedMessageV3 implements ChapterStateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NEEDPLAYERLEVEL_FIELD_NUMBER = 2;
        private NeedPlayerLevel needPlayerLevel_;
        public static final int NEEDBEGINTIME_FIELD_NUMBER = 9;
        private NeedBeginTime needBeginTime_;
        public static final int CHAPTERSTATE_FIELD_NUMBER = 13;
        private int chapterState_;
        public static final int CHAPTERID_FIELD_NUMBER = 15;
        private int chapterId_;
        private byte memoizedIsInitialized;
        private static final ChapterStateNotify DEFAULT_INSTANCE = new ChapterStateNotify();
        private static final Parser<ChapterStateNotify> PARSER = new AbstractParser<ChapterStateNotify>() { // from class: emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.1
            @Override // com.google.protobuf.Parser
            public ChapterStateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChapterStateNotify(input, extensionRegistry);
            }
        };

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify$NeedBeginTimeOrBuilder.class */
        public interface NeedBeginTimeOrBuilder extends MessageOrBuilder {
            int getConfigNeedBeginTime();

            boolean getIsLimit();
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify$NeedPlayerLevelOrBuilder.class */
        public interface NeedPlayerLevelOrBuilder extends MessageOrBuilder {
            int getConfigNeedPlayerLevel();

            boolean getIsLimit();
        }

        private ChapterStateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChapterStateNotify() {
            this.memoizedIsInitialized = -1;
            this.chapterState_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChapterStateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChapterStateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                NeedPlayerLevel.Builder subBuilder = this.needPlayerLevel_ != null ? this.needPlayerLevel_.toBuilder() : null;
                                this.needPlayerLevel_ = (NeedPlayerLevel) input.readMessage(NeedPlayerLevel.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.needPlayerLevel_);
                                    this.needPlayerLevel_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 74:
                                NeedBeginTime.Builder subBuilder2 = this.needBeginTime_ != null ? this.needBeginTime_.toBuilder() : null;
                                this.needBeginTime_ = (NeedBeginTime) input.readMessage(NeedBeginTime.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.needBeginTime_);
                                    this.needBeginTime_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 104:
                                this.chapterState_ = input.readEnum();
                                break;
                            case 120:
                                this.chapterId_ = input.readUInt32();
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
            return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ChapterStateNotify.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify$NeedPlayerLevel.class */
        public static final class NeedPlayerLevel extends GeneratedMessageV3 implements NeedPlayerLevelOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int CONFIGNEEDPLAYERLEVEL_FIELD_NUMBER = 4;
            private int configNeedPlayerLevel_;
            public static final int ISLIMIT_FIELD_NUMBER = 14;
            private boolean isLimit_;
            private byte memoizedIsInitialized;
            private static final NeedPlayerLevel DEFAULT_INSTANCE = new NeedPlayerLevel();
            private static final Parser<NeedPlayerLevel> PARSER = new AbstractParser<NeedPlayerLevel>() { // from class: emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedPlayerLevel.1
                @Override // com.google.protobuf.Parser
                public NeedPlayerLevel parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new NeedPlayerLevel(input, extensionRegistry);
                }
            };

            private NeedPlayerLevel(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private NeedPlayerLevel() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new NeedPlayerLevel();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private NeedPlayerLevel(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.configNeedPlayerLevel_ = input.readUInt32();
                                    break;
                                case 112:
                                    this.isLimit_ = input.readBool();
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
                return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_NeedPlayerLevel_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChapterStateNotifyOuterClass.f673x914871c2.ensureFieldAccessorsInitialized(NeedPlayerLevel.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedPlayerLevelOrBuilder
            public int getConfigNeedPlayerLevel() {
                return this.configNeedPlayerLevel_;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedPlayerLevelOrBuilder
            public boolean getIsLimit() {
                return this.isLimit_;
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
                if (this.configNeedPlayerLevel_ != 0) {
                    output.writeUInt32(4, this.configNeedPlayerLevel_);
                }
                if (this.isLimit_) {
                    output.writeBool(14, this.isLimit_);
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
                if (this.configNeedPlayerLevel_ != 0) {
                    size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.configNeedPlayerLevel_);
                }
                if (this.isLimit_) {
                    size2 += CodedOutputStream.computeBoolSize(14, this.isLimit_);
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
                if (!(obj instanceof NeedPlayerLevel)) {
                    return equals(obj);
                }
                NeedPlayerLevel other = (NeedPlayerLevel) obj;
                return getConfigNeedPlayerLevel() == other.getConfigNeedPlayerLevel() && getIsLimit() == other.getIsLimit() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getConfigNeedPlayerLevel())) + 14)) + Internal.hashBoolean(getIsLimit()))) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash;
                return hash;
            }

            public static NeedPlayerLevel parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static NeedPlayerLevel parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static NeedPlayerLevel parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static NeedPlayerLevel parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static NeedPlayerLevel parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static NeedPlayerLevel parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static NeedPlayerLevel parseFrom(InputStream input) throws IOException {
                return (NeedPlayerLevel) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static NeedPlayerLevel parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NeedPlayerLevel) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static NeedPlayerLevel parseDelimitedFrom(InputStream input) throws IOException {
                return (NeedPlayerLevel) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static NeedPlayerLevel parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NeedPlayerLevel) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static NeedPlayerLevel parseFrom(CodedInputStream input) throws IOException {
                return (NeedPlayerLevel) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static NeedPlayerLevel parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NeedPlayerLevel) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(NeedPlayerLevel prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify$NeedPlayerLevel$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NeedPlayerLevelOrBuilder {
                private int configNeedPlayerLevel_;
                private boolean isLimit_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_NeedPlayerLevel_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return ChapterStateNotifyOuterClass.f673x914871c2.ensureFieldAccessorsInitialized(NeedPlayerLevel.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (NeedPlayerLevel.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.configNeedPlayerLevel_ = 0;
                    this.isLimit_ = false;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_NeedPlayerLevel_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public NeedPlayerLevel getDefaultInstanceForType() {
                    return NeedPlayerLevel.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NeedPlayerLevel build() {
                    NeedPlayerLevel result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NeedPlayerLevel buildPartial() {
                    NeedPlayerLevel result = new NeedPlayerLevel(this);
                    result.configNeedPlayerLevel_ = this.configNeedPlayerLevel_;
                    result.isLimit_ = this.isLimit_;
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
                    if (other instanceof NeedPlayerLevel) {
                        return mergeFrom((NeedPlayerLevel) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(NeedPlayerLevel other) {
                    if (other == NeedPlayerLevel.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getConfigNeedPlayerLevel() != 0) {
                        setConfigNeedPlayerLevel(other.getConfigNeedPlayerLevel());
                    }
                    if (other.getIsLimit()) {
                        setIsLimit(other.getIsLimit());
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
                    NeedPlayerLevel parsedMessage = null;
                    try {
                        try {
                            parsedMessage = NeedPlayerLevel.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (NeedPlayerLevel) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedPlayerLevelOrBuilder
                public int getConfigNeedPlayerLevel() {
                    return this.configNeedPlayerLevel_;
                }

                public Builder setConfigNeedPlayerLevel(int value) {
                    this.configNeedPlayerLevel_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearConfigNeedPlayerLevel() {
                    this.configNeedPlayerLevel_ = 0;
                    onChanged();
                    return this;
                }

                @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedPlayerLevelOrBuilder
                public boolean getIsLimit() {
                    return this.isLimit_;
                }

                public Builder setIsLimit(boolean value) {
                    this.isLimit_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearIsLimit() {
                    this.isLimit_ = false;
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

            public static NeedPlayerLevel getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<NeedPlayerLevel> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<NeedPlayerLevel> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NeedPlayerLevel getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify$NeedBeginTime.class */
        public static final class NeedBeginTime extends GeneratedMessageV3 implements NeedBeginTimeOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int CONFIGNEEDBEGINTIME_FIELD_NUMBER = 5;
            private int configNeedBeginTime_;
            public static final int ISLIMIT_FIELD_NUMBER = 4;
            private boolean isLimit_;
            private byte memoizedIsInitialized;
            private static final NeedBeginTime DEFAULT_INSTANCE = new NeedBeginTime();
            private static final Parser<NeedBeginTime> PARSER = new AbstractParser<NeedBeginTime>() { // from class: emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedBeginTime.1
                @Override // com.google.protobuf.Parser
                public NeedBeginTime parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new NeedBeginTime(input, extensionRegistry);
                }
            };

            private NeedBeginTime(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private NeedBeginTime() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new NeedBeginTime();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private NeedBeginTime(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.isLimit_ = input.readBool();
                                    break;
                                case 40:
                                    this.configNeedBeginTime_ = input.readUInt32();
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
                return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_NeedBeginTime_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChapterStateNotifyOuterClass.f674xbfb0fb2f.ensureFieldAccessorsInitialized(NeedBeginTime.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedBeginTimeOrBuilder
            public int getConfigNeedBeginTime() {
                return this.configNeedBeginTime_;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedBeginTimeOrBuilder
            public boolean getIsLimit() {
                return this.isLimit_;
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
                if (this.isLimit_) {
                    output.writeBool(4, this.isLimit_);
                }
                if (this.configNeedBeginTime_ != 0) {
                    output.writeUInt32(5, this.configNeedBeginTime_);
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
                if (this.isLimit_) {
                    size2 = 0 + CodedOutputStream.computeBoolSize(4, this.isLimit_);
                }
                if (this.configNeedBeginTime_ != 0) {
                    size2 += CodedOutputStream.computeUInt32Size(5, this.configNeedBeginTime_);
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
                if (!(obj instanceof NeedBeginTime)) {
                    return equals(obj);
                }
                NeedBeginTime other = (NeedBeginTime) obj;
                return getConfigNeedBeginTime() == other.getConfigNeedBeginTime() && getIsLimit() == other.getIsLimit() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getConfigNeedBeginTime())) + 4)) + Internal.hashBoolean(getIsLimit()))) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash;
                return hash;
            }

            public static NeedBeginTime parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static NeedBeginTime parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static NeedBeginTime parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static NeedBeginTime parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static NeedBeginTime parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static NeedBeginTime parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static NeedBeginTime parseFrom(InputStream input) throws IOException {
                return (NeedBeginTime) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static NeedBeginTime parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NeedBeginTime) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static NeedBeginTime parseDelimitedFrom(InputStream input) throws IOException {
                return (NeedBeginTime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static NeedBeginTime parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NeedBeginTime) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static NeedBeginTime parseFrom(CodedInputStream input) throws IOException {
                return (NeedBeginTime) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static NeedBeginTime parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (NeedBeginTime) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(NeedBeginTime prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify$NeedBeginTime$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements NeedBeginTimeOrBuilder {
                private int configNeedBeginTime_;
                private boolean isLimit_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_NeedBeginTime_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return ChapterStateNotifyOuterClass.f674xbfb0fb2f.ensureFieldAccessorsInitialized(NeedBeginTime.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (NeedBeginTime.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.configNeedBeginTime_ = 0;
                    this.isLimit_ = false;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_NeedBeginTime_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public NeedBeginTime getDefaultInstanceForType() {
                    return NeedBeginTime.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NeedBeginTime build() {
                    NeedBeginTime result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NeedBeginTime buildPartial() {
                    NeedBeginTime result = new NeedBeginTime(this);
                    result.configNeedBeginTime_ = this.configNeedBeginTime_;
                    result.isLimit_ = this.isLimit_;
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
                    if (other instanceof NeedBeginTime) {
                        return mergeFrom((NeedBeginTime) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(NeedBeginTime other) {
                    if (other == NeedBeginTime.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getConfigNeedBeginTime() != 0) {
                        setConfigNeedBeginTime(other.getConfigNeedBeginTime());
                    }
                    if (other.getIsLimit()) {
                        setIsLimit(other.getIsLimit());
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
                    NeedBeginTime parsedMessage = null;
                    try {
                        try {
                            parsedMessage = NeedBeginTime.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (NeedBeginTime) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedBeginTimeOrBuilder
                public int getConfigNeedBeginTime() {
                    return this.configNeedBeginTime_;
                }

                public Builder setConfigNeedBeginTime(int value) {
                    this.configNeedBeginTime_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearConfigNeedBeginTime() {
                    this.configNeedBeginTime_ = 0;
                    onChanged();
                    return this;
                }

                @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotify.NeedBeginTimeOrBuilder
                public boolean getIsLimit() {
                    return this.isLimit_;
                }

                public Builder setIsLimit(boolean value) {
                    this.isLimit_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearIsLimit() {
                    this.isLimit_ = false;
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

            public static NeedBeginTime getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<NeedBeginTime> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<NeedBeginTime> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NeedBeginTime getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public boolean hasNeedPlayerLevel() {
            return this.needPlayerLevel_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public NeedPlayerLevel getNeedPlayerLevel() {
            return this.needPlayerLevel_ == null ? NeedPlayerLevel.getDefaultInstance() : this.needPlayerLevel_;
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public NeedPlayerLevelOrBuilder getNeedPlayerLevelOrBuilder() {
            return getNeedPlayerLevel();
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public boolean hasNeedBeginTime() {
            return this.needBeginTime_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public NeedBeginTime getNeedBeginTime() {
            return this.needBeginTime_ == null ? NeedBeginTime.getDefaultInstance() : this.needBeginTime_;
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public NeedBeginTimeOrBuilder getNeedBeginTimeOrBuilder() {
            return getNeedBeginTime();
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public int getChapterStateValue() {
            return this.chapterState_;
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public ChapterStateOuterClass.ChapterState getChapterState() {
            ChapterStateOuterClass.ChapterState result = ChapterStateOuterClass.ChapterState.valueOf(this.chapterState_);
            return result == null ? ChapterStateOuterClass.ChapterState.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
        public int getChapterId() {
            return this.chapterId_;
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
            if (this.needPlayerLevel_ != null) {
                output.writeMessage(2, getNeedPlayerLevel());
            }
            if (this.needBeginTime_ != null) {
                output.writeMessage(9, getNeedBeginTime());
            }
            if (this.chapterState_ != ChapterStateOuterClass.ChapterState.CHAPTER_STATE_NONE.getNumber()) {
                output.writeEnum(13, this.chapterState_);
            }
            if (this.chapterId_ != 0) {
                output.writeUInt32(15, this.chapterId_);
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
            if (this.needPlayerLevel_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getNeedPlayerLevel());
            }
            if (this.needBeginTime_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getNeedBeginTime());
            }
            if (this.chapterState_ != ChapterStateOuterClass.ChapterState.CHAPTER_STATE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(13, this.chapterState_);
            }
            if (this.chapterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.chapterId_);
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
            if (!(obj instanceof ChapterStateNotify)) {
                return equals(obj);
            }
            ChapterStateNotify other = (ChapterStateNotify) obj;
            if (hasNeedPlayerLevel() != other.hasNeedPlayerLevel()) {
                return false;
            }
            if ((!hasNeedPlayerLevel() || getNeedPlayerLevel().equals(other.getNeedPlayerLevel())) && hasNeedBeginTime() == other.hasNeedBeginTime()) {
                return (!hasNeedBeginTime() || getNeedBeginTime().equals(other.getNeedBeginTime())) && this.chapterState_ == other.chapterState_ && getChapterId() == other.getChapterId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasNeedPlayerLevel()) {
                hash = (53 * ((37 * hash) + 2)) + getNeedPlayerLevel().hashCode();
            }
            if (hasNeedBeginTime()) {
                hash = (53 * ((37 * hash) + 9)) + getNeedBeginTime().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 13)) + this.chapterState_)) + 15)) + getChapterId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChapterStateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChapterStateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChapterStateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChapterStateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChapterStateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChapterStateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChapterStateNotify parseFrom(InputStream input) throws IOException {
            return (ChapterStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChapterStateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChapterStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChapterStateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (ChapterStateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChapterStateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChapterStateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChapterStateNotify parseFrom(CodedInputStream input) throws IOException {
            return (ChapterStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChapterStateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChapterStateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChapterStateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChapterStateNotifyOuterClass$ChapterStateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChapterStateNotifyOrBuilder {
            private NeedPlayerLevel needPlayerLevel_;
            private SingleFieldBuilderV3<NeedPlayerLevel, NeedPlayerLevel.Builder, NeedPlayerLevelOrBuilder> needPlayerLevelBuilder_;
            private NeedBeginTime needBeginTime_;
            private SingleFieldBuilderV3<NeedBeginTime, NeedBeginTime.Builder, NeedBeginTimeOrBuilder> needBeginTimeBuilder_;
            private int chapterState_ = 0;
            private int chapterId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(ChapterStateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChapterStateNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.needPlayerLevelBuilder_ == null) {
                    this.needPlayerLevel_ = null;
                } else {
                    this.needPlayerLevel_ = null;
                    this.needPlayerLevelBuilder_ = null;
                }
                if (this.needBeginTimeBuilder_ == null) {
                    this.needBeginTime_ = null;
                } else {
                    this.needBeginTime_ = null;
                    this.needBeginTimeBuilder_ = null;
                }
                this.chapterState_ = 0;
                this.chapterId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChapterStateNotifyOuterClass.internal_static_ChapterStateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChapterStateNotify getDefaultInstanceForType() {
                return ChapterStateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChapterStateNotify build() {
                ChapterStateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChapterStateNotify buildPartial() {
                ChapterStateNotify result = new ChapterStateNotify(this);
                if (this.needPlayerLevelBuilder_ == null) {
                    result.needPlayerLevel_ = this.needPlayerLevel_;
                } else {
                    result.needPlayerLevel_ = this.needPlayerLevelBuilder_.build();
                }
                if (this.needBeginTimeBuilder_ == null) {
                    result.needBeginTime_ = this.needBeginTime_;
                } else {
                    result.needBeginTime_ = this.needBeginTimeBuilder_.build();
                }
                result.chapterState_ = this.chapterState_;
                result.chapterId_ = this.chapterId_;
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
                if (other instanceof ChapterStateNotify) {
                    return mergeFrom((ChapterStateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChapterStateNotify other) {
                if (other == ChapterStateNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.hasNeedPlayerLevel()) {
                    mergeNeedPlayerLevel(other.getNeedPlayerLevel());
                }
                if (other.hasNeedBeginTime()) {
                    mergeNeedBeginTime(other.getNeedBeginTime());
                }
                if (other.chapterState_ != 0) {
                    setChapterStateValue(other.getChapterStateValue());
                }
                if (other.getChapterId() != 0) {
                    setChapterId(other.getChapterId());
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
                ChapterStateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChapterStateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChapterStateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public boolean hasNeedPlayerLevel() {
                return (this.needPlayerLevelBuilder_ == null && this.needPlayerLevel_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public NeedPlayerLevel getNeedPlayerLevel() {
                if (this.needPlayerLevelBuilder_ == null) {
                    return this.needPlayerLevel_ == null ? NeedPlayerLevel.getDefaultInstance() : this.needPlayerLevel_;
                }
                return this.needPlayerLevelBuilder_.getMessage();
            }

            public Builder setNeedPlayerLevel(NeedPlayerLevel value) {
                if (this.needPlayerLevelBuilder_ != null) {
                    this.needPlayerLevelBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.needPlayerLevel_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setNeedPlayerLevel(NeedPlayerLevel.Builder builderForValue) {
                if (this.needPlayerLevelBuilder_ == null) {
                    this.needPlayerLevel_ = builderForValue.build();
                    onChanged();
                } else {
                    this.needPlayerLevelBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeNeedPlayerLevel(NeedPlayerLevel value) {
                if (this.needPlayerLevelBuilder_ == null) {
                    if (this.needPlayerLevel_ != null) {
                        this.needPlayerLevel_ = NeedPlayerLevel.newBuilder(this.needPlayerLevel_).mergeFrom(value).buildPartial();
                    } else {
                        this.needPlayerLevel_ = value;
                    }
                    onChanged();
                } else {
                    this.needPlayerLevelBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearNeedPlayerLevel() {
                if (this.needPlayerLevelBuilder_ == null) {
                    this.needPlayerLevel_ = null;
                    onChanged();
                } else {
                    this.needPlayerLevel_ = null;
                    this.needPlayerLevelBuilder_ = null;
                }
                return this;
            }

            public NeedPlayerLevel.Builder getNeedPlayerLevelBuilder() {
                onChanged();
                return getNeedPlayerLevelFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public NeedPlayerLevelOrBuilder getNeedPlayerLevelOrBuilder() {
                if (this.needPlayerLevelBuilder_ != null) {
                    return this.needPlayerLevelBuilder_.getMessageOrBuilder();
                }
                return this.needPlayerLevel_ == null ? NeedPlayerLevel.getDefaultInstance() : this.needPlayerLevel_;
            }

            private SingleFieldBuilderV3<NeedPlayerLevel, NeedPlayerLevel.Builder, NeedPlayerLevelOrBuilder> getNeedPlayerLevelFieldBuilder() {
                if (this.needPlayerLevelBuilder_ == null) {
                    this.needPlayerLevelBuilder_ = new SingleFieldBuilderV3<>(getNeedPlayerLevel(), getParentForChildren(), isClean());
                    this.needPlayerLevel_ = null;
                }
                return this.needPlayerLevelBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public boolean hasNeedBeginTime() {
                return (this.needBeginTimeBuilder_ == null && this.needBeginTime_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public NeedBeginTime getNeedBeginTime() {
                if (this.needBeginTimeBuilder_ == null) {
                    return this.needBeginTime_ == null ? NeedBeginTime.getDefaultInstance() : this.needBeginTime_;
                }
                return this.needBeginTimeBuilder_.getMessage();
            }

            public Builder setNeedBeginTime(NeedBeginTime value) {
                if (this.needBeginTimeBuilder_ != null) {
                    this.needBeginTimeBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.needBeginTime_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setNeedBeginTime(NeedBeginTime.Builder builderForValue) {
                if (this.needBeginTimeBuilder_ == null) {
                    this.needBeginTime_ = builderForValue.build();
                    onChanged();
                } else {
                    this.needBeginTimeBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeNeedBeginTime(NeedBeginTime value) {
                if (this.needBeginTimeBuilder_ == null) {
                    if (this.needBeginTime_ != null) {
                        this.needBeginTime_ = NeedBeginTime.newBuilder(this.needBeginTime_).mergeFrom(value).buildPartial();
                    } else {
                        this.needBeginTime_ = value;
                    }
                    onChanged();
                } else {
                    this.needBeginTimeBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearNeedBeginTime() {
                if (this.needBeginTimeBuilder_ == null) {
                    this.needBeginTime_ = null;
                    onChanged();
                } else {
                    this.needBeginTime_ = null;
                    this.needBeginTimeBuilder_ = null;
                }
                return this;
            }

            public NeedBeginTime.Builder getNeedBeginTimeBuilder() {
                onChanged();
                return getNeedBeginTimeFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public NeedBeginTimeOrBuilder getNeedBeginTimeOrBuilder() {
                if (this.needBeginTimeBuilder_ != null) {
                    return this.needBeginTimeBuilder_.getMessageOrBuilder();
                }
                return this.needBeginTime_ == null ? NeedBeginTime.getDefaultInstance() : this.needBeginTime_;
            }

            private SingleFieldBuilderV3<NeedBeginTime, NeedBeginTime.Builder, NeedBeginTimeOrBuilder> getNeedBeginTimeFieldBuilder() {
                if (this.needBeginTimeBuilder_ == null) {
                    this.needBeginTimeBuilder_ = new SingleFieldBuilderV3<>(getNeedBeginTime(), getParentForChildren(), isClean());
                    this.needBeginTime_ = null;
                }
                return this.needBeginTimeBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public int getChapterStateValue() {
                return this.chapterState_;
            }

            public Builder setChapterStateValue(int value) {
                this.chapterState_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public ChapterStateOuterClass.ChapterState getChapterState() {
                ChapterStateOuterClass.ChapterState result = ChapterStateOuterClass.ChapterState.valueOf(this.chapterState_);
                return result == null ? ChapterStateOuterClass.ChapterState.UNRECOGNIZED : result;
            }

            public Builder setChapterState(ChapterStateOuterClass.ChapterState value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.chapterState_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearChapterState() {
                this.chapterState_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChapterStateNotifyOuterClass.ChapterStateNotifyOrBuilder
            public int getChapterId() {
                return this.chapterId_;
            }

            public Builder setChapterId(int value) {
                this.chapterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearChapterId() {
                this.chapterId_ = 0;
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

        public static ChapterStateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChapterStateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChapterStateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChapterStateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChapterStateOuterClass.getDescriptor();
    }
}
