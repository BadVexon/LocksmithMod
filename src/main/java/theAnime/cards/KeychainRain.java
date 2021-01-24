package theAnime.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import theAnime.AnimeMod;

public class KeychainRain extends AbstractTodoCard {

    public final static String ID = makeID("KeychainRain");

    //stupid intellij stuff ATTACK, ALL_ENEMY, COMMON

    private static final int DAMAGE = 7;
    private static final int UPG_DAMAGE = 3;

    public KeychainRain() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        baseDamage = DAMAGE;
        cardsToPreview = new Key();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        int x = 0;
        for (AbstractCard q : AbstractDungeon.player.hand.group) {
            if (q.hasTag(AnimeMod.KEY)) x++;
        }
        if (x >= 3) {
            dmg(m, AbstractGameAction.AttackEffect.LIGHTNING);
        }
    }

    public void triggerOnGlowCheck() {
        int x = 0;
        for (AbstractCard q : AbstractDungeon.player.hand.group) {
            if (q.hasTag(AnimeMod.KEY)) x++;
        }
        this.glowColor = x >= 3 ? AbstractCard.GOLD_BORDER_GLOW_COLOR : AbstractCard.BLUE_BORDER_GLOW_COLOR;// 65
    }// 68

    public void upp() {
        upgradeDamage(UPG_DAMAGE);
    }
}