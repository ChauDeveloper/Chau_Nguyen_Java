# Challenge 2 Java Bootcamp
## User Stories
- As an API user, I would like to convert the number of any month to its corresponding text, e.g. "1" = "January".
- As an API user, I would like to be able to request a randomly selected month.
- As an API user, I would like to be able to add two numbers and receive back the result.
- As an API user, I would like to be able to subtract two numbers and receive back the result.
- As an API user, I would like to be able to multiply two numbers and receive back the result.
- As an API user, I would like to be able to divide two numbers and receive back the result.
</br></br>
## Goals
- REST API must accept and return data in JSON format where appropriate.
- Every endpoint must have at least one MockMVC test. Endpoints that have error conditions must also contain a MockMVC test for each kind of error.
- The REST API must be documented with Swagger. Save the .yaml file in the root of your project directory.
</br></br>
## Project Endpoints
### Month Converter:
	◦	URI: /month/{monthNumber}
	◦	HTTP Method: GET
	◦	Request Body: None
	◦	Response Body: A Month object containing the name and number of the requested month (1—January, 2—February, etc.)
	◦	Error: 422, if the input is out of range
### Random Month:
    ◦	URI: /randomMonth
	◦	HTTP Method: GET
	◦	Request Body: None
	◦	Response Body: A Month object containing a randomly selected month
### Add
    ◦	URI: /add
	◦	HTTP Method: POST
	◦	Request Body: JSON object with operand1 and operand2
	◦	Response Body: MathSolution, where answer is sum of operand1 and operand2
	◦	Error: 422, if missing operand or if operands are not both numbers
### Subtract
    ◦	URI: /subtract
	◦	HTTP Method: POST
	◦	Request Body: JSON object with operand1 and operand2
	◦	Response Body: MathSolution, where answer is difference of operand1 and operand2 (operand1 – operand2)
	◦	Error: 422, if missing operand or if operands are not both numbers
### Multiply:
    ◦	URI: /multiply
	◦	HTTP Method: POST
	◦	Request Body: JSON object with operand1 and operand2
	◦	Response Body: MathSolution, where answer is product of operand1 and operand2
	◦	Error: 422, if missing operand or if operands are not both numbers
### Divide:
    ◦	URI: /divide
	◦	HTTP Method: POST
	◦	Request Body: JSON object with operand1 and operand2
	◦	Response Body: MathSolution, where answer is quotient of operand1 and operand2 (operand1/operand2)
	◦	Error: 422, if missing operand or if operands are not both numbers, or if operand2 is zero