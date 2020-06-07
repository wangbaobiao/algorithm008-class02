class Solution {
    private List<List<String>> ret=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int [] array=new int[n];
        queue(0,array,n);
        return ret;
    }
    private void queue(int nth,int [] array,int max){
        if(nth==max){
            List<String> listTemp=new ArrayList<>();
            for(int i=0;i<max;i++){
                StringBuilder sb=new StringBuilder();
                for(int j=0;j<max;j++){
                    if(array[i]==j){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                listTemp.add(sb.toString());
            }
            ret.add(listTemp);
            return ;
        }
        for(int i=0;i<max;i++){
            array[nth]=i;
            if(!check(array,max,nth)){
                queue(nth+1,array,max);
            }
        }
    }
    private boolean check(int[] array,int max,int nth){
        for(int i=0;i<nth;i++){
            if(Math.abs(nth-i)==Math.abs(array[nth]-array[i]) || (array[nth]==array[i])){
                return true;
            }
        }
        return false;
    }
}