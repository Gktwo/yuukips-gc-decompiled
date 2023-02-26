package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.player.PlayerBuffManager;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketServerBuffChangeNotify.class */
public class PacketServerBuffChangeNotify extends BasePacket {
    public PacketServerBuffChangeNotify(Player player, ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType changeType, PlayerBuffManager.PlayerBuff buff) {
        this(player, changeType, Stream.of(buff));
    }

    public PacketServerBuffChangeNotify(Player player, ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType changeType, Collection<PlayerBuffManager.PlayerBuff> buffs) {
        this(player, changeType, buffs.stream());
    }

    public PacketServerBuffChangeNotify(Player player, ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType changeType, Stream<PlayerBuffManager.PlayerBuff> buffs) {
        super(315);
        ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.Builder proto = ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.newBuilder();
        LongStream mapToLong = player.getTeamManager().getActiveTeam().stream().mapToLong(entity -> {
            return entity.getAvatar().getGuid();
        });
        Objects.requireNonNull(proto);
        mapToLong.forEach(this::addAvatarGuidList);
        proto.setServerBuffChangeType(changeType);
        Stream<R> map = buffs.map((v0) -> {
            return v0.toProto();
        });
        Objects.requireNonNull(proto);
        map.forEach(this::addServerBuffList);
        setData(proto);
    }
}
