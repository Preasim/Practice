package daily;

class ABCheck {
    public static void main(String[] args) {
        String str = "dfaeghaew2131kkdk";
        str = str.toLowerCase();

        for(int i=4;i<str.length();i++){
            if((str.charAt(i)=='a' && str.charAt(i-4)=='b')||(str.charAt(i)=='b'&&str.charAt(i-4)=='a'))
                System.out.println("true");

        }
    }
}