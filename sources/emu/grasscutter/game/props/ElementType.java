package emu.grasscutter.game.props;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.utils.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ElementType.class */
public enum ElementType {
    None(0, FightProperty.FIGHT_PROP_CUR_FIRE_ENERGY, FightProperty.FIGHT_PROP_MAX_FIRE_ENERGY),
    Fire(1, FightProperty.FIGHT_PROP_CUR_FIRE_ENERGY, FightProperty.FIGHT_PROP_MAX_FIRE_ENERGY, RetcodeOuterClass.Retcode.RET_LANTERN_RITE_FIREWORKS_CONTENT_CLOSED_VALUE, "TeamResonance_Fire_Lv2", 1),
    Water(2, FightProperty.FIGHT_PROP_CUR_WATER_ENERGY, FightProperty.FIGHT_PROP_MAX_WATER_ENERGY, 10201, "TeamResonance_Water_Lv2", 2),
    Grass(3, FightProperty.FIGHT_PROP_CUR_GRASS_ENERGY, FightProperty.FIGHT_PROP_MAX_GRASS_ENERGY, 10501, "TeamResonance_Grass_Lv2", 7),
    Electric(4, FightProperty.FIGHT_PROP_CUR_ELEC_ENERGY, FightProperty.FIGHT_PROP_MAX_ELEC_ENERGY, RetcodeOuterClass.Retcode.RET_VINTAGE_VIRTUAL_COIN_NOT_ENOUGH_VALUE, "TeamResonance_Electric_Lv2", 6),
    Ice(5, FightProperty.FIGHT_PROP_CUR_ICE_ENERGY, FightProperty.FIGHT_PROP_MAX_ICE_ENERGY, 10601, "TeamResonance_Ice_Lv2", 4),
    Frozen(6, FightProperty.FIGHT_PROP_CUR_ICE_ENERGY, FightProperty.FIGHT_PROP_MAX_ICE_ENERGY),
    Wind(7, FightProperty.FIGHT_PROP_CUR_WIND_ENERGY, FightProperty.FIGHT_PROP_MAX_WIND_ENERGY, RetcodeOuterClass.Retcode.RET_IRODORI_CHESS_NOT_OPEN_VALUE, "TeamResonance_Wind_Lv2", 3),
    Rock(8, FightProperty.FIGHT_PROP_CUR_ROCK_ENERGY, FightProperty.FIGHT_PROP_MAX_ROCK_ENERGY, 10701, "TeamResonance_Rock_Lv2", 5),
    AntiFire(9, FightProperty.FIGHT_PROP_CUR_FIRE_ENERGY, FightProperty.FIGHT_PROP_MAX_FIRE_ENERGY),
    Default(255, FightProperty.FIGHT_PROP_CUR_FIRE_ENERGY, FightProperty.FIGHT_PROP_MAX_FIRE_ENERGY, 10801, "TeamResonance_AllDifferent");
    
    private final int value;
    private final int teamResonanceId;
    private final FightProperty curEnergyProp;
    private final FightProperty maxEnergyProp;
    private final int depotIndex;
    private final int configHash;
    private static final Int2ObjectMap<ElementType> map = new Int2ObjectOpenHashMap();
    private static final Map<String, ElementType> stringMap = new HashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    public int getValue() {
        return this.value;
    }

    public int getTeamResonanceId() {
        return this.teamResonanceId;
    }

    public FightProperty getCurEnergyProp() {
        return this.curEnergyProp;
    }

    public FightProperty getMaxEnergyProp() {
        return this.maxEnergyProp;
    }

    public int getDepotIndex() {
        return this.depotIndex;
    }

    public int getConfigHash() {
        return this.configHash;
    }

    ElementType(int value, FightProperty curEnergyProp, FightProperty maxEnergyProp) {
        this(value, curEnergyProp, maxEnergyProp, 0, null, 1);
    }

    ElementType(int value, FightProperty curEnergyProp, FightProperty maxEnergyProp, int teamResonanceId, String configName) {
        this(value, curEnergyProp, maxEnergyProp, teamResonanceId, configName, 1);
    }

    ElementType(int value, FightProperty curEnergyProp, FightProperty maxEnergyProp, int teamResonanceId, String configName, int depotIndex) {
        this.value = value;
        this.curEnergyProp = curEnergyProp;
        this.maxEnergyProp = maxEnergyProp;
        this.teamResonanceId = teamResonanceId;
        this.depotIndex = depotIndex;
        if (configName != null) {
            this.configHash = Utils.abilityHash(configName);
        } else {
            this.configHash = 0;
        }
    }

    public static ElementType getTypeByValue(int value) {
        return map.getOrDefault(value, (int) None);
    }

    public static ElementType getTypeByName(String name) {
        return stringMap.getOrDefault(name, None);
    }
}
