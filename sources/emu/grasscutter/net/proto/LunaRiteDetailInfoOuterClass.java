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
import emu.grasscutter.net.proto.LunaRiteAreaInfoOuterClass;
import emu.grasscutter.net.proto.LunaRiteHintPointOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteDetailInfoOuterClass.class */
public final class LunaRiteDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018LunaRiteDetailInfo.proto\u001a\u0016LunaRiteAreaInfo.proto\u001a\u0017LunaRiteHintPoint.proto\"g\n\u0012LunaRiteDetailInfo\u0012&\n\nhint_point\u0018\u0004 \u0003(\u000b2\u0012.LunaRiteHintPoint\u0012)\n\u000earea_info_list\u0018\u0007 \u0003(\u000b2\u0011.LunaRiteAreaInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LunaRiteAreaInfoOuterClass.getDescriptor(), LunaRiteHintPointOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LunaRiteDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LunaRiteDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LunaRiteDetailInfo_descriptor, new String[]{"HintPoint", "AreaInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteDetailInfoOuterClass$LunaRiteDetailInfoOrBuilder.class */
    public interface LunaRiteDetailInfoOrBuilder extends MessageOrBuilder {
        List<LunaRiteHintPointOuterClass.LunaRiteHintPoint> getHintPointList();

        LunaRiteHintPointOuterClass.LunaRiteHintPoint getHintPoint(int i);

        int getHintPointCount();

        List<? extends LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder> getHintPointOrBuilderList();

        LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder getHintPointOrBuilder(int i);

        List<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo> getAreaInfoListList();

        LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo getAreaInfoList(int i);

        int getAreaInfoListCount();

        List<? extends LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder> getAreaInfoListOrBuilderList();

        LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder getAreaInfoListOrBuilder(int i);
    }

    private LunaRiteDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteDetailInfoOuterClass$LunaRiteDetailInfo.class */
    public static final class LunaRiteDetailInfo extends GeneratedMessageV3 implements LunaRiteDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HINT_POINT_FIELD_NUMBER = 4;
        private List<LunaRiteHintPointOuterClass.LunaRiteHintPoint> hintPoint_;
        public static final int AREA_INFO_LIST_FIELD_NUMBER = 7;
        private List<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo> areaInfoList_;
        private byte memoizedIsInitialized;
        private static final LunaRiteDetailInfo DEFAULT_INSTANCE = new LunaRiteDetailInfo();
        private static final Parser<LunaRiteDetailInfo> PARSER = new AbstractParser<LunaRiteDetailInfo>() { // from class: emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.1
            @Override // com.google.protobuf.Parser
            public LunaRiteDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LunaRiteDetailInfo(input, extensionRegistry);
            }
        };

        private LunaRiteDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LunaRiteDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.hintPoint_ = Collections.emptyList();
            this.areaInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LunaRiteDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:58:0x00b8 */
        private LunaRiteDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 34:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.hintPoint_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.hintPoint_.add((LunaRiteHintPointOuterClass.LunaRiteHintPoint) input.readMessage(LunaRiteHintPointOuterClass.LunaRiteHintPoint.parser(), extensionRegistry));
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.areaInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.areaInfoList_.add((LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo) input.readMessage(LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.hintPoint_ = Collections.unmodifiableList(this.hintPoint_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.areaInfoList_ = Collections.unmodifiableList(this.areaInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LunaRiteDetailInfoOuterClass.internal_static_LunaRiteDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LunaRiteDetailInfoOuterClass.internal_static_LunaRiteDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LunaRiteDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public List<LunaRiteHintPointOuterClass.LunaRiteHintPoint> getHintPointList() {
            return this.hintPoint_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public List<? extends LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder> getHintPointOrBuilderList() {
            return this.hintPoint_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public int getHintPointCount() {
            return this.hintPoint_.size();
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public LunaRiteHintPointOuterClass.LunaRiteHintPoint getHintPoint(int index) {
            return this.hintPoint_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder getHintPointOrBuilder(int index) {
            return this.hintPoint_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public List<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo> getAreaInfoListList() {
            return this.areaInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public List<? extends LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder> getAreaInfoListOrBuilderList() {
            return this.areaInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public int getAreaInfoListCount() {
            return this.areaInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo getAreaInfoList(int index) {
            return this.areaInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
        public LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder getAreaInfoListOrBuilder(int index) {
            return this.areaInfoList_.get(index);
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
            for (int i = 0; i < this.hintPoint_.size(); i++) {
                output.writeMessage(4, this.hintPoint_.get(i));
            }
            for (int i2 = 0; i2 < this.areaInfoList_.size(); i2++) {
                output.writeMessage(7, this.areaInfoList_.get(i2));
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
            for (int i = 0; i < this.hintPoint_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.hintPoint_.get(i));
            }
            for (int i2 = 0; i2 < this.areaInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.areaInfoList_.get(i2));
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
            if (!(obj instanceof LunaRiteDetailInfo)) {
                return equals(obj);
            }
            LunaRiteDetailInfo other = (LunaRiteDetailInfo) obj;
            return getHintPointList().equals(other.getHintPointList()) && getAreaInfoListList().equals(other.getAreaInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getHintPointCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getHintPointList().hashCode();
            }
            if (getAreaInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getAreaInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static LunaRiteDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteDetailInfo parseFrom(InputStream input) throws IOException {
            return (LunaRiteDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LunaRiteDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LunaRiteDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LunaRiteDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LunaRiteDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LunaRiteDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (LunaRiteDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LunaRiteDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LunaRiteDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteDetailInfoOuterClass$LunaRiteDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LunaRiteDetailInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<LunaRiteHintPointOuterClass.LunaRiteHintPoint, LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder, LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder> hintPointBuilder_;
            private RepeatedFieldBuilderV3<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder> areaInfoListBuilder_;
            private List<LunaRiteHintPointOuterClass.LunaRiteHintPoint> hintPoint_ = Collections.emptyList();
            private List<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo> areaInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return LunaRiteDetailInfoOuterClass.internal_static_LunaRiteDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LunaRiteDetailInfoOuterClass.internal_static_LunaRiteDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LunaRiteDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LunaRiteDetailInfo.alwaysUseFieldBuilders) {
                    getHintPointFieldBuilder();
                    getAreaInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.hintPointBuilder_ == null) {
                    this.hintPoint_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.hintPointBuilder_.clear();
                }
                if (this.areaInfoListBuilder_ == null) {
                    this.areaInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.areaInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LunaRiteDetailInfoOuterClass.internal_static_LunaRiteDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LunaRiteDetailInfo getDefaultInstanceForType() {
                return LunaRiteDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LunaRiteDetailInfo build() {
                LunaRiteDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LunaRiteDetailInfo buildPartial() {
                LunaRiteDetailInfo result = new LunaRiteDetailInfo(this);
                int i = this.bitField0_;
                if (this.hintPointBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.hintPoint_ = Collections.unmodifiableList(this.hintPoint_);
                        this.bitField0_ &= -2;
                    }
                    result.hintPoint_ = this.hintPoint_;
                } else {
                    result.hintPoint_ = this.hintPointBuilder_.build();
                }
                if (this.areaInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.areaInfoList_ = Collections.unmodifiableList(this.areaInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.areaInfoList_ = this.areaInfoList_;
                } else {
                    result.areaInfoList_ = this.areaInfoListBuilder_.build();
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
                if (other instanceof LunaRiteDetailInfo) {
                    return mergeFrom((LunaRiteDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LunaRiteDetailInfo other) {
                if (other == LunaRiteDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.hintPointBuilder_ == null) {
                    if (!other.hintPoint_.isEmpty()) {
                        if (this.hintPoint_.isEmpty()) {
                            this.hintPoint_ = other.hintPoint_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureHintPointIsMutable();
                            this.hintPoint_.addAll(other.hintPoint_);
                        }
                        onChanged();
                    }
                } else if (!other.hintPoint_.isEmpty()) {
                    if (this.hintPointBuilder_.isEmpty()) {
                        this.hintPointBuilder_.dispose();
                        this.hintPointBuilder_ = null;
                        this.hintPoint_ = other.hintPoint_;
                        this.bitField0_ &= -2;
                        this.hintPointBuilder_ = LunaRiteDetailInfo.alwaysUseFieldBuilders ? getHintPointFieldBuilder() : null;
                    } else {
                        this.hintPointBuilder_.addAllMessages(other.hintPoint_);
                    }
                }
                if (this.areaInfoListBuilder_ == null) {
                    if (!other.areaInfoList_.isEmpty()) {
                        if (this.areaInfoList_.isEmpty()) {
                            this.areaInfoList_ = other.areaInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAreaInfoListIsMutable();
                            this.areaInfoList_.addAll(other.areaInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.areaInfoList_.isEmpty()) {
                    if (this.areaInfoListBuilder_.isEmpty()) {
                        this.areaInfoListBuilder_.dispose();
                        this.areaInfoListBuilder_ = null;
                        this.areaInfoList_ = other.areaInfoList_;
                        this.bitField0_ &= -3;
                        this.areaInfoListBuilder_ = LunaRiteDetailInfo.alwaysUseFieldBuilders ? getAreaInfoListFieldBuilder() : null;
                    } else {
                        this.areaInfoListBuilder_.addAllMessages(other.areaInfoList_);
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
                LunaRiteDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LunaRiteDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LunaRiteDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureHintPointIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.hintPoint_ = new ArrayList(this.hintPoint_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public List<LunaRiteHintPointOuterClass.LunaRiteHintPoint> getHintPointList() {
                if (this.hintPointBuilder_ == null) {
                    return Collections.unmodifiableList(this.hintPoint_);
                }
                return this.hintPointBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public int getHintPointCount() {
                if (this.hintPointBuilder_ == null) {
                    return this.hintPoint_.size();
                }
                return this.hintPointBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public LunaRiteHintPointOuterClass.LunaRiteHintPoint getHintPoint(int index) {
                if (this.hintPointBuilder_ == null) {
                    return this.hintPoint_.get(index);
                }
                return this.hintPointBuilder_.getMessage(index);
            }

            public Builder setHintPoint(int index, LunaRiteHintPointOuterClass.LunaRiteHintPoint value) {
                if (this.hintPointBuilder_ != null) {
                    this.hintPointBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHintPointIsMutable();
                    this.hintPoint_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setHintPoint(int index, LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder builderForValue) {
                if (this.hintPointBuilder_ == null) {
                    ensureHintPointIsMutable();
                    this.hintPoint_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.hintPointBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHintPoint(LunaRiteHintPointOuterClass.LunaRiteHintPoint value) {
                if (this.hintPointBuilder_ != null) {
                    this.hintPointBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHintPointIsMutable();
                    this.hintPoint_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addHintPoint(int index, LunaRiteHintPointOuterClass.LunaRiteHintPoint value) {
                if (this.hintPointBuilder_ != null) {
                    this.hintPointBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHintPointIsMutable();
                    this.hintPoint_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addHintPoint(LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder builderForValue) {
                if (this.hintPointBuilder_ == null) {
                    ensureHintPointIsMutable();
                    this.hintPoint_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.hintPointBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHintPoint(int index, LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder builderForValue) {
                if (this.hintPointBuilder_ == null) {
                    ensureHintPointIsMutable();
                    this.hintPoint_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.hintPointBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHintPoint(Iterable<? extends LunaRiteHintPointOuterClass.LunaRiteHintPoint> values) {
                if (this.hintPointBuilder_ == null) {
                    ensureHintPointIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.hintPoint_);
                    onChanged();
                } else {
                    this.hintPointBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHintPoint() {
                if (this.hintPointBuilder_ == null) {
                    this.hintPoint_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.hintPointBuilder_.clear();
                }
                return this;
            }

            public Builder removeHintPoint(int index) {
                if (this.hintPointBuilder_ == null) {
                    ensureHintPointIsMutable();
                    this.hintPoint_.remove(index);
                    onChanged();
                } else {
                    this.hintPointBuilder_.remove(index);
                }
                return this;
            }

            public LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder getHintPointBuilder(int index) {
                return getHintPointFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder getHintPointOrBuilder(int index) {
                if (this.hintPointBuilder_ == null) {
                    return this.hintPoint_.get(index);
                }
                return this.hintPointBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public List<? extends LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder> getHintPointOrBuilderList() {
                if (this.hintPointBuilder_ != null) {
                    return this.hintPointBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.hintPoint_);
            }

            public LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder addHintPointBuilder() {
                return getHintPointFieldBuilder().addBuilder(LunaRiteHintPointOuterClass.LunaRiteHintPoint.getDefaultInstance());
            }

            public LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder addHintPointBuilder(int index) {
                return getHintPointFieldBuilder().addBuilder(index, LunaRiteHintPointOuterClass.LunaRiteHintPoint.getDefaultInstance());
            }

            public List<LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder> getHintPointBuilderList() {
                return getHintPointFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LunaRiteHintPointOuterClass.LunaRiteHintPoint, LunaRiteHintPointOuterClass.LunaRiteHintPoint.Builder, LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder> getHintPointFieldBuilder() {
                if (this.hintPointBuilder_ == null) {
                    this.hintPointBuilder_ = new RepeatedFieldBuilderV3<>(this.hintPoint_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.hintPoint_ = null;
                }
                return this.hintPointBuilder_;
            }

            private void ensureAreaInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.areaInfoList_ = new ArrayList(this.areaInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public List<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo> getAreaInfoListList() {
                if (this.areaInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.areaInfoList_);
                }
                return this.areaInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public int getAreaInfoListCount() {
                if (this.areaInfoListBuilder_ == null) {
                    return this.areaInfoList_.size();
                }
                return this.areaInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo getAreaInfoList(int index) {
                if (this.areaInfoListBuilder_ == null) {
                    return this.areaInfoList_.get(index);
                }
                return this.areaInfoListBuilder_.getMessage(index);
            }

            public Builder setAreaInfoList(int index, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo value) {
                if (this.areaInfoListBuilder_ != null) {
                    this.areaInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAreaInfoListIsMutable();
                    this.areaInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAreaInfoList(int index, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder builderForValue) {
                if (this.areaInfoListBuilder_ == null) {
                    ensureAreaInfoListIsMutable();
                    this.areaInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.areaInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAreaInfoList(LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo value) {
                if (this.areaInfoListBuilder_ != null) {
                    this.areaInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAreaInfoListIsMutable();
                    this.areaInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAreaInfoList(int index, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo value) {
                if (this.areaInfoListBuilder_ != null) {
                    this.areaInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAreaInfoListIsMutable();
                    this.areaInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAreaInfoList(LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder builderForValue) {
                if (this.areaInfoListBuilder_ == null) {
                    ensureAreaInfoListIsMutable();
                    this.areaInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.areaInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAreaInfoList(int index, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder builderForValue) {
                if (this.areaInfoListBuilder_ == null) {
                    ensureAreaInfoListIsMutable();
                    this.areaInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.areaInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAreaInfoList(Iterable<? extends LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo> values) {
                if (this.areaInfoListBuilder_ == null) {
                    ensureAreaInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.areaInfoList_);
                    onChanged();
                } else {
                    this.areaInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAreaInfoList() {
                if (this.areaInfoListBuilder_ == null) {
                    this.areaInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.areaInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAreaInfoList(int index) {
                if (this.areaInfoListBuilder_ == null) {
                    ensureAreaInfoListIsMutable();
                    this.areaInfoList_.remove(index);
                    onChanged();
                } else {
                    this.areaInfoListBuilder_.remove(index);
                }
                return this;
            }

            public LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder getAreaInfoListBuilder(int index) {
                return getAreaInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder getAreaInfoListOrBuilder(int index) {
                if (this.areaInfoListBuilder_ == null) {
                    return this.areaInfoList_.get(index);
                }
                return this.areaInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder
            public List<? extends LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder> getAreaInfoListOrBuilderList() {
                if (this.areaInfoListBuilder_ != null) {
                    return this.areaInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.areaInfoList_);
            }

            public LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder addAreaInfoListBuilder() {
                return getAreaInfoListFieldBuilder().addBuilder(LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.getDefaultInstance());
            }

            public LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder addAreaInfoListBuilder(int index) {
                return getAreaInfoListFieldBuilder().addBuilder(index, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.getDefaultInstance());
            }

            public List<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder> getAreaInfoListBuilderList() {
                return getAreaInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfo.Builder, LunaRiteAreaInfoOuterClass.LunaRiteAreaInfoOrBuilder> getAreaInfoListFieldBuilder() {
                if (this.areaInfoListBuilder_ == null) {
                    this.areaInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.areaInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.areaInfoList_ = null;
                }
                return this.areaInfoListBuilder_;
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

        public static LunaRiteDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LunaRiteDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LunaRiteDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LunaRiteDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LunaRiteAreaInfoOuterClass.getDescriptor();
        LunaRiteHintPointOuterClass.getDescriptor();
    }
}
