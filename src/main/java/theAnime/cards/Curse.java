package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.HexxPower;

public class Curse extends AbstractTodoCard {

    public final static String ID = makeID("Curse");

    //stupid intellij stuff SKILL, ENEMY, COMMON

    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 2;

    public Curse() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = MAGIC;
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new HexxPower(m, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}