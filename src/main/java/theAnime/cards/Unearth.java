package theAnime.cards;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.UnearthAction;

public class Unearth extends AbstractTodoCard {

    public final static String ID = makeID("Unearth");

    //stupid intellij stuff SKILL, SELF, UNCOMMON

    public Unearth() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        exhaust = true;
        lockme(2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new UnearthAction());
    }

    public void upp() {
        exhaust = false;
        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, 2);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, 2);
        ExhaustiveField.ExhaustiveFields.isExhaustiveUpgraded.set(this, true);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}