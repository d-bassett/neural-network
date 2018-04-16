package neuralnetwork;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NeuralNetworkTest {
    
    private int[] input;
    private double[] weight;
    private int desired;
    private double learningRate;
    
    public NeuralNetworkTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        int[] data = {0,0,0,1,0,0,1,1,0,0};
        double[] zero = {0,0,0,0,0,0,0,0,0,0};
        input = data;
        weight = zero;
        desired = 1;
        learningRate = 0.05;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of evaluate method, of class NeuralNetwork.
     */
    @Test
    public void testEvaluate() {
        System.out.println("evaluate");
        int[] input = this.input;
        double[] weight = this.weight;
        NeuralNetwork instance = new NeuralNetwork(this.input, this.weight, this.desired, this.learningRate);
        int expResult = 0;
        for(int i = 0; i < this.input.length; i++) {
            expResult += input[i]*weight[i];
        }
        int result = instance.evaluate(input, weight);
        assertEquals(expResult, result);
    }

    /**
     * Test of learn method, of class NeuralNetwork.
     */
    @Test
    public void testLearn() {
        System.out.println("learn");
        int[] input = this.input;
        double[] weight = this.weight;
        NeuralNetwork instance = new NeuralNetwork(this.input, this.weight, this.desired, this.learningRate);
        instance.learn(input, weight);
        
        // TODO
        // Refactor to iterate through array and check each value for change in weights
        
        assertFalse(weight.equals(this.weight));
    }

    /**
     * Test of error method, of class NeuralNetwork.
     */
    @Test
    public void testError() {
        System.out.println("error");
        NeuralNetwork instance = new NeuralNetwork(this.input, this.weight, this.desired, this.learningRate);
        int expResult = desired - this.input[0];
        int result = instance.error(desired, this.input[0]);
        assertEquals(expResult, result);
    }
    
}
