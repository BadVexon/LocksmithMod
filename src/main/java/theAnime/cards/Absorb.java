package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;
import theAnime.monsters.EmptyDummy;
import theAnime.powers.AbsorbPower;

public class Absorb extends AbstractTodoCard {

    public final static String ID = makeID("Absorb");

    //stupid intellij stuff POWER, SELF, UNCOMMON

    public Absorb() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.EMPTY, 10));
        applyToSelf(new AbsorbPower(1));
    }

    public void upp() {
        isInnate = true;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}