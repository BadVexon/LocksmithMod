package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.actions.HPLossRandomFleshAction;
import theAnime.monsters.AbstractDummy;
import theAnime.util.CasualFlameParticleEffect;
import theAnime.util.TextureLoader;

public class AngryDummyPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("AngryDummyPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Angry84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Angry32.png");

    public AngryDummyPower(final int amount) {
        name = "Dummy Wrath";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    private static final float MAX_OFFSET = 20.0F * Settings.scale;

    public void atEndOfTurn(boolean isPlayer) {
        if (isPlayer) {// 36
            this.flash();// 37
            for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
                if (m != null && !m.isDeadOrEscaped() && m instanceof AbstractDummy) {// 40
                    for (int i = 0; i < amount * 3; i++) {
                        float distance = MathUtils.random(MAX_OFFSET);
                        float direction = MathUtils.random(MathUtils.PI2);
                        float xOffset = MathUtils.cos(direction) * distance;
                        float yOffset = MathUtils.sin(direction) * distance;
                        AbstractDungeon.effectList.add(new CasualFlameParticleEffect(owner.hb.cX + xOffset, owner.hb.cY + yOffset, invertColor(((AbstractDummy) m).myColor)));
                    }
                    addToBot(new HPLossRandomFleshAction(m, amount));
                }
            }
        }
    }// 57

    private static Color invertColor(Color c) {
        Color q = new Color(0, 0, 0, 0);
        q.a = 1.0F - c.a;
        q.g = 1.0F - c.g;
        q.b = 1.0F - c.b;
        q.a = 1.0F;
        return q;
    }

    @Override
    public AbstractPower makeCopy() {
        return new AngryDummyPower(amount);
    }

    @Override
    public void updateDescription() {
        description = "At the end of your turn, each Dummy makes a random enemy lose #b" + amount + " HP.";
    }
}