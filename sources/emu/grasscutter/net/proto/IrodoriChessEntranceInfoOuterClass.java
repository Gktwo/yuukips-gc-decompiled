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
import emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass.class */
public final class IrodoriChessEntranceInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eIrodoriChessEntranceInfo.proto\u001a\u001dIrodoriChessMonsterInfo.proto\"^\n\u0018IrodoriChessEntranceInfo\u0012\u0013\n\u000bdfpedbghhma\u0018\n \u0001(\r\u0012-\n\u000blhjhgbpjpkl\u0018\b \u0003(\u000b2\u0018.IrodoriChessMonsterInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriChessMonsterInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriChessEntranceInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessEntranceInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessEntranceInfo_descriptor, new String[]{"Dfpedbghhma", "Lhjhgbpjpkl"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass$IrodoriChessEntranceInfoOrBuilder.class */
    public interface IrodoriChessEntranceInfoOrBuilder extends MessageOrBuilder {
        int getDfpedbghhma();

        List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> getLhjhgbpjpklList();

        IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo getLhjhgbpjpkl(int i);

        int getLhjhgbpjpklCount();

        List<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getLhjhgbpjpklOrBuilderList();

        IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder getLhjhgbpjpklOrBuilder(int i);
    }

    private IrodoriChessEntranceInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass$IrodoriChessEntranceInfo.class */
    public static final class IrodoriChessEntranceInfo extends GeneratedMessageV3 implements IrodoriChessEntranceInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DFPEDBGHHMA_FIELD_NUMBER = 10;
        private int dfpedbghhma_;
        public static final int LHJHGBPJPKL_FIELD_NUMBER = 8;
        private List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> lhjhgbpjpkl_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessEntranceInfo DEFAULT_INSTANCE = new IrodoriChessEntranceInfo();
        private static final Parser<IrodoriChessEntranceInfo> PARSER = new AbstractParser<IrodoriChessEntranceInfo>() { // from class: emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessEntranceInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessEntranceInfo(input, extensionRegistry);
            }
        };

        private IrodoriChessEntranceInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessEntranceInfo() {
            this.memoizedIsInitialized = -1;
            this.lhjhgbpjpkl_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessEntranceInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessEntranceInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 66:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.lhjhgbpjpkl_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.lhjhgbpjpkl_.add((IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo) input.readMessage(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.parser(), extensionRegistry));
                                    break;
                                case 80:
                                    this.dfpedbghhma_ = input.readUInt32();
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
                    this.lhjhgbpjpkl_ = Collections.unmodifiableList(this.lhjhgbpjpkl_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEntranceInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public int getDfpedbghhma() {
            return this.dfpedbghhma_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> getLhjhgbpjpklList() {
            return this.lhjhgbpjpkl_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public List<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getLhjhgbpjpklOrBuilderList() {
            return this.lhjhgbpjpkl_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public int getLhjhgbpjpklCount() {
            return this.lhjhgbpjpkl_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo getLhjhgbpjpkl(int index) {
            return this.lhjhgbpjpkl_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
        public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder getLhjhgbpjpklOrBuilder(int index) {
            return this.lhjhgbpjpkl_.get(index);
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
            for (int i = 0; i < this.lhjhgbpjpkl_.size(); i++) {
                output.writeMessage(8, this.lhjhgbpjpkl_.get(i));
            }
            if (this.dfpedbghhma_ != 0) {
                output.writeUInt32(10, this.dfpedbghhma_);
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
            for (int i = 0; i < this.lhjhgbpjpkl_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.lhjhgbpjpkl_.get(i));
            }
            if (this.dfpedbghhma_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.dfpedbghhma_);
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
            if (!(obj instanceof IrodoriChessEntranceInfo)) {
                return equals(obj);
            }
            IrodoriChessEntranceInfo other = (IrodoriChessEntranceInfo) obj;
            return getDfpedbghhma() == other.getDfpedbghhma() && getLhjhgbpjpklList().equals(other.getLhjhgbpjpklList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + getDfpedbghhma();
            if (getLhjhgbpjpklCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getLhjhgbpjpklList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(InputStream input) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEntranceInfo parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessEntranceInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceInfoOuterClass$IrodoriChessEntranceInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessEntranceInfoOrBuilder {
            private int bitField0_;
            private int dfpedbghhma_;
            private List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> lhjhgbpjpkl_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> lhjhgbpjpklBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessEntranceInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessEntranceInfo.alwaysUseFieldBuilders) {
                    getLhjhgbpjpklFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.dfpedbghhma_ = 0;
                if (this.lhjhgbpjpklBuilder_ == null) {
                    this.lhjhgbpjpkl_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.lhjhgbpjpklBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessEntranceInfoOuterClass.internal_static_IrodoriChessEntranceInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessEntranceInfo getDefaultInstanceForType() {
                return IrodoriChessEntranceInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEntranceInfo build() {
                IrodoriChessEntranceInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEntranceInfo buildPartial() {
                IrodoriChessEntranceInfo result = new IrodoriChessEntranceInfo(this);
                int i = this.bitField0_;
                result.dfpedbghhma_ = this.dfpedbghhma_;
                if (this.lhjhgbpjpklBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.lhjhgbpjpkl_ = Collections.unmodifiableList(this.lhjhgbpjpkl_);
                        this.bitField0_ &= -2;
                    }
                    result.lhjhgbpjpkl_ = this.lhjhgbpjpkl_;
                } else {
                    result.lhjhgbpjpkl_ = this.lhjhgbpjpklBuilder_.build();
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
                if (other instanceof IrodoriChessEntranceInfo) {
                    return mergeFrom((IrodoriChessEntranceInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessEntranceInfo other) {
                if (other == IrodoriChessEntranceInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDfpedbghhma() != 0) {
                    setDfpedbghhma(other.getDfpedbghhma());
                }
                if (this.lhjhgbpjpklBuilder_ == null) {
                    if (!other.lhjhgbpjpkl_.isEmpty()) {
                        if (this.lhjhgbpjpkl_.isEmpty()) {
                            this.lhjhgbpjpkl_ = other.lhjhgbpjpkl_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureLhjhgbpjpklIsMutable();
                            this.lhjhgbpjpkl_.addAll(other.lhjhgbpjpkl_);
                        }
                        onChanged();
                    }
                } else if (!other.lhjhgbpjpkl_.isEmpty()) {
                    if (this.lhjhgbpjpklBuilder_.isEmpty()) {
                        this.lhjhgbpjpklBuilder_.dispose();
                        this.lhjhgbpjpklBuilder_ = null;
                        this.lhjhgbpjpkl_ = other.lhjhgbpjpkl_;
                        this.bitField0_ &= -2;
                        this.lhjhgbpjpklBuilder_ = IrodoriChessEntranceInfo.alwaysUseFieldBuilders ? getLhjhgbpjpklFieldBuilder() : null;
                    } else {
                        this.lhjhgbpjpklBuilder_.addAllMessages(other.lhjhgbpjpkl_);
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
                IrodoriChessEntranceInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessEntranceInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessEntranceInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public int getDfpedbghhma() {
                return this.dfpedbghhma_;
            }

            public Builder setDfpedbghhma(int value) {
                this.dfpedbghhma_ = value;
                onChanged();
                return this;
            }

            public Builder clearDfpedbghhma() {
                this.dfpedbghhma_ = 0;
                onChanged();
                return this;
            }

            private void ensureLhjhgbpjpklIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.lhjhgbpjpkl_ = new ArrayList(this.lhjhgbpjpkl_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> getLhjhgbpjpklList() {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    return Collections.unmodifiableList(this.lhjhgbpjpkl_);
                }
                return this.lhjhgbpjpklBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public int getLhjhgbpjpklCount() {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    return this.lhjhgbpjpkl_.size();
                }
                return this.lhjhgbpjpklBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo getLhjhgbpjpkl(int index) {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    return this.lhjhgbpjpkl_.get(index);
                }
                return this.lhjhgbpjpklBuilder_.getMessage(index);
            }

            public Builder setLhjhgbpjpkl(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo value) {
                if (this.lhjhgbpjpklBuilder_ != null) {
                    this.lhjhgbpjpklBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLhjhgbpjpklIsMutable();
                    this.lhjhgbpjpkl_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLhjhgbpjpkl(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder builderForValue) {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    ensureLhjhgbpjpklIsMutable();
                    this.lhjhgbpjpkl_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.lhjhgbpjpklBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLhjhgbpjpkl(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo value) {
                if (this.lhjhgbpjpklBuilder_ != null) {
                    this.lhjhgbpjpklBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLhjhgbpjpklIsMutable();
                    this.lhjhgbpjpkl_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLhjhgbpjpkl(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo value) {
                if (this.lhjhgbpjpklBuilder_ != null) {
                    this.lhjhgbpjpklBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLhjhgbpjpklIsMutable();
                    this.lhjhgbpjpkl_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLhjhgbpjpkl(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder builderForValue) {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    ensureLhjhgbpjpklIsMutable();
                    this.lhjhgbpjpkl_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.lhjhgbpjpklBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLhjhgbpjpkl(int index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder builderForValue) {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    ensureLhjhgbpjpklIsMutable();
                    this.lhjhgbpjpkl_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.lhjhgbpjpklBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLhjhgbpjpkl(Iterable<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo> values) {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    ensureLhjhgbpjpklIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lhjhgbpjpkl_);
                    onChanged();
                } else {
                    this.lhjhgbpjpklBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLhjhgbpjpkl() {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    this.lhjhgbpjpkl_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.lhjhgbpjpklBuilder_.clear();
                }
                return this;
            }

            public Builder removeLhjhgbpjpkl(int index) {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    ensureLhjhgbpjpklIsMutable();
                    this.lhjhgbpjpkl_.remove(index);
                    onChanged();
                } else {
                    this.lhjhgbpjpklBuilder_.remove(index);
                }
                return this;
            }

            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder getLhjhgbpjpklBuilder(int index) {
                return getLhjhgbpjpklFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder getLhjhgbpjpklOrBuilder(int index) {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    return this.lhjhgbpjpkl_.get(index);
                }
                return this.lhjhgbpjpklBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder
            public List<? extends IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getLhjhgbpjpklOrBuilderList() {
                if (this.lhjhgbpjpklBuilder_ != null) {
                    return this.lhjhgbpjpklBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.lhjhgbpjpkl_);
            }

            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder addLhjhgbpjpklBuilder() {
                return getLhjhgbpjpklFieldBuilder().addBuilder(IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.getDefaultInstance());
            }

            public IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder addLhjhgbpjpklBuilder(int index) {
                return getLhjhgbpjpklFieldBuilder().addBuilder(index, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.getDefaultInstance());
            }

            public List<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder> getLhjhgbpjpklBuilderList() {
                return getLhjhgbpjpklFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.Builder, IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder> getLhjhgbpjpklFieldBuilder() {
                if (this.lhjhgbpjpklBuilder_ == null) {
                    this.lhjhgbpjpklBuilder_ = new RepeatedFieldBuilderV3<>(this.lhjhgbpjpkl_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.lhjhgbpjpkl_ = null;
                }
                return this.lhjhgbpjpklBuilder_;
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

        public static IrodoriChessEntranceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessEntranceInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessEntranceInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessEntranceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriChessMonsterInfoOuterClass.getDescriptor();
    }
}
