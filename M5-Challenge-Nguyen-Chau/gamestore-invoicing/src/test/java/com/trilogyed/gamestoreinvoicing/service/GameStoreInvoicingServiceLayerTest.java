package com.trilogyed.gamestoreinvoicing.service;

import com.trilogyed.gamestoreinvoicing.repository.*;
import com.trilogyed.gamestoreinvoicing.model.*;

import com.trilogyed.gamestoreinvoicing.util.feign.GameStoreClient;
import com.trilogyed.gamestoreinvoicing.viewModel.InvoiceViewModel;

import com.trilogyed.gamestoreinvoicing.viewModel.ItemViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class GameStoreInvoicingServiceLayerTest {


    InvoiceRepository invoiceRepository;
    ProcessingFeeRepository processingFeeRepository;
    TaxRepository taxRepository;
    GameStoreInvoicingServiceLayer service;
    ItemViewModel item;
    ItemViewModel itemReturned;

    GameStoreClient client;

    @Before
    public void setUp() throws Exception {
        item = new ItemViewModel();
        itemReturned = new ItemViewModel();
        client = new GameStoreClient(){

            @Override
            public ItemViewModel getConsole(long consoleId) {
                itemReturned.setId(1);
                itemReturned.setQuantity(5);
                itemReturned.setPrice(new BigDecimal("299.99"));
                itemReturned.setDescription("");
                itemReturned.setModel("Xbox");
                itemReturned.setManufacturer("Xbox");
                itemReturned.setTitle("");
                itemReturned.setColor("");
                return itemReturned;
            }

            @Override
            public ItemViewModel getGame(long gameId) {
                itemReturned.setId(1);
                itemReturned.setQuantity(5);
                itemReturned.setPrice(new BigDecimal("52.99"));
                itemReturned.setDescription("puzzle game");
                itemReturned.setModel("");
                itemReturned.setManufacturer("");
                itemReturned.setTitle("Candy Crush");
                itemReturned.setColor("");
                return itemReturned;
            }

            @Override
            public ItemViewModel getTShirt(long tshirtId) {
                itemReturned.setId(1);
                itemReturned.setQuantity(5);
                itemReturned.setPrice(new BigDecimal("12.99"));
                itemReturned.setDescription("disco");
                itemReturned.setModel("");
                itemReturned.setManufacturer("");
                itemReturned.setTitle("");
                itemReturned.setColor("grey");
                return null;
            }

            @Override
            public void updateConsoleQuantity(Item item) {

            }

            @Override
            public void updateGameQuantity(Item item) {

            }

            @Override
            public void updateTShirtQuantity(Item item) {

            }
        };

        setUpInvoiceRepositoryMock();
        setUpProcessingFeeRepositoryMock();
        setUpTaxRepositoryMock();

        service = new GameStoreInvoicingServiceLayer(invoiceRepository, taxRepository, processingFeeRepository);
    }

    //Testing Invoice Operations...
    @Test
    public void shouldCreateFindInvoice() {
        item.setColor("Blue");
        item.setDescription("V-Neck");
        item.setPrice(new BigDecimal("19.99"));
        item.setQuantity(5);
        item.setId(54);
//        tShirt = service.create(tShirt);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName("John Jake");
        invoiceViewModel.setStreet("street");
        invoiceViewModel.setCity("Charlotte");
        invoiceViewModel.setState("NC");
        invoiceViewModel.setZipcode("83749");
        invoiceViewModel.setItemType("T-Shirt");
        invoiceViewModel.setItemId(54);
        invoiceViewModel.setQuantity(2);

        invoiceViewModel = service.createInvoice(invoiceViewModel);

        InvoiceViewModel ivmfromService = service.getInvoice(invoiceViewModel.getId());

        assertEquals(invoiceViewModel, ivmfromService);
    }

    @Test
    public void shouldFindAllInvoices(){
        InvoiceViewModel savedInvoice1 = new InvoiceViewModel();
        savedInvoice1.setName("Sandy Beach");
        savedInvoice1.setStreet("123 Main St");
        savedInvoice1.setCity("any City");
        savedInvoice1.setState("NY");
        savedInvoice1.setZipcode("10016");
        savedInvoice1.setItemType("T-Shirt");
        savedInvoice1.setItemId(12);//pretending item exists with this id...
        savedInvoice1.setUnitPrice(new BigDecimal("12.50"));//pretending item exists with this price...
        savedInvoice1.setQuantity(2);
        savedInvoice1.setSubtotal(savedInvoice1.getUnitPrice().multiply(new BigDecimal(savedInvoice1.getQuantity())));
        savedInvoice1.setTax(savedInvoice1.getSubtotal().multiply(new BigDecimal("0.06")));
        savedInvoice1.setProcessingFee(new BigDecimal("10.00"));
        savedInvoice1.setTotal(savedInvoice1.getSubtotal().add(savedInvoice1.getTax()).add(savedInvoice1.getProcessingFee()));
        savedInvoice1.setId(22);

        InvoiceViewModel savedInvoice2 = new InvoiceViewModel();
        savedInvoice2.setName("Rob Bank");
        savedInvoice2.setStreet("888 Main St");
        savedInvoice2.setCity("any town");
        savedInvoice2.setState("NJ");
        savedInvoice2.setZipcode("08234");
        savedInvoice2.setItemType("Console");
        savedInvoice2.setItemId(120);//pretending item exists with this id...
        savedInvoice2.setUnitPrice(new BigDecimal("129.50"));//pretending item exists with this price...
        savedInvoice2.setQuantity(1);
        savedInvoice2.setSubtotal(savedInvoice2.getUnitPrice().multiply(new BigDecimal(savedInvoice2.getQuantity())));
        savedInvoice2.setTax(savedInvoice2.getSubtotal().multiply(new BigDecimal("0.08")));
        savedInvoice2.setProcessingFee(new BigDecimal("10.00"));
        savedInvoice2.setTotal(savedInvoice2.getSubtotal().add(savedInvoice2.getTax()).add(savedInvoice2.getProcessingFee()));
        savedInvoice2.setId(12);

        InvoiceViewModel savedInvoice3 = new InvoiceViewModel();
        savedInvoice3.setName("Sandy Beach");
        savedInvoice3.setStreet("123 Broad St");
        savedInvoice3.setCity("any where");
        savedInvoice3.setState("CA");
        savedInvoice3.setZipcode("90016");
        savedInvoice3.setItemType("Game");
        savedInvoice3.setItemId(19);//pretending item exists with this id...
        savedInvoice3.setUnitPrice(new BigDecimal("12.50"));//pretending item exists with this price...
        savedInvoice3.setQuantity(4);
        savedInvoice3.setSubtotal(savedInvoice3.getUnitPrice().multiply(new BigDecimal(savedInvoice3.getQuantity())));
        savedInvoice3.setTax(savedInvoice3.getSubtotal().multiply(new BigDecimal("0.09")));
        savedInvoice3.setProcessingFee(BigDecimal.ZERO);
        savedInvoice3.setTotal(savedInvoice3.getSubtotal().add(savedInvoice3.getTax()).add(savedInvoice3.getProcessingFee()));
        savedInvoice3.setId(73);

        List<InvoiceViewModel> currInvoices = new ArrayList<>();
        currInvoices.add(savedInvoice1);
        currInvoices.add(savedInvoice2);
        currInvoices.add(savedInvoice3);

        List<InvoiceViewModel> foundAllInvoices = service.getAllInvoices();

        assertEquals(currInvoices.size(), foundAllInvoices.size());
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldFailCreateFindInvoiceWithBadState() {

        item.setId(99);
        item.setColor("Red");
        item.setDescription("sleeveless");
        item.setPrice(new BigDecimal("400"));
        item.setQuantity(30);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName("John Jake");
        invoiceViewModel.setStreet("street");
        invoiceViewModel.setCity("Charlotte");
        invoiceViewModel.setState("NY");
        invoiceViewModel.setZipcode("83749");
        invoiceViewModel.setItemType("T-Shirt");
        invoiceViewModel.setItemId(99);
        invoiceViewModel.setQuantity(2);

        invoiceViewModel = service.createInvoice(invoiceViewModel);

        InvoiceViewModel ivmfromService = service.getInvoice(invoiceViewModel.getId());

        assertEquals(invoiceViewModel, ivmfromService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailCreateFindInvoiceWithBadItemType() {
        item.setColor("Blue");
        item.setDescription("V-Neck");
        item.setPrice(new BigDecimal("19.99"));
        item.setQuantity(5);
//        item = service.createTShirt(tShirt);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName("John Jake");
        invoiceViewModel.setStreet("street");
        invoiceViewModel.setCity("Charlotte");
        invoiceViewModel.setState("NC");
        invoiceViewModel.setZipcode("83749");
        invoiceViewModel.setItemType("Bad Item Type");
        invoiceViewModel.setItemId(54);
        invoiceViewModel.setQuantity(2);

        invoiceViewModel = service.createInvoice(invoiceViewModel);

        InvoiceViewModel ivmfromService = service.getInvoice(invoiceViewModel.getId());

        assertEquals(invoiceViewModel, ivmfromService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailCreateFindInvoiceWithNoInventory() {
        item.setColor("Blue");
        item.setDescription("V-Neck");
        item.setPrice(new BigDecimal("19.99"));
        item.setQuantity(5);
//        item = service.createTShirt(tShirt);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName("John Jake");
        invoiceViewModel.setStreet("street");
        invoiceViewModel.setCity("Charlotte");
        invoiceViewModel.setState("NC");
        invoiceViewModel.setZipcode("83749");
        invoiceViewModel.setItemType("T-Shirt");
        invoiceViewModel.setItemId(54);
        invoiceViewModel.setQuantity(6);

        invoiceViewModel = service.createInvoice(invoiceViewModel);

        InvoiceViewModel ivmfromService = service.getInvoice(invoiceViewModel.getId());

        assertEquals(invoiceViewModel, ivmfromService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenCreateInvoiceInvalidItem() {
        item.setColor("Blue");
        item.setDescription("V-Neck");
        item.setPrice(new BigDecimal("19.99"));
        item.setQuantity(5);


        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName("John Jake");
        invoiceViewModel.setStreet("street");
        invoiceViewModel.setCity("Charlotte");
        invoiceViewModel.setState("NC");
        invoiceViewModel.setZipcode("83749");
        invoiceViewModel.setItemType("nothing");
        invoiceViewModel.setItemId(54);
        invoiceViewModel.setQuantity(2);

        invoiceViewModel = service.createInvoice(invoiceViewModel);

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailWhenCreateInvoiceInvalidQuantity() {
        item.setColor("Blue");
        item.setDescription("V-Neck");
        item.setPrice(new BigDecimal("19.99"));
        item.setQuantity(5);
//        item = service.createTShirt(tShirt);

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setName("John Jake");
        invoiceViewModel.setStreet("street");
        invoiceViewModel.setCity("Charlotte");
        invoiceViewModel.setState("NC");
        invoiceViewModel.setZipcode("83749");
        invoiceViewModel.setItemType("T-Shirt");
        invoiceViewModel.setItemId(54);
        invoiceViewModel.setQuantity(0);

        invoiceViewModel = service.createInvoice(invoiceViewModel);
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailWhenCreateInvoiceInvalidInvoiceMV() {
        item.setColor("Blue");
        item.setDescription("V-Neck");
        item.setPrice(new BigDecimal("19.99"));
        item.setQuantity(5);
//        item = service.createTShirt(tShirt);

        InvoiceViewModel invoiceViewModel = null;

        invoiceViewModel = service.createInvoice(invoiceViewModel);
    }

    //Testing Console Operations...
    @Test
    public void shouldGetAConsole() {
        item.setModel("Playstation");
        item.setManufacturer("Sony");
        item.setPrice(new BigDecimal("299.99"));
        item.setQuantity(4);
//        item = service.createConsole(console);

        ItemViewModel console1 = service.getConsole(item.getId());
        assertEquals(item, console1);
    }


    @Test
    public void shouldUpdateItemQuantity() {
        Item updatedItem = new Item();
        updatedItem.setId(1);
        updatedItem.setQuantity(5);

        service.updateConsoleQuantity(updatedItem);
        service.updateGameQuantity(updatedItem);
        service.updateTShirtQuantity(updatedItem);

        assertEquals(updatedItem.getQuantity() , client.getConsole(1).getQuantity());
        assertEquals(updatedItem.getQuantity() , client.getGame(1).getQuantity());
        assertEquals(updatedItem.getQuantity() , client.getTShirt(1).getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailUpdateCatalogWithNullView() {
        Item item = null;

        service.updateConsoleQuantity(item);
        service.updateGameQuantity(item);
        service.updateTShirtQuantity(item);
    }

    private void setUpInvoiceRepositoryMock() {
        invoiceRepository = mock(InvoiceRepository.class);

        Invoice invoice = new Invoice();
        invoice.setName("John Jake");
        invoice.setStreet("street");
        invoice.setCity("Charlotte");
        invoice.setState("NC");
        invoice.setZipcode("83749");
        invoice.setItemType("T-Shirt");
        invoice.setItemId(54);
        invoice.setUnitPrice(new BigDecimal("19.99"));
        invoice.setQuantity(2);
        invoice.setSubtotal(new BigDecimal("39.98"));
        invoice.setTax(new BigDecimal("2"));
        invoice.setProcessingFee(new BigDecimal("1.98"));
        invoice.setTotal(new BigDecimal("43.96"));

        Invoice invoice1 = new Invoice();
        invoice1.setId(20);
        invoice1.setName("John Jake");
        invoice1.setStreet("street");
        invoice1.setCity("Charlotte");
        invoice1.setState("NC");
        invoice1.setZipcode("83749");
        invoice1.setItemType("T-Shirt");
        invoice1.setItemId(54);
        invoice1.setUnitPrice(new BigDecimal("19.99"));
        invoice1.setQuantity(2);
        invoice1.setSubtotal(new BigDecimal("39.98"));
        invoice1.setTax(new BigDecimal("2"));
        invoice1.setProcessingFee(new BigDecimal("1.98"));
        invoice1.setTotal(new BigDecimal("43.96"));

        doReturn(invoice1).when(invoiceRepository).save(invoice);
        doReturn(Optional.of(invoice1)).when(invoiceRepository).findById(20L);

        //Get All...
        Invoice savedInvoice1 = new Invoice();
        savedInvoice1.setName("Sandy Beach");
        savedInvoice1.setStreet("123 Main St");
        savedInvoice1.setCity("any City");
        savedInvoice1.setState("NY");
        savedInvoice1.setZipcode("10016");
        savedInvoice1.setItemType("T-Shirt");
        savedInvoice1.setItemId(12);//pretending item exists with this id...
        savedInvoice1.setUnitPrice(new BigDecimal("12.50"));//pretending item exists with this price...
        savedInvoice1.setQuantity(2);
        savedInvoice1.setSubtotal(savedInvoice1.getUnitPrice().multiply(new BigDecimal(savedInvoice1.getQuantity())));
        savedInvoice1.setTax(savedInvoice1.getSubtotal().multiply(new BigDecimal("0.06")));
        savedInvoice1.setProcessingFee(new BigDecimal("10.00"));
        savedInvoice1.setTotal(savedInvoice1.getSubtotal().add(savedInvoice1.getTax()).add(savedInvoice1.getProcessingFee()));
        savedInvoice1.setId(22);

        Invoice savedInvoice2 = new Invoice();
        savedInvoice2.setName("Rob Bank");
        savedInvoice2.setStreet("888 Main St");
        savedInvoice2.setCity("any town");
        savedInvoice2.setState("NJ");
        savedInvoice2.setZipcode("08234");
        savedInvoice2.setItemType("Console");
        savedInvoice2.setItemId(120);//pretending item exists with this id...
        savedInvoice2.setUnitPrice(new BigDecimal("129.50"));//pretending item exists with this price...
        savedInvoice2.setQuantity(1);
        savedInvoice2.setSubtotal(savedInvoice2.getUnitPrice().multiply(new BigDecimal(savedInvoice2.getQuantity())));
        savedInvoice2.setTax(savedInvoice2.getSubtotal().multiply(new BigDecimal("0.08")));
        savedInvoice2.setProcessingFee(new BigDecimal("10.00"));
        savedInvoice2.setTotal(savedInvoice2.getSubtotal().add(savedInvoice2.getTax()).add(savedInvoice2.getProcessingFee()));
        savedInvoice2.setId(12);

        Invoice savedInvoice3 = new Invoice();
        savedInvoice3.setName("Sandy Beach");
        savedInvoice3.setStreet("123 Broad St");
        savedInvoice3.setCity("any where");
        savedInvoice3.setState("CA");
        savedInvoice3.setZipcode("90016");
        savedInvoice3.setItemType("Game");
        savedInvoice3.setItemId(19);//pretending item exists with this id...
        savedInvoice3.setUnitPrice(new BigDecimal("12.50"));//pretending item exists with this price...
        savedInvoice3.setQuantity(4);
        savedInvoice3.setSubtotal(savedInvoice3.getUnitPrice().multiply(new BigDecimal(savedInvoice3.getQuantity())));
        savedInvoice3.setTax(savedInvoice3.getSubtotal().multiply(new BigDecimal("0.09")));
        savedInvoice3.setProcessingFee(BigDecimal.ZERO);
        savedInvoice3.setTotal(savedInvoice3.getSubtotal().add(savedInvoice3.getTax()).add(savedInvoice3.getProcessingFee()));
        savedInvoice3.setId(73);

        List<Invoice> allList = new ArrayList<>();
        allList.add(savedInvoice1);
        allList.add(savedInvoice2);
        allList.add(savedInvoice3);

        doReturn(allList).when(invoiceRepository).findAll();
    }

    private void setUpProcessingFeeRepositoryMock() {

        processingFeeRepository = mock(ProcessingFeeRepository.class);

        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setFee(new BigDecimal("1.98"));
        processingFee.setProductType("T-Shirt");

        doReturn(Optional.of(processingFee)).when(processingFeeRepository).findById("T-Shirt");

    }

    private void setUpTaxRepositoryMock() {
        taxRepository = mock(TaxRepository.class);

        Tax taxNC = new Tax();
        taxNC.setRate(new BigDecimal(".05"));
        taxNC.setState("NC");

        Tax taxNY = new Tax();
        taxNY.setRate(BigDecimal.ZERO);
        taxNY.setState("NY");

        doReturn(Optional.of(taxNC)).when(taxRepository).findById("NC");
        doReturn(Optional.of(taxNY)).when(taxRepository).findById("NY");

    }


}