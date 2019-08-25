package com.person.client.person.ribbon;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

/**
 * @author ：周美华
 * @date ：Created in 2019/8/18 23:46
 * @description：
 * @modified By：
 */
public class MyRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        //获取server
        ILoadBalancer loadBalancer = getLoadBalancer();
         return loadBalancer.getAllServers().get(0);
    }
}
