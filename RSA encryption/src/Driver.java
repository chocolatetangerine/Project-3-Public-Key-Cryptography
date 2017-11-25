import java.math.BigInteger;


public class Driver {
	public static void main(String args[]){
		/**
a.Generate two large prime numbers p and q with each number being at least 80 digits long.

b.Ask user to pick up a value of public key e(e.g. 17, 2^16-1). Call the private key computation function/method using the values of e, p, q obtained to find the private key d.

c.Ask user to input a two digit number (e.g. 98), call the encryption function/method to encrypt the small number. Then call the decryptionfunction torecover the plaintext small number
		**/
		BigInteger x = new BigInteger("97531246465789432580765248342513933344455588642467748");
		BigInteger y = new BigInteger("88774646578943258076524842465789432521146586321077894325");
		BigInteger z = x.multiply(y);
		System.out.println(z);
	}
}
