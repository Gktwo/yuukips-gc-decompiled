package com.mchange.p006v1.p007db.sql;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.AttributeList;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* renamed from: com.mchange.v1.db.sql.XmlSchema */
/* loaded from: grasscutter.jar:com/mchange/v1/db/sql/XmlSchema.class */
public class XmlSchema implements Schema {
    private static final int CREATE = 0;
    private static final int DROP = 1;
    List createStmts;
    List dropStmts;
    Map appMap;

    public XmlSchema(URL url) throws SAXException, IOException, ParserConfigurationException {
        parse(url.openStream());
    }

    public XmlSchema(InputStream inputStream) throws SAXException, IOException, ParserConfigurationException {
        parse(inputStream);
    }

    public XmlSchema() {
    }

    public void parse(InputStream inputStream) throws SAXException, IOException, ParserConfigurationException {
        this.createStmts = new ArrayList();
        this.dropStmts = new ArrayList();
        this.appMap = new HashMap();
        InputSource inputSource = new InputSource();
        inputSource.setByteStream(inputStream);
        inputSource.setSystemId(XmlSchema.class.getResource("schema.dtd").toExternalForm());
        SAXParserFactory.newInstance().newSAXParser().parse(inputSource, new MySaxHandler());
    }

    private void doStatementList(List list, Connection connection) throws SQLException {
        Statement statement;
        if (list != null) {
            try {
                statement = null;
                try {
                    statement = connection.createStatement();
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        statement.executeUpdate((String) it.next());
                    }
                    connection.commit();
                    StatementUtils.attemptClose(statement);
                } catch (SQLException e) {
                    ConnectionUtils.attemptRollback(connection);
                    e.fillInStackTrace();
                    throw e;
                }
            } catch (Throwable th) {
                StatementUtils.attemptClose(statement);
                throw th;
            }
        }
    }

    @Override // com.mchange.p006v1.p007db.sql.Schema
    public String getStatementText(String str, String str2) {
        SqlApp sqlApp = (SqlApp) this.appMap.get(str);
        String str3 = null;
        if (sqlApp != null) {
            str3 = sqlApp.getStatementText(str2);
        }
        return str3;
    }

    @Override // com.mchange.p006v1.p007db.sql.Schema
    public void createSchema(Connection connection) throws SQLException {
        doStatementList(this.createStmts, connection);
    }

    @Override // com.mchange.p006v1.p007db.sql.Schema
    public void dropSchema(Connection connection) throws SQLException {
        doStatementList(this.dropStmts, connection);
    }

    public static void main(String[] strArr) {
        try {
            new XmlSchema(XmlSchema.class.getResource("/com/mchange/v1/hjug/hjugschema.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v1.db.sql.XmlSchema$MySaxHandler */
    /* loaded from: grasscutter.jar:com/mchange/v1/db/sql/XmlSchema$MySaxHandler.class */
    public class MySaxHandler extends HandlerBase {
        int state = -1;
        boolean in_statement = false;
        boolean in_comment = false;
        StringBuffer charBuff = null;
        SqlApp currentApp = null;
        String currentStmtName = null;

        MySaxHandler() {
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void startElement(String str, AttributeList attributeList) {
            if (str.equals("create")) {
                this.state = 0;
            } else if (str.equals("drop")) {
                this.state = 1;
            } else if (str.equals("statement")) {
                this.in_statement = true;
                this.charBuff = new StringBuffer();
                if (this.currentApp != null) {
                    int length = attributeList.getLength();
                    for (int i = 0; i < length; i++) {
                        if (attributeList.getName(i).equals("name")) {
                            this.currentStmtName = attributeList.getValue(i);
                            return;
                        }
                    }
                }
            } else if (str.equals("comment")) {
                this.in_comment = true;
            } else if (str.equals("application")) {
                int length2 = attributeList.getLength();
                for (int i2 = 0; i2 < length2; i2++) {
                    if (attributeList.getName(i2).equals("name")) {
                        String value = attributeList.getValue(i2);
                        this.currentApp = (SqlApp) XmlSchema.this.appMap.get(value);
                        if (this.currentApp == null) {
                            this.currentApp = new SqlApp();
                            XmlSchema.this.appMap.put(value.intern(), this.currentApp);
                            return;
                        }
                        return;
                    }
                }
            }
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            if (!this.in_comment && this.in_statement) {
                this.charBuff.append(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.DocumentHandler
        public void endElement(String str) {
            if (str.equals("statement")) {
                String trim = this.charBuff.toString().trim();
                if (this.state == 0) {
                    XmlSchema.this.createStmts.add(trim);
                } else if (this.state == 1) {
                    XmlSchema.this.dropStmts.add(trim);
                } else if (this.currentApp != null && this.currentStmtName != null) {
                    this.currentApp.setStatementText(this.currentStmtName, trim);
                }
            } else if (str.equals("create") || str.equals("drop")) {
                this.state = -1;
            } else if (str.equals("comment")) {
                this.in_comment = false;
            } else if (str.equals("application")) {
                this.currentApp = null;
            }
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) {
            System.err.println("[Warning] " + sAXParseException.getMessage());
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) {
            System.err.println("[Error] " + sAXParseException.getMessage());
        }

        @Override // org.xml.sax.HandlerBase, org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXException {
            System.err.println("[Fatal Error] " + sAXParseException.getMessage());
            throw sAXParseException;
        }
    }

    /* renamed from: com.mchange.v1.db.sql.XmlSchema$SqlApp */
    /* loaded from: grasscutter.jar:com/mchange/v1/db/sql/XmlSchema$SqlApp.class */
    class SqlApp {
        Map stmtMap = new HashMap();

        SqlApp() {
        }

        public void setStatementText(String str, String str2) {
            this.stmtMap.put(str, str2);
        }

        public String getStatementText(String str) {
            return (String) this.stmtMap.get(str);
        }
    }
}
