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

public class AbsorbPower extends AbstractPower implements CloneablePowerInterface, OnMonsterDeathPower {
    public static final String POWER_ID = AnimeMod.makeID("AbsorbPower");
    private static final Texture tex84 = TextureLoader.getTexture("locksmithResources/images/powers/Absorb84.png");
    private static final Texture tex32 = TextureLoader.getTexture("locksmithResources/images/powers/Absorb32.png");

    public AbsorbPower(final int amount) {
        name = "Absorption";
        ID = POWER_ID;

        this.owner = AbstractDungeon.player;
        this.amount = amount;

        type = PowerType.BUFF;

        this.region128 = new TextureAtlas.AtlasRegion(tex84, 0, 0, 87, 82);
        this.region48 = new TextureAtlas.AtlasRegion(tex32, 0, 0, 34, 31);

        updateDescription();
    }

    @Override
    public void onMonsterDeath(AbstractMonster q) {
        flash();
        addToBot(new ApplyPowerAction(owner, owner, new StrengthPower(owner, amount), amount));
    }

    @Override
    public AbstractPower makeCopy() {
        return new AbsorbPower(amount);
    }

    @Override
    public void updateDescription() {
        description = "Whenever an enemy dies, gain #b" + amount + " #yStrength.";
    }
}
