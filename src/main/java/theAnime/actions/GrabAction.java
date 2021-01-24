package theAnime.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import theAnime.cards.Key;

public class GrabAction extends AbstractGameAction {
    private int energyGainAmt;
    private DamageInfo info;

    public GrabAction(AbstractCreature target, DamageInfo info, int energyAmt) {
        this.info = info;// 20
        this.setValues(target, info);// 21
        this.energyGainAmt = energyAmt;// 22
        this.actionType = ActionType.DAMAGE;// 23
        this.duration = Settings.ACTION_DUR_FASTER;// 24
    }// 25

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FASTER && this.target != null) {// 29 30
            boolean bruh = target.isDying;
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AttackEffect.BLUNT_HEAVY));// 31
            this.target.damage(this.info);// 33
            if ((((AbstractMonster) this.target).isDying || this.target.currentHealth <= 0) && !bruh) {// 35
                addToBot(new MakeTempCardInHandAction(new Key()));
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {// 39
                AbstractDungeon.actionManager.clearPostCombatActions();// 40
            }
        }

        this.tickDuration();// 45
    }// 46
}
