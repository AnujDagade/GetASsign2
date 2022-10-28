package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }



    // TODO -- Fill your code in here

    public void setCorralGates(Gate[] gate, Random rand) {
        mOut.println("Initial gate setup");
        for(int i=0; i<gate.length; i++) {
            gate[i].setSwing(rand.nextInt(3)-1);
            mOut.println("Gate "+i+ ": "+gate[i]);
        }

    }

    public boolean anyCorralAvailable(Gate[] corral) {
        return true;
    }

    public int corralSnails(Gate[] corral, Random rand) {
        return 1;
    }
}
