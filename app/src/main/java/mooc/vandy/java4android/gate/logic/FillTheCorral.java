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
        for(int i=0; i<corral.length; i++) {
            if(corral[i].getSwingDirection() == Gate.IN) {
                return true;
            }
        }
        return false;
    }

    public int corralSnails(Gate[] corral, Random rand) {
        int pasture = 5;
        int totalSnails = 5;
        int inPen = 0;
        do{
            int gate = rand.nextInt(corral.length);
            corral[gate].setSwing(rand.nextInt(3)-1);
            if(corral[gate].getSwingDirection() == Gate.OUT && pasture == 5) {
                continue;
            }
            pasture -= corral[gate].thru(rand.nextInt(pasture)+1);

            mOut.println(gate+ " are trying to move through corral "+(totalSnails-pasture));

        }while(pasture != 0);
        return 0;
    }
}
