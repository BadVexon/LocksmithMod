package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Prep extends AbstractTodoCard {

    public final static String ID = makeID("Prep");

    //stupid intellij stuff SKILL, ENEMY, COMMON

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    public Prep() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = MAGIC;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        genKey();
        for (int i = 0; i < magicNumber; i++)
            equalize(m);
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}