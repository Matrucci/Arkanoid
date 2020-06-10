/*******************
 * Matan Saloniko.
 * ID: 318570769.
 * email: matan.saloniko@gmail.com.
 * username to the submit system: salonim.
 * A counter class.
 ******************/
public class Counter {
    private int counter;

    /****************
     * A constructor.
     ***************/
    public Counter() {
        this.counter = 0;
    }

    /*******************************************************************
     * @param number - Adds the value of "number" to the current count.
     *****************************************************************/
    public void increase(int number) {
        this.counter += number;
    }

    /*************************************************************************
     * @param number - Subtracts the value of "number" to the current count.
     ************************************************************************/
    public void decrease(int number) {
        this.counter -= number;
    }

    /*********************************************
     * @return - The current value of the counter.
     ********************************************/
    public int getValue() {
        return this.counter;
    }
}