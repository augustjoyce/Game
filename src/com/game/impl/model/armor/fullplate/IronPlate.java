package com.game.impl.model.armor.fullplate;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;

public class IronPlate extends Armor {
	
	public int defense = 10;
	@Override
	public ArmorType getArmorType() {
		return ArmorType.FULLPLATE;
	}

}
