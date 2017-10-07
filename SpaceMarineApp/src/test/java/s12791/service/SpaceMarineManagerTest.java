package s12791.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;
import s12791.domain.SpaceMarine;

@RunWith(JUnit4.class)
public class SpaceMarineManagerTest extends TestCase {
SpaceMarineManager spaceMarineManager;

SpaceMarineManagerImpl impl = new SpaceMarineManagerImpl();

	@Test
	public void testCreateSpaceMarine() throws Exception{
		SpaceMarine sm1= new SpaceMarine("Gabriel", "Thunder Hammer", 5, 5, "Blood Ravens");
		assertEquals(1,impl.createSpaceMarine(sm1));
	}
	@Test
	public void testGetSpaceMarine() throws Exception{
		SpaceMarine sm2= new SpaceMarine("Tarkus", "Bolter", 4, 4, "Blood Ravens");
		impl.createSpaceMarine(sm2);
		assertEquals("Tarkus",impl.getSpaceMarine(0).getName());
		assertEquals("Bolter",impl.getSpaceMarine(0).getWeapon());
		assertEquals(4,impl.getSpaceMarine(0).getBallisticSkill());
		assertEquals(4,impl.getSpaceMarine(0).getWeaponSkill());
		assertEquals("Blood Ravens",impl.getSpaceMarine(0).getChapter());
	}
	@Test
	public void testUpdateSpaceMarine() throws Exception{
		SpaceMarine sm3= new SpaceMarine("Tarkus", "Bolter", 4, 4, "Blood Ravens");
		SpaceMarine sm4= new SpaceMarine("Thaddeus", "Chainsword", 4, 4, "Blood Ravens");

		impl.createSpaceMarine(sm3);

		assertEquals(1,impl.updateSpaceMarine(sm4,0));
		
		assertEquals("Thaddeus",impl.getSpaceMarine(0).getName());
		assertEquals("Chainsword",impl.getSpaceMarine(0).getWeapon());
		assertEquals(4,impl.getSpaceMarine(0).getBallisticSkill());
		assertEquals(4,impl.getSpaceMarine(0).getWeaponSkill());
		assertEquals("Blood Ravens",impl.getSpaceMarine(0).getChapter());
	}
	@Test
	public void testDeleteSpaceMarine() throws Exception{
		SpaceMarine sm1= new SpaceMarine("Gabriel", "Thunder Hammer", 5, 5, "Blood Ravens");
		SpaceMarine sm2= new SpaceMarine("Tarkus", "Bolter", 4, 4, "Blood Ravens");
		SpaceMarine sm3= new SpaceMarine("Thaddeus", "Chainsword", 4, 4, "Blood Ravens");
		impl.createSpaceMarine(sm1);
		impl.createSpaceMarine(sm2);
		impl.createSpaceMarine(sm3);
		
		assertEquals(2,impl.deleteSpaceMarine(1));
	}
	
	
}
