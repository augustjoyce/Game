package com.game.impl.model.armor.robe;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;

public class AngelRobe extends Armor {
	public int defense = 20;
	@Override
	public ArmorType getArmorType() {
		return ArmorType.ROBE;
	}

}
