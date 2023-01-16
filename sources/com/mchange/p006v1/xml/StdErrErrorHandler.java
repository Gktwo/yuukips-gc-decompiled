package com.mchange.p006v1.xml;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* renamed from: com.mchange.v1.xml.StdErrErrorHandler */
/* loaded from: grasscutter.jar:com/mchange/v1/xml/StdErrErrorHandler.class */
public class StdErrErrorHandler implements ErrorHandler {
    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException sAXParseException) {
        System.err.println("[Warning]");
        showExceptionInformation(sAXParseException);
        sAXParseException.printStackTrace();
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException sAXParseException) {
        System.err.println("[Error]");
        showExceptionInformation(sAXParseException);
        sAXParseException.printStackTrace();
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException sAXParseException) throws SAXException {
        System.err.println("[Fatal Error]");
        showExceptionInformation(sAXParseException);
        sAXParseException.printStackTrace();
        throw sAXParseException;
    }

    private void showExceptionInformation(SAXParseException sAXParseException) {
        System.err.println("[\tLine Number: " + sAXParseException.getLineNumber() + ']');
        System.err.println("[\tColumn Number: " + sAXParseException.getColumnNumber() + ']');
        System.err.println("[\tPublic ID: " + sAXParseException.getPublicId() + ']');
        System.err.println("[\tSystem ID: " + sAXParseException.getSystemId() + ']');
    }
}
