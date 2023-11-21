package org.universities.organization_educational_process.controllers.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.universities.organization_educational_process.persistence.model.user.UserInfo;
import org.universities.organization_educational_process.persistence.requests.user.ChangePasswordRequest;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.user.UserInfoSimpleService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/${application.uri.main}/${application.uri.user}")
@RequiredArgsConstructor
public class UserInfoController {
    private final UserInfoSimpleService service;

    @PatchMapping("/change-password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            @NonNull Principal connectedUser
    ){
        service.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/all")
    public List<UserInfo> registrationPage(){
        return service.findAll();
    }
}
