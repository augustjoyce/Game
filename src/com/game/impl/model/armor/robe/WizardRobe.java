package com.game.impl.model.armor.robe;

import com.game.api.model.armor.Armor;
import com.game.api.model.armor.ArmorType;

public class WizardRobe extends Armor {
	public int defense = 10;
	@Override
	public ArmorType getArmorType() {
		
		return ArmorType.ROBE;
	}

}
