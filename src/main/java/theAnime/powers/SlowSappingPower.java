package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.mod.stslib.actions.tempHp.AddTemporaryHPAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.monsters.AbstractDummy;
import theAnime.util.TextureLoader;

public class SlowSappingPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("SlowSappingPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Slow84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Slow32.png");

    public SlowSappingPower(final int amount) {
        name = "Slow Sapping";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }


    public void atStartOfTurnPostDraw() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {// 27
            this.flash();// 28

            for (AbstractMonster m : AbstractDungeon.getMonsters().monsters) {
                if (!m.isDead && !m.isDying && !(m instanceof AbstractDummy)) {// 30
                    this.addToBot(new ApplyPowerAction(m, this.owner, new HexxPower(m, this.amount), this.amount));// 31
                }
            }

            addToBot(new AddTemporaryHPAction(owner, owner, amount));
        }

    }// 34


    @Override
    public AbstractPower makeCopy() {
        return new SlowSappingPower(amount);
    }

    @Override
    public void updateDescription() {
        description = "At the start of your turn, apply #b" + amount + " #yHexx to ALL enemies and gain #b" + amount + " #yTemporary #yHP.";
    }
}