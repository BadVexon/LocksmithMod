package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.SoulSuckerPower;

public class SoulSucker extends AbstractTodoCard {

    public final static String ID = makeID("SoulSucker");

    //stupid intellij stuff POWER, SELF, UNCOMMON

    public SoulSucker() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new SoulSuckerPower(1));
        if (upgraded) {
            for (AbstractMonster q : monsterList()) {
                weaken(q, 1);
                expose(q, 1);
            }
        }
    }

    public void upp() {
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}