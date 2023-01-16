package org.eclipse.jetty.p023io.jmx;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.eclipse.jetty.jmx.ObjectMBean;
import org.eclipse.jetty.p023io.ConnectionStatistics;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;

@ManagedObject
/* renamed from: org.eclipse.jetty.io.jmx.ConnectionStatisticsMBean */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/jmx/ConnectionStatisticsMBean.class */
public class ConnectionStatisticsMBean extends ObjectMBean {
    public ConnectionStatisticsMBean(Object object) {
        super(object);
    }

    @ManagedAttribute("ConnectionStatistics grouped by connection class")
    public Collection<String> getConnectionStatisticsGroups() {
        return (Collection) ((ConnectionStatistics) getManagedObject()).getConnectionStatisticsGroups().values().stream().sorted(Comparator.comparing((v0) -> {
            return v0.getName();
        })).map(stats -> {
            return stats.dump();
        }).map(dump -> {
            return dump.replaceAll("[\r\n]", " ");
        }).collect(Collectors.toList());
    }
}
