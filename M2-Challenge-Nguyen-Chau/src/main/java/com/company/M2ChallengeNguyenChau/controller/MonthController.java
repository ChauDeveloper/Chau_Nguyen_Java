package com.company.M2ChallengeNguyenChau.controller;

import com.company.M2ChallengeNguyenChau.model.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
public class MonthController {
    List<Month> months = new ArrayList<>(Arrays.asList(
            new Month("January", 1),
            new Month("February", 2),
            new Month("March", 3),
            new Month("April", 4),
            new Month("May", 5),
            new Month("June", 6),
            new Month("July", 7),
            new Month("August", 8),
            new Month("September", 9),
            new Month("October", 10),
            new Month("November", 11),
            new Month("December", 12)
    ));

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Month convertMonth(@PathVariable int monthNumber){
        for(Month month:months) {
            if(month.getNumber() == monthNumber) {
                return month;
            }
        }
        throw new IllegalArgumentException("Please only use number 1-12");
    }

    @RequestMapping(value = "/randomMonth", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Month randomMonth(){
        Random randomNumberGenerator = new Random();
        // generate a random integer
        int randomNumber = randomNumberGenerator.nextInt(months.size());
        return months.get(randomNumber);
    }
}
