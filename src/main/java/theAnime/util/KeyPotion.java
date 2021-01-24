package theAnime.util;

import basemod.abstracts.CustomPotion;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.helpers.PowerTip;
import com.megacrit.cardcrawl.localization.PotionStrings;
import theAnime.AnimeMod;
import theAnime.cards.Key;

public class KeyPotion extends CustomPotion {
    public static final String POTION_ID = "locksmith:KeyPotion";

    public KeyPotion() {
        super("Key Potion", POTION_ID, PotionRarity.UNCOMMON, PotionSize.BOTTLE, PotionColor.WEAK);
        this.isThrown = false;
        this.targetRequired = false;
        this.labOutlineColor = AnimeMod.todoColor;
    }

    public void initializeData() {
        this.potency = getPotency();
        this.description = ("Add #b" + this.potency + " #yKeys into your hand.");
        this.tips.clear();
        this.tips.add(new PowerTip(this.name, this.description));
    }

    public void use(AbstractCreature target) {
        addToBot(new MakeTempCardInHandAction(new Key(), potency));
    }

    public CustomPotion makeCopy() {
        return new KeyPotion();
    }

    public int getPotency(int ascensionLevel) {
        return 3;
    }
}


