package krishna.examples;

import java.util.function.Function;

class LambdaTestFunctionEx {
    public static void main(String[] args) {

        Function<Integer, Integer> func=x->x*x;
        int result = func.apply(50);
        System.out.println(result);
    }

}
