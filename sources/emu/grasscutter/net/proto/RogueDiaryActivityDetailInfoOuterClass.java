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
import emu.grasscutter.net.proto.RogueDiaryProgressOuterClass;
import emu.grasscutter.net.proto.RogueDiaryStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryActivityDetailInfoOuterClass.class */
public final class RogueDiaryActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"RogueDiaryActivityDetailInfo.proto\u001a\u0018RogueDiaryProgress.proto\u001a\u0019RogueDiaryStageInfo.proto\"¨\u0001\n\u001cRogueDiaryActivityDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\u0003 \u0001(\b\u0012(\n\nstage_list\u0018\u000b \u0003(\u000b2\u0014.RogueDiaryStageInfo\u0012\u0018\n\u0010is_have_progress\u0018\u0005 \u0001(\b\u0012)\n\fcur_progress\u0018\n \u0001(\u000b2\u0013.RogueDiaryProgressB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RogueDiaryProgressOuterClass.getDescriptor(), RogueDiaryStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RogueDiaryActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueDiaryActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueDiaryActivityDetailInfo_descriptor, new String[]{"IsContentClosed", "StageList", "IsHaveProgress", "CurProgress"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryActivityDetailInfoOuterClass$RogueDiaryActivityDetailInfoOrBuilder.class */
    public interface RogueDiaryActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> getStageListList();

        RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo getStageList(int i);

        int getStageListCount();

        List<? extends RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> getStageListOrBuilderList();

        RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder getStageListOrBuilder(int i);

        boolean getIsHaveProgress();

        boolean hasCurProgress();

        RogueDiaryProgressOuterClass.RogueDiaryProgress getCurProgress();

        RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder getCurProgressOrBuilder();
    }

    private RogueDiaryActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryActivityDetailInfoOuterClass$RogueDiaryActivityDetailInfo.class */
    public static final class RogueDiaryActivityDetailInfo extends GeneratedMessageV3 implements RogueDiaryActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 3;
        private boolean isContentClosed_;
        public static final int STAGE_LIST_FIELD_NUMBER = 11;
        private List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> stageList_;
        public static final int IS_HAVE_PROGRESS_FIELD_NUMBER = 5;
        private boolean isHaveProgress_;
        public static final int CUR_PROGRESS_FIELD_NUMBER = 10;
        private RogueDiaryProgressOuterClass.RogueDiaryProgress curProgress_;
        private byte memoizedIsInitialized;
        private static final RogueDiaryActivityDetailInfo DEFAULT_INSTANCE = new RogueDiaryActivityDetailInfo();
        private static final Parser<RogueDiaryActivityDetailInfo> PARSER = new AbstractParser<RogueDiaryActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public RogueDiaryActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueDiaryActivityDetailInfo(input, extensionRegistry);
            }
        };

        private RogueDiaryActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueDiaryActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.stageList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueDiaryActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueDiaryActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 40:
                                this.isHaveProgress_ = input.readBool();
                                break;
                            case 82:
                                RogueDiaryProgressOuterClass.RogueDiaryProgress.Builder subBuilder = this.curProgress_ != null ? this.curProgress_.toBuilder() : null;
                                this.curProgress_ = (RogueDiaryProgressOuterClass.RogueDiaryProgress) input.readMessage(RogueDiaryProgressOuterClass.RogueDiaryProgress.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.curProgress_);
                                    this.curProgress_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 90:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.stageList_.add((RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo) input.readMessage(RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.parser(), extensionRegistry));
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
                    this.stageList_ = Collections.unmodifiableList(this.stageList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RogueDiaryActivityDetailInfoOuterClass.internal_static_RogueDiaryActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueDiaryActivityDetailInfoOuterClass.internal_static_RogueDiaryActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public List<? extends RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder getStageListOrBuilder(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public boolean getIsHaveProgress() {
            return this.isHaveProgress_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public boolean hasCurProgress() {
            return this.curProgress_ != null;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public RogueDiaryProgressOuterClass.RogueDiaryProgress getCurProgress() {
            return this.curProgress_ == null ? RogueDiaryProgressOuterClass.RogueDiaryProgress.getDefaultInstance() : this.curProgress_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
        public RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder getCurProgressOrBuilder() {
            return getCurProgress();
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
            if (this.isContentClosed_) {
                output.writeBool(3, this.isContentClosed_);
            }
            if (this.isHaveProgress_) {
                output.writeBool(5, this.isHaveProgress_);
            }
            if (this.curProgress_ != null) {
                output.writeMessage(10, getCurProgress());
            }
            for (int i = 0; i < this.stageList_.size(); i++) {
                output.writeMessage(11, this.stageList_.get(i));
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
            if (this.isContentClosed_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(3, this.isContentClosed_);
            }
            if (this.isHaveProgress_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isHaveProgress_);
            }
            if (this.curProgress_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getCurProgress());
            }
            for (int i = 0; i < this.stageList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.stageList_.get(i));
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
            if (!(obj instanceof RogueDiaryActivityDetailInfo)) {
                return equals(obj);
            }
            RogueDiaryActivityDetailInfo other = (RogueDiaryActivityDetailInfo) obj;
            if (getIsContentClosed() == other.getIsContentClosed() && getStageListList().equals(other.getStageListList()) && getIsHaveProgress() == other.getIsHaveProgress() && hasCurProgress() == other.hasCurProgress()) {
                return (!hasCurProgress() || getCurProgress().equals(other.getCurProgress())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashBoolean(getIsContentClosed());
            if (getStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getStageListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 5)) + Internal.hashBoolean(getIsHaveProgress());
            if (hasCurProgress()) {
                hash2 = (53 * ((37 * hash2) + 10)) + getCurProgress().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static RogueDiaryActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (RogueDiaryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueDiaryActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueDiaryActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (RogueDiaryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueDiaryActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryActivityDetailInfoOuterClass$RogueDiaryActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueDiaryActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isContentClosed_;
            private List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> stageList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> stageListBuilder_;
            private boolean isHaveProgress_;
            private RogueDiaryProgressOuterClass.RogueDiaryProgress curProgress_;
            private SingleFieldBuilderV3<RogueDiaryProgressOuterClass.RogueDiaryProgress, RogueDiaryProgressOuterClass.RogueDiaryProgress.Builder, RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder> curProgressBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueDiaryActivityDetailInfoOuterClass.internal_static_RogueDiaryActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueDiaryActivityDetailInfoOuterClass.internal_static_RogueDiaryActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueDiaryActivityDetailInfo.alwaysUseFieldBuilders) {
                    getStageListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageListBuilder_.clear();
                }
                this.isHaveProgress_ = false;
                if (this.curProgressBuilder_ == null) {
                    this.curProgress_ = null;
                } else {
                    this.curProgress_ = null;
                    this.curProgressBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueDiaryActivityDetailInfoOuterClass.internal_static_RogueDiaryActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueDiaryActivityDetailInfo getDefaultInstanceForType() {
                return RogueDiaryActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryActivityDetailInfo build() {
                RogueDiaryActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryActivityDetailInfo buildPartial() {
                RogueDiaryActivityDetailInfo result = new RogueDiaryActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isContentClosed_ = this.isContentClosed_;
                if (this.stageListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageList_ = Collections.unmodifiableList(this.stageList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageList_ = this.stageList_;
                } else {
                    result.stageList_ = this.stageListBuilder_.build();
                }
                result.isHaveProgress_ = this.isHaveProgress_;
                if (this.curProgressBuilder_ == null) {
                    result.curProgress_ = this.curProgress_;
                } else {
                    result.curProgress_ = this.curProgressBuilder_.build();
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
                if (other instanceof RogueDiaryActivityDetailInfo) {
                    return mergeFrom((RogueDiaryActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueDiaryActivityDetailInfo other) {
                if (other == RogueDiaryActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (this.stageListBuilder_ == null) {
                    if (!other.stageList_.isEmpty()) {
                        if (this.stageList_.isEmpty()) {
                            this.stageList_ = other.stageList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageListIsMutable();
                            this.stageList_.addAll(other.stageList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageList_.isEmpty()) {
                    if (this.stageListBuilder_.isEmpty()) {
                        this.stageListBuilder_.dispose();
                        this.stageListBuilder_ = null;
                        this.stageList_ = other.stageList_;
                        this.bitField0_ &= -2;
                        this.stageListBuilder_ = RogueDiaryActivityDetailInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
                    } else {
                        this.stageListBuilder_.addAllMessages(other.stageList_);
                    }
                }
                if (other.getIsHaveProgress()) {
                    setIsHaveProgress(other.getIsHaveProgress());
                }
                if (other.hasCurProgress()) {
                    mergeCurProgress(other.getCurProgress());
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
                RogueDiaryActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueDiaryActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueDiaryActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            private void ensureStageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageList_ = new ArrayList(this.stageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo getStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessage(index);
            }

            public Builder setStageList(int index, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageList(int index, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(int index, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(int index, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageList(Iterable<? extends RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> values) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageList_);
                    onChanged();
                } else {
                    this.stageListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageList() {
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.remove(index);
                    onChanged();
                } else {
                    this.stageListBuilder_.remove(index);
                }
                return this;
            }

            public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder getStageListBuilder(int index) {
                return getStageListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public List<? extends RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> getStageListOrBuilderList() {
                if (this.stageListBuilder_ != null) {
                    return this.stageListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageList_);
            }

            public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder addStageListBuilder() {
                return getStageListFieldBuilder().addBuilder(RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.getDefaultInstance());
            }

            public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder addStageListBuilder(int index) {
                return getStageListFieldBuilder().addBuilder(index, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.getDefaultInstance());
            }

            public List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder> getStageListBuilderList() {
                return getStageListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> getStageListFieldBuilder() {
                if (this.stageListBuilder_ == null) {
                    this.stageListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageList_ = null;
                }
                return this.stageListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public boolean getIsHaveProgress() {
                return this.isHaveProgress_;
            }

            public Builder setIsHaveProgress(boolean value) {
                this.isHaveProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsHaveProgress() {
                this.isHaveProgress_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public boolean hasCurProgress() {
                return (this.curProgressBuilder_ == null && this.curProgress_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public RogueDiaryProgressOuterClass.RogueDiaryProgress getCurProgress() {
                if (this.curProgressBuilder_ == null) {
                    return this.curProgress_ == null ? RogueDiaryProgressOuterClass.RogueDiaryProgress.getDefaultInstance() : this.curProgress_;
                }
                return this.curProgressBuilder_.getMessage();
            }

            public Builder setCurProgress(RogueDiaryProgressOuterClass.RogueDiaryProgress value) {
                if (this.curProgressBuilder_ != null) {
                    this.curProgressBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.curProgress_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCurProgress(RogueDiaryProgressOuterClass.RogueDiaryProgress.Builder builderForValue) {
                if (this.curProgressBuilder_ == null) {
                    this.curProgress_ = builderForValue.build();
                    onChanged();
                } else {
                    this.curProgressBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCurProgress(RogueDiaryProgressOuterClass.RogueDiaryProgress value) {
                if (this.curProgressBuilder_ == null) {
                    if (this.curProgress_ != null) {
                        this.curProgress_ = RogueDiaryProgressOuterClass.RogueDiaryProgress.newBuilder(this.curProgress_).mergeFrom(value).buildPartial();
                    } else {
                        this.curProgress_ = value;
                    }
                    onChanged();
                } else {
                    this.curProgressBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCurProgress() {
                if (this.curProgressBuilder_ == null) {
                    this.curProgress_ = null;
                    onChanged();
                } else {
                    this.curProgress_ = null;
                    this.curProgressBuilder_ = null;
                }
                return this;
            }

            public RogueDiaryProgressOuterClass.RogueDiaryProgress.Builder getCurProgressBuilder() {
                onChanged();
                return getCurProgressFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder
            public RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder getCurProgressOrBuilder() {
                if (this.curProgressBuilder_ != null) {
                    return this.curProgressBuilder_.getMessageOrBuilder();
                }
                return this.curProgress_ == null ? RogueDiaryProgressOuterClass.RogueDiaryProgress.getDefaultInstance() : this.curProgress_;
            }

            private SingleFieldBuilderV3<RogueDiaryProgressOuterClass.RogueDiaryProgress, RogueDiaryProgressOuterClass.RogueDiaryProgress.Builder, RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder> getCurProgressFieldBuilder() {
                if (this.curProgressBuilder_ == null) {
                    this.curProgressBuilder_ = new SingleFieldBuilderV3<>(getCurProgress(), getParentForChildren(), isClean());
                    this.curProgress_ = null;
                }
                return this.curProgressBuilder_;
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

        public static RogueDiaryActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueDiaryActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueDiaryActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueDiaryActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RogueDiaryProgressOuterClass.getDescriptor();
        RogueDiaryStageInfoOuterClass.getDescriptor();
    }
}
