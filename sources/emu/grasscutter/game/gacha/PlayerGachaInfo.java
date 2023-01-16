package emu.grasscutter.game.gacha;

import dev.morphia.annotations.Entity;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/gacha/PlayerGachaInfo.class */
public class PlayerGachaInfo {
    private PlayerGachaBannerInfo standardBanner = new PlayerGachaBannerInfo();
    private PlayerGachaBannerInfo eventCharacterBanner = new PlayerGachaBannerInfo();
    private PlayerGachaBannerInfo eventWeaponBanner = new PlayerGachaBannerInfo();

    public PlayerGachaBannerInfo getStandardBanner() {
        return this.standardBanner;
    }

    public PlayerGachaBannerInfo getEventCharacterBanner() {
        return this.eventCharacterBanner;
    }

    public PlayerGachaBannerInfo getEventWeaponBanner() {
        return this.eventWeaponBanner;
    }

    public PlayerGachaBannerInfo getBannerInfo(GachaBanner banner) {
        if (banner == null) {
            return this.standardBanner;
        }
        switch (banner.getBannerType()) {
            case EVENT:
                return this.eventCharacterBanner;
            case WEAPON:
                return this.eventWeaponBanner;
            case STANDARD:
            default:
                return this.standardBanner;
        }
    }
}
