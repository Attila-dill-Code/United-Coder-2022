package com.unitedcodernigar.detatypes;

import java.util.Scanner;

public class ScannerDemo1 {
    public static void main(String[] args) {
        // (************)

        // Scanner           // when you can use "input.next" you can not have spaces,
        //this way safely    // but if you want to use space, you can use this way "input.nextLine()"

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your school name");
        String schoolName = input.nextLine();
        System.out.println("Please enter your school address");
        String address = input.nextLine();
        System.out.println("Please enter yor school zipcode");
        String zipCode = input.nextLine();
        System.out.printf("Your school full address is %s %s %s",schoolName,address,zipCode);

    }
}
