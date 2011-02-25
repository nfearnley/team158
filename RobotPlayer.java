package team158;

import battlecode.common.*;
import static battlecode.common.GameConstants.*;

@SuppressWarnings("unused")
public class RobotPlayer implements Runnable
{

    private final RobotController myRC;

    public RobotPlayer(RobotController rc)
    {
        myRC = rc;
    }

    public void run()
    {
        // Loop indefinitely
        while (true)
        {
            // Prevent errors from crashing program
            try
            {
                // Debug Information
                
                myRC.setIndicatorString(1, myRC.getChassis().toString());
                ComponentController [] comps = myRC.components();
                String complist = "";
                for (ComponentController comp : comps)
                {
                    complist += comp.type().toString() + " ";
                }
                myRC.setIndicatorString(2, complist);
                    
                //myRC.components()
                myRC.yield();     
            }
            catch (Exception e)
            {
                // Show any errors in debug info 
                myRC.setIndicatorString(0, e.getMessage());
                // Print errors to std err
                System.err.println("Exception:");
                e.printStackTrace();
            }
        }
    }
}