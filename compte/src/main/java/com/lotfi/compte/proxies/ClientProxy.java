package com.lotfi.compte.proxies;

import com.lotfi.compte.dtos.ClientCinDto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name ="client-service")
public interface ClientProxy {

    @PostMapping(value = "/check")
    public Boolean CheckCinIfExist(ClientCinDto clientCinDto);
}
