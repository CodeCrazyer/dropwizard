package com.allen.healthcheck;

import com.codahale.metrics.health.HealthCheck;
import org.apache.commons.lang3.StringUtils;

/**
 * Author   yang_tao@<yangtao.letzgo.com.cn>
 * Date     2017-09-08 10:05
 * Version  1.0
 */
public class ApplicationHealthCheck extends HealthCheck{
    private final String template;
    private final String defaultName;

    public ApplicationHealthCheck(String template, String defaultName) {
        this.template = template;
        if (StringUtils.isBlank(defaultName)) {
            this.defaultName = "TEST";
        } else {
            this.defaultName = defaultName;
        }
    }

    protected Result check() throws Exception {
        final String output = String.format(template, defaultName);
        if (!output.contains(defaultName)) {
            return Result.unhealthy("the application is unhealthy");
        }
        return Result.healthy();
    }

}
