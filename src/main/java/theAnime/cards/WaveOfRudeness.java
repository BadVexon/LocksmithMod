package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import theAnime.powers.HexxPower;

public class WaveOfRudeness extends AbstractTodoCard {

    public final static String ID = makeID("WaveOfRudeness");

    //stupid intellij stuff SKILL, ALL_ENEMY, UNCOMMON

    private static final int MAGIC = 5;
    private static final int UPG_MAGIC = 2;

    public WaveOfRudeness() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        baseMagicNumber = magicNumber = MAGIC;
        baseSilly = silly = 2;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractMonster q : monsterList()) {
            applyToEnemy(q, new HexxPower(q, magicNumber));
            applyToEnemy(q, new VulnerablePower(q, silly, false));
        }
    }

    public void upp() {
        upgradeMagicNumber(UPG_MAGIC);
        upgradeSilly(1);
    }
}