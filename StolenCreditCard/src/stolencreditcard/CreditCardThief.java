package stolencreditcard;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Tom Vallee
 */

public class CreditCardThief {
 public static int[] numberOfDigits = new int[17];
 public static int firstDigit = 4;
 public static int lastFourDigits;
 public static long middleStart;
 public static int numberToFind;


 public static void main(String[] args) {
  Scanner input = new Scanner(System.in);


  System.out.println("What are the last four digits of the credit card?");
  lastFourDigits = input.nextInt();

  System.out.println("Choose an 11 digit number to start from.");
  middleStart = input.nextLong();

  System.out.println("How many combinations would you like to check?");
  numberToFind = input.nextInt();


  ArrayList gc = generateCreditCards(numberOfDigits, firstDigit, lastFourDigits, middleStart, numberToFind);


 }

 public static ArrayList < String > generateCreditCards(int[] numberOfDigits, int firstDigit, int lastFourDigits, long middleStart, int numberToFind) {


  ArrayList < String > verified = new ArrayList < String > ();

  int[] checkDigitArray = new int[numberOfDigits.length];

  checkDigitArray[0] = firstDigit;

  checkDigitArray[13] = (lastFourDigits / 10) % 10;
  checkDigitArray[14] = (lastFourDigits / 100) % 10;
  checkDigitArray[15] = (lastFourDigits / 1000) % 10;
  checkDigitArray[16] = (lastFourDigits / 10000) % 10;




  for (int g = 0; g < numberToFind; g++) {
   middleStart++;
   String s = Long.toString(middleStart);
   int[] ms = new int[s.length()];
   for (int i = 0; i < s.length(); i++) {
    ms[i] = Integer.parseInt(s.substring(i, i + 1));
    checkDigitArray[i + 1] = ms[i];
   }

   for (int i = ms.length - 2; i >= 0; i = i - 2) {
    int x = ms[i];
    x = x * 2;
    if (x > 9) {
     x = x % 10 + 1;
    }
    ms[i] = x;
   }
   int v = 0;
   for (int i = 0; i < ms.length; i++) {
    v += ms[i];
   }
   if (v % 10 == 0) {
    System.out.println(firstDigit +Arrays.toString(ms) + checkDigitArray[13] + checkDigitArray[14] + checkDigitArray[15] + checkDigitArray[16]);


    g++;
   }


  }
  return verified;
 }
}