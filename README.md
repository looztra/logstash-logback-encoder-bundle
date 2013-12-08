Logstash Logback Encoder Bundle
===============================

[![Build Status](https://travis-ci.org/looztra/logstash-logback-encoder-bundle.png?branch=master)](https://travis-ci.org/looztra/logstash-logback-encoder-bundle)

[Dropwizard](http://www.dropwizard.io/ "Dropwizard is awesome") bundle that uses the [Logstash Logback Encoder](https://github.com/logstash/logstash-logback-encoder) to provide logs ready to be consumed by
[Logstash](http://logstash.net/) and [co](http://graylog2.org/).

Greatly inspired by the [Gelf bundle](https://github.com/gini/dropwizard-gelf) for dropwizard.

Get it
------

0.6.2 release version available. Snapshots are available in [Sonatype OSS snapshots repo](https://oss.sonatype.org/index.html)

```xml
	<dependency>
	  <groupId>net.devlab722</groupId>
	  <artifactId>logstash-logback-encoder-bundle</artifactId>
	  <version>0.6.2</version>
	</dependency>
```
Usage
-----

The Logstash Logback Encoder Bundle consists in a [ConfiguredBundle](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/ConfiguredBundle.html).

To enable the `LogstashLogbackEncoderBundle` and specify which part of your configuration will support the
bundle configuration, simply add the following code to your [Service](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/Service.html)'s
[initialize method](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/Service.html#initialize%28com.yammer.dropwizard.config.Bootstrap%29):
```java
    @Override
    public void initialize(Bootstrap<MyServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new LogstashLogbackEncoderBundle<MyServiceConfiguration>() {
                @Override
                public LogstashLogbackEncoderConfiguration getConfiguration(MyServiceConfiguration configuration) {
                    return configuration.getLogstashLogbackEncoderConfiguration();
                }
            });
    }
```
You also need to add a field for `LogstashLogbackEncoderConfiguration` to your own [Configuration](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/config/Configuration.html)
class.

You can have a look at a sample project using it available at https://bitbucket.org/looztra/dropwizzardsample (see [configuration file](https://bitbucket.org/looztra/dropwizzardsample/src/f2713ee1722bbe6b90c550f60a7b03a74427226d/hello-world.yml?at=default)
 and [service java file](https://bitbucket.org/looztra/dropwizzardsample/src/f2713ee1722bbe6b90c550f60a7b03a74427226d/src/main/java/net/kalaari/wizard/HelloWorldService.java?at=default)


Configuration
-------------

The `LogstashLogbackEncoderConfiguration` inherits its properties from the `LoggingConfiguration.FileConfiguration`
and provides an additionnal property `includeCallerInfo` to include or not the callerInfo (*warning* getting the
callerInfo is an expensive operation that should not be set to true on production environments)

TODO
----

* provide adjustments for the upcoming 0.7.0 version of dropwizard
