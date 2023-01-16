package com.mchange.p006v1.p007db.sql;

/* renamed from: com.mchange.v1.db.sql.DbAuth */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/DbAuth.class */
class DbAuth {
    String username;
    String password;

    public DbAuth(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DbAuth dbAuth = (DbAuth) obj;
        return this.username.equals(dbAuth.username) && this.password.equals(dbAuth.password);
    }

    public int hashCode() {
        return this.username.hashCode() ^ this.password.hashCode();
    }
}
