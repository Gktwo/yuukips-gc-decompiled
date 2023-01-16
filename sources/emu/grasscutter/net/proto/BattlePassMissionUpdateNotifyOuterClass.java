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
import emu.grasscutter.net.proto.BattlePassMissionOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionUpdateNotifyOuterClass.class */
public final class BattlePassMissionUpdateNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#BattlePassMissionUpdateNotify.proto\u001a\u0017BattlePassMission.proto\"I\n\u001dBattlePassMissionUpdateNotify\u0012(\n\fmission_list\u0018\u0001 \u0003(\u000b2\u0012.BattlePassMissionB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassMissionOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BattlePassMissionUpdateNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BattlePassMissionUpdateNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassMissionUpdateNotify_descriptor, new String[]{"MissionList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionUpdateNotifyOuterClass$BattlePassMissionUpdateNotifyOrBuilder.class */
    public interface BattlePassMissionUpdateNotifyOrBuilder extends MessageOrBuilder {
        List<BattlePassMissionOuterClass.BattlePassMission> getMissionListList();

        BattlePassMissionOuterClass.BattlePassMission getMissionList(int i);

        int getMissionListCount();

        List<? extends BattlePassMissionOuterClass.BattlePassMissionOrBuilder> getMissionListOrBuilderList();

        BattlePassMissionOuterClass.BattlePassMissionOrBuilder getMissionListOrBuilder(int i);
    }

    private BattlePassMissionUpdateNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionUpdateNotifyOuterClass$BattlePassMissionUpdateNotify.class */
    public static final class BattlePassMissionUpdateNotify extends GeneratedMessageV3 implements BattlePassMissionUpdateNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MISSION_LIST_FIELD_NUMBER = 1;
        private List<BattlePassMissionOuterClass.BattlePassMission> missionList_;
        private byte memoizedIsInitialized;
        private static final BattlePassMissionUpdateNotify DEFAULT_INSTANCE = new BattlePassMissionUpdateNotify();
        private static final Parser<BattlePassMissionUpdateNotify> PARSER = new AbstractParser<BattlePassMissionUpdateNotify>() { // from class: emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotify.1
            @Override // com.google.protobuf.Parser
            public BattlePassMissionUpdateNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassMissionUpdateNotify(input, extensionRegistry);
            }
        };

        private BattlePassMissionUpdateNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassMissionUpdateNotify() {
            this.memoizedIsInitialized = -1;
            this.missionList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassMissionUpdateNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassMissionUpdateNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.missionList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.missionList_.add((BattlePassMissionOuterClass.BattlePassMission) input.readMessage(BattlePassMissionOuterClass.BattlePassMission.parser(), extensionRegistry));
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
                    this.missionList_ = Collections.unmodifiableList(this.missionList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BattlePassMissionUpdateNotifyOuterClass.internal_static_BattlePassMissionUpdateNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassMissionUpdateNotifyOuterClass.internal_static_BattlePassMissionUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassMissionUpdateNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
        public List<BattlePassMissionOuterClass.BattlePassMission> getMissionListList() {
            return this.missionList_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
        public List<? extends BattlePassMissionOuterClass.BattlePassMissionOrBuilder> getMissionListOrBuilderList() {
            return this.missionList_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
        public int getMissionListCount() {
            return this.missionList_.size();
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
        public BattlePassMissionOuterClass.BattlePassMission getMissionList(int index) {
            return this.missionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
        public BattlePassMissionOuterClass.BattlePassMissionOrBuilder getMissionListOrBuilder(int index) {
            return this.missionList_.get(index);
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
            for (int i = 0; i < this.missionList_.size(); i++) {
                output.writeMessage(1, this.missionList_.get(i));
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
            for (int i = 0; i < this.missionList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.missionList_.get(i));
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
            if (!(obj instanceof BattlePassMissionUpdateNotify)) {
                return equals(obj);
            }
            BattlePassMissionUpdateNotify other = (BattlePassMissionUpdateNotify) obj;
            return getMissionListList().equals(other.getMissionListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMissionListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getMissionListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BattlePassMissionUpdateNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassMissionUpdateNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassMissionUpdateNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassMissionUpdateNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassMissionUpdateNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassMissionUpdateNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassMissionUpdateNotify parseFrom(InputStream input) throws IOException {
            return (BattlePassMissionUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassMissionUpdateNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassMissionUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassMissionUpdateNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassMissionUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassMissionUpdateNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassMissionUpdateNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassMissionUpdateNotify parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassMissionUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassMissionUpdateNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassMissionUpdateNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassMissionUpdateNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassMissionUpdateNotifyOuterClass$BattlePassMissionUpdateNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassMissionUpdateNotifyOrBuilder {
            private int bitField0_;
            private List<BattlePassMissionOuterClass.BattlePassMission> missionList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BattlePassMissionOuterClass.BattlePassMission, BattlePassMissionOuterClass.BattlePassMission.Builder, BattlePassMissionOuterClass.BattlePassMissionOrBuilder> missionListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassMissionUpdateNotifyOuterClass.internal_static_BattlePassMissionUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassMissionUpdateNotifyOuterClass.internal_static_BattlePassMissionUpdateNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassMissionUpdateNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassMissionUpdateNotify.alwaysUseFieldBuilders) {
                    getMissionListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.missionListBuilder_ == null) {
                    this.missionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.missionListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BattlePassMissionUpdateNotifyOuterClass.internal_static_BattlePassMissionUpdateNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassMissionUpdateNotify getDefaultInstanceForType() {
                return BattlePassMissionUpdateNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassMissionUpdateNotify build() {
                BattlePassMissionUpdateNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassMissionUpdateNotify buildPartial() {
                BattlePassMissionUpdateNotify result = new BattlePassMissionUpdateNotify(this);
                int i = this.bitField0_;
                if (this.missionListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.missionList_ = Collections.unmodifiableList(this.missionList_);
                        this.bitField0_ &= -2;
                    }
                    result.missionList_ = this.missionList_;
                } else {
                    result.missionList_ = this.missionListBuilder_.build();
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
                if (other instanceof BattlePassMissionUpdateNotify) {
                    return mergeFrom((BattlePassMissionUpdateNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassMissionUpdateNotify other) {
                if (other == BattlePassMissionUpdateNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.missionListBuilder_ == null) {
                    if (!other.missionList_.isEmpty()) {
                        if (this.missionList_.isEmpty()) {
                            this.missionList_ = other.missionList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMissionListIsMutable();
                            this.missionList_.addAll(other.missionList_);
                        }
                        onChanged();
                    }
                } else if (!other.missionList_.isEmpty()) {
                    if (this.missionListBuilder_.isEmpty()) {
                        this.missionListBuilder_.dispose();
                        this.missionListBuilder_ = null;
                        this.missionList_ = other.missionList_;
                        this.bitField0_ &= -2;
                        this.missionListBuilder_ = BattlePassMissionUpdateNotify.alwaysUseFieldBuilders ? getMissionListFieldBuilder() : null;
                    } else {
                        this.missionListBuilder_.addAllMessages(other.missionList_);
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
                BattlePassMissionUpdateNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassMissionUpdateNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassMissionUpdateNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMissionListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.missionList_ = new ArrayList(this.missionList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
            public List<BattlePassMissionOuterClass.BattlePassMission> getMissionListList() {
                if (this.missionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.missionList_);
                }
                return this.missionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
            public int getMissionListCount() {
                if (this.missionListBuilder_ == null) {
                    return this.missionList_.size();
                }
                return this.missionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
            public BattlePassMissionOuterClass.BattlePassMission getMissionList(int index) {
                if (this.missionListBuilder_ == null) {
                    return this.missionList_.get(index);
                }
                return this.missionListBuilder_.getMessage(index);
            }

            public Builder setMissionList(int index, BattlePassMissionOuterClass.BattlePassMission value) {
                if (this.missionListBuilder_ != null) {
                    this.missionListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMissionListIsMutable();
                    this.missionList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMissionList(int index, BattlePassMissionOuterClass.BattlePassMission.Builder builderForValue) {
                if (this.missionListBuilder_ == null) {
                    ensureMissionListIsMutable();
                    this.missionList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.missionListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMissionList(BattlePassMissionOuterClass.BattlePassMission value) {
                if (this.missionListBuilder_ != null) {
                    this.missionListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMissionListIsMutable();
                    this.missionList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMissionList(int index, BattlePassMissionOuterClass.BattlePassMission value) {
                if (this.missionListBuilder_ != null) {
                    this.missionListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMissionListIsMutable();
                    this.missionList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMissionList(BattlePassMissionOuterClass.BattlePassMission.Builder builderForValue) {
                if (this.missionListBuilder_ == null) {
                    ensureMissionListIsMutable();
                    this.missionList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.missionListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMissionList(int index, BattlePassMissionOuterClass.BattlePassMission.Builder builderForValue) {
                if (this.missionListBuilder_ == null) {
                    ensureMissionListIsMutable();
                    this.missionList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.missionListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMissionList(Iterable<? extends BattlePassMissionOuterClass.BattlePassMission> values) {
                if (this.missionListBuilder_ == null) {
                    ensureMissionListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.missionList_);
                    onChanged();
                } else {
                    this.missionListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMissionList() {
                if (this.missionListBuilder_ == null) {
                    this.missionList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.missionListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMissionList(int index) {
                if (this.missionListBuilder_ == null) {
                    ensureMissionListIsMutable();
                    this.missionList_.remove(index);
                    onChanged();
                } else {
                    this.missionListBuilder_.remove(index);
                }
                return this;
            }

            public BattlePassMissionOuterClass.BattlePassMission.Builder getMissionListBuilder(int index) {
                return getMissionListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
            public BattlePassMissionOuterClass.BattlePassMissionOrBuilder getMissionListOrBuilder(int index) {
                if (this.missionListBuilder_ == null) {
                    return this.missionList_.get(index);
                }
                return this.missionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BattlePassMissionUpdateNotifyOuterClass.BattlePassMissionUpdateNotifyOrBuilder
            public List<? extends BattlePassMissionOuterClass.BattlePassMissionOrBuilder> getMissionListOrBuilderList() {
                if (this.missionListBuilder_ != null) {
                    return this.missionListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.missionList_);
            }

            public BattlePassMissionOuterClass.BattlePassMission.Builder addMissionListBuilder() {
                return getMissionListFieldBuilder().addBuilder(BattlePassMissionOuterClass.BattlePassMission.getDefaultInstance());
            }

            public BattlePassMissionOuterClass.BattlePassMission.Builder addMissionListBuilder(int index) {
                return getMissionListFieldBuilder().addBuilder(index, BattlePassMissionOuterClass.BattlePassMission.getDefaultInstance());
            }

            public List<BattlePassMissionOuterClass.BattlePassMission.Builder> getMissionListBuilderList() {
                return getMissionListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BattlePassMissionOuterClass.BattlePassMission, BattlePassMissionOuterClass.BattlePassMission.Builder, BattlePassMissionOuterClass.BattlePassMissionOrBuilder> getMissionListFieldBuilder() {
                if (this.missionListBuilder_ == null) {
                    this.missionListBuilder_ = new RepeatedFieldBuilderV3<>(this.missionList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.missionList_ = null;
                }
                return this.missionListBuilder_;
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

        public static BattlePassMissionUpdateNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassMissionUpdateNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassMissionUpdateNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassMissionUpdateNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassMissionOuterClass.getDescriptor();
    }
}
