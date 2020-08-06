package com.company.taskpalindrome.controllers;

import com.company.taskpalindrome.models.Palindrome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/palindrome")
    public String palindrome(@RequestParam(name = "inputPalindrome", required = false, defaultValue = "geeksskeeg daviddivad thissShouldBeFalse") String input, Model model){
        System.out.println("in palindrome");

        ArrayList<Palindrome> palindromes = getPalindromes(input);
        model.addAttribute("palindromeList", palindromes);

        return "palindrome";
    }
    //Splits the string and creates an arraylist
    private ArrayList<String> splitToList(String palindrome){
        palindrome.toLowerCase();
        String[] palindromes = palindrome.split(" ");
        ArrayList<String> arrListPalindromes = new ArrayList<String>();
        for (int i = 0; i < palindromes.length; i++) {
            arrListPalindromes.add(palindromes[i]);
        }
        return arrListPalindromes;
    }
    //Checks if its an palindrome
    private boolean isPalindrome(String palindrome){
        boolean res = false;
        String reversePalindrome = "";
        for (int i = palindrome.length() - 1; i >= 0; i--) {
            reversePalindrome = reversePalindrome + palindrome.charAt(i);
        }
        if(palindrome.equals(reversePalindrome))
            res = true;
        return res;
    }
    //Returns a list of the object Palindrome
    private ArrayList<Palindrome> getPalindromes(String input){
        ArrayList<String> listPalindrome = splitToList(input);
        ArrayList<Palindrome> palindromes = new ArrayList<Palindrome>();

        for (String palindrome: listPalindrome) {
            palindromes.add(new Palindrome(palindrome, isPalindrome(palindrome)));
        }
        return palindromes;
    }
}
