package calc;

/**
* calc/CalcHolder.java .
* �� IDL-to-Java ������������ֲ�����汾 "3.2" ����
* ���� calc.idl
* 2011��2��23�� ������ ����09ʱ11��07�� CST
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
