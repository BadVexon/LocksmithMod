package theAnime.monsters;

import basemod.abstracts.CustomMonster;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.RollMoveAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.FireballEffect;
import theAnime.AnimeMod;
import theAnime.powers.AttackingDummiesPower;
import theAnime.util.CalmFireEffect;
import theAnime.util.CasualFlameParticleEffect;

public abstract class AbstractDummy extends CustomMonster {

    protected float x2;
    protected float y2;
    protected int basehp;

    public AbstractDummy(String id, float x, float y, int hp) {
        super(id.replaceAll(AnimeMod.getModID() + ":", "").replaceAll("([^_])([A-Z])", "$1 $2"), id, hp, 0.0F, 0.0F, 110.0F, 110.0F, null, x, y);
        x2 = x;
        y2 = y;
        basehp = hp;
        damage.add(new DamageInfo(this, -1));
    }

    public void takeTurn() {
        if (AbstractDungeon.player.hasPower(AttackingDummiesPower.POWER_ID)) {
            addToBot(new VFXAction(new FireballEffect(this.hb.cX, this.hb.cY, AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY), 0.5F));// 173
            addToBot(new DamageAction(AbstractDungeon.player, damage.get(0), AbstractGameAction.AttackEffect.FIRE));
        }
        AbstractDungeon.actionManager.addToBottom(new RollMoveAction(this));
    }

    protected void getMove(int num) {
        if (AbstractDungeon.player.hasPower(AttackingDummiesPower.POWER_ID)) {
            damage.get(0).base = AbstractDungeon.player.getPower(AttackingDummiesPower.POWER_ID).amount;
            setMove((byte) 1, Intent.ATTACK, damage.get(0).base);
            applyPowers();
        } else
            this.setMove((byte) 0, Intent.NONE);
    }

    public void applyToSelf(AbstractPower po) {
        atb(new ApplyPowerAction(this, this, po, po.amount));
    }

    public void atb(AbstractGameAction a) {
        AbstractDungeon.actionManager.addToTop(a);
    }

    public abstract AbstractMonster makeCopy();

    private static final float MAX_OFFSET = 20.0F * Settings.scale;
    private static final float SPARK_CHANCE = 0.3f;

    private float fireTimer = 0.0F;
    private static final float FIRE_TIME = 0.025F;

    public Color myColor = Color.WHITE.cpy();

    @Override
    public void flashIntent() {
    }

    @Override
    public void update() {
        super.update();
        if (!this.isDying) {
            this.fireTimer -= Gdx.graphics.getDeltaTime();
            if (this.fireTimer < 0.0F) {
                this.fireTimer = FIRE_TIME;
                AbstractDungeon.effectList.add(new CalmFireEffect(hb.cX, hb.cY, myColor));
                if (MathUtils.randomBoolean(SPARK_CHANCE)) {
                    float distance = MathUtils.random(MAX_OFFSET);
                    float direction = MathUtils.random(MathUtils.PI2);
                    float xOffset = MathUtils.cos(direction) * distance;
                    float yOffset = MathUtils.sin(direction) * distance;
                    AbstractDungeon.effectList.add(new CasualFlameParticleEffect(hb.cX + xOffset, hb.cY + yOffset, myColor));
                }
            }
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        if (!this.isDead && !this.escaped) {
            this.hb.render(sb);
            this.healthHb.render(sb);
        }

        if (!AbstractDungeon.player.isDead) {
            this.renderHealth(sb);
            this.renderName(sb);
        }
    }
}
