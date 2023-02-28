package daily;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 두개의 배열을 입력받아 배열2가 배열1의 부분집합인지 여부
class IsSubsetOf {
    public static void main(String[] args) {
        IsSubsetOfSolution isSubsetOfSolution = new IsSubsetOfSolution();

        boolean output = isSubsetOfSolution.isSubsetOf(
                new int[]{1,2,3,4,5},
                new int[]{1,3,16});
        System.out.println(output);
    }
}

class IsSubsetOfSolution {
    public boolean isSubsetOf(int[] base, int[] sample){
        // 풀이 1---------------------------------
//        int count = 0;
//        if(sample.length == 0) return false;
//
//        for(int i=0; i<sample.length; i++){
//            for(int j=0; j<base.length; j++){
//                if(sample[i] == base[j]) count++;
//            }
//        }
//        if(count == sample.length) return true;
//        return false;

        // 풀이 2 -------------------
        List<Integer> intList
                = Arrays.stream(base)
                .boxed()
                .collect(Collectors.toList());

        for (int i:sample){
            if(!intList.contains(i)){
                return false;
            }
        }
        return true;
    }
}