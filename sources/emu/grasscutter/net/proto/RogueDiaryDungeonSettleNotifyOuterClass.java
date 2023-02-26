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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonSettleNotifyOuterClass.class */
public final class RogueDiaryDungeonSettleNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#RogueDiaryDungeonSettleNotify.proto\"X\n\u001dRogueDiaryDungeonSettleNotify\u0012\u0010\n\bisFinish\u0018\u0002 \u0001(\b\u0012\u0013\n\u000bexploreTime\u0018\u0003 \u0001(\r\u0012\u0010\n\bcurRound\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_RogueDiaryDungeonSettleNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueDiaryDungeonSettleNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueDiaryDungeonSettleNotify_descriptor, new String[]{"IsFinish", "ExploreTime", "CurRound"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonSettleNotifyOuterClass$RogueDiaryDungeonSettleNotifyOrBuilder.class */
    public interface RogueDiaryDungeonSettleNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsFinish();

        int getExploreTime();

        int getCurRound();
    }

    private RogueDiaryDungeonSettleNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonSettleNotifyOuterClass$RogueDiaryDungeonSettleNotify.class */
    public static final class RogueDiaryDungeonSettleNotify extends GeneratedMessageV3 implements RogueDiaryDungeonSettleNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISFINISH_FIELD_NUMBER = 2;
        private boolean isFinish_;
        public static final int EXPLORETIME_FIELD_NUMBER = 3;
        private int exploreTime_;
        public static final int CURROUND_FIELD_NUMBER = 12;
        private int curRound_;
        private byte memoizedIsInitialized;
        private static final RogueDiaryDungeonSettleNotify DEFAULT_INSTANCE = new RogueDiaryDungeonSettleNotify();
        private static final Parser<RogueDiaryDungeonSettleNotify> PARSER = new AbstractParser<RogueDiaryDungeonSettleNotify>() { // from class: emu.grasscutter.net.proto.RogueDiaryDungeonSettleNotifyOuterClass.RogueDiaryDungeonSettleNotify.1
            @Override // com.google.protobuf.Parser
            public RogueDiaryDungeonSettleNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueDiaryDungeonSettleNotify(input, extensionRegistry);
            }
        };

        private RogueDiaryDungeonSettleNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueDiaryDungeonSettleNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueDiaryDungeonSettleNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueDiaryDungeonSettleNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.isFinish_ = input.readBool();
                                    break;
                                case 24:
                                    this.exploreTime_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.curRound_ = input.readUInt32();
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
            return RogueDiaryDungeonSettleNotifyOuterClass.internal_static_RogueDiaryDungeonSettleNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueDiaryDungeonSettleNotifyOuterClass.internal_static_RogueDiaryDungeonSettleNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryDungeonSettleNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryDungeonSettleNotifyOuterClass.RogueDiaryDungeonSettleNotifyOrBuilder
        public boolean getIsFinish() {
            return this.isFinish_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryDungeonSettleNotifyOuterClass.RogueDiaryDungeonSettleNotifyOrBuilder
        public int getExploreTime() {
            return this.exploreTime_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryDungeonSettleNotifyOuterClass.RogueDiaryDungeonSettleNotifyOrBuilder
        public int getCurRound() {
            return this.curRound_;
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
            if (this.isFinish_) {
                output.writeBool(2, this.isFinish_);
            }
            if (this.exploreTime_ != 0) {
                output.writeUInt32(3, this.exploreTime_);
            }
            if (this.curRound_ != 0) {
                output.writeUInt32(12, this.curRound_);
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
            if (this.isFinish_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.isFinish_);
            }
            if (this.exploreTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.exploreTime_);
            }
            if (this.curRound_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.curRound_);
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
            if (!(obj instanceof RogueDiaryDungeonSettleNotify)) {
                return equals(obj);
            }
            RogueDiaryDungeonSettleNotify other = (RogueDiaryDungeonSettleNotify) obj;
            return getIsFinish() == other.getIsFinish() && getExploreTime() == other.getExploreTime() && getCurRound() == other.getCurRound() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + Internal.hashBoolean(getIsFinish()))) + 3)) + getExploreTime())) + 12)) + getCurRound())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(InputStream input) throws IOException {
            return (RogueDiaryDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryDungeonSettleNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueDiaryDungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueDiaryDungeonSettleNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryDungeonSettleNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(CodedInputStream input) throws IOException {
            return (RogueDiaryDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryDungeonSettleNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryDungeonSettleNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueDiaryDungeonSettleNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryDungeonSettleNotifyOuterClass$RogueDiaryDungeonSettleNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueDiaryDungeonSettleNotifyOrBuilder {
            private boolean isFinish_;
            private int exploreTime_;
            private int curRound_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueDiaryDungeonSettleNotifyOuterClass.internal_static_RogueDiaryDungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueDiaryDungeonSettleNotifyOuterClass.internal_static_RogueDiaryDungeonSettleNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryDungeonSettleNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueDiaryDungeonSettleNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinish_ = false;
                this.exploreTime_ = 0;
                this.curRound_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueDiaryDungeonSettleNotifyOuterClass.internal_static_RogueDiaryDungeonSettleNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueDiaryDungeonSettleNotify getDefaultInstanceForType() {
                return RogueDiaryDungeonSettleNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryDungeonSettleNotify build() {
                RogueDiaryDungeonSettleNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryDungeonSettleNotify buildPartial() {
                RogueDiaryDungeonSettleNotify result = new RogueDiaryDungeonSettleNotify(this);
                result.isFinish_ = this.isFinish_;
                result.exploreTime_ = this.exploreTime_;
                result.curRound_ = this.curRound_;
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
                if (other instanceof RogueDiaryDungeonSettleNotify) {
                    return mergeFrom((RogueDiaryDungeonSettleNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueDiaryDungeonSettleNotify other) {
                if (other == RogueDiaryDungeonSettleNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinish()) {
                    setIsFinish(other.getIsFinish());
                }
                if (other.getExploreTime() != 0) {
                    setExploreTime(other.getExploreTime());
                }
                if (other.getCurRound() != 0) {
                    setCurRound(other.getCurRound());
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
                RogueDiaryDungeonSettleNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueDiaryDungeonSettleNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueDiaryDungeonSettleNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryDungeonSettleNotifyOuterClass.RogueDiaryDungeonSettleNotifyOrBuilder
            public boolean getIsFinish() {
                return this.isFinish_;
            }

            public Builder setIsFinish(boolean value) {
                this.isFinish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinish() {
                this.isFinish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryDungeonSettleNotifyOuterClass.RogueDiaryDungeonSettleNotifyOrBuilder
            public int getExploreTime() {
                return this.exploreTime_;
            }

            public Builder setExploreTime(int value) {
                this.exploreTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearExploreTime() {
                this.exploreTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryDungeonSettleNotifyOuterClass.RogueDiaryDungeonSettleNotifyOrBuilder
            public int getCurRound() {
                return this.curRound_;
            }

            public Builder setCurRound(int value) {
                this.curRound_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurRound() {
                this.curRound_ = 0;
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

        public static RogueDiaryDungeonSettleNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueDiaryDungeonSettleNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueDiaryDungeonSettleNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueDiaryDungeonSettleNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
