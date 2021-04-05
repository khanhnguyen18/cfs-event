package org.cfs.pact.provider;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import org.cfs.LocalCfsApplication;
import org.cfs.security.service.CurrentUserService;
import org.cfs.security.vo.CfsUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = LocalCfsApplication.class)
@Provider("cfs-api")
@ActiveProfiles(profiles = {"pact"})
@PactFolder("pact")
public class ContractVerificationTest {

    @LocalServerPort
    private int serverPort;

    @MockBean
    private CurrentUserService currentUserService;

    @BeforeEach
    void before(PactVerificationContext context) {
        context.setTarget(new HttpTestTarget("localhost", serverPort, "/"));

        //CfsUser cfsUser = new CfsUser(null, null, null, UUID.fromString("4f9b99eb-490a-484e-bade-15e3841dfda9"));
        CfsUser cfsUser = mock(CfsUser.class);
        when(cfsUser.getAgencyId()).thenReturn(UUID.fromString("4f9b99eb-490a-484e-bade-15e3841dfda9"));
        when(currentUserService.getCurrentUser()).thenReturn(cfsUser);
    }

    @TestTemplate
    @ExtendWith(PactVerificationInvocationContextProvider.class)
    void pactVerificationTestTemplate(PactVerificationContext context) {
        context.verifyInteraction();
    }

}