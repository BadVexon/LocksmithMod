package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.BurdenPower;

public class Burden extends AbstractTodoCard {

    public final static String ID = makeID("Burden");

    //stupid intellij stuff SKILL, SELF, RARE

    public Burden() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new BurdenPower(1));
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}