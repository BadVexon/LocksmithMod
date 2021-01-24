package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SkeletonKey extends AbstractTodoCard {

    public final static String ID = makeID("SkeletonKey");

    //stupid intellij stuff SKILL, SELF, RARE

    public SkeletonKey() {
        super(ID, 2, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        makeInHand(new Key(), 5);
    }

    public void upp() {
        upgradeBaseCost(1);
    }
}