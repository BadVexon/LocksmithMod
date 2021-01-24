package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class Recharge extends AbstractTodoCard {

    public final static String ID = makeID("Recharge");

    //stupid intellij stuff ATTACK, SELF_AND_ENEMY, UNCOMMON

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 2;

    private static final int BLOCK = 7;
    private static final int UPG_BLOCK = 2;

    public Recharge() {
        super(ID, 2, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        baseBlock = BLOCK;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_HEAVY);
        if (keyCheck()) {
            genKey(2);
        }
    }

    private static boolean keyCheck() {
        boolean bruh = true;
        for (AbstractCard q : AbstractDungeon.player.hand.group) {
            if (q.hasTag(AnimeMod.KEY)) {
                bruh = false;
                break;
            }
        }
        return bruh;
    }

    public void triggerOnGlowCheck() {
        this.glowColor = keyCheck() ? AbstractCard.GOLD_BORDER_GLOW_COLOR : AbstractCard.BLUE_BORDER_GLOW_COLOR;// 65
    }// 68

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
        upgradeBlock(UPG_BLOCK);
    }
}