package org.universities.organization_educational_process.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RolesSimpleService;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.UsersInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

//@Controller
//@Slf4j
//@RequiredArgsConstructor
public class UserInfoController {
//    private final UsersInfoSimpleService usersInfoService;
//    private final RolesSimpleService rolesSimpleService;
//
//    @GetMapping("/registration")
//    public String registration(@NonNull Model model){
//        var roles = rolesSimpleService.findAll();
//        roles.removeIf(r -> r.getNameRole().equalsIgnoreCase("admin"));
//
//        model.addAttribute("roles", roles);
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String createUser(UsersInfo user, Model model){
//        if(usersInfoService.isExistUser(user)) {
//            model.addAttribute("errorMessage", String.format("The user with the email: %s has already been registered.", user.getUserEmail()));
//            return "registration";
//        }
//        usersInfoService.createUser(user);
//        return "redirect:/login";
//    }
}
