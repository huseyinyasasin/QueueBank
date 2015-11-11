/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankqueue;

/**
 *
 * @author huseyin
 */
public class Node <E>{
    E data;
    Node next;
    long joinQueueTime, leaveQueueTime;

    public long getJoinQueueTime() {
        return joinQueueTime;
    }

    public long getLeaveQueueTime() {
        return leaveQueueTime;
    }
    
    public E getData() {
        return data;
    }
    
    Node(E data){
        this.data = data;
    }
    
}
