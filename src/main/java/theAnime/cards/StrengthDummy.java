package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;

public class StrengthDummy extends AbstractTodoCard {

    public final static String ID = makeID("StrengthDummy");

    //stupid intellij stuff SKILL, NONE, UNCOMMON

    private static final int MAGIC = 15;

    public StrengthDummy() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
        baseSilly = silly = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.STRONG, magicNumber, silly));
    }

    public void upp() {
        upgradeSilly(1);
    }
}