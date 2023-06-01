import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;
import org.omg.CORBA.*;
import org.omg.CORBA.Object;

import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextExtOperations;

import java.io.*;

// import com.sun.corba.se.org.omg.CORBA.ORB;
// import com.sun.xml.internal.bind.api.impl.NameConverter;

public class CalculatorClient {
    public static void main(String[] args) {
        try{
            ORB orb = ORB.init(args, null);
            Object objRef = orb.resolve_initial_references( "NameService");
            NamingContext ncRef = NamingContextExtHelper.narrow(objRef);

            String name = "Calculator";
            org.omg.CORBA.Object obj = ncRef.resolve( ((NamingContextExtOperations) ncRef).to_name(name));
            // Calculator calculator = CalculatorHelper.narrow( ncRef.resolve(name));
            Calculator calculator = CalculatorHelper.narrow(obj);

            float a = 5.0f;
            float b = 3.0f;

            float result = calculator.add(a, b);
            System.out.println("Addition result : "+ result);

            result = calculator.multiply(a, b);
            System.out.println("Multiplication result: " + result);

            orb.shutdown(true);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        
    }
    
}
