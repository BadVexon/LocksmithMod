package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class LockCrash extends AbstractTodoCard {

    public final static String ID = makeID("LockCrash");

    //stupid intellij stuff ATTACK, ENEMY, BASIC

    private static final int DAMAGE = 11;

    public LockCrash() {
        super(ID, 2, CardType.ATTACK, CardRarity.BASIC, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        lockme();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        expose(m, 2);
    }

    public void upp() {
        upgradeBaseCost(1);
    }
}