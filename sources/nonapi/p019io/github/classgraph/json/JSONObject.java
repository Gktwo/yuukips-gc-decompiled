package nonapi.p019io.github.classgraph.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.json.JSONObject */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/JSONObject.class */
public class JSONObject {
    List<Map.Entry<String, Object>> items;
    CharSequence objectId;

    public JSONObject(int sizeHint) {
        this.items = new ArrayList(sizeHint);
    }

    public JSONObject(List<Map.Entry<String, Object>> items) {
        this.items = items;
    }

    /* access modifiers changed from: package-private */
    public void toJSONString(Map<ReferenceEqualityKey<JSONReference>, CharSequence> jsonReferenceToId, boolean includeNullValuedFields, int depth, int indentWidth, StringBuilder buf) {
        int numDisplayedFields;
        boolean prettyPrint = indentWidth > 0;
        int n = this.items.size();
        if (includeNullValuedFields) {
            numDisplayedFields = n;
        } else {
            numDisplayedFields = 0;
            for (Map.Entry<String, Object> item : this.items) {
                if (item.getValue() != null) {
                    numDisplayedFields++;
                }
            }
        }
        if (this.objectId == null && numDisplayedFields == 0) {
            buf.append("{}");
            return;
        }
        buf.append(prettyPrint ? "{\n" : "{");
        if (this.objectId != null) {
            if (prettyPrint) {
                JSONUtils.indent(depth + 1, indentWidth, buf);
            }
            buf.append('\"');
            buf.append("__ID");
            buf.append(prettyPrint ? "\": " : "\":");
            JSONSerializer.jsonValToJSONString(this.objectId, jsonReferenceToId, includeNullValuedFields, depth + 1, indentWidth, buf);
            if (numDisplayedFields > 0) {
                buf.append(',');
            }
            if (prettyPrint) {
                buf.append('\n');
            }
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            Map.Entry<String, Object> item2 = this.items.get(i);
            Object val = item2.getValue();
            if (val != null || includeNullValuedFields) {
                String key = item2.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Cannot serialize JSON object with null key");
                }
                if (prettyPrint) {
                    JSONUtils.indent(depth + 1, indentWidth, buf);
                }
                buf.append('\"');
                JSONUtils.escapeJSONString(key, buf);
                buf.append(prettyPrint ? "\": " : "\":");
                JSONSerializer.jsonValToJSONString(val, jsonReferenceToId, includeNullValuedFields, depth + 1, indentWidth, buf);
                j++;
                if (j < numDisplayedFields) {
                    buf.append(',');
                }
                if (prettyPrint) {
                    buf.append('\n');
                }
            }
        }
        if (prettyPrint) {
            JSONUtils.indent(depth, indentWidth, buf);
        }
        buf.append('}');
    }
}
