package s12791.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import s12791.domain.SpaceMarine;

@RunWith(MockitoJUnitRunner.class)
public class SpaceMarineActionTest {
	// class under test:
	SpaceMarineAction spaceMarineAction = new SpaceMarineAction();

	@Mock
	SpaceMarineDao mockedSpaceMarineDao;

	SpaceMarine sm1 = new SpaceMarine("Gabriel", "Thunder Hammer", 5, 5, "Blood Ravens");
	SpaceMarine sm2 = new SpaceMarine("Tarkus", "Bolter", 4, 4, "Blood Ravens");
	SpaceMarine sm3 = new SpaceMarine("Thaddeus", "Chainsword", 4, 4, "Rabbits");

	@Before
	public void setup() {
		Assert.assertNotNull(mockedSpaceMarineDao);
		spaceMarineAction.setDataSource(mockedSpaceMarineDao);
	}

	@Test
	public void findRecordsByRegexTest() {
		List<SpaceMarine> mySmList = new ArrayList<SpaceMarine>();
		mySmList.add(sm1);
		mySmList.add(sm2);
		mySmList.add(sm3);
		when(mockedSpaceMarineDao.getAllSpaceMarines()).thenReturn(mySmList);

		// test
		List<SpaceMarine> resultList = spaceMarineAction.findRecordsByRegex("Blood Ravens");

		// verify
		Assert.assertEquals(2, resultList.size());
		Mockito.verify(mockedSpaceMarineDao, Mockito.times(1)).getAllSpaceMarines();
	}

	@Test
	public void findRecordsByRegexTestWhenNoMarinesFoundInDB() {
		when(mockedSpaceMarineDao.getAllSpaceMarines()).thenReturn(null);

		// test
		List<SpaceMarine> resultList = spaceMarineAction.findRecordsByRegex("Blood Ravens");

		// verify
		Assert.assertEquals(0, resultList.size());
		Mockito.verify(mockedSpaceMarineDao, Mockito.times(1)).getAllSpaceMarines();
	}

	@Test(expected = IllegalArgumentException.class)
	public void findRecordsByRegexTestWhenNullInput() {
		when(mockedSpaceMarineDao.getAllSpaceMarines()).thenReturn(null);

		// test
		spaceMarineAction.findRecordsByRegex(null);
		Assert.fail("exception expected");
	}

	@Test
	public void deleteSpaceMarinesTestWhenDeleteSuccessful() {

		List<SpaceMarine> mySmList = new ArrayList<SpaceMarine>();
		mySmList.add(sm1);
		mySmList.add(sm2);
		mySmList.add(sm3);
		when(mockedSpaceMarineDao.deleteSpaceMarine(Matchers.eq(sm1.getId()))).thenReturn(true);
		when(mockedSpaceMarineDao.deleteSpaceMarine(Matchers.eq(sm2.getId()))).thenReturn(true);
		when(mockedSpaceMarineDao.deleteSpaceMarine(Matchers.eq(sm3.getId()))).thenReturn(true);

		// test
		boolean result = spaceMarineAction.deleteSpaceMarines(mySmList);

		// verify
		Assert.assertTrue(result);
		Mockito.verify(mockedSpaceMarineDao, Mockito.times(3)).deleteSpaceMarine(Mockito.anyLong());

	}

	@Test
	public void deleteSpaceMarinesTestWhenPartiallySuccessful() {
		List<SpaceMarine> mySmList = new ArrayList<SpaceMarine>();
		mySmList.add(sm1);
		mySmList.add(sm2);
		mySmList.add(sm3);
		when(mockedSpaceMarineDao.deleteSpaceMarine(Matchers.eq(sm1.getId()))).thenReturn(true);
		when(mockedSpaceMarineDao.deleteSpaceMarine(Matchers.eq(sm2.getId()))).thenReturn(true);
		when(mockedSpaceMarineDao.deleteSpaceMarine(Matchers.eq(sm3.getId()))).thenReturn(false);

		// test
		boolean result = spaceMarineAction.deleteSpaceMarines(mySmList);

		// verify
		Assert.assertFalse(result);
		Mockito.verify(mockedSpaceMarineDao, Mockito.times(3)).deleteSpaceMarine(Mockito.anyLong());
	}

	@Test(expected = NullPointerException.class)
	public void deleteSpaceMarinesTestWhenNullInput() {
		List<SpaceMarine> mySmList = null;
		when(mockedSpaceMarineDao.deleteSpaceMarine(Matchers.eq(sm1.getId()))).thenReturn(false);

		// test
		spaceMarineAction.deleteSpaceMarines(mySmList);
	}
}