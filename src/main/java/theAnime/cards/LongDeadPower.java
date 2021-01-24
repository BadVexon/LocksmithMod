package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class LongDeadPower extends AbstractTodoCard {

    public final static String ID = makeID("LongDeadPower");

    //stupid intellij stuff ATTACK, SELF_AND_ENEMY, UNCOMMON

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 4;

    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 1;

    public LongDeadPower() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = MAGIC;
        lockme(4);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        applyToSelf(new StrengthPower(p, magicNumber));
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeMagicNumber(UPG_MAGIC);
    }
}