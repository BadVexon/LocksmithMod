package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.SappingKeysPower;

public class SappingKeys extends AbstractTodoCard {

    public final static String ID = makeID("SappingKeys");

    //stupid intellij stuff POWER, SELF, UNCOMMON

    public SappingKeys() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new SappingKeysPower(1));
        if (upgraded) {
            genKey();
        }
    }

    public void upp() {
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}