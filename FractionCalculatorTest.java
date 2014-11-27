import java.util.Scanner;

/**
 * Created by devon on 23/11/2014.
 */
public class FractionCalculatorTest {

    public static FractionCalculator fr1;
    public static FractionCalculator fr2;
    public static FractionCalculator fr3;
    public static FractionCalculator fr4;

    public static int f1; //integer variables for fraction objects
    public static int f1_;
    public static int f2;
    public static int f2_;
    public static int f3;
    public static int f3_;

    public static String data;// typed string from user


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        String b, b3, b4, b6, b7, b8;
        String fra1, fra1_, fra2, fra2_, fra3, fra3_; // parsed string variables into integers: numerators and denominators for all 3 fractions
        String op1; // operator applied to the first two fractions
        String op2; // operator applied to the last fraction, the 3rd

        FractionCalculator g = new FractionCalculator(1,2);
        FractionCalculator h = new FractionCalculator(4,2);
        FractionCalculator i = new FractionCalculator(8,3);

        FractionCalculator j = new FractionCalculator(2,3);
        FractionCalculator k = new FractionCalculator(5,6);
        FractionCalculator l = new FractionCalculator(0,0);// FractionCalculator's set to zero. an invalid fraction error message with denominator with zero should be display

        FractionCalculator m = new FractionCalculator(-2,-2);
        FractionCalculator n = new FractionCalculator(1,8);

        FractionCalculator p = new FractionCalculator(21,0);
        FractionCalculator o = new FractionCalculator( 10,10);
        FractionCalculator q = new FractionCalculator( 10,2);
        FractionCalculator r = new FractionCalculator( 10,1);
        FractionCalculator s = new FractionCalculator( 10,7);

        String test1 = "1/2 / 4/2 * 8/3";
        String test2 = "1/2 + 2/3 * 1/2";
        String test3 = "2/3 * 2/1 + 1/2";
        String test4 = "10/10 - 10/2 - 10/1";



        // the if statements below check if the values of the fraction objects get passed successfully within the
        // FractionCalculator and if the if statements and methods correctly calculated the sum and called methods.
        // the call to the evaluate function below test if the string is correctly in fraction objects and the right
        // operators applied in relation to order of operation.

        g.divide(h).multiply(l);// multiplying with zero. A error message should be displayed because it
                                // is invalid for the denominator to be zero.


        System.out.println("Test 1: "+ g.evaluate(g, test1));// test should equal  2/3 and
        if (!j.equals(g.divide(h).multiply(i)))
        {System.out.println("test failed, used operators: divide and multiply");}// same equation as the first but
        // with passed fraction values as arguments test should equal  2/3.




        System.out.println("Test 2 "+ g.evaluate(g, test2));// test should equal 5/6. Tests if order of operation is
        // correctly followed in that the sum equals the correct value. if the case return a true value.

        if (!k.equals(k.absValue(k)))
        {System.out.println(" Absolute value test failed");}
        //Current value in calculator 5/6. Test fails if absolute value does not equal 5/6.

        System.out.println("Test 3: " + g.evaluate(g, test3));
        if (! k.equals(j.multiply(g).add(g))) {System.out.println(" test failed, used operators: add and multiply");}
        // same equation as the previous passed argument as a string within the method but with fraction objects
        // and it's values as arguments. test should also equal 2/3.



        if (!n.equals(g.multiply(g).multiply(g)))
        {System.out.println(" Multiply test failed ");}// tests if the 3 operands multiplied give the correct value.


        System.out.println("Test 4:  "+ g.evaluate(g, test4));// tests the divide operator on the fractions and that the result of the sum is correct.
        if (!s.equals(o.divide(q).divide(r))){System.out.println(" divide test failed ");}
        System.out.println(o.divide(q).divide(r));






























        System.out.println("                       Welcome to Devon Mullings's fraction Calculator");
        System.out.println();

        System.out.println("              This calculator takes in 3 fractions and inputs the result of the sum ");
        System.out.println("                            The sums are worked out in order of operation");
        System.out.println("                                  Please input your equation: ");







         data = input.nextLine();
        while (!data.contains("quit") || !data.equals("q")) {


            b = data.substring(0, data.indexOf(" ")); // inputted string spilt to store first fraction
            op1 = data.substring(b.length() + 1, b.length() + 2);//  stores the string for the first operator
            op2 = data.substring(b.length() + 3, data.lastIndexOf("/"));// string contains the second operator and second fraction
            b8 =  data.substring(data.lastIndexOf(" "));// spilt string stores last fraction
            b4 =  data.substring(op2.length() + 5, data.length());





            fra1 = b.substring(0, b.indexOf("/"));                        // fraction one: numerator   extracted from the split strings
            fra1_ = b.substring(b.indexOf("/") + 1, data.indexOf(" "));   // fraction one: denominator extracted from the split strings

            fra2 = op2.substring(0, op2.indexOf("/"));                    // fraction two: numerator   extracted from the split strings
            fra2_ = op2.substring(fra2.length() + 1, op2.indexOf(" "));   // fraction two: numerator   extracted from the split strings

            fra3 = b8.substring(1, b8.indexOf("/"));                      // fraction two: numerator   extracted from the split strings
            fra3_ = b4.substring(b4.indexOf("/") + 1);                    // fraction two: numerator   extracted from the split strings


            try { // if the value of string variable does not contain solely strings that represent numerals in converting to integers this part of the program detects the error
                f1 = Integer.parseInt(fra1); // Numeral string values converted into integers to be passed into the fraction objects
                f1_ = Integer.parseInt(fra1_);
                f2 = Integer.parseInt(fra2);
                f2_ = Integer.parseInt(fra2_);
                f3 = Integer.parseInt(fra3);
                f3_ = Integer.parseInt(fra3_);
            }

                catch ( NumberFormatException ex)
                {
                    System.out.println( " parse of string to number failed");

                }



            fr1 = new FractionCalculator(f1, f1_);//  3 instantiated fraction object ready for their numerator and denominator values to be passed into them
            fr2 = new FractionCalculator(f2, f2_);
            fr3 = new FractionCalculator(f3, f3_);


            if (op1.contains("/") && op2.contains("*")) {
                fr2 = fr1.divide(fr2);
                fr3 = fr2.multiply(fr3);
                System.out.println(fr3);


            }

            if (op1.contains("+") && op2.contains("*")) {
                fr2 = fr2.multiply(fr3);


                fr3 = fr1.add(fr2);
                System.out.println(fr3);


            }
            if (op1.contains("*") && op2.contains("/")) {// if statements to computer each inputted equation in terms of order of operation
                fr2 = fr1.multiply(fr2);
                fr3 = fr2.divide(fr3);
                System.out.println(fr3);


            }


            if (op1.contains("*") && op2.contains("+")) {
                fr2 = fr1.multiply(fr2);
                fr3 = fr2.add(fr3);
                System.out.println(fr3);


            }
            if (op1.contains("-") && op2.contains("*")) {
                fr2 = fr2.multiply(fr3);
                fr3 = fr1.subtract(fr2);
                System.out.println(fr3);


            }
            if (op1.contains("*") && op2.contains("-")) {
                fr2 = fr1.divide(fr2);
                fr3 = fr1.add(fr3);
                System.out.println(fr3);


            }


            if (op1.contains("-") && op2.contains("/")) {
                fr2 = fr2.divide(fr3);
                fr3 = fr1.subtract(fr2);
                System.out.println(fr3);


            }
            if (op1.contains("/") && op2.contains("-")) {
                fr2 = fr1.divide(fr2);
                fr3 = fr2.subtract(fr3);
                System.out.println(fr3);


            }
            if (op1.contains("+") && op2.contains("-")) {
                fr2 = fr1.add(fr2);
                fr3 = fr2.divide(fr3);
                System.out.println(fr3);


            }
            if (op1.contains("-") && op2.contains("+")) {
                fr2 = fr1.divide(fr2);
                fr3 = fr2.divide(fr3);
                System.out.println(fr3);


            }
            if (op1.contains("/") && op2.contains("+")) {
                fr2 = fr1.divide(fr2);
                fr3 = fr2.add(fr3);
                System.out.println(fr3);


            }
            if (op1.contains("+") && op2.contains("/")) {
                fr2 = fr2.divide(fr3);
                fr3 = fr1.add(fr2);
                System.out.println(fr3);


            }


            if (op1.contains("-") && op2.contains("-")) {
                fr2 = fr1.divide(fr2);
                fr3 = fr2.divide(fr3);
                System.out.println(fr3);


            }


            if (op1.contains("*") && op2.contains("*")) {
                fr2 = fr1.multiply(fr2);
                fr3 = fr2.divide(fr3);
                System.out.println(fr3);


            }

            if (op1.contains("/") && op2.contains("/")) {
                fr2 = fr1.divide(fr2);
                fr3 = fr2.divide(fr3);
                System.out.println(fr3);


            }

            if (op1.contains("+") && op2.contains("+")) {
                fr2 = fr1.add(fr2);
                fr3 = fr2.add(fr3);
                System.out.println(fr3);


            }


            System.out.println(" please type in another sum or any other relevant input:");


            data = input.nextLine();


            if (data.equals("c") | data.equals("C") | data.contains("Clear") | data.contains("CLEAR")) {
                fr3.setToZero();
                System.out.println("fraction 1 " + fr3);

                data = input.nextLine();

            }
            if (data.contains("A whole number")) {


                System.out.println(fr3.aWholeNumber(fr3));
                System.out.println("you may type another sum");
                data = input.nextLine();
            }

            if (data.equals("n") || data.equals("N") || data.contains("neg")) {
                System.out.print(" current fraction: " + fr3);
                System.out.print(" fraction sign changed: " + fr3.Neg(fr3));
                System.out.println("you may type another sum");
                data = input.nextLine();
            }


            if (data.contains("anything else")) {
                fr3.setToZero();

            }


            if (data.contains("A fraction")) {


                if (op2.contains("+")) {

                    System.out.println(fr3.add(fr2));
                    System.out.println("you may type another sum");
                    data = input.nextLine();
                }
                if (op2.contains("*")) {
                    System.out.println(fr3.multiply(fr2));
                    System.out.println("you may type another sum");
                    data = input.nextLine();
                }
                if (op2.contains("-")) {
                    System.out.println(fr3.subtract(fr2));
                    System.out.println("you may type another sum");
                    data = input.nextLine();
                }
                if (op2.contains("/")) {
                    System.out.print(fr3.divide(fr2));
                    System.out.println("you may type another sum");
                    data = input.nextLine();
                }


            }
        }
    }
}




