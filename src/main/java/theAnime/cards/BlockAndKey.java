package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BlockAndKey extends AbstractTodoCard {

    public final static String ID = makeID("BlockAndKey");

    //stupid intellij stuff SKILL, SELF, COMMON

    private static final int BLOCK = 6;
    private static final int UPG_BLOCK = 3;

    public BlockAndKey() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = BLOCK;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        genKey();
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
    }
}