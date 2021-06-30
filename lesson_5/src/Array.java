public class Array {
    static final int size = 10000000;
    static final int h = size / 2;

    public static long createArray() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1F;
        }
        long startCalculation = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long endCalculation = System.currentTimeMillis();
        long result = endCalculation - startCalculation;
        return result;
    }

    public static long createArrayWithThread() {
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1F;
        }
        float[] firstHalfArray = new float[h];
        float[] secondHalfArray = new float[h];
        long startCalculation = System.currentTimeMillis();
        System.arraycopy(arr, 0, firstHalfArray, 0, h);
        System.arraycopy(arr, h, secondHalfArray, 0, h);
        Thread threadFirst = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < firstHalfArray.length; i++) {
                    firstHalfArray[i] = (float) (firstHalfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread threadSecond = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < secondHalfArray.length; i++) {
                    secondHalfArray[i] = (float) (secondHalfArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        threadFirst.start();
        threadSecond.start();
        try {
            threadFirst.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            threadSecond.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(firstHalfArray, 0, arr, 0, h);
        System.arraycopy(secondHalfArray, 0, arr, h, h);
        long endCalculation = System.currentTimeMillis();
        long result = endCalculation - startCalculation;
        return result;
    }
}
