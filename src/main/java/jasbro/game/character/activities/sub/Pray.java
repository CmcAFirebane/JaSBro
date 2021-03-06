package jasbro.game.character.activities.sub;

import jasbro.Util;
import jasbro.game.character.activities.RunningActivity;
import jasbro.game.character.attributes.BaseAttributeTypes;
import jasbro.game.character.attributes.EssentialAttributes;
import jasbro.game.character.attributes.Sextype;
import jasbro.game.character.conditions.Buff;
import jasbro.game.character.specialization.SpecializationAttribute;
import jasbro.game.events.MessageData;
import jasbro.gui.pictures.ImageTag;
import jasbro.gui.pictures.ImageUtil;
import jasbro.texts.TextUtil;

import java.util.ArrayList;
import java.util.List;

public class Pray extends RunningActivity {
	int randomBlessing=Util.getInt(1, 100);
	int charismaBonus=0;
	int intellBonus=0;
	int staminaBonus=0;
	int strengthBonus=0;
	int seductionBonus=0;
	int maidBonus=0;
	int groupBonus=0;
	int bondageBonus=0;
	int monsterBonus=0;
	int bartendBonus=0;
	int danceBonus=0;
	int fightBonus=0;
	int advBonus=0;
	int sexBonus=0;
	int medBonus=0;
	int stealBonus=0;
	
	


	@Override
	public MessageData getBaseMessage() {
		String message = TextUtil.t("pray.basic", getCharacters());
		message+="\n";


		if(randomBlessing<20){
			message += TextUtil.t("pray.nothing", getCharacters());
		}
		else if (randomBlessing<22){
			message += TextUtil.t("pray.charisma", getCharacters());
		}
		else if (randomBlessing<24){
			message += TextUtil.t("pray.intell", getCharacters());
		}
		else if (randomBlessing<26){
			message += TextUtil.t("pray.strength", getCharacters());
		}
		else if (randomBlessing<28){
			message += TextUtil.t("pray.stamina", getCharacters());
		}
		else if (randomBlessing<30){
			message += TextUtil.t("pray.whore", getCharacters());
		}
		else if (randomBlessing<35){
			message += TextUtil.t("pray.bartend", getCharacters());
		}
		else if (randomBlessing<40){
			message += TextUtil.t("pray.dance", getCharacters());
		}
		else if (randomBlessing<45){
			message += TextUtil.t("pray.steal", getCharacters());
		}
		else if (randomBlessing<50){
			message += TextUtil.t("pray.maid", getCharacters());
		}
		else if (randomBlessing<55){
			message += TextUtil.t("pray.group", getCharacters());
		}
		else if (randomBlessing<60){
			message += TextUtil.t("pray.monster", getCharacters());
		}
		else if (randomBlessing<65){
			message += TextUtil.t("pray.sex", getCharacters());
		}
		else if (randomBlessing<70){
			message += TextUtil.t("pray.bondage", getCharacters());
		}
		else if (randomBlessing<75){
			message += TextUtil.t("pray.medic", getCharacters());
		}
		else if (randomBlessing<80){
			message += TextUtil.t("pray.fight", getCharacters());
		}
		else{
			message += TextUtil.t("pray.motivated", getCharacters());
			getCharacter().addCondition(new Buff.MotivatedTwo(getCharacter()));
		}





		return new MessageData(message, ImageUtil.getInstance().getImageDataByTag(ImageTag.CLOTHED, getCharacter()), getCharacterLocation().getImage());
	}

	@Override
	public List<ModificationData> getStatModifications() {
		
		if (randomBlessing<22 && randomBlessing>=20){
			charismaBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<24){
			intellBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<26){
			strengthBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<28){
			staminaBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<30){
			seductionBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<35){
			bartendBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<40){
			danceBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<45){
			stealBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<50){
			maidBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<55){
			groupBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<60){
			monsterBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<65){
			sexBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<70){
			bondageBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<75){
			medBonus+=Util.getInt(1, 100);
		}
		else if (randomBlessing<80){
			fightBonus+=Util.getInt(1, 100);
		}

		

		List<ModificationData> modifications = new ArrayList<RunningActivity.ModificationData>();
		modifications.add(new ModificationData(TargetType.ALL, -15f, EssentialAttributes.ENERGY));
		
		modifications.add(new ModificationData(TargetType.ALL, charismaBonus*0.005f, BaseAttributeTypes.CHARISMA));
		modifications.add(new ModificationData(TargetType.ALL, intellBonus*0.005f, BaseAttributeTypes.INTELLIGENCE));
		modifications.add(new ModificationData(TargetType.ALL, staminaBonus*0.005f, BaseAttributeTypes.STAMINA));
		modifications.add(new ModificationData(TargetType.ALL, strengthBonus*0.005f, BaseAttributeTypes.STRENGTH));
		
		modifications.add(new ModificationData(TargetType.ALL, seductionBonus*0.05f, SpecializationAttribute.SEDUCTION));
		modifications.add(new ModificationData(TargetType.ALL, maidBonus*0.05f, SpecializationAttribute.CLEANING));
		modifications.add(new ModificationData(TargetType.ALL, maidBonus*0.05f, SpecializationAttribute.COOKING));
		modifications.add(new ModificationData(TargetType.ALL, danceBonus*0.05f, SpecializationAttribute.STRIP));
		modifications.add(new ModificationData(TargetType.ALL, bartendBonus*0.05f, SpecializationAttribute.BARTENDING));
		modifications.add(new ModificationData(TargetType.ALL, medBonus*0.05f, SpecializationAttribute.MEDICALKNOWLEDGE));
		modifications.add(new ModificationData(TargetType.ALL, medBonus*0.05f, SpecializationAttribute.WELLNESS));
		modifications.add(new ModificationData(TargetType.ALL, stealBonus*0.05f, SpecializationAttribute.PICKPOCKETING));
		modifications.add(new ModificationData(TargetType.ALL, fightBonus*0.05f, SpecializationAttribute.VETERAN));
		modifications.add(new ModificationData(TargetType.ALL, sexBonus*0.05f, Sextype.ANAL));
		modifications.add(new ModificationData(TargetType.ALL, sexBonus*0.05f, Sextype.VAGINAL));
		modifications.add(new ModificationData(TargetType.ALL, sexBonus*0.05f, Sextype.ORAL));
		modifications.add(new ModificationData(TargetType.ALL, sexBonus*0.05f, Sextype.TITFUCK));
		modifications.add(new ModificationData(TargetType.ALL, sexBonus*0.05f, Sextype.FOREPLAY));
		modifications.add(new ModificationData(TargetType.ALL, groupBonus*0.05f, Sextype.GROUP));
		modifications.add(new ModificationData(TargetType.ALL, monsterBonus*0.05f, Sextype.MONSTER));
		modifications.add(new ModificationData(TargetType.ALL, bondageBonus*0.05f, Sextype.BONDAGE));
		
		

		return modifications;
	}
}
