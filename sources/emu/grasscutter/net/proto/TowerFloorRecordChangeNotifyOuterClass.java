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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.TowerFloorRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordChangeNotifyOuterClass.class */
public final class TowerFloorRecordChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"TowerFloorRecordChangeNotify.proto\u001a\u0016TowerFloorRecord.proto\"p\n\u001cTowerFloorRecordChangeNotify\u0012\u001f\n\u0017isFinishedEntranceFloor\u0018\u000b \u0001(\b\u0012/\n\u0014towerFloorRecordList\u0018\f \u0003(\u000b2\u0011.TowerFloorRecordB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerFloorRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerFloorRecordChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerFloorRecordChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerFloorRecordChangeNotify_descriptor, new String[]{"IsFinishedEntranceFloor", "TowerFloorRecordList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordChangeNotifyOuterClass$TowerFloorRecordChangeNotifyOrBuilder.class */
    public interface TowerFloorRecordChangeNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsFinishedEntranceFloor();

        List<TowerFloorRecordOuterClass.TowerFloorRecord> getTowerFloorRecordListList();

        TowerFloorRecordOuterClass.TowerFloorRecord getTowerFloorRecordList(int i);

        int getTowerFloorRecordListCount();

        List<? extends TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListOrBuilderList();

        TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder getTowerFloorRecordListOrBuilder(int i);
    }

    private TowerFloorRecordChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordChangeNotifyOuterClass$TowerFloorRecordChangeNotify.class */
    public static final class TowerFloorRecordChangeNotify extends GeneratedMessageV3 implements TowerFloorRecordChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISFINISHEDENTRANCEFLOOR_FIELD_NUMBER = 11;
        private boolean isFinishedEntranceFloor_;
        public static final int TOWERFLOORRECORDLIST_FIELD_NUMBER = 12;
        private List<TowerFloorRecordOuterClass.TowerFloorRecord> towerFloorRecordList_;
        private byte memoizedIsInitialized;
        private static final TowerFloorRecordChangeNotify DEFAULT_INSTANCE = new TowerFloorRecordChangeNotify();
        private static final Parser<TowerFloorRecordChangeNotify> PARSER = new AbstractParser<TowerFloorRecordChangeNotify>() { // from class: emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotify.1
            @Override // com.google.protobuf.Parser
            public TowerFloorRecordChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerFloorRecordChangeNotify(input, extensionRegistry);
            }
        };

        private TowerFloorRecordChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TowerFloorRecordChangeNotify() {
            this.memoizedIsInitialized = -1;
            this.towerFloorRecordList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerFloorRecordChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TowerFloorRecordChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 88:
                                    this.isFinishedEntranceFloor_ = input.readBool();
                                    break;
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.towerFloorRecordList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.towerFloorRecordList_.add((TowerFloorRecordOuterClass.TowerFloorRecord) input.readMessage(TowerFloorRecordOuterClass.TowerFloorRecord.parser(), extensionRegistry));
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
                    this.towerFloorRecordList_ = Collections.unmodifiableList(this.towerFloorRecordList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerFloorRecordChangeNotifyOuterClass.internal_static_TowerFloorRecordChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerFloorRecordChangeNotifyOuterClass.internal_static_TowerFloorRecordChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerFloorRecordChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
        public boolean getIsFinishedEntranceFloor() {
            return this.isFinishedEntranceFloor_;
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
        public List<TowerFloorRecordOuterClass.TowerFloorRecord> getTowerFloorRecordListList() {
            return this.towerFloorRecordList_;
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
        public List<? extends TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListOrBuilderList() {
            return this.towerFloorRecordList_;
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
        public int getTowerFloorRecordListCount() {
            return this.towerFloorRecordList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
        public TowerFloorRecordOuterClass.TowerFloorRecord getTowerFloorRecordList(int index) {
            return this.towerFloorRecordList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
        public TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder getTowerFloorRecordListOrBuilder(int index) {
            return this.towerFloorRecordList_.get(index);
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
            if (this.isFinishedEntranceFloor_) {
                output.writeBool(11, this.isFinishedEntranceFloor_);
            }
            for (int i = 0; i < this.towerFloorRecordList_.size(); i++) {
                output.writeMessage(12, this.towerFloorRecordList_.get(i));
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
            if (this.isFinishedEntranceFloor_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(11, this.isFinishedEntranceFloor_);
            }
            for (int i = 0; i < this.towerFloorRecordList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.towerFloorRecordList_.get(i));
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
            if (!(obj instanceof TowerFloorRecordChangeNotify)) {
                return equals(obj);
            }
            TowerFloorRecordChangeNotify other = (TowerFloorRecordChangeNotify) obj;
            return getIsFinishedEntranceFloor() == other.getIsFinishedEntranceFloor() && getTowerFloorRecordListList().equals(other.getTowerFloorRecordListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + Internal.hashBoolean(getIsFinishedEntranceFloor());
            if (getTowerFloorRecordListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getTowerFloorRecordListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TowerFloorRecordChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerFloorRecordChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerFloorRecordChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerFloorRecordChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerFloorRecordChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerFloorRecordChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerFloorRecordChangeNotify parseFrom(InputStream input) throws IOException {
            return (TowerFloorRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerFloorRecordChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerFloorRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerFloorRecordChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerFloorRecordChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerFloorRecordChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerFloorRecordChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerFloorRecordChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (TowerFloorRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerFloorRecordChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerFloorRecordChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerFloorRecordChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerFloorRecordChangeNotifyOuterClass$TowerFloorRecordChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerFloorRecordChangeNotifyOrBuilder {
            private int bitField0_;
            private boolean isFinishedEntranceFloor_;
            private List<TowerFloorRecordOuterClass.TowerFloorRecord> towerFloorRecordList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<TowerFloorRecordOuterClass.TowerFloorRecord, TowerFloorRecordOuterClass.TowerFloorRecord.Builder, TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> towerFloorRecordListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerFloorRecordChangeNotifyOuterClass.internal_static_TowerFloorRecordChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerFloorRecordChangeNotifyOuterClass.internal_static_TowerFloorRecordChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerFloorRecordChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerFloorRecordChangeNotify.alwaysUseFieldBuilders) {
                    getTowerFloorRecordListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isFinishedEntranceFloor_ = false;
                if (this.towerFloorRecordListBuilder_ == null) {
                    this.towerFloorRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.towerFloorRecordListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerFloorRecordChangeNotifyOuterClass.internal_static_TowerFloorRecordChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerFloorRecordChangeNotify getDefaultInstanceForType() {
                return TowerFloorRecordChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerFloorRecordChangeNotify build() {
                TowerFloorRecordChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerFloorRecordChangeNotify buildPartial() {
                TowerFloorRecordChangeNotify result = new TowerFloorRecordChangeNotify(this);
                int i = this.bitField0_;
                result.isFinishedEntranceFloor_ = this.isFinishedEntranceFloor_;
                if (this.towerFloorRecordListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.towerFloorRecordList_ = Collections.unmodifiableList(this.towerFloorRecordList_);
                        this.bitField0_ &= -2;
                    }
                    result.towerFloorRecordList_ = this.towerFloorRecordList_;
                } else {
                    result.towerFloorRecordList_ = this.towerFloorRecordListBuilder_.build();
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
                if (other instanceof TowerFloorRecordChangeNotify) {
                    return mergeFrom((TowerFloorRecordChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerFloorRecordChangeNotify other) {
                if (other == TowerFloorRecordChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsFinishedEntranceFloor()) {
                    setIsFinishedEntranceFloor(other.getIsFinishedEntranceFloor());
                }
                if (this.towerFloorRecordListBuilder_ == null) {
                    if (!other.towerFloorRecordList_.isEmpty()) {
                        if (this.towerFloorRecordList_.isEmpty()) {
                            this.towerFloorRecordList_ = other.towerFloorRecordList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureTowerFloorRecordListIsMutable();
                            this.towerFloorRecordList_.addAll(other.towerFloorRecordList_);
                        }
                        onChanged();
                    }
                } else if (!other.towerFloorRecordList_.isEmpty()) {
                    if (this.towerFloorRecordListBuilder_.isEmpty()) {
                        this.towerFloorRecordListBuilder_.dispose();
                        this.towerFloorRecordListBuilder_ = null;
                        this.towerFloorRecordList_ = other.towerFloorRecordList_;
                        this.bitField0_ &= -2;
                        this.towerFloorRecordListBuilder_ = TowerFloorRecordChangeNotify.alwaysUseFieldBuilders ? getTowerFloorRecordListFieldBuilder() : null;
                    } else {
                        this.towerFloorRecordListBuilder_.addAllMessages(other.towerFloorRecordList_);
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
                TowerFloorRecordChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerFloorRecordChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerFloorRecordChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
            public boolean getIsFinishedEntranceFloor() {
                return this.isFinishedEntranceFloor_;
            }

            public Builder setIsFinishedEntranceFloor(boolean value) {
                this.isFinishedEntranceFloor_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinishedEntranceFloor() {
                this.isFinishedEntranceFloor_ = false;
                onChanged();
                return this;
            }

            private void ensureTowerFloorRecordListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.towerFloorRecordList_ = new ArrayList(this.towerFloorRecordList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
            public List<TowerFloorRecordOuterClass.TowerFloorRecord> getTowerFloorRecordListList() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return Collections.unmodifiableList(this.towerFloorRecordList_);
                }
                return this.towerFloorRecordListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
            public int getTowerFloorRecordListCount() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return this.towerFloorRecordList_.size();
                }
                return this.towerFloorRecordListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
            public TowerFloorRecordOuterClass.TowerFloorRecord getTowerFloorRecordList(int index) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return this.towerFloorRecordList_.get(index);
                }
                return this.towerFloorRecordListBuilder_.getMessage(index);
            }

            public Builder setTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord value) {
                if (this.towerFloorRecordListBuilder_ != null) {
                    this.towerFloorRecordListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord.Builder builderForValue) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTowerFloorRecordList(TowerFloorRecordOuterClass.TowerFloorRecord value) {
                if (this.towerFloorRecordListBuilder_ != null) {
                    this.towerFloorRecordListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord value) {
                if (this.towerFloorRecordListBuilder_ != null) {
                    this.towerFloorRecordListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerFloorRecordList(TowerFloorRecordOuterClass.TowerFloorRecord.Builder builderForValue) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTowerFloorRecordList(int index, TowerFloorRecordOuterClass.TowerFloorRecord.Builder builderForValue) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTowerFloorRecordList(Iterable<? extends TowerFloorRecordOuterClass.TowerFloorRecord> values) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.towerFloorRecordList_);
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTowerFloorRecordList() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    this.towerFloorRecordList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTowerFloorRecordList(int index) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    ensureTowerFloorRecordListIsMutable();
                    this.towerFloorRecordList_.remove(index);
                    onChanged();
                } else {
                    this.towerFloorRecordListBuilder_.remove(index);
                }
                return this;
            }

            public TowerFloorRecordOuterClass.TowerFloorRecord.Builder getTowerFloorRecordListBuilder(int index) {
                return getTowerFloorRecordListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
            public TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder getTowerFloorRecordListOrBuilder(int index) {
                if (this.towerFloorRecordListBuilder_ == null) {
                    return this.towerFloorRecordList_.get(index);
                }
                return this.towerFloorRecordListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerFloorRecordChangeNotifyOuterClass.TowerFloorRecordChangeNotifyOrBuilder
            public List<? extends TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListOrBuilderList() {
                if (this.towerFloorRecordListBuilder_ != null) {
                    return this.towerFloorRecordListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.towerFloorRecordList_);
            }

            public TowerFloorRecordOuterClass.TowerFloorRecord.Builder addTowerFloorRecordListBuilder() {
                return getTowerFloorRecordListFieldBuilder().addBuilder(TowerFloorRecordOuterClass.TowerFloorRecord.getDefaultInstance());
            }

            public TowerFloorRecordOuterClass.TowerFloorRecord.Builder addTowerFloorRecordListBuilder(int index) {
                return getTowerFloorRecordListFieldBuilder().addBuilder(index, TowerFloorRecordOuterClass.TowerFloorRecord.getDefaultInstance());
            }

            public List<TowerFloorRecordOuterClass.TowerFloorRecord.Builder> getTowerFloorRecordListBuilderList() {
                return getTowerFloorRecordListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TowerFloorRecordOuterClass.TowerFloorRecord, TowerFloorRecordOuterClass.TowerFloorRecord.Builder, TowerFloorRecordOuterClass.TowerFloorRecordOrBuilder> getTowerFloorRecordListFieldBuilder() {
                if (this.towerFloorRecordListBuilder_ == null) {
                    this.towerFloorRecordListBuilder_ = new RepeatedFieldBuilderV3<>(this.towerFloorRecordList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.towerFloorRecordList_ = null;
                }
                return this.towerFloorRecordListBuilder_;
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

        public static TowerFloorRecordChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerFloorRecordChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerFloorRecordChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerFloorRecordChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerFloorRecordOuterClass.getDescriptor();
    }
}
