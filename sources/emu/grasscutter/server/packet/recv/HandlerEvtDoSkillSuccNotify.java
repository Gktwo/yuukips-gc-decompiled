package emu.grasscutter.server.packet.recv;

import emu.grasscutter.command.commands.Equip;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EvtDoSkillSuccNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.EvtDoSkillSuccNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEvtDoSkillSuccNotify.class */
public class HandlerEvtDoSkillSuccNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotify notify = EvtDoSkillSuccNotifyOuterClass.EvtDoSkillSuccNotify.parseFrom(payload);
        Player player = session.getPlayer();
        int skillId = notify.getSkillId();
        int casterId = notify.getCasterId();
        player.getAbilityManager().onSkillStart(session.getPlayer(), skillId, casterId);
        player.getStaminaManager().handleEvtDoSkillSuccNotify(session, skillId, casterId);
        player.getEnergyManager().handleEvtDoSkillSuccNotify(session, skillId, casterId);
        player.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_SKILL, skillId);
        Equip.addAttack(session, skillId);
    }
}
