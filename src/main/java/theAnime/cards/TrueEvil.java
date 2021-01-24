package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.KillEnemyAction;

public class TrueEvil extends AbstractTodoCard {

    public final static String ID = makeID("TrueEvil");

    //stupid intellij stuff SKILL, ALL_ENEMY, RARE

    public TrueEvil() {
        super(ID, 3, CardType.SKILL, CardRarity.RARE, CardTarget.ALL_ENEMY);
        lockme(9);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractMonster q : monsterList()) {
            atb(new KillEnemyAction(q));
        }
    }

    public void upp() {
        selfRetain = true;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}