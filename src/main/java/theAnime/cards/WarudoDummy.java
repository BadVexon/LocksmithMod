package theAnime.cards;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;

public class WarudoDummy extends AbstractTodoCard {

    public final static String ID = makeID("WarudoDummy");

    //stupid intellij stuff SKILL, NONE, RARE

    private static final int MAGIC = 30;

    public WarudoDummy() {
        super(ID, 2, CardType.SKILL, CardRarity.RARE, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
        lockme(2);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.DIO, magicNumber));
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