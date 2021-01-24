package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import theAnime.powers.HexxPower;

public class DeathGaze extends AbstractTodoCard {

    public final static String ID = makeID("DeathGaze");

    //stupid intellij stuff SKILL, SELF, COMMON

    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 2;

    private static final int MAGIC = 4;
    private static final int UPG_MAGIC = 2;

    public DeathGaze() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseBlock = BLOCK;
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        for (AbstractMonster q : monsterList()) {
            if (crippled(q)) {
                applyToEnemy(q, new HexxPower(q, magicNumber));
            }
        }
    }

    @Override
    public void triggerOnGlowCheck() {
        crippledGlowCheck();
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
        upgradeMagicNumber(UPG_MAGIC);
    }
}