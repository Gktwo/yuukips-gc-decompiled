package org.jline.terminal;

import java.util.EnumSet;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/MouseEvent.class */
public class MouseEvent {
    private final Type type;
    private final Button button;
    private final EnumSet<Modifier> modifiers;

    /* renamed from: x */
    private final int f3200x;

    /* renamed from: y */
    private final int f3201y;

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/MouseEvent$Button.class */
    public enum Button {
        NoButton,
        Button1,
        Button2,
        Button3,
        WheelUp,
        WheelDown
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/MouseEvent$Modifier.class */
    public enum Modifier {
        Shift,
        Alt,
        Control
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/terminal/MouseEvent$Type.class */
    public enum Type {
        Released,
        Pressed,
        Wheel,
        Moved,
        Dragged
    }

    public MouseEvent(Type type, Button button, EnumSet<Modifier> modifiers, int x, int y) {
        this.type = type;
        this.button = button;
        this.modifiers = modifiers;
        this.f3200x = x;
        this.f3201y = y;
    }

    public Type getType() {
        return this.type;
    }

    public Button getButton() {
        return this.button;
    }

    public EnumSet<Modifier> getModifiers() {
        return this.modifiers;
    }

    public int getX() {
        return this.f3200x;
    }

    public int getY() {
        return this.f3201y;
    }

    public String toString() {
        return "MouseEvent[type=" + this.type + ", button=" + this.button + ", modifiers=" + this.modifiers + ", x=" + this.f3200x + ", y=" + this.f3201y + ']';
    }
}
