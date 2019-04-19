package eg.edu.alexu.csd.datastructure.linkedList;
import java.util.Scanner;
import java.lang.Math; 
public class Polynomial{ 
static	DoubleLinkedList Ac = new DoubleLinkedList();
static	DoubleLinkedList Bc = new DoubleLinkedList();
static	DoubleLinkedList Cc = new DoubleLinkedList();
static	DoubleLinkedList Rc = new DoubleLinkedList();
static	DoubleLinkedList Ae = new DoubleLinkedList();
static	DoubleLinkedList Be = new DoubleLinkedList();
static	DoubleLinkedList Ce = new DoubleLinkedList();
static	DoubleLinkedList Re = new DoubleLinkedList();

public static void setPolynomial(char poly, int[][] terms) {

    if (poly == 'A') {
        for (int i = 0; i < terms.length; i++) {
            Ac.add(terms[i][0]);
            Ae.add(terms[i][1]);
        }
    } else if (poly == 'B') {

        for (int i = 0; i < terms.length; i++) {
            Bc.add(terms[i][0]);
            Be.add(terms[i][1]);
        }
    } else if (poly == 'C') {
        for (int i = 0; i < terms.length; i++) {
            Cc.add(terms[i][0]);
            Ce.add(terms[i][1]);
        }
    } else throw new IllegalArgumentException("Unrcognisable poly");

}
public static String print(char poly){ 
	
	String string=new String("");
	
	if(poly=='A'){

    for (int i=0;i<Ac.size;i++){
        if((int) Ac.get(i)>0)
            string=string+"+";
        else if((int) Ac.get(i)<0)
            string=string+"-";
        else
            continue;
        if((int)Ae.get(i)>1)
            string=string+Ac.get(i)+"X^"+Ae.get(i);
        else  if((int)Ae.get(i)==1)
            string=string+Ac.get(i)+"X";
        else
            string=string+Ac.get(i);
    }

}
else if(poly=='B'){
   for (int i=0;i<Bc.size;i++){
       if((int) Bc.get(i)>0)
           string=string+"+";
       else if((int) Bc.get(i)<0)
           string=string+"-";
       else
           continue;
       if((int)Be.get(i)>1)
           string=string+Bc.get(i)+"X^"+Be.get(i);
       else  if((int)Be.get(i)==1)
           string=string+Bc.get(i)+"X";
       else
           string=string+Bc.get(i);
   }
}
else if(poly=='C'){
   for (int i=0;i<Cc.size;i++){
       if((int) Cc.get(i)>0)
           string=string+"+";
       else if((int) Cc.get(i)<0)
           string=string+"-";
       else
           continue;
       if((int)Ce.get(i)>1)
           string=string+Cc.get(i)+"X^"+Ce.get(i);
       else  if((int)Ce.get(i)==1)
           string=string+Cc.get(i)+"X";
       else
           string=string+Cc.get(i);
   }
} else throw new IllegalArgumentException("Wrong poly name");

return string;
}
//@Override
public void clearPolynomial(char poly) {
if(poly=='A'){
    Ae.clear();
    Ac.clear();
}
else if(poly=='B'){
    Be.clear();
    Bc.clear();
}
else if(poly=='C'){
    Ce.clear();
    Cc.clear();
}else throw new IllegalArgumentException("Wrong Entry");
}

//@Override
public static float evaluatePolynomial(char poly, float value) {
 float f=0;
 if(poly=='A'){
     for(int i=0;i<Ac.size;i++){
         f += (float) Ac.get(i)*Math.pow(value,(double)Ae.get(i));
     }
 }else if(poly=='B'){
     for(int i=0;i<Bc.size;i++){
         f += (float) Bc.get(i)*Math.pow(value,(double)Be.get(i));
     }
 }else if(poly=='C'){
     for(int i=0;i<Cc.size;i++){
         f += (float) Cc.get(i)*Math.pow(value,(double)Ce.get(i));
     }
 }else throw new IllegalArgumentException("Wrong index");
 return f;

}

public static void main (String args[]) {
		int z = 0;
		for(int h = 0;h<10 ; h++) {
		System.out.println("Please choose an action\r");
	       System.out.println("-----------------------\r");
	       System.out.println("1- Set a polynomial variable\r\n" + "2- Print the value of a polynomial variable\r\n" + "3- Add two polynomials\r\n" + "4- Subtract two polynomials\r\n"+"5- Multiply two polynomials\r\n"+"6- Evaluate a polynomial at some point\r\n"+"7- Clear a polynomial variable\r\n"+"====================================================================\r\n");   
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int test = input ;	
		if(input==1) 
		{
		System.out.println("Insert the variable name: A, B or C\r\n" );
		String poly = sc.next() ;
		System.out.print("Insert the polynomial terms in the form:\r\n" + "(coeff1, exponent1), (coeff2, exponent2), ..\r\n" );
		String essam = sc.next();int d = 0 ; int w = 0 ;
		System.out.println("====================================================================\r\n");
		int [][] term = new int[20][2];
		for(int f = 0; f< essam.length() ; f++) {
			if(f%2==0) {
			if(essam.charAt(f)!=' '||essam.charAt(f)!=','||essam.charAt(f)!='('||essam.charAt(f)!=')') {
				term[d][0]=Character.getNumericValue(essam.charAt(f));
				d++;
			}}
			else {
				if(essam.charAt(f)!=44||essam.charAt(f)!=49||essam.charAt(f)!=41||essam.charAt(f)!=40) {
					term[w][1]=Character.getNumericValue(essam.charAt(f));
					w++;
				}
			}
		}
		setPolynomial(poly.charAt(0),term);
		System.out.print("Polynomial " );
		System.out.print(poly);System.out.println(" "+ "is set\n");
		}
		else if (input==2) {
			System.out.println("Insert the variable name: A, B, C or R");
			String poly = sc.next();
		String output =	print(poly.charAt(0));
		System.out.print(output);
		System.out.println("====================================================================\r\n");
		}
		else if (input==3) {System.out.println("Enter the Poly1\r\n");
		String poly1 = sc.next();
		System.out.println("Enter the Poly2\r\n");
		String poly2 = sc.next();
		int array[][] ;
		array =	add(poly1,poly2);
		for(int e = 0;e<array.length-1 ; e++ ) {
			System.out.print("("+" "+array[e][0]+","+" "+array[e][1]+")"+" , ");
		}
		System.out.println("====================================================================\r\n");
		}
		else if (input==4) {
		System.out.println("Enter the Poly1\r\n");
		String poly11 = sc.next();
		System.out.println("Enter the Poly2\r\n");
		String poly22 = sc.next();
		int array2 [] [];
		array2	= subtract(poly11,poly22);
		for(int e = 0;e<array2.length-1 ; e++ ) {
			System.out.print("("+" "+array2[e][0]+","+" "+array2[e][1]+")"+" , ");
		}
		System.out.println("====================================================================\r\n");
		}
		else if (input==5) {
			
		System.out.println("Enter the Poly1\r\n");
		String poly111 = sc.next();
		System.out.println("Enter the Poly2\r\n");
		String poly222 = sc.next();
		int array3 [] [];
		array2	= subtract(poly111,poly222);
		for(int e = 0;e<array3.length-1 ; e++ ) {
			System.out.print("("+" "+array3[e][0]+","+" "+array3[e][1]+")"+" , ");
		}		System.out.println("====================================================================\r\n");
		}
		else if (input==6) {
			System.out.println("Enter the poly \r\n ");
			String Poly = sc.next();
			System.out.println("Enter the Value\r\n");
			float zezo = sc.nextFloat();
			float sasa = evaluatePolynomial( Poly.charAt(0) , zezo);
			System.out.println(" "+sasa);
			System.out.println("====================================================================\r\n");

		}
		else if (input==7) {
			String c = sc.next() ; 
			clearPolynomial( c );
			System.out.println("====================================================================\r\n");
		}
		else {System.out.println("Invaild Please try again\n") ;}
		}
	}
}


