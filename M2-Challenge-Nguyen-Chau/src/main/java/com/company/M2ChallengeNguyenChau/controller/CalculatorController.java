package com.company.M2ChallengeNguyenChau.controller;

import com.company.M2ChallengeNguyenChau.exception.IllegalArgumentException;
import com.company.M2ChallengeNguyenChau.model.MathSolution;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.http.HttpStatus;

import org.apache.commons.lang3.math.NumberUtils;
//import org.springframework.util.NumberUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CalculatorController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution add(@RequestBody @Valid MathSolution plus){
            int a = Integer.parseInt(plus.getOperand1());
            int b = Integer.parseInt(plus.getOperand2());
            plus.setAnswer(a+b);
            plus.setOperation("add");
        return plus;
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtract(@RequestBody @Valid MathSolution minus){
        int a = Integer.parseInt(minus.getOperand1());
        int b = Integer.parseInt(minus.getOperand2());
        minus.setAnswer(a-b);
        minus.setOperation("subtract");
        return minus;
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiply(@RequestBody @Valid MathSolution multiply){
        int a = Integer.parseInt(multiply.getOperand1());
        int b = Integer.parseInt(multiply.getOperand2());
        multiply.setAnswer(a*b);
        multiply.setOperation("multiply");
        return multiply;
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divide(@RequestBody @Valid MathSolution division){
        int a = Integer.parseInt(division.getOperand1());
        int b = Integer.parseInt(division.getOperand2());
        if (b == 0) {
            throw new IllegalArgumentException("operand2 cannot be 0");
        }
        division.setAnswer(a/b);
        division.setOperation("divide");
        return division;
    }
}
