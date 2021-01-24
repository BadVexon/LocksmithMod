package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.HexxPower;

public class DarkDoom extends AbstractTodoCard {

    public final static String ID = makeID("DarkDoom");

    //stupid intellij stuff SKILL, ENEMY, RARE

    private static final int MAGIC = 12;
    private static final int UPG_MAGIC = 4;

    public DarkDoom() {
        super(ID, 1, CardType.SKILL, CardRarity.RARE, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = MAGIC;
        lockme(3);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new HexxPower(m, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}