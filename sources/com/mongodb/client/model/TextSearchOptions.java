package com.mongodb.client.model;

import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/client/model/TextSearchOptions.class */
public final class TextSearchOptions {
    private String language;
    private Boolean caseSensitive;
    private Boolean diacriticSensitive;

    @Nullable
    public String getLanguage() {
        return this.language;
    }

    public TextSearchOptions language(@Nullable String language) {
        this.language = language;
        return this;
    }

    @Nullable
    public Boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    public TextSearchOptions caseSensitive(@Nullable Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    @Nullable
    public Boolean getDiacriticSensitive() {
        return this.diacriticSensitive;
    }

    public TextSearchOptions diacriticSensitive(@Nullable Boolean diacriticSensitive) {
        this.diacriticSensitive = diacriticSensitive;
        return this;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextSearchOptions that = (TextSearchOptions) o;
        if (this.language != null) {
            if (!this.language.equals(that.language)) {
                return false;
            }
        } else if (that.language != null) {
            return false;
        }
        if (this.caseSensitive != null) {
            if (!this.caseSensitive.equals(that.caseSensitive)) {
                return false;
            }
        } else if (that.caseSensitive != null) {
            return false;
        }
        return this.diacriticSensitive != null ? this.diacriticSensitive.equals(that.diacriticSensitive) : that.diacriticSensitive == null;
    }

    public int hashCode() {
        return (31 * ((31 * (this.language != null ? this.language.hashCode() : 0)) + (this.caseSensitive != null ? this.caseSensitive.hashCode() : 0))) + (this.diacriticSensitive != null ? this.diacriticSensitive.hashCode() : 0);
    }

    public String toString() {
        return "Text Search Options{language='" + this.language + "', caseSensitive=" + this.caseSensitive + ", diacriticSensitive=" + this.diacriticSensitive + '}';
    }
}
