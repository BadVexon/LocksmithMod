package theAnime.cardmods;

import basemod.abstracts.AbstractCardModifier;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class KeybladeModifier extends AbstractCardModifier {

    private int bonusDamage;
    private String oldName = null;

    public KeybladeModifier(int bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    @Override
    public void onInitialApplication(AbstractCard card) {
        card.name = card.name + "blade";
        card.baseDamage += bonusDamage;
    }

    @Override
    public void onRemove(AbstractCard card) {
        card.name = oldName;
        card.baseDamage -= bonusDamage;
    }

    @Override
    public AbstractCardModifier makeCopy() {
        return new KeybladeModifier(bonusDamage);
    }
}
