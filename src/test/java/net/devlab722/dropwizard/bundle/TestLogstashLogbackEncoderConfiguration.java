package net.devlab722.dropwizard.bundle;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * User: cfurmaniak
 * Date: 07/12/13
 * Time: 17:16
 */
public class TestLogstashLogbackEncoderConfiguration {
    @Test
    public void should_have_includeCallerInfo_false_by_default() {
        LogstashLogbackEncoderConfiguration defaultConfig = new LogstashLogbackEncoderConfiguration();
        assertThat(defaultConfig.isIncludeCallerInfo()).isFalse();
    }
}
