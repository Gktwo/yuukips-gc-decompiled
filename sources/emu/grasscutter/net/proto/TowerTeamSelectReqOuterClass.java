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
import emu.grasscutter.net.proto.TowerTeamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerTeamSelectReqOuterClass.class */
public final class TowerTeamSelectReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018TowerTeamSelectReq.proto\u001a\u000fTowerTeam.proto\"H\n\u0012TowerTeamSelectReq\u0012!\n\rtowerTeamList\u0018\u0001 \u0003(\u000b2\n.TowerTeam\u0012\u000f\n\u0007floorId\u0018\u000b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerTeamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerTeamSelectReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerTeamSelectReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerTeamSelectReq_descriptor, new String[]{"TowerTeamList", "FloorId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerTeamSelectReqOuterClass$TowerTeamSelectReqOrBuilder.class */
    public interface TowerTeamSelectReqOrBuilder extends MessageOrBuilder {
        List<TowerTeamOuterClass.TowerTeam> getTowerTeamListList();

        TowerTeamOuterClass.TowerTeam getTowerTeamList(int i);

        int getTowerTeamListCount();

        List<? extends TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListOrBuilderList();

        TowerTeamOuterClass.TowerTeamOrBuilder getTowerTeamListOrBuilder(int i);

        int getFloorId();
    }

    private TowerTeamSelectReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerTeamSelectReqOuterClass$TowerTeamSelectReq.class */
    public static final class TowerTeamSelectReq extends GeneratedMessageV3 implements TowerTeamSelectReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TOWERTEAMLIST_FIELD_NUMBER = 1;
        private List<TowerTeamOuterClass.TowerTeam> towerTeamList_;
        public static final int FLOORID_FIELD_NUMBER = 11;
        private int floorId_;
        private byte memoizedIsInitialized;
        private static final TowerTeamSelectReq DEFAULT_INSTANCE = new TowerTeamSelectReq();
        private static final Parser<TowerTeamSelectReq> PARSER = new AbstractParser<TowerTeamSelectReq>() { // from class: emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReq.1
            @Override // com.google.protobuf.Parser
            public TowerTeamSelectReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerTeamSelectReq(input, extensionRegistry);
            }
        };

        private TowerTeamSelectReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerTeamSelectReq() {
            this.memoizedIsInitialized = -1;
            this.towerTeamList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerTeamSelectReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerTeamSelectReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.towerTeamList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.towerTeamList_.add((TowerTeamOuterClass.TowerTeam) input.readMessage(TowerTeamOuterClass.TowerTeam.parser(), extensionRegistry));
                                    break;
                                case 88:
                                    this.floorId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.towerTeamList_ = Collections.unmodifiableList(this.towerTeamList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerTeamSelectReqOuterClass.internal_static_TowerTeamSelectReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerTeamSelectReqOuterClass.internal_static_TowerTeamSelectReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerTeamSelectReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
        public List<TowerTeamOuterClass.TowerTeam> getTowerTeamListList() {
            return this.towerTeamList_;
        }

        @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
        public List<? extends TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListOrBuilderList() {
            return this.towerTeamList_;
        }

        @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
        public int getTowerTeamListCount() {
            return this.towerTeamList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
        public TowerTeamOuterClass.TowerTeam getTowerTeamList(int index) {
            return this.towerTeamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
        public TowerTeamOuterClass.TowerTeamOrBuilder getTowerTeamListOrBuilder(int index) {
            return this.towerTeamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
        public int getFloorId() {
            return this.floorId_;
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
            for (int i = 0; i < this.towerTeamList_.size(); i++) {
                output.writeMessage(1, this.towerTeamList_.get(i));
            }
            if (this.floorId_ != 0) {
                output.writeUInt32(11, this.floorId_);
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
            for (int i = 0; i < this.towerTeamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.towerTeamList_.get(i));
            }
            if (this.floorId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.floorId_);
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
            if (!(obj instanceof TowerTeamSelectReq)) {
                return equals(obj);
            }
            TowerTeamSelectReq other = (TowerTeamSelectReq) obj;
            return getTowerTeamListList().equals(other.getTowerTeamListList()) && getFloorId() == other.getFloorId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getTowerTeamListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getTowerTeamListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 11)) + getFloorId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TowerTeamSelectReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerTeamSelectReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerTeamSelectReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerTeamSelectReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerTeamSelectReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerTeamSelectReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerTeamSelectReq parseFrom(InputStream input) throws IOException {
            return (TowerTeamSelectReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerTeamSelectReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerTeamSelectReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerTeamSelectReq parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerTeamSelectReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerTeamSelectReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerTeamSelectReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerTeamSelectReq parseFrom(CodedInputStream input) throws IOException {
            return (TowerTeamSelectReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerTeamSelectReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerTeamSelectReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerTeamSelectReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerTeamSelectReqOuterClass$TowerTeamSelectReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerTeamSelectReqOrBuilder {
            private int bitField0_;
            private List<TowerTeamOuterClass.TowerTeam> towerTeamList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TowerTeamOuterClass.TowerTeam, TowerTeamOuterClass.TowerTeam.Builder, TowerTeamOuterClass.TowerTeamOrBuilder> towerTeamListBuilder_;
            private int floorId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerTeamSelectReqOuterClass.internal_static_TowerTeamSelectReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerTeamSelectReqOuterClass.internal_static_TowerTeamSelectReq_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerTeamSelectReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerTeamSelectReq.alwaysUseFieldBuilders) {
                    getTowerTeamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.towerTeamListBuilder_ == null) {
                    this.towerTeamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.towerTeamListBuilder_.clear();
                }
                this.floorId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerTeamSelectReqOuterClass.internal_static_TowerTeamSelectReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerTeamSelectReq getDefaultInstanceForType() {
                return TowerTeamSelectReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerTeamSelectReq build() {
                TowerTeamSelectReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerTeamSelectReq buildPartial() {
                TowerTeamSelectReq result = new TowerTeamSelectReq(this);
                int i = this.bitField0_;
                if (this.towerTeamListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.towerTeamList_ = Collections.unmodifiableList(this.towerTeamList_);
                        this.bitField0_ &= -2;
                    }
                    result.towerTeamList_ = this.towerTeamList_;
                } else {
                    result.towerTeamList_ = this.towerTeamListBuilder_.build();
                }
                result.floorId_ = this.floorId_;
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
                if (other instanceof TowerTeamSelectReq) {
                    return mergeFrom((TowerTeamSelectReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerTeamSelectReq other) {
                if (other == TowerTeamSelectReq.getDefaultInstance()) {
                    return this;
                }
                if (this.towerTeamListBuilder_ == null) {
                    if (!other.towerTeamList_.isEmpty()) {
                        if (this.towerTeamList_.isEmpty()) {
                            this.towerTeamList_ = other.towerTeamList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTowerTeamListIsMutable();
                            this.towerTeamList_.addAll(other.towerTeamList_);
                        }
                        onChanged();
                    }
                } else if (!other.towerTeamList_.isEmpty()) {
                    if (this.towerTeamListBuilder_.isEmpty()) {
                        this.towerTeamListBuilder_.dispose();
                        this.towerTeamListBuilder_ = null;
                        this.towerTeamList_ = other.towerTeamList_;
                        this.bitField0_ &= -2;
                        this.towerTeamListBuilder_ = TowerTeamSelectReq.alwaysUseFieldBuilders ? getTowerTeamListFieldBuilder() : null;
                    } else {
                        this.towerTeamListBuilder_.addAllMessages(other.towerTeamList_);
                    }
                }
                if (other.getFloorId() != 0) {
                    setFloorId(other.getFloorId());
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
                TowerTeamSelectReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerTeamSelectReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerTeamSelectReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureTowerTeamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.towerTeamList_ = new ArrayList(this.towerTeamList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
            public List<TowerTeamOuterClass.TowerTeam> getTowerTeamListList() {
                if (this.towerTeamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.towerTeamList_);
                }
                return this.towerTeamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
            public int getTowerTeamListCount() {
                if (this.towerTeamListBuilder_ == null) {
                    return this.towerTeamList_.size();
                }
                return this.towerTeamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
            public TowerTeamOuterClass.TowerTeam getTowerTeamList(int index) {
                if (this.towerTeamListBuilder_ == null) {
                    return this.towerTeamList_.get(index);
                }
                return this.towerTeamListBuilder_.getMessage(index);
            }

            public Builder setTowerTeamList(int index, TowerTeamOuterClass.TowerTeam value) {
                if (this.towerTeamListBuilder_ != null) {
                    this.towerTeamListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTowerTeamList(int index, TowerTeamOuterClass.TowerTeam.Builder builderForValue) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTowerTeamList(TowerTeamOuterClass.TowerTeam value) {
                if (this.towerTeamListBuilder_ != null) {
                    this.towerTeamListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerTeamList(int index, TowerTeamOuterClass.TowerTeam value) {
                if (this.towerTeamListBuilder_ != null) {
                    this.towerTeamListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerTeamList(TowerTeamOuterClass.TowerTeam.Builder builderForValue) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTowerTeamList(int index, TowerTeamOuterClass.TowerTeam.Builder builderForValue) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTowerTeamList(Iterable<? extends TowerTeamOuterClass.TowerTeam> values) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.towerTeamList_);
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTowerTeamList() {
                if (this.towerTeamListBuilder_ == null) {
                    this.towerTeamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTowerTeamList(int index) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.remove(index);
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.remove(index);
                }
                return this;
            }

            public TowerTeamOuterClass.TowerTeam.Builder getTowerTeamListBuilder(int index) {
                return getTowerTeamListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
            public TowerTeamOuterClass.TowerTeamOrBuilder getTowerTeamListOrBuilder(int index) {
                if (this.towerTeamListBuilder_ == null) {
                    return this.towerTeamList_.get(index);
                }
                return this.towerTeamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
            public List<? extends TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListOrBuilderList() {
                if (this.towerTeamListBuilder_ != null) {
                    return this.towerTeamListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.towerTeamList_);
            }

            public TowerTeamOuterClass.TowerTeam.Builder addTowerTeamListBuilder() {
                return getTowerTeamListFieldBuilder().addBuilder(TowerTeamOuterClass.TowerTeam.getDefaultInstance());
            }

            public TowerTeamOuterClass.TowerTeam.Builder addTowerTeamListBuilder(int index) {
                return getTowerTeamListFieldBuilder().addBuilder(index, TowerTeamOuterClass.TowerTeam.getDefaultInstance());
            }

            public List<TowerTeamOuterClass.TowerTeam.Builder> getTowerTeamListBuilderList() {
                return getTowerTeamListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TowerTeamOuterClass.TowerTeam, TowerTeamOuterClass.TowerTeam.Builder, TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListFieldBuilder() {
                if (this.towerTeamListBuilder_ == null) {
                    this.towerTeamListBuilder_ = new RepeatedFieldBuilderV3<>(this.towerTeamList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.towerTeamList_ = null;
                }
                return this.towerTeamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass.TowerTeamSelectReqOrBuilder
            public int getFloorId() {
                return this.floorId_;
            }

            public Builder setFloorId(int value) {
                this.floorId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFloorId() {
                this.floorId_ = 0;
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

        public static TowerTeamSelectReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerTeamSelectReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerTeamSelectReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerTeamSelectReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerTeamOuterClass.getDescriptor();
    }
}
