package devlab722.dropwizard.bundle;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.filter.ThresholdFilter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.spi.FilterAttachable;
import com.google.common.base.Optional;
import com.yammer.dropwizard.ConfiguredBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.config.LoggingConfiguration;
import com.yammer.dropwizard.logging.AsyncAppender;
import com.yammer.dropwizard.logging.LogFormatter;
import com.yammer.dropwizard.logging.LogbackFactory;
import net.logstash.logback.encoder.LogstashEncoder;
import org.slf4j.LoggerFactory;

/**
 * User: cfurmaniak
 * Date: 10/11/13
 * Time: 21:16
 */
public abstract class LogstashLogbackEncoderBundle<T extends Configuration> implements ConfiguredBundle<T> {
    @Override
    public void run(T configuration, Environment environment) throws Exception {
        final LogstashLogbackEncoderConfiguration lleConfig = getConfiguration(configuration);
        if (lleConfig.isEnabled()) {
            final Logger root = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
            final FileAppender<ILoggingEvent> jsonFileAppender = LogbackFactory.buildFileAppender(lleConfig,
                    root.getLoggerContext(), lleConfig.getLogFormat());
            final LogstashEncoder logstashEncoder = new LogstashEncoder();
            logstashEncoder.setIncludeCallerInfo(lleConfig.isIncludeCallerInfo());
            jsonFileAppender.stop();
            jsonFileAppender.setEncoder(logstashEncoder);
            jsonFileAppender.start();
            root.addAppender(AsyncAppender.wrap(jsonFileAppender));

        }
    }

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
    }

    public abstract LogstashLogbackEncoderConfiguration getConfiguration(T configuration);
}
