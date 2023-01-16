package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GCGTCTavernChallengeDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataNotifyOuterClass.class */
public final class GCGTCTavernChallengeDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$GCGTCTavernChallengeDataNotify.proto\u001a\u001eGCGTCTavernChallengeData.proto\"Z\n\u001eGCGTCTavernChallengeDataNotify\u00128\n\u0015tavern_challenge_list\u0018\u0005 \u0003(\u000b2\u0019.GCGTCTavernChallengeDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GCGTCTavernChallengeDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GCGTCTavernChallengeDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_GCGTCTavernChallengeDataNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f726x8763fc19 = new GeneratedMessageV3.FieldAccessorTable(internal_static_GCGTCTavernChallengeDataNotify_descriptor, new String[]{"TavernChallengeList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GCGTCTavernChallengeDataNotifyOuterClass$GCGTCTavernChallengeDataNotifyOrBuilder.class */
    public interface GCGTCTavernChallengeDataNotifyOrBuilder extends MessageOrBuilder {
        List<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData> getTavernChallengeListList();

        GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData getTavernChallengeList(int i);

        int getTavernChallengeListCount();

        List<? extends GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder> getTavernChallengeListOrBuilderList();

        GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder getTavernChallengeListOrBuilder(int i);
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
        public static final int TAVERN_CHALLENGE_LIST_FIELD_NUMBER = 5;
        private List<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData> tavernChallengeList_;
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
            this.tavernChallengeList_ = Collections.emptyList();
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
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.tavernChallengeList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.tavernChallengeList_.add((GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData) input.readMessage(GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.tavernChallengeList_ = Collections.unmodifiableList(this.tavernChallengeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GCGTCTavernChallengeDataNotifyOuterClass.internal_static_GCGTCTavernChallengeDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GCGTCTavernChallengeDataNotifyOuterClass.f726x8763fc19.ensureFieldAccessorsInitialized(GCGTCTavernChallengeDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
        public List<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData> getTavernChallengeListList() {
            return this.tavernChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
        public List<? extends GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder> getTavernChallengeListOrBuilderList() {
            return this.tavernChallengeList_;
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
        public int getTavernChallengeListCount() {
            return this.tavernChallengeList_.size();
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
        public GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData getTavernChallengeList(int index) {
            return this.tavernChallengeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
        public GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder getTavernChallengeListOrBuilder(int index) {
            return this.tavernChallengeList_.get(index);
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
            for (int i = 0; i < this.tavernChallengeList_.size(); i++) {
                output.writeMessage(5, this.tavernChallengeList_.get(i));
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
            for (int i = 0; i < this.tavernChallengeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.tavernChallengeList_.get(i));
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
            return getTavernChallengeListList().equals(other.getTavernChallengeListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTavernChallengeListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getTavernChallengeListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
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
            private int bitField0_;
            private List<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData> tavernChallengeList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder> tavernChallengeListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GCGTCTavernChallengeDataNotifyOuterClass.internal_static_GCGTCTavernChallengeDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GCGTCTavernChallengeDataNotifyOuterClass.f726x8763fc19.ensureFieldAccessorsInitialized(GCGTCTavernChallengeDataNotify.class, Builder.class);
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
                    getTavernChallengeListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.tavernChallengeListBuilder_ == null) {
                    this.tavernChallengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.tavernChallengeListBuilder_.clear();
                }
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
                int i = this.bitField0_;
                if (this.tavernChallengeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.tavernChallengeList_ = Collections.unmodifiableList(this.tavernChallengeList_);
                        this.bitField0_ &= -2;
                    }
                    result.tavernChallengeList_ = this.tavernChallengeList_;
                } else {
                    result.tavernChallengeList_ = this.tavernChallengeListBuilder_.build();
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
                if (this.tavernChallengeListBuilder_ == null) {
                    if (!other.tavernChallengeList_.isEmpty()) {
                        if (this.tavernChallengeList_.isEmpty()) {
                            this.tavernChallengeList_ = other.tavernChallengeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTavernChallengeListIsMutable();
                            this.tavernChallengeList_.addAll(other.tavernChallengeList_);
                        }
                        onChanged();
                    }
                } else if (!other.tavernChallengeList_.isEmpty()) {
                    if (this.tavernChallengeListBuilder_.isEmpty()) {
                        this.tavernChallengeListBuilder_.dispose();
                        this.tavernChallengeListBuilder_ = null;
                        this.tavernChallengeList_ = other.tavernChallengeList_;
                        this.bitField0_ &= -2;
                        this.tavernChallengeListBuilder_ = GCGTCTavernChallengeDataNotify.alwaysUseFieldBuilders ? getTavernChallengeListFieldBuilder() : null;
                    } else {
                        this.tavernChallengeListBuilder_.addAllMessages(other.tavernChallengeList_);
                    }
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

            private void ensureTavernChallengeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.tavernChallengeList_ = new ArrayList(this.tavernChallengeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
            public List<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData> getTavernChallengeListList() {
                if (this.tavernChallengeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.tavernChallengeList_);
                }
                return this.tavernChallengeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
            public int getTavernChallengeListCount() {
                if (this.tavernChallengeListBuilder_ == null) {
                    return this.tavernChallengeList_.size();
                }
                return this.tavernChallengeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
            public GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData getTavernChallengeList(int index) {
                if (this.tavernChallengeListBuilder_ == null) {
                    return this.tavernChallengeList_.get(index);
                }
                return this.tavernChallengeListBuilder_.getMessage(index);
            }

            public Builder setTavernChallengeList(int index, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData value) {
                if (this.tavernChallengeListBuilder_ != null) {
                    this.tavernChallengeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTavernChallengeListIsMutable();
                    this.tavernChallengeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTavernChallengeList(int index, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder builderForValue) {
                if (this.tavernChallengeListBuilder_ == null) {
                    ensureTavernChallengeListIsMutable();
                    this.tavernChallengeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tavernChallengeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTavernChallengeList(GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData value) {
                if (this.tavernChallengeListBuilder_ != null) {
                    this.tavernChallengeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTavernChallengeListIsMutable();
                    this.tavernChallengeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTavernChallengeList(int index, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData value) {
                if (this.tavernChallengeListBuilder_ != null) {
                    this.tavernChallengeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTavernChallengeListIsMutable();
                    this.tavernChallengeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTavernChallengeList(GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder builderForValue) {
                if (this.tavernChallengeListBuilder_ == null) {
                    ensureTavernChallengeListIsMutable();
                    this.tavernChallengeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.tavernChallengeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTavernChallengeList(int index, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder builderForValue) {
                if (this.tavernChallengeListBuilder_ == null) {
                    ensureTavernChallengeListIsMutable();
                    this.tavernChallengeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.tavernChallengeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTavernChallengeList(Iterable<? extends GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData> values) {
                if (this.tavernChallengeListBuilder_ == null) {
                    ensureTavernChallengeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.tavernChallengeList_);
                    onChanged();
                } else {
                    this.tavernChallengeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTavernChallengeList() {
                if (this.tavernChallengeListBuilder_ == null) {
                    this.tavernChallengeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.tavernChallengeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTavernChallengeList(int index) {
                if (this.tavernChallengeListBuilder_ == null) {
                    ensureTavernChallengeListIsMutable();
                    this.tavernChallengeList_.remove(index);
                    onChanged();
                } else {
                    this.tavernChallengeListBuilder_.remove(index);
                }
                return this;
            }

            public GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder getTavernChallengeListBuilder(int index) {
                return getTavernChallengeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
            public GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder getTavernChallengeListOrBuilder(int index) {
                if (this.tavernChallengeListBuilder_ == null) {
                    return this.tavernChallengeList_.get(index);
                }
                return this.tavernChallengeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GCGTCTavernChallengeDataNotifyOuterClass.GCGTCTavernChallengeDataNotifyOrBuilder
            public List<? extends GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder> getTavernChallengeListOrBuilderList() {
                if (this.tavernChallengeListBuilder_ != null) {
                    return this.tavernChallengeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.tavernChallengeList_);
            }

            public GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder addTavernChallengeListBuilder() {
                return getTavernChallengeListFieldBuilder().addBuilder(GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.getDefaultInstance());
            }

            public GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder addTavernChallengeListBuilder(int index) {
                return getTavernChallengeListFieldBuilder().addBuilder(index, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.getDefaultInstance());
            }

            public List<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder> getTavernChallengeListBuilderList() {
                return getTavernChallengeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeData.Builder, GCGTCTavernChallengeDataOuterClass.GCGTCTavernChallengeDataOrBuilder> getTavernChallengeListFieldBuilder() {
                if (this.tavernChallengeListBuilder_ == null) {
                    this.tavernChallengeListBuilder_ = new RepeatedFieldBuilderV3<>(this.tavernChallengeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.tavernChallengeList_ = null;
                }
                return this.tavernChallengeListBuilder_;
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

    static {
        GCGTCTavernChallengeDataOuterClass.getDescriptor();
    }
}
