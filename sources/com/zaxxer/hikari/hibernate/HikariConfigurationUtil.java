package com.zaxxer.hikari.hibernate;

import com.zaxxer.hikari.HikariConfig;
import java.util.Map;
import java.util.Properties;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/hibernate/HikariConfigurationUtil.class */
public class HikariConfigurationUtil {
    public static final String CONFIG_PREFIX = "hibernate.hikari.";
    public static final String CONFIG_PREFIX_DATASOURCE = "hibernate.hikari.dataSource.";

    public static HikariConfig loadConfiguration(Map props) {
        Properties hikariProps = new Properties();
        copyProperty("hibernate.connection.isolation", props, "transactionIsolation", hikariProps);
        copyProperty("hibernate.connection.autocommit", props, "autoCommit", hikariProps);
        copyProperty("hibernate.connection.driver_class", props, "driverClassName", hikariProps);
        copyProperty("hibernate.connection.url", props, "jdbcUrl", hikariProps);
        copyProperty("hibernate.connection.username", props, SendMailJob.PROP_USERNAME, hikariProps);
        copyProperty("hibernate.connection.password", props, "password", hikariProps);
        for (String key : props.keySet()) {
            if (key.startsWith(CONFIG_PREFIX)) {
                hikariProps.setProperty(key.substring(CONFIG_PREFIX.length()), (String) props.get(key));
            }
        }
        return new HikariConfig(hikariProps);
    }

    private static void copyProperty(String srcKey, Map src, String dstKey, Properties dst) {
        if (src.containsKey(srcKey)) {
            dst.setProperty(dstKey, (String) src.get(srcKey));
        }
    }
}
