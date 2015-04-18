package calc;

/**
* calc/CalcHolder.java .
* 由 IDL-to-Java 编译器（可移植），版本 "3.2" 生成
* 来自 calc.idl
* 2011年2月23日 星期三 下午09时11分07秒 CST
*/

public final class CalcHolder implements org.omg.CORBA.portable.Streamable
{
  public calc.Calc value = null;

  public CalcHolder ()
  {
  }

  public CalcHolder (calc.Calc initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = calc.CalcHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    calc.CalcHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return calc.CalcHelper.type ();
  }

}
