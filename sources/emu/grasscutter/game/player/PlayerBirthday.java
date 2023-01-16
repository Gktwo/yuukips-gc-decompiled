package emu.grasscutter.game.player;

import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.BirthdayOuterClass;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/player/PlayerBirthday.class */
public class PlayerBirthday {
    private int day;
    private int month;

    public PlayerBirthday() {
        this.day = 0;
        this.month = 0;
    }

    public PlayerBirthday(int day, int month) {
        this.day = day;
        this.month = month;
    }

    public PlayerBirthday set(PlayerBirthday birth) {
        this.day = birth.day;
        this.month = birth.month;
        return this;
    }

    public PlayerBirthday set(int d, int m) {
        this.day = d;
        this.month = m;
        return this;
    }

    public PlayerBirthday setDay(int value) {
        this.day = value;
        return this;
    }

    public PlayerBirthday setMonth(int value) {
        this.month = value;
        return this;
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public BirthdayOuterClass.Birthday toProto() {
        return BirthdayOuterClass.Birthday.newBuilder().setDay(getDay()).setMonth(getMonth()).build();
    }

    public BirthdayOuterClass.Birthday.Builder getFilledProtoWhenNotEmpty() {
        if (getDay() > 0) {
            return BirthdayOuterClass.Birthday.newBuilder().setDay(getDay()).setMonth(getMonth());
        }
        return BirthdayOuterClass.Birthday.newBuilder();
    }
}
