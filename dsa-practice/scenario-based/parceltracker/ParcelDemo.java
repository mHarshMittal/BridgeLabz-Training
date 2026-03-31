public class ParcelDemo {
    public static void main(String[] args) {
        ParcelTracker pt = new ParcelTracker();
        pt.addStage("Packed");
        pt.addStage("Shipped");
        pt.addStage("In Transit");
        pt.addStage("Delivered");

        pt.printStages();

        pt.addCheckpointAfter("Shipped", "Custom Checkpoint");
        pt.printStages();

        
        pt.markLost();
        pt.printStages(); 
    }
}

