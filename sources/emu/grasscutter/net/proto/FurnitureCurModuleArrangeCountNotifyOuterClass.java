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
import emu.grasscutter.net.proto.Uint32PairOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureCurModuleArrangeCountNotifyOuterClass.class */
public final class FurnitureCurModuleArrangeCountNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n*FurnitureCurModuleArrangeCountNotify.proto\u001a\u0010Uint32Pair.proto\"V\n$FurnitureCurModuleArrangeCountNotify\u0012.\n\u0019furnitureArrangeCountList\u0018\r \u0003(\u000b2\u000b.Uint32PairB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{Uint32PairOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FurnitureCurModuleArrangeCountNotify_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_FurnitureCurModuleArrangeCountNotify_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f718xb011ca17 = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureCurModuleArrangeCountNotify_descriptor, new String[]{"FurnitureArrangeCountList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureCurModuleArrangeCountNotifyOuterClass$FurnitureCurModuleArrangeCountNotifyOrBuilder.class */
    public interface FurnitureCurModuleArrangeCountNotifyOrBuilder extends MessageOrBuilder {
        List<Uint32PairOuterClass.Uint32Pair> getFurnitureArrangeCountListList();

        Uint32PairOuterClass.Uint32Pair getFurnitureArrangeCountList(int i);

        int getFurnitureArrangeCountListCount();

        List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getFurnitureArrangeCountListOrBuilderList();

        Uint32PairOuterClass.Uint32PairOrBuilder getFurnitureArrangeCountListOrBuilder(int i);
    }

    private FurnitureCurModuleArrangeCountNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureCurModuleArrangeCountNotifyOuterClass$FurnitureCurModuleArrangeCountNotify.class */
    public static final class FurnitureCurModuleArrangeCountNotify extends GeneratedMessageV3 implements FurnitureCurModuleArrangeCountNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FURNITUREARRANGECOUNTLIST_FIELD_NUMBER = 13;
        private List<Uint32PairOuterClass.Uint32Pair> furnitureArrangeCountList_;
        private byte memoizedIsInitialized;
        private static final FurnitureCurModuleArrangeCountNotify DEFAULT_INSTANCE = new FurnitureCurModuleArrangeCountNotify();
        private static final Parser<FurnitureCurModuleArrangeCountNotify> PARSER = new AbstractParser<FurnitureCurModuleArrangeCountNotify>() { // from class: emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotify.1
            @Override // com.google.protobuf.Parser
            public FurnitureCurModuleArrangeCountNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureCurModuleArrangeCountNotify(input, extensionRegistry);
            }
        };

        private FurnitureCurModuleArrangeCountNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureCurModuleArrangeCountNotify() {
            this.memoizedIsInitialized = -1;
            this.furnitureArrangeCountList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureCurModuleArrangeCountNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureCurModuleArrangeCountNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.furnitureArrangeCountList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.furnitureArrangeCountList_.add((Uint32PairOuterClass.Uint32Pair) input.readMessage(Uint32PairOuterClass.Uint32Pair.parser(), extensionRegistry));
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
                    this.furnitureArrangeCountList_ = Collections.unmodifiableList(this.furnitureArrangeCountList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FurnitureCurModuleArrangeCountNotifyOuterClass.internal_static_FurnitureCurModuleArrangeCountNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureCurModuleArrangeCountNotifyOuterClass.f718xb011ca17.ensureFieldAccessorsInitialized(FurnitureCurModuleArrangeCountNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
        public List<Uint32PairOuterClass.Uint32Pair> getFurnitureArrangeCountListList() {
            return this.furnitureArrangeCountList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
        public List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getFurnitureArrangeCountListOrBuilderList() {
            return this.furnitureArrangeCountList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
        public int getFurnitureArrangeCountListCount() {
            return this.furnitureArrangeCountList_.size();
        }

        @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
        public Uint32PairOuterClass.Uint32Pair getFurnitureArrangeCountList(int index) {
            return this.furnitureArrangeCountList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
        public Uint32PairOuterClass.Uint32PairOrBuilder getFurnitureArrangeCountListOrBuilder(int index) {
            return this.furnitureArrangeCountList_.get(index);
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
            for (int i = 0; i < this.furnitureArrangeCountList_.size(); i++) {
                output.writeMessage(13, this.furnitureArrangeCountList_.get(i));
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
            for (int i = 0; i < this.furnitureArrangeCountList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.furnitureArrangeCountList_.get(i));
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
            if (!(obj instanceof FurnitureCurModuleArrangeCountNotify)) {
                return equals(obj);
            }
            FurnitureCurModuleArrangeCountNotify other = (FurnitureCurModuleArrangeCountNotify) obj;
            return getFurnitureArrangeCountListList().equals(other.getFurnitureArrangeCountListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFurnitureArrangeCountListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getFurnitureArrangeCountListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(InputStream input) throws IOException {
            return (FurnitureCurModuleArrangeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureCurModuleArrangeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureCurModuleArrangeCountNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureCurModuleArrangeCountNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureCurModuleArrangeCountNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureCurModuleArrangeCountNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureCurModuleArrangeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureCurModuleArrangeCountNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureCurModuleArrangeCountNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureCurModuleArrangeCountNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureCurModuleArrangeCountNotifyOuterClass$FurnitureCurModuleArrangeCountNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureCurModuleArrangeCountNotifyOrBuilder {
            private int bitField0_;
            private List<Uint32PairOuterClass.Uint32Pair> furnitureArrangeCountList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<Uint32PairOuterClass.Uint32Pair, Uint32PairOuterClass.Uint32Pair.Builder, Uint32PairOuterClass.Uint32PairOrBuilder> furnitureArrangeCountListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureCurModuleArrangeCountNotifyOuterClass.internal_static_FurnitureCurModuleArrangeCountNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureCurModuleArrangeCountNotifyOuterClass.f718xb011ca17.ensureFieldAccessorsInitialized(FurnitureCurModuleArrangeCountNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureCurModuleArrangeCountNotify.alwaysUseFieldBuilders) {
                    getFurnitureArrangeCountListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    this.furnitureArrangeCountList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.furnitureArrangeCountListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureCurModuleArrangeCountNotifyOuterClass.internal_static_FurnitureCurModuleArrangeCountNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureCurModuleArrangeCountNotify getDefaultInstanceForType() {
                return FurnitureCurModuleArrangeCountNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureCurModuleArrangeCountNotify build() {
                FurnitureCurModuleArrangeCountNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureCurModuleArrangeCountNotify buildPartial() {
                FurnitureCurModuleArrangeCountNotify result = new FurnitureCurModuleArrangeCountNotify(this);
                int i = this.bitField0_;
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.furnitureArrangeCountList_ = Collections.unmodifiableList(this.furnitureArrangeCountList_);
                        this.bitField0_ &= -2;
                    }
                    result.furnitureArrangeCountList_ = this.furnitureArrangeCountList_;
                } else {
                    result.furnitureArrangeCountList_ = this.furnitureArrangeCountListBuilder_.build();
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
                if (other instanceof FurnitureCurModuleArrangeCountNotify) {
                    return mergeFrom((FurnitureCurModuleArrangeCountNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureCurModuleArrangeCountNotify other) {
                if (other == FurnitureCurModuleArrangeCountNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    if (!other.furnitureArrangeCountList_.isEmpty()) {
                        if (this.furnitureArrangeCountList_.isEmpty()) {
                            this.furnitureArrangeCountList_ = other.furnitureArrangeCountList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFurnitureArrangeCountListIsMutable();
                            this.furnitureArrangeCountList_.addAll(other.furnitureArrangeCountList_);
                        }
                        onChanged();
                    }
                } else if (!other.furnitureArrangeCountList_.isEmpty()) {
                    if (this.furnitureArrangeCountListBuilder_.isEmpty()) {
                        this.furnitureArrangeCountListBuilder_.dispose();
                        this.furnitureArrangeCountListBuilder_ = null;
                        this.furnitureArrangeCountList_ = other.furnitureArrangeCountList_;
                        this.bitField0_ &= -2;
                        this.furnitureArrangeCountListBuilder_ = FurnitureCurModuleArrangeCountNotify.alwaysUseFieldBuilders ? getFurnitureArrangeCountListFieldBuilder() : null;
                    } else {
                        this.furnitureArrangeCountListBuilder_.addAllMessages(other.furnitureArrangeCountList_);
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
                FurnitureCurModuleArrangeCountNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureCurModuleArrangeCountNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureCurModuleArrangeCountNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFurnitureArrangeCountListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.furnitureArrangeCountList_ = new ArrayList(this.furnitureArrangeCountList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
            public List<Uint32PairOuterClass.Uint32Pair> getFurnitureArrangeCountListList() {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    return Collections.unmodifiableList(this.furnitureArrangeCountList_);
                }
                return this.furnitureArrangeCountListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
            public int getFurnitureArrangeCountListCount() {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    return this.furnitureArrangeCountList_.size();
                }
                return this.furnitureArrangeCountListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
            public Uint32PairOuterClass.Uint32Pair getFurnitureArrangeCountList(int index) {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    return this.furnitureArrangeCountList_.get(index);
                }
                return this.furnitureArrangeCountListBuilder_.getMessage(index);
            }

            public Builder setFurnitureArrangeCountList(int index, Uint32PairOuterClass.Uint32Pair value) {
                if (this.furnitureArrangeCountListBuilder_ != null) {
                    this.furnitureArrangeCountListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureArrangeCountListIsMutable();
                    this.furnitureArrangeCountList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFurnitureArrangeCountList(int index, Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    ensureFurnitureArrangeCountListIsMutable();
                    this.furnitureArrangeCountList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureArrangeCountListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureArrangeCountList(Uint32PairOuterClass.Uint32Pair value) {
                if (this.furnitureArrangeCountListBuilder_ != null) {
                    this.furnitureArrangeCountListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureArrangeCountListIsMutable();
                    this.furnitureArrangeCountList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureArrangeCountList(int index, Uint32PairOuterClass.Uint32Pair value) {
                if (this.furnitureArrangeCountListBuilder_ != null) {
                    this.furnitureArrangeCountListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFurnitureArrangeCountListIsMutable();
                    this.furnitureArrangeCountList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFurnitureArrangeCountList(Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    ensureFurnitureArrangeCountListIsMutable();
                    this.furnitureArrangeCountList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureArrangeCountListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFurnitureArrangeCountList(int index, Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    ensureFurnitureArrangeCountListIsMutable();
                    this.furnitureArrangeCountList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.furnitureArrangeCountListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFurnitureArrangeCountList(Iterable<? extends Uint32PairOuterClass.Uint32Pair> values) {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    ensureFurnitureArrangeCountListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.furnitureArrangeCountList_);
                    onChanged();
                } else {
                    this.furnitureArrangeCountListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFurnitureArrangeCountList() {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    this.furnitureArrangeCountList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.furnitureArrangeCountListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFurnitureArrangeCountList(int index) {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    ensureFurnitureArrangeCountListIsMutable();
                    this.furnitureArrangeCountList_.remove(index);
                    onChanged();
                } else {
                    this.furnitureArrangeCountListBuilder_.remove(index);
                }
                return this;
            }

            public Uint32PairOuterClass.Uint32Pair.Builder getFurnitureArrangeCountListBuilder(int index) {
                return getFurnitureArrangeCountListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
            public Uint32PairOuterClass.Uint32PairOrBuilder getFurnitureArrangeCountListOrBuilder(int index) {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    return this.furnitureArrangeCountList_.get(index);
                }
                return this.furnitureArrangeCountListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureCurModuleArrangeCountNotifyOuterClass.FurnitureCurModuleArrangeCountNotifyOrBuilder
            public List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getFurnitureArrangeCountListOrBuilderList() {
                if (this.furnitureArrangeCountListBuilder_ != null) {
                    return this.furnitureArrangeCountListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.furnitureArrangeCountList_);
            }

            public Uint32PairOuterClass.Uint32Pair.Builder addFurnitureArrangeCountListBuilder() {
                return getFurnitureArrangeCountListFieldBuilder().addBuilder(Uint32PairOuterClass.Uint32Pair.getDefaultInstance());
            }

            public Uint32PairOuterClass.Uint32Pair.Builder addFurnitureArrangeCountListBuilder(int index) {
                return getFurnitureArrangeCountListFieldBuilder().addBuilder(index, Uint32PairOuterClass.Uint32Pair.getDefaultInstance());
            }

            public List<Uint32PairOuterClass.Uint32Pair.Builder> getFurnitureArrangeCountListBuilderList() {
                return getFurnitureArrangeCountListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Uint32PairOuterClass.Uint32Pair, Uint32PairOuterClass.Uint32Pair.Builder, Uint32PairOuterClass.Uint32PairOrBuilder> getFurnitureArrangeCountListFieldBuilder() {
                if (this.furnitureArrangeCountListBuilder_ == null) {
                    this.furnitureArrangeCountListBuilder_ = new RepeatedFieldBuilderV3<>(this.furnitureArrangeCountList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.furnitureArrangeCountList_ = null;
                }
                return this.furnitureArrangeCountListBuilder_;
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

        public static FurnitureCurModuleArrangeCountNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureCurModuleArrangeCountNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureCurModuleArrangeCountNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureCurModuleArrangeCountNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Uint32PairOuterClass.getDescriptor();
    }
}
