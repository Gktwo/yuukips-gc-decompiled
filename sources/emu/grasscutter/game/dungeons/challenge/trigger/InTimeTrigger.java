package emu.grasscutter.game.dungeons.challenge.trigger;

import emu.grasscutter.game.dungeons.challenge.WorldChallenge;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/challenge/trigger/InTimeTrigger.class */
public class InTimeTrigger extends ChallengeTrigger {
    @Override // emu.grasscutter.game.dungeons.challenge.trigger.ChallengeTrigger
    public void onCheckTimeout(WorldChallenge challenge) {
        if (System.currentTimeMillis() - challenge.getStartedAt() > ((long) challenge.getTimeLimit()) * 1000) {
            challenge.fail();
        }
    }
}
