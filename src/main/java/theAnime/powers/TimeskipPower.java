package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class TimeskipPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("TimeskipPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/DIO84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/DIO32.png");

    public TimeskipPower(AbstractCreature owner) {
        name = "Kono DIO da!";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = -1;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public AbstractPower makeCopy() {
        return new TimeskipPower(owner);
    }

    @Override
    public void onDeath() {
        flash();
        addToBot(new ApplyPowerAction(AbstractDungeon.player, owner, new TimeStopPower(), 1));
    }

    @Override
    public void updateDescription() {
        description = "When " + owner.name + " dies, take an extra turn.";
    }
}