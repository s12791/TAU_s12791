package s12791.service;

import java.util.List;

import s12791.domain.SpaceMarine;

public interface SpaceMarineManager {

	public int createSpaceMarine(SpaceMarine spaceMarine);
	public SpaceMarine getSpaceMarine(SpaceMarine spaceMarine);
	public int updateSpaceMarine(SpaceMarine spaceMarine);
	public int deleteSpaceMarine(SpaceMarine spaceMarine);
	
	public List<SpaceMarine> getAllSpaceMarines();
}
