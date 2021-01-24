package theAnime.cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BlockBurnDraw extends AbstractTodoCard {

    public final static String ID = makeID("BlockBurnDraw");

    //stupid intellij stuff SKILL, SELF, UNCOMMON

    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 2;

    public BlockBurnDraw() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = BLOCK;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        atb(new ExhaustAction(1, !upgraded, false, false));
        atb(new DrawCardAction(2));
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}