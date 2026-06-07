package com.dilaraj;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String password = getPassword();

        System.out.println("Length: " + passwordLength(password));
        System.out.println("Uppercase: " + hasUppercase(password));
        System.out.println("Lowercase: " + hasLowercase(password));
        System.out.println("Numbers: " + hasNumber(password));
        System.out.println("Special Character: " + hasSpecialChar(password));
        System.out.println("\nPassword Strength: " + findStrength(password));
        System.out.println("Password Classification: " + findClassification(password));
    }

    public static String getPassword() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Password: ");

        return scan.nextLine();
    }

    public static int passwordLength(String password) {
        return password.length();
    }

    public static boolean hasUppercase(String password) {
        return password.matches(".*[A-Z].*");
    }

    public static boolean hasLowercase(String password) {
        return password.matches(".*[a-z].*");
    }

    public static boolean hasNumber(String password) {
        return password.matches(".*[0-9].*");
    }

    public static boolean hasSpecialChar(String password) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
    
    public static int findStrength(String password) {
        int passwordStrength = 0;
        if (passwordLength(password) >= 8) {
            passwordStrength++;
        }
        if (passwordLength(password) >= 12) {
            passwordStrength++;
        }
        if (hasUppercase(password)) {
            passwordStrength++;
        }
        if (hasLowercase(password)) {
            passwordStrength++;
        }
        if (hasNumber(password)) {
            passwordStrength++;
        }
        if (hasSpecialChar(password)) {
            passwordStrength++;
        }

        return passwordStrength;
    }

    public static String findClassification(String password) {
        int strength = findStrength(password);
        String classification = "Weak";

        if (strength >= 0 && strength <= 2) {
            return classification;
        } else if (strength >= 3 && strength <= 4) {
            classification = "Medium";
        } else if (strength >= 5 && strength <= 6) {
            classification = "Strong";
        }

        return classification;
    }
}
