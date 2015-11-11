/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankqueue;

import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huseyin
 * @param <E>
 */
public class BankQueue<E> {

    Node<E> first;
    Node<E> last;
    Random random = new Random();
    private static Logger logger = Logger.getLogger(BankQueue.class.getName());


    void push(Node<E> node) throws InterruptedException {
        int i = random.nextInt(10000);
        if (first == null) {
            Thread.sleep(i);
            first = node;
            first.joinQueueTime = System.currentTimeMillis();
            last = node;
            logger.info(first.data+" Vezne boş ilk eleman" + i +"ms sonra eklendi.Eklenme zamanı: "+new Date(first.joinQueueTime));
        } else {
            Thread.sleep(i);
            last.next = node;
            last = node;
            last.joinQueueTime = System.currentTimeMillis();
            logger.info(last.data+" kuyrugun sonuna "+ i +" ms sonra eleman eklendi.Eklenme zamanı:"+ new Date(last.joinQueueTime));
        }
    }

    public Node<E> pop() throws InterruptedException {
        Node<E> temp = first;
        int i = random.nextInt(10000);
        Thread.sleep(i);
        temp.leaveQueueTime = System.currentTimeMillis();
        logger.info(temp.data+" veznede "+i+ "ms zaman harcadı. "+ "Ayrıldığı zaman:"+ new Date(temp.leaveQueueTime)+
                " Toplam bekleme süresi: " +(temp.leaveQueueTime-temp.joinQueueTime)+"ms");
        first = temp.next;
        temp.next = null;
        return temp;
    }

    public void display() {
        Node<E> current = first;

        while (current != null) {
            System.out.print(current.data);
            long waitTime= current.leaveQueueTime-current.joinQueueTime;
            System.out.println("Total time on queue:" + waitTime);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        try {
            String s1 = "okan";
            String s2 = "hüso";
            String s3 = "lütfü";
            
            Node<String> n1 = new Node(s1);
            Node<String> n2 = new Node(s2);
            Node<String> n3 = new Node(s3);
            
            BankQueue<String> queue = new BankQueue<>();
            queue.push(n1);
            queue.push(n2);
            queue.push(n3);
            
            queue.pop();
            queue.pop();
            queue.pop();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(BankQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}