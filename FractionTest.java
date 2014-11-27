/**
 * Created by devon on 14/11/2014.
 */
public class FractionTest {

        public static void main(String[] args) {

            // test divide by zero - should print an error and exit
            new Fraction(1, 0);

            // test multiply
            Fraction f = new Fraction(3,10);
            Fraction g = new Fraction(1,2);
            Fraction h = new Fraction(3,5);



            if (!f.equals(g.multiply(h))) System.out.println("Multiply failed");


            // test add
            Fraction i = new Fraction (3,6);
            Fraction j = new Fraction (2,5);
            Fraction k = new Fraction(9,10);


            if (!k.equals(i.add(j))) System.out.println("Add failed");


            // test subtract
            Fraction l = new Fraction (7,3);
            Fraction m = new Fraction (6,2);
            Fraction n = new Fraction(-2,3);

            if (!n.equals(l.subtract(m))) System.out.println("Subtract failed");


            // test divide
            Fraction o = new Fraction(5,10);
            Fraction p = new Fraction(3,20);
            Fraction q = new Fraction(10,3);

            if (!q.equals(o.divide(p))) System.out.println("Divide failed");


            // test absolute value
            Fraction r = new Fraction(1,2);
            Fraction s = new Fraction(1,2);
            Fraction t = new Fraction(1,1);

            if (!t.equals(s.add(r))) System.out. println(" Getting the absolute vale failed");


            test(new Fraction(1, 2),new Fraction(1, 2),"error test 1");
            test(new Fraction(1, 2),new Fraction(3, 6),"error test 2");
            test(new Fraction(-1, 2),new Fraction(1, -2),"error test 3");
            test(new Fraction(-1, -2),new Fraction(1, 2),"error test 4");
            test(new Fraction(4, -8),new Fraction(1, 2),"error test 5");

            // extend with extra tests
        }

        static void test(Fraction f1, Fraction f2, String msg){
            if (! f1.equals(f2))
                System.out.println(msg);
        }
    }

