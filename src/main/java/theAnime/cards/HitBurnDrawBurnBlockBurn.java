package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class HitBurnDrawBurnBlockBurn extends AbstractTodoCard {

    public final static String ID = makeID("HitBurnDrawBurnBlockBurn");

    //stupid intellij stuff ATTACK, SELF_AND_ENEMY, RARE

    private static final int DAMAGE = 8;
    private static final int UPG_DAMAGE = 2;

    private static final int BLOCK = 8;
    private static final int UPG_BLOCK = 2;

    private static final int MAGIC = 2;
    private static final int UPG_MAGIC = 1;

    public HitBurnDrawBurnBlockBurn() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseBlock = BLOCK;
        baseMagicNumber = magicNumber = MAGIC;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        atb(new ExhaustAction(1, false, false, false));
        atb(new DrawCardAction(p, magicNumber));
        atb(new ExhaustAction(1, false, false, false));
        blck();
        atb(new ExhaustAction(1, false, false, false));
    }

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeBlock(UPG_BLOCK);
        upgradeMagicNumber(UPG_MAGIC);
    }
}