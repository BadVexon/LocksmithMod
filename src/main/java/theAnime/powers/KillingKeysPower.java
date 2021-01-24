package theAnime.powers;

import basemod.interfaces.CloneablePowerInterface;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import theAnime.AnimeMod;
import theAnime.util.TextureLoader;

public class KillingKeysPower extends AbstractPower implements CloneablePowerInterface {
    public static final String POWER_ID = AnimeMod.makeID("KillingKeysPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Pestered_84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Pestered_32.png");

    public KillingKeysPower() {
        name = "Killing Keys";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = -1;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public AbstractPower makeCopy() {
        return new KillingKeysPower();
    }

    @Override
    public void updateDescription() {
        description = "Keys kill Dummies.";
    }
}
