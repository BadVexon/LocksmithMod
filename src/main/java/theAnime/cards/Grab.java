package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.GrabAction;

public class Grab extends AbstractTodoCard {

    public final static String ID = makeID("Grab");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 2;

    public Grab() {
        super(ID, 0, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = 2;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (int i = 0; i < magicNumber; i++)
            atb(new GrabAction(m, makeInfo(), -1));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}