public class StringBuilderVsStringBuffer {
    public static void main(String[] args) {
        String testString = "hello";
        int iterations = 1_000_000;
        
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(testString);
        }
        String result1 = sb.toString();
        long endTime = System.currentTimeMillis();
        long stringBuilderTime = endTime - startTime;
        
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(testString);
        }
        String result2 = sbf.toString();
        endTime = System.currentTimeMillis();
        long stringBufferTime = endTime - startTime;
        
        System.out.println("=== StringBuilder vs StringBuffer ===");
        System.out.println("Iterations: " + iterations);
        System.out.println("StringBuilder: " + stringBuilderTime + " ms");
        System.out.println("StringBuffer: " + stringBufferTime + " ms");
        System.out.println("StringBuilder length: " + result1.length());
        System.out.println("StringBuffer length: " + result2.length());
    }
}
