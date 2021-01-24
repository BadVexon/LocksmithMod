package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class BuriedCurse extends AbstractTodoCard {

    public final static String ID = makeID("BuriedCurse");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 8;

    public BuriedCurse() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        lockme(2);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        weaken(m, magicNumber);
        expose(m, magicNumber);
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}