package body;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer extends Frame implements Runnable {
    public Timer(String title) {

        setFont(new Font("고딕", Font.BOLD, 36));
        setBounds(250, 200, 400, 100);
        setVisible(true);
        setTitle(title);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Thread thread = new Thread(this); //스레드 생성
        thread.start();

    }

    private long start;
    public void paint(Graphics g) {
        long current = System.nanoTime();
        String str = String.format("시간 : %5.1f", (float) (current-start)/1_000_000/1_000 );
        g.drawString( str, 30, 60 );

    }


    @Override
    public void run() {
        start = System.nanoTime();
        while (true) {
            repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
