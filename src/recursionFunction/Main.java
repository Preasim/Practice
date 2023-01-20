package recursionFunction;

class Recurs {
    public void Gugudan(int level, int count) {
        if(count > 9) {
            return;
        }
        System.out.printf("%d x %d = %d\n", level, count, level*count);
        Gugudan(level, ++count);
        System.out.println(count);
    }

}
class Main {
    public static void main(String[] args){
        Recurs recurs = new Recurs();
        recurs.Gugudan(5, 6);
    }
}
