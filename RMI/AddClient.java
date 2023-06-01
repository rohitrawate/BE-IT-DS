import java.rmi.Naming;

public class AddClient {
    public static void main( String args[] )
    {
        try{
            String addServerURL = "rmi://" + args[0] + "/AddServer";  // 127.0.0.1 -> args[0]
            AddServerIntf addServerIntf =  (AddServerIntf)Naming.lookup(addServerURL);

            System.out.println( "the First num is : "+ args[1]);
            double d1 =  Double.valueOf(args[1]).doubleValue();
            System.out.println( "the second num is : "+ args[2]);
            double d2 = Double.valueOf( args[2]).doubleValue();

            System.out.println( " The sum is : "+ addServerIntf.add(d1, d2));
        }
        catch( Exception e){
            System.out.println("Exception : " + e);
        }
    }
}
