
public class MFU {

    private final Object mon1 = new Object();
    private final Object mon2 = new Object();

    public static void main(String[] args) {

        MFU m = new MFU();

        new Thread(() -> m.print("doc1",10)).start();
        new Thread(() -> m.scan("doc1",10)).start();

        new Thread(() -> m.print("doc3",11)).start();
        new Thread(() -> m.scan("doc3",11)).start();

        new Thread(() -> m.print("doc4",12)).start();
        new Thread(() -> m.scan("doc4",12)).start();

        new Thread(() -> m.print("doc5",13)).start();
        new Thread(() -> m.scan("doc5",13)).start();


    }

    private void print(String docName,int pages) {

        synchronized (mon1) {
            for (int i = 1; i <= pages; i++) {
                System.out.println(docName + ": напечатано страница " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void scan(String docName, int pages) {

        synchronized (mon2) {
            for (int i = 1; i <= pages; i++) {
                System.out.println(docName + ": отсканирована страница " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
