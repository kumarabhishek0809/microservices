package com.zull.proxy.filter;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("TOKEN-SERVICE")
public interface TokenService {
}
