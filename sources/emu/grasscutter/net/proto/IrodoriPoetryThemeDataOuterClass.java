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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryThemeDataOuterClass.class */
public final class IrodoriPoetryThemeDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cIrodoriPoetryThemeData.proto\"Ä\u0001\n\u0016IrodoriPoetryThemeData\u0012\u001b\n\u0013Unk3300_CNNMEHOGGLL\u0018\u0006 \u0003(\r\u0012\u001b\n\u0013Unk3300_HODJKKDBJDJ\u0018\u0004 \u0003(\r\u0012\u0010\n\bprogress\u0018\u000e \u0001(\r\u0012\u0013\n\u000bmaxProgress\u0018\r \u0001(\r\u0012\u001b\n\u0013Unk3300_NJHMNLIAGIK\u0018\u0007 \u0001(\r\u0012\u000f\n\u0007themeId\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_HFMKPNOBPDK\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_IrodoriPoetryThemeData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriPoetryThemeData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriPoetryThemeData_descriptor, new String[]{"Unk3300CNNMEHOGGLL", "Unk3300HODJKKDBJDJ", "Progress", "MaxProgress", "Unk3300NJHMNLIAGIK", "ThemeId", "Unk3300HFMKPNOBPDK"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryThemeDataOuterClass$IrodoriPoetryThemeDataOrBuilder.class */
    public interface IrodoriPoetryThemeDataOrBuilder extends MessageOrBuilder {
        List<Integer> getUnk3300CNNMEHOGGLLList();

        int getUnk3300CNNMEHOGGLLCount();

        int getUnk3300CNNMEHOGGLL(int i);

        List<Integer> getUnk3300HODJKKDBJDJList();

        int getUnk3300HODJKKDBJDJCount();

        int getUnk3300HODJKKDBJDJ(int i);

        int getProgress();

        int getMaxProgress();

        int getUnk3300NJHMNLIAGIK();

        int getThemeId();

        int getUnk3300HFMKPNOBPDK();
    }

    private IrodoriPoetryThemeDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryThemeDataOuterClass$IrodoriPoetryThemeData.class */
    public static final class IrodoriPoetryThemeData extends GeneratedMessageV3 implements IrodoriPoetryThemeDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_CNNMEHOGGLL_FIELD_NUMBER = 6;
        private Internal.IntList unk3300CNNMEHOGGLL_;
        private int unk3300CNNMEHOGGLLMemoizedSerializedSize;
        public static final int UNK3300_HODJKKDBJDJ_FIELD_NUMBER = 4;
        private Internal.IntList unk3300HODJKKDBJDJ_;
        private int unk3300HODJKKDBJDJMemoizedSerializedSize;
        public static final int PROGRESS_FIELD_NUMBER = 14;
        private int progress_;
        public static final int MAXPROGRESS_FIELD_NUMBER = 13;
        private int maxProgress_;
        public static final int UNK3300_NJHMNLIAGIK_FIELD_NUMBER = 7;
        private int unk3300NJHMNLIAGIK_;
        public static final int THEMEID_FIELD_NUMBER = 1;
        private int themeId_;
        public static final int UNK3300_HFMKPNOBPDK_FIELD_NUMBER = 15;
        private int unk3300HFMKPNOBPDK_;
        private byte memoizedIsInitialized;
        private static final IrodoriPoetryThemeData DEFAULT_INSTANCE = new IrodoriPoetryThemeData();
        private static final Parser<IrodoriPoetryThemeData> PARSER = new AbstractParser<IrodoriPoetryThemeData>() { // from class: emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.1
            @Override // com.google.protobuf.Parser
            public IrodoriPoetryThemeData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriPoetryThemeData(input, extensionRegistry);
            }
        };

        private IrodoriPoetryThemeData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300CNNMEHOGGLLMemoizedSerializedSize = -1;
            this.unk3300HODJKKDBJDJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private IrodoriPoetryThemeData() {
            this.unk3300CNNMEHOGGLLMemoizedSerializedSize = -1;
            this.unk3300HODJKKDBJDJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300CNNMEHOGGLL_ = emptyIntList();
            this.unk3300HODJKKDBJDJ_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriPoetryThemeData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x019b */
        private IrodoriPoetryThemeData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.themeId_ = input.readUInt32();
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300HODJKKDBJDJ_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300HODJKKDBJDJ_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300HODJKKDBJDJ_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300HODJKKDBJDJ_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300CNNMEHOGGLL_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300CNNMEHOGGLL_.addInt(input.readUInt32());
                                break;
                            case 50:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300CNNMEHOGGLL_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300CNNMEHOGGLL_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 56:
                                this.unk3300NJHMNLIAGIK_ = input.readUInt32();
                                break;
                            case 104:
                                this.maxProgress_ = input.readUInt32();
                                break;
                            case 112:
                                this.progress_ = input.readUInt32();
                                break;
                            case 120:
                                this.unk3300HFMKPNOBPDK_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300HODJKKDBJDJ_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300CNNMEHOGGLL_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriPoetryThemeDataOuterClass.internal_static_IrodoriPoetryThemeData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriPoetryThemeDataOuterClass.internal_static_IrodoriPoetryThemeData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriPoetryThemeData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public List<Integer> getUnk3300CNNMEHOGGLLList() {
            return this.unk3300CNNMEHOGGLL_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getUnk3300CNNMEHOGGLLCount() {
            return this.unk3300CNNMEHOGGLL_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getUnk3300CNNMEHOGGLL(int index) {
            return this.unk3300CNNMEHOGGLL_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public List<Integer> getUnk3300HODJKKDBJDJList() {
            return this.unk3300HODJKKDBJDJ_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getUnk3300HODJKKDBJDJCount() {
            return this.unk3300HODJKKDBJDJ_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getUnk3300HODJKKDBJDJ(int index) {
            return this.unk3300HODJKKDBJDJ_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getMaxProgress() {
            return this.maxProgress_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getUnk3300NJHMNLIAGIK() {
            return this.unk3300NJHMNLIAGIK_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getThemeId() {
            return this.themeId_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
        public int getUnk3300HFMKPNOBPDK() {
            return this.unk3300HFMKPNOBPDK_;
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
            getSerializedSize();
            if (this.themeId_ != 0) {
                output.writeUInt32(1, this.themeId_);
            }
            if (getUnk3300HODJKKDBJDJList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.unk3300HODJKKDBJDJMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300HODJKKDBJDJ_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300HODJKKDBJDJ_.getInt(i));
            }
            if (getUnk3300CNNMEHOGGLLList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.unk3300CNNMEHOGGLLMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300CNNMEHOGGLL_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300CNNMEHOGGLL_.getInt(i2));
            }
            if (this.unk3300NJHMNLIAGIK_ != 0) {
                output.writeUInt32(7, this.unk3300NJHMNLIAGIK_);
            }
            if (this.maxProgress_ != 0) {
                output.writeUInt32(13, this.maxProgress_);
            }
            if (this.progress_ != 0) {
                output.writeUInt32(14, this.progress_);
            }
            if (this.unk3300HFMKPNOBPDK_ != 0) {
                output.writeUInt32(15, this.unk3300HFMKPNOBPDK_);
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
            if (this.themeId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.themeId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300HODJKKDBJDJ_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300HODJKKDBJDJ_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUnk3300HODJKKDBJDJList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300HODJKKDBJDJMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300CNNMEHOGGLL_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300CNNMEHOGGLL_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300CNNMEHOGGLLList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300CNNMEHOGGLLMemoizedSerializedSize = dataSize2;
            if (this.unk3300NJHMNLIAGIK_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(7, this.unk3300NJHMNLIAGIK_);
            }
            if (this.maxProgress_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(13, this.maxProgress_);
            }
            if (this.progress_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(14, this.progress_);
            }
            if (this.unk3300HFMKPNOBPDK_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(15, this.unk3300HFMKPNOBPDK_);
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IrodoriPoetryThemeData)) {
                return equals(obj);
            }
            IrodoriPoetryThemeData other = (IrodoriPoetryThemeData) obj;
            return getUnk3300CNNMEHOGGLLList().equals(other.getUnk3300CNNMEHOGGLLList()) && getUnk3300HODJKKDBJDJList().equals(other.getUnk3300HODJKKDBJDJList()) && getProgress() == other.getProgress() && getMaxProgress() == other.getMaxProgress() && getUnk3300NJHMNLIAGIK() == other.getUnk3300NJHMNLIAGIK() && getThemeId() == other.getThemeId() && getUnk3300HFMKPNOBPDK() == other.getUnk3300HFMKPNOBPDK() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300CNNMEHOGGLLCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getUnk3300CNNMEHOGGLLList().hashCode();
            }
            if (getUnk3300HODJKKDBJDJCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getUnk3300HODJKKDBJDJList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + getProgress())) + 13)) + getMaxProgress())) + 7)) + getUnk3300NJHMNLIAGIK())) + 1)) + getThemeId())) + 15)) + getUnk3300HFMKPNOBPDK())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriPoetryThemeData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriPoetryThemeData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriPoetryThemeData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriPoetryThemeData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriPoetryThemeData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriPoetryThemeData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriPoetryThemeData parseFrom(InputStream input) throws IOException {
            return (IrodoriPoetryThemeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriPoetryThemeData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriPoetryThemeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriPoetryThemeData parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriPoetryThemeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriPoetryThemeData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriPoetryThemeData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriPoetryThemeData parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriPoetryThemeData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriPoetryThemeData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriPoetryThemeData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriPoetryThemeData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryThemeDataOuterClass$IrodoriPoetryThemeData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriPoetryThemeDataOrBuilder {
            private int bitField0_;
            private Internal.IntList unk3300CNNMEHOGGLL_ = IrodoriPoetryThemeData.emptyIntList();
            private Internal.IntList unk3300HODJKKDBJDJ_ = IrodoriPoetryThemeData.emptyIntList();
            private int progress_;
            private int maxProgress_;
            private int unk3300NJHMNLIAGIK_;
            private int themeId_;
            private int unk3300HFMKPNOBPDK_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriPoetryThemeDataOuterClass.internal_static_IrodoriPoetryThemeData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriPoetryThemeDataOuterClass.internal_static_IrodoriPoetryThemeData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriPoetryThemeData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriPoetryThemeData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300CNNMEHOGGLL_ = IrodoriPoetryThemeData.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300HODJKKDBJDJ_ = IrodoriPoetryThemeData.emptyIntList();
                this.bitField0_ &= -3;
                this.progress_ = 0;
                this.maxProgress_ = 0;
                this.unk3300NJHMNLIAGIK_ = 0;
                this.themeId_ = 0;
                this.unk3300HFMKPNOBPDK_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriPoetryThemeDataOuterClass.internal_static_IrodoriPoetryThemeData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriPoetryThemeData getDefaultInstanceForType() {
                return IrodoriPoetryThemeData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriPoetryThemeData build() {
                IrodoriPoetryThemeData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriPoetryThemeData buildPartial() {
                IrodoriPoetryThemeData result = new IrodoriPoetryThemeData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300CNNMEHOGGLL_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300CNNMEHOGGLL_ = this.unk3300CNNMEHOGGLL_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300HODJKKDBJDJ_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300HODJKKDBJDJ_ = this.unk3300HODJKKDBJDJ_;
                result.progress_ = this.progress_;
                result.maxProgress_ = this.maxProgress_;
                result.unk3300NJHMNLIAGIK_ = this.unk3300NJHMNLIAGIK_;
                result.themeId_ = this.themeId_;
                result.unk3300HFMKPNOBPDK_ = this.unk3300HFMKPNOBPDK_;
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
                if (other instanceof IrodoriPoetryThemeData) {
                    return mergeFrom((IrodoriPoetryThemeData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriPoetryThemeData other) {
                if (other == IrodoriPoetryThemeData.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300CNNMEHOGGLL_.isEmpty()) {
                    if (this.unk3300CNNMEHOGGLL_.isEmpty()) {
                        this.unk3300CNNMEHOGGLL_ = other.unk3300CNNMEHOGGLL_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300CNNMEHOGGLLIsMutable();
                        this.unk3300CNNMEHOGGLL_.addAll(other.unk3300CNNMEHOGGLL_);
                    }
                    onChanged();
                }
                if (!other.unk3300HODJKKDBJDJ_.isEmpty()) {
                    if (this.unk3300HODJKKDBJDJ_.isEmpty()) {
                        this.unk3300HODJKKDBJDJ_ = other.unk3300HODJKKDBJDJ_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300HODJKKDBJDJIsMutable();
                        this.unk3300HODJKKDBJDJ_.addAll(other.unk3300HODJKKDBJDJ_);
                    }
                    onChanged();
                }
                if (other.getProgress() != 0) {
                    setProgress(other.getProgress());
                }
                if (other.getMaxProgress() != 0) {
                    setMaxProgress(other.getMaxProgress());
                }
                if (other.getUnk3300NJHMNLIAGIK() != 0) {
                    setUnk3300NJHMNLIAGIK(other.getUnk3300NJHMNLIAGIK());
                }
                if (other.getThemeId() != 0) {
                    setThemeId(other.getThemeId());
                }
                if (other.getUnk3300HFMKPNOBPDK() != 0) {
                    setUnk3300HFMKPNOBPDK(other.getUnk3300HFMKPNOBPDK());
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
                IrodoriPoetryThemeData parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriPoetryThemeData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriPoetryThemeData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300CNNMEHOGGLLIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300CNNMEHOGGLL_ = IrodoriPoetryThemeData.mutableCopy(this.unk3300CNNMEHOGGLL_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public List<Integer> getUnk3300CNNMEHOGGLLList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300CNNMEHOGGLL_) : this.unk3300CNNMEHOGGLL_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getUnk3300CNNMEHOGGLLCount() {
                return this.unk3300CNNMEHOGGLL_.size();
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getUnk3300CNNMEHOGGLL(int index) {
                return this.unk3300CNNMEHOGGLL_.getInt(index);
            }

            public Builder setUnk3300CNNMEHOGGLL(int index, int value) {
                ensureUnk3300CNNMEHOGGLLIsMutable();
                this.unk3300CNNMEHOGGLL_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300CNNMEHOGGLL(int value) {
                ensureUnk3300CNNMEHOGGLLIsMutable();
                this.unk3300CNNMEHOGGLL_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300CNNMEHOGGLL(Iterable<? extends Integer> values) {
                ensureUnk3300CNNMEHOGGLLIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300CNNMEHOGGLL_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300CNNMEHOGGLL() {
                this.unk3300CNNMEHOGGLL_ = IrodoriPoetryThemeData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUnk3300HODJKKDBJDJIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300HODJKKDBJDJ_ = IrodoriPoetryThemeData.mutableCopy(this.unk3300HODJKKDBJDJ_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public List<Integer> getUnk3300HODJKKDBJDJList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300HODJKKDBJDJ_) : this.unk3300HODJKKDBJDJ_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getUnk3300HODJKKDBJDJCount() {
                return this.unk3300HODJKKDBJDJ_.size();
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getUnk3300HODJKKDBJDJ(int index) {
                return this.unk3300HODJKKDBJDJ_.getInt(index);
            }

            public Builder setUnk3300HODJKKDBJDJ(int index, int value) {
                ensureUnk3300HODJKKDBJDJIsMutable();
                this.unk3300HODJKKDBJDJ_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300HODJKKDBJDJ(int value) {
                ensureUnk3300HODJKKDBJDJIsMutable();
                this.unk3300HODJKKDBJDJ_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300HODJKKDBJDJ(Iterable<? extends Integer> values) {
                ensureUnk3300HODJKKDBJDJIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300HODJKKDBJDJ_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300HODJKKDBJDJ() {
                this.unk3300HODJKKDBJDJ_ = IrodoriPoetryThemeData.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getProgress() {
                return this.progress_;
            }

            public Builder setProgress(int value) {
                this.progress_ = value;
                onChanged();
                return this;
            }

            public Builder clearProgress() {
                this.progress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getMaxProgress() {
                return this.maxProgress_;
            }

            public Builder setMaxProgress(int value) {
                this.maxProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearMaxProgress() {
                this.maxProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getUnk3300NJHMNLIAGIK() {
                return this.unk3300NJHMNLIAGIK_;
            }

            public Builder setUnk3300NJHMNLIAGIK(int value) {
                this.unk3300NJHMNLIAGIK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NJHMNLIAGIK() {
                this.unk3300NJHMNLIAGIK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getThemeId() {
                return this.themeId_;
            }

            public Builder setThemeId(int value) {
                this.themeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearThemeId() {
                this.themeId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder
            public int getUnk3300HFMKPNOBPDK() {
                return this.unk3300HFMKPNOBPDK_;
            }

            public Builder setUnk3300HFMKPNOBPDK(int value) {
                this.unk3300HFMKPNOBPDK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300HFMKPNOBPDK() {
                this.unk3300HFMKPNOBPDK_ = 0;
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

        public static IrodoriPoetryThemeData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriPoetryThemeData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriPoetryThemeData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriPoetryThemeData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
