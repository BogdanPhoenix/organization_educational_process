package org.universities.organization_educational_process.core.email;

import lombok.Getter;
import lombok.Setter;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public abstract class AbstractEmailContext {
    private String from;
    private String to;
    private String subject;
    private String email;
    private String attachment;
    private String fromDisplayName;
    private String emailLanguage;
    private String displayName;
    private String templateLocation;
    private Map<String, Object> context;

    protected AbstractEmailContext() {
        this.context = new HashMap<>();
    }

    public abstract <T extends UsersInfo> void init(T context);
    public abstract void buildVerificationUrl(final String baseURL, final String token);

    public void setToken(String token) {
        put("token", token);
    }

    public Object put(String key, Object value) {
        return key ==null ? null : this.context.put(key.intern(),value);
    }
}
