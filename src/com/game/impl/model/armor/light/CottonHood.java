package com.game.impl.model.armor.light;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;

public class CottonHood extends Armor {
	public int defense = 10;
	@Override
	public ArmorType getArmorType() {
		
		return ArmorType.LIGHT;
	}

}
