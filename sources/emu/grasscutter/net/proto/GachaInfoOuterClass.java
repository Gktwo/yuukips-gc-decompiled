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
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AttackResultOuterClass;
import emu.grasscutter.net.proto.GachaUpInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass.class */
public final class GachaInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fGachaInfo.proto\u001a\u0011GachaUpInfo.proto\"È\u0005\n\tGachaInfo\u0012\u0018\n\u0010left_gacha_times\u0018\u0005 \u0001(\r\u0012\u0012\n\ngacha_type\u0018\u0007 \u0001(\r\u0012\u0016\n\rwish_progress\u0018º\u0007 \u0001(\r\u0012\u001f\n\u0016gacha_prob_url_oversea\u0018ü\u000b \u0001(\t\u0012\u0018\n\u0010gacha_record_url\u0018\u000f \u0001(\t\u0012\u0016\n\u000egacha_prob_url\u0018\u0001 \u0001(\t\u0012\u0012\n\nbegin_time\u0018\u000e \u0001(\r\u0012\u0013\n\u000bschedule_id\u0018\b \u0001(\r\u0012\u001e\n\u0015display_up5_item_list\u0018Ü\u0003 \u0003(\r\u0012\u0019\n\u0011gacha_times_limit\u0018\n \u0001(\r\u0012!\n\u0019gacha_preview_prefab_path\u0018\u0004 \u0001(\t\u0012\u0015\n\rtitle_textmap\u0018r \u0001(\t\u0012'\n\u001ecur_schedule_daily_gacha_times\u0018õ\u0001 \u0001(\r\u0012\u0010\n\bend_time\u0018\u0002 \u0001(\r\u0012\u001e\n\u0015display_up4_item_list\u0018\u0004 \u0003(\r\u0012\u0019\n\u0011ten_cost_item_num\u0018\r \u0001(\r\u0012\u001a\n\u0011wish_max_progress\u0018û\t \u0001(\r\u0012\u0018\n\u0010ten_cost_item_id\u0018\t \u0001(\r\u0012\u0015\n\rgacha_sort_id\u0018\u0006 \u0001(\r\u0012\u0014\n\u000bis_new_wish\u0018Ç\u0007 \u0001(\b\u0012\u0015\n\rcost_item_num\u0018\f \u0001(\r\u0012\u0015\n\fwish_item_id\u0018¬\f \u0001(\r\u0012!\n\u0018gacha_record_url_oversea\u0018ë\t \u0001(\t\u0012)\n\u0012gacha_up_info_list\u0018±\f \u0003(\u000b2\f.GachaUpInfo\u0012\u0014\n\fcost_item_id\u0018\u0003 \u0001(\r\u0012\u0019\n\u0011gacha_prefab_path\u0018\u000b \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GachaUpInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GachaInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GachaInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GachaInfo_descriptor, new String[]{"LeftGachaTimes", "GachaType", "WishProgress", "GachaProbUrlOversea", "GachaRecordUrl", "GachaProbUrl", "BeginTime", "ScheduleId", "DisplayUp5ItemList", "GachaTimesLimit", "GachaPreviewPrefabPath", "TitleTextmap", "CurScheduleDailyGachaTimes", "EndTime", "DisplayUp4ItemList", "TenCostItemNum", "WishMaxProgress", "TenCostItemId", "GachaSortId", "IsNewWish", "CostItemNum", "WishItemId", "GachaRecordUrlOversea", "GachaUpInfoList", "CostItemId", "GachaPrefabPath"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass$GachaInfoOrBuilder.class */
    public interface GachaInfoOrBuilder extends MessageOrBuilder {
        int getLeftGachaTimes();

        int getGachaType();

        int getWishProgress();

        String getGachaProbUrlOversea();

        ByteString getGachaProbUrlOverseaBytes();

        String getGachaRecordUrl();

        ByteString getGachaRecordUrlBytes();

        String getGachaProbUrl();

        ByteString getGachaProbUrlBytes();

        int getBeginTime();

        int getScheduleId();

        List<Integer> getDisplayUp5ItemListList();

        int getDisplayUp5ItemListCount();

        int getDisplayUp5ItemList(int i);

        int getGachaTimesLimit();

        String getGachaPreviewPrefabPath();

        ByteString getGachaPreviewPrefabPathBytes();

        String getTitleTextmap();

        ByteString getTitleTextmapBytes();

        int getCurScheduleDailyGachaTimes();

        int getEndTime();

        List<Integer> getDisplayUp4ItemListList();

        int getDisplayUp4ItemListCount();

        int getDisplayUp4ItemList(int i);

        int getTenCostItemNum();

        int getWishMaxProgress();

        int getTenCostItemId();

        int getGachaSortId();

        boolean getIsNewWish();

        int getCostItemNum();

        int getWishItemId();

        String getGachaRecordUrlOversea();

        ByteString getGachaRecordUrlOverseaBytes();

        List<GachaUpInfoOuterClass.GachaUpInfo> getGachaUpInfoListList();

        GachaUpInfoOuterClass.GachaUpInfo getGachaUpInfoList(int i);

        int getGachaUpInfoListCount();

        List<? extends GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListOrBuilderList();

        GachaUpInfoOuterClass.GachaUpInfoOrBuilder getGachaUpInfoListOrBuilder(int i);

        int getCostItemId();

        String getGachaPrefabPath();

        ByteString getGachaPrefabPathBytes();
    }

    private GachaInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass$GachaInfo.class */
    public static final class GachaInfo extends GeneratedMessageV3 implements GachaInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEFT_GACHA_TIMES_FIELD_NUMBER = 5;
        private int leftGachaTimes_;
        public static final int GACHA_TYPE_FIELD_NUMBER = 7;
        private int gachaType_;
        public static final int WISH_PROGRESS_FIELD_NUMBER = 954;
        private int wishProgress_;
        public static final int GACHA_PROB_URL_OVERSEA_FIELD_NUMBER = 1532;
        private volatile Object gachaProbUrlOversea_;
        public static final int GACHA_RECORD_URL_FIELD_NUMBER = 15;
        private volatile Object gachaRecordUrl_;
        public static final int GACHA_PROB_URL_FIELD_NUMBER = 1;
        private volatile Object gachaProbUrl_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 14;
        private int beginTime_;
        public static final int SCHEDULE_ID_FIELD_NUMBER = 8;
        private int scheduleId_;
        public static final int DISPLAY_UP5_ITEM_LIST_FIELD_NUMBER = 476;
        private Internal.IntList displayUp5ItemList_;
        private int displayUp5ItemListMemoizedSerializedSize;
        public static final int GACHA_TIMES_LIMIT_FIELD_NUMBER = 10;
        private int gachaTimesLimit_;
        public static final int GACHA_PREVIEW_PREFAB_PATH_FIELD_NUMBER = 4;
        private volatile Object gachaPreviewPrefabPath_;
        public static final int TITLE_TEXTMAP_FIELD_NUMBER = 114;
        private volatile Object titleTextmap_;
        public static final int CUR_SCHEDULE_DAILY_GACHA_TIMES_FIELD_NUMBER = 245;
        private int curScheduleDailyGachaTimes_;
        public static final int END_TIME_FIELD_NUMBER = 2;
        private int endTime_;
        public static final int DISPLAY_UP4_ITEM_LIST_FIELD_NUMBER = 540;
        private Internal.IntList displayUp4ItemList_;
        private int displayUp4ItemListMemoizedSerializedSize;
        public static final int TEN_COST_ITEM_NUM_FIELD_NUMBER = 13;
        private int tenCostItemNum_;
        public static final int WISH_MAX_PROGRESS_FIELD_NUMBER = 1275;
        private int wishMaxProgress_;
        public static final int TEN_COST_ITEM_ID_FIELD_NUMBER = 9;
        private int tenCostItemId_;
        public static final int GACHA_SORT_ID_FIELD_NUMBER = 6;
        private int gachaSortId_;
        public static final int IS_NEW_WISH_FIELD_NUMBER = 967;
        private boolean isNewWish_;
        public static final int COST_ITEM_NUM_FIELD_NUMBER = 12;
        private int costItemNum_;
        public static final int WISH_ITEM_ID_FIELD_NUMBER = 1580;
        private int wishItemId_;
        public static final int GACHA_RECORD_URL_OVERSEA_FIELD_NUMBER = 1259;
        private volatile Object gachaRecordUrlOversea_;
        public static final int GACHA_UP_INFO_LIST_FIELD_NUMBER = 1585;
        private List<GachaUpInfoOuterClass.GachaUpInfo> gachaUpInfoList_;
        public static final int COST_ITEM_ID_FIELD_NUMBER = 3;
        private int costItemId_;
        public static final int GACHA_PREFAB_PATH_FIELD_NUMBER = 11;
        private volatile Object gachaPrefabPath_;
        private byte memoizedIsInitialized;
        private static final GachaInfo DEFAULT_INSTANCE = new GachaInfo();
        private static final Parser<GachaInfo> PARSER = new AbstractParser<GachaInfo>() { // from class: emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfo.1
            @Override // com.google.protobuf.Parser
            public GachaInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GachaInfo(input, extensionRegistry);
            }
        };

        private GachaInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.displayUp5ItemListMemoizedSerializedSize = -1;
            this.displayUp4ItemListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GachaInfo() {
            this.displayUp5ItemListMemoizedSerializedSize = -1;
            this.displayUp4ItemListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.gachaProbUrlOversea_ = "";
            this.gachaRecordUrl_ = "";
            this.gachaProbUrl_ = "";
            this.displayUp5ItemList_ = emptyIntList();
            this.gachaPreviewPrefabPath_ = "";
            this.titleTextmap_ = "";
            this.displayUp4ItemList_ = emptyIntList();
            this.gachaRecordUrlOversea_ = "";
            this.gachaUpInfoList_ = Collections.emptyList();
            this.gachaPrefabPath_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GachaInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:135:0x0342 */
        private GachaInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                this.gachaProbUrl_ = input.readStringRequireUtf8();
                                break;
                            case 16:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 24:
                                this.costItemId_ = input.readUInt32();
                                break;
                            case 34:
                                this.gachaPreviewPrefabPath_ = input.readStringRequireUtf8();
                                break;
                            case 40:
                                this.leftGachaTimes_ = input.readUInt32();
                                break;
                            case 48:
                                this.gachaSortId_ = input.readUInt32();
                                break;
                            case 56:
                                this.gachaType_ = input.readUInt32();
                                break;
                            case 64:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 72:
                                this.tenCostItemId_ = input.readUInt32();
                                break;
                            case 80:
                                this.gachaTimesLimit_ = input.readUInt32();
                                break;
                            case 90:
                                this.gachaPrefabPath_ = input.readStringRequireUtf8();
                                break;
                            case 96:
                                this.costItemNum_ = input.readUInt32();
                                break;
                            case 104:
                                this.tenCostItemNum_ = input.readUInt32();
                                break;
                            case 112:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 122:
                                this.gachaRecordUrl_ = input.readStringRequireUtf8();
                                break;
                            case AttackResultOuterClass.AttackResult.UNK3300_JMJHGJCAOBH_FIELD_NUMBER:
                                this.titleTextmap_ = input.readStringRequireUtf8();
                                break;
                            case PacketOpcodes.SaveCoopDialogRsp:
                                this.curScheduleDailyGachaTimes_ = input.readUInt32();
                                break;
                            case 3808:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.displayUp5ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.displayUp5ItemList_.addInt(input.readUInt32());
                                break;
                            case 3810:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.displayUp5ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.displayUp5ItemList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 4320:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.displayUp4ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.displayUp4ItemList_.addInt(input.readUInt32());
                                break;
                            case PacketOpcodes.GetCityHuntingOfferReq:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.displayUp4ItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.displayUp4ItemList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 7632:
                                this.wishProgress_ = input.readUInt32();
                                break;
                            case 7736:
                                this.isNewWish_ = input.readBool();
                                break;
                            case RET_WINTER_CAMP_COIN_B_EXCEED_LIMIT_VALUE:
                                this.gachaRecordUrlOversea_ = input.readStringRequireUtf8();
                                break;
                            case 10200:
                                this.wishMaxProgress_ = input.readUInt32();
                                break;
                            case RET_GCG_TC_NO_INVITE_DATA_VALUE:
                                this.gachaProbUrlOversea_ = input.readStringRequireUtf8();
                                break;
                            case 12640:
                                this.wishItemId_ = input.readUInt32();
                                break;
                            case 12682:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.gachaUpInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.gachaUpInfoList_.add((GachaUpInfoOuterClass.GachaUpInfo) input.readMessage(GachaUpInfoOuterClass.GachaUpInfo.parser(), extensionRegistry));
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
                    this.displayUp5ItemList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.displayUp4ItemList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.gachaUpInfoList_ = Collections.unmodifiableList(this.gachaUpInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GachaInfoOuterClass.internal_static_GachaInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GachaInfoOuterClass.internal_static_GachaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getLeftGachaTimes() {
            return this.leftGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaType() {
            return this.gachaType_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getWishProgress() {
            return this.wishProgress_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaProbUrlOversea() {
            Object ref = this.gachaProbUrlOversea_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaProbUrlOversea_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaProbUrlOverseaBytes() {
            Object ref = this.gachaProbUrlOversea_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaProbUrlOversea_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaRecordUrl() {
            Object ref = this.gachaRecordUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaRecordUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaRecordUrlBytes() {
            Object ref = this.gachaRecordUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaRecordUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaProbUrl() {
            Object ref = this.gachaProbUrl_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaProbUrl_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaProbUrlBytes() {
            Object ref = this.gachaProbUrl_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaProbUrl_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<Integer> getDisplayUp5ItemListList() {
            return this.displayUp5ItemList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp5ItemListCount() {
            return this.displayUp5ItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp5ItemList(int index) {
            return this.displayUp5ItemList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaTimesLimit() {
            return this.gachaTimesLimit_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaPreviewPrefabPath() {
            Object ref = this.gachaPreviewPrefabPath_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaPreviewPrefabPath_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaPreviewPrefabPathBytes() {
            Object ref = this.gachaPreviewPrefabPath_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaPreviewPrefabPath_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getTitleTextmap() {
            Object ref = this.titleTextmap_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.titleTextmap_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getTitleTextmapBytes() {
            Object ref = this.titleTextmap_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.titleTextmap_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getCurScheduleDailyGachaTimes() {
            return this.curScheduleDailyGachaTimes_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<Integer> getDisplayUp4ItemListList() {
            return this.displayUp4ItemList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp4ItemListCount() {
            return this.displayUp4ItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getDisplayUp4ItemList(int index) {
            return this.displayUp4ItemList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getTenCostItemNum() {
            return this.tenCostItemNum_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getWishMaxProgress() {
            return this.wishMaxProgress_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getTenCostItemId() {
            return this.tenCostItemId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaSortId() {
            return this.gachaSortId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public boolean getIsNewWish() {
            return this.isNewWish_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getCostItemNum() {
            return this.costItemNum_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getWishItemId() {
            return this.wishItemId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaRecordUrlOversea() {
            Object ref = this.gachaRecordUrlOversea_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaRecordUrlOversea_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaRecordUrlOverseaBytes() {
            Object ref = this.gachaRecordUrlOversea_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaRecordUrlOversea_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<GachaUpInfoOuterClass.GachaUpInfo> getGachaUpInfoListList() {
            return this.gachaUpInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public List<? extends GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListOrBuilderList() {
            return this.gachaUpInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getGachaUpInfoListCount() {
            return this.gachaUpInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public GachaUpInfoOuterClass.GachaUpInfo getGachaUpInfoList(int index) {
            return this.gachaUpInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public GachaUpInfoOuterClass.GachaUpInfoOrBuilder getGachaUpInfoListOrBuilder(int index) {
            return this.gachaUpInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public int getCostItemId() {
            return this.costItemId_;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public String getGachaPrefabPath() {
            Object ref = this.gachaPrefabPath_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.gachaPrefabPath_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
        public ByteString getGachaPrefabPathBytes() {
            Object ref = this.gachaPrefabPath_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.gachaPrefabPath_ = b;
            return b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrl_)) {
                GeneratedMessageV3.writeString(output, 1, this.gachaProbUrl_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(2, this.endTime_);
            }
            if (this.costItemId_ != 0) {
                output.writeUInt32(3, this.costItemId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPreviewPrefabPath_)) {
                GeneratedMessageV3.writeString(output, 4, this.gachaPreviewPrefabPath_);
            }
            if (this.leftGachaTimes_ != 0) {
                output.writeUInt32(5, this.leftGachaTimes_);
            }
            if (this.gachaSortId_ != 0) {
                output.writeUInt32(6, this.gachaSortId_);
            }
            if (this.gachaType_ != 0) {
                output.writeUInt32(7, this.gachaType_);
            }
            if (this.scheduleId_ != 0) {
                output.writeUInt32(8, this.scheduleId_);
            }
            if (this.tenCostItemId_ != 0) {
                output.writeUInt32(9, this.tenCostItemId_);
            }
            if (this.gachaTimesLimit_ != 0) {
                output.writeUInt32(10, this.gachaTimesLimit_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPrefabPath_)) {
                GeneratedMessageV3.writeString(output, 11, this.gachaPrefabPath_);
            }
            if (this.costItemNum_ != 0) {
                output.writeUInt32(12, this.costItemNum_);
            }
            if (this.tenCostItemNum_ != 0) {
                output.writeUInt32(13, this.tenCostItemNum_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(14, this.beginTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrl_)) {
                GeneratedMessageV3.writeString(output, 15, this.gachaRecordUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.titleTextmap_)) {
                GeneratedMessageV3.writeString(output, 114, this.titleTextmap_);
            }
            if (this.curScheduleDailyGachaTimes_ != 0) {
                output.writeUInt32(245, this.curScheduleDailyGachaTimes_);
            }
            if (getDisplayUp5ItemListList().size() > 0) {
                output.writeUInt32NoTag(3810);
                output.writeUInt32NoTag(this.displayUp5ItemListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.displayUp5ItemList_.size(); i++) {
                output.writeUInt32NoTag(this.displayUp5ItemList_.getInt(i));
            }
            if (getDisplayUp4ItemListList().size() > 0) {
                output.writeUInt32NoTag(PacketOpcodes.GetCityHuntingOfferReq);
                output.writeUInt32NoTag(this.displayUp4ItemListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.displayUp4ItemList_.size(); i2++) {
                output.writeUInt32NoTag(this.displayUp4ItemList_.getInt(i2));
            }
            if (this.wishProgress_ != 0) {
                output.writeUInt32(954, this.wishProgress_);
            }
            if (this.isNewWish_) {
                output.writeBool(967, this.isNewWish_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrlOversea_)) {
                GeneratedMessageV3.writeString(output, GACHA_RECORD_URL_OVERSEA_FIELD_NUMBER, this.gachaRecordUrlOversea_);
            }
            if (this.wishMaxProgress_ != 0) {
                output.writeUInt32(WISH_MAX_PROGRESS_FIELD_NUMBER, this.wishMaxProgress_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrlOversea_)) {
                GeneratedMessageV3.writeString(output, 1532, this.gachaProbUrlOversea_);
            }
            if (this.wishItemId_ != 0) {
                output.writeUInt32(WISH_ITEM_ID_FIELD_NUMBER, this.wishItemId_);
            }
            for (int i3 = 0; i3 < this.gachaUpInfoList_.size(); i3++) {
                output.writeMessage(1585, this.gachaUpInfoList_.get(i3));
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
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrl_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(1, this.gachaProbUrl_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.endTime_);
            }
            if (this.costItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.costItemId_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPreviewPrefabPath_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.gachaPreviewPrefabPath_);
            }
            if (this.leftGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.leftGachaTimes_);
            }
            if (this.gachaSortId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.gachaSortId_);
            }
            if (this.gachaType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.gachaType_);
            }
            if (this.scheduleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.scheduleId_);
            }
            if (this.tenCostItemId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.tenCostItemId_);
            }
            if (this.gachaTimesLimit_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.gachaTimesLimit_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaPrefabPath_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.gachaPrefabPath_);
            }
            if (this.costItemNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.costItemNum_);
            }
            if (this.tenCostItemNum_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.tenCostItemNum_);
            }
            if (this.beginTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.beginTime_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrl_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.gachaRecordUrl_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.titleTextmap_)) {
                size2 += GeneratedMessageV3.computeStringSize(114, this.titleTextmap_);
            }
            if (this.curScheduleDailyGachaTimes_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(245, this.curScheduleDailyGachaTimes_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.displayUp5ItemList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.displayUp5ItemList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getDisplayUp5ItemListList().isEmpty()) {
                size3 = size3 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.displayUp5ItemListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.displayUp4ItemList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.displayUp4ItemList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getDisplayUp4ItemListList().isEmpty()) {
                size4 = size4 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.displayUp4ItemListMemoizedSerializedSize = dataSize2;
            if (this.wishProgress_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(954, this.wishProgress_);
            }
            if (this.isNewWish_) {
                size4 += CodedOutputStream.computeBoolSize(967, this.isNewWish_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaRecordUrlOversea_)) {
                size4 += GeneratedMessageV3.computeStringSize(GACHA_RECORD_URL_OVERSEA_FIELD_NUMBER, this.gachaRecordUrlOversea_);
            }
            if (this.wishMaxProgress_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(WISH_MAX_PROGRESS_FIELD_NUMBER, this.wishMaxProgress_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.gachaProbUrlOversea_)) {
                size4 += GeneratedMessageV3.computeStringSize(1532, this.gachaProbUrlOversea_);
            }
            if (this.wishItemId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(WISH_ITEM_ID_FIELD_NUMBER, this.wishItemId_);
            }
            for (int i3 = 0; i3 < this.gachaUpInfoList_.size(); i3++) {
                size4 += CodedOutputStream.computeMessageSize(1585, this.gachaUpInfoList_.get(i3));
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
            if (!(obj instanceof GachaInfo)) {
                return equals(obj);
            }
            GachaInfo other = (GachaInfo) obj;
            return getLeftGachaTimes() == other.getLeftGachaTimes() && getGachaType() == other.getGachaType() && getWishProgress() == other.getWishProgress() && getGachaProbUrlOversea().equals(other.getGachaProbUrlOversea()) && getGachaRecordUrl().equals(other.getGachaRecordUrl()) && getGachaProbUrl().equals(other.getGachaProbUrl()) && getBeginTime() == other.getBeginTime() && getScheduleId() == other.getScheduleId() && getDisplayUp5ItemListList().equals(other.getDisplayUp5ItemListList()) && getGachaTimesLimit() == other.getGachaTimesLimit() && getGachaPreviewPrefabPath().equals(other.getGachaPreviewPrefabPath()) && getTitleTextmap().equals(other.getTitleTextmap()) && getCurScheduleDailyGachaTimes() == other.getCurScheduleDailyGachaTimes() && getEndTime() == other.getEndTime() && getDisplayUp4ItemListList().equals(other.getDisplayUp4ItemListList()) && getTenCostItemNum() == other.getTenCostItemNum() && getWishMaxProgress() == other.getWishMaxProgress() && getTenCostItemId() == other.getTenCostItemId() && getGachaSortId() == other.getGachaSortId() && getIsNewWish() == other.getIsNewWish() && getCostItemNum() == other.getCostItemNum() && getWishItemId() == other.getWishItemId() && getGachaRecordUrlOversea().equals(other.getGachaRecordUrlOversea()) && getGachaUpInfoListList().equals(other.getGachaUpInfoListList()) && getCostItemId() == other.getCostItemId() && getGachaPrefabPath().equals(other.getGachaPrefabPath()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getLeftGachaTimes())) + 7)) + getGachaType())) + 954)) + getWishProgress())) + 1532)) + getGachaProbUrlOversea().hashCode())) + 15)) + getGachaRecordUrl().hashCode())) + 1)) + getGachaProbUrl().hashCode())) + 14)) + getBeginTime())) + 8)) + getScheduleId();
            if (getDisplayUp5ItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 476)) + getDisplayUp5ItemListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + getGachaTimesLimit())) + 4)) + getGachaPreviewPrefabPath().hashCode())) + 114)) + getTitleTextmap().hashCode())) + 245)) + getCurScheduleDailyGachaTimes())) + 2)) + getEndTime();
            if (getDisplayUp4ItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + DISPLAY_UP4_ITEM_LIST_FIELD_NUMBER)) + getDisplayUp4ItemListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 13)) + getTenCostItemNum())) + WISH_MAX_PROGRESS_FIELD_NUMBER)) + getWishMaxProgress())) + 9)) + getTenCostItemId())) + 6)) + getGachaSortId())) + 967)) + Internal.hashBoolean(getIsNewWish()))) + 12)) + getCostItemNum())) + WISH_ITEM_ID_FIELD_NUMBER)) + getWishItemId())) + GACHA_RECORD_URL_OVERSEA_FIELD_NUMBER)) + getGachaRecordUrlOversea().hashCode();
            if (getGachaUpInfoListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 1585)) + getGachaUpInfoListList().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * ((53 * ((37 * hash3) + 3)) + getCostItemId())) + 11)) + getGachaPrefabPath().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static GachaInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GachaInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GachaInfo parseFrom(InputStream input) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GachaInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GachaInfo parseFrom(CodedInputStream input) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GachaInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GachaInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GachaInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GachaInfoOuterClass$GachaInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GachaInfoOrBuilder {
            private int bitField0_;
            private int leftGachaTimes_;
            private int gachaType_;
            private int wishProgress_;
            private int beginTime_;
            private int scheduleId_;
            private int gachaTimesLimit_;
            private int curScheduleDailyGachaTimes_;
            private int endTime_;
            private int tenCostItemNum_;
            private int wishMaxProgress_;
            private int tenCostItemId_;
            private int gachaSortId_;
            private boolean isNewWish_;
            private int costItemNum_;
            private int wishItemId_;
            private RepeatedFieldBuilderV3<GachaUpInfoOuterClass.GachaUpInfo, GachaUpInfoOuterClass.GachaUpInfo.Builder, GachaUpInfoOuterClass.GachaUpInfoOrBuilder> gachaUpInfoListBuilder_;
            private int costItemId_;
            private Object gachaProbUrlOversea_ = "";
            private Object gachaRecordUrl_ = "";
            private Object gachaProbUrl_ = "";
            private Internal.IntList displayUp5ItemList_ = GachaInfo.emptyIntList();
            private Object gachaPreviewPrefabPath_ = "";
            private Object titleTextmap_ = "";
            private Internal.IntList displayUp4ItemList_ = GachaInfo.emptyIntList();
            private Object gachaRecordUrlOversea_ = "";
            private List<GachaUpInfoOuterClass.GachaUpInfo> gachaUpInfoList_ = Collections.emptyList();
            private Object gachaPrefabPath_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return GachaInfoOuterClass.internal_static_GachaInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GachaInfoOuterClass.internal_static_GachaInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GachaInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GachaInfo.alwaysUseFieldBuilders) {
                    getGachaUpInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.leftGachaTimes_ = 0;
                this.gachaType_ = 0;
                this.wishProgress_ = 0;
                this.gachaProbUrlOversea_ = "";
                this.gachaRecordUrl_ = "";
                this.gachaProbUrl_ = "";
                this.beginTime_ = 0;
                this.scheduleId_ = 0;
                this.displayUp5ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.gachaTimesLimit_ = 0;
                this.gachaPreviewPrefabPath_ = "";
                this.titleTextmap_ = "";
                this.curScheduleDailyGachaTimes_ = 0;
                this.endTime_ = 0;
                this.displayUp4ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.tenCostItemNum_ = 0;
                this.wishMaxProgress_ = 0;
                this.tenCostItemId_ = 0;
                this.gachaSortId_ = 0;
                this.isNewWish_ = false;
                this.costItemNum_ = 0;
                this.wishItemId_ = 0;
                this.gachaRecordUrlOversea_ = "";
                if (this.gachaUpInfoListBuilder_ == null) {
                    this.gachaUpInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.gachaUpInfoListBuilder_.clear();
                }
                this.costItemId_ = 0;
                this.gachaPrefabPath_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GachaInfoOuterClass.internal_static_GachaInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GachaInfo getDefaultInstanceForType() {
                return GachaInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaInfo build() {
                GachaInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GachaInfo buildPartial() {
                GachaInfo result = new GachaInfo(this);
                int i = this.bitField0_;
                result.leftGachaTimes_ = this.leftGachaTimes_;
                result.gachaType_ = this.gachaType_;
                result.wishProgress_ = this.wishProgress_;
                result.gachaProbUrlOversea_ = this.gachaProbUrlOversea_;
                result.gachaRecordUrl_ = this.gachaRecordUrl_;
                result.gachaProbUrl_ = this.gachaProbUrl_;
                result.beginTime_ = this.beginTime_;
                result.scheduleId_ = this.scheduleId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.displayUp5ItemList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.displayUp5ItemList_ = this.displayUp5ItemList_;
                result.gachaTimesLimit_ = this.gachaTimesLimit_;
                result.gachaPreviewPrefabPath_ = this.gachaPreviewPrefabPath_;
                result.titleTextmap_ = this.titleTextmap_;
                result.curScheduleDailyGachaTimes_ = this.curScheduleDailyGachaTimes_;
                result.endTime_ = this.endTime_;
                if ((this.bitField0_ & 2) != 0) {
                    this.displayUp4ItemList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.displayUp4ItemList_ = this.displayUp4ItemList_;
                result.tenCostItemNum_ = this.tenCostItemNum_;
                result.wishMaxProgress_ = this.wishMaxProgress_;
                result.tenCostItemId_ = this.tenCostItemId_;
                result.gachaSortId_ = this.gachaSortId_;
                result.isNewWish_ = this.isNewWish_;
                result.costItemNum_ = this.costItemNum_;
                result.wishItemId_ = this.wishItemId_;
                result.gachaRecordUrlOversea_ = this.gachaRecordUrlOversea_;
                if (this.gachaUpInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.gachaUpInfoList_ = Collections.unmodifiableList(this.gachaUpInfoList_);
                        this.bitField0_ &= -5;
                    }
                    result.gachaUpInfoList_ = this.gachaUpInfoList_;
                } else {
                    result.gachaUpInfoList_ = this.gachaUpInfoListBuilder_.build();
                }
                result.costItemId_ = this.costItemId_;
                result.gachaPrefabPath_ = this.gachaPrefabPath_;
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
                if (other instanceof GachaInfo) {
                    return mergeFrom((GachaInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GachaInfo other) {
                if (other == GachaInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getLeftGachaTimes() != 0) {
                    setLeftGachaTimes(other.getLeftGachaTimes());
                }
                if (other.getGachaType() != 0) {
                    setGachaType(other.getGachaType());
                }
                if (other.getWishProgress() != 0) {
                    setWishProgress(other.getWishProgress());
                }
                if (!other.getGachaProbUrlOversea().isEmpty()) {
                    this.gachaProbUrlOversea_ = other.gachaProbUrlOversea_;
                    onChanged();
                }
                if (!other.getGachaRecordUrl().isEmpty()) {
                    this.gachaRecordUrl_ = other.gachaRecordUrl_;
                    onChanged();
                }
                if (!other.getGachaProbUrl().isEmpty()) {
                    this.gachaProbUrl_ = other.gachaProbUrl_;
                    onChanged();
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
                }
                if (!other.displayUp5ItemList_.isEmpty()) {
                    if (this.displayUp5ItemList_.isEmpty()) {
                        this.displayUp5ItemList_ = other.displayUp5ItemList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDisplayUp5ItemListIsMutable();
                        this.displayUp5ItemList_.addAll(other.displayUp5ItemList_);
                    }
                    onChanged();
                }
                if (other.getGachaTimesLimit() != 0) {
                    setGachaTimesLimit(other.getGachaTimesLimit());
                }
                if (!other.getGachaPreviewPrefabPath().isEmpty()) {
                    this.gachaPreviewPrefabPath_ = other.gachaPreviewPrefabPath_;
                    onChanged();
                }
                if (!other.getTitleTextmap().isEmpty()) {
                    this.titleTextmap_ = other.titleTextmap_;
                    onChanged();
                }
                if (other.getCurScheduleDailyGachaTimes() != 0) {
                    setCurScheduleDailyGachaTimes(other.getCurScheduleDailyGachaTimes());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (!other.displayUp4ItemList_.isEmpty()) {
                    if (this.displayUp4ItemList_.isEmpty()) {
                        this.displayUp4ItemList_ = other.displayUp4ItemList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureDisplayUp4ItemListIsMutable();
                        this.displayUp4ItemList_.addAll(other.displayUp4ItemList_);
                    }
                    onChanged();
                }
                if (other.getTenCostItemNum() != 0) {
                    setTenCostItemNum(other.getTenCostItemNum());
                }
                if (other.getWishMaxProgress() != 0) {
                    setWishMaxProgress(other.getWishMaxProgress());
                }
                if (other.getTenCostItemId() != 0) {
                    setTenCostItemId(other.getTenCostItemId());
                }
                if (other.getGachaSortId() != 0) {
                    setGachaSortId(other.getGachaSortId());
                }
                if (other.getIsNewWish()) {
                    setIsNewWish(other.getIsNewWish());
                }
                if (other.getCostItemNum() != 0) {
                    setCostItemNum(other.getCostItemNum());
                }
                if (other.getWishItemId() != 0) {
                    setWishItemId(other.getWishItemId());
                }
                if (!other.getGachaRecordUrlOversea().isEmpty()) {
                    this.gachaRecordUrlOversea_ = other.gachaRecordUrlOversea_;
                    onChanged();
                }
                if (this.gachaUpInfoListBuilder_ == null) {
                    if (!other.gachaUpInfoList_.isEmpty()) {
                        if (this.gachaUpInfoList_.isEmpty()) {
                            this.gachaUpInfoList_ = other.gachaUpInfoList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureGachaUpInfoListIsMutable();
                            this.gachaUpInfoList_.addAll(other.gachaUpInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.gachaUpInfoList_.isEmpty()) {
                    if (this.gachaUpInfoListBuilder_.isEmpty()) {
                        this.gachaUpInfoListBuilder_.dispose();
                        this.gachaUpInfoListBuilder_ = null;
                        this.gachaUpInfoList_ = other.gachaUpInfoList_;
                        this.bitField0_ &= -5;
                        this.gachaUpInfoListBuilder_ = GachaInfo.alwaysUseFieldBuilders ? getGachaUpInfoListFieldBuilder() : null;
                    } else {
                        this.gachaUpInfoListBuilder_.addAllMessages(other.gachaUpInfoList_);
                    }
                }
                if (other.getCostItemId() != 0) {
                    setCostItemId(other.getCostItemId());
                }
                if (!other.getGachaPrefabPath().isEmpty()) {
                    this.gachaPrefabPath_ = other.gachaPrefabPath_;
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
                GachaInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GachaInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GachaInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getLeftGachaTimes() {
                return this.leftGachaTimes_;
            }

            public Builder setLeftGachaTimes(int value) {
                this.leftGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftGachaTimes() {
                this.leftGachaTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaType() {
                return this.gachaType_;
            }

            public Builder setGachaType(int value) {
                this.gachaType_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaType() {
                this.gachaType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getWishProgress() {
                return this.wishProgress_;
            }

            public Builder setWishProgress(int value) {
                this.wishProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishProgress() {
                this.wishProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaProbUrlOversea() {
                Object ref = this.gachaProbUrlOversea_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaProbUrlOversea_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaProbUrlOverseaBytes() {
                Object ref = this.gachaProbUrlOversea_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaProbUrlOversea_ = b;
                return b;
            }

            public Builder setGachaProbUrlOversea(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaProbUrlOversea_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaProbUrlOversea() {
                this.gachaProbUrlOversea_ = GachaInfo.getDefaultInstance().getGachaProbUrlOversea();
                onChanged();
                return this;
            }

            public Builder setGachaProbUrlOverseaBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaProbUrlOversea_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaRecordUrl() {
                Object ref = this.gachaRecordUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaRecordUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaRecordUrlBytes() {
                Object ref = this.gachaRecordUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaRecordUrl_ = b;
                return b;
            }

            public Builder setGachaRecordUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaRecordUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaRecordUrl() {
                this.gachaRecordUrl_ = GachaInfo.getDefaultInstance().getGachaRecordUrl();
                onChanged();
                return this;
            }

            public Builder setGachaRecordUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaRecordUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaProbUrl() {
                Object ref = this.gachaProbUrl_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaProbUrl_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaProbUrlBytes() {
                Object ref = this.gachaProbUrl_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaProbUrl_ = b;
                return b;
            }

            public Builder setGachaProbUrl(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaProbUrl_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaProbUrl() {
                this.gachaProbUrl_ = GachaInfo.getDefaultInstance().getGachaProbUrl();
                onChanged();
                return this;
            }

            public Builder setGachaProbUrlBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaProbUrl_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getScheduleId() {
                return this.scheduleId_;
            }

            public Builder setScheduleId(int value) {
                this.scheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleId() {
                this.scheduleId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDisplayUp5ItemListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.displayUp5ItemList_ = GachaInfo.mutableCopy(this.displayUp5ItemList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<Integer> getDisplayUp5ItemListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.displayUp5ItemList_) : this.displayUp5ItemList_;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp5ItemListCount() {
                return this.displayUp5ItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp5ItemList(int index) {
                return this.displayUp5ItemList_.getInt(index);
            }

            public Builder setDisplayUp5ItemList(int index, int value) {
                ensureDisplayUp5ItemListIsMutable();
                this.displayUp5ItemList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDisplayUp5ItemList(int value) {
                ensureDisplayUp5ItemListIsMutable();
                this.displayUp5ItemList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDisplayUp5ItemList(Iterable<? extends Integer> values) {
                ensureDisplayUp5ItemListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.displayUp5ItemList_);
                onChanged();
                return this;
            }

            public Builder clearDisplayUp5ItemList() {
                this.displayUp5ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaTimesLimit() {
                return this.gachaTimesLimit_;
            }

            public Builder setGachaTimesLimit(int value) {
                this.gachaTimesLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaTimesLimit() {
                this.gachaTimesLimit_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaPreviewPrefabPath() {
                Object ref = this.gachaPreviewPrefabPath_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaPreviewPrefabPath_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaPreviewPrefabPathBytes() {
                Object ref = this.gachaPreviewPrefabPath_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaPreviewPrefabPath_ = b;
                return b;
            }

            public Builder setGachaPreviewPrefabPath(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaPreviewPrefabPath_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaPreviewPrefabPath() {
                this.gachaPreviewPrefabPath_ = GachaInfo.getDefaultInstance().getGachaPreviewPrefabPath();
                onChanged();
                return this;
            }

            public Builder setGachaPreviewPrefabPathBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaPreviewPrefabPath_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getTitleTextmap() {
                Object ref = this.titleTextmap_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.titleTextmap_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getTitleTextmapBytes() {
                Object ref = this.titleTextmap_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.titleTextmap_ = b;
                return b;
            }

            public Builder setTitleTextmap(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.titleTextmap_ = value;
                onChanged();
                return this;
            }

            public Builder clearTitleTextmap() {
                this.titleTextmap_ = GachaInfo.getDefaultInstance().getTitleTextmap();
                onChanged();
                return this;
            }

            public Builder setTitleTextmapBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.titleTextmap_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getCurScheduleDailyGachaTimes() {
                return this.curScheduleDailyGachaTimes_;
            }

            public Builder setCurScheduleDailyGachaTimes(int value) {
                this.curScheduleDailyGachaTimes_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurScheduleDailyGachaTimes() {
                this.curScheduleDailyGachaTimes_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureDisplayUp4ItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.displayUp4ItemList_ = GachaInfo.mutableCopy(this.displayUp4ItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<Integer> getDisplayUp4ItemListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.displayUp4ItemList_) : this.displayUp4ItemList_;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp4ItemListCount() {
                return this.displayUp4ItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getDisplayUp4ItemList(int index) {
                return this.displayUp4ItemList_.getInt(index);
            }

            public Builder setDisplayUp4ItemList(int index, int value) {
                ensureDisplayUp4ItemListIsMutable();
                this.displayUp4ItemList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDisplayUp4ItemList(int value) {
                ensureDisplayUp4ItemListIsMutable();
                this.displayUp4ItemList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDisplayUp4ItemList(Iterable<? extends Integer> values) {
                ensureDisplayUp4ItemListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.displayUp4ItemList_);
                onChanged();
                return this;
            }

            public Builder clearDisplayUp4ItemList() {
                this.displayUp4ItemList_ = GachaInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getTenCostItemNum() {
                return this.tenCostItemNum_;
            }

            public Builder setTenCostItemNum(int value) {
                this.tenCostItemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearTenCostItemNum() {
                this.tenCostItemNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getWishMaxProgress() {
                return this.wishMaxProgress_;
            }

            public Builder setWishMaxProgress(int value) {
                this.wishMaxProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishMaxProgress() {
                this.wishMaxProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getTenCostItemId() {
                return this.tenCostItemId_;
            }

            public Builder setTenCostItemId(int value) {
                this.tenCostItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTenCostItemId() {
                this.tenCostItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaSortId() {
                return this.gachaSortId_;
            }

            public Builder setGachaSortId(int value) {
                this.gachaSortId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaSortId() {
                this.gachaSortId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public boolean getIsNewWish() {
                return this.isNewWish_;
            }

            public Builder setIsNewWish(boolean value) {
                this.isNewWish_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsNewWish() {
                this.isNewWish_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getCostItemNum() {
                return this.costItemNum_;
            }

            public Builder setCostItemNum(int value) {
                this.costItemNum_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostItemNum() {
                this.costItemNum_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getWishItemId() {
                return this.wishItemId_;
            }

            public Builder setWishItemId(int value) {
                this.wishItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearWishItemId() {
                this.wishItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaRecordUrlOversea() {
                Object ref = this.gachaRecordUrlOversea_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaRecordUrlOversea_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaRecordUrlOverseaBytes() {
                Object ref = this.gachaRecordUrlOversea_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaRecordUrlOversea_ = b;
                return b;
            }

            public Builder setGachaRecordUrlOversea(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaRecordUrlOversea_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaRecordUrlOversea() {
                this.gachaRecordUrlOversea_ = GachaInfo.getDefaultInstance().getGachaRecordUrlOversea();
                onChanged();
                return this;
            }

            public Builder setGachaRecordUrlOverseaBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaRecordUrlOversea_ = value;
                onChanged();
                return this;
            }

            private void ensureGachaUpInfoListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.gachaUpInfoList_ = new ArrayList(this.gachaUpInfoList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<GachaUpInfoOuterClass.GachaUpInfo> getGachaUpInfoListList() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.gachaUpInfoList_);
                }
                return this.gachaUpInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getGachaUpInfoListCount() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return this.gachaUpInfoList_.size();
                }
                return this.gachaUpInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public GachaUpInfoOuterClass.GachaUpInfo getGachaUpInfoList(int index) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return this.gachaUpInfoList_.get(index);
                }
                return this.gachaUpInfoListBuilder_.getMessage(index);
            }

            public Builder setGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo value) {
                if (this.gachaUpInfoListBuilder_ != null) {
                    this.gachaUpInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo.Builder builderForValue) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addGachaUpInfoList(GachaUpInfoOuterClass.GachaUpInfo value) {
                if (this.gachaUpInfoListBuilder_ != null) {
                    this.gachaUpInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo value) {
                if (this.gachaUpInfoListBuilder_ != null) {
                    this.gachaUpInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addGachaUpInfoList(GachaUpInfoOuterClass.GachaUpInfo.Builder builderForValue) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addGachaUpInfoList(int index, GachaUpInfoOuterClass.GachaUpInfo.Builder builderForValue) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllGachaUpInfoList(Iterable<? extends GachaUpInfoOuterClass.GachaUpInfo> values) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.gachaUpInfoList_);
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearGachaUpInfoList() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    this.gachaUpInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeGachaUpInfoList(int index) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    ensureGachaUpInfoListIsMutable();
                    this.gachaUpInfoList_.remove(index);
                    onChanged();
                } else {
                    this.gachaUpInfoListBuilder_.remove(index);
                }
                return this;
            }

            public GachaUpInfoOuterClass.GachaUpInfo.Builder getGachaUpInfoListBuilder(int index) {
                return getGachaUpInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public GachaUpInfoOuterClass.GachaUpInfoOrBuilder getGachaUpInfoListOrBuilder(int index) {
                if (this.gachaUpInfoListBuilder_ == null) {
                    return this.gachaUpInfoList_.get(index);
                }
                return this.gachaUpInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public List<? extends GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListOrBuilderList() {
                if (this.gachaUpInfoListBuilder_ != null) {
                    return this.gachaUpInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.gachaUpInfoList_);
            }

            public GachaUpInfoOuterClass.GachaUpInfo.Builder addGachaUpInfoListBuilder() {
                return getGachaUpInfoListFieldBuilder().addBuilder(GachaUpInfoOuterClass.GachaUpInfo.getDefaultInstance());
            }

            public GachaUpInfoOuterClass.GachaUpInfo.Builder addGachaUpInfoListBuilder(int index) {
                return getGachaUpInfoListFieldBuilder().addBuilder(index, GachaUpInfoOuterClass.GachaUpInfo.getDefaultInstance());
            }

            public List<GachaUpInfoOuterClass.GachaUpInfo.Builder> getGachaUpInfoListBuilderList() {
                return getGachaUpInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<GachaUpInfoOuterClass.GachaUpInfo, GachaUpInfoOuterClass.GachaUpInfo.Builder, GachaUpInfoOuterClass.GachaUpInfoOrBuilder> getGachaUpInfoListFieldBuilder() {
                if (this.gachaUpInfoListBuilder_ == null) {
                    this.gachaUpInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.gachaUpInfoList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.gachaUpInfoList_ = null;
                }
                return this.gachaUpInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public int getCostItemId() {
                return this.costItemId_;
            }

            public Builder setCostItemId(int value) {
                this.costItemId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCostItemId() {
                this.costItemId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public String getGachaPrefabPath() {
                Object ref = this.gachaPrefabPath_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.gachaPrefabPath_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfoOrBuilder
            public ByteString getGachaPrefabPathBytes() {
                Object ref = this.gachaPrefabPath_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.gachaPrefabPath_ = b;
                return b;
            }

            public Builder setGachaPrefabPath(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.gachaPrefabPath_ = value;
                onChanged();
                return this;
            }

            public Builder clearGachaPrefabPath() {
                this.gachaPrefabPath_ = GachaInfo.getDefaultInstance().getGachaPrefabPath();
                onChanged();
                return this;
            }

            public Builder setGachaPrefabPathBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                GachaInfo.checkByteStringIsUtf8(value);
                this.gachaPrefabPath_ = value;
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

        public static GachaInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GachaInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GachaInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GachaInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GachaUpInfoOuterClass.getDescriptor();
    }
}
