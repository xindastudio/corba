package test;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;

import calc.Calc;

public class CalcServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] params = new String[]{"-ORBInitialPort", "9999"};
		ORB orb = ORB.init(params, null);
		try {
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("RootPOA");
			
			org.omg.PortableServer.POA calcPOA = org.omg.PortableServer.POAHelper.narrow(objRef);
			org.omg.PortableServer.POAManager manager = calcPOA.the_POAManager();
			
			CalcImpl calcImpl = new CalcImpl();
			Calc calc = calcImpl._this(orb);
			
			NamingContext ncRef = NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));
			NameComponent nc = new NameComponent("Calc", "");
			NameComponent path[] = { nc };
			ncRef.rebind(path, calc);
			
			manager.activate();
			System.out.println("Calc service start...");
			
			orb.run();
		} catch (InvalidName e) {
			e.printStackTrace();
		} catch (NotFound e) {
			e.printStackTrace();
		} catch (CannotProceed e) {
			e.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e) {
			e.printStackTrace();
		} catch (AdapterInactive e) {
			e.printStackTrace();
		}
	}

}
