package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;
import theAnime.monsters.BlockDummy;

public class PuppetGuard extends AbstractTodoCard {

    public final static String ID = makeID("PuppetGuard");

    //stupid intellij stuff SKILL, NONE, COMMON

    private static final int MAGIC = 9;
    private static final int UPG_MAGIC = 3;

    public PuppetGuard() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.BLOCK, 6, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}