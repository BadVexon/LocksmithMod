package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class SliceSlash extends AbstractTodoCard {

    public final static String ID = makeID("SliceSlash");

    //stupid intellij stuff ATTACK, ALL_ENEMY, UNCOMMON

    private static final int DAMAGE = 6;

    public SliceSlash() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseDamage = DAMAGE;
        baseSecondDamage = secondDamage = 7;
        isMultiDamage = true;
        lockme(2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        allDmg(AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        allDmg(AbstractGameAction.AttackEffect.SLASH_HEAVY);
    }

    public void upp() {
        upgradeDamage(3);
        upgradeSecondDamage(1);
    }
}