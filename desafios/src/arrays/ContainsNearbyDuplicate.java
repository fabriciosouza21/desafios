package arrays;

import java.util.HashSet;
import java.util.Set;

public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k){

        Set<Integer> janela = new HashSet<Integer>();

        for (int i =0; i < nums.length; i++){

            //remover o elemento mais antigo da janela
            if(i > k){
                janela.remove(nums[i-k -1]);
            }

            //se não adicionar é por que não existe
            if(!janela.add(nums[i])){
                return true;
            }


        }

        return false;

    }
}
