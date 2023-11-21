package org.universities.organization_educational_process.persistence.dao.services.interfaces.support_contracts;

import lombok.NonNull;
import org.springframework.ui.Model;

public interface ModelErrorMessage {
    default String getMessage(@NonNull Model model, String message, String page){
        model.addAttribute("errorMessage", String.format("The %s is already present in the database.", message));
        return page;
    }
}
