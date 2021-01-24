package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.DrainingMiasmaPower;

public class DrainingFog extends AbstractTodoCard {

    public final static String ID = makeID("DrainingFog");

    //stupid intellij stuff POWER, SELF, UNCOMMON

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public DrainingFog() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new DrainingMiasmaPower(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}