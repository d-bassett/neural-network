package neuralnetwork;

/**
 * Simple neural network. Work in progress.
 * 
 * Based on content from: https://becominghuman.ai/making-a-simple-neural-network-2ea1de81ec20
 * 
 * @author Dylan Bassett
 */
public class NeuralNetwork {
    
    private int[] inputs;           // Input data
    private double[] weights;       // Weight data
    private int desired;            // Desired ouput
    private double learningRate;    // Learning rate

    /**
     * Constructor method to initialize class variables.
     * 
     * @param inputs Input data to be initialized
     * @param weights Weight data to be initialized
     * @param desired Desired output
     * @param learningRate Learning rate
     */
    public NeuralNetwork(int[] inputs, double[] weights, int desired, double learningRate) {
        this.inputs = inputs;
        this.weights = weights;
        this.desired = desired;
        this.learningRate = learningRate;
    }
    
    /**
     * Main method for testing some functionality (To be removed at a later date)
     * 
     * @param args 
     */
    public static void main(String... args) {
        int[] input = {0,0,1,0,1,1,0,0,0,1};
        double[] weight = {1,0,0,0,0,0,0,0,1,0};
        int desired = 1;
        double learningRate = 0.05;
        NeuralNetwork nn = new NeuralNetwork(input, weight, desired, learningRate);
        System.out.printf(nn.toString());
        for(int i = 0; i < desired/learningRate; i++) {
            nn.learn(input, nn.weights);
            System.out.printf(nn.toString());
        }
    }
    
    /**
     * Evaluate method.
     * 
     * @param input Input data
     * @param weight Weight data
     * @return 
     */
    public int evaluate(int[] input, double[] weight) {
        int result = 0;
        for(int i = 0; i < input.length; i++) {
            result += input[i]*weight[i];
        }
        return result;
    }
    
    /**
     * Learning method to train the neural network.
     * 
     * @param input Input data
     * @param weight Weight data
     */
    public void learn(int[] input, double[] weight) {
        for(int i = 0; i < input.length; i++) {
            if(input[i] > 0 && weights[i] < desired) {
                weights[i] += learningRate;
            } else if(input[i] < desired && weight[i] > input[i]){
                weights[i] = Math.abs(weights[i] - learningRate);
            }
        }
    }
    
    /**
     * Error method returns the difference between desired and actual outcomes.
     * 
     * @param desired Desired output
     * @param actual Actual output
     * @return Difference between desired and actual output
     */
    public int error(int desired, int actual) {
        return desired - actual;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        String inputString = "";
        String weightString = "";
        for(int i = 0; i < this.inputs.length; i++) {
            inputString += String.format("%d\t\t", this.inputs[i]);
            weightString += String.format("%f\t", this.weights[i]);
        }
        return String.format("\nInput:\t%s\nWeight:\t%s\n\nDesired: %d\nLearning Rate: %f\n", inputString, weightString, this.desired, this.learningRate);
    }
}