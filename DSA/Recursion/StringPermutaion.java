package Recursion;

public class StringPermutaion {
   public static void  permute(String str1, String str2) {
    if(str1.length() == 0) {
        System.out.println(str2);
        return;
    }
    for(int i = 0; i < str1.length(); i++) {
        char ch = str1.charAt(i);
        String newStr1 = str1.substring(0, i) + str1.substring(i + 1);
        String newStr2 = str2 + ch;
        permute(newStr1, newStr2);
    
    }
    return;

   }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "";
        permute(str1,str2);
    }
}
