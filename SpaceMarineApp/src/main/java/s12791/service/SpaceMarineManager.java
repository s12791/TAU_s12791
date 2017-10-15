package s12791.service;

import java.util.List;

import s12791.domain.SpaceMarine;

public interface SpaceMarineManager {

	public int createSpaceMarine(SpaceMarine spaceMarine);
	public SpaceMarine getSpaceMarine(int id);
	public int updateSpaceMarine(SpaceMarine spaceMarine, int id) throws IndexOutOfBoundsException;
	public int deleteSpaceMarine(int id);
	
	public List<SpaceMarine> getAllSpaceMarines();
}
