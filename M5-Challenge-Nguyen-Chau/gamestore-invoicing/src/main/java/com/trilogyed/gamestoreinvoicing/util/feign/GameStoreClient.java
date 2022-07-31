package com.trilogyed.gamestoreinvoicing.util.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gamestore-catalog")
public interface GameStoreClient {
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String getRandomQuote();
}
