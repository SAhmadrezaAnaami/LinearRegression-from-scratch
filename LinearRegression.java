public class LinearRegression {
    double learningRate;
    int iteration;
    double weight;
    double bias;
    Boolean verbose;

    public LinearRegression(double learningRate, int iteration) {
        this.learningRate = learningRate;
        this.iteration = iteration;
        this.verbose = true;
    }

    public LinearRegression(double learningRate, int iteration , boolean verbose) {
        this.learningRate = learningRate;
        this.iteration = iteration;
        this.verbose = verbose;
    }

    public String fit(double[] X ,double[] Y){
        this.weight = 0;
        this.bias = 0;
        
        for (int i = 0; i < this.iteration; i++) {

            double dw = 0;
            double db = 0;
            Double loss = 0d;
            for (int j = 0; j < X.length; j++) {

                double y_pred = predictForLoss(X[j]);
                loss = (y_pred - Y[j]);
                Float sum = 1f / X.length;
                
                dw += sum * loss * X[j];
                db += sum * loss;
                
            }
            if (verbose) {
                System.out.println("epoch : " + i + " -- loss : " + Math.abs(loss));
            }
            this.weight -= this.learningRate * dw;
            this.bias -= this.learningRate * db;

        }
        return null;
    }
    public double predictForLoss(double x){
        return this.weight * x + this.bias;
    }
    public double predict(double x){
        return Math.round(this.weight * x + this.bias);
    }
    public void printWeightAndBias(){
        System.out.println("weight : " + Math.round(this.weight));
        System.out.println("bias : " + Math.round(this.bias));
    }
}
