import arrays.LongestHarmoniousSubsequence;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        LongestHarmoniousSubsequence exec = new LongestHarmoniousSubsequence();

        int[] array = {1,3,2,2,5,2,3,7};

        int lhsSlideWindows = exec.findLhsSlideWindows(array);

    }
}