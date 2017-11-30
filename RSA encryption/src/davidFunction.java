
public class davidFunction {
	
	public static void main(String[] args){
		
		System.out.println("Lets test this function!");
		long privateKey = findPrivateKey(1759, 550);
		System.out.println("The private key is: "+privateKey);
	}
	
	// Function findPrivateKey takes in two values (a and b) and returns a value y such that a*x + b*y = gcd(a, b)
	public static long findPrivateKey(long a, long b){
		long x = 0;		// holds the current value of x
		long y = 1;		// holds the current value of y
		long lastx = 1; // holds the value of x one cycle previously
		long lasty = 0;	// holds the value of y one cycle previously
		long temp;		// a variable used to hold a value for a just a short period of time
		
		//while loop cycles through the rounds of the euclidean alg until a%b == 0
        while (a%b != 0)
        {
            long q = a / b; // divide a and b
            a = b; 			// set a = b
            b = a % b;		// set b = a%b
 
            temp = x; 			//save the current value of x
            x = lastx - q * x;  //get the new value of x
            lastx = temp;		//set the previous value of x
 
            temp = y;			//save the current value of y
            y = lasty - q * y;	//get the new value of y
            lasty = temp;       //set the previous value of y     
        }
        //the answer will be saved in the previous values of x and y.
        //lastx and lasty
        System.out.println("Roots  x : "+ x +" y :"+ y);
        return y; //return lasty as the private key
	}
}
