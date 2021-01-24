package theAnime.cards;

import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.ExhaustiveField;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class JingleLoan extends AbstractTodoCard {

    public final static String ID = makeID("JingleLoan");

    //stupid intellij stuff SKILL, SELF, UNCOMMOn

    private static final int MAGIC = 2;

    public JingleLoan() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = MAGIC;
        exhaust = true;
        cardsToPreview = new Key();
        isInnate = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        genKey(magicNumber);
    }

    public void upp() {
        exhaust = false;
        ExhaustiveField.ExhaustiveFields.baseExhaustive.set(this, 2);
        ExhaustiveField.ExhaustiveFields.exhaustive.set(this, 2);
        ExhaustiveField.ExhaustiveFields.isExhaustiveUpgraded.set(this, true);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}