package com.game.impl.model.armor.fullplate;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;

public class SteelPlate extends Armor {
	public int defense = 20;
	@Override
	public ArmorType getArmorType() {
		return ArmorType.FULLPLATE;
	}

}
