package CalculatorApp;


/**
* CalculatorApp/CalculatorPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Calculator.idl
* Wednesday, 31 May 2023 19:23:05 o'clock IST
*/

public abstract class CalculatorPOA extends org.omg.PortableServer.Servant
 implements CalculatorApp.CalculatorOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
    _methods.put ("multiply", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CalculatorApp/Calculator/add
       {
         float a = in.read_float ();
         float b = in.read_float ();
         float $result = (float)0;
         $result = this.add (a, b);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 1:  // CalculatorApp/Calculator/multiply
       {
         float x = in.read_float ();
         float y = in.read_float ();
         float $result = (float)0;
         $result = this.multiply (x, y);
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CalculatorApp/Calculator:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calculator _this() 
  {
    return CalculatorHelper.narrow(
    super._this_object());
  }

  public Calculator _this(org.omg.CORBA.ORB orb) 
  {
    return CalculatorHelper.narrow(
    super._this_object(orb));
  }


} // class CalculatorPOA