package com.mchange.util.impl;

import java.util.LinkedList;
import java.util.StringTokenizer;

/* loaded from: grasscutter.jar:com/mchange/util/impl/QuotesAndWhitespaceTokenizer.class */
public class QuotesAndWhitespaceTokenizer extends StringEnumerationHelperBase {
    Object current;
    LinkedList list = new LinkedList();

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b8, code lost:
        advance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bc, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public QuotesAndWhitespaceTokenizer(java.lang.String r7) throws java.lang.IllegalArgumentException {
        /*
            r6 = this;
            r0 = r6
            r0.<init>()
            r0 = r6
            java.util.LinkedList r1 = new java.util.LinkedList
            r2 = r1
            r2.<init>()
            r0.list = r1
            r0 = 0
            r8 = r0
            r0 = r7
            int r0 = r0.length()
            r9 = r0
        L_0x0016:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L_0x00b8
            r0 = r7
            r1 = 34
            r2 = r8
            int r0 = r0.indexOf(r1, r2)
            r10 = r0
            r0 = r10
            if (r0 < 0) goto L_0x0092
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            r1 = r0
            r2 = r7
            r3 = r8
            r4 = r10
            java.lang.String r2 = r2.substring(r3, r4)
            r1.<init>(r2)
            r11 = r0
            r0 = r11
            boolean r0 = r0.hasMoreTokens()
            if (r0 == 0) goto L_0x004b
            r0 = r6
            java.util.LinkedList r0 = r0.list
            r1 = r11
            boolean r0 = r0.add(r1)
        L_0x004b:
            r0 = r7
            r1 = 34
            r2 = r10
            r3 = 1
            int r2 = r2 + r3
            int r0 = r0.indexOf(r1, r2)
            r12 = r0
            r0 = r12
            r1 = -1
            if (r0 != r1) goto L_0x0078
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Badly quoted string: "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0078:
            r0 = r6
            java.util.LinkedList r0 = r0.list
            r1 = r7
            r2 = r10
            r3 = 1
            int r2 = r2 + r3
            r3 = r12
            java.lang.String r1 = r1.substring(r2, r3)
            boolean r0 = r0.add(r1)
            r0 = r12
            r1 = 1
            int r0 = r0 + r1
            r8 = r0
            goto L_0x00b5
        L_0x0092:
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            r1 = r0
            r2 = r7
            r3 = r8
            java.lang.String r2 = r2.substring(r3)
            r1.<init>(r2)
            r11 = r0
            r0 = r11
            boolean r0 = r0.hasMoreTokens()
            if (r0 == 0) goto L_0x00b8
            r0 = r6
            java.util.LinkedList r0 = r0.list
            r1 = r11
            boolean r0 = r0.add(r1)
            goto L_0x00b8
        L_0x00b5:
            goto L_0x0016
        L_0x00b8:
            r0 = r6
            r0.advance()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mchange.util.impl.QuotesAndWhitespaceTokenizer.<init>(java.lang.String):void");
    }

    @Override // com.mchange.util.impl.StringEnumerationHelperBase, com.mchange.util.StringEnumeration, com.mchange.p005io.IOStringEnumeration
    public synchronized boolean hasMoreStrings() {
        return this.current != null;
    }

    @Override // com.mchange.util.impl.StringEnumerationHelperBase, com.mchange.util.StringEnumeration, com.mchange.p005io.IOStringEnumeration
    public synchronized String nextString() {
        if (this.current instanceof String) {
            String str = (String) this.current;
            advance();
            return str;
        }
        StringTokenizer stringTokenizer = (StringTokenizer) this.current;
        String nextToken = stringTokenizer.nextToken();
        if (!stringTokenizer.hasMoreTokens()) {
            advance();
        }
        return nextToken;
    }

    private void advance() {
        if (this.list.isEmpty()) {
            this.current = null;
            return;
        }
        this.current = this.list.getFirst();
        this.list.removeFirst();
    }

    public static void main(String[] strArr) {
        QuotesAndWhitespaceTokenizer quotesAndWhitespaceTokenizer = new QuotesAndWhitespaceTokenizer("\t  \n\r");
        while (quotesAndWhitespaceTokenizer.hasMoreStrings()) {
            System.out.println(quotesAndWhitespaceTokenizer.nextString());
        }
    }
}
