package com.company.taskpalindrome.models;

public class Palindrome {
    private String value;
    private Boolean isPalindrome;

    public Palindrome(String value, Boolean isPalindrome) {
        this.value = value;
        this.isPalindrome = isPalindrome;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getIsPalindrome() {
        return isPalindrome;
    }

    public void setPalindrome(Boolean palindrome) {
        isPalindrome = palindrome;
    }
}
