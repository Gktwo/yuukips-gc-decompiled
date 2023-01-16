package com.mchange.p009v2.naming;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.ser.IndirectlySerialized;
import com.mchange.p009v2.ser.Indirector;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.Referenceable;

/* renamed from: com.mchange.v2.naming.ReferenceIndirector */
/* loaded from: grasscutter.jar:com/mchange/v2/naming/ReferenceIndirector.class */
public class ReferenceIndirector implements Indirector {
    static final MLogger logger = MLog.getLogger(ReferenceIndirector.class);
    Name name;
    Name contextName;
    Hashtable environmentProperties;

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Name getNameContextName() {
        return this.contextName;
    }

    public void setNameContextName(Name name) {
        this.contextName = name;
    }

    public Hashtable getEnvironmentProperties() {
        return this.environmentProperties;
    }

    public void setEnvironmentProperties(Hashtable hashtable) {
        this.environmentProperties = hashtable;
    }

    @Override // com.mchange.p009v2.ser.Indirector
    public IndirectlySerialized indirectForm(Object obj) throws Exception {
        return new ReferenceSerialized(((Referenceable) obj).getReference(), this.name, this.contextName, this.environmentProperties);
    }

    /* renamed from: com.mchange.v2.naming.ReferenceIndirector$ReferenceSerialized */
    /* loaded from: grasscutter.jar:com/mchange/v2/naming/ReferenceIndirector$ReferenceSerialized.class */
    private static class ReferenceSerialized implements IndirectlySerialized {
        Reference reference;
        Name name;
        Name contextName;
        Hashtable env;

        ReferenceSerialized(Reference reference, Name name, Name name2, Hashtable hashtable) {
            this.reference = reference;
            this.name = name;
            this.contextName = name2;
            this.env = hashtable;
        }

        @Override // com.mchange.p009v2.ser.IndirectlySerialized
        public Object getObject() throws ClassNotFoundException, IOException {
            Context context;
            try {
                if (this.env == null) {
                    context = new InitialContext();
                } else {
                    context = new InitialContext(this.env);
                }
                Context context2 = null;
                if (this.contextName != null) {
                    context2 = (Context) context.lookup(this.contextName);
                }
                return ReferenceableUtils.referenceToObject(this.reference, this.name, context2, this.env);
            } catch (NamingException e) {
                if (ReferenceIndirector.logger.isLoggable(MLevel.WARNING)) {
                    ReferenceIndirector.logger.log(MLevel.WARNING, "Failed to acquire the Context necessary to lookup an Object.", e);
                }
                throw new InvalidObjectException("Failed to acquire the Context necessary to lookup an Object: " + e.toString());
            }
        }
    }
}
