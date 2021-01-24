package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;
import theAnime.powers.HexxPower;

public class CursedKey extends AbstractTodoCard {

    public final static String ID = makeID("CursedKey");

    //stupid intellij stuff ATTACK, ENEMY, COMMON

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 2;

    public CursedKey() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseMagicNumber = magicNumber = 3;
        cardsToPreview = new Key();
        tags.add(AnimeMod.KEY);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
    }

    @Override
    public void triggerOnExhaust() {
        for (AbstractMonster m : monsterList()) {
            applyToEnemy(m, new HexxPower(m, magicNumber));
        }
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeMagicNumber(2);
    }
}