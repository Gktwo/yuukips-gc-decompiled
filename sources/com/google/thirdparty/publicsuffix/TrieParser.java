package com.google.thirdparty.publicsuffix;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

@GwtCompatible
/* loaded from: grasscutter.jar:com/google/thirdparty/publicsuffix/TrieParser.class */
final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.m1464on("");

    TrieParser() {
    }

    /* access modifiers changed from: package-private */
    public static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence encoded) {
        ImmutableMap.Builder<String, PublicSuffixType> builder = ImmutableMap.builder();
        int encodedLen = encoded.length();
        int idx = 0;
        while (idx < encodedLen) {
            idx += doParseTrieToBuilder(Lists.newLinkedList(), encoded, idx, builder);
        }
        return builder.build();
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00af  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int doParseTrieToBuilder(java.util.List<java.lang.CharSequence> r6, java.lang.CharSequence r7, int r8, com.google.common.collect.ImmutableMap.Builder<java.lang.String, com.google.thirdparty.publicsuffix.PublicSuffixType> r9) {
        /*
        // Method dump skipped, instructions count: 233
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.thirdparty.publicsuffix.TrieParser.doParseTrieToBuilder(java.util.List, java.lang.CharSequence, int, com.google.common.collect.ImmutableMap$Builder):int");
    }

    private static CharSequence reverse(CharSequence s) {
        return new StringBuilder(s).reverse();
    }
}
