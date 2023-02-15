package daily;

import java.util.Objects;

class CompressString {
    public static void main(String[] args) {
        String str = "wwwggoppopppp";

        char before = str.charAt(0);

        int count = 1;
        String result = "";

        str = str + ' ';
        for(int i=1; i<str.length(); i++){
            if(before == str.charAt(i)){
                count++;
            } else {
                if(count>=3){
                    result = result + count + before;
                } else {
                    for (int j=0; j<count; j++){
                        result = result + before;
                    }
                }
                before = str.charAt(i);
                count = 1;
            }
        }
        System.out.println(result);
    }
}