package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CookRecipeDataNotifyOuterClass;
import emu.grasscutter.net.proto.CookRecipeDataOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCookRecipeDataNotify.class */
public class PacketCookRecipeDataNotify extends BasePacket {
    public PacketCookRecipeDataNotify(CookRecipeDataOuterClass.CookRecipeData recipe) {
        super(110);
        setData(CookRecipeDataNotifyOuterClass.CookRecipeDataNotify.newBuilder().setRecipeData(recipe).build());
    }

    public PacketCookRecipeDataNotify(int recipeId) {
        super(110);
        setData(CookRecipeDataNotifyOuterClass.CookRecipeDataNotify.newBuilder().setRecipeData(CookRecipeDataOuterClass.CookRecipeData.newBuilder().setRecipeId(recipeId)).build());
    }
}
