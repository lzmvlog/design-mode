package top.lzmvlog.strategy;

import java.util.Arrays;

/**
 * @author ShaoJie
 * @Date 2019/11/15
 */
public class Main {

    public static void main(String[] args) {
        int[] a = {9, 2, 3, 5, 7, 1, 4};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
