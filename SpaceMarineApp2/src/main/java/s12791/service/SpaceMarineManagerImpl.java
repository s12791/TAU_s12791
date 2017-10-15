package s12791.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import s12791.domain.SpaceMarine;

public class SpaceMarineManagerImpl implements SpaceMarineManager{

	private Map<Integer,SpaceMarine> treeMapDb = new TreeMap<Integer,SpaceMarine>();
	
	public int createSpaceMarine(SpaceMarine spaceMarine) {
		spaceMarine.setId(treeMapDb.size());
		treeMapDb.put(treeMapDb.size(), spaceMarine);
		return treeMapDb.size();
	}

	public SpaceMarine getSpaceMarine(int id) {
		SpaceMarine spaceMarine = new SpaceMarine();
		spaceMarine = (treeMapDb.get(id));
		return spaceMarine;
	}

	public int updateSpaceMarine(SpaceMarine spaceMarine,int id) {
		if (treeMapDb.containsKey(id)) {
			treeMapDb.remove(id);
			spaceMarine.setId(id);
			treeMapDb.put(id,spaceMarine);
			
		}
		return treeMapDb.size();
	}

	public int deleteSpaceMarine(int id) {
		if (treeMapDb.containsKey(id)) {
			treeMapDb.remove(id);
		}
		return treeMapDb.size();
	}

	public List<SpaceMarine> getAllSpaceMarines() {
		List <SpaceMarine> listOfSpaceMarines = new ArrayList<SpaceMarine>(treeMapDb.values());	
		return listOfSpaceMarines;
	}

}
