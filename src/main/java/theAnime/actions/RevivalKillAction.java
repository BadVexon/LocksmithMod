package theAnime.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import com.megacrit.cardcrawl.vfx.combat.HealEffect;

public class RevivalKillAction extends AbstractGameAction {
    private DamageInfo info;

    public static boolean CANNOT_END = false;

    public RevivalKillAction(AbstractCreature target, DamageInfo info) {
        this.info = info;// 20
        this.setValues(target, info);// 21
        this.actionType = ActionType.DAMAGE;// 23
        this.duration = Settings.ACTION_DUR_FASTER;// 24
    }// 25

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FASTER && this.target != null) {// 29 30
            CANNOT_END = true;
            AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, AttackEffect.BLUNT_HEAVY));// 31
            this.target.damage(this.info);// 33
            if ((((AbstractMonster) this.target).isDying || this.target.currentHealth <= 0)) {// 35
                int healAmt = target.maxHealth;
                healUndead(target, healAmt);
                AbstractDungeon.effectsQueue.add(new HealEffect(target.hb.cX, target.hb.cY, healAmt));
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {// 39
                AbstractDungeon.actionManager.clearPostCombatActions();// 40
            }
            CANNOT_END = false;
        }

        this.tickDuration();// 45
    }// 46

    private void healUndead(AbstractCreature m, int healAmount) {
        if (m.isDying) m.isDying = false;
        for (AbstractPower p : m.powers) {
            p.onHeal(healAmount);
        }

        m.currentHealth += healAmount;// 451
        if (m.currentHealth > m.maxHealth) {// 452
            m.currentHealth = m.maxHealth;// 453
        }


        if (healAmount > 0) {// 465
            m.healthBarUpdatedEvent();// 470
        }

    }
}
