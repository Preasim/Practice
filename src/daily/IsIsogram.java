package daily;

import java.util.LinkedList;
import java.util.Queue;

class IsIsogram {
    public static void main(String[] args) {
        String str = "moOse";
        str = str.toLowerCase();
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                if(str.charAt(i) == str.charAt(j)) System.out.println("false");
            }
        }
        System.out.println("true");
    }
}
