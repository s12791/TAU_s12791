package s12791.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import s12791.domain.SpaceMarine;

public class SpaceMarineAction {

	private SpaceMarineManagerImpl spaceMarineManagerImpl;

	public void setDataSource(SpaceMarineManagerImpl spaceMarineManagerImpl) {
		this.spaceMarineManagerImpl = spaceMarineManagerImpl;
	}

	public List<SpaceMarine> findRecordsByRegex(String regexString) {
		if (regexString == null) {
			throw new IllegalArgumentException("regex string required!");
		}
		
		List<SpaceMarine> matches = new ArrayList<SpaceMarine>();
		List<SpaceMarine> list = spaceMarineManagerImpl.getAllSpaceMarines();
		if (list == null) {
			return matches;
		}
		
		Pattern p = Pattern.compile(regexString);
		for (SpaceMarine s : list) {
			if (p.matcher(s.getChapter()).matches()) {
				matches.add(s);
			}
		}

		return matches;
	}

	/**
	 * Delete all SpaceMarine-s from DB.
	 * @param spaceMarinesToRemove
	 * @return information if all SpaceMarine-s were successfully deleted.
	 */
	public boolean deleteSpaceMarines(List<SpaceMarine> spaceMarinesToDelete) {
		if (spaceMarinesToDelete == null) {
			throw new IllegalArgumentException("list must not be null");
		}
		
		boolean successfulDelete = true;
		
		for (SpaceMarine spaceMarine : spaceMarinesToDelete) {
			boolean result = spaceMarineManagerImpl.deleteSpaceMarine(spaceMarine.getId());
			if (result == false) {
				successfulDelete = false;
			}
		}
		return successfulDelete;
	}

}