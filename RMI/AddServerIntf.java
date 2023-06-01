import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddServerIntf extends Remote{
    public double add( double d1, double d2 ) throws RemoteException;
    // int add(int a, int b) throws RemoteException;

    
}