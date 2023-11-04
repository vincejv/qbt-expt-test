package org.acme;

import java.util.Locale;

public class BeanT {
    private Locale locale;

    public BeanT(String locale) {
        this.locale = Locale.forLanguageTag(locale);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
