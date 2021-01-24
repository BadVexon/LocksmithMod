package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class GoAway extends AbstractTodoCard {

    public final static String ID = makeID("GoAway");

    //stupid intellij stuff SKILL, ALL, UNCOMMON

    private static final int BLOCK = 12;
    private static final int UPG_BLOCK = 2;

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    public GoAway() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ALL);
        baseBlock = BLOCK;
        baseMagicNumber = magicNumber = MAGIC;
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        for (AbstractMonster q : monsterList()) {
            weaken(q, magicNumber);
        }
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
        upgradeMagicNumber(UPG_MAGIC);
    }
}