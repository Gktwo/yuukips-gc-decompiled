package org.eclipse.jetty.server;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import org.eclipse.jetty.http.CookieCompliance;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/CookieCutter.class */
public class CookieCutter {
    private static final Logger LOG = Log.getLogger(CookieCutter.class);
    private final CookieCompliance _compliance;
    private Cookie[] _cookies;
    private Cookie[] _lastCookies;
    private final List<String> _fieldList;
    int _fields;

    public CookieCutter() {
        this(CookieCompliance.RFC6265);
    }

    public CookieCutter(CookieCompliance compliance) {
        this._fieldList = new ArrayList();
        this._compliance = compliance;
    }

    public Cookie[] getCookies() {
        if (this._cookies != null) {
            return this._cookies;
        }
        if (this._lastCookies == null || this._fields != this._fieldList.size()) {
            parseFields();
        } else {
            this._cookies = this._lastCookies;
        }
        this._lastCookies = this._cookies;
        return this._cookies;
    }

    public void setCookies(Cookie[] cookies) {
        this._cookies = cookies;
        this._lastCookies = null;
        this._fieldList.clear();
        this._fields = 0;
    }

    public void reset() {
        this._cookies = null;
        this._fields = 0;
    }

    public void addCookieField(String f) {
        if (f != null) {
            String f2 = f.trim();
            if (f2.length() != 0) {
                if (this._fieldList.size() > this._fields) {
                    if (f2.equals(this._fieldList.get(this._fields))) {
                        this._fields++;
                        return;
                    } else {
                        while (this._fieldList.size() > this._fields) {
                            this._fieldList.remove(this._fields);
                        }
                    }
                }
                this._cookies = null;
                this._lastCookies = null;
                List<String> list = this._fieldList;
                int i = this._fields;
                this._fields = i + 1;
                list.add(i, f2);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x032e  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01db A[Catch: Exception -> 0x02f3, TryCatch #0 {Exception -> 0x02f3, blocks: (B:54:0x01d1, B:56:0x01db, B:58:0x01e5, B:59:0x01fb, B:60:0x0224, B:63:0x0234, B:66:0x0244, B:69:0x0254, B:73:0x0263, B:76:0x0285, B:79:0x0294, B:82:0x02a3, B:83:0x02bf, B:85:0x02cb, B:87:0x02dc, B:90:0x02e7), top: B:141:0x01d1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02cb A[Catch: Exception -> 0x02f3, TryCatch #0 {Exception -> 0x02f3, blocks: (B:54:0x01d1, B:56:0x01db, B:58:0x01e5, B:59:0x01fb, B:60:0x0224, B:63:0x0234, B:66:0x0244, B:69:0x0254, B:73:0x0263, B:76:0x0285, B:79:0x0294, B:82:0x02a3, B:83:0x02bf, B:85:0x02cb, B:87:0x02dc, B:90:0x02e7), top: B:141:0x01d1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void parseFields() {
        /*
        // Method dump skipped, instructions count: 1104
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.CookieCutter.parseFields():void");
    }

    protected boolean isRFC6265RejectedCharacter(boolean inQuoted, char c) {
        if (!inQuoted) {
            return Character.isISOControl(c) || c > 127 || c == ',' || c == ';';
        }
        if (Character.isISOControl(c)) {
            return true;
        }
        return false;
    }
}
