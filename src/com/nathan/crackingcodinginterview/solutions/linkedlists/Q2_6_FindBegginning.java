package com.nathan.crackingcodinginterview.solutions.linkedlists;

/*Given a circular linked list, implement an algorithm which returns the node at the
beginning of the loop.*/

public class Q2_6_FindBegginning {

  public static Node findBegginning(Node node) {

    /*slowrunner moves as 1 step, fastrunner moves as 2 steps. When slowrunner moved k step into the LOOP entrance, fastrunner is k steps in the LOOP*
     * So fastrunner is MOD(K,LOOPSIZE) head slowrunner. fastrunner need (LOOPSIZE - MOD(K,LOOPSIZE)) to catch up slowrunner.
     * Fastrunner is 1 step closer to slowrunner after each times.
     * So after(LOOPSIZE - MOD(K,LOOPSIZE)) times(it means slowrunner moved (LOOPSIZE - MOD(K,LOOPSIZE) steps), they meet.
     * At this point, the meeting point will be MOD(K,LOOPSIZE) to the entrance of the LOOP.  */
    Node fastRunner = node;
    Node slowRunner = node;

    //Find meeting point. This will be (LOOPSIZE - MOD(K,LOOPSIZE)) 
    while (fastRunner != null && fastRunner.next != null) {
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next.next;
      if (slowRunner == fastRunner) //Collision
        break;
    }
    
    //error check
    if(fastRunner == null || slowRunner == null) {
      System.out.println("it is not a circular linked list");
      return null;
    }
    
    
/*    The meeting point will be MOD(K,LOOPSIZE) to the entrance of the LOOP.
    So move the slowpoint to the head, when slowpoint move K steps into the start of the Loop, 
    the fast point(move by 1 step) will meet the slow point in the start of the LOOP.
    Because MOD(K,LOOPSIZE) + n * LOOPSIZE = k  */
    slowRunner = node; //move slow runner to head;
    
    while (fastRunner != slowRunner) {
      fastRunner = fastRunner.next;
      slowRunner = slowRunner.next;
    }
    
    return slowRunner;
    
  }

}
