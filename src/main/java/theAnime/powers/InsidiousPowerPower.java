package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class InsidiousPowerPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("InsidiousPowerPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Insidious84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Insidious32.png");

    public InsidiousPowerPower(final int amount) {
        name = "Insidious Power";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void atStartOfTurn() {
        flash();
        addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new HexxPower(AbstractDungeon.player, amount), amount));
        addToBot(new GainEnergyAction(amount));
    }

    @Override
    public AbstractPower makeCopy() {
        return new InsidiousPowerPower(amount);
    }

    @Override
    public void updateDescription() {
        if (amount == 1)
            description = "At the start of your turn, gain #b" + amount + " #yHexx and [E] .";
        else
            description = "At the start of your turn, gain #b" + amount + " #yHexx and #b" + amount + "[E] .";
    }
}