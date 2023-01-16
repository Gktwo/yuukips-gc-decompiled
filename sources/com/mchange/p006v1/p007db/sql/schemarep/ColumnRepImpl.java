package com.mchange.p006v1.p007db.sql.schemarep;

import com.mchange.lang.ArrayUtils;
import java.util.Arrays;

/* renamed from: com.mchange.v1.db.sql.schemarep.ColumnRepImpl */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/schemarep/ColumnRepImpl.class */
public class ColumnRepImpl implements ColumnRep {
    String colName;
    int col_type;
    int[] colSize;
    boolean accepts_nulls;
    Object defaultValue;

    public ColumnRepImpl(String str, int i) {
        this(str, i, null);
    }

    public ColumnRepImpl(String str, int i, int[] iArr) {
        this(str, i, iArr, false, null);
    }

    public ColumnRepImpl(String str, int i, int[] iArr, boolean z, Object obj) {
        this.colName = str;
        this.col_type = i;
        this.colSize = iArr;
        this.accepts_nulls = z;
        this.defaultValue = obj;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ColumnRep
    public String getColumnName() {
        return this.colName;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ColumnRep
    public int getColumnType() {
        return this.col_type;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ColumnRep
    public int[] getColumnSize() {
        return this.colSize;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ColumnRep
    public boolean acceptsNulls() {
        return this.accepts_nulls;
    }

    @Override // com.mchange.p006v1.p007db.sql.schemarep.ColumnRep
    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ColumnRepImpl columnRepImpl = (ColumnRepImpl) obj;
        if (!this.colName.equals(columnRepImpl.colName) || this.col_type != columnRepImpl.col_type || this.accepts_nulls != columnRepImpl.accepts_nulls) {
            return false;
        }
        if (this.colSize != columnRepImpl.colSize && !Arrays.equals(this.colSize, columnRepImpl.colSize)) {
            return false;
        }
        if (this.defaultValue == columnRepImpl.defaultValue || this.defaultValue == null || this.defaultValue.equals(columnRepImpl.defaultValue)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.colName.hashCode() ^ this.col_type;
        if (!this.accepts_nulls) {
            hashCode ^= -1;
        }
        if (this.colSize != null) {
            hashCode ^= ArrayUtils.hashAll(this.colSize);
        }
        if (this.defaultValue != null) {
            hashCode ^= this.defaultValue.hashCode();
        }
        return hashCode;
    }
}
