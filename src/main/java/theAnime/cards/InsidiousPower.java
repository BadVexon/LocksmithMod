package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.InsidiousPowerPower;

public class InsidiousPower extends AbstractTodoCard {

    public final static String ID = makeID("InsidiousPower");

    //stupid intellij stuff POWER, SELF, RARE

    public InsidiousPower() {
        super(ID, 0, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new InsidiousPowerPower(1));
    }

    public void upp() {
        isInnate = true;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}