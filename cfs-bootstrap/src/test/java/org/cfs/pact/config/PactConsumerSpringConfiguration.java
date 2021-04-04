package org.cfs.pact.config;

import org.cfs.config.RestConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@AutoConfigureWebClient
@Import({RestConfiguration.class})
public class PactConsumerSpringConfiguration {
}
