package dev.morphia.query;

import com.mongodb.QueryOperators;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/CriteriaContainerImpl.class */
public class CriteriaContainerImpl extends AbstractCriteria implements CriteriaContainer {
    private final Mapper mapper;
    private final EntityModel model;
    private final CriteriaJoin joinMethod;
    private final List<Criteria> children = new ArrayList();
    private LegacyQuery<?> query;

    /* access modifiers changed from: protected */
    public CriteriaContainerImpl(Mapper mapper, LegacyQuery<?> query, CriteriaJoin joinMethod) {
        this.joinMethod = joinMethod;
        this.mapper = mapper;
        this.query = query;
        this.model = mapper.getEntityModel(query.getEntityClass());
    }

    public CriteriaJoin getJoinMethod() {
        return this.joinMethod;
    }

    public List<Criteria> getChildren() {
        return this.children;
    }

    @Override // dev.morphia.query.CriteriaContainer
    public void add(Criteria... criteria) {
        for (Criteria c : criteria) {
            c.attach(this);
            this.children.add(c);
        }
    }

    @Override // dev.morphia.query.Criteria
    public Document toDocument() {
        if (this.joinMethod == CriteriaJoin.AND) {
            return and();
        }
        return m1226or();
    }

    private Document and() {
        Document document = new Document();
        List<Document> and = new ArrayList<>();
        Set<String> names = new HashSet<>();
        boolean duplicates = false;
        for (Criteria child : this.children) {
            Document childObject = child.toDocument();
            for (String s : childObject.keySet()) {
                duplicates |= !names.add(s);
            }
            and.add(childObject);
        }
        if (!duplicates) {
            for (Map<? extends String, ? extends Object> map : and) {
                document.putAll(map);
            }
        } else {
            document.put(QueryOperators.AND, (Object) and);
        }
        return document;
    }

    /* renamed from: or */
    private Document m1226or() {
        Document document = new Document();
        List<Document> or = new ArrayList<>();
        for (Criteria child : this.children) {
            or.add(child.toDocument());
        }
        document.put(QueryOperators.f428OR, (Object) or);
        return document;
    }

    @Override // dev.morphia.query.Criteria
    public String getFieldName() {
        return this.joinMethod.toString();
    }

    @Override // dev.morphia.query.CriteriaContainer
    public CriteriaContainer and(Criteria... criteria) {
        return collect(CriteriaJoin.AND, criteria);
    }

    @Override // dev.morphia.query.CriteriaContainer
    public FieldEnd<? extends CriteriaContainer> criteria(String name) {
        return new FieldEndImpl(this.mapper, name, this, this.model, this.query.isValidatingNames());
    }

    public LegacyQuery<?> getQuery() {
        return this.query;
    }

    public void setQuery(LegacyQuery<?> query) {
        this.query = query;
    }

    public String toString() {
        return this.children.toString();
    }

    @Override // dev.morphia.query.CriteriaContainer
    /* renamed from: or */
    public CriteriaContainer mo1224or(Criteria... criteria) {
        return collect(CriteriaJoin.OR, criteria);
    }

    @Override // dev.morphia.query.CriteriaContainer
    public void remove(Criteria criteria) {
        this.children.remove(criteria);
    }

    private CriteriaContainer collect(CriteriaJoin cj, Criteria... criteria) {
        CriteriaContainerImpl parent = new CriteriaContainerImpl(this.mapper, this.query, cj);
        int length = criteria.length;
        for (int i = 0; i < length; i++) {
            parent.add(criteria[i]);
        }
        add(parent);
        return parent;
    }
}
