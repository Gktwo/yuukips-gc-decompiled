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
import emu.grasscutter.net.proto.CutSceneExtraParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneBeginNotifyOuterClass.class */
public final class CutSceneBeginNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CutSceneBeginNotify.proto\u001a\u0018CutSceneExtraParam.proto\"l\n\u0013CutSceneBeginNotify\u0012\u0014\n\fisWaitOthers\u0018\u0003 \u0001(\b\u0012+\n\u000eextraParamList\u0018\u000e \u0003(\u000b2\u0013.CutSceneExtraParam\u0012\u0012\n\ncutsceneId\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CutSceneExtraParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CutSceneBeginNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CutSceneBeginNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CutSceneBeginNotify_descriptor, new String[]{"IsWaitOthers", "ExtraParamList", "CutsceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneBeginNotifyOuterClass$CutSceneBeginNotifyOrBuilder.class */
    public interface CutSceneBeginNotifyOrBuilder extends MessageOrBuilder {
        boolean getIsWaitOthers();

        List<CutSceneExtraParamOuterClass.CutSceneExtraParam> getExtraParamListList();

        CutSceneExtraParamOuterClass.CutSceneExtraParam getExtraParamList(int i);

        int getExtraParamListCount();

        List<? extends CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder> getExtraParamListOrBuilderList();

        CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder getExtraParamListOrBuilder(int i);

        int getCutsceneId();
    }

    private CutSceneBeginNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneBeginNotifyOuterClass$CutSceneBeginNotify.class */
    public static final class CutSceneBeginNotify extends GeneratedMessageV3 implements CutSceneBeginNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISWAITOTHERS_FIELD_NUMBER = 3;
        private boolean isWaitOthers_;
        public static final int EXTRAPARAMLIST_FIELD_NUMBER = 14;
        private List<CutSceneExtraParamOuterClass.CutSceneExtraParam> extraParamList_;
        public static final int CUTSCENEID_FIELD_NUMBER = 2;
        private int cutsceneId_;
        private byte memoizedIsInitialized;
        private static final CutSceneBeginNotify DEFAULT_INSTANCE = new CutSceneBeginNotify();
        private static final Parser<CutSceneBeginNotify> PARSER = new AbstractParser<CutSceneBeginNotify>() { // from class: emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotify.1
            @Override // com.google.protobuf.Parser
            public CutSceneBeginNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CutSceneBeginNotify(input, extensionRegistry);
            }
        };

        private CutSceneBeginNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CutSceneBeginNotify() {
            this.memoizedIsInitialized = -1;
            this.extraParamList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CutSceneBeginNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CutSceneBeginNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.cutsceneId_ = input.readUInt32();
                                break;
                            case 24:
                                this.isWaitOthers_ = input.readBool();
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.extraParamList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.extraParamList_.add((CutSceneExtraParamOuterClass.CutSceneExtraParam) input.readMessage(CutSceneExtraParamOuterClass.CutSceneExtraParam.parser(), extensionRegistry));
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
                    this.extraParamList_ = Collections.unmodifiableList(this.extraParamList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CutSceneBeginNotifyOuterClass.internal_static_CutSceneBeginNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CutSceneBeginNotifyOuterClass.internal_static_CutSceneBeginNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CutSceneBeginNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
        public boolean getIsWaitOthers() {
            return this.isWaitOthers_;
        }

        @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
        public List<CutSceneExtraParamOuterClass.CutSceneExtraParam> getExtraParamListList() {
            return this.extraParamList_;
        }

        @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
        public List<? extends CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder> getExtraParamListOrBuilderList() {
            return this.extraParamList_;
        }

        @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
        public int getExtraParamListCount() {
            return this.extraParamList_.size();
        }

        @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
        public CutSceneExtraParamOuterClass.CutSceneExtraParam getExtraParamList(int index) {
            return this.extraParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
        public CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder getExtraParamListOrBuilder(int index) {
            return this.extraParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
        public int getCutsceneId() {
            return this.cutsceneId_;
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
            if (this.cutsceneId_ != 0) {
                output.writeUInt32(2, this.cutsceneId_);
            }
            if (this.isWaitOthers_) {
                output.writeBool(3, this.isWaitOthers_);
            }
            for (int i = 0; i < this.extraParamList_.size(); i++) {
                output.writeMessage(14, this.extraParamList_.get(i));
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
            if (this.cutsceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.cutsceneId_);
            }
            if (this.isWaitOthers_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.isWaitOthers_);
            }
            for (int i = 0; i < this.extraParamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.extraParamList_.get(i));
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
            if (!(obj instanceof CutSceneBeginNotify)) {
                return equals(obj);
            }
            CutSceneBeginNotify other = (CutSceneBeginNotify) obj;
            return getIsWaitOthers() == other.getIsWaitOthers() && getExtraParamListList().equals(other.getExtraParamListList()) && getCutsceneId() == other.getCutsceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + Internal.hashBoolean(getIsWaitOthers());
            if (getExtraParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getExtraParamListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getCutsceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CutSceneBeginNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CutSceneBeginNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CutSceneBeginNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CutSceneBeginNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CutSceneBeginNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CutSceneBeginNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CutSceneBeginNotify parseFrom(InputStream input) throws IOException {
            return (CutSceneBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CutSceneBeginNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CutSceneBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CutSceneBeginNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CutSceneBeginNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CutSceneBeginNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CutSceneBeginNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CutSceneBeginNotify parseFrom(CodedInputStream input) throws IOException {
            return (CutSceneBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CutSceneBeginNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CutSceneBeginNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CutSceneBeginNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CutSceneBeginNotifyOuterClass$CutSceneBeginNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CutSceneBeginNotifyOrBuilder {
            private int bitField0_;
            private boolean isWaitOthers_;
            private List<CutSceneExtraParamOuterClass.CutSceneExtraParam> extraParamList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CutSceneExtraParamOuterClass.CutSceneExtraParam, CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder, CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder> extraParamListBuilder_;
            private int cutsceneId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CutSceneBeginNotifyOuterClass.internal_static_CutSceneBeginNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CutSceneBeginNotifyOuterClass.internal_static_CutSceneBeginNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CutSceneBeginNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CutSceneBeginNotify.alwaysUseFieldBuilders) {
                    getExtraParamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isWaitOthers_ = false;
                if (this.extraParamListBuilder_ == null) {
                    this.extraParamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.extraParamListBuilder_.clear();
                }
                this.cutsceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CutSceneBeginNotifyOuterClass.internal_static_CutSceneBeginNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CutSceneBeginNotify getDefaultInstanceForType() {
                return CutSceneBeginNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CutSceneBeginNotify build() {
                CutSceneBeginNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CutSceneBeginNotify buildPartial() {
                CutSceneBeginNotify result = new CutSceneBeginNotify(this);
                int i = this.bitField0_;
                result.isWaitOthers_ = this.isWaitOthers_;
                if (this.extraParamListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.extraParamList_ = Collections.unmodifiableList(this.extraParamList_);
                        this.bitField0_ &= -2;
                    }
                    result.extraParamList_ = this.extraParamList_;
                } else {
                    result.extraParamList_ = this.extraParamListBuilder_.build();
                }
                result.cutsceneId_ = this.cutsceneId_;
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
                if (other instanceof CutSceneBeginNotify) {
                    return mergeFrom((CutSceneBeginNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CutSceneBeginNotify other) {
                if (other == CutSceneBeginNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsWaitOthers()) {
                    setIsWaitOthers(other.getIsWaitOthers());
                }
                if (this.extraParamListBuilder_ == null) {
                    if (!other.extraParamList_.isEmpty()) {
                        if (this.extraParamList_.isEmpty()) {
                            this.extraParamList_ = other.extraParamList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureExtraParamListIsMutable();
                            this.extraParamList_.addAll(other.extraParamList_);
                        }
                        onChanged();
                    }
                } else if (!other.extraParamList_.isEmpty()) {
                    if (this.extraParamListBuilder_.isEmpty()) {
                        this.extraParamListBuilder_.dispose();
                        this.extraParamListBuilder_ = null;
                        this.extraParamList_ = other.extraParamList_;
                        this.bitField0_ &= -2;
                        this.extraParamListBuilder_ = CutSceneBeginNotify.alwaysUseFieldBuilders ? getExtraParamListFieldBuilder() : null;
                    } else {
                        this.extraParamListBuilder_.addAllMessages(other.extraParamList_);
                    }
                }
                if (other.getCutsceneId() != 0) {
                    setCutsceneId(other.getCutsceneId());
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
                CutSceneBeginNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CutSceneBeginNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CutSceneBeginNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
            public boolean getIsWaitOthers() {
                return this.isWaitOthers_;
            }

            public Builder setIsWaitOthers(boolean value) {
                this.isWaitOthers_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsWaitOthers() {
                this.isWaitOthers_ = false;
                onChanged();
                return this;
            }

            private void ensureExtraParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.extraParamList_ = new ArrayList(this.extraParamList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
            public List<CutSceneExtraParamOuterClass.CutSceneExtraParam> getExtraParamListList() {
                if (this.extraParamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.extraParamList_);
                }
                return this.extraParamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
            public int getExtraParamListCount() {
                if (this.extraParamListBuilder_ == null) {
                    return this.extraParamList_.size();
                }
                return this.extraParamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
            public CutSceneExtraParamOuterClass.CutSceneExtraParam getExtraParamList(int index) {
                if (this.extraParamListBuilder_ == null) {
                    return this.extraParamList_.get(index);
                }
                return this.extraParamListBuilder_.getMessage(index);
            }

            public Builder setExtraParamList(int index, CutSceneExtraParamOuterClass.CutSceneExtraParam value) {
                if (this.extraParamListBuilder_ != null) {
                    this.extraParamListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraParamListIsMutable();
                    this.extraParamList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setExtraParamList(int index, CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder builderForValue) {
                if (this.extraParamListBuilder_ == null) {
                    ensureExtraParamListIsMutable();
                    this.extraParamList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraParamListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtraParamList(CutSceneExtraParamOuterClass.CutSceneExtraParam value) {
                if (this.extraParamListBuilder_ != null) {
                    this.extraParamListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraParamListIsMutable();
                    this.extraParamList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraParamList(int index, CutSceneExtraParamOuterClass.CutSceneExtraParam value) {
                if (this.extraParamListBuilder_ != null) {
                    this.extraParamListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureExtraParamListIsMutable();
                    this.extraParamList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addExtraParamList(CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder builderForValue) {
                if (this.extraParamListBuilder_ == null) {
                    ensureExtraParamListIsMutable();
                    this.extraParamList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extraParamListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtraParamList(int index, CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder builderForValue) {
                if (this.extraParamListBuilder_ == null) {
                    ensureExtraParamListIsMutable();
                    this.extraParamList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extraParamListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtraParamList(Iterable<? extends CutSceneExtraParamOuterClass.CutSceneExtraParam> values) {
                if (this.extraParamListBuilder_ == null) {
                    ensureExtraParamListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.extraParamList_);
                    onChanged();
                } else {
                    this.extraParamListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtraParamList() {
                if (this.extraParamListBuilder_ == null) {
                    this.extraParamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.extraParamListBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtraParamList(int index) {
                if (this.extraParamListBuilder_ == null) {
                    ensureExtraParamListIsMutable();
                    this.extraParamList_.remove(index);
                    onChanged();
                } else {
                    this.extraParamListBuilder_.remove(index);
                }
                return this;
            }

            public CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder getExtraParamListBuilder(int index) {
                return getExtraParamListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
            public CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder getExtraParamListOrBuilder(int index) {
                if (this.extraParamListBuilder_ == null) {
                    return this.extraParamList_.get(index);
                }
                return this.extraParamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
            public List<? extends CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder> getExtraParamListOrBuilderList() {
                if (this.extraParamListBuilder_ != null) {
                    return this.extraParamListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.extraParamList_);
            }

            public CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder addExtraParamListBuilder() {
                return getExtraParamListFieldBuilder().addBuilder(CutSceneExtraParamOuterClass.CutSceneExtraParam.getDefaultInstance());
            }

            public CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder addExtraParamListBuilder(int index) {
                return getExtraParamListFieldBuilder().addBuilder(index, CutSceneExtraParamOuterClass.CutSceneExtraParam.getDefaultInstance());
            }

            public List<CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder> getExtraParamListBuilderList() {
                return getExtraParamListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CutSceneExtraParamOuterClass.CutSceneExtraParam, CutSceneExtraParamOuterClass.CutSceneExtraParam.Builder, CutSceneExtraParamOuterClass.CutSceneExtraParamOrBuilder> getExtraParamListFieldBuilder() {
                if (this.extraParamListBuilder_ == null) {
                    this.extraParamListBuilder_ = new RepeatedFieldBuilderV3<>(this.extraParamList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.extraParamList_ = null;
                }
                return this.extraParamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass.CutSceneBeginNotifyOrBuilder
            public int getCutsceneId() {
                return this.cutsceneId_;
            }

            public Builder setCutsceneId(int value) {
                this.cutsceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCutsceneId() {
                this.cutsceneId_ = 0;
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

        public static CutSceneBeginNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CutSceneBeginNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CutSceneBeginNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CutSceneBeginNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CutSceneExtraParamOuterClass.getDescriptor();
    }
}
