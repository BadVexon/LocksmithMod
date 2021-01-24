package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class HiddenPower extends AbstractTodoCard {

    public final static String ID = makeID("HiddenPower");

    //stupid intellij stuff SKILL, SELF, COMMON

    public HiddenPower() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new StrengthPower(p, 1));
    }

    public void upp() {
        upgradeBaseCost(0);
    }
}