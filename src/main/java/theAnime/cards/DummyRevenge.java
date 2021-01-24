package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;
import theAnime.powers.AngryDummyPower;

public class DummyRevenge extends AbstractTodoCard {

    public final static String ID = makeID("DummyRevenge");

    //stupid intellij stuff POWER, SELF, UNCOMMON

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public DummyRevenge() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.EMPTY, 10));
        applyToSelf(new AngryDummyPower(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}