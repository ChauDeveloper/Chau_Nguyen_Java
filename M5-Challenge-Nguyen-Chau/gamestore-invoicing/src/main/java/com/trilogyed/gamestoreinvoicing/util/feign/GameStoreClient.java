package com.trilogyed.gamestoreinvoicing.util.feign;

import com.trilogyed.gamestoreinvoicing.model.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@FeignClient(name = "gamestore-catalog")
public interface GameStoreClient {
    //GET AN ITEM INFO
    @RequestMapping(value = "/console/{id}", method = RequestMethod.GET)
    public Item getConsole(@PathVariable("id") long consoleId);

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public Item getGameInfo(@PathVariable("id") long gameId);

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    public Item getTShirt(@PathVariable("id") long tshirtId);


    //UPDATE AN ITEM
    @RequestMapping(value = "/console", method = RequestMethod.PUT)
    public void updateConsole(@RequestBody Item item);
    @RequestMapping(value = "/game", method = RequestMethod.PUT)
    public void updateGame(@RequestBody Item item);
    @RequestMapping(value = "/tshirt", method = RequestMethod.PUT)
    public void updateTShirt(@RequestBody Item item);


}
