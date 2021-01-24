package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class GolfGash extends AbstractTodoCard {

    public final static String ID = makeID("GolfGash");

    //stupid intellij stuff ATTACK, ENEMY, UNCOMMON

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 3;

    public GolfGash() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int x = 0;
        for (AbstractMonster q : monsterList()) {
            x++;
            dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        }
        if (x >= 3) {// 42
            this.addToBot(new SFXAction("ATTACK_BOWLING"));// 43
        }
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}