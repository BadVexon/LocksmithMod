package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import theAnime.AnimeMod;
import theAnime.cards.Key;
import theAnime.util.TextureLoader;

public class InfiniteKeysPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("InfiniteKeysPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Infinite84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Infinite32.png");

    public InfiniteKeysPower(final int amount) {
        name = "Infinite Keys";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    public void atStartOfTurn() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {// 25
            this.flash();// 26
            this.addToBot(new MakeTempCardInHandAction(new Key(), this.amount, false));// 27
        }
    }// 29

    @Override
    public AbstractPower makeCopy() {
        return new InfiniteKeysPower(amount);
    }

    @Override
    public void updateDescription() {
        if (amount == 1)
            description = "At the start of your turn, add #b" + amount + " #yKey into your hand.";
        else
            description = "At the start of your turn, add #b" + amount + " #yKeys into your hand.";
    }
}