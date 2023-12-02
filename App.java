public class App {
    public static void main(String[] args) throws Exception {
        double[] x = {1,2,3,4,5,6,7,8,9};
        double[] y = {3,5,7,9,11,13,15,17,19};

        LinearRegression lm = new LinearRegression(0.01, 5000 , true);
        lm.fit(x, y);
        System.out.println(lm.predict(10));
        lm.printWeightAndBias();

    }
}
