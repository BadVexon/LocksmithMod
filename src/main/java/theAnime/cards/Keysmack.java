package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Keysmack extends AbstractTodoCard {

    public final static String ID = makeID("Keysmack");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 6;
    private static final int UPG_DAMAGE = 3;

    public Keysmack() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_HEAVY);
        genKey();
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}