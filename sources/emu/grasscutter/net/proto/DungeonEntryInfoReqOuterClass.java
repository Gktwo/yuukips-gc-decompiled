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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoReqOuterClass.class */
public final class DungeonEntryInfoReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019DungeonEntryInfoReq.proto\u001a\u0010Uint32Pair.proto\"^\n\u0013DungeonEntryInfoReq\u0012\u000f\n\u0007pointId\u0018\u000e \u0001(\r\u0012%\n\u0010scenePointIdList\u0018\f \u0003(\u000b2\u000b.Uint32Pair\u0012\u000f\n\u0007sceneId\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{Uint32PairOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DungeonEntryInfoReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DungeonEntryInfoReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DungeonEntryInfoReq_descriptor, new String[]{"PointId", "ScenePointIdList", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoReqOuterClass$DungeonEntryInfoReqOrBuilder.class */
    public interface DungeonEntryInfoReqOrBuilder extends MessageOrBuilder {
        int getPointId();

        List<Uint32PairOuterClass.Uint32Pair> getScenePointIdListList();

        Uint32PairOuterClass.Uint32Pair getScenePointIdList(int i);

        int getScenePointIdListCount();

        List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getScenePointIdListOrBuilderList();

        Uint32PairOuterClass.Uint32PairOrBuilder getScenePointIdListOrBuilder(int i);

        int getSceneId();
    }

    private DungeonEntryInfoReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoReqOuterClass$DungeonEntryInfoReq.class */
    public static final class DungeonEntryInfoReq extends GeneratedMessageV3 implements DungeonEntryInfoReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int POINTID_FIELD_NUMBER = 14;
        private int pointId_;
        public static final int SCENEPOINTIDLIST_FIELD_NUMBER = 12;
        private List<Uint32PairOuterClass.Uint32Pair> scenePointIdList_;
        public static final int SCENEID_FIELD_NUMBER = 3;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final DungeonEntryInfoReq DEFAULT_INSTANCE = new DungeonEntryInfoReq();
        private static final Parser<DungeonEntryInfoReq> PARSER = new AbstractParser<DungeonEntryInfoReq>() { // from class: emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReq.1
            @Override // com.google.protobuf.Parser
            public DungeonEntryInfoReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DungeonEntryInfoReq(input, extensionRegistry);
            }
        };

        private DungeonEntryInfoReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DungeonEntryInfoReq() {
            this.memoizedIsInitialized = -1;
            this.scenePointIdList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DungeonEntryInfoReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DungeonEntryInfoReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 24:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 98:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.scenePointIdList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.scenePointIdList_.add((Uint32PairOuterClass.Uint32Pair) input.readMessage(Uint32PairOuterClass.Uint32Pair.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.pointId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.scenePointIdList_ = Collections.unmodifiableList(this.scenePointIdList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DungeonEntryInfoReqOuterClass.internal_static_DungeonEntryInfoReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DungeonEntryInfoReqOuterClass.internal_static_DungeonEntryInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryInfoReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
        public int getPointId() {
            return this.pointId_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
        public List<Uint32PairOuterClass.Uint32Pair> getScenePointIdListList() {
            return this.scenePointIdList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
        public List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getScenePointIdListOrBuilderList() {
            return this.scenePointIdList_;
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
        public int getScenePointIdListCount() {
            return this.scenePointIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
        public Uint32PairOuterClass.Uint32Pair getScenePointIdList(int index) {
            return this.scenePointIdList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
        public Uint32PairOuterClass.Uint32PairOrBuilder getScenePointIdListOrBuilder(int index) {
            return this.scenePointIdList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (this.sceneId_ != 0) {
                output.writeUInt32(3, this.sceneId_);
            }
            for (int i = 0; i < this.scenePointIdList_.size(); i++) {
                output.writeMessage(12, this.scenePointIdList_.get(i));
            }
            if (this.pointId_ != 0) {
                output.writeUInt32(14, this.pointId_);
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
            if (this.sceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.sceneId_);
            }
            for (int i = 0; i < this.scenePointIdList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.scenePointIdList_.get(i));
            }
            if (this.pointId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.pointId_);
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
            if (!(obj instanceof DungeonEntryInfoReq)) {
                return equals(obj);
            }
            DungeonEntryInfoReq other = (DungeonEntryInfoReq) obj;
            return getPointId() == other.getPointId() && getScenePointIdListList().equals(other.getScenePointIdListList()) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getPointId();
            if (getScenePointIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getScenePointIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DungeonEntryInfoReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfoReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfoReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfoReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfoReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DungeonEntryInfoReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DungeonEntryInfoReq parseFrom(InputStream input) throws IOException {
            return (DungeonEntryInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryInfoReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryInfoReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DungeonEntryInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DungeonEntryInfoReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfoReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DungeonEntryInfoReq parseFrom(CodedInputStream input) throws IOException {
            return (DungeonEntryInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DungeonEntryInfoReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DungeonEntryInfoReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DungeonEntryInfoReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DungeonEntryInfoReqOuterClass$DungeonEntryInfoReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DungeonEntryInfoReqOrBuilder {
            private int bitField0_;
            private int pointId_;
            private List<Uint32PairOuterClass.Uint32Pair> scenePointIdList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<Uint32PairOuterClass.Uint32Pair, Uint32PairOuterClass.Uint32Pair.Builder, Uint32PairOuterClass.Uint32PairOrBuilder> scenePointIdListBuilder_;
            private int sceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DungeonEntryInfoReqOuterClass.internal_static_DungeonEntryInfoReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DungeonEntryInfoReqOuterClass.internal_static_DungeonEntryInfoReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DungeonEntryInfoReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DungeonEntryInfoReq.alwaysUseFieldBuilders) {
                    getScenePointIdListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.pointId_ = 0;
                if (this.scenePointIdListBuilder_ == null) {
                    this.scenePointIdList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.scenePointIdListBuilder_.clear();
                }
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DungeonEntryInfoReqOuterClass.internal_static_DungeonEntryInfoReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DungeonEntryInfoReq getDefaultInstanceForType() {
                return DungeonEntryInfoReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryInfoReq build() {
                DungeonEntryInfoReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DungeonEntryInfoReq buildPartial() {
                DungeonEntryInfoReq result = new DungeonEntryInfoReq(this);
                int i = this.bitField0_;
                result.pointId_ = this.pointId_;
                if (this.scenePointIdListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.scenePointIdList_ = Collections.unmodifiableList(this.scenePointIdList_);
                        this.bitField0_ &= -2;
                    }
                    result.scenePointIdList_ = this.scenePointIdList_;
                } else {
                    result.scenePointIdList_ = this.scenePointIdListBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof DungeonEntryInfoReq) {
                    return mergeFrom((DungeonEntryInfoReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DungeonEntryInfoReq other) {
                if (other == DungeonEntryInfoReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getPointId() != 0) {
                    setPointId(other.getPointId());
                }
                if (this.scenePointIdListBuilder_ == null) {
                    if (!other.scenePointIdList_.isEmpty()) {
                        if (this.scenePointIdList_.isEmpty()) {
                            this.scenePointIdList_ = other.scenePointIdList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureScenePointIdListIsMutable();
                            this.scenePointIdList_.addAll(other.scenePointIdList_);
                        }
                        onChanged();
                    }
                } else if (!other.scenePointIdList_.isEmpty()) {
                    if (this.scenePointIdListBuilder_.isEmpty()) {
                        this.scenePointIdListBuilder_.dispose();
                        this.scenePointIdListBuilder_ = null;
                        this.scenePointIdList_ = other.scenePointIdList_;
                        this.bitField0_ &= -2;
                        this.scenePointIdListBuilder_ = DungeonEntryInfoReq.alwaysUseFieldBuilders ? getScenePointIdListFieldBuilder() : null;
                    } else {
                        this.scenePointIdListBuilder_.addAllMessages(other.scenePointIdList_);
                    }
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                DungeonEntryInfoReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DungeonEntryInfoReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DungeonEntryInfoReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
            public int getPointId() {
                return this.pointId_;
            }

            public Builder setPointId(int value) {
                this.pointId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPointId() {
                this.pointId_ = 0;
                onChanged();
                return this;
            }

            private void ensureScenePointIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.scenePointIdList_ = new ArrayList(this.scenePointIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
            public List<Uint32PairOuterClass.Uint32Pair> getScenePointIdListList() {
                if (this.scenePointIdListBuilder_ == null) {
                    return Collections.unmodifiableList(this.scenePointIdList_);
                }
                return this.scenePointIdListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
            public int getScenePointIdListCount() {
                if (this.scenePointIdListBuilder_ == null) {
                    return this.scenePointIdList_.size();
                }
                return this.scenePointIdListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
            public Uint32PairOuterClass.Uint32Pair getScenePointIdList(int index) {
                if (this.scenePointIdListBuilder_ == null) {
                    return this.scenePointIdList_.get(index);
                }
                return this.scenePointIdListBuilder_.getMessage(index);
            }

            public Builder setScenePointIdList(int index, Uint32PairOuterClass.Uint32Pair value) {
                if (this.scenePointIdListBuilder_ != null) {
                    this.scenePointIdListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureScenePointIdListIsMutable();
                    this.scenePointIdList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setScenePointIdList(int index, Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.scenePointIdListBuilder_ == null) {
                    ensureScenePointIdListIsMutable();
                    this.scenePointIdList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.scenePointIdListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addScenePointIdList(Uint32PairOuterClass.Uint32Pair value) {
                if (this.scenePointIdListBuilder_ != null) {
                    this.scenePointIdListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureScenePointIdListIsMutable();
                    this.scenePointIdList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addScenePointIdList(int index, Uint32PairOuterClass.Uint32Pair value) {
                if (this.scenePointIdListBuilder_ != null) {
                    this.scenePointIdListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureScenePointIdListIsMutable();
                    this.scenePointIdList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addScenePointIdList(Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.scenePointIdListBuilder_ == null) {
                    ensureScenePointIdListIsMutable();
                    this.scenePointIdList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.scenePointIdListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addScenePointIdList(int index, Uint32PairOuterClass.Uint32Pair.Builder builderForValue) {
                if (this.scenePointIdListBuilder_ == null) {
                    ensureScenePointIdListIsMutable();
                    this.scenePointIdList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.scenePointIdListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllScenePointIdList(Iterable<? extends Uint32PairOuterClass.Uint32Pair> values) {
                if (this.scenePointIdListBuilder_ == null) {
                    ensureScenePointIdListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.scenePointIdList_);
                    onChanged();
                } else {
                    this.scenePointIdListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearScenePointIdList() {
                if (this.scenePointIdListBuilder_ == null) {
                    this.scenePointIdList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.scenePointIdListBuilder_.clear();
                }
                return this;
            }

            public Builder removeScenePointIdList(int index) {
                if (this.scenePointIdListBuilder_ == null) {
                    ensureScenePointIdListIsMutable();
                    this.scenePointIdList_.remove(index);
                    onChanged();
                } else {
                    this.scenePointIdListBuilder_.remove(index);
                }
                return this;
            }

            public Uint32PairOuterClass.Uint32Pair.Builder getScenePointIdListBuilder(int index) {
                return getScenePointIdListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
            public Uint32PairOuterClass.Uint32PairOrBuilder getScenePointIdListOrBuilder(int index) {
                if (this.scenePointIdListBuilder_ == null) {
                    return this.scenePointIdList_.get(index);
                }
                return this.scenePointIdListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
            public List<? extends Uint32PairOuterClass.Uint32PairOrBuilder> getScenePointIdListOrBuilderList() {
                if (this.scenePointIdListBuilder_ != null) {
                    return this.scenePointIdListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.scenePointIdList_);
            }

            public Uint32PairOuterClass.Uint32Pair.Builder addScenePointIdListBuilder() {
                return getScenePointIdListFieldBuilder().addBuilder(Uint32PairOuterClass.Uint32Pair.getDefaultInstance());
            }

            public Uint32PairOuterClass.Uint32Pair.Builder addScenePointIdListBuilder(int index) {
                return getScenePointIdListFieldBuilder().addBuilder(index, Uint32PairOuterClass.Uint32Pair.getDefaultInstance());
            }

            public List<Uint32PairOuterClass.Uint32Pair.Builder> getScenePointIdListBuilderList() {
                return getScenePointIdListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<Uint32PairOuterClass.Uint32Pair, Uint32PairOuterClass.Uint32Pair.Builder, Uint32PairOuterClass.Uint32PairOrBuilder> getScenePointIdListFieldBuilder() {
                if (this.scenePointIdListBuilder_ == null) {
                    this.scenePointIdListBuilder_ = new RepeatedFieldBuilderV3<>(this.scenePointIdList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.scenePointIdList_ = null;
                }
                return this.scenePointIdListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass.DungeonEntryInfoReqOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static DungeonEntryInfoReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DungeonEntryInfoReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DungeonEntryInfoReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DungeonEntryInfoReq getDefaultInstanceForType() {
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
