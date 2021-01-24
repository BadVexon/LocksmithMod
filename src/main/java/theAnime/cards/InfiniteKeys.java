package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.InfiniteKeysPower;

public class InfiniteKeys extends AbstractTodoCard {

    public final static String ID = makeID("InfiniteKeys");

    //stupid intellij stuff POWER, SELF, RARE

    public InfiniteKeys() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new InfiniteKeysPower(1));
    }

    public void upp() {
        isInnate = true;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}