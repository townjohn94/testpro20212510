package auth;

import static org.junit.Assert.*;

import org.junit.Test;

import Authorization.DataBase;

public class DataTest {

	@Test
	public void test() {
		DataBase bus = new DataBase();
		assertNull(bus.useres);
	}

}
