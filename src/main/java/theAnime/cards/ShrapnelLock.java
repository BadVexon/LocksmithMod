package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class ShrapnelLock extends AbstractTodoCard {

    public final static String ID = makeID("ShrapnelLock");

    //stupid intellij stuff ATTACK, ALL_ENEMY, COMMON

    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 3;

    public ShrapnelLock() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        baseDamage = DAMAGE;
        lockme();
        isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        allDmg(AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}