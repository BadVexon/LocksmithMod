package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class LockBlock extends AbstractTodoCard {

    public final static String ID = makeID("LockBlock");

    //stupid intellij stuff SKILL, SELF, COMMON

    private static final int BLOCK = 11;
    private static final int UPG_BLOCK = 3;

    public LockBlock() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = BLOCK;
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
    }
}