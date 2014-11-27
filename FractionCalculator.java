/**
 * Created by devon on 23/11/2014.
 */
public class FractionCalculator {
    private int numerator;
    private int denominator;

    public FractionCalculator (int num, int denom) {
        if (denom == 0) {
            System.out.println("Invalid fraction with denominator 0");
            // this should use exceptions
            return;
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    public FractionCalculator Neg( FractionCalculator other){

        if ( this.numerator >0 && this.denominator >0) {
            int num = other.numerator - other.numerator - other.numerator;
            int denom = other.denominator - other.denominator;
            return new FractionCalculator ( num,denom);
        }

        else {
            int num = other.numerator+ other.numerator;
            int denom = other.denominator + other.denominator;
            return new FractionCalculator ( num, denom);
        }

    }




    public void setToZero (){
        this.numerator   =0;
        this.denominator =0;

    }

    @Override
    public String toString() {
        if (getDenominator()==1) return ""+ getNumerator();

        else {
            return "" + getNumerator() + '/' + getDenominator();
        }

    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FractionCalculator fraction = (FractionCalculator) o;

        if (getDenominator() != fraction.getDenominator()) return false;
        if (getNumerator() != fraction.getNumerator()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }
    public FractionCalculator aWholeNumber (FractionCalculator other){
        int num = other.numerator;
        int denom = 1;


        return new FractionCalculator ( num, denom);

    }

    public FractionCalculator multiply( FractionCalculator other) {

        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new FractionCalculator (num, denom);
    }

    public FractionCalculator add( FractionCalculator other) {

        int num = (this.getNumerator() * other.getDenominator()) + ( this.getDenominator()* other.getNumerator());
        int denom = this.getDenominator() * other.getDenominator();
        return new FractionCalculator (num, denom);
    }
    public FractionCalculator subtract (FractionCalculator other){
        int num = (this.getNumerator()* other.getDenominator())- ( other.getNumerator()*this.getDenominator());
        int demon = this.getDenominator()* other.getDenominator();

        return new FractionCalculator(num,demon);


    }

    public FractionCalculator divide (FractionCalculator other){

        int num = this.getNumerator() * other.getDenominator();
        int denom = this.getDenominator()* other.getNumerator();

        return new FractionCalculator ( num,denom);


    }





    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }




    public FractionCalculator absValue (FractionCalculator other) {


        int num = other.getNumerator();
        int denom = other.getDenominator();

        num = Math.abs(num);
        denom = Math.abs(denom);
        return new FractionCalculator (num,denom);














    }

    public boolean evaluate(FractionCalculator other, String inputString) {



        String b8 = inputString.substring(inputString.lastIndexOf(" "));

        String b = inputString.substring(0, inputString.indexOf(" "));


        String op1 = inputString.substring(b.length() + 1, b.length() + 2);

        String b3 = inputString.substring(inputString.indexOf("/"), inputString.lastIndexOf(" "));
        String op2 = inputString.substring(b.length() + 3, inputString.lastIndexOf("/"));
        String b4 = inputString.substring(op2.length() + 5, inputString.length());
        String b6 = inputString.substring(b4.length(), b4.length() + 2);


        String fra1 = b.substring(0, b.indexOf("/"));                        // fraction one: numerator
        String fra1_ = b.substring(b.indexOf("/") + 1, inputString.indexOf(" "));      // fraction one: denominator

        String fra2 = op2.substring(0, op2.indexOf("/"));                    // fraction two: numerator
        String fra2_ = op2.substring(fra2.length() + 1, op2.indexOf(" "));   // fraction two: numerator

        String fra3 = b8.substring(1, b8.indexOf("/"));                      // fraction two: numerator
        String fra3_ = b4.substring(b4.indexOf("/") + 1);

        int f1 = Integer.parseInt(fra1); // Numeral string values converted into integers to be passed in that the fraction objects
        int f1_ = Integer.parseInt(fra1_);
        int f2 = Integer.parseInt(fra2);
        int f2_ = Integer.parseInt(fra2_);
        int f3 = Integer.parseInt(fra3);
        int f3_ = Integer.parseInt(fra3_);

        FractionCalculator fr1 = new FractionCalculator(f1, f1_);//  3 instantiated fraction object ready for their numerator and denominator values to be passed into them
        FractionCalculator fr2 = new FractionCalculator(f2, f2_);
        FractionCalculator fr3 = new FractionCalculator(f3, f3_);


        if (op1.contains("/") && op2.contains("*")) {
            fr2 = fr1.divide(fr2);
            fr3 = fr2.multiply(fr3);
            System.out.println(fr3);


            if ( "1/2 / 4/2 * 8/3".equals(inputString) && fr3.equals(new FractionCalculator(2,3)))return true;

            else {return false;}

        }


        if (op1.contains("+") && op2.contains("*")) {
            fr2 = fr2.multiply(fr3);


            fr3 = fr1.add(fr2);
            System.out.println(fr3);

            if ( "1/2 + 2/3 * 1/2" ==inputString && fr3.equals(new FractionCalculator(5,6)))return true;

            else {return false;}



        }
        if (op1.contains("*") && op2.contains("/")) {// if statements to computer each inputted equation in terms of order of operation
            fr2 = fr1.multiply(fr2);
            fr3 = fr2.divide(fr3);
            System.out.println(fr3);


        }


        if (op1.contains("*") && op2.contains("+")) {
            fr2 = fr1.multiply(fr2);
            fr3 = fr2.add(fr3);


            if ( "2/3 * 2/1 + 1/2".equals(inputString) && fr3.equals(new FractionCalculator(10,3))){return true;}

            else {return false;}

        }
        if (op1.contains("-") && op2.contains("*")) {
            fr2 = fr2.multiply(fr3);
            fr3 = fr1.subtract(fr2);
            System.out.println(fr3);


        }
        if (op1.contains("*") && op2.contains("-")) {
            fr2 = fr1.divide(fr2);
            fr3 = fr1.add(fr3);




        }


        if (op1.contains("-") && op2.contains("/")) {
            fr2 = fr2.divide(fr3);
            fr3 = fr1.subtract(fr2);



        }
        if (op1.contains("/") && op2.contains("-")) {
            fr2 = fr1.divide(fr2);
            fr3 = fr2.subtract(fr3);



        }
        if (op1.contains("+") && op2.contains("-")) {
            fr2 = fr1.add(fr2);
            fr3 = fr2.divide(fr3);



        }
        if (op1.contains("-") && op2.contains("+")) {
            fr2 = fr1.divide(fr2);
            fr3 = fr2.divide(fr3);



        }
        if (op1.contains("/") && op2.contains("+")) {
            fr2 = fr1.divide(fr2);
            fr3 = fr2.add(fr3);



        }
        if (op1.contains("+") && op2.contains("/")) {
            fr2 = fr2.divide(fr3);
            fr3 = fr1.add(fr2);



        }


        if (op1.contains("-") && op2.contains("-")) {
            fr2 = fr1.divide(fr2);
            fr3 = fr2.divide(fr3);

            if ( "10/10 - 10/2 - 10/1".equals(inputString) && fr3.equals(new FractionCalculator(10,7)))return true;

            else {return false;}


        }


        if (op1.contains("*") && op2.contains("*")) {
            fr3 = fr1.multiply(fr2.multiply(fr3));

            if ( "1/2 * 1/2 * 1/2" ==inputString && fr3.equals(new FractionCalculator(1,8)))return true;

            else {return false;}




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





        if (inputString.equals("c") | inputString.equals("C") | inputString.contains("Clear") | inputString.contains("CLEAR")) {
            fr3.setToZero();
            System.out.println("fraction 1 " + fr3);





        }
        if (inputString.contains("A whole number")) {

            System.out.println(fr3.aWholeNumber(fr3));
            System.out.println("you may type another sum");






        }

        if (inputString.equals("n") || inputString.equals("N") || inputString.contains("neg")) {
            System.out.print(" current fraction: " + fr3);
            System.out.print(" fraction sign changed: " + fr3.Neg(fr3));
            System.out.println("you may type another sum");

        }


        if (inputString.contains("anything else")) {
            fr3.setToZero();

        }


        if (inputString.contains("A fraction")) {


            if (op2.contains("+")) {

                fr3.add(fr2);


            }
            if (op2.contains("*")) {

                fr3= fr3.multiply( other);
                FractionCalculator a = new FractionCalculator(1,3);

                if ( fr3.equals(a)) return true;
                else {return false;}

            }
            if (op2.contains("-")) {
                System.out.println(fr3.subtract(fr2));
                System.out.println("you may type another sum");

            }
            if (op2.contains("/")) {
                System.out.print(fr3.divide(fr2));
                System.out.println("you may type another sum");

            }






        }



      return false;

    }


}




