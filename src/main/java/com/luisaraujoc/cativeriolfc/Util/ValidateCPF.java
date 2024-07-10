package com.luisaraujoc.cativeriolfc.Util;

public class ValidateCPF {

    public static boolean isCPF(String CPF) {
        // Check if CPF is empty or has an incorrect length
        if (CPF == null || CPF.length() != 11 || CPF.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Calculate the first digit
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (10 - i) * Character.getNumericValue(CPF.charAt(i));
            }
            int firstCheckDigit = 11 - (sum % 11);
            firstCheckDigit = (firstCheckDigit >= 10) ? 0 : firstCheckDigit;

            // Calculate the second digit
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (11 - i) * Character.getNumericValue(CPF.charAt(i));
            }
            int secondCheckDigit = 11 - (sum % 11);
            secondCheckDigit = (secondCheckDigit >= 10) ? 0 : secondCheckDigit;

            // Validate the check digits
            return (firstCheckDigit == Character.getNumericValue(CPF.charAt(9))) &&
                   (secondCheckDigit == Character.getNumericValue(CPF.charAt(10)));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testCPFs = {
            "12345678909", // valid
            "11111111111", // invalid
            "12345678900", // invalid
            "01234567890"  // invalid
        };

        for (String cpf : testCPFs) {
            System.out.println("CPF: " + cpf + " is " + (isCPF(cpf) ? "valid" : "invalid"));
        }
    }
}
