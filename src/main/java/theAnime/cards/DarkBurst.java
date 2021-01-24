package theAnime.cards;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.powers.HexxPower;

public class DarkBurst extends AbstractTodoCard {

    public final static String ID = makeID("DarkBurst");

    //stupid intellij stuff SKILL, SELF, UNCOMMON

    private static final int BLOCK = 14;
    private static final int UPG_BLOCK = 2;

    public DarkBurst() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = BLOCK;
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        for (int i = 0; i < magicNumber; i++) {
            if (p.hasPower(HexxPower.POWER_ID)) {
                p.getPower(HexxPower.POWER_ID).atStartOfTurn();
            }
            for (AbstractMonster q : monsterList()) {
                if (q.hasPower(HexxPower.POWER_ID)) {
                    q.getPower(HexxPower.POWER_ID).atStartOfTurn();
                }
            }
        }
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
        upgradeMagicNumber(1);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}