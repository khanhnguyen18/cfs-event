package org.cfs.pact.provider;


//@ExtendWith({PactConsumerTestExt.class, SpringExtension.class})
//@PactTestFor(providerName = "ses-api", port = "8080")
//@ContextConfiguration(classes = {PactConsumerSpringConfiguration.class})
public class CfsEventPactProvider {


//    @Pact(consumer = "cfs-events")
//    RequestResponsePact createPact(PactDslWithProvider builder) {
//        DslPart requestBody = new PactDslJsonBody()
//                .object("documentMetadata")
//                .array("properties")
//                .object();
//        Map<String, String> header = new HashMap<>();
//        header.put("Content-Type", "application/json");
//        return builder
//                .given("")
//                .uponReceiving("Create call for service event")
//                .path("/rest/api/v1/cfs-event/create")
//                .headers(header)
//                .body(requestBody)
//                .method(HttpMethod.POST.toString())
//                .willRespondWith()
//                .status(201)
//                .toPact();
//    }
//
//    @Test
//    @PactTestFor(pactMethod = "createPact")
//    public void createCallForServiceEvent() {
//
//    }

}