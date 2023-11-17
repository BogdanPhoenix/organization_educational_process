package org.universities.organization_educational_process.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.RolesSimpleService;
import org.universities.organization_educational_process.persistence.dao.services.interfaces.UsersInfoSimpleService;
import org.universities.organization_educational_process.persistence.model.Roles;
import org.universities.organization_educational_process.persistence.model.UsersInfo;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
class TestUserInfoController{
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RolesSimpleService rolesSimpleService;
    @Autowired
    private UsersInfoSimpleService usersInfoSimpleService;

    private static final String TEST_ROLE = "User";

    @BeforeEach
    void createDB(){
        Roles role = new Roles();
        role.setNameRole(TEST_ROLE);
        role = rolesSimpleService.addRole(role);

        UsersInfo testUser = new UsersInfo();
        testUser.setRole(role);
        testUser.setUserEmail("test@example.com");
        testUser.setPasswordUser("testPassword");
        testUser.setLastName("Doe");
        testUser.setFirstName("John");
        testUser.setPatronymic("Pat");
        testUser.setCurrentData(true);

        usersInfoSimpleService.createUser(testUser);
    }

    @AfterEach
    void dropDB(){
        usersInfoSimpleService.deleteAllUsers();
        rolesSimpleService.deleteAllRoles();
    }

    @Test
    void shouldReturnRegistrationForm() throws Exception {
        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(view().name("registration"));
    }

    @Test
    void testCreateUser_SuccessfulRegistration(){
        UsersInfoSimpleService testUserService = mock(UsersInfoSimpleService.class);
//        UserInfoController controller = new UserInfoController(testUserService, rolesSimpleService);
//        Model mockModel = mock(Model.class);
//        UsersInfo testUser = mock(UsersInfo.class);
//
//        when(testUserService.isExistUser(testUser)).thenReturn(false);
//        when(testUserService.createUser(testUser)).thenReturn(testUser);
//
//        String result = controller.createUser(testUser, mockModel);
//
//        verify(testUserService).isExistUser(testUser);
//        verify(testUserService).createUser(testUser);
//        assertEquals("redirect:/login", result);
    }

    @Test
    void testCreateUser_WrongRegistration(){
        UsersInfoSimpleService testUserService = mock(UsersInfoSimpleService.class);
//        UserInfoController controller = new UserInfoController(testUserService, rolesSimpleService);
//        Model mockModel = mock(Model.class);
//        UsersInfo testUser = mock(UsersInfo.class);
//
//        when(testUserService.isExistUser(testUser)).thenReturn(true);
//
//        String result = controller.createUser(testUser, mockModel);
//        assertEquals("registration", result);
    }

    @Test
    void shouldCreateUserSuccessfully() throws Exception{
        String userEmail = "newTest@example.com";
        String password = "testPassword";
        String firstName = "David";
        String lastName = "Pad";
        String patronymic = "Cat";

        Roles roleTest = rolesSimpleService.findByName(TEST_ROLE);

        mockMvc.perform(get("/registration"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("roles", rolesSimpleService.findAll()));

        mockMvc.perform(post("/registration")
                        .param("userEmail", userEmail)
                        .param("passwordUser", password)
                        .param("repeatPassword", password)
                        .param("firstName", firstName)
                        .param("lastName", lastName)
                        .param("patronymic", patronymic)
                        .param("role", String.valueOf(roleTest.getIndexRole()))
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login"));
    }
}
