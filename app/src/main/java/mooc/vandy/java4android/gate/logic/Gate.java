package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here

    public static final int IN = 1;
    public static final int OUT = -1;
    public static final int CLOSED = 0;

    private int mSwing;

    Gate() {
        mSwing = CLOSED;
    }

    public int getSwingDirection() {
        return mSwing;
    }

    //Improve condition checking
    public boolean setSwing(int direction) {
        if(direction == IN || direction == OUT || direction == CLOSED) {
            mSwing = direction;
            return true;
        }

        return false;
    }

    public boolean open(int direction) {
        if(direction==IN || direction==OUT) {
            this.setSwing(direction);
            return true;
        }
        return false;
    }

    public void close() {
        this.setSwing(CLOSED);
    }

    public int thru(int count) {
        if(this.getSwingDirection() == IN) {
            return count;
        } else if(this.getSwingDirection() == OUT) {
            return -count;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if(mSwing == IN) {
            return "This gate is open and swings to enter the pen only";
        }
        return "This gate is open and swings to exit the pen only";
    }
}
