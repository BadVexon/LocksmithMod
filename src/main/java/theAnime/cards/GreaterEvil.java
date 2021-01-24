package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class GreaterEvil extends AbstractTodoCard {

    public final static String ID = makeID("GreaterEvil");

    //stupid intellij stuff ATTACK, ENEMY, RARE

    private static final int DAMAGE = 10;
    private static final int UPG_DAMAGE = 1;

    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 2;

    public GreaterEvil() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = MAGIC;
        lockme();
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        for (int i = 0; i < magicNumber; i++) {
            equalize(m);
        }
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeMagicNumber(UPG_MAGIC);
    }
}