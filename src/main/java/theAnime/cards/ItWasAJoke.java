package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.RevivalKillAction;

public class ItWasAJoke extends AbstractTodoCard {

    public final static String ID = makeID("ItWasAJoke");

    //stupid intellij stuff ATTACK, ENEMY, RARE

    private static final int DAMAGE = 12;
    private static final int UPG_DAMAGE = 4;

    public ItWasAJoke() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new RevivalKillAction(m, makeInfo()));
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}