# DS22-p03-postfix-evaluator-key

# Post Fix Evaluator


## Overview
For this assignment, you will be implementing a Post Fix Evaluator to perform basic arithmetic. This assignment is based off Chapter 3 and Chapter 4 in the Java Software Structures textbook by Lewis & Chase.


### Table of Contents
**[Files to complete](#files-to-complete)**<br>
**[TODO vs TONOTDO](#TODO-vs-TONOTDO)**<br>
**[Part One: Importing the Project](#part-one-importing-the-project)**<br>
**[Part Two: Implementing LinkedStack](#part-two-implementing-linkedstack)**<br>
**[Part Three: Implement Arithmetic Operators](#part-three-implement-arithmetic-operators)**<br>
**[Part Four: Implement a Postfix Arithmetic Evaluator](#part-four-implement-a-postfix-arithmetic-evaluator)**<br>
**[Part Five: Commit Project](#part-five-commit-project)**<br>
**[Bonus: Infix Expression Evaluator](#bonus-infix-expression-evaluator)**<br>
**[Additional Notes: Help for the project](#additional-notes)**<br>

## Files to complete
Each of the files listed here have unit tests associated with them and are required for submission. With the exception of LinkedStack, you are allowed to implement them in anyway you would like. However, keep in mind there are helper classes that should make your job easier.

**stack.LinkedStack<T>** - A Stack data structure that MUST use a Node based structure to allow for unbounded stack size. Note, you may not use the built in List types provided by the Java API. The Node class has been created for you.

**language.arith.SubOperator** - A binary operator for performing subtraction on two integers.
**language.arith.MultOperator** - A binary operator for performing multiplication on two integers
**language.arith.DivOperator** - A binary operator for performing multiplication on two integers
**language.arith.NegateOperator** - A unary operator for performing negation on a single integer

**evaluator.arith.ArithPostFixEvaluator** - An evaluator for simple arithmetic post fix notation...this is the big challenge...maybe

### Test files
In the test folder, you are provided with several JUnit test cases that will help you keep on track while completing this assignment. I recommend you run the tests often and use them as a checklist of things to do next. If you choose to modify these files, proceed with care, but in general you are welcome to add additional tests if you like.

### TODO vs TONOTDO
Several classes / interfaces in this project have been completed for you. The places where you need to provide code are marked with a TODO comment, and the classes / interfaces that you should not modify are marked with a TONOTDO comment.

It is not important that you understand how these classes are implemented but it is important that you understand what these classes offer. In particular, it is highly recommended that you spend some time reading the Javadoc in each of the following:

**stack.StackInterface**<br>
**parser.arith.PostFixParser**<br>
**language.Operator**<br>
**language.Operand**<br>
**language.BinaryOperator**<br>
**evaluator.PostFixEvaluator**<br>


## Part One: Getting Started
First you need to get your GitHub Classroom project into your IDE. So go do that first.

By default, your project should have no compiler errors and contain the following root items:

**src** - The source folder where all code you are submitting must go. You can change anything you want in this folder, you can add new files, etc...<br>
**test** - The test folder where all of the public unit tests are available<br>
**JUnit 5** - A library that is used to run the test programs<br>
**JRE System Library** - This is what allows java to run<br>

If you are missing any of the above or errors are present in the project, seek help immediately so you can get started on the project right away. The project may start with a warning in **evaluator.arith.ArithPostFixEvaluator**, this is okay.

## Part Two: Implementing LinkedStack
You need to implement a basic stack data structure using a linked list data type internally to allow for an unbounded structure. Start by reading the comments in the `StackInterface` interface. It will provide you with some direction on what each method needs to do. Also, it will be helpful to review Chapter 3 to see how a stack works and Chapter 4 to see how to implement a stack using a linked structure.

**Hint:** Much of this will be familiar from our work on the MyLinkedList project.

The test associated with the `LinkedStack` class **stack.LinkedStackTest** are in the test folder. You will want to make sure your implementation passes all of the tests provided. Try and think of additional tests that might trip you up. Did you meet all of the requirements specified by the interface?

## Part Three: Implement Arithmetic Operators
Before you can even attempt to create a postfix evaluator, you will need to define what each of the possible postfix operators do. For this assignment, you are required to support addition, subtraction, multiplication, division and negation of integers. To help facilitate this, you have been provided with an `Operator<T>` interface. Take a moment to review the interface.

Now run the **operator.arith.PlusOperatorTest** test. All of the tests pass! Right? (Please say yes.) Go ahead and open up the `PlusOperator` class and you will see an implementation. Review this implementation then complete the `SubOperator`, `DivOperator`, and `MultOperator` classes. Each time you implement something, be sure to run the associated tests to see how you’re doing.

For the `DivOperator` you will have to override the `setOperand` method to throw an `IllegalStateException` if the denominator is set to 0. After checking for the exception you can call the `setOperand` method from `BinaryOperator` and pass in the appropriate arguments.

These operators all have two operands, but we will also want to implement an operator with one operand. You will need to complete the `UnaryOperator` abstract class, which implements the `Operator` interface, and should look a lot like the `BinaryOperator` abstract class, but simpler (because there is only one operand).

Finally, you will need to implement the unary `NegateOperator` class, which will extend the `UnaryOperator` class. Negation is represented by the ‘!’ and flips the sign of the `Operand`. For example, "5 !" would evaluate to -5, and "-12 !" would evaluate to 12.

## Part Four: Implement a Postfix Arithmetic Evaluator
Now that we have a stack and operators defined, it is time to create an evaluator. Open up the **evaluator.arith.ArithPostFixEvaluator** class and you will see four TODO comments.

Before starting, check out the **evaluator.arith.ArithPostFixEvaluatorTest** class to see examples of how the evaluator is expected to be called and the results that are expected to be returned.

First, you want to initialize the stack you will be using with your implementation.

Second, determine what you will do when you see an `Operand`.

Third, determine what you will do when you see an `Operator`.

Finally, determine what you will return.

## Part Five: Commit Project
When you have finished your solution and are ready to submit, make your final commit and push eveything up to GitHub.


## Bonus: Infix Expression Evaluator

Implement the following algorithm for the evaluation of arithmetic infix expressions.

Each operator has a precedence. The + and - operators have the lowest precedence, * and / have a higher (and equal) precedence, and ^ (which denotes “ raising to a power” in this project) has the highest. For example,

3 * 4 ^ 2 + 5

should mean the same as

(3 * (4  ^ 2)) + 5

with a value of 53.

In you are going to tackle the bonus you will likely need to implement a robust test suite.

### Part One: Write an ExponentOperator class

Write an `ExponentOperatorTest` class similar to that of the of the `PlusOperatorTest` class. Try to think of additional scenarios you would like to test and write test cases for those scenarios.

Implement an `ExponentOperator` class that is similar to your `PlusOperator` class. Think about what the two operands represent and how `performOperation` would work for this class (anyone thinking about Math.pow?).

### Part Two: Write an ArthInFixEvaluatorClass

Write an `ArthInFixEvaluatorTest` class modeled after `ArthPostFixEvaluatorTest` class. Try to think of additional scenarios you would like to test and write test cases for those scenarios.

Implement an `ArthInFixEvaluator` class that is similar to your `ArthPostFixEvaluator` class.

In your algorithm, use two stacks. One stack holds Operands, the other holds Operators. When you encounter a Operand, put it on the Operand stack. When you encounter an Operator, push it on the Operator stack if it has higher precedence than the operator on the top of the stack. Otherwise, pop an Operator off the Operator stack, pops the appropriate number of Operands off the Operand stack, and push the result of the computation on the Operand stack. Repeat until the top of the Operator stack has lower precedence. At the end of the expression, clear the stack in the same way. For example, here is how the expression 3 * 4 ^ 2 + 5 is evaluated:

Expression: 3 * 4 ^ 2 + 5
```

1) Remaining expression: * 4 ^ 2 + 5           Operand stack               Operator stack 
                                                      3 

2) Remaining expression:   4 ^ 2 + 5           Operand stack               Operator stack 
                                                      3                            * 

3) Remaining expression:     ^ 2 + 5           Operand stack               Operator stack  
                                                      4                            *
                                                      3

4) Remaining expression:       2 + 5           Operand stack               Operator stack
                                                      4                            ^
                                                      3                            *  

5) Remaining expression:         + 5           Operand stack               Operator stack
                                                      2                            ^
                                                      4                            *
                                                      3  

6) Remaining expression:         + 5           Operand stack               Operator stack
                                                      16                           *          
                                                      3
 
7) Remaining expression:           5           Operand stack               Operator stack
                                                      48                           +


8) Remaining expression:                       Operand stack               Operator stack
                                                      5                            +
                                                      48
                                        

9) Remaining expression:                       Operand stack               Operator stack
                                                      53
```


## Additional Notes

### Using the ArithPostFixParser

You have been provided with a class for parsing arithmetic postfix expressions. It is not important that you understand how it is implemented but it is important that you understand what the interface provides for you. Read over the comments in the **parser.PostFixParser** interface carefully.

A short example of its use can be found in **parser.arith.ArithPostFixParserExample**

### Collaboration and Resources
This is a solo project, and you should write your own code. That said, feel free to discuss the project with your classmates, with the understanding that there is a difference between helping someone get to a solution and providing someone with your own solution. Of course, copying code from the internet is not the purpose of this project. Read through the book and see if you can piece together the puzzle yourself. I am happy to help.

### Material on Exceptions
For this assignment, you will need to make use of exceptional situations. For a quick reference on how to throw an exception, check out **language.BinaryOperator** this is an abstract class that meets many of the requirements for the **language.Operator** interface. You will notice that its `setOperand` method has several exceptional states and throws the exceptions detailed in the **language.Operator** interface. Also, there is material available in the book in chapter 3 (focus on section 3.6).

### Where is the Driver Class?
If you scan through the provided files, you will notice none of them contain a `main` method. This means that out of the box you can’t actually run your code. Instead, you might want to create your own drivers for testing out your elements. For example, when you implement `MultOperator`, you could write a driver similar to the following:

```java
public static void main(String[] args){
  Operator<Integer> multOp = new MultOperator();
  Operand<Integer> operand0 = new Operand<Integer>(5);
  Operand<Integer> operand1 = new Operand<Integer>(6);
  multOp.setOperand(0, operand0);
  multOp.setOperand(1, operand1);
  Operand<Integer> result = multOp.performOperation();
  System.out.println(result.getValue());
}
```

Consider also writing a driver class that reads in post-fix expressions from the user and calculates them. This might look something like the following:

```java
public static void main(String[] args){

   Scanner s = new Scanner(System.in);
   PostFixEvaluator<Integer> evaluator = new ArithPostFixEvaluator();
   System.out.println(“Welcome to the Post Fix Evaluator 5000 SUX”);
   System.out.println(“Please enter a post fix expression to be evaluated:”);
   String expr = s.nextLine();
   // Sometimes I get an exception… Maybe I should use a try/catch block.
   Integer result = evaluator.evaluate(expr);
   System.out.println(“The expression evaluated to: “ + result);
   // Maybe I could ask user if they want to enter another expression and loop

}
```

### What is this enum Type?
In the `ArithPostFixEvaluator` code I provided for you I wrote a switch statement that has two cases: `OPERAND` and `OPERATOR`. If you decide to dig to see what these are, you will find the following:

```java
	/**
	 * A {@link PostFixParser} can produce different types.
	 * @author jcollard, jddevaug
	 *
	 */
	enum Type {
	
		/**
		 * Indicates that the value being parsed is an {@link Operand}
		 */
		OPERAND,
		
		/**
		 * Indicates that the value being parsed is an {@link Operator} 
		 */
		OPERATOR
	}
```

The `PostFixParser` can produce two different types, `Operators` and `Operands`. This class helps facilitate that information to the user in a more readable (and modular) way than a boolean would. The `nextType` method returns one of these two values indicating which method you should call next in your evaluator.

Luckily, most of this code is written for you so you don’t have to worry too much about it. For more information about enumerated types, check out the following: http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html



