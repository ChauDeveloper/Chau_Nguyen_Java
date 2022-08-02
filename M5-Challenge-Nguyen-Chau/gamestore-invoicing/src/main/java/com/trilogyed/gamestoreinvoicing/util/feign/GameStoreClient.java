package com.trilogyed.gamestoreinvoicing.util.feign;

import com.trilogyed.gamestoreinvoicing.model.Item;
import com.trilogyed.gamestoreinvoicing.viewModel.ItemViewModel;
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
    public ItemViewModel getConsole(@PathVariable("id") long consoleId);

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET)
    public ItemViewModel getGame(@PathVariable("id") long gameId);

    @RequestMapping(value = "/tshirt/{id}", method = RequestMethod.GET)
    public ItemViewModel getTShirt(@PathVariable("id") long tshirtId);


    //UPDATE AN ITEM'S QUANTITY
    @RequestMapping(value = "/console/updatequantity", method = RequestMethod.PUT)
    public void updateConsoleQuantity(@RequestBody Item item);
    @RequestMapping(value = "/game/updatequantity", method = RequestMethod.PUT)
    public void updateGameQuantity(@RequestBody Item item);
    @RequestMapping(value = "/tshirt/updatequantity", method = RequestMethod.PUT)
    public void updateTShirtQuantity(@RequestBody Item item);


}
