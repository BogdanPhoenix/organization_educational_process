package org.universities.organization_educational_process.persistence.dao.services.interfaces;

import jakarta.mail.MessagingException;
import org.universities.organization_educational_process.core.email.AbstractEmailContext;

public interface EmailService {
    void sendMail(final AbstractEmailContext email) throws MessagingException;
}
