package theAnime.actions;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;
import theAnime.monsters.AbstractDummy;

import java.util.Iterator;

public class DamageAllNonDummyEnemiesAction extends AbstractGameAction {
    public int[] damage;
    private int baseDamage;
    private boolean firstFrame;
    private boolean utilizeBaseDamage;

    public DamageAllNonDummyEnemiesAction(AbstractCreature source, int[] amount, DamageType type, AttackEffect effect, boolean isFast) {
        this.firstFrame = true;// 18
        this.utilizeBaseDamage = false;
        this.source = source;// 26
        this.damage = amount;// 27
        this.actionType = ActionType.DAMAGE;// 28
        this.damageType = type;// 29
        this.attackEffect = effect;// 30
        if (isFast) {// 31
            this.duration = Settings.ACTION_DUR_XFAST;// 32
        } else {
            this.duration = Settings.ACTION_DUR_FAST;// 34
        }

    }// 36

    public DamageAllNonDummyEnemiesAction(AbstractCreature source, int[] amount, DamageType type, AttackEffect effect) {
        this(source, amount, type, effect, false);// 39
    }// 40

    public DamageAllNonDummyEnemiesAction(AbstractPlayer player, int baseDamage, DamageType type, AttackEffect effect) {
        this(player, (int[]) null, type, effect, false);// 43
        this.baseDamage = baseDamage;// 44
        this.utilizeBaseDamage = true;// 45
    }// 46

    public void update() {
        int i;
        if (this.firstFrame) {// 50
            boolean playedMusic = false;// 51
            i = AbstractDungeon.getCurrRoom().monsters.monsters.size();// 52
            if (this.utilizeBaseDamage) {// 53
                this.damage = DamageInfo.createDamageMatrix(this.baseDamage);// 54
            }

            for (int q = 0; q < i; ++q) {// 57
                if (!((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(q)).isDying && ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(q)).currentHealth > 0 && !(AbstractDungeon.getCurrRoom().monsters.monsters.get(q) instanceof AbstractDummy) && !((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(q)).isEscaping) {// 58 59 60
                    if (playedMusic) {// 61
                        AbstractDungeon.effectList.add(new FlashAtkImgEffect(((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(q)).hb.cX, ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(q)).hb.cY, this.attackEffect, true));// 62 64 65
                    } else {
                        playedMusic = true;// 69
                        AbstractDungeon.effectList.add(new FlashAtkImgEffect(((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(q)).hb.cX, ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(q)).hb.cY, this.attackEffect));// 70 72 73
                    }
                }
            }

            this.firstFrame = false;// 78
        }

        this.tickDuration();// 81
        if (this.isDone) {// 83
            Iterator var4 = AbstractDungeon.player.powers.iterator();// 84

            while (var4.hasNext()) {
                AbstractPower p = (AbstractPower) var4.next();
                p.onDamageAllEnemies(this.damage);// 85
            }

            int temp = AbstractDungeon.getCurrRoom().monsters.monsters.size();// 88

            for (i = 0; i < temp; ++i) {// 89
                if (!((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(i)).isDeadOrEscaped() && !((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(i) instanceof AbstractDummy)) {// 90
                    if (this.attackEffect == AttackEffect.POISON) {// 91
                        ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(i)).tint.color.set(Color.CHARTREUSE);// 92
                        ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(i)).tint.changeColor(Color.WHITE.cpy());// 93
                    } else if (this.attackEffect == AttackEffect.FIRE) {// 94
                        ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(i)).tint.color.set(Color.RED);// 95
                        ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(i)).tint.changeColor(Color.WHITE.cpy());// 96
                    }

                    ((AbstractMonster) AbstractDungeon.getCurrRoom().monsters.monsters.get(i)).damage(new DamageInfo(this.source, this.damage[i], this.damageType));// 98
                }
            }

            if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {// 103
                AbstractDungeon.actionManager.clearPostCombatActions();// 104
            }

            if (!Settings.FAST_MODE) {// 106
                this.addToTop(new WaitAction(0.1F));// 107
            }
        }

    }// 110
}
