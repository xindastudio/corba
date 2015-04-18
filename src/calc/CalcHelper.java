package calc;


/**
* calc/CalcHelper.java .
* 由 IDL-to-Java 编译器（可移植），版本 "3.2" 生成
* 来自 calc.idl
* 2011年2月23日 星期三 下午09时11分07秒 CST
*/

abstract public class CalcHelper
{
  private static String  _id = "IDL:calc/Calc:1.0";

  public static void insert (org.omg.CORBA.Any a, calc.Calc that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static calc.Calc extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (calc.CalcHelper.id (), "Calc");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static calc.Calc read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_CalcStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, calc.Calc value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static calc.Calc narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof calc.Calc)
      return (calc.Calc)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      calc._CalcStub stub = new calc._CalcStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static calc.Calc unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof calc.Calc)
      return (calc.Calc)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      calc._CalcStub stub = new calc._CalcStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
