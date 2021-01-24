package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.TsundereAction;

public class Tsundere extends AbstractTodoCard {

    public final static String ID = makeID("Tsundere");

    //stupid intellij stuff ATTACK, ENEMY, UNCOMMON

    private static final int DAMAGE = 9;
    private static final int UPG_DAMAGE = 3;

    public Tsundere() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new TsundereAction(m, makeInfo(), 1));
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}