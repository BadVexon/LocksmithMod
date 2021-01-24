package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class ValuePower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("ValuePower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Value84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Value32.png");

    public ValuePower(AbstractCreature owner, int amount) {
        name = "Valuable Bounty";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onDeath() {
        flash();
        addToBot(new DrawCardAction(owner, amount));
        addToBot(new GainEnergyAction(amount));
    }

    @Override
    public AbstractPower makeCopy() {
        return new ValuePower(owner, amount);
    }

    @Override
    public void updateDescription() {
        if (amount == 1)
            description = "When " + owner.name + " dies, draw #b" + amount + " card and gain #b" + amount + " [E] .";
        else
            description = "When " + owner.name + " dies, draw #b" + amount + " cards and gain #b" + amount + " [E] .";
    }
}