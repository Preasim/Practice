package daily;


public class DecryptCaesarCipher {
    public static void main(String[] args) {
        String str = "nzop delepd dfaazced jzf";
        int secret = 11;


        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String result = "";
        System.out.println(alphabet.length());

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == ' ') result += str.charAt(i);

            else {
                int asis = alphabet.indexOf(str.charAt(i));
                int tobe = (asis - secret + alphabet.length()) % alphabet.length();
                result += alphabet.charAt(tobe);
            }
        }
        System.out.println(result);
    }
}
