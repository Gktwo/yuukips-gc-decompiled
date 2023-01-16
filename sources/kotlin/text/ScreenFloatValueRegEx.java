package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: StringNumberConversionsJVM.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\bÂ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0005"}, m373d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/text/ScreenFloatValueRegEx.class */
final class ScreenFloatValueRegEx {
    @NotNull
    public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
    @JvmField
    @NotNull
    public static final Regex value;

    private ScreenFloatValueRegEx() {
    }

    static {
        ScreenFloatValueRegEx screenFloatValueRegEx = INSTANCE;
        String Exp = "[eE][+-]?(\\p{Digit}+)";
        value = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + Exp + ")?)|(\\.((\\p{Digit}+))(" + Exp + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
