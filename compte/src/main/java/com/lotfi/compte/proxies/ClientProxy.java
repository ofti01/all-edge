package com.lotfi.compte.proxies;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name ="client-service")
public interface ClientProxy {

    @LoadBalanced
    public Boolean CheckCinIfExist(String cin);
}
