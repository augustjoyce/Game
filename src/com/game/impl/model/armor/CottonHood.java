package com.game.impl.model.armor;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;

public class CottonHood extends Armor {

	@Override
	public ArmorType getArmorType() {
		
		return ArmorType.LIGHT;
	}

}
