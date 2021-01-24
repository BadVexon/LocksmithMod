package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class FeelNoFeignPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("FeelNoFeignPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Feign84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Feign32.png");

    public FeelNoFeignPower(final int amount) {
        name = "Feel No Feign";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onExhaust(AbstractCard card) {
        flash();
        addToBot(new ApplyPowerAction(owner, owner, new NextTurnBlockPower(owner, amount), amount));
    }

    @Override
    public AbstractPower makeCopy() {
        return new FeelNoFeignPower(amount);
    }

    @Override
    public void updateDescription() {
        description = "Whenever a card is #yExhausted, gain #b" + amount + " #yBlock next turn.";
    }
}
