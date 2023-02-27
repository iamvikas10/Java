package multithreading.inter.thread.communication;

//Producer Thread is responsible to produce items to queue. After producing items to the queue, producer thread is
//responsible to call notify method then waiting consumer will get the notification and continue its execution with updated items
class ProducerThread extends Thread{

}
//consumer Thread is responsible to consume items from queue. If a queue is empty then consumer will call wait method and
//enter into waiting state
class ConsumerThread extends Thread{

}
public class ProducerConsumerProblem {
}
