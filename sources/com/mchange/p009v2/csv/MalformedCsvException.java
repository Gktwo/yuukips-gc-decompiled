package com.mchange.p009v2.csv;

import com.mchange.lang.PotentiallySecondaryException;

/* renamed from: com.mchange.v2.csv.MalformedCsvException */
/* loaded from: grasscutter.jar:com/mchange/v2/csv/MalformedCsvException.class */
public class MalformedCsvException extends PotentiallySecondaryException {
    public MalformedCsvException(String str, Throwable th) {
        super(str, th);
    }

    public MalformedCsvException(Throwable th) {
        super(th);
    }

    public MalformedCsvException(String str) {
        super(str);
    }

    public MalformedCsvException() {
    }
}
