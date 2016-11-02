package com.nathan.interviews.appboy;import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Created by Nathan on 11/1/16.
 */
public class IntegerTracker {


    double sum; //tracking the sum of all numbers
    int count; //quantity of numbers
    int max; //max number
    int min; //min number
    int mode; //mode number
    HashMap<Integer, Integer> frequency; //number - frequency mapping
    HashMap<Integer, Integer> position; //number - position mapping


    //constructor to initial data
    //O(1)
    public IntegerTracker() {
        this.sum = 0;
        this.count = 0;
        this.max = Integer.MIN_VALUE;
        this.min = Integer.MAX_VALUE;
        this.mode = 0;
        this.frequency = new HashMap<>();
        this.position = new HashMap<>();

    }

    //O(1)
    public void track(int num) {
        this.sum += num;
        this.count++;
        this.max = Math.max(num, this.max);
        this.min = Math.min(num, this.min);


        if (this.frequency.containsKey(num)) {
            this.frequency.put(num, this.frequency.get(num) + 1);
        } else {
            this.frequency.put(num, 1);
        }

        //only update at the very first time
        if (!this.position.containsKey(num)) {
            this.position.put(num, this.count);
        }

        if (this.count == 1) {
            this.mode = num;
        } else {
            //when the new number's frequency == mode's frequency
            if ((this.frequency.get(num) == this.frequency.get(this.mode))
                    && (this.position.get(num) < this.position.get(this.mode))) {
                this.mode = num;

                //when the number's frequency > mode's frequency
            } else if (this.frequency.get(num) > this.frequency.get(this.mode)) {
                this.mode = num;
            }
        }


    }

    //O(1)
    public int get_max() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.max;
    }

    //O(1)
    public int get_min() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.min;

    }

    //O(1)
    public double get_mean() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.sum / this.count;

    }

    //O(1)
    public int get_mode() {
        if (isEmpty()) throw new NoSuchElementException();
        return this.mode;

    }

    //O(1)
    public boolean isEmpty() {
        return count <= 0;
    }


    public static void main(String[] args) {
        IntegerTracker tracker = new IntegerTracker();
        tracker.track(1);
        tracker.track(0);
        System.out.println(tracker.get_max());
        System.out.println(tracker.get_min());
        System.out.println(tracker.get_mean());
        System.out.println(tracker.get_mode());
        tracker.track(3);
        tracker.track(3);
        tracker.track(1);
        System.out.println(tracker.get_max());
        System.out.println(tracker.get_min());
        System.out.println(tracker.get_mean());
        System.out.println(tracker.get_mode());
    }
}
