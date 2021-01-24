package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class AoeMultiAttackPlusAKey extends AbstractTodoCard {

    public final static String ID = makeID("AoeMultiAttackPlusAKey");

    //stupid intellij stuff RARE, ALL_ENEMY, ATTACK

    private static final int DAMAGE = 5;
    private static final int UPG_DAMAGE = 2;

    public AoeMultiAttackPlusAKey() {
        super(ID, 2, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY);
        baseDamage = DAMAGE;
        isMultiDamage = true;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < 3; i++) {
            allDmg(AbstractGameAction.AttackEffect.FIRE);
        }
        genKey();
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}