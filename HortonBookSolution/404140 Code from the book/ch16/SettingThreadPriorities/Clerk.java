import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class Clerk implements Runnable {
  // Constructor
  public Clerk(int ID, Bank theBank, int priority) {
    this.ID = ID;
    this.theBank = theBank;                                            // Who the clerk works for
    this.priority = priority;
  }

  // Receive a transaction
  synchronized public boolean doTransaction(Transaction transaction) {
    if(inTray.size() >= maxTransactions) {
      return false;
    }
    inTray.add(transaction);                                           // Add transaction to the list
    return true;
  }

  // The working clerk...
   public void run() {
    Thread.currentThread().setPriority(priority);                      // Set the priority for this thread
    while(true) {
      while(inTray.size() == 0) {                                      // No transaction waiting?
        try {
          Thread.sleep(200);                                           // then take a break
          if(inTray.size() != 0) {
            break;
          } else {
            return;
          }
        } catch(InterruptedException e) {
          System.out.println("Clerk "+ ID + "\n" + e);
          return;
        }
      }
      theBank.doTransaction(inTray.remove(0), ID);
      if(Thread.interrupted()) {
        System.out.println("Interrupt flag for Clerk " + ID + " set. Terminating.");
        return;
      }
    }
  }

  int ID;
  int priority;                                                        // This thread's priority
  private Bank theBank;
  private List<Transaction> inTray =                                   // The in-tray holding transactions
                   Collections.synchronizedList(new LinkedList<Transaction>());
  private int maxTransactions = 8;                                     // Maximum transactions in the in-tray
}
