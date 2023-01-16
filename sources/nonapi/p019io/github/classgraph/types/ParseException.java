package nonapi.p019io.github.classgraph.types;

/* renamed from: nonapi.io.github.classgraph.types.ParseException */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/types/ParseException.class */
public class ParseException extends Exception {
    static final long serialVersionUID = 1;

    public ParseException(Parser parser, String msg) {
        super(parser == null ? msg : msg + " (" + parser.getPositionInfo() + ")");
    }
}
