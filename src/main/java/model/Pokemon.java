package model;

public class Pokemon {
	
	private String name, type, abilities;
	private int id, hp, att, def, special_att, special_def, spd;
	
	public Pokemon(String name, String type, String abilities, int hp, int att, int def, int special_att, int special_def, int spd) {
		this.name = name;
		this.type = type;
		this.abilities = abilities;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.special_att = special_att;
		this.special_def = special_def;
		this.spd = spd;
	}
	
	public Pokemon(int id, String name, String type, String abilities, int hp, int att, int def, int special_att, int special_def, int spd) {
		this.name = name;
		this.type = type;
		this.abilities = abilities;
		this.id = id;
		this.hp = hp;
		this.att = att;
		this.def = def;
		this.special_att = special_att;
		this.special_def = special_def;
		this.spd = spd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAbilities() {
		return abilities;
	}

	public void setAbilities(String abilities) {
		this.abilities = abilities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpecial_att() {
		return special_att;
	}

	public void setSpecial_att(int special_att) {
		this.special_att = special_att;
	}

	public int getSpecial_def() {
		return special_def;
	}

	public void setSpecial_def(int special_def) {
		this.special_def = special_def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}
	
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", type=" + type + ", abilities=" + abilities + ", id=" + id + ", hp=" + hp
				+ ", att=" + att + ", def=" + def + ", special_att=" + special_att + ", special_def=" + special_def
				+ ", spd=" + spd + "]";
	}

	
}
