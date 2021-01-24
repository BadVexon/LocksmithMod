package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.SlowSappingPower;

public class SlowSapping extends AbstractTodoCard {

    public final static String ID = makeID("SlowSapping");

    //stupid intellij stuff POWER, SELF, RARE

    public SlowSapping() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        lockme(2);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new SlowSappingPower(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}