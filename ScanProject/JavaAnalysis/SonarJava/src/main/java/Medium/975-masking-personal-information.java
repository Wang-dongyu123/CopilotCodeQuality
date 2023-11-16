package main.java.Medium;

/**https://leetcode.com/problems/masking-personal-information/ */
//You are given a personal information string s, representing either an email address or a phone number. Return the masked personal information using the below rules.
//Email address:
//An email address is:
//A name consisting of uppercase and lowercase English letters, followed by
//The '@' symbol, followed by
//The domain consisting of uppercase and lowercase English letters with a dot '.' somewhere in the middle (not the first or last character).
//To mask an email:
//The uppercase letters in the name and domain must be converted to lowercase letters.
//The middle letters of the name (i.e., all but the first and last letters) must be replaced by 5 asterisks "*****".
//Phone number:
//A phone number is formatted as follows:
//The phone number contains 10-13 digits.
//The last 10 digits make up the local number.
//The remaining 0-3 digits, in the beginning, make up the country code.
//Separation characters from the set {'+', '-', '(', ')', ' '} separate the above digits in some way.
//To mask a phone number:
//Remove all separation characters.
//The masked phone number should have the form:
//"***-***-XXXX" if the country code has 0 digits.
//"+*-***-***-XXXX" if the country code has 1 digit.
//"+**-***-***-XXXX" if the country code has 2 digits.
//"+***-***-***-XXXX" if the country code has 3 digits.
//"XXXX" is the last 4 digits of the local number.


class MaskingPersonalInformation {
    public String maskPII(String s) {
        if(s.contains("@")){
            return maskEmail(s);
        }
        return maskPhone(s);
        
    }
    public String maskEmail(String s){
        s = s.toLowerCase();
        int i = s.indexOf("@");
        String name = s.substring(0, i);
        String domain = s.substring(i + 1);
        return name.charAt(0) + "*****" + name.charAt(name.length() - 1) + "@" + domain;
    }
    public String maskPhone(String s){
        s = s.replaceAll("[^0-9]", "");
        String res = "";
        int n = s.length();
        if(n == 10){
            res = "***-***-";
        }
        else if(n == 11){
            res = "+*-***-***-";
        }
        else if(n == 12){
            res = "+**-***-***-";
        }
        else{
            res = "+***-***-***-";
        }
        return res + s.substring(n - 4);
    }
}

    