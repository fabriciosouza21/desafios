package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestHarmoniousSubsequence {

    public int findLhs1(int[] nums) {

        if (nums == null) {
            return 0;
        }


        Map<Integer, Long> mapaContagem = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(
                        Function.identity(),        // chave = o próprio valor
                        Collectors.counting()       // valor = contagem
                ));

        int maiorSequencia = 0;
        //navegar nas chaves do map e verifica a quantidade de n +1 se for maior salvar o valor

        for (Map.Entry<Integer, Long> entry : mapaContagem.entrySet()) {
            Integer chave = entry.getKey();
            Long valor = entry.getValue();
            Long diferencaPositiva = mapaContagem.get(chave + 1);
            Long diferencaNegativa = mapaContagem.get(chave - 1);


            if (diferencaPositiva != null && valor + diferencaPositiva > maiorSequencia) {
                maiorSequencia = (int) (valor + diferencaPositiva);
            }

            if (diferencaNegativa != null && valor + diferencaNegativa > maiorSequencia) {
                maiorSequencia = (int) (valor + diferencaNegativa);
            }


        }
        return maiorSequencia;
    }

    public int findLhsSlideWindows(int[] nums) {


        if (nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        int maiorSequencia = 0;


        int j = 0;

        for(int i=0; i< nums.length; i++){
            while (nums[i] - nums[j] > 1) {
                j++;
            }

            if (nums[i] - nums[j] == 1) {
                maiorSequencia = Math.max(maiorSequencia, i - j + 1);
            }
        }
        return maiorSequencia;
    }

}
