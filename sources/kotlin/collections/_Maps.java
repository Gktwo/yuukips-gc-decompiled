package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.HidesMembers;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;

@Metadata(m371mv = {1, 6, 0}, m372k = 5, m369xi = 49, m374d1 = {"��\u0001\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n��\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010��\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\u001aJ\u0010��\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\bø\u0001��\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\b\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\bø\u0001��\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\b\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\bø\u0001��\u001a[\u0010\u000f\u001a\u0002H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010\u0013\u001a]\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010\u0013\u001a\\\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\bø\u0001��\u001aa\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\bø\u0001��¢\u0006\u0002\b\u0017\u001au\u0010\u0018\u001a\u0002H\u0019\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b��\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\u0006H\bø\u0001��¢\u0006\u0002\u0010\u001c\u001aw\u0010\u0018\u001a\u0002H\u0019\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b��\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f0\u0006H\bø\u0001��¢\u0006\u0004\b\u001d\u0010\u001c\u001aJ\u0010\u001e\u001a\u00020\u001f\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\bø\u0001��\u001aV\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��\u001a\\\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\bø\u0001��\u001au\u0010#\u001a\u0002H\u0019\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0010*\u00020\u0011\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b��\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010\u001c\u001ao\u0010$\u001a\u0002H\u0019\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010\"\u0010\b\u0003\u0010\u0019*\n\u0012\u0006\b��\u0012\u0002H\u00100\u001a*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u001b\u001a\u0002H\u00192\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010\u001c\u001ah\u0010%\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��\u001ah\u0010(\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��\u001a_\u0010)\u001a\u0002H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010*\u001aJ\u0010)\u001a\u00020+\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\bø\u0001��\u001aJ\u0010)\u001a\u00020,\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\bø\u0001��\u001aa\u0010-\u001a\u0004\u0018\u0001H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010*\u001aQ\u0010-\u001a\u0004\u0018\u00010+\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\bø\u0001��¢\u0006\u0002\u0010.\u001aQ\u0010-\u001a\u0004\u0018\u00010,\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\bø\u0001��¢\u0006\u0002\u0010/\u001aq\u00100\u001a\u0002H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u001002j\n\u0012\u0006\b��\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u00104\u001as\u00105\u001a\u0004\u0018\u0001H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u001002j\n\u0012\u0006\b��\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u00104\u001ai\u00106\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\b\u001ai\u00107\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\b\u001ah\u00108\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��\u001ah\u00109\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��\u001a_\u0010:\u001a\u0002H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010*\u001aJ\u0010:\u001a\u00020+\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\bø\u0001��\u001aJ\u0010:\u001a\u00020,\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\bø\u0001��\u001aa\u0010;\u001a\u0004\u0018\u0001H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100&*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u0010*\u001aQ\u0010;\u001a\u0004\u0018\u00010+\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020+0\u0006H\bø\u0001��¢\u0006\u0002\u0010.\u001aQ\u0010;\u001a\u0004\u0018\u00010,\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020,0\u0006H\bø\u0001��¢\u0006\u0002\u0010/\u001aq\u0010<\u001a\u0002H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u001002j\n\u0012\u0006\b��\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u00104\u001as\u0010=\u001a\u0004\u0018\u0001H\u0010\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u00101\u001a\u0016\u0012\u0006\b��\u0012\u0002H\u001002j\n\u0012\u0006\b��\u0012\u0002H\u0010`32\u001e\u0010'\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00100\u0006H\bø\u0001��¢\u0006\u0002\u00104\u001ah\u0010>\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\u0007\u001ai\u0010?\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u00101\u001a.\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000702j\u0016\u0012\u0012\b��\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`3H\b\u001a$\u0010@\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010@\u001a\u00020\u0001\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\bø\u0001��\u001aY\u0010A\u001a\u0002HB\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HB2\u001e\u0010 \u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0\u0006H\bø\u0001��¢\u0006\u0002\u0010C\u001an\u0010D\u001a\u0002HB\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010B*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002HB23\u0010 \u001a/\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bF\u0012\b\bG\u0012\u0004\b\b(H\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001f0EH\bø\u0001��¢\u0006\u0002\u0010I\u001a6\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030K0\u0016\"\u0004\b��\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0002\u0007\n\u0005\b20\u0001¨\u0006L"}, m373d2 = {Printer.ALL, "", "K", "V", "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "firstNotNullOf", "R", "", "transform", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullOfOrNull", "flatMap", "", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrNull", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, m368xs = "kotlin/collections/MapsKt")
/* renamed from: kotlin.collections.MapsKt___MapsKt */
/* loaded from: grasscutter.jar:kotlin/collections/MapsKt___MapsKt.class */
class _Maps extends Maps {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R firstNotNullOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        R r;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                r = null;
                break;
            }
            r = (R) function1.invoke(it.next());
            if (r != null) {
                break;
            }
        }
        if (r != null) {
            return r;
        }
        throw new NoSuchElementException("No element of the map was transformed to a non-null value.");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <K, V, R> R firstNotNullOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            R r = (R) function1.invoke(it.next());
            if (r != null) {
                return r;
            }
        }
        return null;
    }

    @NotNull
    public static final <K, V> List<Pair<K, V>> toList(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.size() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterator iterator = map.entrySet().iterator();
        if (!iterator.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Map.Entry<? extends K, ? extends V> first = iterator.next();
        if (!iterator.hasNext()) {
            return CollectionsKt.listOf(new Pair(first.getKey(), first.getValue()));
        }
        ArrayList result = new ArrayList(map.size());
        result.add(new Pair(first.getKey(), first.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next = iterator.next();
            result.add(new Pair(next.getKey(), next.getValue()));
        } while (iterator.hasNext());
        return result;
    }

    @NotNull
    public static final <K, V, R> List<R> flatMap(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(destination$iv, (Iterable) function1.invoke(it.next()));
        }
        return (List) destination$iv;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequence")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <K, V, R> List<R> flatMapSequence(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(destination$iv, (Sequence) function1.invoke(it.next()));
        }
        return (List) destination$iv;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(@NotNull Map<? extends K, ? extends V> map, @NotNull C c, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(c, (Iterable) function1.invoke(it.next()));
        }
        return c;
    }

    @SinceKotlin(version = "1.4")
    @JvmName(name = "flatMapSequenceTo")
    @NotNull
    @OverloadResolutionByLambdaReturnType
    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(@NotNull Map<? extends K, ? extends V> map, @NotNull C c, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(c, (Sequence) function1.invoke(it.next()));
        }
        return c;
    }

    @NotNull
    public static final <K, V, R> List<R> map(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList(map.size());
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            destination$iv.add(function1.invoke(it.next()));
        }
        return (List) destination$iv;
    }

    @NotNull
    public static final <K, V, R> List<R> mapNotNull(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Collection destination$iv = new ArrayList();
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object it$iv = function1.invoke(it.next());
            if (it$iv != null) {
                destination$iv.add(it$iv);
            }
        }
        return (List) destination$iv;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(@NotNull Map<? extends K, ? extends V> map, @NotNull C c, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object it2 = function1.invoke(it.next());
            if (it2 != null) {
                c.add(it2);
            }
        }
        return c;
    }

    @NotNull
    public static final <K, V, R, C extends Collection<? super R>> C mapTo(@NotNull Map<? extends K, ? extends V> map, @NotNull C c, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        Intrinsics.checkNotNullParameter(function1, "transform");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            c.add(function1.invoke(it.next()));
        }
        return c;
    }

    public static final <K, V> boolean all(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (!function1.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean any(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return !map.isEmpty();
    }

    public static final <K, V> boolean any(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return false;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @InlineOnly
    private static final <K, V> int count(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.size();
    }

    public static final <K, V> int count(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return 0;
        }
        int count = 0;
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                count++;
            }
        }
        return count;
    }

    @HidesMembers
    public static final <K, V> void forEach(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r7v0. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4", errorSince = "1.5", hiddenSince = "1.6")
    @InlineOnly
    private static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object obj3 = (Object) it.next();
            if (!it.hasNext()) {
                obj = obj3;
            } else {
                Comparable comparable = (Comparable) function1.invoke(obj3);
                Object obj4 = obj3;
                do {
                    Object obj5 = (Object) it.next();
                    Comparable comparable2 = (Comparable) function1.invoke(obj5);
                    obj2 = obj4;
                    if (comparable.compareTo(comparable2) < 0) {
                        comparable = comparable2;
                        obj2 = (Object) obj5;
                    }
                    obj4 = obj2;
                } while (it.hasNext());
                obj = obj2;
            }
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r0v20. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator$iv = map.entrySet().iterator();
        if (!iterator$iv.hasNext()) {
            obj = null;
        } else {
            Object maxElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                obj = maxElem$iv;
            } else {
                Comparable maxValue$iv = (Comparable) function1.invoke(maxElem$iv);
                do {
                    Object e$iv = (Object) iterator$iv.next();
                    Comparable v$iv = (Comparable) function1.invoke(e$iv);
                    if (maxValue$iv.compareTo(v$iv) < 0) {
                        maxElem$iv = e$iv;
                        maxValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
                obj = maxElem$iv;
            }
        }
        return (Map.Entry) obj;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return doubleValue;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: maxOf  reason: collision with other method in class */
    private static final <K, V> float m7509maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.OverloadResolutionByLambdaReturnType
    @kotlin.internal.InlineOnly
    /* renamed from: maxOf  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <K, V, R extends java.lang.Comparable<? super R>> R m7510maxOf(java.util.Map<? extends K, ? extends V> r3, kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        /*
            r0 = r3
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r4
            java.lang.String r1 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r3
            java.util.Set r0 = r0.entrySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x002c
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x002c:
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r6 = r0
        L_0x003c:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0067
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r7 = r0
            r0 = r6
            r1 = r7
            int r0 = r0.compareTo(r1)
            if (r0 >= 0) goto L_0x003c
            r0 = r7
            r6 = r0
            goto L_0x003c
        L_0x0067:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections._Maps.m7510maxOf(java.util.Map, kotlin.jvm.functions.Function1):java.lang.Comparable");
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Double maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.max(doubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: maxOfOrNull  reason: collision with other method in class */
    private static final <K, V> Float m7511maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.max(floatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.OverloadResolutionByLambdaReturnType
    @kotlin.internal.InlineOnly
    /* renamed from: maxOfOrNull  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <K, V, R extends java.lang.Comparable<? super R>> R m7512maxOfOrNull(java.util.Map<? extends K, ? extends V> r3, kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        /*
            r0 = r3
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r4
            java.lang.String r1 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r3
            java.util.Set r0 = r0.entrySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0064
        L_0x0028:
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r6 = r0
        L_0x0038:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0063
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r7 = r0
            r0 = r6
            r1 = r7
            int r0 = r0.compareTo(r1)
            if (r0 >= 0) goto L_0x0038
            r0 = r7
            r6 = r0
            goto L_0x0038
        L_0x0063:
            r0 = r6
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections._Maps.m7512maxOfOrNull(java.util.Map, kotlin.jvm.functions.Function1):java.lang.Comparable");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0041 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v0. Raw type applied. Possible types: ? super R */
    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v5. Raw type applied. Possible types: java.lang.Object, ? super R */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (Object) function1.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (Object) function1.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (Object) obj2;
            }
        }
        return (R) obj;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x003d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v0. Raw type applied. Possible types: ? super R */
    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v5. Raw type applied. Possible types: java.lang.Object, ? super R */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (Object) function1.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (Object) function1.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) < 0) {
                obj = (Object) obj2;
            }
        }
        return (R) obj;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4", errorSince = "1.5", hiddenSince = "1.6")
    @InlineOnly
    private static final /* synthetic */ <K, V> Map.Entry<K, V> maxWith(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.maxWithOrNull(map.entrySet(), comparator);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.maxWithOrNull(map.entrySet(), comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r8v0. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4", errorSince = "1.5", hiddenSince = "1.6")
    public static final /* synthetic */ <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object obj3 = (Object) it.next();
            if (!it.hasNext()) {
                obj = obj3;
            } else {
                Comparable comparable = (Comparable) function1.invoke(obj3);
                Object obj4 = obj3;
                do {
                    Object obj5 = (Object) it.next();
                    Comparable comparable2 = (Comparable) function1.invoke(obj5);
                    obj2 = obj4;
                    if (comparable.compareTo(comparable2) > 0) {
                        comparable = comparable2;
                        obj2 = (Object) obj5;
                    }
                    obj4 = obj2;
                } while (it.hasNext());
                obj = obj2;
            }
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v7. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r0v20. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator iterator$iv = map.entrySet().iterator();
        if (!iterator$iv.hasNext()) {
            obj = null;
        } else {
            Object minElem$iv = iterator$iv.next();
            if (!iterator$iv.hasNext()) {
                obj = minElem$iv;
            } else {
                Comparable minValue$iv = (Comparable) function1.invoke(minElem$iv);
                do {
                    Object e$iv = (Object) iterator$iv.next();
                    Comparable v$iv = (Comparable) function1.invoke(e$iv);
                    if (minValue$iv.compareTo(v$iv) > 0) {
                        minElem$iv = e$iv;
                        minValue$iv = v$iv;
                    }
                } while (iterator$iv.hasNext());
                obj = minElem$iv;
            }
        }
        return (Map.Entry) obj;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> double minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        double doubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return doubleValue;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: minOf  reason: collision with other method in class */
    private static final <K, V> float m7513minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        float floatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return floatValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.OverloadResolutionByLambdaReturnType
    @kotlin.internal.InlineOnly
    /* renamed from: minOf  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <K, V, R extends java.lang.Comparable<? super R>> R m7514minOf(java.util.Map<? extends K, ? extends V> r3, kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        /*
            r0 = r3
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r4
            java.lang.String r1 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r3
            java.util.Set r0 = r0.entrySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x002c
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x002c:
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r6 = r0
        L_0x003c:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0067
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r7 = r0
            r0 = r6
            r1 = r7
            int r0 = r0.compareTo(r1)
            if (r0 <= 0) goto L_0x003c
            r0 = r7
            r6 = r0
            goto L_0x003c
        L_0x0067:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections._Maps.m7514minOf(java.util.Map, kotlin.jvm.functions.Function1):java.lang.Comparable");
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V> Double minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        double doubleValue = function1.invoke((Object) it.next()).doubleValue();
        while (it.hasNext()) {
            doubleValue = Math.min(doubleValue, function1.invoke((Object) it.next()).doubleValue());
        }
        return Double.valueOf(doubleValue);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* renamed from: minOfOrNull  reason: collision with other method in class */
    private static final <K, V> Float m7515minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator<T> it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        float floatValue = function1.invoke((Object) it.next()).floatValue();
        while (it.hasNext()) {
            floatValue = Math.min(floatValue, function1.invoke((Object) it.next()).floatValue());
        }
        return Float.valueOf(floatValue);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v5. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Comparable, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.OverloadResolutionByLambdaReturnType
    @kotlin.internal.InlineOnly
    /* renamed from: minOfOrNull  reason: collision with other method in class */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <K, V, R extends java.lang.Comparable<? super R>> R m7516minOfOrNull(java.util.Map<? extends K, ? extends V> r3, kotlin.jvm.functions.Function1<? super java.util.Map.Entry<? extends K, ? extends V>, ? extends R> r4) {
        /*
            r0 = r3
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r4
            java.lang.String r1 = "selector"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r3
            java.util.Set r0 = r0.entrySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            r5 = r0
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x0028
            r0 = 0
            goto L_0x0064
        L_0x0028:
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r6 = r0
        L_0x0038:
            r0 = r5
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0063
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.next()
            java.lang.Object r0 = r0.invoke(r1)
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r7 = r0
            r0 = r6
            r1 = r7
            int r0 = r0.compareTo(r1)
            if (r0 <= 0) goto L_0x0038
            r0 = r7
            r6 = r0
            goto L_0x0038
        L_0x0063:
            r0 = r6
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections._Maps.m7516minOfOrNull(java.util.Map, kotlin.jvm.functions.Function1):java.lang.Comparable");
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0041 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:17:0x0041 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v0. Raw type applied. Possible types: ? super R */
    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v5. Raw type applied. Possible types: java.lang.Object, ? super R */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = (Object) function1.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (Object) function1.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (Object) obj2;
            }
        }
        return (R) obj;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x003d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x003d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: java.util.Iterator<T>, java.util.Iterator */
    /* JADX DEBUG: Type inference failed for r1v4. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v0. Raw type applied. Possible types: ? super R */
    /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: ? super java.util.Map$Entry<? extends K, ? extends V> */
    /* JADX DEBUG: Type inference failed for r8v5. Raw type applied. Possible types: java.lang.Object, ? super R */
    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        Intrinsics.checkNotNullParameter(function1, "selector");
        Iterator it = map.entrySet().iterator();
        if (!it.hasNext()) {
            return null;
        }
        Object obj = (Object) function1.invoke((Object) it.next());
        while (it.hasNext()) {
            Object obj2 = (Object) function1.invoke((Object) it.next());
            if (comparator.compare(obj, obj2) > 0) {
                obj = (Object) obj2;
            }
        }
        return (R) obj;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.4", errorSince = "1.5", hiddenSince = "1.6")
    public static final /* synthetic */ Map.Entry minWith(Map $this$minWith, Comparator comparator) {
        Intrinsics.checkNotNullParameter($this$minWith, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.minWithOrNull($this$minWith.entrySet(), comparator);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.minWithOrNull(map.entrySet(), comparator);
    }

    public static final <K, V> boolean none(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.isEmpty();
    }

    public static final <K, V> boolean none(@NotNull Map<? extends K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (map.isEmpty()) {
            return true;
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (function1.invoke(it.next()).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(@NotNull M m, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, Unit> function1) {
        Intrinsics.checkNotNullParameter(m, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        Iterator<Map.Entry<K, V>> it = m.entrySet().iterator();
        while (it.hasNext()) {
            function1.invoke(it.next());
        }
        return m;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(@NotNull M m, @NotNull Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> function2) {
        Intrinsics.checkNotNullParameter(m, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        int index$iv = 0;
        for (Object item$iv : m.entrySet()) {
            index$iv++;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            function2.invoke(Integer.valueOf(index$iv), item$iv);
        }
        return m;
    }

    @InlineOnly
    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.entrySet();
    }

    @NotNull
    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(@NotNull Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return CollectionsKt.asSequence(map.entrySet());
    }
}
