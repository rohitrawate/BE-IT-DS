import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;



// 

public class CalculatorServer {
    public static void main(String[] args) {
        try{
            ORB orb =  ORB.init(args, null);
            POA rootPOA =  POAHelper.narrow( orb.resolve_initial_references("RootPOA") );

            rootPOA.the_POAManager().activate();

            CalculatorImpl  CalcuImpl = new CalculatorImpl();
            Object ref  = rootPOA.servant_to_reference(CalcuImpl);
            Calculator calculatorRef = CalculatorHelper.narrow( ref);

            System.out.println("Calculator Server is Running ...");

            orb.run();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
