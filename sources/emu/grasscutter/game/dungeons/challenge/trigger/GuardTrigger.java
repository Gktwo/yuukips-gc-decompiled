package emu.grasscutter.game.dungeons.challenge.trigger;

import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.server.packet.send.PacketChallengeDataNotify;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/trigger/GuardTrigger.class */
public class GuardTrigger extends KillMonsterTrigger {
    @Override // emu.grasscutter.game.dungeons.challenge.trigger.KillMonsterTrigger, emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger
    public void onBegin(WorldChallenge challenge) {
        onBegin(challenge);
        challenge.getScene().broadcastPacket(new PacketChallengeDataNotify(challenge, 2, 100));
    }

    @Override // emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger
    public void onGadgetDamage(WorldChallenge challenge, EntityGadget gadget) {
        int percent = (int) (gadget.getFightProperties().get(FightProperty.FIGHT_PROP_CUR_HP.getId()) / gadget.getFightProperties().get(FightProperty.FIGHT_PROP_BASE_HP.getId()));
        challenge.getScene().broadcastPacket(new PacketChallengeDataNotify(challenge, 2, percent));
        if (percent <= 0) {
            challenge.fail();
        }
    }
}
