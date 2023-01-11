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

    public void paint(Graphics g) {
        SimpleDateFormat sdf = new SimpleDateFormat("a hh시 mm분 ss초");
        Date d = new Date();
        g.drawString(sdf.format(d), 40, 80);
    }


    @Override
    public void run() {
        while (true) {
            repaint(); //과부화가 걸릴수 있다 계속해서 객체를 만들고 지우고 만들고 지우고

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
