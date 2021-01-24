package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.HexxPower;

public class SlamCrush extends AbstractTodoCard {

    public final static String ID = makeID("SlamCrush");

    //stupid intellij stuff ATTACK, ENEMY, RARE

    private static final int DAMAGE = 16;
    private static final int UPG_DAMAGE = 4;

    private static final int MAGIC = 16;
    private static final int UPG_MAGIC = 4;

    public SlamCrush() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (crippled(m)) {
            applyToEnemy(m, new HexxPower(m, magicNumber));
        } else {
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        crippledGlowCheck();
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeMagicNumber(UPG_MAGIC);
    }
}