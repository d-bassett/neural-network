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
            if(input[i] > 0) {
                weights[i] += learningRate;
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
}