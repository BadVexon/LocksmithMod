package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.AttackingDummiesPower;
import theAnime.powers.TsunderePower;

public class DDummy extends AbstractTodoCard {

    public final static String ID = makeID("DDummy");

    //stupid intellij stuff POWER, SELF, UNCOMMON

    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 3;

    public DDummy() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new AttackingDummiesPower(1));
        applyToSelf(new TsunderePower(magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
    }
}