public class BufferBuilder {

    public static void main(String[] args) {

        int count = 1_000_000;

        // StringBuffer test
        StringBuffer stringBuffer = new StringBuffer();
        long startBuffer = System.nanoTime();

        for (int i = 0; i < count; i++) {
            stringBuffer.append("hello");
        }

        long endBuffer = System.nanoTime();
        long bufferTime = endBuffer - startBuffer;

        // StringBuilder test
        StringBuilder stringBuilder = new StringBuilder();
        long startBuilder = System.nanoTime();

        for (int i = 0; i < count; i++) {
            stringBuilder.append("hello");
        }

        long endBuilder = System.nanoTime();
        long builderTime = endBuilder - startBuilder;

        // Output
        System.out.println("Time taken by StringBuffer (ns): " + bufferTime);
        System.out.println("Time taken by StringBuilder (ns): " + builderTime);
    }
}
