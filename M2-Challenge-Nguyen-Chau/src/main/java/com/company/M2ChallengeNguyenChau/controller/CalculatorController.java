package com.company.M2ChallengeNguyenChau.controller;

import com.company.M2ChallengeNguyenChau.model.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CalculatorController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution add(@RequestBody @Valid MathSolution plus){
        int a = plus.getOperand1();
        int b = plus.getOperand2();
        plus.setAnswer(a+b);
        plus.setOperation("add");
        return plus;
    }


    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtract(@RequestBody MathSolution subtract) {
        if (subtract.getOperand1() == 0 || subtract.getOperand2() == 0) {
            throw new IllegalArgumentException("Must enter an integer value for both operand1 and operand2");
        } else {
            int a = subtract.getOperand1();
            int b = subtract.getOperand2();
            subtract.setAnswer(a - b);
            subtract.setOperation("subtract");
            return subtract;
        }
    }


    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiply(@RequestBody MathSolution multiply) {
        if (multiply.getOperand1() == 0 || multiply.getOperand2() == 0) {
            throw new IllegalArgumentException("Must enter an integer value for both operand1 and operand2");
        } else {
            int a = multiply.getOperand1();
            int b = multiply.getOperand2();
            multiply.setAnswer(a*b);
            multiply.setOperation("multiply");
            return multiply;
        }
    }


    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divide(@RequestBody MathSolution divide) {
        if (divide.getOperand1() == 0 || divide.getOperand2() == 0) {
            throw new IllegalArgumentException("Must enter an integer value for both operand1 and operand2");
        } else {
            int a = divide.getOperand1();
            int b = divide.getOperand2();
            divide.setAnswer(a/b);
            divide.setOperation("divide");
            return divide;
        }
    }



}
