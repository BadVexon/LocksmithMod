package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.actions.SummonDummyAction;
import theAnime.monsters.CrippleDummy;

public class CripplingDummy extends AbstractTodoCard {

    public final static String ID = makeID("CripplingDummy");

    //stupid intellij stuff SKILL, NONE, UNCOMMON

    public CripplingDummy() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.NONE);
        baseMagicNumber = magicNumber = 12;
        baseSilly = silly = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new SummonDummyAction(SummonDummyAction.DummyTypes.CRIPPLE, magicNumber, silly));
    }

    public void upp() {
        upgradeSilly(1);
    }
}