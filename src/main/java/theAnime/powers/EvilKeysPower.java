package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class EvilKeysPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("EvilKeysPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Evil84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Evil32.png");

    public EvilKeysPower(final int amount) {
        name = "Evil Keys";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onUseCard(AbstractCard card, UseCardAction action) {
        if (card.hasTag(AnimeMod.KEY)) {
            flash();
            addToBot(new ApplyPowerAction(action.target, owner, new HexxPower(action.target, amount), amount));
        }
    }

    @Override
    public AbstractPower makeCopy() {
        return new EvilKeysPower(amount);
    }

    @Override
    public void updateDescription() {
        description = "Keys apply #b" + amount + " #yHex.";
    }
}