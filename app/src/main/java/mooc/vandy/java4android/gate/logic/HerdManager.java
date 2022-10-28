package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mWestGate;

    /**
     * The output Gate object.
     */
    private Gate mEastGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    public static final int HERD = 24;
    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here

    public void simulateHerd(Random rand) {
        int snellsInPen = HERD;
        mOut.println("There are currently "+snellsInPen+ " snails in the pen and " +(HERD-snellsInPen)+ " snails in the pasture");

        for(int i=0; i<10; i++) {
            if(snellsInPen == HERD) {
               snellsInPen += mEastGate.thru(rand.nextInt(snellsInPen)+1);
            } else
            if(snellsInPen == 0) {
                snellsInPen += mWestGate.thru(rand.nextInt(HERD)+1);
            } else
            {
                int chGate = rand.nextInt(2)+1;
                if(chGate == 1) {
                    snellsInPen += mWestGate.thru(rand.nextInt((HERD - snellsInPen))+1);
                }
                else {
                    snellsInPen += mEastGate.thru(rand.nextInt(snellsInPen)+1);
                }

            }
            mOut.println("There are currently "+snellsInPen+ " snails in the pen and " +(HERD-snellsInPen)+ " snails in the pasture");
        }
    }
}
