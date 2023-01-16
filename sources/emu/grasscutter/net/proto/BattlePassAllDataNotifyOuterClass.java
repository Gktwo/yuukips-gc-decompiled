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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BattlePassMissionOuterClass;
import emu.grasscutter.net.proto.BattlePassScheduleOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassAllDataNotifyOuterClass.class */
public final class BattlePassAllDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dBattlePassAllDataNotify.proto\u001a\u0017BattlePassMission.proto\u001a\u0018BattlePassSchedule.proto\"\u0001\n\u0017BattlePassAllDataNotify\u0012(\n\fmission_list\u0018\u0001 \u0003(\u000b2\u0012.BattlePassMission\u0012)\n\fcur_schedule\u0018\n \u0001(\u000b2\u0013.BattlePassSchedule\u0012\u0019\n\u0011have_cur_schedule\u0018\u0003 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BattlePassMissionOuterClass.getDescriptor(), BattlePassScheduleOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BattlePassAllDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BattlePassAllDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BattlePassAllDataNotify_descriptor, new String[]{"MissionList", "CurSchedule", "HaveCurSchedule"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassAllDataNotifyOuterClass$BattlePassAllDataNotifyOrBuilder.class */
    public interface BattlePassAllDataNotifyOrBuilder extends MessageOrBuilder {
        List<BattlePassMissionOuterClass.BattlePassMission> getMissionListList();

        BattlePassMissionOuterClass.BattlePassMission getMissionList(int i);

        int getMissionListCount();

        List<? extends BattlePassMissionOuterClass.BattlePassMissionOrBuilder> getMissionListOrBuilderList();

        BattlePassMissionOuterClass.BattlePassMissionOrBuilder getMissionListOrBuilder(int i);

        boolean hasCurSchedule();

        BattlePassScheduleOuterClass.BattlePassSchedule getCurSchedule();

        BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder getCurScheduleOrBuilder();

        boolean getHaveCurSchedule();
    }

    private BattlePassAllDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassAllDataNotifyOuterClass$BattlePassAllDataNotify.class */
    public static final class BattlePassAllDataNotify extends GeneratedMessageV3 implements BattlePassAllDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MISSION_LIST_FIELD_NUMBER = 1;
        private List<BattlePassMissionOuterClass.BattlePassMission> missionList_;
        public static final int CUR_SCHEDULE_FIELD_NUMBER = 10;
        private BattlePassScheduleOuterClass.BattlePassSchedule curSchedule_;
        public static final int HAVE_CUR_SCHEDULE_FIELD_NUMBER = 3;
        private boolean haveCurSchedule_;
        private byte memoizedIsInitialized;
        private static final BattlePassAllDataNotify DEFAULT_INSTANCE = new BattlePassAllDataNotify();
        private static final Parser<BattlePassAllDataNotify> PARSER = new AbstractParser<BattlePassAllDataNotify>() { // from class: emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotify.1
            @Override // com.google.protobuf.Parser
            public BattlePassAllDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BattlePassAllDataNotify(input, extensionRegistry);
            }
        };

        private BattlePassAllDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BattlePassAllDataNotify() {
            this.memoizedIsInitialized = -1;
            this.missionList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BattlePassAllDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BattlePassAllDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.missionList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.missionList_.add((BattlePassMissionOuterClass.BattlePassMission) input.readMessage(BattlePassMissionOuterClass.BattlePassMission.parser(), extensionRegistry));
                                break;
                            case 24:
                                this.haveCurSchedule_ = input.readBool();
                                break;
                            case 82:
                                BattlePassScheduleOuterClass.BattlePassSchedule.Builder subBuilder = this.curSchedule_ != null ? this.curSchedule_.toBuilder() : null;
                                this.curSchedule_ = (BattlePassScheduleOuterClass.BattlePassSchedule) input.readMessage(BattlePassScheduleOuterClass.BattlePassSchedule.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.curSchedule_);
                                    this.curSchedule_ = subBuilder.buildPartial();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.missionList_ = Collections.unmodifiableList(this.missionList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BattlePassAllDataNotifyOuterClass.internal_static_BattlePassAllDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BattlePassAllDataNotifyOuterClass.internal_static_BattlePassAllDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassAllDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public List<BattlePassMissionOuterClass.BattlePassMission> getMissionListList() {
            return this.missionList_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public List<? extends BattlePassMissionOuterClass.BattlePassMissionOrBuilder> getMissionListOrBuilderList() {
            return this.missionList_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public int getMissionListCount() {
            return this.missionList_.size();
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public BattlePassMissionOuterClass.BattlePassMission getMissionList(int index) {
            return this.missionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public BattlePassMissionOuterClass.BattlePassMissionOrBuilder getMissionListOrBuilder(int index) {
            return this.missionList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public boolean hasCurSchedule() {
            return this.curSchedule_ != null;
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public BattlePassScheduleOuterClass.BattlePassSchedule getCurSchedule() {
            return this.curSchedule_ == null ? BattlePassScheduleOuterClass.BattlePassSchedule.getDefaultInstance() : this.curSchedule_;
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
        public BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder getCurScheduleOrBuilder() {
            return getCurSchedule();
        }

        @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
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
            for (int i = 0; i < this.missionList_.size(); i++) {
                output.writeMessage(1, this.missionList_.get(i));
            }
            if (this.haveCurSchedule_) {
                output.writeBool(3, this.haveCurSchedule_);
            }
            if (this.curSchedule_ != null) {
                output.writeMessage(10, getCurSchedule());
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
            if (this.haveCurSchedule_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.haveCurSchedule_);
            }
            if (this.curSchedule_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getCurSchedule());
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
            if (!(obj instanceof BattlePassAllDataNotify)) {
                return equals(obj);
            }
            BattlePassAllDataNotify other = (BattlePassAllDataNotify) obj;
            if (getMissionListList().equals(other.getMissionListList()) && hasCurSchedule() == other.hasCurSchedule()) {
                return (!hasCurSchedule() || getCurSchedule().equals(other.getCurSchedule())) && getHaveCurSchedule() == other.getHaveCurSchedule() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
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
            if (hasCurSchedule()) {
                hash = (53 * ((37 * hash) + 10)) + getCurSchedule().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + Internal.hashBoolean(getHaveCurSchedule()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BattlePassAllDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassAllDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassAllDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassAllDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassAllDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BattlePassAllDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BattlePassAllDataNotify parseFrom(InputStream input) throws IOException {
            return (BattlePassAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassAllDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassAllDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (BattlePassAllDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BattlePassAllDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassAllDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BattlePassAllDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (BattlePassAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BattlePassAllDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BattlePassAllDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BattlePassAllDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BattlePassAllDataNotifyOuterClass$BattlePassAllDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BattlePassAllDataNotifyOrBuilder {
            private int bitField0_;
            private List<BattlePassMissionOuterClass.BattlePassMission> missionList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BattlePassMissionOuterClass.BattlePassMission, BattlePassMissionOuterClass.BattlePassMission.Builder, BattlePassMissionOuterClass.BattlePassMissionOrBuilder> missionListBuilder_;
            private BattlePassScheduleOuterClass.BattlePassSchedule curSchedule_;
            private SingleFieldBuilderV3<BattlePassScheduleOuterClass.BattlePassSchedule, BattlePassScheduleOuterClass.BattlePassSchedule.Builder, BattlePassScheduleOuterClass.BattlePassScheduleOrBuilder> curScheduleBuilder_;
            private boolean haveCurSchedule_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BattlePassAllDataNotifyOuterClass.internal_static_BattlePassAllDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BattlePassAllDataNotifyOuterClass.internal_static_BattlePassAllDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(BattlePassAllDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BattlePassAllDataNotify.alwaysUseFieldBuilders) {
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
                return BattlePassAllDataNotifyOuterClass.internal_static_BattlePassAllDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BattlePassAllDataNotify getDefaultInstanceForType() {
                return BattlePassAllDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassAllDataNotify build() {
                BattlePassAllDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BattlePassAllDataNotify buildPartial() {
                BattlePassAllDataNotify result = new BattlePassAllDataNotify(this);
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
                if (other instanceof BattlePassAllDataNotify) {
                    return mergeFrom((BattlePassAllDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BattlePassAllDataNotify other) {
                if (other == BattlePassAllDataNotify.getDefaultInstance()) {
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
                        this.missionListBuilder_ = BattlePassAllDataNotify.alwaysUseFieldBuilders ? getMissionListFieldBuilder() : null;
                    } else {
                        this.missionListBuilder_.addAllMessages(other.missionList_);
                    }
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
                BattlePassAllDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = BattlePassAllDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BattlePassAllDataNotify) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
            public List<BattlePassMissionOuterClass.BattlePassMission> getMissionListList() {
                if (this.missionListBuilder_ == null) {
                    return Collections.unmodifiableList(this.missionList_);
                }
                return this.missionListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
            public int getMissionListCount() {
                if (this.missionListBuilder_ == null) {
                    return this.missionList_.size();
                }
                return this.missionListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
            public BattlePassMissionOuterClass.BattlePassMissionOrBuilder getMissionListOrBuilder(int index) {
                if (this.missionListBuilder_ == null) {
                    return this.missionList_.get(index);
                }
                return this.missionListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
            public boolean hasCurSchedule() {
                return (this.curScheduleBuilder_ == null && this.curSchedule_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
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

            @Override // emu.grasscutter.net.proto.BattlePassAllDataNotifyOuterClass.BattlePassAllDataNotifyOrBuilder
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

        public static BattlePassAllDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BattlePassAllDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BattlePassAllDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BattlePassAllDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BattlePassMissionOuterClass.getDescriptor();
        BattlePassScheduleOuterClass.getDescriptor();
    }
}
