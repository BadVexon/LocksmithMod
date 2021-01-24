package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class KeyMove extends AbstractTodoCard {

    public final static String ID = makeID("KeyMove");

    //stupid intellij stuff SKILL, ENEMY, BASIC

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    public KeyMove() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = MAGIC;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        weaken(m, magicNumber);
        genKey();
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}