package theAnime.cards;

import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.StuffedWithKeysPower;

public class FriendlyGift extends AbstractTodoCard {

    public final static String ID = makeID("FriendlyGift");

    //stupid intellij stuff SKILL, ENEMY, UNCOMMON

    private static final int MAGIC = 15;
    private static final int UPG_MAGIC = -5;

    public FriendlyGift() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = MAGIC;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new AddTemporaryHPAction(m, p, magicNumber));
        applyToEnemy(m, new StuffedWithKeysPower(m, 3));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}