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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SamLampInfoOuterClass.class */
public final class SamLampInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011SamLampInfo.proto\"\u0001\n\u000bSamLampInfo\u0012\f\n\u0004days\u0018\u000b \u0001(\r\u0012\u0010\n\bprogress\u0018\u0003 \u0001(\r\u0012\u000e\n\u0006factor\u0018\n \u0001(\r\u0012\u0014\n\fcontribution\u0018\t \u0001(\r\u0012\u000f\n\u0007phaseId\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_ODBFFAIIPMB\u0018\u000e \u0003(\r\u0012\u001b\n\u0013Unk3300_FGHDJJCLNFN\u0018\u000f \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SamLampInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SamLampInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SamLampInfo_descriptor, new String[]{"Days", "Progress", "Factor", "Contribution", "PhaseId", "Unk3300ODBFFAIIPMB", "Unk3300FGHDJJCLNFN"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SamLampInfoOuterClass$SamLampInfoOrBuilder.class */
    public interface SamLampInfoOrBuilder extends MessageOrBuilder {
        int getDays();

        int getProgress();

        int getFactor();

        int getContribution();

        int getPhaseId();

        List<Integer> getUnk3300ODBFFAIIPMBList();

        int getUnk3300ODBFFAIIPMBCount();

        int getUnk3300ODBFFAIIPMB(int i);

        List<Integer> getUnk3300FGHDJJCLNFNList();

        int getUnk3300FGHDJJCLNFNCount();

        int getUnk3300FGHDJJCLNFN(int i);
    }

    private SamLampInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SamLampInfoOuterClass$SamLampInfo.class */
    public static final class SamLampInfo extends GeneratedMessageV3 implements SamLampInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAYS_FIELD_NUMBER = 11;
        private int days_;
        public static final int PROGRESS_FIELD_NUMBER = 3;
        private int progress_;
        public static final int FACTOR_FIELD_NUMBER = 10;
        private int factor_;
        public static final int CONTRIBUTION_FIELD_NUMBER = 9;
        private int contribution_;
        public static final int PHASEID_FIELD_NUMBER = 7;
        private int phaseId_;
        public static final int UNK3300_ODBFFAIIPMB_FIELD_NUMBER = 14;
        private Internal.IntList unk3300ODBFFAIIPMB_;
        private int unk3300ODBFFAIIPMBMemoizedSerializedSize;
        public static final int UNK3300_FGHDJJCLNFN_FIELD_NUMBER = 15;
        private Internal.IntList unk3300FGHDJJCLNFN_;
        private int unk3300FGHDJJCLNFNMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final SamLampInfo DEFAULT_INSTANCE = new SamLampInfo();
        private static final Parser<SamLampInfo> PARSER = new AbstractParser<SamLampInfo>() { // from class: emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfo.1
            @Override // com.google.protobuf.Parser
            public SamLampInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SamLampInfo(input, extensionRegistry);
            }
        };

        private SamLampInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300ODBFFAIIPMBMemoizedSerializedSize = -1;
            this.unk3300FGHDJJCLNFNMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SamLampInfo() {
            this.unk3300ODBFFAIIPMBMemoizedSerializedSize = -1;
            this.unk3300FGHDJJCLNFNMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300ODBFFAIIPMB_ = emptyIntList();
            this.unk3300FGHDJJCLNFN_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SamLampInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:88:0x019b */
        private SamLampInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.progress_ = input.readUInt32();
                                break;
                            case 56:
                                this.phaseId_ = input.readUInt32();
                                break;
                            case 72:
                                this.contribution_ = input.readUInt32();
                                break;
                            case 80:
                                this.factor_ = input.readUInt32();
                                break;
                            case 88:
                                this.days_ = input.readUInt32();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300ODBFFAIIPMB_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300ODBFFAIIPMB_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300ODBFFAIIPMB_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300ODBFFAIIPMB_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 120:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300FGHDJJCLNFN_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300FGHDJJCLNFN_.addInt(input.readUInt32());
                                break;
                            case 122:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300FGHDJJCLNFN_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300FGHDJJCLNFN_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
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
                    this.unk3300ODBFFAIIPMB_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300FGHDJJCLNFN_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SamLampInfoOuterClass.internal_static_SamLampInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SamLampInfoOuterClass.internal_static_SamLampInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SamLampInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getDays() {
            return this.days_;
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getProgress() {
            return this.progress_;
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getFactor() {
            return this.factor_;
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getContribution() {
            return this.contribution_;
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getPhaseId() {
            return this.phaseId_;
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public List<Integer> getUnk3300ODBFFAIIPMBList() {
            return this.unk3300ODBFFAIIPMB_;
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getUnk3300ODBFFAIIPMBCount() {
            return this.unk3300ODBFFAIIPMB_.size();
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getUnk3300ODBFFAIIPMB(int index) {
            return this.unk3300ODBFFAIIPMB_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public List<Integer> getUnk3300FGHDJJCLNFNList() {
            return this.unk3300FGHDJJCLNFN_;
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getUnk3300FGHDJJCLNFNCount() {
            return this.unk3300FGHDJJCLNFN_.size();
        }

        @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
        public int getUnk3300FGHDJJCLNFN(int index) {
            return this.unk3300FGHDJJCLNFN_.getInt(index);
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
            if (this.progress_ != 0) {
                output.writeUInt32(3, this.progress_);
            }
            if (this.phaseId_ != 0) {
                output.writeUInt32(7, this.phaseId_);
            }
            if (this.contribution_ != 0) {
                output.writeUInt32(9, this.contribution_);
            }
            if (this.factor_ != 0) {
                output.writeUInt32(10, this.factor_);
            }
            if (this.days_ != 0) {
                output.writeUInt32(11, this.days_);
            }
            if (getUnk3300ODBFFAIIPMBList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.unk3300ODBFFAIIPMBMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300ODBFFAIIPMB_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300ODBFFAIIPMB_.getInt(i));
            }
            if (getUnk3300FGHDJJCLNFNList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.unk3300FGHDJJCLNFNMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300FGHDJJCLNFN_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300FGHDJJCLNFN_.getInt(i2));
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
            if (this.progress_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.progress_);
            }
            if (this.phaseId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.phaseId_);
            }
            if (this.contribution_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.contribution_);
            }
            if (this.factor_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.factor_);
            }
            if (this.days_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(11, this.days_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300ODBFFAIIPMB_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300ODBFFAIIPMB_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getUnk3300ODBFFAIIPMBList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300ODBFFAIIPMBMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300FGHDJJCLNFN_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300FGHDJJCLNFN_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300FGHDJJCLNFNList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300FGHDJJCLNFNMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SamLampInfo)) {
                return equals(obj);
            }
            SamLampInfo other = (SamLampInfo) obj;
            return getDays() == other.getDays() && getProgress() == other.getProgress() && getFactor() == other.getFactor() && getContribution() == other.getContribution() && getPhaseId() == other.getPhaseId() && getUnk3300ODBFFAIIPMBList().equals(other.getUnk3300ODBFFAIIPMBList()) && getUnk3300FGHDJJCLNFNList().equals(other.getUnk3300FGHDJJCLNFNList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getDays())) + 3)) + getProgress())) + 10)) + getFactor())) + 9)) + getContribution())) + 7)) + getPhaseId();
            if (getUnk3300ODBFFAIIPMBCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getUnk3300ODBFFAIIPMBList().hashCode();
            }
            if (getUnk3300FGHDJJCLNFNCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getUnk3300FGHDJJCLNFNList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SamLampInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SamLampInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SamLampInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SamLampInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SamLampInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SamLampInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SamLampInfo parseFrom(InputStream input) throws IOException {
            return (SamLampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SamLampInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SamLampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SamLampInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SamLampInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SamLampInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SamLampInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SamLampInfo parseFrom(CodedInputStream input) throws IOException {
            return (SamLampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SamLampInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SamLampInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SamLampInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SamLampInfoOuterClass$SamLampInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SamLampInfoOrBuilder {
            private int bitField0_;
            private int days_;
            private int progress_;
            private int factor_;
            private int contribution_;
            private int phaseId_;
            private Internal.IntList unk3300ODBFFAIIPMB_ = SamLampInfo.emptyIntList();
            private Internal.IntList unk3300FGHDJJCLNFN_ = SamLampInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SamLampInfoOuterClass.internal_static_SamLampInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SamLampInfoOuterClass.internal_static_SamLampInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SamLampInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SamLampInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.days_ = 0;
                this.progress_ = 0;
                this.factor_ = 0;
                this.contribution_ = 0;
                this.phaseId_ = 0;
                this.unk3300ODBFFAIIPMB_ = SamLampInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300FGHDJJCLNFN_ = SamLampInfo.emptyIntList();
                this.bitField0_ &= -3;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SamLampInfoOuterClass.internal_static_SamLampInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SamLampInfo getDefaultInstanceForType() {
                return SamLampInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SamLampInfo build() {
                SamLampInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SamLampInfo buildPartial() {
                SamLampInfo result = new SamLampInfo(this);
                int i = this.bitField0_;
                result.days_ = this.days_;
                result.progress_ = this.progress_;
                result.factor_ = this.factor_;
                result.contribution_ = this.contribution_;
                result.phaseId_ = this.phaseId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300ODBFFAIIPMB_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300ODBFFAIIPMB_ = this.unk3300ODBFFAIIPMB_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300FGHDJJCLNFN_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300FGHDJJCLNFN_ = this.unk3300FGHDJJCLNFN_;
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
                if (other instanceof SamLampInfo) {
                    return mergeFrom((SamLampInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SamLampInfo other) {
                if (other == SamLampInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getDays() != 0) {
                    setDays(other.getDays());
                }
                if (other.getProgress() != 0) {
                    setProgress(other.getProgress());
                }
                if (other.getFactor() != 0) {
                    setFactor(other.getFactor());
                }
                if (other.getContribution() != 0) {
                    setContribution(other.getContribution());
                }
                if (other.getPhaseId() != 0) {
                    setPhaseId(other.getPhaseId());
                }
                if (!other.unk3300ODBFFAIIPMB_.isEmpty()) {
                    if (this.unk3300ODBFFAIIPMB_.isEmpty()) {
                        this.unk3300ODBFFAIIPMB_ = other.unk3300ODBFFAIIPMB_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300ODBFFAIIPMBIsMutable();
                        this.unk3300ODBFFAIIPMB_.addAll(other.unk3300ODBFFAIIPMB_);
                    }
                    onChanged();
                }
                if (!other.unk3300FGHDJJCLNFN_.isEmpty()) {
                    if (this.unk3300FGHDJJCLNFN_.isEmpty()) {
                        this.unk3300FGHDJJCLNFN_ = other.unk3300FGHDJJCLNFN_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300FGHDJJCLNFNIsMutable();
                        this.unk3300FGHDJJCLNFN_.addAll(other.unk3300FGHDJJCLNFN_);
                    }
                    onChanged();
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
                SamLampInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SamLampInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SamLampInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getDays() {
                return this.days_;
            }

            public Builder setDays(int value) {
                this.days_ = value;
                onChanged();
                return this;
            }

            public Builder clearDays() {
                this.days_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getFactor() {
                return this.factor_;
            }

            public Builder setFactor(int value) {
                this.factor_ = value;
                onChanged();
                return this;
            }

            public Builder clearFactor() {
                this.factor_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getContribution() {
                return this.contribution_;
            }

            public Builder setContribution(int value) {
                this.contribution_ = value;
                onChanged();
                return this;
            }

            public Builder clearContribution() {
                this.contribution_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getPhaseId() {
                return this.phaseId_;
            }

            public Builder setPhaseId(int value) {
                this.phaseId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPhaseId() {
                this.phaseId_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnk3300ODBFFAIIPMBIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300ODBFFAIIPMB_ = SamLampInfo.mutableCopy(this.unk3300ODBFFAIIPMB_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public List<Integer> getUnk3300ODBFFAIIPMBList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300ODBFFAIIPMB_) : this.unk3300ODBFFAIIPMB_;
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getUnk3300ODBFFAIIPMBCount() {
                return this.unk3300ODBFFAIIPMB_.size();
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getUnk3300ODBFFAIIPMB(int index) {
                return this.unk3300ODBFFAIIPMB_.getInt(index);
            }

            public Builder setUnk3300ODBFFAIIPMB(int index, int value) {
                ensureUnk3300ODBFFAIIPMBIsMutable();
                this.unk3300ODBFFAIIPMB_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300ODBFFAIIPMB(int value) {
                ensureUnk3300ODBFFAIIPMBIsMutable();
                this.unk3300ODBFFAIIPMB_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300ODBFFAIIPMB(Iterable<? extends Integer> values) {
                ensureUnk3300ODBFFAIIPMBIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300ODBFFAIIPMB_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300ODBFFAIIPMB() {
                this.unk3300ODBFFAIIPMB_ = SamLampInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUnk3300FGHDJJCLNFNIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300FGHDJJCLNFN_ = SamLampInfo.mutableCopy(this.unk3300FGHDJJCLNFN_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public List<Integer> getUnk3300FGHDJJCLNFNList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300FGHDJJCLNFN_) : this.unk3300FGHDJJCLNFN_;
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getUnk3300FGHDJJCLNFNCount() {
                return this.unk3300FGHDJJCLNFN_.size();
            }

            @Override // emu.grasscutter.net.proto.SamLampInfoOuterClass.SamLampInfoOrBuilder
            public int getUnk3300FGHDJJCLNFN(int index) {
                return this.unk3300FGHDJJCLNFN_.getInt(index);
            }

            public Builder setUnk3300FGHDJJCLNFN(int index, int value) {
                ensureUnk3300FGHDJJCLNFNIsMutable();
                this.unk3300FGHDJJCLNFN_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300FGHDJJCLNFN(int value) {
                ensureUnk3300FGHDJJCLNFNIsMutable();
                this.unk3300FGHDJJCLNFN_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300FGHDJJCLNFN(Iterable<? extends Integer> values) {
                ensureUnk3300FGHDJJCLNFNIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300FGHDJJCLNFN_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300FGHDJJCLNFN() {
                this.unk3300FGHDJJCLNFN_ = SamLampInfo.emptyIntList();
                this.bitField0_ &= -3;
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

        public static SamLampInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SamLampInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SamLampInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SamLampInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
