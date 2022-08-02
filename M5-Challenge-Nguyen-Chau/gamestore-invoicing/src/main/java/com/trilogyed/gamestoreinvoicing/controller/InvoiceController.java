package com.trilogyed.gamestoreinvoicing.controller;

import com.trilogyed.gamestoreinvoicing.model.Item;
import com.trilogyed.gamestoreinvoicing.service.GameStoreInvoicingServiceLayer;
import com.trilogyed.gamestoreinvoicing.util.feign.GameStoreClient;
import com.trilogyed.gamestoreinvoicing.viewModel.InvoiceViewModel;
import com.trilogyed.gamestoreinvoicing.viewModel.ItemViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
@CrossOrigin(origins = {"http://localhost:3000"})
public class InvoiceController {
    @Autowired
    GameStoreInvoicingServiceLayer service;

    // Assumption: All orders are final and data privacy is not top priority. Therefore, the Update & Delete EndPoints
    // are left out by design due to its potential danger. The getAllInvoices is a questionable one since it could
    // overwhelm the system and infringes on data privacy; however, it does not damage data as with the Update and Delete

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel purchaseItem(@RequestBody @Valid InvoiceViewModel invoiceViewModel) {
        invoiceViewModel = service.createInvoice(invoiceViewModel);
        return invoiceViewModel;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel findInvoice(@PathVariable("id") long invoiceId) {
        InvoiceViewModel invoiceViewModel = service.getInvoice(invoiceId);
        if (invoiceViewModel == null) {
            throw new IllegalArgumentException("Invoice could not be retrieved for id " + invoiceId);
        } else {
            return invoiceViewModel;
        }
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> findAllInvoices() {
        List<InvoiceViewModel> invoiceViewModelList = service.getAllInvoices();

        if (invoiceViewModelList == null || invoiceViewModelList.isEmpty()) {
            throw new IllegalArgumentException("No invoices were found.");
        } else {
            return invoiceViewModelList;
        }
    }

    @GetMapping("/cname/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> findInvoicesByCustomerName(@PathVariable String name) {
        List<InvoiceViewModel> invoiceViewModelList = service.getInvoicesByCustomerName(name);

        if (invoiceViewModelList == null || invoiceViewModelList.isEmpty()) {
            throw new IllegalArgumentException("No invoices were found for: "+name);
        } else {
            return invoiceViewModelList;
        }
    }

    //Feign request logics
    //Review item information
    @RequestMapping(value="/console/{id}", method = RequestMethod.GET)
    public ItemViewModel getConsole(@PathVariable("id") long consoleId) {
        return service.getConsole(consoleId);
    }

    @RequestMapping(value="/game/{id}", method = RequestMethod.GET)
    public ItemViewModel getGame(@PathVariable("id") long gameId) {
        return service.getGame(gameId);
    }

    @RequestMapping(value="/tshirt/{id}", method = RequestMethod.GET)
    public ItemViewModel getTShirt(@PathVariable("id") long tshirtId) {
        return service.getTShirt(tshirtId);
    }

    //Update item quantity by inputting item id and quantity amount
    @RequestMapping(value = "/console/updatequantity", method = RequestMethod.PUT)
    public void updateConsoleQuantity(@RequestBody Item item){ service.updateConsoleQuantity(item);};
    @RequestMapping(value = "/game/updatequantity", method = RequestMethod.PUT)
    public void updateGameQuantity(@RequestBody Item item){ service.updateGameQuantity(item);};
    @RequestMapping(value = "/tshirt/updatequantity", method = RequestMethod.PUT)
    public void updateTShirtQuantity(@RequestBody Item item){ service.updateTShirtQuantity(item);};

}
