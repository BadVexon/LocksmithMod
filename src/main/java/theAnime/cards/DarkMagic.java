package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.HexxPower;

public class DarkMagic extends AbstractTodoCard {

    public final static String ID = makeID("DarkMagic");

    //stupid intellij stuff SKILL, ENEMY, UNCOMMON

    public DarkMagic() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        lockme(2);
        exhaust = true;
        baseMagicNumber = magicNumber = 7;
        baseSilly = silly = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new HexxPower(m, magicNumber));
        weaken(m, 2);
        expose(m, 2);
    }

    public void upp() {
        upgradeMagicNumber(3);
        upgradeSilly(1);
    }
}