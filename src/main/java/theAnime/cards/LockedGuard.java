package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class LockedGuard extends AbstractTodoCard {

    public final static String ID = makeID("LockedGuard");

    //stupid intellij stuff SKILL, SELF, UNCOMMON

    private static final int BLOCK = 12;
    private static final int UPG_BLOCK = 3;

    private static final int MAGIC = 1;
    private static final int UPG_MAGIC = 1;

    public LockedGuard() {
        super(ID, 0, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.SELF_AND_ENEMY);
        baseBlock = BLOCK;
        baseMagicNumber = magicNumber = MAGIC;
        baseDamage = 10;
        lockme(3);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        atb(new DrawCardAction(magicNumber));
    }

    public void upp() {
        upgradeBlock(UPG_BLOCK);
        upgradeDamage(2);
        upgradeMagicNumber(UPG_MAGIC);
        rawDescription = UPGRADE_DESCRIPTION;
        initializeDescription();
    }
}