import java.math.BigInteger;
import java.util.Scanner;


public class Driver {
	public static void main(String args[]){
		/**
			a.Generate two large prime numbers p and q with each number being at least 80 digits long.

			b.Ask user to pick up a value of public key e(e.g. 17, 2^16-1). Call the private key computation function/method using the values of e, p, q obtained to find the private key d.

			c.Ask user to input a two digit number (e.g. 98), call the encryption function/method to encrypt the small number. Then call the decryptionfunction torecover the plaintext small number
		**/
		//test variables
		BigInteger x = new BigInteger("97531246465789432580765248342513933344455588642467748");
		BigInteger y = new BigInteger("88774646578943258076524842465789432521146586321077894325");
		BigInteger one = new BigInteger("1");
		BigInteger n = x.subtract(one).multiply(y.subtract(one)); // n(0) = ((p-1) * (q-1))
		
		//initialize the bigints
		BigInteger p, q;
		
		//Nicoles functions to get prime bigInts
		//p = getRandomPrime(p);
		//q = getRandomPrime(q);
		
		//BigInteger n = q.subtract(one).multiply(p.subtract(one)); // n(0) = ((p-1) * (q-1))
		
		//ask user to pick a value of a public key
		Scanner s = new Scanner(System.in);
		System.out.println("Please enter a value for a public key: ");
		BigInteger publicKey = s.nextBigInteger();	//I think we have to add something here
		
		//David's function to get private key
		BigInteger privateKey = findPrivateKey(n, publicKey); //note, my function will output negatives as well as poitives
		
		//cory's function to encrypt/decrypt
		
		
		
	}
	
	
	// Function findPrivateKey takes in two values (a and b) and returns a value y such that a*x + b*y = gcd(a, b)
		public static BigInteger findPrivateKey(BigInteger a, BigInteger b){
			BigInteger x = new BigInteger("0");		// holds the current value of x
			BigInteger y = new BigInteger("1");		// holds the current value of y
			BigInteger prevx = new BigInteger("1"); // holds the value of x one cycle previously
			BigInteger prevy = new BigInteger("0");	// holds the value of y one cycle previously
			BigInteger temp;						// a variable used to hold a value for a just a short period of time
			BigInteger zero = new BigInteger("0");  // biginteger value of zero
			
			
			//while loop cycles through the rounds of the euclidean alg until a%b == 0
	        while (!b.equals(zero))
	        {
	        	
	            BigInteger q = a.divide(b); // divide a and b
	            BigInteger r = a.remainder(b); // a%b
	            
	            a = b; 			// set a = b
	            b = r;		// set b = a%b
	            
	            //System.out.println("check values: x = "+x+" y = "+ y);
	 
	            temp = x; 							//save the current value of x
	            x = prevx.subtract(q.multiply(x));  //get the new value of x
	            prevx = temp;						//set the previous value of x
	 
	            temp = y;							//save the current value of y
	            y = prevy.subtract(q.multiply(y));	//get the new value of y
	            prevy = temp;       				//set the previous value of y  
	            
	            
	        }
	        //the answer will be saved in the previous values of x and y.
	        System.out.println("x : "+ prevx +" y :"+ prevy);
	        return prevy; //return y as the private key
		}
}
