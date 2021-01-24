package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;

public class ShieldingDummy extends AbstractTodoCard {

    public final static String ID = makeID("ShieldingDummy");

    //stupid intellij stuff SKILL, NONE, UNCOMMON

    private static final int MAGIC = 18;
    private static final int UPG_MAGIC = 6;

    public ShieldingDummy() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.SHIELDING, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}