package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.BolsteringKeysPower;

public class EvilKeys extends AbstractTodoCard {

    public final static String ID = makeID("EvilKeys");

    //stupid intellij stuff POWER, SELF, RARE

    public EvilKeys() {
        super(ID, 2, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new BolsteringKeysPower(1));
    }

    public void upp() {
        upgradeBaseCost(1);
    }
}