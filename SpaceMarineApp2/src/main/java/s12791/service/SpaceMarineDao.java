package s12791.service;

import java.util.List;
import s12791.domain.SpaceMarine;

public interface SpaceMarineDao {

	/**
	 * @param spaceMarine
	 * @return true when SpaceMarine created
	 */
	public boolean createSpaceMarine(SpaceMarine spaceMarine);

	public SpaceMarine getSpaceMarine(long id);

	public int updateSpaceMarine(SpaceMarine spaceMarine, long id);

	/**
	 * @param id - SpaceMarine ID
	 * @return true when SpaceMarine deleted
	 */
	public boolean deleteSpaceMarine(long id);

	public List<SpaceMarine> getAllSpaceMarines();

}
