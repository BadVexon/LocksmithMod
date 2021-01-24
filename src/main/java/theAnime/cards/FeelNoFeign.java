package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.FeelNoFeignPower;

public class FeelNoFeign extends AbstractTodoCard {

    public final static String ID = makeID("FeelNoFeign");

    //stupid intellij stuff POWER, SELF, UNCOMMON

    private static final int MAGIC = 2;

    public FeelNoFeign() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new FeelNoFeignPower(magicNumber));
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}