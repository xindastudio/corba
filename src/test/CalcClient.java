package test;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import calc.Calc;
import calc.CalcHelper;

public class CalcClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] params = new String[]{"-ORBInitialPort", "9999"};
		ORB orb = ORB.init(params, null);
		try {
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			
			NamingContext ncRef = NamingContextHelper.narrow(objRef);
			NameComponent nc = new NameComponent("Calc", "");
			NameComponent[] path = { nc };
			
			Calc calc = CalcHelper.narrow(ncRef.resolve(path));
			
			System.out.println("100 + 98 = " + calc.add(100, 98));
		} catch (InvalidName e) {
			e.printStackTrace();
		} catch (NotFound e) {
			e.printStackTrace();
		} catch (CannotProceed e) {
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		}
		
	}

}
