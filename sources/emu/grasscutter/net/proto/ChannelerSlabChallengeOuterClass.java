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
import emu.grasscutter.net.proto.ChannelerSlabCampOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeOuterClass.class */
public final class ChannelerSlabChallengeOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cChannelerSlabChallenge.proto\u001a\u0017ChannelerSlabCamp.proto\"Z\n\u0016ChannelerSlabChallenge\u0012\u0019\n\u0011active_camp_index\u0018\u0001 \u0001(\r\u0012%\n\tcamp_list\u0018\u000e \u0003(\u000b2\u0012.ChannelerSlabCampB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChannelerSlabCampOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ChannelerSlabChallenge_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChannelerSlabChallenge_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabChallenge_descriptor, new String[]{"ActiveCampIndex", "CampList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeOuterClass$ChannelerSlabChallengeOrBuilder.class */
    public interface ChannelerSlabChallengeOrBuilder extends MessageOrBuilder {
        int getActiveCampIndex();

        List<ChannelerSlabCampOuterClass.ChannelerSlabCamp> getCampListList();

        ChannelerSlabCampOuterClass.ChannelerSlabCamp getCampList(int i);

        int getCampListCount();

        List<? extends ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder> getCampListOrBuilderList();

        ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder getCampListOrBuilder(int i);
    }

    private ChannelerSlabChallengeOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeOuterClass$ChannelerSlabChallenge.class */
    public static final class ChannelerSlabChallenge extends GeneratedMessageV3 implements ChannelerSlabChallengeOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ACTIVE_CAMP_INDEX_FIELD_NUMBER = 1;
        private int activeCampIndex_;
        public static final int CAMP_LIST_FIELD_NUMBER = 14;
        private List<ChannelerSlabCampOuterClass.ChannelerSlabCamp> campList_;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabChallenge DEFAULT_INSTANCE = new ChannelerSlabChallenge();
        private static final Parser<ChannelerSlabChallenge> PARSER = new AbstractParser<ChannelerSlabChallenge>() { // from class: emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallenge.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabChallenge parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabChallenge(input, extensionRegistry);
            }
        };

        private ChannelerSlabChallenge(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabChallenge() {
            this.memoizedIsInitialized = -1;
            this.campList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabChallenge();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private ChannelerSlabChallenge(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.activeCampIndex_ = input.readUInt32();
                                    break;
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.campList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.campList_.add((ChannelerSlabCampOuterClass.ChannelerSlabCamp) input.readMessage(ChannelerSlabCampOuterClass.ChannelerSlabCamp.parser(), extensionRegistry));
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
                    this.campList_ = Collections.unmodifiableList(this.campList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChannelerSlabChallengeOuterClass.internal_static_ChannelerSlabChallenge_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabChallengeOuterClass.internal_static_ChannelerSlabChallenge_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabChallenge.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
        public int getActiveCampIndex() {
            return this.activeCampIndex_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
        public List<ChannelerSlabCampOuterClass.ChannelerSlabCamp> getCampListList() {
            return this.campList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
        public List<? extends ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder> getCampListOrBuilderList() {
            return this.campList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
        public int getCampListCount() {
            return this.campList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
        public ChannelerSlabCampOuterClass.ChannelerSlabCamp getCampList(int index) {
            return this.campList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
        public ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder getCampListOrBuilder(int index) {
            return this.campList_.get(index);
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
            if (this.activeCampIndex_ != 0) {
                output.writeUInt32(1, this.activeCampIndex_);
            }
            for (int i = 0; i < this.campList_.size(); i++) {
                output.writeMessage(14, this.campList_.get(i));
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
            if (this.activeCampIndex_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.activeCampIndex_);
            }
            for (int i = 0; i < this.campList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.campList_.get(i));
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
            if (!(obj instanceof ChannelerSlabChallenge)) {
                return equals(obj);
            }
            ChannelerSlabChallenge other = (ChannelerSlabChallenge) obj;
            return getActiveCampIndex() == other.getActiveCampIndex() && getCampListList().equals(other.getCampListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getActiveCampIndex();
            if (getCampListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getCampListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChannelerSlabChallenge parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabChallenge parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabChallenge parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabChallenge parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabChallenge parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabChallenge parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabChallenge parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabChallenge) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabChallenge parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabChallenge) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabChallenge parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabChallenge) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabChallenge parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabChallenge) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabChallenge parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabChallenge) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabChallenge parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabChallenge) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabChallenge prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabChallengeOuterClass$ChannelerSlabChallenge$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabChallengeOrBuilder {
            private int bitField0_;
            private int activeCampIndex_;
            private List<ChannelerSlabCampOuterClass.ChannelerSlabCamp> campList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ChannelerSlabCampOuterClass.ChannelerSlabCamp, ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder, ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder> campListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabChallengeOuterClass.internal_static_ChannelerSlabChallenge_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabChallengeOuterClass.internal_static_ChannelerSlabChallenge_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabChallenge.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabChallenge.alwaysUseFieldBuilders) {
                    getCampListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.activeCampIndex_ = 0;
                if (this.campListBuilder_ == null) {
                    this.campList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.campListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabChallengeOuterClass.internal_static_ChannelerSlabChallenge_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabChallenge getDefaultInstanceForType() {
                return ChannelerSlabChallenge.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabChallenge build() {
                ChannelerSlabChallenge result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabChallenge buildPartial() {
                ChannelerSlabChallenge result = new ChannelerSlabChallenge(this);
                int i = this.bitField0_;
                result.activeCampIndex_ = this.activeCampIndex_;
                if (this.campListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.campList_ = Collections.unmodifiableList(this.campList_);
                        this.bitField0_ &= -2;
                    }
                    result.campList_ = this.campList_;
                } else {
                    result.campList_ = this.campListBuilder_.build();
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
                if (other instanceof ChannelerSlabChallenge) {
                    return mergeFrom((ChannelerSlabChallenge) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabChallenge other) {
                if (other == ChannelerSlabChallenge.getDefaultInstance()) {
                    return this;
                }
                if (other.getActiveCampIndex() != 0) {
                    setActiveCampIndex(other.getActiveCampIndex());
                }
                if (this.campListBuilder_ == null) {
                    if (!other.campList_.isEmpty()) {
                        if (this.campList_.isEmpty()) {
                            this.campList_ = other.campList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCampListIsMutable();
                            this.campList_.addAll(other.campList_);
                        }
                        onChanged();
                    }
                } else if (!other.campList_.isEmpty()) {
                    if (this.campListBuilder_.isEmpty()) {
                        this.campListBuilder_.dispose();
                        this.campListBuilder_ = null;
                        this.campList_ = other.campList_;
                        this.bitField0_ &= -2;
                        this.campListBuilder_ = ChannelerSlabChallenge.alwaysUseFieldBuilders ? getCampListFieldBuilder() : null;
                    } else {
                        this.campListBuilder_.addAllMessages(other.campList_);
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
                ChannelerSlabChallenge parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabChallenge.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabChallenge) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
            public int getActiveCampIndex() {
                return this.activeCampIndex_;
            }

            public Builder setActiveCampIndex(int value) {
                this.activeCampIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearActiveCampIndex() {
                this.activeCampIndex_ = 0;
                onChanged();
                return this;
            }

            private void ensureCampListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.campList_ = new ArrayList(this.campList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
            public List<ChannelerSlabCampOuterClass.ChannelerSlabCamp> getCampListList() {
                if (this.campListBuilder_ == null) {
                    return Collections.unmodifiableList(this.campList_);
                }
                return this.campListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
            public int getCampListCount() {
                if (this.campListBuilder_ == null) {
                    return this.campList_.size();
                }
                return this.campListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
            public ChannelerSlabCampOuterClass.ChannelerSlabCamp getCampList(int index) {
                if (this.campListBuilder_ == null) {
                    return this.campList_.get(index);
                }
                return this.campListBuilder_.getMessage(index);
            }

            public Builder setCampList(int index, ChannelerSlabCampOuterClass.ChannelerSlabCamp value) {
                if (this.campListBuilder_ != null) {
                    this.campListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCampListIsMutable();
                    this.campList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCampList(int index, ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder builderForValue) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.campListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCampList(ChannelerSlabCampOuterClass.ChannelerSlabCamp value) {
                if (this.campListBuilder_ != null) {
                    this.campListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCampListIsMutable();
                    this.campList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCampList(int index, ChannelerSlabCampOuterClass.ChannelerSlabCamp value) {
                if (this.campListBuilder_ != null) {
                    this.campListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCampListIsMutable();
                    this.campList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCampList(ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder builderForValue) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.campListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCampList(int index, ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder builderForValue) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.campListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCampList(Iterable<? extends ChannelerSlabCampOuterClass.ChannelerSlabCamp> values) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.campList_);
                    onChanged();
                } else {
                    this.campListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCampList() {
                if (this.campListBuilder_ == null) {
                    this.campList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.campListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCampList(int index) {
                if (this.campListBuilder_ == null) {
                    ensureCampListIsMutable();
                    this.campList_.remove(index);
                    onChanged();
                } else {
                    this.campListBuilder_.remove(index);
                }
                return this;
            }

            public ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder getCampListBuilder(int index) {
                return getCampListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
            public ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder getCampListOrBuilder(int index) {
                if (this.campListBuilder_ == null) {
                    return this.campList_.get(index);
                }
                return this.campListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabChallengeOuterClass.ChannelerSlabChallengeOrBuilder
            public List<? extends ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder> getCampListOrBuilderList() {
                if (this.campListBuilder_ != null) {
                    return this.campListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.campList_);
            }

            public ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder addCampListBuilder() {
                return getCampListFieldBuilder().addBuilder(ChannelerSlabCampOuterClass.ChannelerSlabCamp.getDefaultInstance());
            }

            public ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder addCampListBuilder(int index) {
                return getCampListFieldBuilder().addBuilder(index, ChannelerSlabCampOuterClass.ChannelerSlabCamp.getDefaultInstance());
            }

            public List<ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder> getCampListBuilderList() {
                return getCampListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChannelerSlabCampOuterClass.ChannelerSlabCamp, ChannelerSlabCampOuterClass.ChannelerSlabCamp.Builder, ChannelerSlabCampOuterClass.ChannelerSlabCampOrBuilder> getCampListFieldBuilder() {
                if (this.campListBuilder_ == null) {
                    this.campListBuilder_ = new RepeatedFieldBuilderV3<>(this.campList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.campList_ = null;
                }
                return this.campListBuilder_;
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

        public static ChannelerSlabChallenge getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabChallenge> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabChallenge> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabChallenge getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChannelerSlabCampOuterClass.getDescriptor();
    }
}
