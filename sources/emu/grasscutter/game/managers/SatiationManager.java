package emu.grasscutter.game.managers;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketAvatarPropNotify;
import emu.grasscutter.server.packet.send.PacketAvatarSatiationDataNotify;
import emu.grasscutter.server.packet.send.PacketPlayerGameTimeNotify;
import emu.grasscutter.server.packet.send.PacketPlayerTimeNotify;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/SatiationManager.class */
public class SatiationManager extends BasePlayerManager {
    public SatiationManager(Player player) {
        super(player);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r0v40, types: [long] */
    /* JADX WARN: Type inference failed for: r19v2 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r19v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean addSatiation(emu.grasscutter.game.avatar.Avatar r9, float r10, int r11) {
        /*
            r8 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r12 = r0
            r0 = r10
            r1 = 1120403456(0x42c80000, float:100.0)
            float r0 = r0 * r1
            int r0 = java.lang.Math.round(r0)
            r13 = r0
            r0 = r10
            r1 = 1120403456(0x42c80000, float:100.0)
            float r0 = r0 * r1
            r1 = r9
            int r1 = r1.getSatiation()
            float r1 = (float) r1
            float r0 = r0 + r1
            r14 = r0
            r0 = r8
            r0.updateTime()
            r0 = r8
            emu.grasscutter.game.player.Player r0 = r0.player
            int r0 = r0.getClientTime()
            r1 = 1000(0x3e8, float:1.401E-42)
            int r0 = r0 / r1
            r15 = r0
            r0 = r15
            float r0 = (float) r0
            r1 = r14
            r2 = 1106247680(0x41f00000, float:30.0)
            float r1 = r1 / r2
            float r0 = r0 + r1
            r16 = r0
            r0 = r15
            long r0 = (long) r0
            r17 = r0
            r0 = r9
            int r0 = r0.getSatiationPenalty()
            long r0 = (long) r0
            r19 = r0
            r0 = r14
            r1 = r9
            int r1 = r1.getSatiation()
            float r1 = (float) r1
            float r0 = r0 + r1
            r1 = 1176256512(0x461c4000, float:10000.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x0068
            r0 = r19
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0068
            r0 = r17
            r1 = 30
            long r0 = r0 + r1
            r17 = r0
            r0 = 3000(0xbb8, double:1.482E-320)
            r19 = r0
        L_0x0068:
            r0 = r8
            r1 = r9
            r2 = r13
            boolean r0 = r0.addSatiationDirectly(r1, r2)
            if (r0 != 0) goto L_0x0074
            r0 = 0
            return r0
        L_0x0074:
            r0 = r12
            emu.grasscutter.game.props.PlayerProperty r1 = emu.grasscutter.game.props.PlayerProperty.PROP_SATIATION_VAL
            int r1 = r1.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r13
            long r2 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r12
            emu.grasscutter.game.props.PlayerProperty r1 = emu.grasscutter.game.props.PlayerProperty.PROP_SATIATION_PENALTY_TIME
            int r1 = r1.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r19
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r8
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.server.game.GameSession r0 = r0.getSession()
            emu.grasscutter.server.packet.send.PacketAvatarPropNotify r1 = new emu.grasscutter.server.packet.send.PacketAvatarPropNotify
            r2 = r1
            r3 = r9
            r4 = r12
            r2.<init>(r3, r4)
            r0.send(r1)
            r0 = r8
            emu.grasscutter.game.player.Player r0 = r0.player
            emu.grasscutter.server.game.GameSession r0 = r0.getSession()
            emu.grasscutter.server.packet.send.PacketAvatarSatiationDataNotify r1 = new emu.grasscutter.server.packet.send.PacketAvatarSatiationDataNotify
            r2 = r1
            r3 = r9
            r4 = r16
            r5 = r17
            r2.<init>(r3, r4, r5)
            r0.send(r1)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.managers.SatiationManager.addSatiation(emu.grasscutter.game.avatar.Avatar, float, int):boolean");
    }

    public synchronized boolean addSatiationDirectly(Avatar avatar, int value) {
        if (!avatar.addSatiation(value)) {
            return false;
        }
        avatar.save();
        return true;
    }

    public synchronized void removeSatiationDirectly(Avatar avatar, int value) {
        avatar.reduceSatiation(value);
        avatar.reduceSatiationPenalty(3000);
        avatar.save();
        updateSingleAvatar(avatar, 0.0f);
    }

    public synchronized void reduceSatiation() {
        this.player.getAvatars().forEach(avatar -> {
            if (avatar.getSatiationPenalty() > 0 && avatar.getSatiation() == 0) {
                avatar.reduceSatiationPenalty(3000);
            }
            if (avatar.getSatiation() <= 0) {
                return;
            }
            if (avatar.getSatiationPenalty() > 0) {
                avatar.reduceSatiationPenalty(100);
                return;
            }
            avatar.reduceSatiation(30);
            addSatiation(avatar, 0.0f, 0);
        });
    }

    public synchronized void updateSingleAvatar(Avatar avatar, float givenTime) {
        float time = ((float) (this.player.getClientTime() / 1000)) + givenTime;
        this.player.getSession().send(new PacketAvatarPropNotify(avatar));
        this.player.getSession().send(new PacketAvatarSatiationDataNotify(time, avatar));
    }

    private void updateTime() {
        this.player.getSession().send(new PacketPlayerGameTimeNotify(this.player));
        this.player.getSession().send(new PacketPlayerTimeNotify(this.player));
    }
}
