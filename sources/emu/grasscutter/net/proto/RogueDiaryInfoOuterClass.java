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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryInfoOuterClass.class */
public final class RogueDiaryInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014RogueDiaryInfo.proto\u001a\u0018RogueDiaryProgress.proto\u001a\u0019RogueDiaryStageInfo.proto\"\u0001\n\u000eRogueDiaryInfo\u0012(\n\u000bcurProgress\u0018\u0005 \u0001(\u000b2\u0013.RogueDiaryProgress\u0012'\n\tstageList\u0018\b \u0003(\u000b2\u0014.RogueDiaryStageInfo\u0012\u0014\n\fleftMonsters\u0018\u0001 \u0001(\b\u0012\u0016\n\u000eisHaveProgress\u0018\r \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RogueDiaryProgressOuterClass.getDescriptor(), RogueDiaryStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RogueDiaryInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RogueDiaryInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RogueDiaryInfo_descriptor, new String[]{"CurProgress", "StageList", "LeftMonsters", "IsHaveProgress"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryInfoOuterClass$RogueDiaryInfoOrBuilder.class */
    public interface RogueDiaryInfoOrBuilder extends MessageOrBuilder {
        boolean hasCurProgress();

        RogueDiaryProgressOuterClass.RogueDiaryProgress getCurProgress();

        RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder getCurProgressOrBuilder();

        List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> getStageListList();

        RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo getStageList(int i);

        int getStageListCount();

        List<? extends RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> getStageListOrBuilderList();

        RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder getStageListOrBuilder(int i);

        boolean getLeftMonsters();

        boolean getIsHaveProgress();
    }

    private RogueDiaryInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryInfoOuterClass$RogueDiaryInfo.class */
    public static final class RogueDiaryInfo extends GeneratedMessageV3 implements RogueDiaryInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CURPROGRESS_FIELD_NUMBER = 5;
        private RogueDiaryProgressOuterClass.RogueDiaryProgress curProgress_;
        public static final int STAGELIST_FIELD_NUMBER = 8;
        private List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> stageList_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 1;
        private boolean leftMonsters_;
        public static final int ISHAVEPROGRESS_FIELD_NUMBER = 13;
        private boolean isHaveProgress_;
        private byte memoizedIsInitialized;
        private static final RogueDiaryInfo DEFAULT_INSTANCE = new RogueDiaryInfo();
        private static final Parser<RogueDiaryInfo> PARSER = new AbstractParser<RogueDiaryInfo>() { // from class: emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfo.1
            @Override // com.google.protobuf.Parser
            public RogueDiaryInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RogueDiaryInfo(input, extensionRegistry);
            }
        };

        private RogueDiaryInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private RogueDiaryInfo() {
            this.memoizedIsInitialized = -1;
            this.stageList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RogueDiaryInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private RogueDiaryInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 42:
                                RogueDiaryProgressOuterClass.RogueDiaryProgress.Builder subBuilder = this.curProgress_ != null ? this.curProgress_.toBuilder() : null;
                                this.curProgress_ = (RogueDiaryProgressOuterClass.RogueDiaryProgress) input.readMessage(RogueDiaryProgressOuterClass.RogueDiaryProgress.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.curProgress_);
                                    this.curProgress_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 66:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.stageList_.add((RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo) input.readMessage(RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.parser(), extensionRegistry));
                                break;
                            case 104:
                                this.isHaveProgress_ = input.readBool();
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
            return RogueDiaryInfoOuterClass.internal_static_RogueDiaryInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RogueDiaryInfoOuterClass.internal_static_RogueDiaryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public boolean hasCurProgress() {
            return this.curProgress_ != null;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public RogueDiaryProgressOuterClass.RogueDiaryProgress getCurProgress() {
            return this.curProgress_ == null ? RogueDiaryProgressOuterClass.RogueDiaryProgress.getDefaultInstance() : this.curProgress_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder getCurProgressOrBuilder() {
            return getCurProgress();
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public List<? extends RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder getStageListOrBuilder(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
        public boolean getIsHaveProgress() {
            return this.isHaveProgress_;
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
            if (this.leftMonsters_) {
                output.writeBool(1, this.leftMonsters_);
            }
            if (this.curProgress_ != null) {
                output.writeMessage(5, getCurProgress());
            }
            for (int i = 0; i < this.stageList_.size(); i++) {
                output.writeMessage(8, this.stageList_.get(i));
            }
            if (this.isHaveProgress_) {
                output.writeBool(13, this.isHaveProgress_);
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
            if (this.leftMonsters_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.leftMonsters_);
            }
            if (this.curProgress_ != null) {
                size2 += CodedOutputStream.computeMessageSize(5, getCurProgress());
            }
            for (int i = 0; i < this.stageList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.stageList_.get(i));
            }
            if (this.isHaveProgress_) {
                size2 += CodedOutputStream.computeBoolSize(13, this.isHaveProgress_);
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
            if (!(obj instanceof RogueDiaryInfo)) {
                return equals(obj);
            }
            RogueDiaryInfo other = (RogueDiaryInfo) obj;
            if (hasCurProgress() != other.hasCurProgress()) {
                return false;
            }
            return (!hasCurProgress() || getCurProgress().equals(other.getCurProgress())) && getStageListList().equals(other.getStageListList()) && getLeftMonsters() == other.getLeftMonsters() && getIsHaveProgress() == other.getIsHaveProgress() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasCurProgress()) {
                hash = (53 * ((37 * hash) + 5)) + getCurProgress().hashCode();
            }
            if (getStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getStageListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 1)) + Internal.hashBoolean(getLeftMonsters()))) + 13)) + Internal.hashBoolean(getIsHaveProgress()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static RogueDiaryInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RogueDiaryInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RogueDiaryInfo parseFrom(InputStream input) throws IOException {
            return (RogueDiaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RogueDiaryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RogueDiaryInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RogueDiaryInfo parseFrom(CodedInputStream input) throws IOException {
            return (RogueDiaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RogueDiaryInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RogueDiaryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RogueDiaryInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RogueDiaryInfoOuterClass$RogueDiaryInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RogueDiaryInfoOrBuilder {
            private int bitField0_;
            private RogueDiaryProgressOuterClass.RogueDiaryProgress curProgress_;
            private SingleFieldBuilderV3<RogueDiaryProgressOuterClass.RogueDiaryProgress, RogueDiaryProgressOuterClass.RogueDiaryProgress.Builder, RogueDiaryProgressOuterClass.RogueDiaryProgressOrBuilder> curProgressBuilder_;
            private List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> stageList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo.Builder, RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder> stageListBuilder_;
            private boolean leftMonsters_;
            private boolean isHaveProgress_;

            public static final Descriptors.Descriptor getDescriptor() {
                return RogueDiaryInfoOuterClass.internal_static_RogueDiaryInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RogueDiaryInfoOuterClass.internal_static_RogueDiaryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RogueDiaryInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RogueDiaryInfo.alwaysUseFieldBuilders) {
                    getStageListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.curProgressBuilder_ == null) {
                    this.curProgress_ = null;
                } else {
                    this.curProgress_ = null;
                    this.curProgressBuilder_ = null;
                }
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageListBuilder_.clear();
                }
                this.leftMonsters_ = false;
                this.isHaveProgress_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RogueDiaryInfoOuterClass.internal_static_RogueDiaryInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RogueDiaryInfo getDefaultInstanceForType() {
                return RogueDiaryInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryInfo build() {
                RogueDiaryInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RogueDiaryInfo buildPartial() {
                RogueDiaryInfo result = new RogueDiaryInfo(this);
                int i = this.bitField0_;
                if (this.curProgressBuilder_ == null) {
                    result.curProgress_ = this.curProgress_;
                } else {
                    result.curProgress_ = this.curProgressBuilder_.build();
                }
                if (this.stageListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageList_ = Collections.unmodifiableList(this.stageList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageList_ = this.stageList_;
                } else {
                    result.stageList_ = this.stageListBuilder_.build();
                }
                result.leftMonsters_ = this.leftMonsters_;
                result.isHaveProgress_ = this.isHaveProgress_;
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
                if (other instanceof RogueDiaryInfo) {
                    return mergeFrom((RogueDiaryInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RogueDiaryInfo other) {
                if (other == RogueDiaryInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasCurProgress()) {
                    mergeCurProgress(other.getCurProgress());
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
                        this.stageListBuilder_ = RogueDiaryInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
                    } else {
                        this.stageListBuilder_.addAllMessages(other.stageList_);
                    }
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.getIsHaveProgress()) {
                    setIsHaveProgress(other.getIsHaveProgress());
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
                RogueDiaryInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RogueDiaryInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RogueDiaryInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
            public boolean hasCurProgress() {
                return (this.curProgressBuilder_ == null && this.curProgress_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
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

            private void ensureStageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageList_ = new ArrayList(this.stageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
            public List<RogueDiaryStageInfoOuterClass.RogueDiaryStageInfo> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
            public RogueDiaryStageInfoOuterClass.RogueDiaryStageInfoOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static RogueDiaryInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RogueDiaryInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RogueDiaryInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RogueDiaryInfo getDefaultInstanceForType() {
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
