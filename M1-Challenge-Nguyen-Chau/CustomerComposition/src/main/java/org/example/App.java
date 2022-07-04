package org.example;

public class App {
    public static void main(String[] args) {
        Customer test = new Customer("Chau", "Nguyen", "chaudeveloper@gmail.com", "4075672467",true);

        Address testBillingAddress = new
                Address("123 Test Street", "apt 2433", "Orlando", "FL", 33896);
        Address testShippingAddress = new
                Address("434 Another Test Street", "lot 23", "Des Moines", "WA", 99855);
        test.setBillingAddress(testBillingAddress);
        test.setShippingAddress(testShippingAddress);
        System.out.println(test.toString());
    };
}
