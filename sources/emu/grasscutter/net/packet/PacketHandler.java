package emu.grasscutter.net.packet;

import emu.grasscutter.server.game.GameSession;

/* loaded from: grasscutter.jar:emu/grasscutter/net/packet/PacketHandler.class */
public abstract class PacketHandler {
    protected static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    public abstract void handle(GameSession gameSession, byte[] bArr, byte[] bArr2) throws Exception;
}
