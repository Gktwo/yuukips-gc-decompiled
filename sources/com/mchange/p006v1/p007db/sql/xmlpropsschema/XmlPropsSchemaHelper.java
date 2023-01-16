package com.mchange.p006v1.p007db.sql.xmlpropsschema;

import com.mchange.p006v1.xmlprops.DomXmlPropsParser;
import com.mchange.p006v1.xmlprops.XmlPropsException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringTokenizer;

/* renamed from: com.mchange.v1.db.sql.xmlpropsschema.XmlPropsSchemaHelper */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/xmlpropsschema/XmlPropsSchemaHelper.class */
public class XmlPropsSchemaHelper {
    Properties props;

    public XmlPropsSchemaHelper(InputStream inputStream) throws XmlPropsException {
        this.props = new DomXmlPropsParser().parseXmlProps(inputStream);
    }

    public PreparedStatement prepareXmlStatement(Connection connection, String str) throws SQLException {
        return connection.prepareStatement(getKey(str));
    }

    public void executeViaStatement(Statement statement, String str) throws SQLException {
        statement.executeUpdate(getKey(str));
    }

    public StringTokenizer getItems(String str) {
        return new StringTokenizer(getKey(str), ", \t\r\n");
    }

    public String getKey(String str) {
        return this.props.getProperty(str).trim();
    }
}
