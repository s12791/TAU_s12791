package s12791.domain;

public class SpaceMarine {
	private long id;
	private String name;
	private String weapon;
	private int weaponSkill;
	private int ballisticSkill;
	private String chapter;

	@Override
	public String toString() {
		return "SpaceMarine [id=" + id + ", name=" + name + ", weapon=" + weapon + ", weaponSkill=" + weaponSkill
				+ ", ballisticSkill=" + ballisticSkill + ", chapter=" + chapter + "]";
	}

	public SpaceMarine(String name, String weapon, int weaponSkill, int ballisticSkill, String chapter) {
		this.name = name;
		this.weapon = weapon;
		this.weaponSkill = weaponSkill;
		this.ballisticSkill = ballisticSkill;
		this.chapter = chapter;
	}

	public SpaceMarine() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getWeaponSkill() {
		return weaponSkill;
	}

	public void setWeaponSkill(int weaponSkill) {
		this.weaponSkill = weaponSkill;
	}

	public int getBallisticSkill() {
		return ballisticSkill;
	}

	public void setBallisticSkill(int ballisticSkill) {
		this.ballisticSkill = ballisticSkill;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}


}