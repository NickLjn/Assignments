package ATM;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class AtmTest {
    Atm atm = new Atm(9000,1);
    User jack = new User("jack",21,"wa","12345","002");	
    User marry = new User("marry",22,"wa","23456","003");
    UserData jackud = new UserData(jack,"002");
    UserData marryud = new UserData(marry,"003");
	
    @Before
    public void before() {
    	atm.userDataBase.add(jackud);
    	atm.userDataBase.add(marryud);
    }

	@Test
	public void testAtm() {
		atm.current = jackud;
		assertEquals("password","002");
		assertEquals("user","jack");
	}

	@Test
	public void testUserType() {
		assertEquals(atm.createNewUser(),atm.sc.nextInt() == 1);
	}

	@Test
	public void testCreateNewUser() {
		assertEquals("name",atm.sc.next());
		assertEquals("age",atm.sc.next());
		assertEquals("address",atm.sc.next());
		assertEquals("phonenumber",atm.sc.next());
		assertEquals("bankaccount",atm.sc.next());
		assertEquals("password",atm.sc.next());
	}

	@Test
	public void testForgotPassword() {

	}

	@Test
	public void testReset() {
		assertEquals("name",atm.sc.next());
		assertEquals("age",atm.sc.next());
		assertEquals("phonenumber",atm.sc.next());
	}

	@Test
	public void testLogin() {
		for(int i = 0; i < atm.userDataBase.size(); i++){
			UserData ud = atm.userDataBase.get(i);
			assertEquals(ud,atm.userDataBase.iterator());
		}
	}

	@Test
	public void testManage() {

	}

	@Test
	public void testAvailableBalance() {
		atm.current = jackud;
		jackud.setBalance(100.0);
		assertEquals(100.0, atm.availableBalance() , 0.0001);
		jackud.setBalance(2.0);
		assertEquals(2.0, atm.availableBalance() , 0.0001);
	}

	@Test
	public void testWithDraw() {
		atm.current = marryud;
		double withdraw = atm.sc.nextDouble();
		double balance = atm.current.getBalance();
		assertEquals(balance,withdraw);
		
	}

	@Test
	public void testDeposit() {
		atm.current = jackud;
		double balance = atm.current.getBalance();
		double deposit = atm.sc.nextDouble();
		assertEquals(balance,deposit);
	}

	@Test
	public void testRecentTransaction() {
		atm.current = marryud;
		assertEquals(0.0,atm.current.getTransaction());
	}

	@Test
	public void testChangePassword() {

	}
}
