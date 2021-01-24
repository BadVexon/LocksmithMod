package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class ShittyKey extends AbstractTodoCard {

    public final static String ID = makeID("ShittyKey");

    //stupid intellij stuff ATTACK, ENEMY, SPECIAL

    public ShittyKey() {
        super(ID, 0, CardType.SKILL, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS);
        isEthereal = true;
        exhaust = true;
        tags.add(AnimeMod.KEY);
        cardsToPreview = new Key();
        baseDamage = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
    }

    public void upp() {
        upgradeDamage(1);
    }
}