
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
		long prevx = 1; // holds the value of x one cycle previously
		long prevy = 0;	// holds the value of y one cycle previously
		long temp;		// a variable used to hold a value for a just a short period of time
		
		//while loop cycles through the rounds of the euclidean alg until a%b == 0
        while (a%b != 0)
        {
            long q = a / b; // divide a and b
            
            a = b; 			// set a = b
            b = a % b;		// set b = a%b
 
            temp = x; 			//save the current value of x
            x = prevx - q * x;  //get the new value of x
            prevx = temp;		//set the previous value of x
 
            temp = y;			//save the current value of y
            y = prevy - q * y;	//get the new value of y
            prevy = temp;       //set the previous value of y     
        }
        //the answer will be saved in the values of x and y.
        System.out.println("x : "+ x +" y :"+ y);
        return y; //return y as the private key
	}
}
