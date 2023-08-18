package utils;

import java.util.Random;
/**
 * this class contains java specific Random Number method
 * @author aanand
 *
 */
public class RandomNumber {
	/**
	 * it is used to generate the integer Random Number within the boundary of 0 to 10000
	 * @return intData
	 */
	public int getRandomNumber() {
		Random random=new Random();
		int randomNumber = random.nextInt(10000);
		return randomNumber;
	}

}
