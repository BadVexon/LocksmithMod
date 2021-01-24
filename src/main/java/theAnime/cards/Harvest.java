package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SearchDummyAction;

public class Harvest extends AbstractTodoCard {

    public final static String ID = makeID("Harvest");

    //stupid intellij stuff SKILL, NONE, RARE

    private static final int MAGIC = 10;

    public Harvest() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.NONE);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SearchDummyAction(magicNumber));
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}