package theAnime.util;

import basemod.abstracts.DynamicVariable;
import com.megacrit.cardcrawl.cards.AbstractCard;
import theAnime.cards.AbstractTodoCard;

public class SecondDamage extends DynamicVariable {

    @Override
    public String key() {
        return "sddy";
    } //TODO: change to something else!

    @Override
    public boolean isModified(AbstractCard card) {
        return ((AbstractTodoCard) card).isSecondDamageModified;
    }

    public void setIsModified(AbstractCard card, boolean v) {
        if (card instanceof AbstractTodoCard) {
            ((AbstractTodoCard) card).isSecondDamageModified = v;
        }
    }

    @Override
    public int value(AbstractCard card) {
        return ((AbstractTodoCard) card).secondDamage;
    }

    @Override
    public int baseValue(AbstractCard card) {
        return ((AbstractTodoCard) card).baseSecondDamage;
    }

    @Override
    public boolean upgraded(AbstractCard card) {
        return ((AbstractTodoCard) card).upgradedSecondDamage;
    }
}