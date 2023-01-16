package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CookRecipeDataOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.PlayerCookRspOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerCookRsp.class */
public class PacketPlayerCookRsp extends BasePacket {
    public PacketPlayerCookRsp(RetcodeOuterClass.Retcode retcode) {
        super(194);
        setData(PlayerCookRspOuterClass.PlayerCookRsp.newBuilder().setRetcode(retcode.getNumber()).build());
    }

    public PacketPlayerCookRsp(List<GameItem> output, int quality, int count, int recipeId, int proficiency) {
        super(194);
        PlayerCookRspOuterClass.PlayerCookRsp.Builder proto = PlayerCookRspOuterClass.PlayerCookRsp.newBuilder().setRecipeData(CookRecipeDataOuterClass.CookRecipeData.newBuilder().setRecipeId(recipeId).setProficiency(proficiency)).setQteQuality(quality).setCookCount(count);
        for (GameItem item : output) {
            proto.addItemList(ItemParamOuterClass.ItemParam.newBuilder().setItemId(item.getItemId()).setCount(item.getCount()));
        }
        setData(proto);
    }
}
