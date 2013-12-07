package net.devlab722.dropwizard.bundle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.LoggingConfiguration;
import lombok.Data;

/**
 * User: cfurmaniak
 * Date: 10/11/13
 * Time: 21:18
 */
@Data
public class LogstashLogbackEncoderConfiguration extends LoggingConfiguration.FileConfiguration {
    @JsonProperty
    private boolean includeCallerInfo = false;
}
