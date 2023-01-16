package org.quartz.xml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* loaded from: grasscutter.jar:org/quartz/xml/ValidationException.class */
public class ValidationException extends Exception {
    private static final long serialVersionUID = -1697832087051681357L;
    private Collection<Exception> validationExceptions;

    public ValidationException() {
        this.validationExceptions = new ArrayList();
    }

    public ValidationException(String message) {
        super(message);
        this.validationExceptions = new ArrayList();
    }

    public ValidationException(Collection<Exception> errors) {
        this();
        this.validationExceptions = Collections.unmodifiableCollection(this.validationExceptions);
        initCause(errors.iterator().next());
    }

    public ValidationException(String message, Collection<Exception> errors) {
        this(message);
        this.validationExceptions = Collections.unmodifiableCollection(this.validationExceptions);
        initCause(errors.iterator().next());
    }

    public Collection<Exception> getValidationExceptions() {
        return this.validationExceptions;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (getValidationExceptions().size() == 0) {
            return getMessage();
        }
        StringBuffer sb = new StringBuffer();
        boolean first = true;
        for (Exception e : getValidationExceptions()) {
            if (!first) {
                sb.append('\n');
                first = false;
            }
            sb.append(e.getMessage());
        }
        return sb.toString();
    }
}
