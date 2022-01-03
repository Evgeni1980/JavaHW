package lesson_5;

public class ThreadHomework {
    public static void main(String[] args) throws InterruptedException {
        firstMethod();
        secondMethod();
    }

    // Код первого метода

    public static void firstMethod() {
        int size = 10000000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
        }
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + "ms.");
    }

    //Код второго метода

    public static void secondMethod() throws InterruptedException {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        // Создаем два массива для левой и правой части исходного
        int h = size/2;
        float[] leftHalf = new float[h];
        float[] rightHalf = new float[h];

        // Копируем в них значения из большого массива
        System.arraycopy(arr, 0, leftHalf, 0, h);
        System.arraycopy(arr, h, rightHalf, 0, h);

        // Запускаем два потока и параллельно просчитываем каждый малый массив
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < leftHalf.length; i++) {
                leftHalf[i] = (float) (leftHalf[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < rightHalf.length; i++) {
                rightHalf[i] = (float) (rightHalf[i] * Math.sin(0.2f + i/5) * Math.cos(0.2f + i/5) * Math.cos(0.4f + i/2));
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        // Склеиваем малые массивы обратно в один большой
        float[] mergedArray = new float[size];
        System.arraycopy(leftHalf, 0, mergedArray, 0, h);
        System.arraycopy(rightHalf, 0, mergedArray, h, h);
        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
