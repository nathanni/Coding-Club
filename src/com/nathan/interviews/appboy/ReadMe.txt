Language: JAVA
OS: maxOS
JDK: 1.8.0_66-b17




Member Variables:
    double sum 
    int count
    int max
    int min
    int mode 
    frequency map
    position map


Time Complexity:

track(): O(1)
int get_max(): O(1)
int get_min(): O(1)
int get_mean(): O(1)
int get_mode(): O(1)


Thinking process:

Since this data structure only "append" data without any "delete" and "modify".
I can simply create some variables to record the current status: min, max, mean(sum /count), mode.

max: Initial to Int.MIN_VALUE, when a record is inserted, compare to it and update.
min: similar to max, initial to Int.MAX_VALUE, when a record is inserted, compare to it and update.
mean: Maintain a double variable "sum" and int variable "count", when get_mean() is called, cal by sum / count
mode: There are several ways to implement this.
But in order to keep the get_mode() operation to O(1) time. I decided to use two HashMap: "frequency" and "position". 
(p.s. I can also create a wrapper class to wrap number and its id, but under this situation, count can be considered as id, which makes things easier)

    map: "frequency" refers to map the number and frequency (how many times it appears)
    map: "position" refers to map the number and its first appearance position (it will be set only once for each number at the very first time)

    when to update mode ?
    1. when the current insert number's frequency is larger than the mode's frequency
    2. when the current insert number's frequency equals to mode's frequency && current insert number's position is before/smaller than mode's position


Since we have a O(1) time by calling track() to update the max, min, mean, mode states. The getter functions will also return the member state directly in O(1) time

