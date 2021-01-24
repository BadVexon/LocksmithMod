package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.LectureAction;

public class StormOfShpiel extends AbstractTodoCard {

    public final static String ID = makeID("StormOfShpiel");

    //stupid intellij stuff SKILL, ALL_ENEMY, RARE

    public StormOfShpiel() {
        super(ID, 3, CardType.SKILL, CardRarity.RARE, CardTarget.ALL_ENEMY);
        lockme(2);
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new LectureAction());
    }

    public void upp() {
        upgradeBaseCost(2);
    }
}