package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Influx extends AbstractTodoCard {

    public final static String ID = makeID("Influx");

    //stupid intellij stuff SKILL, SELF, UNCOMMON

    private static final int MAGIC = 3;
    private static final int UPG_MAGIC = 1;

    public Influx() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
        cardsToPreview = new ShittyKey();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        makeInHand(new ShittyKey(), magicNumber);
    }

    public void upp() {
        selfRetain = true;
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}