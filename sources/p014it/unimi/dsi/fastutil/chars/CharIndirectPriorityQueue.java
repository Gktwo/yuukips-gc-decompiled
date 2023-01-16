package p014it.unimi.dsi.fastutil.chars;

import java.util.Comparator;
import p014it.unimi.dsi.fastutil.IndirectPriorityQueue;

/* renamed from: it.unimi.dsi.fastutil.chars.CharIndirectPriorityQueue */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharIndirectPriorityQueue.class */
public interface CharIndirectPriorityQueue extends IndirectPriorityQueue<Character> {
    /* Return type fixed from 'it.unimi.dsi.fastutil.chars.CharComparator' to match base method */
    @Override // p014it.unimi.dsi.fastutil.IndirectPriorityQueue
    Comparator<? super Character> comparator();
}
