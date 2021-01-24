package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;
import theAnime.monsters.HexxDummy;

public class HexingDummy extends AbstractTodoCard {

    public final static String ID = makeID("HexingDummy");

    //stupid intellij stuff SKILL, NONE, UNCOMMON

    private static final int MAGIC = 12;
    private static final int UPG_MAGIC = 4;

    public HexingDummy() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
        lockme(2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.HEXX, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}