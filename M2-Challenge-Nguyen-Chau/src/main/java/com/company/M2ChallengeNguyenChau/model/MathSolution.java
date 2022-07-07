package com.company.M2ChallengeNguyenChau.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class MathSolution {
    @NotEmpty(message = "Must enter an integer value for both operand1")
    private int operand1;
    @NotEmpty(message = "Must enter an integer value for both operand1")
    private int operand2;
    private String operation;
    private int answer;

    public MathSolution(int operand1, int operand2, String operation, int answer) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
        this.answer = answer;
    }

    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathSolution that = (MathSolution) o;
        return operand1 == that.operand1 && operand2 == that.operand2 && answer == that.answer && Objects.equals(operation, that.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand1, operand2, operation, answer);
    }

    @Override
    public String toString() {
        return "MathSolution{" +
                "operand1=" + operand1 +
                ", operand2=" + operand2 +
                ", operation='" + operation + '\'' +
                ", answer=" + answer +
                '}';
    }
}
