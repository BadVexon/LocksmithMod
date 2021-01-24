package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class Key extends AbstractTodoCard {

    public final static String ID = makeID("Key");

    //stupid intellij stuff ATTACK, ENEMY, SPECIAL

    private static final int DAMAGE = 3;
    private static final int UPG_DAMAGE = 2;

    public Key() {
        super(ID, 0, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS);
        baseDamage = DAMAGE;
        selfRetain = true;
        exhaust = true;
        tags.add(AnimeMod.KEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}