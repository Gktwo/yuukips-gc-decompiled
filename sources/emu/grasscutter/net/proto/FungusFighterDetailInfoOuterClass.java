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
import emu.grasscutter.net.proto.FungusDetailOuterClass;
import emu.grasscutter.net.proto.FungusPlotStageDetailOuterClass;
import emu.grasscutter.net.proto.FungusTrainingDungeonDetailOuterClass;
import emu.grasscutter.net.proto.FungusTrainingProgressDetailOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterDetailInfoOuterClass.class */
public final class FungusFighterDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dFungusFighterDetailInfo.proto\u001a\u0012FungusDetail.proto\u001a\u001bFungusPlotStageDetail.proto\u001a!FungusTrainingDungeonDetail.proto\u001a\"FungusTrainingProgressDetail.proto\"å\u0002\n\u0017FungusFighterDetailInfo\u0012)\n\u0012fungus_detail_list\u0018\u0006 \u0003(\u000b2\r.FungusDetail\u0012\u001b\n\u0013Unk3300_GIHAKKAJHDH\u0018\u0001 \u0003(\r\u0012\u001b\n\u0013Unk3300_KGKFJJHFHAB\u0018\b \u0003(\r\u0012L\n%training_dungeon_progress_detail_list\u0018\u0003 \u0003(\u000b2\u001d.FungusTrainingProgressDetail\u0012\u001b\n\u0013Unk3300_HPDOJOBPFMJ\u0018\t \u0003(\r\u00126\n\u0016plot_stage_detail_list\u0018\u000b \u0003(\u000b2\u0016.FungusPlotStageDetail\u0012B\n\u001ctraining_dungeon_detail_list\u0018\u0002 \u0003(\u000b2\u001c.FungusTrainingDungeonDetailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FungusDetailOuterClass.getDescriptor(), FungusPlotStageDetailOuterClass.getDescriptor(), FungusTrainingDungeonDetailOuterClass.getDescriptor(), FungusTrainingProgressDetailOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FungusFighterDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FungusFighterDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FungusFighterDetailInfo_descriptor, new String[]{"FungusDetailList", "Unk3300GIHAKKAJHDH", "Unk3300KGKFJJHFHAB", "TrainingDungeonProgressDetailList", "Unk3300HPDOJOBPFMJ", "PlotStageDetailList", "TrainingDungeonDetailList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterDetailInfoOuterClass$FungusFighterDetailInfoOrBuilder.class */
    public interface FungusFighterDetailInfoOrBuilder extends MessageOrBuilder {
        List<FungusDetailOuterClass.FungusDetail> getFungusDetailListList();

        FungusDetailOuterClass.FungusDetail getFungusDetailList(int i);

        int getFungusDetailListCount();

        List<? extends FungusDetailOuterClass.FungusDetailOrBuilder> getFungusDetailListOrBuilderList();

        FungusDetailOuterClass.FungusDetailOrBuilder getFungusDetailListOrBuilder(int i);

        List<Integer> getUnk3300GIHAKKAJHDHList();

        int getUnk3300GIHAKKAJHDHCount();

        int getUnk3300GIHAKKAJHDH(int i);

        List<Integer> getUnk3300KGKFJJHFHABList();

        int getUnk3300KGKFJJHFHABCount();

        int getUnk3300KGKFJJHFHAB(int i);

        List<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail> getTrainingDungeonProgressDetailListList();

        FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail getTrainingDungeonProgressDetailList(int i);

        int getTrainingDungeonProgressDetailListCount();

        List<? extends FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder> getTrainingDungeonProgressDetailListOrBuilderList();

        FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder getTrainingDungeonProgressDetailListOrBuilder(int i);

        List<Integer> getUnk3300HPDOJOBPFMJList();

        int getUnk3300HPDOJOBPFMJCount();

        int getUnk3300HPDOJOBPFMJ(int i);

        List<FungusPlotStageDetailOuterClass.FungusPlotStageDetail> getPlotStageDetailListList();

        FungusPlotStageDetailOuterClass.FungusPlotStageDetail getPlotStageDetailList(int i);

        int getPlotStageDetailListCount();

        List<? extends FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder> getPlotStageDetailListOrBuilderList();

        FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder getPlotStageDetailListOrBuilder(int i);

        List<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail> getTrainingDungeonDetailListList();

        FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail getTrainingDungeonDetailList(int i);

        int getTrainingDungeonDetailListCount();

        List<? extends FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder> getTrainingDungeonDetailListOrBuilderList();

        FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder getTrainingDungeonDetailListOrBuilder(int i);
    }

    private FungusFighterDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterDetailInfoOuterClass$FungusFighterDetailInfo.class */
    public static final class FungusFighterDetailInfo extends GeneratedMessageV3 implements FungusFighterDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FUNGUS_DETAIL_LIST_FIELD_NUMBER = 6;
        private List<FungusDetailOuterClass.FungusDetail> fungusDetailList_;
        public static final int UNK3300_GIHAKKAJHDH_FIELD_NUMBER = 1;
        private Internal.IntList unk3300GIHAKKAJHDH_;
        private int unk3300GIHAKKAJHDHMemoizedSerializedSize;
        public static final int UNK3300_KGKFJJHFHAB_FIELD_NUMBER = 8;
        private Internal.IntList unk3300KGKFJJHFHAB_;
        private int unk3300KGKFJJHFHABMemoizedSerializedSize;
        public static final int TRAINING_DUNGEON_PROGRESS_DETAIL_LIST_FIELD_NUMBER = 3;
        private List<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail> trainingDungeonProgressDetailList_;
        public static final int UNK3300_HPDOJOBPFMJ_FIELD_NUMBER = 9;
        private Internal.IntList unk3300HPDOJOBPFMJ_;
        private int unk3300HPDOJOBPFMJMemoizedSerializedSize;
        public static final int PLOT_STAGE_DETAIL_LIST_FIELD_NUMBER = 11;
        private List<FungusPlotStageDetailOuterClass.FungusPlotStageDetail> plotStageDetailList_;
        public static final int TRAINING_DUNGEON_DETAIL_LIST_FIELD_NUMBER = 2;
        private List<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail> trainingDungeonDetailList_;
        private byte memoizedIsInitialized;
        private static final FungusFighterDetailInfo DEFAULT_INSTANCE = new FungusFighterDetailInfo();
        private static final Parser<FungusFighterDetailInfo> PARSER = new AbstractParser<FungusFighterDetailInfo>() { // from class: emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.1
            @Override // com.google.protobuf.Parser
            public FungusFighterDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FungusFighterDetailInfo(input, extensionRegistry);
            }
        };

        private FungusFighterDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300GIHAKKAJHDHMemoizedSerializedSize = -1;
            this.unk3300KGKFJJHFHABMemoizedSerializedSize = -1;
            this.unk3300HPDOJOBPFMJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private FungusFighterDetailInfo() {
            this.unk3300GIHAKKAJHDHMemoizedSerializedSize = -1;
            this.unk3300KGKFJJHFHABMemoizedSerializedSize = -1;
            this.unk3300HPDOJOBPFMJMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.fungusDetailList_ = Collections.emptyList();
            this.unk3300GIHAKKAJHDH_ = emptyIntList();
            this.unk3300KGKFJJHFHAB_ = emptyIntList();
            this.trainingDungeonProgressDetailList_ = Collections.emptyList();
            this.unk3300HPDOJOBPFMJ_ = emptyIntList();
            this.plotStageDetailList_ = Collections.emptyList();
            this.trainingDungeonDetailList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FungusFighterDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:143:0x0291 */
        private FungusFighterDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.unk3300GIHAKKAJHDH_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.unk3300GIHAKKAJHDH_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300GIHAKKAJHDH_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300GIHAKKAJHDH_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 64) == 0) {
                                        this.trainingDungeonDetailList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                    }
                                    this.trainingDungeonDetailList_.add((FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail) input.readMessage(FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.parser(), extensionRegistry));
                                    break;
                                case 26:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.trainingDungeonProgressDetailList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    this.trainingDungeonProgressDetailList_.add((FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail) input.readMessage(FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.parser(), extensionRegistry));
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.fungusDetailList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.fungusDetailList_.add((FungusDetailOuterClass.FungusDetail) input.readMessage(FungusDetailOuterClass.FungusDetail.parser(), extensionRegistry));
                                    break;
                                case 64:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.unk3300KGKFJJHFHAB_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.unk3300KGKFJJHFHAB_.addInt(input.readUInt32());
                                    break;
                                case 66:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300KGKFJJHFHAB_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300KGKFJJHFHAB_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 72:
                                    if ((mutable_bitField0_ & 16) == 0) {
                                        this.unk3300HPDOJOBPFMJ_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    this.unk3300HPDOJOBPFMJ_.addInt(input.readUInt32());
                                    break;
                                case 74:
                                    int limit3 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300HPDOJOBPFMJ_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300HPDOJOBPFMJ_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit3);
                                    break;
                                case 90:
                                    if ((mutable_bitField0_ & 32) == 0) {
                                        this.plotStageDetailList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                    }
                                    this.plotStageDetailList_.add((FungusPlotStageDetailOuterClass.FungusPlotStageDetail) input.readMessage(FungusPlotStageDetailOuterClass.FungusPlotStageDetail.parser(), extensionRegistry));
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300GIHAKKAJHDH_.makeImmutable();
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.trainingDungeonDetailList_ = Collections.unmodifiableList(this.trainingDungeonDetailList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.trainingDungeonProgressDetailList_ = Collections.unmodifiableList(this.trainingDungeonProgressDetailList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.fungusDetailList_ = Collections.unmodifiableList(this.fungusDetailList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unk3300KGKFJJHFHAB_.makeImmutable();
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.unk3300HPDOJOBPFMJ_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.plotStageDetailList_ = Collections.unmodifiableList(this.plotStageDetailList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FungusFighterDetailInfoOuterClass.internal_static_FungusFighterDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FungusFighterDetailInfoOuterClass.internal_static_FungusFighterDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusFighterDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<FungusDetailOuterClass.FungusDetail> getFungusDetailListList() {
            return this.fungusDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<? extends FungusDetailOuterClass.FungusDetailOrBuilder> getFungusDetailListOrBuilderList() {
            return this.fungusDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getFungusDetailListCount() {
            return this.fungusDetailList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusDetailOuterClass.FungusDetail getFungusDetailList(int index) {
            return this.fungusDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusDetailOuterClass.FungusDetailOrBuilder getFungusDetailListOrBuilder(int index) {
            return this.fungusDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<Integer> getUnk3300GIHAKKAJHDHList() {
            return this.unk3300GIHAKKAJHDH_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getUnk3300GIHAKKAJHDHCount() {
            return this.unk3300GIHAKKAJHDH_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getUnk3300GIHAKKAJHDH(int index) {
            return this.unk3300GIHAKKAJHDH_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<Integer> getUnk3300KGKFJJHFHABList() {
            return this.unk3300KGKFJJHFHAB_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getUnk3300KGKFJJHFHABCount() {
            return this.unk3300KGKFJJHFHAB_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getUnk3300KGKFJJHFHAB(int index) {
            return this.unk3300KGKFJJHFHAB_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail> getTrainingDungeonProgressDetailListList() {
            return this.trainingDungeonProgressDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<? extends FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder> getTrainingDungeonProgressDetailListOrBuilderList() {
            return this.trainingDungeonProgressDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getTrainingDungeonProgressDetailListCount() {
            return this.trainingDungeonProgressDetailList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail getTrainingDungeonProgressDetailList(int index) {
            return this.trainingDungeonProgressDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder getTrainingDungeonProgressDetailListOrBuilder(int index) {
            return this.trainingDungeonProgressDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<Integer> getUnk3300HPDOJOBPFMJList() {
            return this.unk3300HPDOJOBPFMJ_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getUnk3300HPDOJOBPFMJCount() {
            return this.unk3300HPDOJOBPFMJ_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getUnk3300HPDOJOBPFMJ(int index) {
            return this.unk3300HPDOJOBPFMJ_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<FungusPlotStageDetailOuterClass.FungusPlotStageDetail> getPlotStageDetailListList() {
            return this.plotStageDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<? extends FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder> getPlotStageDetailListOrBuilderList() {
            return this.plotStageDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getPlotStageDetailListCount() {
            return this.plotStageDetailList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusPlotStageDetailOuterClass.FungusPlotStageDetail getPlotStageDetailList(int index) {
            return this.plotStageDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder getPlotStageDetailListOrBuilder(int index) {
            return this.plotStageDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail> getTrainingDungeonDetailListList() {
            return this.trainingDungeonDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public List<? extends FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder> getTrainingDungeonDetailListOrBuilderList() {
            return this.trainingDungeonDetailList_;
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public int getTrainingDungeonDetailListCount() {
            return this.trainingDungeonDetailList_.size();
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail getTrainingDungeonDetailList(int index) {
            return this.trainingDungeonDetailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
        public FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder getTrainingDungeonDetailListOrBuilder(int index) {
            return this.trainingDungeonDetailList_.get(index);
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
            if (getUnk3300GIHAKKAJHDHList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.unk3300GIHAKKAJHDHMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300GIHAKKAJHDH_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300GIHAKKAJHDH_.getInt(i));
            }
            for (int i2 = 0; i2 < this.trainingDungeonDetailList_.size(); i2++) {
                output.writeMessage(2, this.trainingDungeonDetailList_.get(i2));
            }
            for (int i3 = 0; i3 < this.trainingDungeonProgressDetailList_.size(); i3++) {
                output.writeMessage(3, this.trainingDungeonProgressDetailList_.get(i3));
            }
            for (int i4 = 0; i4 < this.fungusDetailList_.size(); i4++) {
                output.writeMessage(6, this.fungusDetailList_.get(i4));
            }
            if (getUnk3300KGKFJJHFHABList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.unk3300KGKFJJHFHABMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.unk3300KGKFJJHFHAB_.size(); i5++) {
                output.writeUInt32NoTag(this.unk3300KGKFJJHFHAB_.getInt(i5));
            }
            if (getUnk3300HPDOJOBPFMJList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.unk3300HPDOJOBPFMJMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.unk3300HPDOJOBPFMJ_.size(); i6++) {
                output.writeUInt32NoTag(this.unk3300HPDOJOBPFMJ_.getInt(i6));
            }
            for (int i7 = 0; i7 < this.plotStageDetailList_.size(); i7++) {
                output.writeMessage(11, this.plotStageDetailList_.get(i7));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.unk3300GIHAKKAJHDH_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300GIHAKKAJHDH_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300GIHAKKAJHDHList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300GIHAKKAJHDHMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.trainingDungeonDetailList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.trainingDungeonDetailList_.get(i2));
            }
            for (int i3 = 0; i3 < this.trainingDungeonProgressDetailList_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.trainingDungeonProgressDetailList_.get(i3));
            }
            for (int i4 = 0; i4 < this.fungusDetailList_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.fungusDetailList_.get(i4));
            }
            int dataSize2 = 0;
            for (int i5 = 0; i5 < this.unk3300KGKFJJHFHAB_.size(); i5++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300KGKFJJHFHAB_.getInt(i5));
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300KGKFJJHFHABList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300KGKFJJHFHABMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i6 = 0; i6 < this.unk3300HPDOJOBPFMJ_.size(); i6++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300HPDOJOBPFMJ_.getInt(i6));
            }
            int size4 = size3 + dataSize3;
            if (!getUnk3300HPDOJOBPFMJList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.unk3300HPDOJOBPFMJMemoizedSerializedSize = dataSize3;
            for (int i7 = 0; i7 < this.plotStageDetailList_.size(); i7++) {
                size4 += CodedOutputStream.computeMessageSize(11, this.plotStageDetailList_.get(i7));
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
            if (!(obj instanceof FungusFighterDetailInfo)) {
                return equals(obj);
            }
            FungusFighterDetailInfo other = (FungusFighterDetailInfo) obj;
            return getFungusDetailListList().equals(other.getFungusDetailListList()) && getUnk3300GIHAKKAJHDHList().equals(other.getUnk3300GIHAKKAJHDHList()) && getUnk3300KGKFJJHFHABList().equals(other.getUnk3300KGKFJJHFHABList()) && getTrainingDungeonProgressDetailListList().equals(other.getTrainingDungeonProgressDetailListList()) && getUnk3300HPDOJOBPFMJList().equals(other.getUnk3300HPDOJOBPFMJList()) && getPlotStageDetailListList().equals(other.getPlotStageDetailListList()) && getTrainingDungeonDetailListList().equals(other.getTrainingDungeonDetailListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFungusDetailListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getFungusDetailListList().hashCode();
            }
            if (getUnk3300GIHAKKAJHDHCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getUnk3300GIHAKKAJHDHList().hashCode();
            }
            if (getUnk3300KGKFJJHFHABCount() > 0) {
                hash = (53 * ((37 * hash) + 8)) + getUnk3300KGKFJJHFHABList().hashCode();
            }
            if (getTrainingDungeonProgressDetailListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getTrainingDungeonProgressDetailListList().hashCode();
            }
            if (getUnk3300HPDOJOBPFMJCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getUnk3300HPDOJOBPFMJList().hashCode();
            }
            if (getPlotStageDetailListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getPlotStageDetailListList().hashCode();
            }
            if (getTrainingDungeonDetailListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getTrainingDungeonDetailListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FungusFighterDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusFighterDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusFighterDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusFighterDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusFighterDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusFighterDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusFighterDetailInfo parseFrom(InputStream input) throws IOException {
            return (FungusFighterDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusFighterDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusFighterDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusFighterDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (FungusFighterDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FungusFighterDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusFighterDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusFighterDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (FungusFighterDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusFighterDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusFighterDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FungusFighterDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusFighterDetailInfoOuterClass$FungusFighterDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FungusFighterDetailInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<FungusDetailOuterClass.FungusDetail, FungusDetailOuterClass.FungusDetail.Builder, FungusDetailOuterClass.FungusDetailOrBuilder> fungusDetailListBuilder_;
            private RepeatedFieldBuilderV3<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder> trainingDungeonProgressDetailListBuilder_;
            private RepeatedFieldBuilderV3<FungusPlotStageDetailOuterClass.FungusPlotStageDetail, FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder, FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder> plotStageDetailListBuilder_;
            private RepeatedFieldBuilderV3<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder> trainingDungeonDetailListBuilder_;
            private List<FungusDetailOuterClass.FungusDetail> fungusDetailList_ = Collections.emptyList();
            private Internal.IntList unk3300GIHAKKAJHDH_ = FungusFighterDetailInfo.emptyIntList();
            private Internal.IntList unk3300KGKFJJHFHAB_ = FungusFighterDetailInfo.emptyIntList();
            private List<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail> trainingDungeonProgressDetailList_ = Collections.emptyList();
            private Internal.IntList unk3300HPDOJOBPFMJ_ = FungusFighterDetailInfo.emptyIntList();
            private List<FungusPlotStageDetailOuterClass.FungusPlotStageDetail> plotStageDetailList_ = Collections.emptyList();
            private List<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail> trainingDungeonDetailList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return FungusFighterDetailInfoOuterClass.internal_static_FungusFighterDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FungusFighterDetailInfoOuterClass.internal_static_FungusFighterDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusFighterDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FungusFighterDetailInfo.alwaysUseFieldBuilders) {
                    getFungusDetailListFieldBuilder();
                    getTrainingDungeonProgressDetailListFieldBuilder();
                    getPlotStageDetailListFieldBuilder();
                    getTrainingDungeonDetailListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.fungusDetailListBuilder_ == null) {
                    this.fungusDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.fungusDetailListBuilder_.clear();
                }
                this.unk3300GIHAKKAJHDH_ = FungusFighterDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unk3300KGKFJJHFHAB_ = FungusFighterDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    this.trainingDungeonProgressDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.trainingDungeonProgressDetailListBuilder_.clear();
                }
                this.unk3300HPDOJOBPFMJ_ = FungusFighterDetailInfo.emptyIntList();
                this.bitField0_ &= -17;
                if (this.plotStageDetailListBuilder_ == null) {
                    this.plotStageDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.plotStageDetailListBuilder_.clear();
                }
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    this.trainingDungeonDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.trainingDungeonDetailListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FungusFighterDetailInfoOuterClass.internal_static_FungusFighterDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FungusFighterDetailInfo getDefaultInstanceForType() {
                return FungusFighterDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusFighterDetailInfo build() {
                FungusFighterDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusFighterDetailInfo buildPartial() {
                FungusFighterDetailInfo result = new FungusFighterDetailInfo(this);
                int i = this.bitField0_;
                if (this.fungusDetailListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.fungusDetailList_ = Collections.unmodifiableList(this.fungusDetailList_);
                        this.bitField0_ &= -2;
                    }
                    result.fungusDetailList_ = this.fungusDetailList_;
                } else {
                    result.fungusDetailList_ = this.fungusDetailListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300GIHAKKAJHDH_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300GIHAKKAJHDH_ = this.unk3300GIHAKKAJHDH_;
                if ((this.bitField0_ & 4) != 0) {
                    this.unk3300KGKFJJHFHAB_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.unk3300KGKFJJHFHAB_ = this.unk3300KGKFJJHFHAB_;
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.trainingDungeonProgressDetailList_ = Collections.unmodifiableList(this.trainingDungeonProgressDetailList_);
                        this.bitField0_ &= -9;
                    }
                    result.trainingDungeonProgressDetailList_ = this.trainingDungeonProgressDetailList_;
                } else {
                    result.trainingDungeonProgressDetailList_ = this.trainingDungeonProgressDetailListBuilder_.build();
                }
                if ((this.bitField0_ & 16) != 0) {
                    this.unk3300HPDOJOBPFMJ_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                result.unk3300HPDOJOBPFMJ_ = this.unk3300HPDOJOBPFMJ_;
                if (this.plotStageDetailListBuilder_ == null) {
                    if ((this.bitField0_ & 32) != 0) {
                        this.plotStageDetailList_ = Collections.unmodifiableList(this.plotStageDetailList_);
                        this.bitField0_ &= -33;
                    }
                    result.plotStageDetailList_ = this.plotStageDetailList_;
                } else {
                    result.plotStageDetailList_ = this.plotStageDetailListBuilder_.build();
                }
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    if ((this.bitField0_ & 64) != 0) {
                        this.trainingDungeonDetailList_ = Collections.unmodifiableList(this.trainingDungeonDetailList_);
                        this.bitField0_ &= -65;
                    }
                    result.trainingDungeonDetailList_ = this.trainingDungeonDetailList_;
                } else {
                    result.trainingDungeonDetailList_ = this.trainingDungeonDetailListBuilder_.build();
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
                if (other instanceof FungusFighterDetailInfo) {
                    return mergeFrom((FungusFighterDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FungusFighterDetailInfo other) {
                if (other == FungusFighterDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.fungusDetailListBuilder_ == null) {
                    if (!other.fungusDetailList_.isEmpty()) {
                        if (this.fungusDetailList_.isEmpty()) {
                            this.fungusDetailList_ = other.fungusDetailList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFungusDetailListIsMutable();
                            this.fungusDetailList_.addAll(other.fungusDetailList_);
                        }
                        onChanged();
                    }
                } else if (!other.fungusDetailList_.isEmpty()) {
                    if (this.fungusDetailListBuilder_.isEmpty()) {
                        this.fungusDetailListBuilder_.dispose();
                        this.fungusDetailListBuilder_ = null;
                        this.fungusDetailList_ = other.fungusDetailList_;
                        this.bitField0_ &= -2;
                        this.fungusDetailListBuilder_ = FungusFighterDetailInfo.alwaysUseFieldBuilders ? getFungusDetailListFieldBuilder() : null;
                    } else {
                        this.fungusDetailListBuilder_.addAllMessages(other.fungusDetailList_);
                    }
                }
                if (!other.unk3300GIHAKKAJHDH_.isEmpty()) {
                    if (this.unk3300GIHAKKAJHDH_.isEmpty()) {
                        this.unk3300GIHAKKAJHDH_ = other.unk3300GIHAKKAJHDH_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300GIHAKKAJHDHIsMutable();
                        this.unk3300GIHAKKAJHDH_.addAll(other.unk3300GIHAKKAJHDH_);
                    }
                    onChanged();
                }
                if (!other.unk3300KGKFJJHFHAB_.isEmpty()) {
                    if (this.unk3300KGKFJJHFHAB_.isEmpty()) {
                        this.unk3300KGKFJJHFHAB_ = other.unk3300KGKFJJHFHAB_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureUnk3300KGKFJJHFHABIsMutable();
                        this.unk3300KGKFJJHFHAB_.addAll(other.unk3300KGKFJJHFHAB_);
                    }
                    onChanged();
                }
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    if (!other.trainingDungeonProgressDetailList_.isEmpty()) {
                        if (this.trainingDungeonProgressDetailList_.isEmpty()) {
                            this.trainingDungeonProgressDetailList_ = other.trainingDungeonProgressDetailList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureTrainingDungeonProgressDetailListIsMutable();
                            this.trainingDungeonProgressDetailList_.addAll(other.trainingDungeonProgressDetailList_);
                        }
                        onChanged();
                    }
                } else if (!other.trainingDungeonProgressDetailList_.isEmpty()) {
                    if (this.trainingDungeonProgressDetailListBuilder_.isEmpty()) {
                        this.trainingDungeonProgressDetailListBuilder_.dispose();
                        this.trainingDungeonProgressDetailListBuilder_ = null;
                        this.trainingDungeonProgressDetailList_ = other.trainingDungeonProgressDetailList_;
                        this.bitField0_ &= -9;
                        this.trainingDungeonProgressDetailListBuilder_ = FungusFighterDetailInfo.alwaysUseFieldBuilders ? getTrainingDungeonProgressDetailListFieldBuilder() : null;
                    } else {
                        this.trainingDungeonProgressDetailListBuilder_.addAllMessages(other.trainingDungeonProgressDetailList_);
                    }
                }
                if (!other.unk3300HPDOJOBPFMJ_.isEmpty()) {
                    if (this.unk3300HPDOJOBPFMJ_.isEmpty()) {
                        this.unk3300HPDOJOBPFMJ_ = other.unk3300HPDOJOBPFMJ_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUnk3300HPDOJOBPFMJIsMutable();
                        this.unk3300HPDOJOBPFMJ_.addAll(other.unk3300HPDOJOBPFMJ_);
                    }
                    onChanged();
                }
                if (this.plotStageDetailListBuilder_ == null) {
                    if (!other.plotStageDetailList_.isEmpty()) {
                        if (this.plotStageDetailList_.isEmpty()) {
                            this.plotStageDetailList_ = other.plotStageDetailList_;
                            this.bitField0_ &= -33;
                        } else {
                            ensurePlotStageDetailListIsMutable();
                            this.plotStageDetailList_.addAll(other.plotStageDetailList_);
                        }
                        onChanged();
                    }
                } else if (!other.plotStageDetailList_.isEmpty()) {
                    if (this.plotStageDetailListBuilder_.isEmpty()) {
                        this.plotStageDetailListBuilder_.dispose();
                        this.plotStageDetailListBuilder_ = null;
                        this.plotStageDetailList_ = other.plotStageDetailList_;
                        this.bitField0_ &= -33;
                        this.plotStageDetailListBuilder_ = FungusFighterDetailInfo.alwaysUseFieldBuilders ? getPlotStageDetailListFieldBuilder() : null;
                    } else {
                        this.plotStageDetailListBuilder_.addAllMessages(other.plotStageDetailList_);
                    }
                }
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    if (!other.trainingDungeonDetailList_.isEmpty()) {
                        if (this.trainingDungeonDetailList_.isEmpty()) {
                            this.trainingDungeonDetailList_ = other.trainingDungeonDetailList_;
                            this.bitField0_ &= -65;
                        } else {
                            ensureTrainingDungeonDetailListIsMutable();
                            this.trainingDungeonDetailList_.addAll(other.trainingDungeonDetailList_);
                        }
                        onChanged();
                    }
                } else if (!other.trainingDungeonDetailList_.isEmpty()) {
                    if (this.trainingDungeonDetailListBuilder_.isEmpty()) {
                        this.trainingDungeonDetailListBuilder_.dispose();
                        this.trainingDungeonDetailListBuilder_ = null;
                        this.trainingDungeonDetailList_ = other.trainingDungeonDetailList_;
                        this.bitField0_ &= -65;
                        this.trainingDungeonDetailListBuilder_ = FungusFighterDetailInfo.alwaysUseFieldBuilders ? getTrainingDungeonDetailListFieldBuilder() : null;
                    } else {
                        this.trainingDungeonDetailListBuilder_.addAllMessages(other.trainingDungeonDetailList_);
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
                FungusFighterDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = FungusFighterDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FungusFighterDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFungusDetailListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fungusDetailList_ = new ArrayList(this.fungusDetailList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<FungusDetailOuterClass.FungusDetail> getFungusDetailListList() {
                if (this.fungusDetailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.fungusDetailList_);
                }
                return this.fungusDetailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getFungusDetailListCount() {
                if (this.fungusDetailListBuilder_ == null) {
                    return this.fungusDetailList_.size();
                }
                return this.fungusDetailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusDetailOuterClass.FungusDetail getFungusDetailList(int index) {
                if (this.fungusDetailListBuilder_ == null) {
                    return this.fungusDetailList_.get(index);
                }
                return this.fungusDetailListBuilder_.getMessage(index);
            }

            public Builder setFungusDetailList(int index, FungusDetailOuterClass.FungusDetail value) {
                if (this.fungusDetailListBuilder_ != null) {
                    this.fungusDetailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFungusDetailListIsMutable();
                    this.fungusDetailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFungusDetailList(int index, FungusDetailOuterClass.FungusDetail.Builder builderForValue) {
                if (this.fungusDetailListBuilder_ == null) {
                    ensureFungusDetailListIsMutable();
                    this.fungusDetailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fungusDetailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFungusDetailList(FungusDetailOuterClass.FungusDetail value) {
                if (this.fungusDetailListBuilder_ != null) {
                    this.fungusDetailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFungusDetailListIsMutable();
                    this.fungusDetailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFungusDetailList(int index, FungusDetailOuterClass.FungusDetail value) {
                if (this.fungusDetailListBuilder_ != null) {
                    this.fungusDetailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFungusDetailListIsMutable();
                    this.fungusDetailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFungusDetailList(FungusDetailOuterClass.FungusDetail.Builder builderForValue) {
                if (this.fungusDetailListBuilder_ == null) {
                    ensureFungusDetailListIsMutable();
                    this.fungusDetailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fungusDetailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFungusDetailList(int index, FungusDetailOuterClass.FungusDetail.Builder builderForValue) {
                if (this.fungusDetailListBuilder_ == null) {
                    ensureFungusDetailListIsMutable();
                    this.fungusDetailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fungusDetailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFungusDetailList(Iterable<? extends FungusDetailOuterClass.FungusDetail> values) {
                if (this.fungusDetailListBuilder_ == null) {
                    ensureFungusDetailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fungusDetailList_);
                    onChanged();
                } else {
                    this.fungusDetailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFungusDetailList() {
                if (this.fungusDetailListBuilder_ == null) {
                    this.fungusDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.fungusDetailListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFungusDetailList(int index) {
                if (this.fungusDetailListBuilder_ == null) {
                    ensureFungusDetailListIsMutable();
                    this.fungusDetailList_.remove(index);
                    onChanged();
                } else {
                    this.fungusDetailListBuilder_.remove(index);
                }
                return this;
            }

            public FungusDetailOuterClass.FungusDetail.Builder getFungusDetailListBuilder(int index) {
                return getFungusDetailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusDetailOuterClass.FungusDetailOrBuilder getFungusDetailListOrBuilder(int index) {
                if (this.fungusDetailListBuilder_ == null) {
                    return this.fungusDetailList_.get(index);
                }
                return this.fungusDetailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<? extends FungusDetailOuterClass.FungusDetailOrBuilder> getFungusDetailListOrBuilderList() {
                if (this.fungusDetailListBuilder_ != null) {
                    return this.fungusDetailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.fungusDetailList_);
            }

            public FungusDetailOuterClass.FungusDetail.Builder addFungusDetailListBuilder() {
                return getFungusDetailListFieldBuilder().addBuilder(FungusDetailOuterClass.FungusDetail.getDefaultInstance());
            }

            public FungusDetailOuterClass.FungusDetail.Builder addFungusDetailListBuilder(int index) {
                return getFungusDetailListFieldBuilder().addBuilder(index, FungusDetailOuterClass.FungusDetail.getDefaultInstance());
            }

            public List<FungusDetailOuterClass.FungusDetail.Builder> getFungusDetailListBuilderList() {
                return getFungusDetailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FungusDetailOuterClass.FungusDetail, FungusDetailOuterClass.FungusDetail.Builder, FungusDetailOuterClass.FungusDetailOrBuilder> getFungusDetailListFieldBuilder() {
                if (this.fungusDetailListBuilder_ == null) {
                    this.fungusDetailListBuilder_ = new RepeatedFieldBuilderV3<>(this.fungusDetailList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.fungusDetailList_ = null;
                }
                return this.fungusDetailListBuilder_;
            }

            private void ensureUnk3300GIHAKKAJHDHIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300GIHAKKAJHDH_ = FungusFighterDetailInfo.mutableCopy(this.unk3300GIHAKKAJHDH_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<Integer> getUnk3300GIHAKKAJHDHList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300GIHAKKAJHDH_) : this.unk3300GIHAKKAJHDH_;
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getUnk3300GIHAKKAJHDHCount() {
                return this.unk3300GIHAKKAJHDH_.size();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getUnk3300GIHAKKAJHDH(int index) {
                return this.unk3300GIHAKKAJHDH_.getInt(index);
            }

            public Builder setUnk3300GIHAKKAJHDH(int index, int value) {
                ensureUnk3300GIHAKKAJHDHIsMutable();
                this.unk3300GIHAKKAJHDH_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300GIHAKKAJHDH(int value) {
                ensureUnk3300GIHAKKAJHDHIsMutable();
                this.unk3300GIHAKKAJHDH_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300GIHAKKAJHDH(Iterable<? extends Integer> values) {
                ensureUnk3300GIHAKKAJHDHIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300GIHAKKAJHDH_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300GIHAKKAJHDH() {
                this.unk3300GIHAKKAJHDH_ = FungusFighterDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureUnk3300KGKFJJHFHABIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unk3300KGKFJJHFHAB_ = FungusFighterDetailInfo.mutableCopy(this.unk3300KGKFJJHFHAB_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<Integer> getUnk3300KGKFJJHFHABList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.unk3300KGKFJJHFHAB_) : this.unk3300KGKFJJHFHAB_;
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getUnk3300KGKFJJHFHABCount() {
                return this.unk3300KGKFJJHFHAB_.size();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getUnk3300KGKFJJHFHAB(int index) {
                return this.unk3300KGKFJJHFHAB_.getInt(index);
            }

            public Builder setUnk3300KGKFJJHFHAB(int index, int value) {
                ensureUnk3300KGKFJJHFHABIsMutable();
                this.unk3300KGKFJJHFHAB_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300KGKFJJHFHAB(int value) {
                ensureUnk3300KGKFJJHFHABIsMutable();
                this.unk3300KGKFJJHFHAB_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300KGKFJJHFHAB(Iterable<? extends Integer> values) {
                ensureUnk3300KGKFJJHFHABIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300KGKFJJHFHAB_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300KGKFJJHFHAB() {
                this.unk3300KGKFJJHFHAB_ = FungusFighterDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureTrainingDungeonProgressDetailListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.trainingDungeonProgressDetailList_ = new ArrayList(this.trainingDungeonProgressDetailList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail> getTrainingDungeonProgressDetailListList() {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.trainingDungeonProgressDetailList_);
                }
                return this.trainingDungeonProgressDetailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getTrainingDungeonProgressDetailListCount() {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    return this.trainingDungeonProgressDetailList_.size();
                }
                return this.trainingDungeonProgressDetailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail getTrainingDungeonProgressDetailList(int index) {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    return this.trainingDungeonProgressDetailList_.get(index);
                }
                return this.trainingDungeonProgressDetailListBuilder_.getMessage(index);
            }

            public Builder setTrainingDungeonProgressDetailList(int index, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail value) {
                if (this.trainingDungeonProgressDetailListBuilder_ != null) {
                    this.trainingDungeonProgressDetailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    this.trainingDungeonProgressDetailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTrainingDungeonProgressDetailList(int index, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder builderForValue) {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    this.trainingDungeonProgressDetailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trainingDungeonProgressDetailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTrainingDungeonProgressDetailList(FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail value) {
                if (this.trainingDungeonProgressDetailListBuilder_ != null) {
                    this.trainingDungeonProgressDetailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    this.trainingDungeonProgressDetailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrainingDungeonProgressDetailList(int index, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail value) {
                if (this.trainingDungeonProgressDetailListBuilder_ != null) {
                    this.trainingDungeonProgressDetailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    this.trainingDungeonProgressDetailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrainingDungeonProgressDetailList(FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder builderForValue) {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    this.trainingDungeonProgressDetailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.trainingDungeonProgressDetailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTrainingDungeonProgressDetailList(int index, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder builderForValue) {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    this.trainingDungeonProgressDetailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trainingDungeonProgressDetailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTrainingDungeonProgressDetailList(Iterable<? extends FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail> values) {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.trainingDungeonProgressDetailList_);
                    onChanged();
                } else {
                    this.trainingDungeonProgressDetailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTrainingDungeonProgressDetailList() {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    this.trainingDungeonProgressDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.trainingDungeonProgressDetailListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTrainingDungeonProgressDetailList(int index) {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    ensureTrainingDungeonProgressDetailListIsMutable();
                    this.trainingDungeonProgressDetailList_.remove(index);
                    onChanged();
                } else {
                    this.trainingDungeonProgressDetailListBuilder_.remove(index);
                }
                return this;
            }

            public FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder getTrainingDungeonProgressDetailListBuilder(int index) {
                return getTrainingDungeonProgressDetailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder getTrainingDungeonProgressDetailListOrBuilder(int index) {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    return this.trainingDungeonProgressDetailList_.get(index);
                }
                return this.trainingDungeonProgressDetailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<? extends FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder> getTrainingDungeonProgressDetailListOrBuilderList() {
                if (this.trainingDungeonProgressDetailListBuilder_ != null) {
                    return this.trainingDungeonProgressDetailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.trainingDungeonProgressDetailList_);
            }

            public FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder addTrainingDungeonProgressDetailListBuilder() {
                return getTrainingDungeonProgressDetailListFieldBuilder().addBuilder(FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.getDefaultInstance());
            }

            public FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder addTrainingDungeonProgressDetailListBuilder(int index) {
                return getTrainingDungeonProgressDetailListFieldBuilder().addBuilder(index, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.getDefaultInstance());
            }

            public List<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder> getTrainingDungeonProgressDetailListBuilderList() {
                return getTrainingDungeonProgressDetailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetail.Builder, FungusTrainingProgressDetailOuterClass.FungusTrainingProgressDetailOrBuilder> getTrainingDungeonProgressDetailListFieldBuilder() {
                if (this.trainingDungeonProgressDetailListBuilder_ == null) {
                    this.trainingDungeonProgressDetailListBuilder_ = new RepeatedFieldBuilderV3<>(this.trainingDungeonProgressDetailList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.trainingDungeonProgressDetailList_ = null;
                }
                return this.trainingDungeonProgressDetailListBuilder_;
            }

            private void ensureUnk3300HPDOJOBPFMJIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.unk3300HPDOJOBPFMJ_ = FungusFighterDetailInfo.mutableCopy(this.unk3300HPDOJOBPFMJ_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<Integer> getUnk3300HPDOJOBPFMJList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.unk3300HPDOJOBPFMJ_) : this.unk3300HPDOJOBPFMJ_;
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getUnk3300HPDOJOBPFMJCount() {
                return this.unk3300HPDOJOBPFMJ_.size();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getUnk3300HPDOJOBPFMJ(int index) {
                return this.unk3300HPDOJOBPFMJ_.getInt(index);
            }

            public Builder setUnk3300HPDOJOBPFMJ(int index, int value) {
                ensureUnk3300HPDOJOBPFMJIsMutable();
                this.unk3300HPDOJOBPFMJ_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300HPDOJOBPFMJ(int value) {
                ensureUnk3300HPDOJOBPFMJIsMutable();
                this.unk3300HPDOJOBPFMJ_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300HPDOJOBPFMJ(Iterable<? extends Integer> values) {
                ensureUnk3300HPDOJOBPFMJIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300HPDOJOBPFMJ_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300HPDOJOBPFMJ() {
                this.unk3300HPDOJOBPFMJ_ = FungusFighterDetailInfo.emptyIntList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            private void ensurePlotStageDetailListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.plotStageDetailList_ = new ArrayList(this.plotStageDetailList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<FungusPlotStageDetailOuterClass.FungusPlotStageDetail> getPlotStageDetailListList() {
                if (this.plotStageDetailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.plotStageDetailList_);
                }
                return this.plotStageDetailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getPlotStageDetailListCount() {
                if (this.plotStageDetailListBuilder_ == null) {
                    return this.plotStageDetailList_.size();
                }
                return this.plotStageDetailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusPlotStageDetailOuterClass.FungusPlotStageDetail getPlotStageDetailList(int index) {
                if (this.plotStageDetailListBuilder_ == null) {
                    return this.plotStageDetailList_.get(index);
                }
                return this.plotStageDetailListBuilder_.getMessage(index);
            }

            public Builder setPlotStageDetailList(int index, FungusPlotStageDetailOuterClass.FungusPlotStageDetail value) {
                if (this.plotStageDetailListBuilder_ != null) {
                    this.plotStageDetailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlotStageDetailListIsMutable();
                    this.plotStageDetailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPlotStageDetailList(int index, FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder builderForValue) {
                if (this.plotStageDetailListBuilder_ == null) {
                    ensurePlotStageDetailListIsMutable();
                    this.plotStageDetailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.plotStageDetailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPlotStageDetailList(FungusPlotStageDetailOuterClass.FungusPlotStageDetail value) {
                if (this.plotStageDetailListBuilder_ != null) {
                    this.plotStageDetailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlotStageDetailListIsMutable();
                    this.plotStageDetailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlotStageDetailList(int index, FungusPlotStageDetailOuterClass.FungusPlotStageDetail value) {
                if (this.plotStageDetailListBuilder_ != null) {
                    this.plotStageDetailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePlotStageDetailListIsMutable();
                    this.plotStageDetailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPlotStageDetailList(FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder builderForValue) {
                if (this.plotStageDetailListBuilder_ == null) {
                    ensurePlotStageDetailListIsMutable();
                    this.plotStageDetailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.plotStageDetailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPlotStageDetailList(int index, FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder builderForValue) {
                if (this.plotStageDetailListBuilder_ == null) {
                    ensurePlotStageDetailListIsMutable();
                    this.plotStageDetailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.plotStageDetailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPlotStageDetailList(Iterable<? extends FungusPlotStageDetailOuterClass.FungusPlotStageDetail> values) {
                if (this.plotStageDetailListBuilder_ == null) {
                    ensurePlotStageDetailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.plotStageDetailList_);
                    onChanged();
                } else {
                    this.plotStageDetailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPlotStageDetailList() {
                if (this.plotStageDetailListBuilder_ == null) {
                    this.plotStageDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.plotStageDetailListBuilder_.clear();
                }
                return this;
            }

            public Builder removePlotStageDetailList(int index) {
                if (this.plotStageDetailListBuilder_ == null) {
                    ensurePlotStageDetailListIsMutable();
                    this.plotStageDetailList_.remove(index);
                    onChanged();
                } else {
                    this.plotStageDetailListBuilder_.remove(index);
                }
                return this;
            }

            public FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder getPlotStageDetailListBuilder(int index) {
                return getPlotStageDetailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder getPlotStageDetailListOrBuilder(int index) {
                if (this.plotStageDetailListBuilder_ == null) {
                    return this.plotStageDetailList_.get(index);
                }
                return this.plotStageDetailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<? extends FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder> getPlotStageDetailListOrBuilderList() {
                if (this.plotStageDetailListBuilder_ != null) {
                    return this.plotStageDetailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.plotStageDetailList_);
            }

            public FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder addPlotStageDetailListBuilder() {
                return getPlotStageDetailListFieldBuilder().addBuilder(FungusPlotStageDetailOuterClass.FungusPlotStageDetail.getDefaultInstance());
            }

            public FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder addPlotStageDetailListBuilder(int index) {
                return getPlotStageDetailListFieldBuilder().addBuilder(index, FungusPlotStageDetailOuterClass.FungusPlotStageDetail.getDefaultInstance());
            }

            public List<FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder> getPlotStageDetailListBuilderList() {
                return getPlotStageDetailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FungusPlotStageDetailOuterClass.FungusPlotStageDetail, FungusPlotStageDetailOuterClass.FungusPlotStageDetail.Builder, FungusPlotStageDetailOuterClass.FungusPlotStageDetailOrBuilder> getPlotStageDetailListFieldBuilder() {
                if (this.plotStageDetailListBuilder_ == null) {
                    this.plotStageDetailListBuilder_ = new RepeatedFieldBuilderV3<>(this.plotStageDetailList_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                    this.plotStageDetailList_ = null;
                }
                return this.plotStageDetailListBuilder_;
            }

            private void ensureTrainingDungeonDetailListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.trainingDungeonDetailList_ = new ArrayList(this.trainingDungeonDetailList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail> getTrainingDungeonDetailListList() {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.trainingDungeonDetailList_);
                }
                return this.trainingDungeonDetailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public int getTrainingDungeonDetailListCount() {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    return this.trainingDungeonDetailList_.size();
                }
                return this.trainingDungeonDetailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail getTrainingDungeonDetailList(int index) {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    return this.trainingDungeonDetailList_.get(index);
                }
                return this.trainingDungeonDetailListBuilder_.getMessage(index);
            }

            public Builder setTrainingDungeonDetailList(int index, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail value) {
                if (this.trainingDungeonDetailListBuilder_ != null) {
                    this.trainingDungeonDetailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrainingDungeonDetailListIsMutable();
                    this.trainingDungeonDetailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTrainingDungeonDetailList(int index, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder builderForValue) {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    ensureTrainingDungeonDetailListIsMutable();
                    this.trainingDungeonDetailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trainingDungeonDetailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTrainingDungeonDetailList(FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail value) {
                if (this.trainingDungeonDetailListBuilder_ != null) {
                    this.trainingDungeonDetailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrainingDungeonDetailListIsMutable();
                    this.trainingDungeonDetailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrainingDungeonDetailList(int index, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail value) {
                if (this.trainingDungeonDetailListBuilder_ != null) {
                    this.trainingDungeonDetailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTrainingDungeonDetailListIsMutable();
                    this.trainingDungeonDetailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTrainingDungeonDetailList(FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder builderForValue) {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    ensureTrainingDungeonDetailListIsMutable();
                    this.trainingDungeonDetailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.trainingDungeonDetailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTrainingDungeonDetailList(int index, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder builderForValue) {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    ensureTrainingDungeonDetailListIsMutable();
                    this.trainingDungeonDetailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.trainingDungeonDetailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTrainingDungeonDetailList(Iterable<? extends FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail> values) {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    ensureTrainingDungeonDetailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.trainingDungeonDetailList_);
                    onChanged();
                } else {
                    this.trainingDungeonDetailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTrainingDungeonDetailList() {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    this.trainingDungeonDetailList_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.trainingDungeonDetailListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTrainingDungeonDetailList(int index) {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    ensureTrainingDungeonDetailListIsMutable();
                    this.trainingDungeonDetailList_.remove(index);
                    onChanged();
                } else {
                    this.trainingDungeonDetailListBuilder_.remove(index);
                }
                return this;
            }

            public FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder getTrainingDungeonDetailListBuilder(int index) {
                return getTrainingDungeonDetailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder getTrainingDungeonDetailListOrBuilder(int index) {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    return this.trainingDungeonDetailList_.get(index);
                }
                return this.trainingDungeonDetailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder
            public List<? extends FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder> getTrainingDungeonDetailListOrBuilderList() {
                if (this.trainingDungeonDetailListBuilder_ != null) {
                    return this.trainingDungeonDetailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.trainingDungeonDetailList_);
            }

            public FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder addTrainingDungeonDetailListBuilder() {
                return getTrainingDungeonDetailListFieldBuilder().addBuilder(FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.getDefaultInstance());
            }

            public FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder addTrainingDungeonDetailListBuilder(int index) {
                return getTrainingDungeonDetailListFieldBuilder().addBuilder(index, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.getDefaultInstance());
            }

            public List<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder> getTrainingDungeonDetailListBuilderList() {
                return getTrainingDungeonDetailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetail.Builder, FungusTrainingDungeonDetailOuterClass.FungusTrainingDungeonDetailOrBuilder> getTrainingDungeonDetailListFieldBuilder() {
                if (this.trainingDungeonDetailListBuilder_ == null) {
                    this.trainingDungeonDetailListBuilder_ = new RepeatedFieldBuilderV3<>(this.trainingDungeonDetailList_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                    this.trainingDungeonDetailList_ = null;
                }
                return this.trainingDungeonDetailListBuilder_;
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

        public static FungusFighterDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FungusFighterDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FungusFighterDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FungusFighterDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FungusDetailOuterClass.getDescriptor();
        FungusPlotStageDetailOuterClass.getDescriptor();
        FungusTrainingDungeonDetailOuterClass.getDescriptor();
        FungusTrainingProgressDetailOuterClass.getDescriptor();
    }
}
