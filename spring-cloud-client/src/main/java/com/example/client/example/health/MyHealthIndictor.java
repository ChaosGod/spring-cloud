package com.example.client.example.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

/**
 * @author ：周美华
 * @date ：Created in 2019/7/14 22:27
 * @description：
 * @modified By：
 */
public class MyHealthIndictor extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {

        builder.up().withDetail("Myhealth",

                "DAY DAY UP"
                );
    }
}
