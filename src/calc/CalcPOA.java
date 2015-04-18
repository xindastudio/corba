package calc;


/**
* calc/CalcPOA.java .
* �� IDL-to-Java ������������ֲ�����汾 "3.2" ����
* ���� calc.idl
* 2011��2��23�� ������ ����09ʱ11��07�� CST
*/

public abstract class CalcPOA extends org.omg.PortableServer.Servant
 implements calc.CalcOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("add", new java.lang.Integer (0));
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
       case 0:  // calc/Calc/add
       {
         int a = in.read_long ();
         int b = in.read_long ();
         int $result = (int)0;
         $result = this.add (a, b);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:calc/Calc:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Calc _this() 
  {
    return CalcHelper.narrow(
    super._this_object());
  }

  public Calc _this(org.omg.CORBA.ORB orb) 
  {
    return CalcHelper.narrow(
    super._this_object(orb));
  }


} // class CalcPOA
