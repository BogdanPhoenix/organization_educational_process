package org.universities.organization_educational_process.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RolesSimpleService;
import org.universities.organization_educational_process.persistence.model.Roles;

@Controller
@Slf4j
@RequiredArgsConstructor
public class RoleController {
    private final RolesSimpleService rolesSimpleService;
    @PostMapping("/role/add")
    public String addRole(Roles role){
        var firstLetter = role.getNameRole().substring(0,1).toUpperCase();
        var nextWorld = role.getNameRole().substring(1).toLowerCase();

        role.setNameRole(firstLetter + nextWorld);

        log.info("{}", role);
        rolesSimpleService.addRole(role);
        return "redirect:/role";
    }

    @GetMapping("/role")
    public String listAllRoles(Model model) {
        var roles = rolesSimpleService.findAll();
        log.info("{}", roles);
        model.addAttribute("roles", roles);
        return "role";
    }
}
