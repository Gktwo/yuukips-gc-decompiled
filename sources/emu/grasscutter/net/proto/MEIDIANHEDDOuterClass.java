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
import emu.grasscutter.net.proto.OMNAAMAIBOHOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MEIDIANHEDDOuterClass.class */
public final class MEIDIANHEDDOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011MEIDIANHEDD.proto\u001a\u0011OMNAAMAIBOH.proto\"2\n\u000bMEIDIANHEDD\u0012#\n\rstageInfoList\u0018\f \u0003(\u000b2\f.OMNAAMAIBOHB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{OMNAAMAIBOHOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MEIDIANHEDD_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MEIDIANHEDD_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MEIDIANHEDD_descriptor, new String[]{"StageInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MEIDIANHEDDOuterClass$MEIDIANHEDDOrBuilder.class */
    public interface MEIDIANHEDDOrBuilder extends MessageOrBuilder {
        List<OMNAAMAIBOHOuterClass.OMNAAMAIBOH> getStageInfoListList();

        OMNAAMAIBOHOuterClass.OMNAAMAIBOH getStageInfoList(int i);

        int getStageInfoListCount();

        List<? extends OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder> getStageInfoListOrBuilderList();

        OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder getStageInfoListOrBuilder(int i);
    }

    private MEIDIANHEDDOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MEIDIANHEDDOuterClass$MEIDIANHEDD.class */
    public static final class MEIDIANHEDD extends GeneratedMessageV3 implements MEIDIANHEDDOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGEINFOLIST_FIELD_NUMBER = 12;
        private List<OMNAAMAIBOHOuterClass.OMNAAMAIBOH> stageInfoList_;
        private byte memoizedIsInitialized;
        private static final MEIDIANHEDD DEFAULT_INSTANCE = new MEIDIANHEDD();
        private static final Parser<MEIDIANHEDD> PARSER = new AbstractParser<MEIDIANHEDD>() { // from class: emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDD.1
            @Override // com.google.protobuf.Parser
            public MEIDIANHEDD parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MEIDIANHEDD(input, extensionRegistry);
            }
        };

        private MEIDIANHEDD(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MEIDIANHEDD() {
            this.memoizedIsInitialized = -1;
            this.stageInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MEIDIANHEDD();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MEIDIANHEDD(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 98:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.stageInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.stageInfoList_.add((OMNAAMAIBOHOuterClass.OMNAAMAIBOH) input.readMessage(OMNAAMAIBOHOuterClass.OMNAAMAIBOH.parser(), extensionRegistry));
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
                    this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MEIDIANHEDDOuterClass.internal_static_MEIDIANHEDD_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MEIDIANHEDDOuterClass.internal_static_MEIDIANHEDD_fieldAccessorTable.ensureFieldAccessorsInitialized(MEIDIANHEDD.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
        public List<OMNAAMAIBOHOuterClass.OMNAAMAIBOH> getStageInfoListList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
        public List<? extends OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder> getStageInfoListOrBuilderList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
        public int getStageInfoListCount() {
            return this.stageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
        public OMNAAMAIBOHOuterClass.OMNAAMAIBOH getStageInfoList(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
        public OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder getStageInfoListOrBuilder(int index) {
            return this.stageInfoList_.get(index);
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                output.writeMessage(12, this.stageInfoList_.get(i));
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(12, this.stageInfoList_.get(i));
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
            if (!(obj instanceof MEIDIANHEDD)) {
                return equals(obj);
            }
            MEIDIANHEDD other = (MEIDIANHEDD) obj;
            return getStageInfoListList().equals(other.getStageInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getStageInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MEIDIANHEDD parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MEIDIANHEDD parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MEIDIANHEDD parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MEIDIANHEDD parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MEIDIANHEDD parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MEIDIANHEDD parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MEIDIANHEDD parseFrom(InputStream input) throws IOException {
            return (MEIDIANHEDD) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MEIDIANHEDD parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MEIDIANHEDD) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MEIDIANHEDD parseDelimitedFrom(InputStream input) throws IOException {
            return (MEIDIANHEDD) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MEIDIANHEDD parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MEIDIANHEDD) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MEIDIANHEDD parseFrom(CodedInputStream input) throws IOException {
            return (MEIDIANHEDD) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MEIDIANHEDD parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MEIDIANHEDD) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MEIDIANHEDD prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MEIDIANHEDDOuterClass$MEIDIANHEDD$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MEIDIANHEDDOrBuilder {
            private int bitField0_;
            private List<OMNAAMAIBOHOuterClass.OMNAAMAIBOH> stageInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<OMNAAMAIBOHOuterClass.OMNAAMAIBOH, OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder, OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder> stageInfoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MEIDIANHEDDOuterClass.internal_static_MEIDIANHEDD_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MEIDIANHEDDOuterClass.internal_static_MEIDIANHEDD_fieldAccessorTable.ensureFieldAccessorsInitialized(MEIDIANHEDD.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MEIDIANHEDD.alwaysUseFieldBuilders) {
                    getStageInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MEIDIANHEDDOuterClass.internal_static_MEIDIANHEDD_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MEIDIANHEDD getDefaultInstanceForType() {
                return MEIDIANHEDD.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MEIDIANHEDD build() {
                MEIDIANHEDD result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MEIDIANHEDD buildPartial() {
                MEIDIANHEDD result = new MEIDIANHEDD(this);
                int i = this.bitField0_;
                if (this.stageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageInfoList_ = this.stageInfoList_;
                } else {
                    result.stageInfoList_ = this.stageInfoListBuilder_.build();
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
                if (other instanceof MEIDIANHEDD) {
                    return mergeFrom((MEIDIANHEDD) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MEIDIANHEDD other) {
                if (other == MEIDIANHEDD.getDefaultInstance()) {
                    return this;
                }
                if (this.stageInfoListBuilder_ == null) {
                    if (!other.stageInfoList_.isEmpty()) {
                        if (this.stageInfoList_.isEmpty()) {
                            this.stageInfoList_ = other.stageInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageInfoListIsMutable();
                            this.stageInfoList_.addAll(other.stageInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageInfoList_.isEmpty()) {
                    if (this.stageInfoListBuilder_.isEmpty()) {
                        this.stageInfoListBuilder_.dispose();
                        this.stageInfoListBuilder_ = null;
                        this.stageInfoList_ = other.stageInfoList_;
                        this.bitField0_ &= -2;
                        this.stageInfoListBuilder_ = MEIDIANHEDD.alwaysUseFieldBuilders ? getStageInfoListFieldBuilder() : null;
                    } else {
                        this.stageInfoListBuilder_.addAllMessages(other.stageInfoList_);
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
                MEIDIANHEDD parsedMessage = null;
                try {
                    try {
                        parsedMessage = MEIDIANHEDD.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MEIDIANHEDD) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureStageInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageInfoList_ = new ArrayList(this.stageInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
            public List<OMNAAMAIBOHOuterClass.OMNAAMAIBOH> getStageInfoListList() {
                if (this.stageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageInfoList_);
                }
                return this.stageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
            public int getStageInfoListCount() {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.size();
                }
                return this.stageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
            public OMNAAMAIBOHOuterClass.OMNAAMAIBOH getStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessage(index);
            }

            public Builder setStageInfoList(int index, OMNAAMAIBOHOuterClass.OMNAAMAIBOH value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageInfoList(int index, OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(OMNAAMAIBOHOuterClass.OMNAAMAIBOH value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(int index, OMNAAMAIBOHOuterClass.OMNAAMAIBOH value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(int index, OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageInfoList(Iterable<? extends OMNAAMAIBOHOuterClass.OMNAAMAIBOH> values) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageInfoList_);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageInfoList() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.remove(index);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.remove(index);
                }
                return this;
            }

            public OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder getStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
            public OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder getStageInfoListOrBuilder(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MEIDIANHEDDOuterClass.MEIDIANHEDDOrBuilder
            public List<? extends OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder> getStageInfoListOrBuilderList() {
                if (this.stageInfoListBuilder_ != null) {
                    return this.stageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageInfoList_);
            }

            public OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder addStageInfoListBuilder() {
                return getStageInfoListFieldBuilder().addBuilder(OMNAAMAIBOHOuterClass.OMNAAMAIBOH.getDefaultInstance());
            }

            public OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder addStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().addBuilder(index, OMNAAMAIBOHOuterClass.OMNAAMAIBOH.getDefaultInstance());
            }

            public List<OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder> getStageInfoListBuilderList() {
                return getStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<OMNAAMAIBOHOuterClass.OMNAAMAIBOH, OMNAAMAIBOHOuterClass.OMNAAMAIBOH.Builder, OMNAAMAIBOHOuterClass.OMNAAMAIBOHOrBuilder> getStageInfoListFieldBuilder() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageInfoList_ = null;
                }
                return this.stageInfoListBuilder_;
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

        public static MEIDIANHEDD getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MEIDIANHEDD> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MEIDIANHEDD> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MEIDIANHEDD getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        OMNAAMAIBOHOuterClass.getDescriptor();
    }
}
