package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

public class PocketKey extends AbstractTodoCard {

    public final static String ID = makeID("PocketKey");

    //stupid intellij stuff SKILL, SELF, COMMON

    public PocketKey() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        cardsToPreview = new Key();
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new StrengthPower(p, magicNumber));
        applyToSelf(new LoseStrengthPower(p, magicNumber));
        genKey();
    }

    public void upp() {
        upgradeMagicNumber(2);
    }
}