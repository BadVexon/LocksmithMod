package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class DoubleKey extends AbstractTodoCard {

    public final static String ID = makeID("DoubleKey");

    //stupid intellij stuff SKILL, NONE, UNCOMMON

    public DoubleKey() {
        super(ID, -2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        tags.add(AnimeMod.KEY);
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        cantUseMessage = EXTENDED_DESCRIPTION[0];
        return false;
    }

    @Override
    public void triggerOnExhaust() {
        if (upgraded) {
            makeInHand(new DoubleKey());
        } else {
            makeInHand(new Key());
        }
    }

    public void upgrade() {
        if (!upgraded) {
            name = EXTENDED_DESCRIPTION[1];
            upgradeName();
            rawDescription = UPGRADE_DESCRIPTION;
            initializeDescription();
            cardsToPreview = new DoubleKey();
        }
    }

    @Override
    public void upp() {

    }
}