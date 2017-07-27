import java.io.*;

/**
 * Created by android on 7/27/17.
 */
public class ThreadToFile {

    public static void main(String[] args) {

     threeThreads2file();

    }

    private static void threeThreads2file(){

        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));

            Thread t1 = new Thread(() -> print2file(writer, "Я поток 1 пишу в файл \n"));
            Thread t2 = new Thread(() -> print2file(writer, "Я поток 2 пишу в файл \n"));
            Thread t3 = new Thread(() -> print2file(writer, "Я поток 3 пишу в файл \n"));

            t1.start();
            t2.start();
            t3.start();

            t1.join();
            t2.join();
            t3.join();

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    private static synchronized void print2file(BufferedWriter bf, String str){
        try {
            for (int i = 0; i < 10; i++ ) {
                bf.write(i + " " + str);
                Thread.sleep(20);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }





}
