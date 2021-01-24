package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;
import theAnime.monsters.ExplodeDummy;

public class ExplodingDummy extends AbstractTodoCard {

    public final static String ID = makeID("ExplodingDummy");

    //stupid intellij stuff SKILL, NONE, COMMON

    private static final int MAGIC = 9;

    public ExplodingDummy() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
        baseSilly = silly = 14;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.EXPLODE, magicNumber, silly));
    }

    public void upp() {
        upgradeSilly(4);
    }
}