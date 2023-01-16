package com.mchange.p009v2.c3p0.management;

import com.mchange.p009v2.c3p0.C3P0Registry;
import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.sql.SQLException;
import java.util.Set;

/* renamed from: com.mchange.v2.c3p0.management.C3P0RegistryManager */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/management/C3P0RegistryManager.class */
public class C3P0RegistryManager implements C3P0RegistryManagerMBean {
    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public String[] getAllIdentityTokens() {
        Set tokens = C3P0Registry.allIdentityTokens();
        return (String[]) tokens.toArray(new String[tokens.size()]);
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public Set getAllIdentityTokenized() {
        return C3P0Registry.allIdentityTokenized();
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public Set getAllPooledDataSources() {
        return C3P0Registry.allPooledDataSources();
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public int getAllIdentityTokenCount() {
        return C3P0Registry.allIdentityTokens().size();
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public int getAllIdentityTokenizedCount() {
        return C3P0Registry.allIdentityTokenized().size();
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public int getAllPooledDataSourcesCount() {
        return C3P0Registry.allPooledDataSources().size();
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public String[] getAllIdentityTokenizedStringified() {
        return stringifySet(C3P0Registry.allIdentityTokenized());
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public String[] getAllPooledDataSourcesStringified() {
        return stringifySet(C3P0Registry.allPooledDataSources());
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public int getNumPooledDataSources() throws SQLException {
        return C3P0Registry.getNumPooledDataSources();
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public int getNumPoolsAllDataSources() throws SQLException {
        return C3P0Registry.getNumPoolsAllDataSources();
    }

    @Override // com.mchange.p009v2.c3p0.management.C3P0RegistryManagerMBean
    public String getC3p0Version() {
        return C3P0Substitutions.VERSION;
    }

    private String[] stringifySet(Set s) {
        String[] out = new String[s.size()];
        int i = 0;
        for (Object obj : s) {
            i++;
            out[i] = obj.toString();
        }
        return out;
    }
}
