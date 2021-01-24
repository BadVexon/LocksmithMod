package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.HexxPower;

public class TrashToTreasure extends AbstractTodoCard {

    public final static String ID = makeID("TrashToTreasure");

    //stupid intellij stuff SKILL, SELF, UNCOMMON

    public TrashToTreasure() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseMagicNumber = magicNumber = 5;
        lockme(2);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new HexxPower(m, magicNumber));
        if (crippled(m)) {
            applyToEnemy(m, new HexxPower(m, magicNumber));
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        crippledGlowCheck();
    }

    public void upp() {
        upgradeMagicNumber(2);
    }
}