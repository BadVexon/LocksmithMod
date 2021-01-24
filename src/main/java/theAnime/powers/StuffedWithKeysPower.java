package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.cards.Key;
import theAnime.util.TextureLoader;

public class StuffedWithKeysPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("StuffedWithKeysPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Stuffed84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Stuffed32.png");

    public StuffedWithKeysPower(AbstractCreature owner, int amount) {
        name = "Stuffed with Keys";
        ID = POWER_ID;

        this.owner = owner;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public AbstractPower makeCopy() {
        return new StuffedWithKeysPower(owner, amount);
    }

    @Override
    public void onDeath() {
        flash();
        addToBot(new MakeTempCardInHandAction(new Key(), amount));
    }

    @Override
    public void updateDescription() {
        if (amount == 1)
            description = "When " + owner.name + " dies, add #b" + amount + " #yKey into your hand.";
        else
            description = "When " + owner.name + " dies, add #b" + amount + " #yKeys into your hand.";
    }
}