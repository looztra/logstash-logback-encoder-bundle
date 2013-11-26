Logstash Logback Encoder Bundle
===============================

[![Build Status](https://travis-ci.org/looztra/logstash-logback-encoder-bundle.png?branch=master)](https://travis-ci.org/looztra/logstash-logback-encoder-bundle)

[Dropwizard](http://www.dropwizard.io/ "Dropwizard is awesome") bundle that uses the [Logstash Logback Encoder](https://github.com/logstash/logstash-logback-encoder) to provide logs ready to be consumed by
[Logstash](http://logstash.net/) and [co](http://graylog2.org/).

Greatly inspired by the [Gelf bundle](https://github.com/gini/dropwizard-gelf) for dropwizard.

Usage
-----

The Logstash Logback Encoder Bundle consists in a [ConfiguredBundle](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/ConfiguredBundle.html).

To enable the `LogstashLogbackEncoderBundle` simply add the following code to your [Service](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/Service.html)'s
[initialize method](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/Service.html#initialize%28com.yammer.dropwizard.config.Bootstrap%29):

    @Override
    public void initialize(Bootstrap<MyServiceConfiguration> bootstrap) {
        bootstrap.addBundle(new LogstashLogbackEncoderBundle<MyServiceConfiguration>() {
                @Override
                public LogstashLogbackEncoderConfiguration getConfiguration(MyServiceConfiguration configuration) {
                    return configuration.getLogstashLogbackEncoderConfiguration();
                }
            });
    }

You also need to add a field for `LogstashLogbackEncoderConfiguration` to your own [Configuration](http://dropwizard.codahale.com/maven/apidocs/com/yammer/dropwizard/config/Configuration.html)
class.

TODO: provide a sample project using the `LogstashLogbackEncoderBundle`

Configuration
-------------

TODO
