package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SmackSmackBurn extends AbstractTodoCard {

    public final static String ID = makeID("SmackSmackBurn");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE = 3;

    private static final int DAMAGE2 = 5;
    private static final int UPG_DAMAGE2 = 1;

    public SmackSmackBurn() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseSecondDamage = DAMAGE2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
        atb(new DamageAction(m, new DamageInfo(p, secondDamage, damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
        atb(new ExhaustAction(1, false, false, false));
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}